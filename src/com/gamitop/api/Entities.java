package com.gamitop.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/entity")
public class Entities {

	// GET a list of all entities
	@GET
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response getEntities() {

		String output = "ListOfEntities";
		return Response.status(200).entity(output).build();
	}

	@POST
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response addEntity() {

		String output = "EntityAdd";
		return Response.status(200).entity(output).build();
	}

	// GET a specific entity
	@Path("/{id_entity}")
	@GET
	// @Produces(MediaType.APPLICATION_JSON)
	public String getGame(@PathParam("id_entity") String id) {

		return "specific entity" + id;

	}

	// PUT a specific entity
	@Path("/{id_entity}")
	@PUT
	// @Produces(MediaType.APPLICATION_JSON)
	public String updateEntity(@PathParam("id_entity") String id) {

		return "Entity Updated" + id;

	}

	// DELETE a specific entity
	@Path("/{id_entity}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public String deleteEntity(@PathParam("id_entity") String id) {

		return "Entity with id:" + id + "deleted";

	}

}
