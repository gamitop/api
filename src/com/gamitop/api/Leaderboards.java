/**
 * 
 */
/**
 * @author Paulo
 *
 */
package com.gamitop.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;






@Path("/entity/{id_entity}/leaderboards")

public class Leaderboards {
	
	

	// GET a list of all leaderboards of a specific entity
	@GET
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response getEntities(@PathParam("id_entity") String id) {

		String output = "ListOfLeaderboards"+id;
		return Response.status(200).entity(output).build();
	}

	@POST
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response addEntity() {

		String output = "AddLeaderboard";
		return Response.status(200).entity(output).build();
	}

	// GET a specific entity
	@Path("/{id_leaderboard}")
	@GET
	// @Produces(MediaType.APPLICATION_JSON)
	public String getGame(@PathParam("id_entity") String idE,@PathParam("id_leaderboard") String idL) {

		return "specific entity" + idE+"---"+ idL;

	}

	// PUT a specific entity
	@Path("/{id_leaderboard}")
	@PUT
	// @Produces(MediaType.APPLICATION_JSON)
	public String updateEntity(@PathParam("id_entity") String idE,@PathParam("id_leaderboard") String idL) {

		return "Entity Updated" + idE+"---"+ idL;

	}

	// DELETE a specific entity
	@Path("/{id_leaderboard}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public String deleteEntity(@PathParam("id_entity") String idE,@PathParam("id_leaderboard") String idL) {

		return "Entity with id:" + idE+"---"+ idL + "deleted";

	}
	
	
	
}