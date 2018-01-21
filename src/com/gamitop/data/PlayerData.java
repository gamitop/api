package com.gamitop.data;

import static com.mongodb.client.model.Filters.*;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.gamitop.model.Achievement;
import com.gamitop.model.Entity;
import com.gamitop.model.Leaderboard;
import com.gamitop.model.Player;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class PlayerData {

	static PlayerData le = null;
	static MongoCollection<Player> colPlayer;
	static MongoCollection<Entity> colEntity;
	static MongoCollection<Leaderboard> colLeaderboard;

	public static PlayerData getInstance() {
		if (le == null) {
			le = new PlayerData();

			CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
					fromProviders(PojoCodecProvider.builder().automatic(true).build()));
			MongoClient mongoClient = new MongoClient("localhost",
					MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
			MongoDatabase dbPlayer = mongoClient.getDatabase("Gamitop");
			colPlayer = dbPlayer.getCollection("Player", Player.class);
			colEntity = dbPlayer.getCollection("Entity", Entity.class);
			colLeaderboard = dbPlayer.getCollection("Leaderboard", Leaderboard.class);
		}
		return le;
	}

	public void insertPlayer(Player player, int id_leaderboard) {
		if (colPlayer.find(eq("name", player.getName())).first() == null) {
			colPlayer.insertOne(player);
			colLeaderboard.updateOne(eq("_id", id_leaderboard),
					Updates.push("players", Integer.toString(player.getId())));

		}
	}

	public List<Player> getPlayers(int idEntity, int idLeaderboard) {
		final List<Player> players = new ArrayList<Player>();

		Block<Player> printBlock = new Block<Player>() {
			public void apply(final Player player) {
				players.add(player);
			}
		};

		colPlayer.find(and(eq("entity", idEntity), eq("leaderboard", idLeaderboard))).forEach(printBlock);

		return players;
	}

	public List<Player> getDataPlayer(int idEntity, int idPlayer, int idLeaderboard) {
		final List<Player> entities = new ArrayList<Player>();

		Block<Player> printBlock = new Block<Player>() {
			public void apply(final Player player) {
				entities.add(player);
			}
		};

		colPlayer.find(and(eq("entity", idEntity), eq("_id", idPlayer), eq("leaderboard", idLeaderboard)))
				.forEach(printBlock);

		return entities;
	}

	public int getIdPlayer() {
		int id;
		final List<Integer> players = new ArrayList<Integer>();
		Block<Player> printBlock = new Block<Player>() {
			public void apply(final Player lead) {
				// System.out.println(lead.getId());
				players.add(lead.getId());
			}
		};
		colPlayer.find().forEach(printBlock);
		;
		// System.out.println(Collections.max(entities));
		if (players.isEmpty()) {
			id = -1;
		} else {
			id = Collections.max(players);
		}

		return id;
	}

	public boolean removePlayer(int id_entity, int id_leaderboard, int id_player) {
		DeleteResult result =colPlayer.deleteOne(and(eq("entity", id_entity), eq("_id", id_player)));
		
		
		if (result.getDeletedCount()>0) {			
			colLeaderboard.updateOne(eq("_id", id_leaderboard),
					Updates.pullByFilter(Filters.eq("players", Integer.toString(id_player))));
			return true;
		}
		else {
			return false;
		}
		

	}

	public void insertPlayerAchievement(int id_entity, int id_achievement, int id_player) {
		if (colPlayer.find(and(eq("entity", id_entity), eq("_id", id_player))) != null  ) {
			if(colPlayer.find(nin("achievements",(Integer.toString(id_achievement)))) != null ) {
				colPlayer.updateOne(eq("_id", id_player),
						 Updates.push("achievements",Integer.toString(id_achievement)));
			}			
		}
	}

	public boolean removePlayerAchievement(int id_entity, int id_achievement, int id_player) {
		UpdateResult result=  colPlayer.updateOne(and(eq("entity", id_entity), eq("_id", id_player)),
				Updates.pullByFilter(Filters.eq("achievements", Integer.toString(id_achievement))));
		
		if (result.getModifiedCount()>0) {
			
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	
	public boolean updatePlayer(int id_player,int id_entity,int id_leaderboard,String name, int score, int win, int lose, int totalGames) {
		UpdateResult result=  colPlayer.updateOne(and(eq("entity", id_entity), eq("_id", id_player),eq("leaderboard", id_leaderboard)),
				Updates.set("name",name));
		colPlayer.updateOne(and(eq("entity", id_entity), eq("_id", id_player),eq("leaderboard", id_leaderboard)),
				Updates.set("win",win));
		colPlayer.updateOne(and(eq("entity", id_entity), eq("_id", id_player),eq("leaderboard", id_leaderboard)),
				Updates.set("score",score));
		colPlayer.updateOne(and(eq("entity", id_entity), eq("_id", id_player),eq("leaderboard", id_leaderboard)),
				Updates.set("lose",lose));
		colPlayer.updateOne(and(eq("entity", id_entity), eq("_id", id_player),eq("leaderboard", id_leaderboard)),
				Updates.set("totalGames",totalGames));
		
		if (result.getModifiedCount()>0) {
			
			return true;
		}
		else {
			return false;
		}
		
	}
		


}
