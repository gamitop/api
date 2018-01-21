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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.gamitop.data.AchievementsData;
import com.gamitop.data.PlayerData;
import com.gamitop.impl.AchievementsManager;
import com.gamitop.impl.EntityManager;
import com.gamitop.impl.LeaderboardManager;
import com.gamitop.impl.PlayersManager;
import com.gamitop.model.Achievement;
import com.gamitop.model.Player;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Path("/entity/{id_entity}/achievements")
public class Achievements {

	//
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Achievement> getAchievements(@PathParam("id_entity") int id_entity) {

		AchievementsManager lm = AchievementsManager.getInstance();
		// String output = "ListOfEntities";
		return lm.getAchievements(id_entity);
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	public Response addAchievement(@PathParam("id_entity") int id_entity, @FormParam("name") String name,
			@FormParam("description") String description, @FormParam("token") String token, @Context UriInfo uriInfo) {

		try {
			AchievementsManager am = AchievementsManager.getInstance();
			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			int id = AchievementsData.getInstance().getIdAchievement();
			builder.path(Integer.toString(id));

			am.createAchievement(name, id_entity, description, builder.toString());
			return Response.created(builder.build()).entity("Link:  " + builder).build();

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}

	}

	// GET a specific entity
	@Path("/{id_achievement}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getAchievement(@PathParam("id_entity") int id_entity,
			@PathParam("id_achievement") int id_achievement) {

		AchievementsManager am = AchievementsManager.getInstance();
		List<Achievement> list = new ArrayList<Achievement>();
		list = am.getAchievement(id_entity, id_achievement);
		GenericEntity entity = new GenericEntity<List<Achievement>>(list) {
		};
		if (list.isEmpty() == true) {
			return Response.serverError().status(404).type("text/plain").entity("Not Found!").build();
		} else {
			return Response.status(200).entity(entity).build();
		}

	} 

	// PUT a specific entity
	@Path("/{id_achievement}")
	@PUT
	@Consumes("application/x-www-form-urlencoded")
	public Response updateAchievement(@PathParam("id_entity") int id_entity,
			@PathParam("id_achievement") int id_achievement, @FormParam("token") String token,@FormParam("name") String name,@FormParam("description") String description) {
		try {

			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			AchievementsManager am= AchievementsManager.getInstance();
			if (am.updateAchievement(name, id_entity, id_achievement, description) == true) {

				return Response.serverError().status(401).type("text/plain").entity("Achievement Updated !").build();

			} else {
				return Response.serverError().status(401).type("text/plain")
						.entity("it's not possible to update achievement !").build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't have authorization to acess this!").build();
		}

	}

	// DELETE a specific entity
	@Path("/{id_achievement}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public Response deleteAchievement(@PathParam("id_entity") int id_Entity, @PathParam("id_achievement") int id_Achievement,
			@FormParam("token") String token) {

		try {
			AchievementsManager am = AchievementsManager.getInstance();
			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			if (am.removeAchievement(id_Entity, id_Achievement) == true) {
				return Response.ok().entity("Achievement removed!").build();
			} else {
				return Response.serverError().status(401).type("text/plain").entity("Not Exist").build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}

	}

	// Delete achievement player
	@Path("/{id_achievement}/players/{id_player}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public Response deleteAchievementPlayer(@PathParam("id_entity") int id_entity, @FormParam("token") String token,
			@PathParam("id_achievement") int id_achievement, @PathParam("id_player") int id_player) {

		try {
			PlayersManager pm = PlayersManager.getInstance();
			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			if (pm.removePlayerAchievement(id_entity, id_achievement, id_player) == true) {
				return Response.ok().entity("Achievement removed!").build();
			} else {
				return Response.serverError().status(404).type("text/plain").entity("Not Exist!").build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}

	}

	// Get achievement player
	@Path("/players/{id_player}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Achievement> getAchievementsPlayer(@PathParam("id_player") int id_player,
			@PathParam("id_entity") int id_Entity) {

		PlayersManager pm = PlayersManager.getInstance();
		// String output = "ListOfEntities";
		return pm.getPlayerAchievements(id_Entity, id_player);
	}

	// Add achievement player
	@Path("/players/{id_player}")
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public Response addAchievementPlayer(@PathParam("id_player") int id_player, @PathParam("id_entity") int id_Entity,
			@FormParam("id_achievement") int id_achievement, @FormParam("token") String token,
			@Context UriInfo uriInfo) {

		try {

			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(id_achievement));

			PlayersManager pm = PlayersManager.getInstance();
			pm.addPlayerAchievement(id_Entity, id_achievement, id_player);

			return Response.created(builder.build()).entity("Link:  " + builder).build();

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}

	}

}
