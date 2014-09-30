package com.richo.merlin.web.api;

import com.richo.merlin.api.backend.BackendApi;
import com.richo.merlin.api.web.WebApi;
import com.richo.merlin.api.web.model.Player;
import com.richo.merlin.api.web.model.Room;
import com.richo.merlin.backend.inject.BackendModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApiServer implements WebApi
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final BackendApi api;

	public WebApiServer()
	{
		api = BackendModule.getInstance().getInstance(BackendApi.class);
	}

	@Override
	public Player createPlayers(String playerName)
	{
		return api.createPlayer(playerName);
	}

	@Override
	public Room[] getAllRooms()
	{
		logger.info("Get all rooms");
		return api.getAllRooms();
	}

	@Override
	public Room getRoom(final int id)
	{
		return api.getRoom(id);
	}

	@Override
	public Room createRoom(String roomName)
	{
		return api.createRoom(roomName);
	}

	@Override
	public Player[] getAllPlayersInRoom(String id)
	{
		logger.warn("getAllPlayersInRoom is not implemented");
		return new Player[]{};
	}

	@Override
	public void addNewPlayerToRoom(String roomId, String playerName)
	{
		logger.info("Player {} joined room {}", playerName, roomId);
	}
}
