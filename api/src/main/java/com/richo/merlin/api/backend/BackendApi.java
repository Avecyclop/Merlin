package com.richo.merlin.api.backend;


import com.richo.merlin.api.web.model.Player;
import com.richo.merlin.api.web.model.Room;

public interface BackendApi
{
	Room[] getAllRooms();

	Room getRoom(int id);

	Room createRoom(String roomName);

	Player createPlayer(String playerName);
}
