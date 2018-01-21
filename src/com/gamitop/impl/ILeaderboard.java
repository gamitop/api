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
	public void createLeaderboard( int id,String name, int entity, String description, String link, ArrayList<String> players);
	/* UpdateEntity*/
	public boolean updateLeaderboard(int id, String name, int entity, String description);
	/* RemoveEntity */
	public boolean removeLeaderboard(int idEntity,int idLeaderboard);

}
