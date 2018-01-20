package com.gamitop.data;

import static com.mongodb.client.model.Filters.*;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.gamitop.model.Entity;
import com.gamitop.model.Leaderboard;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.DeleteResult;

public class LeaderboardData {

	static LeaderboardData le = null;
	static MongoCollection<Leaderboard> colLeaderboard;
	static MongoCollection<Entity> colEntity;

	public static LeaderboardData getInstance() {
		if (le == null) {
			le = new LeaderboardData();

			CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
					fromProviders(PojoCodecProvider.builder().automatic(true).build()));
			MongoClient mongoClient = new MongoClient("localhost",
					MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
			MongoDatabase dbLeaderboard = mongoClient.getDatabase("Gamitop");
			colLeaderboard = dbLeaderboard.getCollection("Leaderboard", Leaderboard.class);
			colEntity = dbLeaderboard.getCollection("Entity", Entity.class);
		}
		return le;
	}

	public void insertLeaderboard(Leaderboard leaderboard, int id_entity) {
		if (colLeaderboard.find(eq("name", leaderboard.getName())).first() == null) {
			colLeaderboard.insertOne(leaderboard);
			colEntity.updateOne(eq("_id", id_entity), Updates.push("leaderboards",Integer.toString(leaderboard.getId())));

		}
	}

	public List<Leaderboard> getLeaderboards(int idEntity) {
		final List<Leaderboard> leaderboards = new ArrayList<Leaderboard>();

		Block<Leaderboard> printBlock = new Block<Leaderboard>() {
			public void apply(final Leaderboard leaderboard) {
				leaderboards.add(leaderboard);
			}
		};

		colLeaderboard.find(eq("entity", idEntity)).forEach(printBlock);
		return leaderboards;
	}

	public List<Leaderboard> getDataLeaderboard(int idEntity, int idLeaderboard) {
		final List<Leaderboard> leaderboards = new ArrayList<Leaderboard>();

		Block<Leaderboard> printBlock = new Block<Leaderboard>() {
			public void apply(final Leaderboard leaderboard) {
				leaderboards.add(leaderboard);
			}
		};

		colLeaderboard.find(and(eq("entity", idEntity), eq("_id", idLeaderboard))).forEach(printBlock);

		return leaderboards;
	}



	public int getIdLeaderboard() {
		
		final List<Integer> entities = new ArrayList<Integer>();
		Block<Leaderboard> printBlock = new Block<Leaderboard>() {
			public void apply(final Leaderboard lead) {
				//System.out.println(lead.getId());
				entities.add(lead.getId());
			}
		};
		colLeaderboard.find().forEach(printBlock);;
		//System.out.println(Collections.max(entities));
		
		return Collections.max(entities);
	}

	public boolean removeLeaderboar(int id_entity, int id_leaderboard) {
		DeleteResult result = colLeaderboard.deleteOne(and(eq("entity", id_entity), eq("_id", id_leaderboard)));
		//colLeaderboard.deleteOne(and(eq("entity", id_entity), eq("_id", id_leaderboard)));
		
		if (result.getDeletedCount()>0) {			
			colEntity.updateOne(eq("_id", id_entity), Updates.pullByFilter(Filters.eq("leaderboards", id_leaderboard)));
			return true;
		}
		else {
			return false;
		}
		

	}

}
