package com.radioctivetacoo.worldsalad.entities;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class InfectedQueen extends MonsterEntity implements IAnimatable {
	private AnimationFactory manager = new AnimationFactory(this);
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(InfectedQueen.class, DataSerializers.BYTE);
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenSky(false);
	
	public InfectedQueen(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		this.experienceValue = 20;
	}
	
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
	
	public void addTrackingPlayer(ServerPlayerEntity player) {
	      super.addTrackingPlayer(player);
	      this.bossInfo.addPlayer(player);
	   }
	
	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.ARTHROPOD;
	}
	
	public void removeTrackingPlayer(ServerPlayerEntity player) {
	      super.removeTrackingPlayer(player);
	      this.bossInfo.removePlayer(player);
	   }
	
	@Override
	 public boolean isNonBoss() {
	      return false;
	   }
	
	protected PathNavigator createNavigator(World worldIn) {
	      return new ClimberPathNavigator(this, worldIn);
	   }

	protected void registerData() {
	      super.registerData();
	      this.dataManager.register(CLIMBING, (byte)0);
	   }
	
	public boolean isBesideClimbableBlock() {
	      return (this.dataManager.get(CLIMBING) & 1) != 0;
	   }
	
	public boolean isOnLadder() {
	      return this.isBesideClimbableBlock();
	   }
	
	public void setMotionMultiplier(BlockState state, Vec3d motionMultiplierIn) {
	      if (state.getBlock() != Blocks.COBWEB) {
	         super.setMotionMultiplier(state, motionMultiplierIn);
	      }

	   }
	   
	public void setBesideClimbableBlock(boolean climbing) {
		      byte b0 = this.dataManager.get(CLIMBING);
		      if (climbing) {
		         b0 = (byte)(b0 | 1);
		      } else {
		         b0 = (byte)(b0 & -2);
		      }

		      this.dataManager.set(CLIMBING, b0);
		   }
	   
	public void tick() {
		      super.tick();
		      if (!this.world.isRemote) {
		         this.setBesideClimbableBlock(this.collidedHorizontally);
		      }

		   }

	@Override
	protected boolean canDropLoot() {
		return true;
	}
	
	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
	      super.dropSpecialItems(source, looting, recentlyHitIn);
	      ItemEntity itementity = this.entityDropItem(ItemInit.PLATED_KEY_PIECE.get());
	      if (itementity != null) {
	         itementity.setNoDespawn();
	      }
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
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new SwimGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, TraderAnt.class, true));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SoldierAnt.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, WorkerAnt.class, true));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(80.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.39F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
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
		return super.canDespawn(distanceToClosestPlayer = 40);
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
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof LivingEntity) {
				int j = 0;
				if (this.world.getDifficulty() == Difficulty.NORMAL) {
					j = 0;
				} else if (this.world.getDifficulty() == Difficulty.HARD) {
					j = 1;
				}

				if (j >= 0) {
					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.POISON, 200, 0 + j));
				}
			}

			return true;
		} else {
			return false;
		}
	}
}
