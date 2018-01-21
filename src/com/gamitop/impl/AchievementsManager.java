package com.gamitop.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gamitop.data.AchievementsData;
import com.gamitop.model.Achievement;
import com.gamitop.model.Entity;
import com.gamitop.model.Leaderboard;

public class AchievementsManager implements IAchievement {

	static List<Achievement> achievements = new ArrayList<Achievement>();

	static AchievementsManager am = null;

	public static AchievementsManager getInstance() {

		// ArrayList<String> players = new ArrayList<String>();
		if (am == null) {
			am = new AchievementsManager();

			Achievement a1 = new Achievement(0, "Achie0", 0, "Achievemmm0", "0000");
			achievements.add(a1);

		}
		return am;
	}

	@Override
	public List<Achievement> getAchievement(int id_Entity, int id_Achievement) {
		AchievementsData a = AchievementsData.getInstance();

		return a.getDataAchievement(id_Entity, id_Achievement);
	}

	@Override
	public List<Achievement> getAchievements(int id_Entity) {
		AchievementsData a = AchievementsData.getInstance();

		return a.getAchievements(id_Entity);
	}

	@Override
	public void createAchievement(String name, int id_Entity, String description, String link) {
		AchievementsData a = AchievementsData.getInstance();
		int id = a.getIdAchievement()+1;
		Achievement a1 = new Achievement(id, name, id_Entity, description, link);
		a.insertAchievement(a1, id_Entity);	
	}

	@Override
	public boolean updateAchievement(String name, int entity, int id_achievement, String description) {
		AchievementsData a= AchievementsData.getInstance();
		return a.updateAchievement(id_achievement, name, entity, description);
		

	}

	@Override
	public boolean removeAchievement(int id_Entity, int id_Achievement) {	
		AchievementsData a = AchievementsData.getInstance();
		return a.removeAchievement(id_Entity, id_Achievement);		

	}

}
