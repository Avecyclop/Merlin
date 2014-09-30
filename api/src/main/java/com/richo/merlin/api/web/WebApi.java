package com.richo.merlin.api.web;

import com.richo.merlin.api.web.model.Player;
import com.richo.merlin.api.web.model.Room;

import javax.ws.rs.*;

@Path("/web")
public interface WebApi
{
	final String APPLICATION_JSON = "application/json";

	@POST
	@Path("/players")
	@Produces(APPLICATION_JSON)
	Player createPlayers(String playerName);

	@GET
	@Path("/room")
	@Produces(APPLICATION_JSON)
	Room[] getAllRooms();

	@GET
	@Path("/room/{id}")
	@Produces(APPLICATION_JSON)
	Room getRoom(@PathParam("id") int id);

	@POST
	@Path("/room")
	@Produces(APPLICATION_JSON)
	Room createRoom(String roomName);

	@GET
	@Path("/room/{id}/player")
	@Produces(APPLICATION_JSON)
	Player[] getAllPlayersInRoom(@PathParam("id") String id);

	@POST
	@Path("/room/{id}/player")
	void addNewPlayerToRoom(@PathParam("id") String roomId, String playerName);
}
	