package com.gamitop.api;

import java.util.List;

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

import com.gamitop.impl.EntityManager;
import com.gamitop.model.Entity;

@Path("/entity")
public class Entities {

	// GET a list of all entities
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Entity> getEntities() {

		EntityManager em = EntityManager.getInstance();
		// String output = "ListOfEntities";
		return em.getEntities();
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response addEntity(@FormParam("username") String username, @FormParam("email") String email,
			@FormParam("password") String password, @FormParam("name") String name, @Context UriInfo uriInfo) {

		EntityManager em = EntityManager.getInstance();
		em.createEntity(name, email, username, password, null, null);

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(name);
		return Response.created(builder.build()).entity("Link:  "+builder).build();
	}

	// GET a specific entity
	@Path("/{id_entity}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Entity getEntity(@PathParam("id_entity") int id) {
		EntityManager em = EntityManager.getInstance();

		return em.getEntity(id);

	}

	// PUT a specific entity
	@Path("/{id_entity}")
	@PUT
	@Consumes("application/x-www-form-urlencoded")
	public String updateEntity(@PathParam("id_entity") String id) {

		return "Entity Updated" + id;

	}

	// DELETE a specific entity
	@Path("/{id_entity}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public Response deleteEntity(@PathParam("id_entity") int id) {

		EntityManager em = EntityManager.getInstance();
		em.removeEntity(id);

		return Response.ok().entity("Entity removed!").build();

	}

}
