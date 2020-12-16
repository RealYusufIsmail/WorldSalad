package com.radioctivetacoo.worldsalad.entities;

import java.util.UUID;

import javax.annotation.Nullable;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Dragonfly extends CreatureEntity implements IAnimatable {
	@SuppressWarnings("unused")
	private UUID angerTargetUUID;
	private AnimationFactory manager = new AnimationFactory(this);
	//for variants, 0=blue, 1=red, 2=green, 3=pink, 4=white, 5=white, 6=gold
	private static final DataParameter<Integer> VARIANT = EntityDataManager.createKey(Dragonfly.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> SADDLED = EntityDataManager.createKey(Dragonfly.class, DataSerializers.BOOLEAN);


	public Dragonfly(EntityType<? extends CreatureEntity> type, World worldIn) {
		super(type, worldIn);
		this.experienceValue = 6;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	public boolean processInteract(PlayerEntity player, Hand hand) {
		if (super.processInteract(player, hand)) {
			return true;
		} else {
			ItemStack itemstack = player.getHeldItem(hand);
			if (itemstack.getItem() == Items.NAME_TAG) {
				itemstack.interactWithEntity(player, this, hand);
				return true;
			} else if (this.getSaddled() && !this.isBeingRidden()) {
				if (!this.world.isRemote) {
					player.startRiding(this);
				}

				return true;
			} else {
				return itemstack.getItem() == ItemInit.DRAGONFLY_SADDLE.get()
						&& itemstack.interactWithEntity(player, this, hand);
			}
		}
	}

	protected void dropInventory() {
		super.dropInventory();
		if (this.getSaddled()) {
			this.entityDropItem(ItemInit.DRAGONFLY_SADDLE.get());
		}

	}
	
	public void setSaddled(boolean saddled) {
		if (saddled) {
			this.dataManager.set(SADDLED, true);
		} else {
			this.dataManager.set(SADDLED, false);
		}

	}

	public boolean getSaddled() {
		return this.dataManager.get(SADDLED);
	}
	
	public void setVariant(int variant) {
		if (variant == 0)
		{
		this.dataManager.set(VARIANT, 0);
		}
		else if (variant == 1)
		{
		this.dataManager.set(VARIANT, 1);
		}
		else if (variant == 2)
		{
		this.dataManager.set(VARIANT, 2);
		}
		else if (variant == 3)
		{
		this.dataManager.set(VARIANT, 3);
		}
		else if (variant == 4)
		{
		this.dataManager.set(VARIANT, 4);
		}
		else if (variant == 5)
		{
		this.dataManager.set(VARIANT, 5);
		}
		else if (variant == 6)
		{
		this.dataManager.set(VARIANT, 6);
		}
	}

	public int getVariant() {
		return this.dataManager.get(VARIANT);
	}
	
	@Nullable
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		int i = rand.nextInt(19);
		if (i >= 0 && i <= 3) {
			setVariant(0);
		}
		if (i >= 2 && i <= 5) {
			setVariant(1);
		}
		if (i >= 6 && i <= 9) {
			setVariant(2);
		}
		if (i >= 10 && i <= 13) {
			setVariant(3);
		}
		if (i == 14 || i == 15) {
			setVariant(4);
		}
		if (i == 16 || i == 17) {
			setVariant(5);
		}
		if (i == 18) {
			setVariant(6);
		}
		return spawnDataIn;
	}

	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();
		if (!(entity instanceof PlayerEntity)) {
			return false;
		} else {
			return true;
		}
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("Variant", this.getVariant());
		compound.putBoolean("Saddle", this.getSaddled());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setVariant(compound.getInt("Variant"));
		this.setSaddled(compound.getBoolean("Saddle"));
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(VARIANT, null);
		this.dataManager.register(SADDLED, false);
	}

	public void travel(Vec3d positionIn) {
		if (this.isAlive()) {
			Entity entity = this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
			if (this.isBeingRidden() && this.canBeSteered()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.renderYawOffset = this.rotationYaw;
				this.rotationYawHead = this.rotationYaw;
				this.stepHeight = 1.0F;
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

				if (this.canPassengerSteer()) {
					float f = (float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue();

					this.setAIMoveSpeed(f);
					super.travel(new Vec3d(0.0D, 0.0D, 1.0D));
					this.newPosRotationIncrements = 0;
				} else {
					this.setMotion(Vec3d.ZERO);
				}

				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.getPosX() - this.prevPosX;
				double d0 = this.getPosZ() - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F) {
					f1 = 1.0F;
				}

				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
			} else {
				this.stepHeight = 0.5F;
				this.jumpMovementFactor = 0.02F;
				super.travel(positionIn);
			}
		}
	}

	@Override
	protected boolean canDropLoot() {
		return true;
	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	@Override
	public void livingTick() {
		this.updateArmSwingProgress();
		super.livingTick();
		Vec3d vec3d = this.getMotion();
		if (!this.onGround && vec3d.y < 0.0D) {
	         this.setMotion(vec3d.mul(1.0D, 0.6D, 1.0D));
	      }
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
		this.goalSelector.addGoal(12, new LookAtGoal(this, Dragonfly.class, 3.0F));
		this.goalSelector.addGoal(11, new LookAtGoal(this, TraderAnt.class, 3.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new SwimGoal(this));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4F);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
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
		if(!this.onGround)
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dragonfly.flying", true));
			event.getController().transitionLengthTicks = 0; 
			return PlayState.CONTINUE;
		} else if (event.isMoving()){
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.exoskeleton.walk", true));
			event.getController().transitionLengthTicks = 0;
			return PlayState.CONTINUE;
		}
		  else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dragonfly.idle", true));
			event.getController().transitionLengthTicks = 0;
			return PlayState.CONTINUE;
		}
	}
}
