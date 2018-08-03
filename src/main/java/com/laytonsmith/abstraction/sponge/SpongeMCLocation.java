package com.laytonsmith.abstraction.sponge;

import com.flowpowered.math.vector.Vector3d;
import com.laytonsmith.PureUtilities.Vector3D;
import com.laytonsmith.abstraction.MCChunk;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCWorld;
import com.laytonsmith.abstraction.blocks.MCBlock;
import com.laytonsmith.abstraction.sponge.blocks.SpongeMCBlock;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class SpongeMCLocation implements MCLocation {

	Location<World> loc;
	public SpongeMCLocation(Location<World> location) {
		this.loc = location;
	}

	@Override
	public Location<World> getHandle() {
		return loc;
	}

	public static Vector3d getRotation(MCLocation loc) {
		return new Vector3d(loc.getPitch(), loc.getYaw(), 0);
	}

	@Override
	public double getX() {
		return getHandle().getX();
	}

	@Override
	public double getY() {
		return getHandle().getY();
	}

	@Override
	public double getZ() {
		return getHandle().getZ();
	}

	@Override
	public double distance(MCLocation mcLocation) {
		return Math.sqrt(Math.pow(getHandle().getX() - mcLocation.getX(), 2)
				+ Math.pow(getHandle().getY() - mcLocation.getY(), 2)
				+ Math.pow(getHandle().getZ() - mcLocation.getZ(), 2)
		);
	}

	@Override
	public double distanceSquared(MCLocation mcLocation) {
		return Math.pow(getHandle().getX() - mcLocation.getX(), 2)
				+ Math.pow(getHandle().getY() - mcLocation.getY(), 2)
				+ Math.pow(getHandle().getZ() - mcLocation.getZ(), 2);
	}

	@Override
	public MCWorld getWorld() {
		return null;
	}

	@Override
	public float getYaw() {
		return 0;
	}

	@Override
	public float getPitch() {
		return 0;
	}

	@Override
	public int getBlockX() {
		return getHandle().getBlockX();
	}

	@Override
	public int getBlockY() {
		return getHandle().getBlockY();
	}

	@Override
	public int getBlockZ() {
		return getHandle().getBlockZ();
	}

	@Override
	public MCChunk getChunk() {
		return null;
	}

	@Override
	public MCBlock getBlock()
	{
		return new SpongeMCBlock(getHandle().getBlock());
	}

	@Override
	public MCLocation add(MCLocation mcLocation) {
		return null;
	}

	@Override
	public MCLocation add(Vector3D vector3D) {
		return null;
	}

	@Override
	public MCLocation add(double v, double v1, double v2) {
		return null;
	}

	@Override
	public MCLocation multiply(double v) {
		return null;
	}

	@Override
	public Vector3D toVector() {
		return null;
	}

	@Override
	public MCLocation subtract(MCLocation mcLocation) {
		return null;
	}

	@Override
	public MCLocation subtract(Vector3D vector3D) {
		return null;
	}

	@Override
	public MCLocation subtract(double v, double v1, double v2) {
		return null;
	}

	@Override
	public void setX(double v) {

	}

	@Override
	public void setY(double v) {

	}

	@Override
	public void setZ(double v) {

	}

	@Override
	public void setPitch(float v) {

	}

	@Override
	public void setYaw(float v) {

	}

	@Override
	public void breakBlock() {

	}

	@Override
	public Vector3D getDirection() {
		return null;
	}

	@Override
	public MCLocation clone() {
		return null;
	}
}
