package com.gamitop.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	public Achievement getAchievement(int id_Entity, int id_Achievement) {

		for (Iterator<Achievement> iterator = achievements.iterator(); iterator.hasNext();) {
			Achievement achievement = (Achievement) iterator.next();

			if (achievement.getEntity() == id_Entity && id_Achievement == achievement.getId()) {
				return achievement;
			}
		}

		return null;
	}

	@Override
	public List<Achievement> getAchievements(int id_Entity) {
		List<Achievement> listAchievements = new ArrayList<Achievement>();

		for (Iterator<Achievement> iterator = achievements.iterator(); iterator.hasNext();) {
			Achievement achievement = (Achievement) iterator.next();

			if (achievement.getEntity() == id_Entity) {
				listAchievements.add(achievement);
			}
		}
		return listAchievements;
	}

	@Override
	public void createAchievement(int id, String name, int id_Entity, String description, String link) {

		Achievement a1 = new Achievement(id, name, id_Entity, description, link);
		achievements.add(a1);

		for (Iterator<Entity> iterator2 = EntityManager.entities.iterator(); iterator2.hasNext();) {
			Entity entity = (Entity) iterator2.next();
			if (entity.getId() == id_Entity) {
				entity.getAchievements().add(Integer.toString(id));
			}
		}

	}

	@Override
	public void updateAchievement(int id, String name, int entity, String description, String link) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAchievement(int id_Entity, int id_Achievement) {
		for (Iterator<Achievement> iterator = achievements.iterator(); iterator.hasNext();) {
			Achievement achievement = (Achievement) iterator.next();
			if (achievement.getEntity() == id_Entity && id_Achievement == achievement.getId()) {
				iterator.remove();
			}
		}

		for (Iterator<Entity> iterator2 = EntityManager.entities.iterator(); iterator2.hasNext();) {
			Entity entity = (Entity) iterator2.next();
			if (entity.getId() == id_Entity) {
				for (Iterator<String> leader = entity.getAchievements().iterator(); leader.hasNext();) {
					String le = (String) leader.next();
					if (Integer.parseInt(le) == id_Achievement) {
						leader.remove();
					}
				}
			}
		}

	}

}
