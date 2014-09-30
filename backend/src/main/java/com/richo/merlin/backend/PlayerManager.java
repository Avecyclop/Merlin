package com.richo.merlin.backend;

import com.richo.merlin.api.web.model.Player;
import com.richo.merlin.api.web.model.PlayerId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Richo on 2014-10-01.
 */
public class PlayerManager
{
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final Map<PlayerId, Player> players;
	private final AtomicLong playerIdGenerator;

	public PlayerManager()
	{
		players = new HashMap<>();
		playerIdGenerator = new AtomicLong();
	}

	public Player create(String playerName)
	{
		final long id = playerIdGenerator.incrementAndGet();
		final Player player = new Player(new PlayerId(id), playerName);
		players.put(player.getId(), player);
		logger.info("Created the player {}", player);
		return player;
	}
}
