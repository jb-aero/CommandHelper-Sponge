package com.laytonsmith.abstraction.sponge.entities;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCInventory;
import com.laytonsmith.abstraction.MCItemStack;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCNote;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.MCPlayerInventory;
import com.laytonsmith.abstraction.MCScoreboard;
import com.laytonsmith.abstraction.enums.MCInstrument;
import com.laytonsmith.abstraction.enums.MCSound;
import com.laytonsmith.abstraction.enums.MCWeather;
import com.laytonsmith.abstraction.sponge.SpongeMCLocation;
import org.spongepowered.api.entity.living.player.Player;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.UUID;

public class SpongeMCPlayer extends SpongeMCHuman implements MCPlayer {

	Player player;
	public SpongeMCPlayer(Player player) {
		super(player);
		this.player = player;
	}

	@Override
	public Player getHandle() {
		return player;
	}

	@Override
	public UUID getUniqueID() {
		return getHandle().getUniqueId();
	}

	@Override
	public InetSocketAddress getAddress() {
		return getHandle().getConnection().getAddress();
	}

	@Override
	public MCPlayerInventory getInventory() {
		return null;
	}

	@Override
	public boolean canSee(MCPlayer mcPlayer) {
		return false;
	}

	@Override
	public void chat(String s) {

	}

	@Override
	public boolean getAllowFlight() {
		return false;
	}

	@Override
	public MCLocation getCompassTarget() {
		return null;
	}

	@Override
	public String getDisplayName() {
		return null;
	}

	@Override
	public float getExp() {
		return 0;
	}

	@Override
	public float getFlySpeed() {
		return 0;
	}

	@Override
	public void setFlySpeed(float v) {

	}

	@Override
	public MCItemStack getItemAt(Integer integer) {
		return null;
	}

	@Override
	public int getLevel() {
		return 0;
	}

	@Override
	public String getPlayerListName() {
		return null;
	}

	@Override
	public long getPlayerTime() {
		return 0;
	}

	@Override
	public MCWeather getPlayerWeather() {
		return null;
	}

	@Override
	public int getRemainingFireTicks() {
		return 0;
	}

	@Override
	public MCScoreboard getScoreboard() {
		return null;
	}

	@Override
	public int getTotalExperience() {
		return 0;
	}

	@Override
	public int getExpToLevel() {
		return 0;
	}

	@Override
	public int getExpAtLevel() {
		return 0;
	}

	@Override
	public MCEntity getSpectatorTarget() {
		return null;
	}

	@Override
	public float getWalkSpeed() {
		return 0;
	}

	@Override
	public void setWalkSpeed(float v) {

	}

	@Override
	public void giveExp(int i) {

	}

	@Override
	public boolean isSneaking() {
		return false;
	}

	@Override
	public boolean isSprinting() {
		return false;
	}

	@Override
	public void kickPlayer(String s) {

	}

	@Override
	public void resetPlayerTime() {

	}

	@Override
	public void resetPlayerWeather() {

	}

	@Override
	public void sendTexturePack(String s) {

	}

	@Override
	public void sendResourcePack(String s) {

	}

	@Override
	public void setAllowFlight(boolean b) {

	}

	@Override
	public void setCompassTarget(MCLocation mcLocation) {

	}

	@Override
	public void setDisplayName(String s) {

	}

	@Override
	public void setExp(float v) {

	}

	@Override
	public void setFlying(boolean b) {

	}

	@Override
	public void setLevel(int i) {

	}

	@Override
	public void setPlayerListName(String s) {

	}

	@Override
	public void setPlayerTime(Long aLong, boolean b) {

	}

	@Override
	public void setPlayerWeather(MCWeather mcWeather) {

	}

	@Override
	public void setRemainingFireTicks(int i) {

	}

	@Override
	public void setScoreboard(MCScoreboard mcScoreboard) {

	}

	@Override
	public void setSpectatorTarget(MCEntity mcEntity) {

	}

	@Override
	public void setTempOp(Boolean aBoolean) throws Exception {

	}

	@Override
	public void setTotalExperience(int i) {

	}

	@Override
	public void setVanished(boolean b, MCPlayer mcPlayer) {

	}

	@Override
	public boolean isNewPlayer() {
		return false;
	}

	@Override
	public String getHost() {
		return null;
	}

	@Override
	public void sendBlockChange(MCLocation mcLocation, int i, byte b) {

	}

	@Override
	public void sendSignTextChange(MCLocation mcLocation, String[] strings) {

	}

	@Override
	public MCLocation getLocation() {
		return new SpongeMCLocation(getHandle().getLocation());
	}

	@Override
	public MCLocation asyncGetLocation() {
		return new SpongeMCLocation(getHandle().getLocation());
	}

	@Override
	public void playNote(MCLocation mcLocation, MCInstrument mcInstrument, MCNote mcNote) {

	}

	@Override
	public void playSound(MCLocation mcLocation, MCSound mcSound, float v, float v1) {

	}

	@Override
	public void playSound(MCLocation mcLocation, String s, float v, float v1) {

	}

	@Override
	public int getFoodLevel() {
		return 0;
	}

	@Override
	public void setFoodLevel(int i) {

	}

	@Override
	public float getSaturation() {
		return 0;
	}

	@Override
	public void setSaturation(float v) {

	}

	@Override
	public float getExhaustion() {
		return 0;
	}

	@Override
	public void setExhaustion(float v) {

	}

	@Override
	public void setBedSpawnLocation(MCLocation mcLocation, boolean b) {

	}

	@Override
	public void sendPluginMessage(String s, byte[] bytes) {

	}

	@Override
	public void sendMessage(String s) {

	}

	@Override
	public boolean isOp() {
		return false;
	}

	@Override
	public boolean hasPermission(String s) {
		return false;
	}

	@Override
	public boolean isPermissionSet(String s) {
		return false;
	}

	@Override
	public List<String> getGroups() {
		return null;
	}

	@Override
	public boolean inGroup(String s) {
		return false;
	}

	@Override
	public void setOp(boolean b) {

	}

	@Override
	public boolean isFlying() {
		return false;
	}

	@Override
	public void updateInventory() {

	}

	@Override
	public long getFirstPlayed() {
		return 0;
	}

	@Override
	public long getLastPlayed() {
		return 0;
	}

	@Override
	public MCPlayer getPlayer() {
		return null;
	}

	@Override
	public boolean hasPlayedBefore() {
		return false;
	}

	@Override
	public boolean isBanned() {
		return false;
	}

	@Override
	public boolean isOnline() {
		return false;
	}

	@Override
	public boolean isWhitelisted() {
		return false;
	}

	@Override
	public void setBanned(boolean b) {

	}

	@Override
	public void setWhitelisted(boolean b) {

	}

	@Override
	public MCLocation getBedSpawnLocation() {
		return null;
	}
}
