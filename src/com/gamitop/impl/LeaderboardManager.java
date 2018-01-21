package com.gamitop.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gamitop.data.EntityData;
import com.gamitop.data.LeaderboardData;
import com.gamitop.model.Entity;
import com.gamitop.model.Leaderboard;

public class LeaderboardManager implements ILeaderboard {

	static List<Leaderboard> leaderboards = new ArrayList<Leaderboard>();

	static LeaderboardManager lm = null;

	public static LeaderboardManager getInstance() {
		ArrayList<String> players = new ArrayList<String>();
		// ArrayList<String> players = new ArrayList<String>();
		if (lm == null) {
			lm = new LeaderboardManager();

			Leaderboard l1 = new Leaderboard(0, "hh", 0, "ada", "afafa", players);
			leaderboards.add(l1);

		}
		return lm;
	}

	@Override
	public List<Leaderboard> getLeaderboard(int idEntity, int idLeaderboard) {

		LeaderboardData l = LeaderboardData.getInstance();
		// e.getData();
		return l.getDataLeaderboard(idEntity, idLeaderboard);
	}

	@Override
	public List<Leaderboard> getLeaderboards(int idEntity) {
		LeaderboardData l = LeaderboardData.getInstance();
		// e.getData();
		return l.getLeaderboards(idEntity);
	}

	@Override
	public void createLeaderboard(int id, String name, int idEntity, String description, String link,
			ArrayList<String> players) {

		Leaderboard l1 = new Leaderboard(id, name, idEntity, description, link, players);

		LeaderboardData l = LeaderboardData.getInstance();
		l.insertLeaderboard(l1, idEntity);

	}

	@Override
	public boolean updateLeaderboard(int id, String name, int entity, String description) {
		LeaderboardData l = LeaderboardData.getInstance();
		return l.updateLeaderboard(id, name, entity, description);

	}

	@Override
	public boolean removeLeaderboard(int idEntity, int idLeaderboard) {
		//
		LeaderboardData l = LeaderboardData.getInstance();

		return l.removeLeaderboar(idEntity, idLeaderboard);

	}

}
