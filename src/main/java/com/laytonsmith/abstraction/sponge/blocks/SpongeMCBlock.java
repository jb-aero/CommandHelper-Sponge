package com.laytonsmith.abstraction.sponge.blocks;

import com.laytonsmith.abstraction.MCItemStack;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCWorld;
import com.laytonsmith.abstraction.blocks.MCBlock;
import com.laytonsmith.abstraction.blocks.MCBlockData;
import com.laytonsmith.abstraction.blocks.MCBlockFace;
import com.laytonsmith.abstraction.blocks.MCBlockState;
import com.laytonsmith.abstraction.blocks.MCCommandBlock;
import com.laytonsmith.abstraction.blocks.MCDispenser;
import com.laytonsmith.abstraction.blocks.MCMaterial;
import com.laytonsmith.abstraction.blocks.MCSign;
import com.laytonsmith.abstraction.sponge.SpongeMCMetadatable;
import org.spongepowered.api.block.BlockState;

import java.util.Collection;

public class SpongeMCBlock extends SpongeMCMetadatable implements MCBlock, MCBlockState
{
	BlockState handle;
	public SpongeMCBlock(BlockState block)
	{
		handle = block;
	}

	@Override
	public BlockState getHandle()
	{
		return handle;
	}

	public BlockState _Block()
	{
		return handle;
	}

	@Override
	public int getTypeId()
	{
		return 0;
	}

	@Override
	public byte getData()
	{
		return 0;
	}

	@Override
	public void setType(MCMaterial mat)
	{

	}

	@Override
	public void setType(MCMaterial mat, boolean physics)
	{

	}

	@Override
	public void setTypeAndData(int i, byte b, boolean b1)
	{

	}

	@Override
	public MCBlockData getBlockData()
	{
		return null;
	}

	@Override
	public void setBlockData(MCBlockData data, boolean physics)
	{

	}

	@Override
	public double getTemperature()
	{
		return 0;
	}

	@Override
	public MCBlockState getState()
	{
		return null;
	}

	@Override
	public MCMaterial getType()
	{
		return null;
	}

	@Override
	public MCBlock getBlock()
	{
		return null;
	}

	@Override
	public MCWorld getWorld()
	{
		return null;
	}

	@Override
	public int getX()
	{
		return 0;
	}

	@Override
	public int getY()
	{
		return 0;
	}

	@Override
	public int getZ()
	{
		return 0;
	}

	@Override
	public MCLocation getLocation()
	{
		return null;
	}

	@Override
	public void update()
	{

	}

	@Override
	public MCSign getSign()
	{
		return null;
	}

	@Override
	public boolean isSign()
	{
		return false;
	}

	@Override
	public MCCommandBlock getCommandBlock()
	{
		return null;
	}

	@Override
	public boolean isCommandBlock()
	{
		return false;
	}

	@Override
	public MCDispenser getDispenser()
	{
		return null;
	}

	@Override
	public boolean isDispenser()
	{
		return false;
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}

	@Override
	public boolean isFlammable()
	{
		return false;
	}

	@Override
	public boolean isTransparent()
	{
		return false;
	}

	@Override
	public boolean isOccluding()
	{
		return false;
	}

	@Override
	public boolean isBurnable()
	{
		return false;
	}

	@Override
	public Collection<MCItemStack> getDrops()
	{
		return null;
	}

	@Override
	public Collection<MCItemStack> getDrops(MCItemStack mcItemStack)
	{
		return null;
	}

	@Override
	public int getLightLevel()
	{
		return 0;
	}

	@Override
	public int getBlockPower()
	{
		return 0;
	}

	@Override
	public boolean isBlockPowered()
	{
		return false;
	}

	@Override
	public boolean isBlockIndirectlyPowered()
	{
		return false;
	}

	@Override
	public MCBlock getRelative(MCBlockFace mcBlockFace)
	{
		return null;
	}

	@Override
	public MCBlockFace getFace(MCBlock mcBlock)
	{
		return null;
	}

	@Override
	public boolean isEmpty()
	{
		return false;
	}
}
