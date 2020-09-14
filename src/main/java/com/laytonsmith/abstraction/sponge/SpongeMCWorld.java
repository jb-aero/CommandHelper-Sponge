package com.laytonsmith.abstraction.sponge;

import com.laytonsmith.abstraction.MCChunk;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCFireworkEffect;
import com.laytonsmith.abstraction.MCItemStack;
import com.laytonsmith.abstraction.MCLivingEntity;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.MCWorld;
import com.laytonsmith.abstraction.MCWorldBorder;
import com.laytonsmith.abstraction.blocks.MCBlock;
import com.laytonsmith.abstraction.blocks.MCBlockData;
import com.laytonsmith.abstraction.entities.MCFallingBlock;
import com.laytonsmith.abstraction.entities.MCFirework;
import com.laytonsmith.abstraction.entities.MCItem;
import com.laytonsmith.abstraction.entities.MCLightningStrike;
import com.laytonsmith.abstraction.enums.MCBiomeType;
import com.laytonsmith.abstraction.enums.MCDifficulty;
import com.laytonsmith.abstraction.enums.MCEffect;
import com.laytonsmith.abstraction.enums.MCEntityType;
import com.laytonsmith.abstraction.enums.MCGameRule;
import com.laytonsmith.abstraction.enums.MCMobs;
import com.laytonsmith.abstraction.enums.MCParticle;
import com.laytonsmith.abstraction.enums.MCSound;
import com.laytonsmith.abstraction.enums.MCSoundCategory;
import com.laytonsmith.abstraction.enums.MCTreeType;
import com.laytonsmith.abstraction.enums.MCWorldEnvironment;
import com.laytonsmith.abstraction.enums.MCWorldType;
import com.laytonsmith.abstraction.sponge.blocks.SpongeMCBlock;
import com.laytonsmith.abstraction.sponge.entities.SpongeMCEntity;
import com.laytonsmith.abstraction.sponge.entities.SpongeMCLiving;
import com.laytonsmith.abstraction.sponge.entities.SpongeMCPlayer;
import com.laytonsmith.core.constructs.CArray;
import com.laytonsmith.core.constructs.CClosure;
import com.laytonsmith.core.constructs.Target;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.List;

public class SpongeMCWorld extends SpongeMCMetadatable implements MCWorld
{
	World handle;
	public SpongeMCWorld(World world)
	{
		handle = world;
	}

	public World _World()
	{
		return handle;
	}

	@Override
	public World getHandle()
	{
		return handle;
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof MCWorld && _World().equals(((SpongeMCWorld) obj)._World());
	}

	@Override
	public int hashCode()
	{
		return getHandle().hashCode();
	}

	@Override
	public String toString()
	{
		return getHandle().toString();
	}

	@Override
	public List<MCPlayer> getPlayers()
	{
		List<MCPlayer> ret = new ArrayList<>();
		for (Player p : getHandle().getPlayers())
		{
			ret.add(new SpongeMCPlayer(p));
		}
		return ret;
	}

	@Override
	public List<MCEntity> getEntities()
	{
		List<MCEntity> ret = new ArrayList<>();
		for (Entity e : getHandle().getEntities())
		{
			ret.add(new SpongeMCEntity(e));
		}
		return ret;
	}

	@Override
	public List<MCLivingEntity> getLivingEntities()
	{
		List<MCLivingEntity> ret = new ArrayList<>();
		for (Entity e : getHandle().getEntities())
		{
			if (e instanceof Living)
			{
				ret.add(new SpongeMCLiving((Living) e));
			}
		}
		return ret;
	}

	@Override
	public String getName()
	{
		return getHandle().getName();
	}

	@Override
	public long getSeed()
	{
		return getHandle().getProperties().getSeed();
	}

	@Override
	public MCWorldEnvironment getEnvironment()
	{
		return null;
	}

	@Override
	public String getGenerator()
	{
		return null;
	}

	@Override
	public MCWorldType getWorldType()
	{
		return null;
	}

	@Override
	public int getSeaLevel()
	{
		return getHandle().getSeaLevel();
	}

	@Override
	public int getMaxHeight()
	{
		return 0;
	}

	@Override
	public MCDifficulty getDifficulty()
	{
		return null;
	}

	@Override
	public void setDifficulty(MCDifficulty mcDifficulty)
	{

	}

	@Override
	public boolean getPVP()
	{
		return getHandle().getProperties().isPVPEnabled();
	}

	@Override
	public void setPVP(boolean b)
	{
		getHandle().getProperties().setPVPEnabled(b);
	}

	@Override
	public String[] getGameRules()
	{
		return new String[0];
	}

	@Override
	public String getGameRuleValue(String gameRule)
	{
		return null;
	}

	@Override
	public boolean setGameRuleValue(MCGameRule gameRule, String value)
	{
		return false;
	}

	@Override
	public MCWorldBorder getWorldBorder()
	{
		return null;
	}

	@Override
	public MCBlock getBlockAt(int x, int y, int z)
	{
		return new SpongeMCBlock(getHandle().getBlock(x, y, z));
	}

	@Override
	public MCChunk getChunkAt(int x, int y)
	{
		return null;
	}

	@Override
	public MCChunk getChunkAt(MCBlock mcBlock)
	{
		return null;
	}

	@Override
	public MCChunk getChunkAt(MCLocation mcLocation) {
		return null;
	}

	@Override
	public MCChunk[] getLoadedChunks() {
		return new MCChunk[0];
	}

	@Override
	public boolean isChunkLoaded(int x, int z) {
		return false;
	}

	@Override
	public boolean regenerateChunk(int i, int i1) {
		return false;
	}

	@Override
	public MCEntity spawn(MCLocation mcLocation, Class aClass) {
		return null;
	}

	@Override
	public MCEntity spawn(MCLocation mcLocation, MCEntityType mcEntityType)
	{
		return null;
	}

	@Override
	public MCEntity spawn(MCLocation l, MCEntityType entType, CClosure closure)
	{
		return null;
	}

	@Override
	public MCEntity spawn(MCLocation mcLocation, MCEntityType.MCVanillaEntityType mcVanillaEntityType)
	{
		return null;
	}

	@Override
	public boolean generateTree(MCLocation mcLocation, MCTreeType mcTreeType) {
		return false;
	}

	@Override
	public void playEffect(MCLocation mcLocation, MCEffect mcEffect, int i, int i1) {

	}

	@Override
	public void playEffect(MCLocation l, MCEffect mCEffect, Object data, int radius) {

	}

	@Override
	public void spawnParticle(MCLocation l, MCParticle pa, int count, double offsetX, double offsetY, double offsetZ, double velocity, Object data) {

	}

	@Override
	public void playSound(MCLocation mcLocation, MCSound mcSound, float v, float v1) {

	}

	@Override
	public void playSound(MCLocation mcLocation, String s, float v, float v1)
	{

	}

	@Override
	public void playSound(MCLocation l, MCSound sound, MCSoundCategory category, float volume, float pitch)
	{

	}

	@Override
	public void playSound(MCLocation l, String sound, MCSoundCategory category, float volume, float pitch)
	{

	}

	@Override
	public MCItem dropItemNaturally(MCLocation mcLocation, MCItemStack mcItemStack)
	{
		return null;
	}

	@Override
	public MCItem dropItem(MCLocation mcLocation, MCItemStack mcItemStack)
	{
		return null;
	}

	@Override
	public MCLightningStrike strikeLightning(MCLocation mcLocation)
	{
		return null;
	}

	@Override
	public MCLightningStrike strikeLightningEffect(MCLocation mcLocation)
	{
		return null;
	}

	@Override
	public void setStorm(boolean b)
	{

	}

	@Override
	public void setThundering(boolean b)
	{

	}

	@Override
	public void setWeatherDuration(int i)
	{

	}

	@Override
	public void setThunderDuration(int i)
	{

	}

	@Override
	public boolean isStorming()
	{
		return false;
	}

	@Override
	public boolean isThundering()
	{
		return false;
	}

	@Override
	public MCLocation getSpawnLocation()
	{
		return null;
	}

	@Override
	public void setSpawnLocation(int i, int i1, int i2)
	{

	}

	@Override
	public void refreshChunk(int i, int i1)
	{

	}

	@Override
	public void loadChunk(int i, int i1)
	{

	}

	@Override
	public void unloadChunk(int i, int i1)
	{

	}

	@Override
	public void setTime(long l) {

	}

	@Override
	public long getTime() {
		return 0;
	}

	@Override
	public void setFullTime(long time) {

	}

	@Override
	public long getFullTime() {
		return 0;
	}

	@Override
	public CArray spawnMob(MCMobs mcMobs, String s, int i, MCLocation mcLocation, Target target) {
		return null;
	}

	@Override
	public MCFallingBlock spawnFallingBlock(MCLocation loc, MCBlockData data) {
		return null;
	}

	@Override
	public MCFirework launchFirework(MCLocation mcLocation, int i, List<MCFireworkEffect> list)
	{
		return null;
	}

	@Override
	public MCBiomeType getBiome(int i, int i1)
	{
		return null;
	}

	@Override
	public void setBiome(int i, int i1, MCBiomeType mcBiomeType)
	{

	}

	@Override
	public MCBlock getHighestBlockAt(int i, int i1)
	{
		return null;
	}

	@Override
	public void explosion(double v, double v1, double v2, float v3, boolean b)
	{

	}

	@Override
	public boolean exists() {
		return false;
	}

	@Override
	public void save() {

	}

	@Override
	public void setKeepSpawnInMemory(boolean keepLoaded) {

	}
}
