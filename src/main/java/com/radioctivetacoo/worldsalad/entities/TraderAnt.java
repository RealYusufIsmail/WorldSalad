package com.radioctivetacoo.worldsalad.entities;

import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class TraderAnt extends AbstractAntEntity implements IAnimatable {
	private AnimationFactory manager = new AnimationFactory(this);
	private int tradeCooldown;
	
	public TraderAnt(EntityType<? extends CreatureEntity> type, World worldIn) {
		super(type, worldIn);
		this.experienceValue = 6;
	}
	
	protected boolean canTrade()
	{
		return this.tradeCooldown <= 0;
	}

	@Override
	protected boolean canDropLoot() {
		return true;
	}

	@Override
	public void livingTick() {
		this.updateArmSwingProgress();
		super.livingTick();
		if (!this.canTrade())
		{
			this.tradeCooldown--;
		}
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(12, new LookAtGoal(this, SoldierAnt.class, 3.0F));
		this.goalSelector.addGoal(11, new LookAtGoal(this, TraderAnt.class, 3.0F));
		this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new SwimGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new AvoidEntityGoal(this, Exoskeleton.class, 24.0F, 1D, 1.5D));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, AbstractAntEntity.class)).setCallsForHelp());
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25F);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
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
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
	      ItemStack itemstack = player.getHeldItem(hand);
	      if (this.canTrade())
	      {
	      if (itemstack.getItem().equals(ItemInit.AMBER.get())) {
	    	  	itemstack.shrink(1);
	    	 	double d0 = this.rand.nextGaussian() * 0.02D;
	         	double d1 = this.rand.nextGaussian() * 0.02D;
	         	double d2 = this.rand.nextGaussian() * 0.02D;
	         	for(int i = 0; i < 8; ++i) {
	        	 this.world.addParticle(ParticleTypes.COMPOSTER, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), d0, d1, d2);
	         	}
	         	int generator = this.rand.nextInt(66);
       			if (generator <= 10) {
       				for(int i = 0; i < 32; ++i) {
       				 this.entityDropItem(BlockInit.ADOBE_BLOCK.get(), 1);
       				}
                }
       			if (generator > 10 && generator <= 20) {
       				for(int i = 0; i < 32; ++i) {
          			 this.entityDropItem(BlockInit.MOLDY_HYPHAE_COBBLESTONE.get(), 1);
          			}
       			}
       			if (generator > 20 && generator <= 30) {
   	        	 this.entityDropItem(ItemInit.CHITIN_SHARD.get(), 1);
   	         	}
   	         	if (generator > 30 && generator <= 37) {
   	        	 this.entityDropItem(ItemInit.LUMEN_ESSENCE.get(), 1);
   	         	}
          		if (generator > 37 && generator <= 45) {
          		 this.entityDropItem(ItemInit.ECTOPLASM.get(), 1);
          		}
          		if (generator > 45 && generator <= 48) {
             	 this.entityDropItem(ItemInit.ACID_BUCKET.get(), 1);
                }
       			if (generator > 48 && generator <= 50) {
       			 this.entityDropItem(ItemInit.ESSENCE_CRYSTAL.get(), 1);
          		}
       			if (generator > 50 && generator <= 55) {
       				for(int i = 0; i < 4; ++i) {
       				 this.entityDropItem(ItemInit.SPORE_QUARTZ.get(), 1);
       				}
             	}
       			if (generator > 56 && generator <= 65) {
       			 this.entityDropItem(ItemInit.EARTHWORMS.get(), 1);
             	}
	         	this.tradeCooldown = 100;
	         	return super.processInteract(player, hand);
	      	}
	      if (itemstack.getItem().equals(ItemInit.AMBER_DROPLET.get())) {
	    	  	itemstack.shrink(1);
	    	 	double d0 = this.rand.nextGaussian() * 0.02D;
	         	double d1 = this.rand.nextGaussian() * 0.02D;
	         	double d2 = this.rand.nextGaussian() * 0.02D;
	         	for(int i = 0; i < 3; ++i) {
	        	 this.world.addParticle(ParticleTypes.COMPOSTER, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), d0, d1, d2);
	         	}
	         	int generator = this.rand.nextInt(2);
     			if (generator == 0) {
     			for(int i = 0; i < 6; ++i) {
     				 this.entityDropItem(BlockInit.ADOBE_BLOCK.get(), 1);
     				}
              }
     			if (generator == 1) {
     			for(int i = 0; i < 6; ++i) {
        			 this.entityDropItem(BlockInit.MOLDY_HYPHAE_COBBLESTONE.get(), 1);
        			}
	         	this.tradeCooldown = 10;
	         	return super.processInteract(player, hand);
	      	}
	      }
	   }
	      return super.processInteract(player, hand);
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
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.exoskeleton.walking", true));
			event.getController().transitionLengthTicks = 0; 
			return PlayState.CONTINUE;
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.exoskeleton.idle", true));
			event.getController().transitionLengthTicks = 0;
			return PlayState.CONTINUE;
		}
	}
}
