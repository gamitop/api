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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.gamitop.data.EntityData;
import com.gamitop.data.LeaderboardData;
import com.gamitop.data.PlayerData;
import com.gamitop.impl.EntityManager;
import com.gamitop.impl.LeaderboardManager;
import com.gamitop.impl.PlayersManager;
import com.gamitop.model.Entity;
import com.gamitop.model.Leaderboard;
import com.gamitop.model.Player;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

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
			@FormParam("description") String description, @Context UriInfo uriInfo, @FormParam("token") String token) {

		try {

			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);

			int id_Token = (Integer) Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token).getBody()
					.get("_id");
			if (id_Token == entity) {

				int id = LeaderboardData.getInstance().getIdLeaderboard() + 1;
				UriBuilder builder = uriInfo.getAbsolutePathBuilder();
				builder.path(Integer.toString(id));

				LeaderboardManager lm = LeaderboardManager.getInstance();
				ArrayList<String> players = new ArrayList<String>();
				lm.createLeaderboard(id, name, entity, description, builder.toString(), players);

				return Response.created(builder.build()).type("text/plain").entity("Link:  " + builder).build();
			} else {
				return Response.serverError().status(401).type("text/plain")
						.entity("You don't have authorization to create leaderboard !").build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't have authorization to acess this!").build();
		}

	}

	// GET a specific entity
	@Path("/{id_leaderboard}")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getLeaderboard(@PathParam("id_entity") int idEntity, @PathParam("id_leaderboard") int idLeaderboard,
			@QueryParam("token") String token) {
		// EntityManager em = EntityManager.getInstance();

		// try {
		LeaderboardManager lm = LeaderboardManager.getInstance();
		// Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
		List<Leaderboard> list = new ArrayList<Leaderboard>();
		list = lm.getLeaderboard(idEntity, idLeaderboard);
		GenericEntity entity = new GenericEntity<List<Leaderboard>>(list) {
		};
		if (list.isEmpty() == true) {
			return Response.serverError().status(404).type("text/plain").entity("Not Found!").build();
		} else {
			return Response.status(200).entity(entity).build();
		}

		// } catch (SignatureException e) {
		// return Response.serverError().status(401).type("text/plain")
		// .entity("You don't authorization to acess this!").build();
		// }

	}

	// PUT a specific entity
	@Path("/{id_leaderboard}")
	@PUT
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response updateLeaderboard(@PathParam("id_entity") int idEntity,
			@PathParam("id_leaderboard") int idLeaderboard,@FormParam("name") String nameLeaderboard,@FormParam("description") String description, @FormParam("token") String token) {

		try {

			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			LeaderboardManager lm = LeaderboardManager.getInstance();
			if (lm.updateLeaderboard(idLeaderboard,nameLeaderboard, idEntity, description)== true) {
				
						
				return Response.serverError().status(401).type("text/plain")
						.entity("Leaderboard Updated !").build();
				
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
	@Path("/{id_leaderboard}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public Response deleteLeaderboard(@PathParam("id_entity") int idEntity,
			@PathParam("id_leaderboard") int idLeaderboard, @FormParam("token") String token) {

		try {

			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			LeaderboardManager lm = LeaderboardManager.getInstance();//
			if (lm.removeLeaderboard(idEntity, idLeaderboard) == true) {
				return Response.ok().entity("Leaderboard removed!").build();
			} else {
				return Response.serverError().status(404).type("text/plain").entity("Not exist!").build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}

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
			@FormParam("lose") int lose, @FormParam("totalGames") int totalGames, @FormParam("token") String token,
			@Context UriInfo uriInfo) {

		try {

			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			int id = PlayerData.getInstance().getIdPlayer() + 1;
			builder.path(Integer.toString(id));
			PlayersManager pm = PlayersManager.getInstance();
			ArrayList<String> achievements = new ArrayList<String>();

			pm.addPlayer(name, score, win, lose, totalGames, entity, id_leaderboard, builder.toString(), achievements);
			return Response.created(builder.build()).entity("Link:  " + builder).build();

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();

		}

	}

	// GET a specific entity
	@Path("/{id_leaderboard}/players/{id_player}")
	@GET
	// @Produces(MediaType.APPLICATION_JSON)
	public Response getPlayer(@PathParam("id_entity") int id_Entity, @PathParam("id_leaderboard") int id_Leaderboard,
			@PathParam("id_player") int id_Player) {

		PlayerData p = PlayerData.getInstance();
		List<Player> list = new ArrayList<Player>();
		list = p.getDataPlayer(id_Entity, id_Player, id_Leaderboard);
		GenericEntity entity = new GenericEntity<List<Player>>(list) {
		};
		if (list.isEmpty() == true) {
			return Response.serverError().status(404).type("text/plain").entity("Not Found!").build();
		} else {
			return Response.status(200).entity(entity).build();
		}

	}

	// PUT a specific entity
	@Path("/{id_leaderboard}/players/{id_player}")
	@PUT
	// @Produces(MediaType.APPLICATION_JSON)
	public Response updatePlayer(@PathParam("id_entity") int id_entity, @PathParam("id_leaderboard") int id_leaderboard,
			@PathParam("id_player") int id_player, @FormParam("token") String token, @FormParam("name") String name,@FormParam("win") int win,@FormParam("totalGames") int totalGames,@FormParam("lose") int lose,@FormParam("score") int score) {
		
		
		try {

			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			PlayersManager pm = PlayersManager.getInstance();
			if (pm.updatePlayer(id_player, id_entity, id_leaderboard, name, score, win, lose, totalGames)== true) {
				
						
				return Response.serverError().status(401).type("text/plain")
						.entity("Player Updated !").build();
				
			} else {
				return Response.serverError().status(401).type("text/plain")
						.entity("It´s not possible to update the player !").build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't have authorization to acess this!").build();
		}
		
		
		
		
	}

	// DELETE a specific entity
	@Path("/{id_leaderboard}/players/{id_player}")
	@DELETE
	// @Produces(MediaType.APPLICATION_JSON)
	public Response deletePlayer(@PathParam("id_entity") int id_Entity, @PathParam("id_leaderboard") int id_Leaderboard,
			@PathParam("id_player") int id_Player, @FormParam("token") String token) {

		try {
			EntityManager em = EntityManager.getInstance();
			Jwts.parser().setSigningKey(em.getKey()).parseClaimsJws(token);
			PlayerData p = PlayerData.getInstance();
			if (p.removePlayer(id_Entity, id_Leaderboard, id_Player) == true) {
				return Response.ok().entity("Player removed!").build();
			} else {
				return Response.serverError().status(404).type("text/plain").entity("Not exist!").build();
			}

		} catch (SignatureException e) {
			return Response.serverError().status(401).type("text/plain")
					.entity("You don't authorization to acess this!").build();
		}
	}

}