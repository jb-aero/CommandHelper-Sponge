package com.laytonsmith.abstraction.sponge;

import com.laytonsmith.abstraction.AbstractConvertor;
import com.laytonsmith.abstraction.Implementation.Type;
import com.laytonsmith.abstraction.MCAttributeModifier;
import com.laytonsmith.abstraction.MCColor;
import com.laytonsmith.abstraction.MCEnchantment;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCFireworkBuilder;
import com.laytonsmith.abstraction.MCInventory;
import com.laytonsmith.abstraction.MCInventoryHolder;
import com.laytonsmith.abstraction.MCItemMeta;
import com.laytonsmith.abstraction.MCItemStack;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCMetadataValue;
import com.laytonsmith.abstraction.MCNote;
import com.laytonsmith.abstraction.MCPattern;
import com.laytonsmith.abstraction.MCPlugin;
import com.laytonsmith.abstraction.MCPluginMeta;
import com.laytonsmith.abstraction.MCPotionData;
import com.laytonsmith.abstraction.MCRecipe;
import com.laytonsmith.abstraction.MCWorld;
import com.laytonsmith.abstraction.blocks.MCMaterial;
import com.laytonsmith.abstraction.enums.MCAttribute;
import com.laytonsmith.abstraction.enums.MCDyeColor;
import com.laytonsmith.abstraction.enums.MCEquipmentSlot;
import com.laytonsmith.abstraction.enums.MCPatternShape;
import com.laytonsmith.abstraction.enums.MCPotionType;
import com.laytonsmith.abstraction.enums.MCRecipeType;
import com.laytonsmith.abstraction.enums.MCTone;
import com.laytonsmith.abstraction.sponge.events.SpongeAbstractEventMixin;
import com.laytonsmith.abstraction.sponge.inventory.SpongeMCItemStack;
import com.laytonsmith.annotations.convert;
import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.Environment;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.item.ItemType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@convert(type = Type.SPONGE)
public class SpongeConverter extends AbstractConvertor {

	private static SpongeMCPluginMeta pluginMeta = null;
	private static SpongeMCServer game = null;

	@Override
	public MCLocation GetLocation(MCWorld mcWorld, double v, double v1, double v2, float v3, float v4) {
		return null;
	}

	@Override
	public Class GetServerEventMixin() {
		return SpongeAbstractEventMixin.class;
	}

	@Override
	public MCEnchantment[] GetEnchantmentValues() {
		return new MCEnchantment[0];
	}

	@Override
	public MCEnchantment GetEnchantmentByName(String s) {
		return null;
	}

	@Override
	public SpongeMCServer GetServer() {
		if (game == null) {
			game = new SpongeMCServer(Sponge.getGame());
		}
		return game;
	}

	@Override
	public MCItemStack GetItemStack(MCMaterial mcMaterial, int qty) {
		return null;
	}

	@Override
	public MCItemStack GetItemStack(String search, int qty) {
		Optional<ItemType> type = GetServer().__Game().getRegistry().getType(ItemType.class, search);
		if (type.isPresent()) {
			return new SpongeMCItemStack(type.get());
		}
		return null;
	}

	@Override
	public MCPotionData GetPotionData(MCPotionType mcPotionType, boolean b, boolean b1) {
		return null;
	}

	@Override
	public MCAttributeModifier GetAttributeModifier(MCAttribute attr, UUID id, String name, double amt, MCAttributeModifier.Operation op, MCEquipmentSlot slot) {
		return null;
	}

	@Override
	public void Startup(CommandHelperPlugin commandHelperPlugin) {

	}

	@Override
	public MCMaterial[] GetMaterialValues() {
		return new MCMaterial[0];
	}

	@Override
	public MCMaterial GetMaterialFromLegacy(String name, int data) {
		return null;
	}

	@Override
	public MCMaterial GetMaterialFromLegacy(int id, int data) {
		return null;
	}

	@Override
	public MCMaterial GetMaterial(String s) {
		return null;
	}

	@Override
	public MCMetadataValue GetMetadataValue(Object o, MCPlugin mcPlugin) {
		return null;
	}

	@Override
	public MCEntity GetCorrectEntity(MCEntity mcEntity) {
		return GetCorrectEntity((Entity) mcEntity.getHandle());
	}

	public static MCEntity GetCorrectEntity(Entity e) {
		return null;
	}

	@Override
	public MCItemMeta GetCorrectMeta(MCItemMeta mcItemMeta) {
		return null;
	}

	@Override
	public List<MCEntity> GetEntitiesAt(MCLocation mcLocation, double v) {
		return null;
	}

	@Override
	public MCInventory GetEntityInventory(MCEntity mcEntity) {
		return null;
	}

	@Override
	public MCInventory GetLocationInventory(MCLocation mcLocation) {
		return null;
	}

	@Override
	public MCInventoryHolder CreateInventoryHolder(String id, String title) {
		return null;
	}

	@Override
	public MCNote GetNote(int i, MCTone mcTone, boolean b) {
		return null;
	}

	@Override
	public MCColor GetColor(int i, int i1, int i2) {
		return null;
	}

	@Override
	public MCColor GetColor(String s, Target target) {
		return null;
	}

	@Override
	public MCPattern GetPattern(MCDyeColor mcDyeColor, MCPatternShape mcPatternShape) {
		return null;
	}

	@Override
	public MCFireworkBuilder GetFireworkBuilder() {
		return null;
	}

	@Override
	public MCPluginMeta GetPluginMeta() {
		return null;
	}

	@Override
	public MCRecipe GetNewRecipe(String key, MCRecipeType type, MCItemStack result)
	{
		return null;
	}

	@Override
	public MCRecipe GetRecipe(MCRecipe mcRecipe) {
		return null;
	}

	@Override
	public String GetPluginName() {
		return null;
	}

	@Override
	public MCPlugin GetPlugin() {
		return null;
	}

	@Override
	public String GetUser(Environment environment) {
		return null;
	}
}
