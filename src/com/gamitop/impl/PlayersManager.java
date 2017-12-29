package com.gamitop.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	public void addPlayer(int id, String name, int score, int win, int lose, int totalGames, int entity,
			int id_leaderboard, String link, ArrayList<String> achievements) {

		Player p1 = new Player(id, name, score, win, lose, totalGames, entity, id_leaderboard, link, achievements);

		players.add(p1);

		for (Iterator<Leaderboard> iterator2 = LeaderboardManager.leaderboards.iterator(); iterator2.hasNext();) {
			Leaderboard leaderboard = (Leaderboard) iterator2.next();
			if (leaderboard.getId() == id_leaderboard) {
				leaderboard.getPlayers().add(Integer.toString(id));
			}
		}

	}

	@Override
	public void updatePlayer(int id, String name, int score, int win, int lose, int totalGames, int entity,
			int leaderboard, String link, ArrayList<String> achievements) {
		// TODO Auto-generated method stub

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
		List<Player> listPlayers = new ArrayList<Player>();
		System.out.println(id_Entity);

		for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();) {
			Player player = (Player) iterator.next();
			System.out.println(id_Entity + player.getEntity());
			if (player.getEntity() == id_Entity && player.getLeaderboard() == id_Leaderboard) {
				listPlayers.add(player);
			}
		}
		return listPlayers;
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
	public void addPlayerAchievement(int idEntity, int id_achievement, int id_Player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePlayerAchievement(int idEntity, int id_achievement, int id_Player) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Achievement> getPlayerAchievements(int id_Entity, int id_achievement, int id_Player) {
		// TODO Auto-generated method stub
		return null;
	}

}
