package com.radioctivetacoo.worldsalad.entities;

import java.util.EnumSet;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.radioctivetacoo.worldsalad.init.EffectInit;
import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BioluminescentHorror extends MonsterEntity implements IAnimatable, IFlyingAnimal {
	private LivingEntity targetedEntity;
	private int clientSideAttackTime;
	private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.createKey(BioluminescentHorror.class,
			DataSerializers.VARINT);
	private AnimationFactory factory = new AnimationFactory(this);
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS)).setDarkenSky(false);
	
	public BioluminescentHorror(EntityType<? extends MonsterEntity> type, World worldIn) {
		super(type, worldIn);
		this.setHealth(this.getMaxHealth());
		this.experienceValue = 60;
		this.moveController = new FlyingMovementController(this, 20, true);
		this.func_213623_ec();
	}
	
	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
	      super.dropSpecialItems(source, looting, recentlyHitIn);
	      ItemEntity itementity = this.entityDropItem(ItemInit.LUMINANT_KEY_PIECE.get());
	      if (itementity != null) {
	         itementity.setNoDespawn();
	      }

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

	static class TargetPredicate implements Predicate<LivingEntity> {
		private final BioluminescentHorror parentEntity;

		public TargetPredicate(BioluminescentHorror bioHorror) {
			this.parentEntity = bioHorror;
		}

		public boolean test(@Nullable LivingEntity p_test_1_) {
			return (p_test_1_ instanceof PlayerEntity) && p_test_1_.getDistanceSq(this.parentEntity) > 9.0D;
		}
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
		return 60;
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
	      private final BioluminescentHorror bioHorror;
	      private int tickCounter;

	      public AttackGoal(BioluminescentHorror bioHorror) {
	         this.bioHorror = bioHorror;
	         this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	      }

	      public boolean shouldExecute() {
	         LivingEntity livingentity = this.bioHorror.getAttackTarget();
	         return livingentity != null && livingentity.isAlive();
	      }

	      public boolean shouldContinueExecuting() {
	         return super.shouldContinueExecuting() && (this.bioHorror.getDistanceSq(this.bioHorror.getAttackTarget()) > 3.0D);
	      }

	      public void startExecuting() {
	         this.tickCounter = -10;
	         this.bioHorror.getNavigator().clearPath();
	         this.bioHorror.getLookController().setLookPositionWithEntity(this.bioHorror.getAttackTarget(), 90.0F, 90.0F);
	         this.bioHorror.isAirBorne = false;
	      }

	      public void resetTask() {
	         this.bioHorror.setTargetedEntity(0);
	         this.bioHorror.setAttackTarget((LivingEntity)null);
	      }

	      public void tick() {
	         LivingEntity livingentity = this.bioHorror.getAttackTarget();
	         this.bioHorror.getNavigator().clearPath();
	         this.bioHorror.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 90.0F);
	         if (!this.bioHorror.canEntityBeSeen(livingentity)) {
	            this.bioHorror.setAttackTarget((LivingEntity)null);
	         } else {
	            ++this.tickCounter;
	            if (this.tickCounter == 0) {
	               this.bioHorror.setTargetedEntity(this.bioHorror.getAttackTarget().getEntityId());
	               this.bioHorror.world.setEntityState(this.bioHorror, (byte)21);
	            } else if (this.tickCounter >= this.bioHorror.getAttackDuration()) {
	               float f = 1.0F;
	               if (this.bioHorror.world.getDifficulty() == Difficulty.HARD) {
	                  f += 2.0F;
	               }

	               livingentity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this.bioHorror, this.bioHorror), f);
	               livingentity.attackEntityFrom(DamageSource.causeMobDamage(this.bioHorror), (float)this.bioHorror.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());
	               this.bioHorror.setAttackTarget((LivingEntity)null);
	            }

	            super.tick();
	         }
	      }
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
		return true;
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
		this.goalSelector.addGoal(12, new LookAtGoal(this, PlayerEntity.class, 3.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new SwimGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(4, new BioluminescentHorror.AttackGoal(this));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, true,
				new BioluminescentHorror.TargetPredicate(this)));
	}
	
	@Override
	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(180.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45F);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(1.4F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
	}
	
	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof LivingEntity) {
				int i = 1;
				if (this.world.getDifficulty() == Difficulty.NORMAL) {
					i = 2;
				} else if (this.world.getDifficulty() == Difficulty.HARD) {
					i = 4;
				}

				if (i > 0) {
					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(Effects.GLOWING, i * 40, 0));
					((LivingEntity) entityIn).addPotionEffect(new EffectInstance(EffectInit.ACID.get(), i * 10, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}
	
	@Override
	 public boolean isNonBoss() {
	      return false;
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
	
	public void removeTrackingPlayer(ServerPlayerEntity player) {
	      super.removeTrackingPlayer(player);
	      this.bossInfo.removePlayer(player);
	   }
	
	@Override
	public boolean isPotionApplicable(EffectInstance potioneffectIn) {
		return false;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
		return worldIn.getBlockState(pos).isAir() ? 10.0F : 0.0F;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_IRON_GOLEM_HURT;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_BEE_LOOP;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
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
	private <E extends BioluminescentHorror> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bioluminescent_horror.idle", true));
		event.getController().transitionLengthTicks = 0;
		return PlayState.CONTINUE;
	}
}
