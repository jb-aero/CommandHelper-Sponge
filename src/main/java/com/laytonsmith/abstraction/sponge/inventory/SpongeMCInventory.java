package com.laytonsmith.abstraction.sponge.inventory;

import com.laytonsmith.abstraction.MCHumanEntity;
import com.laytonsmith.abstraction.MCInventory;
import com.laytonsmith.abstraction.MCInventoryHolder;
import com.laytonsmith.abstraction.MCItemStack;
import com.laytonsmith.abstraction.enums.MCInventoryType;
import org.spongepowered.api.item.inventory.Inventory;

import java.util.List;
import java.util.Map;

public class SpongeMCInventory implements MCInventory
{
	Inventory handle;
	public SpongeMCInventory(Inventory inv)
	{
		handle = inv;
	}

	@Override
	public Inventory getHandle()
	{
		return handle;
	}

	@Override
	public Map<Integer, MCItemStack> addItem(MCItemStack mcItemStack)
	{
		return null;
	}

	@Override
	public MCInventoryType getType()
	{
		return null;
	}

	@Override
	public int getSize()
	{
		return getHandle().capacity();
	}

	@Override
	public MCItemStack getItem(int i)
	{
		return null;
	}

	@Override
	public void setItem(int i, MCItemStack mcItemStack)
	{

	}

	@Override
	public List<MCHumanEntity> getViewers()
	{
		return null;
	}

	@Override
	public void updateViewers()
	{

	}

	@Override
	public void clear()
	{

	}

	@Override
	public void clear(int i)
	{

	}

	@Override
	public MCInventoryHolder getHolder()
	{
		return null;
	}

	@Override
	public String getTitle()
	{
		return null;
	}
}
