package com.gamitop.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.gamitop.data.EntityData;
import com.gamitop.impl.EntityManager;
import com.gamitop.impl.LeaderboardManager;
import com.gamitop.model.Entity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Path("/")
public class Entities {

	// POST auth
	@Path("auth")
	@POST
	public Response auth(@FormParam("login") String login, @FormParam("pass") String pass) {

		// Validate user data in db store
		if (EntityData.getInstance().auth(login, pass) == true) {
			// Get GameManager instance
			EntityManager em = EntityManager.getInstance();
			int id = EntityData.getInstance().getAuthId(login, pass);
			// Create user data
			Map<String, Object> user = new HashMap<String, Object>();
			user.put("email", login);
			user.put("_id", id);
			// ...

			// Create JWT token
			String newToken = Jwts.builder().setClaims(user).setIssuer("Gamitop")
					.signWith(SignatureAlgorithm.HS512, em.getKey()).compact();

			// Send token to the client
			return Response.ok().entity(newToken).build();
		} else {
			// Invalid user
			return Response.serverError().status(401).type("text/plain").entity("Invalid Entity!").build();
		}

	}

	// POST auth
	@Path("getID")
	@GET
	public Response get(@QueryParam("token") String token) {

		try {
			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			int id = (Integer) Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token).getBody().get("_id");
			System.out.println(id);

			return Response.status(200).type("text/plain").entity(id).build();
		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}

	}

	// GET a list of all entities
	@Path("/entity")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getEntities(@QueryParam("token") String token) {

		try {
			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			List<Entity> list = new ArrayList<Entity>();
			list = em.getEntities();
			GenericEntity entity = new GenericEntity<List<Entity>>(list) {
			};

			return Response.status(200).entity(entity).build();
		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}

		// String output = "ListOfEntities";
		// return em.getEntities();
	}

	@Path("/entity")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	/* @Produces(MediaType.APPLICATION_JSON) */
	public Response addEntity(@FormParam("name") String username, @FormParam("email") String email,
			@FormParam("password") String password, @FormParam("name") String name, @FormParam("token") String token,
			@Context UriInfo uriInfo) {

		// try {
		EntityManager em = EntityManager.getInstance();
		// Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
		int id = EntityData.getInstance().getIEntity() + 1;
		em.createEntity(id, name, email, username, password, null, null, null);

		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(id));
		return Response.created(builder.build()).entity("Link:" + builder).build();

		// } catch (SignatureException e) {
		// return Response.serverError().status(401).type("text/plain")
		// .entity("You don't authorization to acess this!").build();
		// }

	}

	// GET a specific entity
	@Path("entity/{id_entity}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getEntity(@PathParam("id_entity") int id, @QueryParam("token") String token) {

		try {
			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			List<Entity> list = new ArrayList<Entity>();
			list = em.getEntity(id);
			GenericEntity entity = new GenericEntity<List<Entity>>(list) {
			};
			if (list.isEmpty() == true) {
				return Response.serverError().status(404).type("text/plain").entity("Not Found!").build();
			} else {
				return Response.status(200).entity(entity).build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}

	}

	// PUT a specific entity
	@Path("entity/{id_entity}")
	@PUT
	@Consumes("application/x-www-form-urlencoded")
	public Response updateEntity(@PathParam("id_entity") int id, @FormParam("token") String token,
			@FormParam("name") String name, @FormParam("email") String email, @FormParam("password") String password,
			@FormParam("username") String username) {

		try {

			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);

			if (em.updateEntity(id, name, email, username, password) == true) {

				return Response.serverError().status(401).type("text/plain").entity("Leaderboard Updated !").build();

			} else {
				return Response.serverError().status(401).type("text/plain")
						.entity("You don't have authorization to create leaderboard !").build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't have authorization to acess this!").build();
		}
	}

	// DELETE a specific entity
	@Path("entity/{id_entity}")
	@DELETE
	@Consumes("application/x-www-form-urlencoded")
	public Response deleteEntity(@PathParam("id_entity") int id, @FormParam("token") String token) {

		try {
			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			if (em.removeEntity(id) == true) {
				return Response.ok().entity("Entity removed!").build();
			} else {
				return Response.serverError().status(404).type("text/plain").entity("Not exist!").build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}

	}

}
