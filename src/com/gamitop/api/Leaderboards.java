/**
 * 
 */
/**
 * @author Paulo
 *
 */
package com.gamitop.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.gamitop.data.PlayerData;
import com.gamitop.impl.LeaderboardManager;
import com.gamitop.impl.PlayersManager;
import com.gamitop.model.Leaderboard;
import com.gamitop.model.Player;

@Path("/entity/{id_entity}/leaderboards")

public class Leaderboards {

	// GET a list of all leaderboards of a specific entity
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Leaderboard> getLeaderboads(@PathParam("id_entity") int id) {

		LeaderboardManager lm = LeaderboardManager.getInstance();

		// String output = "ListOfEntities";
		return lm.getLeaderboards(id);
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	public Response addLeaderboard(@PathParam("id_entity") int entity, @FormParam("name") String name,
			@FormParam("description") String description, @Context UriInfo uriInfo) {

		LeaderboardManager lm = LeaderboardManager.getInstance();
		ArrayList<String> players = new ArrayList<String>();

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(0));

		lm.createLeaderboard(name, entity, description, builder.toString(), players);
		return Response.created(builder.build()).entity("Link:  " + builder).build();
	}

	// GET a specific entity
	@Path("/{id_leaderboard}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Leaderboard> getLeaderboard(@PathParam("id_entity") int idEntity,
			@PathParam("id_leaderboard") int idLeaderboard) {

		LeaderboardManager lm = LeaderboardManager.getInstance();

		// String output = "ListOfEntities";
		return lm.getLeaderboard(idEntity, idLeaderboard);

	}

	// PUT a specific entity
	@Path("/{id_leaderboard}")
	@PUT
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String updateLeaderboard(@PathParam("id_entity") int idEntity,
			@PathParam("id_leaderboard") int idLeaderboard) {

		return "Entity Updated" + idEntity + "---" + idLeaderboard;

	}

	// DELETE a specific entity
	@Path("/{id_leaderboard}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public Response deleteLeaderboard(@PathParam("id_entity") int idEntity,
			@PathParam("id_leaderboard") int idLeaderboard) {

		LeaderboardManager lm = LeaderboardManager.getInstance();//
		lm.removeLeaderboard(idEntity, idLeaderboard);

		return Response.ok().entity("Leaderboard removed!").build();

	}

	// get players of leaderboard
	@Path("/{id_leaderboard}/players")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Player> getPlayers(@PathParam("id_entity") int id_Entity,
			@PathParam("id_leaderboard") int id_Leaderboard) {

		PlayersManager lm = PlayersManager.getInstance();

		// String output = "ListOfEntities";
		return lm.getPlayersLeaderboard(id_Entity, id_Leaderboard);
	}

	// add players to leaderboard
	@Path("/{id_leaderboard}/players")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public Response addPlayers(@PathParam("id_entity") int entity, @PathParam("id_leaderboard") int id_leaderboard,
			@FormParam("name") String name, @FormParam("score") int score, @FormParam("win") int win,
			@FormParam("lose") int lose, @FormParam("totalGames") int totalGames, @Context UriInfo uriInfo) {

		PlayersManager pm = PlayersManager.getInstance();
		ArrayList<String> achievements = new ArrayList<String>();

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		// builder.path(Integer.toString(id));

		pm.addPlayer(name, score, win, lose, totalGames, entity, id_leaderboard, builder.toString(), achievements);
		return Response.created(builder.build()).entity("Link:  " + builder).build();

	}

	// GET a specific entity
	@Path("/{id_leaderboard}/players/{id_player}")
	@GET
	// @Produces(MediaType.APPLICATION_JSON)
	public List<Player> getGame(@PathParam("id_entity") int id_Entity, @PathParam("id_leaderboard") int id_Leaderboard,
			@PathParam("id_player") int id_Player) {

		PlayerData p = PlayerData.getInstance();

		return p.getDataPlayer(id_Entity, id_Player, id_Leaderboard);

	}

	// PUT a specific entity
	@Path("/{id_leaderboard}/players/{id_player}")
	@PUT
	// @Produces(MediaType.APPLICATION_JSON)
	public String updateEntity(@PathParam("id_entity") String idE, @PathParam("id_leaderboard") String idL,
			@PathParam("id_player") String idP) {

		return "Entity Updated" + idE + "---" + idL + "---" + idP;

	}

	// DELETE a specific entity
	@Path("/{id_leaderboard}/players/{id_player}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public Response deletePlayer(@PathParam("id_entity") int id_Entity, @PathParam("id_leaderboard") int id_Leaderboard,
			@PathParam("id_player") int id_Player) {

		PlayerData p = PlayerData.getInstance();
		p.removePlayer(id_Entity, id_Leaderboard, id_Player);
		return Response.ok().entity("Player removed!").build();

	}

}