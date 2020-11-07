package com.radioctivetacoo.worldsalad.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class Macrobe extends MonsterEntity implements IAnimatedEntity, IRangedAttackMob {
	private EntityAnimationManager manager = new EntityAnimationManager();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AnimationController controller = new EntityAnimationController(this, "moveController", 20, this::animationPredicate);
	
	public Macrobe(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
		this.experienceValue = 30;
	}

	@Override
	protected boolean canDropLoot() {
		return true;
	}
	
	protected boolean shouldBurnInDay() {
	      return true;
	   }

	@Override
	public boolean isPreventingPlayerRest(PlayerEntity playerIn) {
		return true;
	}

	@Override
	public void livingTick() {
		this.updateArmSwingProgress();
		this.func_213623_ec();
		super.livingTick();
	}
	
	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.ENTITY_HOSTILE_SWIM;
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
		this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.25D, 8, 20.0F));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 30.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(9, new SwimGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(13.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3.5D);
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SLIME_HURT;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return null;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SLIME_DEATH;
	}
	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return super.canDespawn(distanceToClosestPlayer = 100);
	}

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}
	
	private <E extends Macrobe> boolean animationPredicate(AnimationTestEvent<E> event)
	{
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.macrobe.idle", true));
			return true;
	}
	
	private void registerAnimationControllers()
	{
		manager.addAnimationController(controller);
	}

	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
	      ArrowEntity arrowentity = new ArrowEntity(this.world, this);
	      double d0 = target.getPosYEye() - (double)1.1F;
	      double d1 = target.getPosX() - this.getPosX();
	      double d2 = d0 - arrowentity.getPosY();
	      double d3 = target.getPosZ() - this.getPosZ();
	      float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
	      arrowentity.shoot(d1, d2 + (double)f, d3, 1.5F, 13.0F);
	      this.playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	      this.world.addEntity(arrowentity);
	   }
}
