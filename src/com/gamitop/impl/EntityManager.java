/**
 * 
 */
/**
 * @author Paulo
 *
 */
package com.gamitop.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.gamitop.model.Entity;

public class EntityManager implements IEntity {

	static List<Entity> entities = new ArrayList<Entity>();

	static EntityManager em = null;

	public static EntityManager getInstance() {
		if (em == null) {
			em = new EntityManager();

			Entity e1 = new Entity(0, "Entidade1", "e1@gmail.com", "entidade1", "123456", "api/entity/0", null);
			Entity e2 = new Entity(1, "Entidade2", "e2@gmail.com", "entidade2", "123456", "api/entity/1", null);
			// leaderboards.add("leade1");

			entities.add(e1);
			entities.add(e2);
			// leaderboards.add("leade2");

			// entities.get(0).setLeaderboards(leaderboards);

		}
		return em;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	@Override
	public Entity getEntity(int id) {
		for (Iterator<Entity> iterator = entities.iterator(); iterator.hasNext();) {
			Entity entity = (Entity) iterator.next();
			if (entity.getId() == (id))
				return entity;

		}
		return null;
	}

	@Override
	public void createEntity(String name, String email, String username, String password, String link,
			ArrayList<String> leaderboards2) {
		// TODO Auto-generated method stub

		Random rand = new Random();
		int random = rand.nextInt((100 - 1) + 1) + 1;
		Entity e = new Entity(random, name, email, username, password, "api/entity/3", null);
		entities.add(e);
	}

	@Override
	public void updateEntity(int id, String name, String email, String username, String password, String link,
			ArrayList<String> leaderboards2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEntity(int id) {
		ArrayList<String> leaderboards = new ArrayList<String>();
		for (Iterator<Entity> iterator = entities.iterator(); iterator.hasNext();) {
			Entity entity = (Entity) iterator.next();
			if (entity.getId() == (id)) {
				// iterator.remove();

				entity.setLeaderboards(leaderboards);
				leaderboards = entity.getLeaderboards();
				leaderboards.add("xixas");
			}
		}

	}

}
