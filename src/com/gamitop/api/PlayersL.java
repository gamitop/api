package com.gamitop.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/entity/{id_entity}/leaderboards/{id_leaderboard}/players")
public class PlayersL {

	//
	@GET
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response getEntities(@PathParam("id_entity") String id) {

		String output = "Players of Leaderboard" + id;
		return Response.status(200).entity(output).build();
	}

	@POST
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response addEntity() {

		String output = "AddPlayersToLeaderboard";
		return Response.status(200).entity(output).build();
	}

	// GET a specific entity
	@Path("/{id_player}")
	@GET
	// @Produces(MediaType.APPLICATION_JSON)
	public String getGame(@PathParam("id_entity") String idE, @PathParam("id_leaderboard") String idL,
			@PathParam("id_player") String idP) {

		return "specific entity" + idE + "---" + idL + "---" + idP;

	}

	// PUT a specific entity
	@Path("/{id_player}")
	@PUT
	// @Produces(MediaType.APPLICATION_JSON)
	public String updateEntity(@PathParam("id_entity") String idE, @PathParam("id_leaderboard") String idL,
			@PathParam("id_player") String idP) {

		return "Entity Updated" + idE + "---" + idL + "---" + idP;

	}

	// DELETE a specific entity
	@Path("/{id_player}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public String deleteEntity(@PathParam("id_entity") String idE, @PathParam("id_leaderboard") String idL,
			@PathParam("id_player") String idP) {

		return "Entity with id:" + idE + "---" + idL + "---" + idP + "deleted";

	}

}
