package com.gamitop.impl;

import java.util.ArrayList;
import java.util.List;

import com.gamitop.model.Leaderboard;

public interface ILeaderboard {
	/* Get Entity */
	public List<Leaderboard> getLeaderboard(int idEntity,int idLeaderboard);
	/* GetListEntity*/	
	public List<Leaderboard> getLeaderboards(int idEntity);
	/* CreateEntity*/
	public void createLeaderboard( String name, int entity, String description, String link, ArrayList<String> players);
	/* UpdateEntity*/
	public void updateLeaderboard(int id, String name, int entity, String description, String link, ArrayList<String> players);
	/* RemoveEntity */
	public void removeLeaderboard(int idEntity,int idLeaderboard);

}
