package com.richo.merlin.api.web.model;

public class PlayerId
{
	private final long id;

	public PlayerId(long id)
	{
		this.id = id;
	}

	public long getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return String.valueOf(id);
	}
}
