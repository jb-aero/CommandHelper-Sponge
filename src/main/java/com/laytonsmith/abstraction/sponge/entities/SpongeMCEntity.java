package com.laytonsmith.abstraction.sponge.entities;

import com.flowpowered.math.vector.Vector3d;
import com.laytonsmith.PureUtilities.Vector3D;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCMetadataValue;
import com.laytonsmith.abstraction.MCPlugin;
import com.laytonsmith.abstraction.MCServer;
import com.laytonsmith.abstraction.MCWorld;
import com.laytonsmith.abstraction.enums.MCEntityEffect;
import com.laytonsmith.abstraction.enums.MCEntityType;
import com.laytonsmith.abstraction.enums.MCTeleportCause;
import com.laytonsmith.abstraction.events.MCEntityDamageEvent;
import com.laytonsmith.abstraction.sponge.SpongeConverter;
import com.laytonsmith.abstraction.sponge.SpongeMCLocation;
import org.spongepowered.api.data.manipulator.mutable.entity.GravityData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class SpongeMCEntity implements MCEntity {

	Entity ent;
	public SpongeMCEntity(Entity entity) {
		this.ent = entity;
	}

	@Override
	public Entity getHandle() {
		return ent;
	}

	@Override
	public boolean eject() {
		return false;
	}

	@Override
	public float getFallDistance() {
		return 0;
	}

	@Override
	public int getFireTicks() {
		return 0;
	}

	@Override
	public MCEntityDamageEvent getLastDamageCause() {
		return null;
	}

	@Override
	public MCLocation getLocation() {
		return null;
	}

	@Override
	public int getMaxFireTicks() {
		return 0;
	}

	@Override
	public List<MCEntity> getNearbyEntities(double v, double v1, double v2) {
		return null;
	}

	@Override
	public List<MCEntity> getPassengers() {
		return null;
	}

	@Override
	public MCServer getServer() {
		return null;
	}

	@Override
	public int getTicksLived() {
		return 0;
	}

	@Override
	public MCEntityType getType() {
		return null;
	}

	@Override
	public UUID getUniqueId() {
		return getHandle().getUniqueId();
	}

	@Override
	public MCEntity getVehicle() {
		Optional<Entity> v = getHandle().getVehicle();
		if (v.isPresent()) {
			return SpongeConverter.GetCorrectEntity(v.get());
		}
		return null;
	}

	@Override
	public Vector3D getVelocity() {
		return null;
	}

	@Override
	public void setVelocity(Vector3D vector3D) {

	}

	@Override
	public MCWorld getWorld() {
		return null;
	}

	@Override
	public boolean isDead() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean isInsideVehicle() {
		return false;
	}

	@Override
	public boolean isOnGround() {
		return false;
	}

	@Override
	public boolean leaveVehicle() {
		return getHandle().setVehicle(null);
	}

	@Override
	public void playEffect(MCEntityEffect mcEntityEffect) {

	}

	@Override
	public void remove() {
		getHandle().remove();
	}

	@Override
	public void setFallDistance(float v) {

	}

	@Override
	public void setFireTicks(int i) {

	}

	@Override
	public void setLastDamageCause(MCEntityDamageEvent mcEntityDamageEvent) {

	}

	@Override
	public boolean setPassenger(MCEntity mcEntity) {
		return false;
	}

	@Override
	public void setTicksLived(int i) {

	}

	@Override
	public boolean teleport(MCEntity mcEntity) {
		Location<World> loc = (Location<World>) mcEntity.getLocation().getHandle();
		Vector3d rot = SpongeMCLocation.getRotation(mcEntity.getLocation());
		return getHandle().setLocationAndRotation(loc, rot);
	}

	@Override
	public boolean teleport(MCEntity mcEntity, MCTeleportCause mcTeleportCause) {
		return false;
	}

	@Override
	public boolean teleport(MCLocation mcLocation) {
		Location<World> loc = (Location<World>) mcLocation.getHandle();
		Vector3d rot = SpongeMCLocation.getRotation(mcLocation);
		return getHandle().setLocationAndRotation(loc, rot);
	}

	@Override
	public boolean teleport(MCLocation mcLocation, MCTeleportCause mcTeleportCause) {
		return false;
	}

	@Override
	public void setCustomName(String s) {

	}

	@Override
	public String getCustomName() {
		return null;
	}

	@Override
	public void setCustomNameVisible(boolean b) {

	}

	@Override
	public boolean isCustomNameVisible() {
		return false;
	}

	@Override
	public boolean isGlowing() {
		return false;
	}

	@Override
	public void setGlowing(Boolean aBoolean) {

	}

	@Override
	public boolean hasGravity() {
		if (getHandle().supports(GravityData.class)) {
			return getHandle().get(GravityData.class).get().gravity().get();
		}
		return false;
	}

	@Override
	public void setHasGravity(boolean b) {

	}

	@Override
	public boolean isSilent()
	{
		return false;
	}

	@Override
	public void setSilent(boolean silent)
	{

	}

	@Override
	public boolean isInvulnerable()
	{
		return false;
	}

	@Override
	public void setInvulnerable(boolean invulnerable)
	{

	}

	@Override
	public Set<String> getScoreboardTags()
	{
		return null;
	}

	@Override
	public boolean addScoreboardTag(String tag)
	{
		return false;
	}

	@Override
	public boolean removeScoreboardTag(String tag)
	{
		return false;
	}

	@Override
	public List<MCMetadataValue> getMetadata(String s) {
		return null;
	}

	@Override
	public boolean hasMetadata(String s) {
		return false;
	}

	@Override
	public void removeMetadata(String s, MCPlugin mcPlugin) {

	}

	@Override
	public void setMetadata(String s, MCMetadataValue mcMetadataValue) {

	}
}
