package com.laytonsmith.abstraction.sponge.inventory;

import com.laytonsmith.abstraction.MCEnchantment;
import com.laytonsmith.abstraction.MCItemMeta;
import com.laytonsmith.abstraction.MCItemStack;
import com.laytonsmith.abstraction.blocks.MCMaterial;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Map;

public class SpongeMCItemStack implements MCItemStack {

	ItemStack item;

	public SpongeMCItemStack(ItemStack itemStack) {
		this.item = itemStack;
	}

	public SpongeMCItemStack(ItemType itemType) {
		this(ItemStack.builder().itemType(itemType).build());
	}

	@Override
	public ItemStack getHandle() {
		return item;
	}

	@Override
	public int getTypeId() {
		return 0;
	}

	@Override
	public void addEnchantment(MCEnchantment mcEnchantment, int i) {

	}

	@Override
	public void addUnsafeEnchantment(MCEnchantment mcEnchantment, int i) {

	}

	@Override
	public Map<MCEnchantment, Integer> getEnchantments() {
		return null;
	}

	@Override
	public void removeEnchantment(MCEnchantment mcEnchantment) {

	}

	@Override
	public MCMaterial getType() {
		return null;
	}

	@Override
	public void setType(MCMaterial type)
	{

	}

	@Override
	public int maxStackSize() {
		return getHandle().getMaxStackQuantity();
	}

	@Override
	public int getAmount() {
		return getHandle().getQuantity();
	}

	@Override
	public void setAmount(int amt)
	{

	}

	@Override
	public boolean hasItemMeta() {
		return false;
	}

	@Override
	public MCItemMeta getItemMeta() {
		return null;
	}

	@Override
	public void setItemMeta(MCItemMeta mcItemMeta) {

	}

	@Override
	public boolean isEmpty()
	{
		return false;
	}
}
