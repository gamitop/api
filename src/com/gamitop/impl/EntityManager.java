/**
 * 
 */
/**
 * @author Paulo
 *
 */
package com.gamitop.impl;

import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.gamitop.data.EntityData;
import com.gamitop.model.Entity;

import io.jsonwebtoken.impl.crypto.MacProvider;

public class EntityManager implements IEntity {

	static List<Entity> entities = new ArrayList<Entity>();
	static Key key;

	static EntityManager em = null;

	public static EntityManager getInstance() {
	
		
		if (em == null) {
			em = new EntityManager();
			key = MacProvider.generateKey();
			


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


		}
		return em;
	}
	public Key getKey() {
		return key;
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

	@Override	public void removeEntity(int id) {		
		EntityData e= EntityData.getInstance();
		e.removeData(id);
	}

}
