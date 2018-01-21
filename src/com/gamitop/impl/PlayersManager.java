package com.gamitop.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gamitop.data.AchievementsData;
import com.gamitop.data.LeaderboardData;
import com.gamitop.data.PlayerData;
import com.gamitop.model.Achievement;
import com.gamitop.model.Entity;
import com.gamitop.model.Leaderboard;
import com.gamitop.model.Player;

public class PlayersManager implements IPlayer {

	static List<Player> players = new ArrayList<Player>();

	static PlayersManager pm = null;

	public static PlayersManager getInstance() {
		ArrayList<String> achievements = new ArrayList<String>();
		// ArrayList<String> players = new ArrayList<String>();
		if (pm == null) {
			pm = new PlayersManager();

			Player p1 = new Player(1, "name", 11, 11, 11, 11, 0, 0, "aa", achievements);

			players.add(p1);
		}
		return pm;
	}
 
	@Override
	public void addPlayer(String name, int score, int win, int lose, int totalGames, int entity, int id_leaderboard,
			String link, ArrayList<String> achievements) {

		int id = PlayerData.getInstance().getIdPlayer() + 1;
		Player p1 = new Player(id, name, score, win, lose, totalGames, entity, id_leaderboard, link, achievements);

		// players.add(p1);
		//
		// for (Iterator<Leaderboard> iterator2 =
		// LeaderboardManager.leaderboards.iterator(); iterator2.hasNext();) {
		// Leaderboard leaderboard = (Leaderboard) iterator2.next();
		// if (leaderboard.getId() == id_leaderboard) {
		// leaderboard.getPlayers().add(Integer.toString(id));
		// }
		// }

		PlayerData p = PlayerData.getInstance();
		p.insertPlayer(p1, id_leaderboard);

	}

	@Override
	public boolean updatePlayer(int id_player,int id_entity,int id_leaderboard,String name, int score, int win, int lose, int totalGames) {
		PlayerData p= PlayerData.getInstance();

		return p.updatePlayer(id_player, id_entity, id_leaderboard, name, score, win, lose, totalGames);
	}

	@Override
	public Player getPlayer(int id_Entity, int id_Leaderboard, int id_Player) {

		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			Player player = (Player) iterator.next();
			if (player.getEntity() == id_Entity && id_Leaderboard == player.getLeaderboard()
					&& id_Player == player.getId()) {
				return player;
			}
		}
		return null;

	}

	@Override
	public List<Player> getPlayersLeaderboard(int id_Entity, int id_Leaderboard) {
		PlayerData p = PlayerData.getInstance();
		// e.getData();
		return p.getPlayers(id_Entity, id_Leaderboard);
	}

	@Override
	public void removePlayer(int id_Entity, int id_Leaderboard, int id_Player) {

		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			Player player = (Player) iterator.next();
			if (player.getEntity() == id_Entity && id_Leaderboard == player.getLeaderboard()
					&& id_Player == player.getId()) {
				iterator.remove();
			}
		}

		for (Iterator<Leaderboard> iterator2 = LeaderboardManager.leaderboards.iterator(); iterator2.hasNext();) {
			Leaderboard leaderboard = (Leaderboard) iterator2.next();

			if (leaderboard.getEntity() == id_Entity && id_Leaderboard == leaderboard.getId()) {

				for (Iterator<String> player = leaderboard.getPlayers().iterator(); player.hasNext();) {

					String le = (String) player.next();

					if (Integer.parseInt(le) == id_Player) {
						player.remove();
					}

				}
			}

		}

	}

	@Override
	public void addPlayerAchievement(int id_entity, int id_achievement, int id_player) {

	PlayerData p = PlayerData.getInstance();
	p.insertPlayerAchievement(id_entity, id_achievement, id_player);

	}

	@Override
	public boolean removePlayerAchievement(int id_entity, int id_achievement, int id_player) {
		PlayerData p = PlayerData.getInstance();
		return p.removePlayerAchievement(id_entity, id_achievement, id_player);
	}

	@Override
	public List<Achievement> getPlayerAchievements(int id_Entity, int id_Player) {
		// TODO Auto-generated method stub

		List<Achievement> listAchievements = new ArrayList<Achievement>();

		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			Player player = (Player) iterator.next();

			if (player.getEntity() == id_Entity && player.getId() == id_Player) {
				for (Iterator<String> iterator2 = player.getAchievements().iterator(); iterator2.hasNext();) {
					String id_Achievement = (String) iterator2.next();

					for (Iterator<Achievement> iterator3 = AchievementsManager.achievements.iterator(); iterator3
							.hasNext();) {
						Achievement achievement = (Achievement) iterator3.next();

						if (achievement.getId() == Integer.parseInt(id_Achievement)) {
							listAchievements.add(achievement);
						}

					}

				}
			} else {
				return null;
			}

		}
		return listAchievements;

	}

}
