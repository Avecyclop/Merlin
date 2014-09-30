package com.richo.merlin.api.web.model;

/**
 * Created by Richo on 2014-09-24.
 */
public class Player
{
	private final String name;
	private final PlayerId id;

	public Player(final PlayerId id, final String name)
	{
		this.name = name;
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public PlayerId getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return "Player{" +
				"name='" + name + '\'' +
				", id=" + id +
				'}';
	}
}
