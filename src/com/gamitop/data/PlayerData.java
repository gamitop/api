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
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

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

	public void removePlayer(int id_entity, int id_leaderboard, int id_player) {
		colPlayer.deleteOne(and(eq("entity", id_entity), eq("_id", id_player)));
		colLeaderboard.updateOne(eq("_id", id_leaderboard),
				Updates.pullByFilter(Filters.eq("players", Integer.toString(id_player))));

	}

	public void insertPlayerAchievement(int id_entity, int id_achievement, int id_player) {
		if (colPlayer.find(and(eq("entity", id_entity), eq("_id", id_player))) != null  ) {
			if(colPlayer.find(nin("achievements",(Integer.toString(id_achievement)))) != null ) {
				colPlayer.updateOne(eq("_id", id_player),
						 Updates.push("achievements",Integer.toString(id_achievement)));
			}			
		}
	}

	public void removePlayerAchievement(int id_entity, int id_achievement, int id_player) {
		colPlayer.updateOne(and(eq("entity", id_entity), eq("_id", id_player)),
				Updates.pullByFilter(Filters.eq("achievements", Integer.toString(id_achievement))));	
	}

//	public List<Achievement> getPlayerAchievement(int idEntity, int idPlayer) {
//		final List<Achievement> achievementsPlayer = new ArrayList<Achievement>();
//
//		Block<Achievement> printBlock = new Block<Achievement>() {
//			public void apply(final Achievement achievement) {
//				achievementsPlayer.add(achievement);
//			}
//		};
//
//		colPlayer.find(and(eq("entity", idEntity), eq("leaderboard", idPlayer))).forEach(printBlock);
//
//		return achievementsPlayer;
//	}

}
