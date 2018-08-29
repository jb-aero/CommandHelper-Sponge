package com.laytonsmith.abstraction.sponge.entities;

import com.laytonsmith.PureUtilities.Vector3D;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCEntityEquipment;
import com.laytonsmith.abstraction.MCLivingEntity;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.blocks.MCBlock;
import com.laytonsmith.abstraction.blocks.MCMaterial;
import com.laytonsmith.abstraction.entities.MCProjectile;
import com.laytonsmith.abstraction.enums.MCPotionEffectType;
import com.laytonsmith.abstraction.enums.MCProjectileType;
import com.laytonsmith.core.constructs.Target;
import org.spongepowered.api.entity.living.Living;

import java.util.HashSet;
import java.util.List;

public class SpongeMCLiving extends SpongeMCEntity implements MCLivingEntity {

	Living ent;
	public SpongeMCLiving(Living entity) {
		super(entity);
		this.ent = entity;
	}

	@Override
	public Living getHandle() {
		return ent;
	}

	@Override
	public boolean addEffect(MCPotionEffectType type, int strength, int ticks, boolean ambient, boolean particles, boolean icon)
	{
		return false;
	}

	@Override
	public boolean removeEffect(MCPotionEffectType type)
	{
		return false;
	}

	@Override
	public void removeEffects()
	{

	}

	@Override
	public List<MCEffect> getEffects() {
		return null;
	}

	@Override
	public void damage(double v) {

	}

	@Override
	public void damage(double v, MCEntity mcEntity) {

	}

	@Override
	public boolean getCanPickupItems() {
		return false;
	}

	@Override
	public boolean getRemoveWhenFarAway() {
		return false;
	}

	@Override
	public MCEntityEquipment getEquipment() {
		return null;
	}

	@Override
	public double getEyeHeight() {
		return 0;
	}

	@Override
	public double getEyeHeight(boolean b) {
		return 0;
	}

	@Override
	public MCLocation getEyeLocation() {
		return null;
	}

	@Override
	public double getHealth() {
		return getHandle().health().get();
	}

	@Override
	public MCPlayer getKiller() {
		return null;
	}

	@Override
	public double getLastDamage() {
		return 0;
	}

	@Override
	public MCEntity getLeashHolder() {
		return null;
	}

	@Override
	public MCLivingEntity getTarget(Target target) {
		return null;
	}

	@Override
	public MCBlock getTargetBlock(HashSet<MCMaterial> transparent, int maxDistance)
	{
		return null;
	}

	@Override
	public MCBlock getTargetSpace(int maxDistance)
	{
		return null;
	}

	@Override
	public List<MCBlock> getLineOfSight(HashSet<MCMaterial> transparent, int maxDistance)
	{
		return null;
	}

	@Override
	public boolean hasLineOfSight(MCEntity mcEntity) {
		return false;
	}

	@Override
	public double getMaxHealth() {
		return getHandle().maxHealth().get();
	}

	@Override
	public int getMaximumAir() {
		return 0;
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return 0;
	}

	@Override
	public int getNoDamageTicks() {
		return 0;
	}

	@Override
	public int getRemainingAir() {
		return 0;
	}

	@Override
	public boolean isGliding() {
		return false;
	}

	@Override
	public boolean isLeashed() {
		return false;
	}

	@Override
	public boolean hasAI() {
		return false;
	}

	@Override
	public void resetMaxHealth() {

	}

	@Override
	public void setCanPickupItems(boolean b) {

	}

	@Override
	public void setRemoveWhenFarAway(boolean b) {

	}

	@Override
	public void setHealth(double v) {
		getHandle().health().set(v);
	}

	@Override
	public void setLastDamage(double v) {

	}

	@Override
	public void setLeashHolder(MCEntity mcEntity) {

	}

	@Override
	public void setMaxHealth(double v) {

	}

	@Override
	public void setMaximumAir(int i) {

	}

	@Override
	public void setMaximumNoDamageTicks(int i) {

	}

	@Override
	public void setNoDamageTicks(int i) {

	}

	@Override
	public void setRemainingAir(int i) {

	}

	@Override
	public void setTarget(MCLivingEntity mcLivingEntity, Target target) {

	}

	@Override
	public void setGliding(Boolean aBoolean) {

	}

	@Override
	public void setAI(Boolean aBoolean) {

	}

	@Override
	public boolean isCollidable()
	{
		return false;
	}

	@Override
	public void setCollidable(boolean collidable)
	{

	}

	@Override
	public void kill() {

	}

	@Override
	public MCProjectile launchProjectile(MCProjectileType mcProjectileType) {
		return null;
	}

	@Override
	public MCProjectile launchProjectile(MCProjectileType mcProjectileType, Vector3D vector3D) {
		return null;
	}
}
