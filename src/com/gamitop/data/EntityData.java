/**
 * 
 */
/**
 * @author Paulo
 *
 */
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
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class EntityData {

	static EntityData ge = null;
	static MongoCollection<Entity> colEntity;

	public static EntityData getInstance() {
		if (ge == null) {
			ge = new EntityData();

			CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
					fromProviders(PojoCodecProvider.builder().automatic(true).build()));
			MongoClient mongoClient = new MongoClient("localhost",
					MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
			MongoDatabase dbEntity = mongoClient.getDatabase("Gamitop");
			colEntity = dbEntity.getCollection("Entity", Entity.class);
		}
		return ge;
	}

	public void insertEntity(Entity entity) {
		if (colEntity.find(eq("name", entity.getName())).first() == null) {
			colEntity.insertOne(entity);
		}
	}

	public List<Entity> getData() {
		final List<Entity> entities = new ArrayList<Entity>();

		Block<Entity> printBlock = new Block<Entity>() {
			public void apply(final Entity entity) {
				entities.add(entity);
			}
		};

		colEntity.find().forEach(printBlock);
		return entities;
	}

	public List<Entity> getDataEntity(int id) {
		final List<Entity> entities = new ArrayList<Entity>();

		Block<Entity> printBlock = new Block<Entity>() {
			public void apply(final Entity entity) {
				entities.add(entity);
			}
		};
		colEntity.find(eq("_id", id)).forEach(printBlock);

		return entities;
	}

	public boolean removeData(int id) {
		
		DeleteResult result = colEntity.deleteOne(eq("_id", id)) ;
		
		if (result.getDeletedCount()>0) {
			return true;
		}
		else {
			return false;
		}

	}

	public int getIEntity() {

		int id;
		final List<Integer> entities = new ArrayList<Integer>();
		Block<Entity> printBlock = new Block<Entity>() {
			public void apply(final Entity ent) {
				// System.out.println(lead.getId());
				entities.add(ent.getId());
			}
		};
		colEntity.find().forEach(printBlock);
		
		// System.out.println(Collections.max(entities));
		if (entities.isEmpty()) {
			id = -1;
		} else {
			id = Collections.max(entities);
		}

		return id;
	}
	
	public int getAuthId(String email, String password) {

		int id;
		final List<Integer> entities = new ArrayList<Integer>();
		Block<Entity> printBlock = new Block<Entity>() {
			public void apply(final Entity ent) {
				// System.out.println(lead.getId());
				entities.add(ent.getId());
			}
		};
		colEntity.find(and(eq("email",email), eq("password",password))).forEach(printBlock);
		
		// System.out.println(Collections.max(entities));
		if (entities.isEmpty()) {
			id = -1;
		} else {
			id = Collections.max(entities);
		}

		return id;
	}

	public boolean auth(String email, String password) {

		if (colEntity.find(and(eq("email", email), eq("password", password))).first() == null) {	
			return false;
		}
		else {
			return true;
		}
		
	}
	public boolean updateLeaderboard(int id, String name, String email, String username, String password) {
		//	DeleteResult result = colLeaderboard.deleteOne(and(eq("entity", id_entity), eq("_id", id_leaderboard)));
			UpdateResult result = colEntity.updateOne(eq("_id", id), Updates.set("name",name));
			UpdateResult result2 = colEntity.updateOne(eq("_id", id), Updates.set("email",email));
			UpdateResult result4 = colEntity.updateOne(eq("_id", id), Updates.set("username",username));
			UpdateResult result3 =colEntity.updateOne(eq("_id", id), Updates.set("password",password));
			
			

			if (result.getModifiedCount()>0|| result2.getModifiedCount()>0 || result3.getModifiedCount()>0|| result4.getModifiedCount()>0) {			
				//colEntity.updateOne(eq("_id", id_entity), Updates.pullByFilter(Filters.eq("leaderboards", id_leaderboard)));
				return true;
			}
			else {
				return false;
			}
//			

		}

}