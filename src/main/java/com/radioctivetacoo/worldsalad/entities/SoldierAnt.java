package com.radioctivetacoo.worldsalad.entities;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class SoldierAnt extends CreatureEntity implements IAnimatedEntity {
	@SuppressWarnings("unused")
	private UUID angerTargetUUID;
	private EntityAnimationManager manager = new EntityAnimationManager();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AnimationController controller = new EntityAnimationController(this, "moveController", 20, this::animationPredicate);
	
	public SoldierAnt(EntityType<? extends CreatureEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
		this.experienceValue = 6;
	}

	@Override
	protected boolean canDropLoot() {
		return true;
	}
	
	public void setRevengeTarget(@Nullable LivingEntity livingBase) {
	      super.setRevengeTarget(livingBase);
	      if (livingBase != null) {
	         this.angerTargetUUID = livingBase.getUniqueID();
	      }

	   }

	@Override
	public void livingTick() {
		this.updateArmSwingProgress();
		super.livingTick();
	}
	
	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.ENTITY_HOSTILE_SWIM;
	}
	
	@Override
	protected boolean isDespawnPeaceful() {
		return false;
	}

	@Override
	protected SoundEvent getSplashSound() {
		return SoundEvents.ENTITY_HOSTILE_SPLASH;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return this.isInvulnerableTo(source) ? false : super.attackEntityFrom(source, amount);
	}

	@Override
	protected SoundEvent getFallSound(int heightIn) {
		return heightIn > 4 ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(12, new LookAtGoal(this, SoldierAnt.class, 3.0F));
		this.goalSelector.addGoal(10, new LookAtGoal(this, TraderAnt.class, 3.0F));
		this.goalSelector.addGoal(11, new LookAtGoal(this, WorkerAnt.class, 3.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(9, new SwimGoal(this));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Exoskeleton.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, CordycepsAnt.class, true));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.targetSelector.addGoal(7, (new HurtByTargetGoal(this)));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.327F);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
		this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SPIDER_HURT;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SPIDER_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SPIDER_DEATH;
	}
	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}
	
	@SuppressWarnings("unchecked")
	private <E extends SoldierAnt> boolean animationPredicate(AnimationTestEvent<E> event)
	{
		if(event.isWalking())
		{
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.exoskeleton.walking", true));
			controller.transitionLengthTicks = 0; 
			return true;
		} else {
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.exoskeleton.idle", true));
			controller.transitionLengthTicks = 0;
			return true;
		}
	}
	
	private void registerAnimationControllers()
	{
		manager.addAnimationController(controller);
	}
}
