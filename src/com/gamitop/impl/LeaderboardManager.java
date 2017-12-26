package com.gamitop.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gamitop.model.Entity;
import com.gamitop.model.Leaderboard;

public class LeaderboardManager implements ILeaderboard {

	static List<Leaderboard> leaderboards = new ArrayList<Leaderboard>();

	static LeaderboardManager lm = null;

	public static LeaderboardManager getInstance() {

		// ArrayList<String> players = new ArrayList<String>();
		if (lm == null) {
			lm = new LeaderboardManager();
		}
		return lm;
	}

	@Override
	public Leaderboard getLeaderboard(int idEntity, int idLeaderboard) {

		for (Iterator<Leaderboard> iterator = leaderboards.iterator(); iterator.hasNext();) {
			Leaderboard leaderboard = (Leaderboard) iterator.next();
			System.out.println(idEntity + leaderboard.getEntity());
			if (leaderboard.getEntity() == idEntity && idLeaderboard == leaderboard.getId()) {
				return leaderboard;
			}
		}

		return null;
	}

	@Override
	public List<Leaderboard> getLeaderboards(int idEntity) {
		List<Leaderboard> listLeaderboards = new ArrayList<Leaderboard>();
		System.out.println(idEntity);
		for (Iterator<Leaderboard> iterator = leaderboards.iterator(); iterator.hasNext();) {
			Leaderboard leaderboard = (Leaderboard) iterator.next();
			System.out.println(idEntity + leaderboard.getEntity());
			if (leaderboard.getEntity() == idEntity) {
				listLeaderboards.add(leaderboard);
			}
		}
		return listLeaderboards;
	}

	@Override
	public void createLeaderboard(int id, String name, int idEntity, String description, String link,
			ArrayList<String> players) {

		Leaderboard l1 = new Leaderboard(id, name, idEntity, description, link, players);
		leaderboards.add(l1);
		
		for (Iterator<Entity> iterator2 = EntityManager.entities.iterator(); iterator2.hasNext();) {
			Entity entity = (Entity) iterator2.next();
			if(entity.getId()==idEntity) {
				entity.getLeaderboards().add(Integer.toString(id));
			}			
		}		
	}

	@Override
	public void updateLeaderboard(int id, String name, int entity, String description, String link,
			ArrayList<String> players) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLeaderboard(int idEntity, int idLeaderboard) {
		for (Iterator<Leaderboard> iterator = leaderboards.iterator(); iterator.hasNext();) {
			Leaderboard leaderboard = (Leaderboard) iterator.next();
			System.out.println(idEntity + leaderboard.getEntity());
			if (leaderboard.getEntity() == idEntity && idLeaderboard == leaderboard.getId()) {
				iterator.remove();

			}
		}

		for (Iterator<Entity> iterator2 = EntityManager.entities.iterator(); iterator2.hasNext();) {
			Entity entity = (Entity) iterator2.next();

			if (entity.getId() == idEntity) {
				
				for (Iterator<String> leader = entity.getLeaderboards().iterator(); leader.hasNext();) {
					
					String le = (String) leader.next();
					
					if (Integer.parseInt(le) == idLeaderboard) {
						leader.remove();
					}

				}
			}

		}
	}

}
