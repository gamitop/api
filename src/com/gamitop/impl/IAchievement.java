package com.gamitop.impl;

import java.util.List;

import com.gamitop.model.Achievement;

public interface IAchievement {

	/* Get Entity */
	public List<Achievement> getAchievement(int id_Entity,int id_Achievement);
	/* GetListEntity*/	
	public List<Achievement> getAchievements(int id_Entity);
	/* CreateEntity*/
	public void createAchievement( String name, int entity, String description, String link);
	/* UpdateEntity*/
	public boolean updateAchievement( String name, int entity, int id_achievement, String description);
	/* RemoveEntity */
	public boolean removeAchievement(int id_Entity,int id_Leaderboard);
	
	
	
	
}
