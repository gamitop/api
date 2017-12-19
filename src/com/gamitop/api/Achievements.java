package com.gamitop.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/entity/{id_entity}/achievements")
public class Achievements {

	//
	@GET
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response getEntities(@PathParam("id_entity") String id) {

		String output = "Achievements of Entity" + id;
		return Response.status(200).entity(output).build();
	}

	@POST
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response addEntity() {

		String output = "AddAchievement";
		return Response.status(200).entity(output).build();
	}

	// GET a specific entity
	@Path("/{name}")
	@GET
	// @Produces(MediaType.APPLICATION_JSON)
	public String getGame(@PathParam("id_entity") String idE, @PathParam("name") String idL) {

		return "specific Achievements" + idE + "---" + idL ;

	}

	// PUT a specific entity
	@Path("/{name}")
	@PUT
	// @Produces(MediaType.APPLICATION_JSON)
	public String updateEntity(@PathParam("id_entity") String idE, @PathParam("name") String idL) {

		return "Achievements Updated" + idE + "---" + idL ;

	}

	// DELETE a specific entity
	@Path("/{name}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public String deleteEntity(@PathParam("id_entity") String idE, @PathParam("name") String idL) {

		return "Achievements with id:" + idE + "---" + idL + "deleted";

	}

}
