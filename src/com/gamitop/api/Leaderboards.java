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

import com.gamitop.impl.LeaderboardManager;
import com.gamitop.model.Leaderboard;

@Path("/entity/{id_entity}/leaderboards")

public class Leaderboards {

	// GET a list of all leaderboards of a specific entity
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
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
		Random rand = new Random();
		int id = rand.nextInt((100 - 1) + 1) + 1;

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(id));

		lm.createLeaderboard(id, name, entity, description, builder.toString(), players);
		return Response.created(builder.build()).entity("Link:  " + builder).build();
	}

	// GET a specific entity
	@Path("/{id_leaderboard}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Leaderboard getLeaderboard(@PathParam("id_entity") int idEntity, @PathParam("id_leaderboard") int idLeaderboard) {

		LeaderboardManager lm = LeaderboardManager.getInstance();

		// String output = "ListOfEntities";
		return lm.getLeaderboard(idEntity, idLeaderboard);

	}

	// PUT a specific entity
	@Path("/{id_leaderboard}")
	@PUT
	// @Produces(MediaType.APPLICATION_JSON)
	public String updateLeaderboard(@PathParam("id_entity") int idEntity, @PathParam("id_leaderboard") int idLeaderboard) {

		return "Entity Updated" + idEntity + "---" + idLeaderboard;

	}

	// DELETE a specific entity
	@Path("/{id_leaderboard}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public Response deleteLeaderboard(@PathParam("id_entity") int idEntity, @PathParam("id_leaderboard") int idLeaderboard) {

		LeaderboardManager lm = LeaderboardManager.getInstance();
		
		lm.removeLeaderboard(idEntity,idLeaderboard);

		return Response.ok().entity("Leaderboard removed!").build();

	}

}