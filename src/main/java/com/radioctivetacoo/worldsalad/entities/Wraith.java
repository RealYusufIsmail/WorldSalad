package com.radioctivetacoo.worldsalad.entities;

import com.radioctivetacoo.worldsalad.init.SoundInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.AnimationController;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class Wraith extends MonsterEntity implements IFlyingAnimal, IAnimatedEntity {
	private EntityAnimationManager manager = new EntityAnimationManager();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private AnimationController controller = new EntityAnimationController(this, "moveController", 20, this::animationPredicate);

	public Wraith(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		registerAnimationControllers();
		this.moveController = new FlyingMovementController(this, 20, true);
		this.experienceValue = 7;
	}

	@Override
	protected boolean canDropLoot() {
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
		if (this.world.isRemote) {
	          for(int i = 0; i < 2; ++i) {
	            this.world.addParticle(ParticleTypes.LARGE_SMOKE, this.getPosXRandom(0.5D), this.getPosYRandom(), this.getPosZRandom(0.5D), 0.0D, 0.0D, 0.0D);
	         }
	      }
		}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return this.isInvulnerableTo(source) ? false : super.attackEntityFrom(source, amount);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4F);
		this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.7F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(4.5D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}

	@Override
	protected PathNavigator createNavigator(World worldIn) {
		FlyingPathNavigator flyingpathnavigator = new FlyingPathNavigator(this, worldIn) {
			@Override
			@SuppressWarnings("deprecation")
			public boolean canEntityStandOnPos(BlockPos pos) {
				return !this.world.getBlockState(pos.down()).isAir();
			}
		};
		flyingpathnavigator.setCanOpenDoors(false);
		flyingpathnavigator.setCanSwim(false);
		flyingpathnavigator.setCanEnterDoors(true);
		return flyingpathnavigator;
	}

	@Override
	@SuppressWarnings("deprecation")
	public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
		return worldIn.getBlockState(pos).isAir() ? 10.0F : 0.0F;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.WRAITH_HURT.get();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.WRAITH_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.WRAITH_DEATH.get();
	}

	public AgeableEntity createChild(AgeableEntity ageable) {
		return null;
	}

	@Override
	protected void updateAITasks() {}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	protected float getSoundVolume() {
		return 0.2F;
	}

	@Override
	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	@Override
	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof LivingEntity) {
				int i = 1;
				int j = 0;
				int k = 0;
				if (this.world.getDifficulty() == Difficulty.NORMAL) {
					i = 2;
					j = 1;
				} else if (this.world.getDifficulty() == Difficulty.HARD) {
					i = 3;
					j = 2;
					k = 1;
				}

				if (i > 0) {
					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.SLOWNESS, i * 15, 6));
					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.WITHER,  j * 30, 0 + k));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isPotionApplicable(EffectInstance potioneffectIn) {
		return potioneffectIn.getPotion() == Effects.WITHER || potioneffectIn.getPotion() == Effects.POISON ? false
				: super.isPotionApplicable(potioneffectIn);
	}
	
	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}
	
	private <E extends Exoskeleton> boolean animationPredicate(AnimationTestEvent<E> event)
	{
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.wraith.idle", true));
			return true;
	}
	
	private void registerAnimationControllers()
	{
		manager.addAnimationController(controller);
	}

}
