package com.radioctivetacoo.worldsalad.entities;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class FungalZombie extends ZombieEntity implements IAnimatable {

	private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.createKey(ZombieEntity.class, DataSerializers.BOOLEAN);
	private AnimationFactory manager = new AnimationFactory(this);

	
	public FungalZombie(EntityType<? extends ZombieEntity> type, World worldIn) {
		super(type, worldIn);
		this.experienceValue = 6;
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.5D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}
	
	public void notifyDataManagerChange(DataParameter<?> key) {
	      if (IS_CHILD.equals(key)) {
	         this.recalculateSize();
	      }

	      super.notifyDataManagerChange(key);
	   }
	protected void registerData() {
	      super.registerData();
	      this.getDataManager().register(IS_CHILD, false);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
	      return this.isChild() ? 0.93F : 1.74F;
	   }
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new SwimGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, TraderAnt.class, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SoldierAnt.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, WorkerAnt.class, true));
		this.goalSelector.addGoal(2, new ZombieAttackGoal(this, 1.0D, false));
	}
	
	@Override
	public AnimationFactory getFactory() {
		return manager;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}
	
	@SuppressWarnings("unchecked")
	private <E extends Exoskeleton> PlayState predicate(AnimationEvent<E> event)
	{
		if(event.isMoving())
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.fungal_zombie.walking", true));
			event.getController().transitionLengthTicks = 0; 
			return PlayState.CONTINUE;
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.fungal_zombie.idle", true));
			event.getController().transitionLengthTicks = 0;
			return PlayState.CONTINUE;
		}
	}
}
