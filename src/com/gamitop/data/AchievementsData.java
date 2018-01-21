package com.gamitop.data;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.gamitop.model.Entity;
import com.gamitop.model.Player;
import com.gamitop.model.Achievement;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class AchievementsData {

	static AchievementsData le = null;
	static MongoCollection<Achievement> colAchievement;
	static MongoCollection<Entity> colEntity;

	public static AchievementsData getInstance() {
		if (le == null) {
			le = new AchievementsData();

			CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
					fromProviders(PojoCodecProvider.builder().automatic(true).build()));
			MongoClient mongoClient = new MongoClient("localhost",
					MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
			MongoDatabase dbAchievement = mongoClient.getDatabase("Gamitop");
			colAchievement = dbAchievement.getCollection("Achievement", Achievement.class);
			colEntity = dbAchievement.getCollection("Entity", Entity.class);
		}
		return le;
	}

	public void insertAchievement(Achievement achievement, int id_entity) {
		if (colAchievement.find(eq("name", achievement.getName())).first() == null) {
			colAchievement.insertOne(achievement);
			colEntity.updateOne(eq("_id", id_entity),
					Updates.push("achievements", Integer.toString(achievement.getId())));

		}
	}

	public List<Achievement> getAchievements(int idEntity) {
		final List<Achievement> achievements = new ArrayList<Achievement>();

		Block<Achievement> printBlock = new Block<Achievement>() {
			public void apply(final Achievement achievement) {
				achievements.add(achievement);
			}
		};

		colAchievement.find(eq("entity", idEntity)).forEach(printBlock);
		return achievements;
	}

	public List<Achievement> getDataAchievement(int idEntity, int idAchievement) {
		final List<Achievement> achievements = new ArrayList<Achievement>();

		Block<Achievement> printBlock = new Block<Achievement>() {
			public void apply(final Achievement achievement) {
				achievements.add(achievement);
			}
		};

		colAchievement.find(and(eq("entity", idEntity), eq("_id", idAchievement))).forEach(printBlock);

		return achievements;
	}

	public int getIdAchievement() {

		int id;
		final List<Integer> achievements = new ArrayList<Integer>();
		Block<Achievement> printBlock = new Block<Achievement>() {
			public void apply(final Achievement ach) {
				// System.out.println(lead.getId());
				achievements.add(ach.getId());
			}
		};
		colAchievement.find().forEach(printBlock);

		// System.out.println(Collections.max(entities));
		if (achievements.isEmpty()) {
			id = -1;
		} else {
			id = Collections.max(achievements);
		}

		return id;
	}

	public boolean removeAchievement(int id_entity, int id_Achievement) {
		DeleteResult result = colAchievement.deleteOne(and(eq("entity", id_entity), eq("_id", id_Achievement)));
		colEntity.updateOne(eq("_id", id_entity),
				Updates.pullByFilter(Filters.eq("achievements", Integer.toString(id_Achievement))));

		if (result.getDeletedCount() > 0) {
			colEntity.updateOne(eq("_id", id_entity),
					Updates.pullByFilter(Filters.eq("achievements", Integer.toString(id_Achievement))));
			return true;
		} else {
			return false;
		}

	}
	
	public boolean updateAchievement(int id, String name, int entity, String description) {
	//	DeleteResult result = colLeaderboard.deleteOne(and(eq("entity", id_entity), eq("_id", id_leaderboard)));
		System.out.println(name);
		UpdateResult result = colAchievement.updateOne(eq("_id", id), Updates.set("name",name));
		UpdateResult result2 = colAchievement.updateOne(eq("_id", id), Updates.set("description",description));

		if (result.getModifiedCount()>0) {			
			//colEntity.updateOne(eq("_id", id_entity), Updates.pullByFilter(Filters.eq("leaderboards", id_leaderboard)));
			return true;
		}
		else {
			return false;
		}
//		

	}

}
