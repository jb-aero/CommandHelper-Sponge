package com.laytonsmith.abstraction.sponge.entities;

import com.laytonsmith.abstraction.MCHumanEntity;
import com.laytonsmith.abstraction.MCInventory;
import com.laytonsmith.abstraction.MCInventoryView;
import com.laytonsmith.abstraction.MCItemStack;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.blocks.MCMaterial;
import com.laytonsmith.abstraction.enums.MCGameMode;
import org.spongepowered.api.entity.living.Humanoid;

public class SpongeMCHuman extends SpongeMCLiving implements MCHumanEntity {

	Humanoid human;
	public SpongeMCHuman(Humanoid h) {
		super(h);
		this.human = h;
	}

	@Override
	public Humanoid getHandle() {
		return human;
	}

	@Override
	public void closeInventory() {

	}

	@Override
	public MCGameMode getGameMode() {
		return null;
	}

	@Override
	public MCItemStack getItemInHand() {
		return null;
	}

	@Override
	public MCItemStack getItemOnCursor() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public int getSleepTicks() {
		return 0;
	}

	@Override
	public boolean isBlocking() {
		return false;
	}

	@Override
	public boolean isSleeping() {
		return false;
	}

	@Override
	public MCInventoryView openEnchanting(MCLocation mcLocation, boolean b) {
		return null;
	}

	@Override
	public MCInventoryView openInventory(MCInventory mcInventory) {
		return null;
	}

	@Override
	public MCInventoryView getOpenInventory() {
		return null;
	}

	@Override
	public MCInventory getEnderChest() {
		return null;
	}

	@Override
	public MCInventoryView openWorkbench(MCLocation mcLocation, boolean b) {
		return null;
	}

	@Override
	public void setGameMode(MCGameMode mcGameMode) {

	}

	@Override
	public void setItemInHand(MCItemStack mcItemStack) {

	}

	@Override
	public void setItemOnCursor(MCItemStack mcItemStack) {

	}

	@Override
	public int getCooldown(MCMaterial material)
	{
		return 0;
	}

	@Override
	public void setCooldown(MCMaterial material, int ticks)
	{

	}

	@Override
	public MCInventory getInventory() {
		return null;
	}
}
