package com.gamitop.impl;

import java.util.List;

import com.gamitop.model.Achievement;

public interface IAchievement {

	/* Get Entity */
	public Achievement getAchievement(int id_Entity,int id_Achievement);
	/* GetListEntity*/	
	public List<Achievement> getAchievements(int id_Entity);
	/* CreateEntity*/
	public void createAchievement(int id, String name, int entity, String description, String link);
	/* UpdateEntity*/
	public void updateAchievement(int id, String name, int entity, String description, String link);
	/* RemoveEntity */
	public void removeAchievement(int id_Entity,int id_Leaderboard);
	
	
	
	
}
