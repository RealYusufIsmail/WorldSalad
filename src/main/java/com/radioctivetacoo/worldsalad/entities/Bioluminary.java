package com.radioctivetacoo.worldsalad.entities;

import java.util.EnumSet;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Bioluminary extends MonsterEntity implements IAnimatable {
	private LivingEntity targetedEntity;
	private int clientSideAttackTime;
	private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.createKey(Bioluminary.class,
			DataSerializers.VARINT);
	private AnimationFactory factory = new AnimationFactory(this);

	static class TargetPredicate implements Predicate<LivingEntity> {
		private final Bioluminary parentEntity;

		public TargetPredicate(Bioluminary bioluminary) {
			this.parentEntity = bioluminary;
		}

		public boolean test(@Nullable LivingEntity p_test_1_) {
			return (p_test_1_ instanceof PlayerEntity) && p_test_1_.getDistanceSq(this.parentEntity) > 9.0D;
		}
	}
	
	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.ARTHROPOD;
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(TARGET_ENTITY, 0);
	}

	private void setTargetedEntity(int entityId) {
		this.dataManager.set(TARGET_ENTITY, entityId);
	}

	public boolean hasTargetedEntity() {
		return this.dataManager.get(TARGET_ENTITY) != 0;
	}

	public void notifyDataManagerChange(DataParameter<?> key) {
		super.notifyDataManagerChange(key);
		if (TARGET_ENTITY.equals(key)) {
			this.clientSideAttackTime = 0;
			this.targetedEntity = null;
		}

	}

	public int getAttackDuration() {
		return 10;
	}

	public void livingTick() {
		if (this.isAlive()) {
			if (this.world.isRemote) {
				if (this.hasTargetedEntity()) {
					if (this.clientSideAttackTime < this.getAttackDuration()) {
						++this.clientSideAttackTime;
					}

					LivingEntity livingentity = this.getTargetedEntity();
					if (livingentity != null) {
						this.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 90.0F);
						this.getLookController().tick();
						double d5 = (double) this.getAttackAnimationScale(0.0F);
						double d0 = livingentity.getPosX() - this.getPosX();
						double d1 = livingentity.getPosYHeight(0.5D) - this.getPosYEye();
						double d2 = livingentity.getPosZ() - this.getPosZ();
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						double d4 = this.rand.nextDouble();

						while (d4 < d3) {
							d4 += 1.8D - d5 + this.rand.nextDouble() * (1.7D - d5);
							this.world.addParticle(ParticleTypes.END_ROD, this.getPosX() + d0 * d4,
									this.getPosYEye() + d1 * d4, this.getPosZ() + d2 * d4, 0.0D, 0.0D, 0.0D);
							this.world.addParticle(ParticleTypes.END_ROD, this.getPosX() + d0 * d4,
									this.getPosYEye() + d1 * d4, this.getPosZ() + d2 * d4, 0.0D, 0.0D, 0.0D);
							this.world.addParticle(ParticleTypes.END_ROD, this.getPosX() + d0 * d4,
									this.getPosYEye() + d1 * d4, this.getPosZ() + d2 * d4, 0.0D, 0.0D, 0.0D);
							this.world.addParticle(ParticleTypes.COMPOSTER, this.getPosX() + d0 * d4,
									this.getPosYEye() + d1 * d4, this.getPosZ() + d2 * d4, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			}

			if (this.hasTargetedEntity()) {
				this.rotationYaw = this.rotationYawHead;
			}
		}

		super.livingTick();
	}

	public float getAttackAnimationScale(float p_175477_1_) {
		return ((float) this.clientSideAttackTime + p_175477_1_) / (float) this.getAttackDuration();
	}

	public LivingEntity getTargetedEntity() {
		if (!this.hasTargetedEntity()) {
			return null;
		} else if (this.world.isRemote) {
			if (this.targetedEntity != null) {
				return this.targetedEntity;
			} else {
				Entity entity = this.world.getEntityByID(this.dataManager.get(TARGET_ENTITY));
				if (entity instanceof LivingEntity) {
					this.targetedEntity = (LivingEntity) entity;
					return this.targetedEntity;
				} else {
					return null;
				}
			}
		} else {
			return this.getAttackTarget();
		}
	}
	
	static class AttackGoal extends Goal {
	      private final Bioluminary bioluminary;
	      private int tickCounter;

	      public AttackGoal(Bioluminary bioluminary) {
	         this.bioluminary = bioluminary;
	         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	      }

	      public boolean shouldExecute() {
	         LivingEntity livingentity = this.bioluminary.getAttackTarget();
	         return livingentity != null && livingentity.isAlive();
	      }

	      public boolean shouldContinueExecuting() {
	         return super.shouldContinueExecuting() && (this.bioluminary.getDistanceSq(this.bioluminary.getAttackTarget()) > 9.0D);
	      }

	      public void startExecuting() {
	         this.tickCounter = -10;
	         this.bioluminary.getNavigator().clearPath();
	         this.bioluminary.getLookController().setLookPositionWithEntity(this.bioluminary.getAttackTarget(), 90.0F, 90.0F);
	         this.bioluminary.isAirBorne = true;
	      }

	      public void resetTask() {
	         this.bioluminary.setTargetedEntity(0);
	         this.bioluminary.setAttackTarget((LivingEntity)null);
	      }

	      public void tick() {
	         LivingEntity livingentity = this.bioluminary.getAttackTarget();
	         this.bioluminary.getNavigator().clearPath();
	         this.bioluminary.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 90.0F);
	         if (!this.bioluminary.canEntityBeSeen(livingentity)) {
	            this.bioluminary.setAttackTarget((LivingEntity)null);
	         } else {
	            ++this.tickCounter;
	            if (this.tickCounter == 0) {
	               this.bioluminary.setTargetedEntity(this.bioluminary.getAttackTarget().getEntityId());
	               this.bioluminary.world.setEntityState(this.bioluminary, (byte)21);
	            } else if (this.tickCounter >= this.bioluminary.getAttackDuration()) {
	               float f = 1.0F;
	               if (this.bioluminary.world.getDifficulty() == Difficulty.HARD) {
	                  f += 2.0F;
	               }

	               livingentity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this.bioluminary, this.bioluminary), f);
	               livingentity.attackEntityFrom(DamageSource.causeMobDamage(this.bioluminary), (float)this.bioluminary.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());
	               this.bioluminary.setAttackTarget((LivingEntity)null);
	            }

	            super.tick();
	         }
	      }
	   }

	public Bioluminary(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		this.experienceValue = 6;
	}

	@Override
	protected boolean canDropLoot() {
		return true;
	}

	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.ENTITY_GENERIC_SWIM;
	}

	@Override
	protected boolean isDespawnPeaceful() {
		return false;
	}

	@Override
	protected SoundEvent getSplashSound() {
		return SoundEvents.ENTITY_GENERIC_SPLASH;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		return this.isInvulnerableTo(source) ? false : super.attackEntityFrom(source, amount);
	}

	@Override
	protected SoundEvent getFallSound(int heightIn) {
		return heightIn > 4 ? SoundEvents.ENTITY_GENERIC_BIG_FALL : SoundEvents.ENTITY_GENERIC_SMALL_FALL;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(12, new LookAtGoal(this, Bioluminary.class, 3.0F));
		this.goalSelector.addGoal(11, new LookAtGoal(this, TraderAnt.class, 3.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new SwimGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(4, new Bioluminary.AttackGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false,
				new Bioluminary.TargetPredicate(this)));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45F);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(45.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_GENERIC_HURT;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return null;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return null;
	}

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return true;
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@SuppressWarnings("unchecked")
	private <E extends Bioluminary> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bioluminary.walk", true));
			event.getController().transitionLengthTicks = 0;
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bioluminary.constant", true));
		event.getController().transitionLengthTicks = 0;
		return PlayState.CONTINUE;
	}
}
