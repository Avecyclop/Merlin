package com.richo.merlin.api.web;

import com.richo.merlin.api.web.model.Player;
import com.richo.merlin.api.web.model.Room;

import javax.ws.rs.*;

@Path("/web")
public interface WebApi
{
	@GET
	@Path("/room")
	@Produces("application/json")
	Room[] getAllRooms();

	@GET
	@Path("/room/{id}")
	@Produces("application/json")
	Room getRoom(@PathParam("id") int id);

	@POST
	@Path("/room")
	@Produces("application/json")
	Room createRoom(String roomName);

	@GET
	@Path("/room/{id}/player")
	@Produces("application/json")
	Player[] getAllPlayersInRoom(@PathParam("id") String id);

	@POST
	@Path("/room/{id}/player")
	void addNewPlayerToRoom(@PathParam("id") String roomId, String playerName);
}
	