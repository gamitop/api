package com.gamitop.impl;

import java.util.ArrayList;
import java.util.List;

import com.gamitop.model.Entity;

public interface IEntity {
	
	/* Get Entity */
	public List<Entity> getEntity(int id);
	/* GetListEntity*/	
	public List<Entity> getEntities();
	/* CreateEntity*/
	public void createEntity( int id,String name, String email, String username, String password, String link,
			ArrayList<String> leaderboards2, ArrayList<String> achievements2);
	/* UpdateEntity*/
	public void updateEntity(int id, String name, String email, String username, String password, String link,
			ArrayList<String> leaderboards2, ArrayList<String> achievements2);
	/* RemoveEntity */
	public boolean removeEntity(int id);

}
