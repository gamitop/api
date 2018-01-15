package com.gamitop.api;

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

import com.gamitop.impl.AchievementsManager;
import com.gamitop.impl.PlayersManager;
import com.gamitop.model.Achievement;

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
			@FormParam("description") String description, @Context UriInfo uriInfo) {

		AchievementsManager am = AchievementsManager.getInstance();

	
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(0));

		am.createAchievement(name, id_entity, description, builder.toString());
		return Response.created(builder.build()).entity("Link:  " + builder).build();
	}

	// GET a specific entity
	@Path("/{name}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Achievement> getAchievement(@PathParam("id_entity") int id_entity,
			@PathParam("id_achievement") int id_achievement) {

		AchievementsManager am = AchievementsManager.getInstance();

		// String output = "ListOfEntities";
		return am.getAchievement(id_entity, id_achievement);

	}

	// PUT a specific entity
	@Path("/{id_achievement}")
	@PUT
	@Consumes("application/x-www-form-urlencoded")
	public String updateAchievement(@PathParam("id_entity") String id_entity,
			@PathParam("id_achievement") String id_achievement) {
		return null;

	}

	// DELETE a specific entity
	@Path("/{id_achievement}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public Response deleteAchievement(@PathParam("id_entity") int id_Entity, @PathParam("name") int id_Achievement) {

		AchievementsManager am = AchievementsManager.getInstance();

		am.removeAchievement(id_Entity, id_Achievement);

		return Response.ok().entity("Achievement removed!").build();

	}

	// Delete achievement player
	@Path("/{id_achievement}/players/{id_player}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public String deleteAchievementPlayer(@PathParam("id_entity") int id_entity, @PathParam("id_achievement") int id_achievement, @PathParam("id_player") int id_player) {

		PlayersManager pm= PlayersManager.getInstance();
		pm.removePlayerAchievement(id_entity, id_achievement, id_player);
		return null;
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
	public String addAchievementPlayer(@PathParam("id_player") int id_player,
			@PathParam("id_entity") int id_Entity, @FormParam("id_achievement") int id_achievement) {
		
		PlayersManager pm= PlayersManager.getInstance();
		pm.addPlayerAchievement(id_Entity, id_achievement, id_player);
		
		return "Achievemente added to Player";
		

	}

}
