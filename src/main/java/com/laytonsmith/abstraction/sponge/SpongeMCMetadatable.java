package com.laytonsmith.abstraction.sponge;

import com.laytonsmith.abstraction.MCMetadataValue;
import com.laytonsmith.abstraction.MCMetadatable;
import com.laytonsmith.abstraction.MCPlugin;

import java.util.List;

/*
 * TODO - not sure off the top of my head if this feature exists in Sponge
 */
public class SpongeMCMetadatable implements MCMetadatable
{
	@Override
	public List<MCMetadataValue> getMetadata(String s)
	{
		return null;
	}

	@Override
	public boolean hasMetadata(String s)
	{
		return false;
	}

	@Override
	public void removeMetadata(String s, MCPlugin mcPlugin)
	{

	}

	@Override
	public void setMetadata(String s, MCMetadataValue mcMetadataValue)
	{

	}

	@Override
	public Object getHandle()
	{
		return null;
	}
}
