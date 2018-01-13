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

import com.gamitop.data.EntityData;
import com.gamitop.model.Entity;

public class EntityManager implements IEntity {

	static List<Entity> entities = new ArrayList<Entity>();

	static EntityManager em = null;

	public static EntityManager getInstance() {
		ArrayList<String> leaderboards = new ArrayList<String>();
		ArrayList<String> achievements = new ArrayList<String>();
		
		if (em == null) {
			em = new EntityManager();

			Entity e1 = new Entity(0, "Entidade1", "e1@gmail.com", "entidade1", "123456", "api/entity/0", leaderboards,achievements);
			// Entity e2 = new Entity(1, "Entidade2", "e2@gmail.com", "entidade2", "123456",
			// "api/entity/1", leaderboards);
			// leaderboards.add("leade1");

			entities.add(e1);
			//entities.add(e2);
			// leaderboards.add("leade2");

			// entities.get(0).setLeaderboards(leaderboards);

			// try {
			// JAXBContext jaxbContext = JAXBContext.newInstance(Entity.class);
			// Marshaller m = jaxbContext.createMarshaller();
			// m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// //m.marshal(entities, System.out);
			//
			// } catch (JAXBException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// PlayersManager pm = PlayersManager.getInstance();
			// LeaderboardManager lm = LeaderboardManager.getInstance();
			// AchievementsManager am = AchievementsManager.getInstance();

		}
		return em;
	}

	public List<Entity> getEntities() {
		EntityData e= EntityData.getInstance();
		//e.getData();
		return e.getData();
	}

	@Override
	public List<Entity> getEntity(int id) {

		EntityData e= EntityData.getInstance();
		
		return e.getDataEntity(id);
	}

	@Override
	public void createEntity(String name, String email, String username, String password, String link,
			ArrayList<String> leaderboards2, ArrayList<String> achievements2) {
		// TODO Auto-generated method stub
		ArrayList<String> leaderboards = new ArrayList<String>();
		ArrayList<String> achievements = new ArrayList<String>();
				
		Random rand = new Random();
		int random = rand.nextInt((100 - 1) + 1) + 1;
		Entity entity = new Entity(random, name, email, username, password, "api/entity/3", leaderboards,achievements);
		//entities.add(entity);
		
		//MONGOdB
		EntityData e= EntityData.getInstance();
		e.insertEntity(entity);
		
		
	}

	@Override
	public void updateEntity(int id, String name, String email, String username, String password, String link,
			ArrayList<String> leaderboards2, ArrayList<String> achievements2 ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEntity(int id) {
		
//		for (Iterator<Entity> iterator = entities.iterator(); iterator.hasNext();) {
//			Entity entity = (Entity) iterator.next();
//			if (entity.getId() == (id)) {
//				 iterator.remove();
//			
//			}
//		}
		
		EntityData e= EntityData.getInstance();
		e.removeData(id);

	}

}
