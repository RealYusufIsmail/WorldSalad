package com.radioctivetacoo.worldsalad.tileentity;

import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.IncensePlateBlock;

import java.util.List;
 
import javax.annotation.Nullable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;

public class IncensePlateTileEntity extends TileEntity implements ITickableTileEntity {
	private List<LivingEntity> playersInRange;

	public IncensePlateTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public IncensePlateTileEntity() {
		this(TileEntityInit.INCENSE_PLATE.get());
	}
	
	private void effect(LivingEntity entityIn) {
		if (this.world.getBlockState(this.getPos()).equals(BlockInit.INCENSE_PLATE.get().getDefaultState().with(IncensePlateBlock.STICK_TYPE, 2).with(IncensePlateBlock.HAS_STICK, true).with(IncensePlateBlock.LIT, true)))
		{
			entityIn.addPotionEffect(new EffectInstance(Effects.REGENERATION, 60));
		}
		else if (this.world.getBlockState(this.getPos()).equals(BlockInit.INCENSE_PLATE.get().getDefaultState().with(IncensePlateBlock.STICK_TYPE, 3).with(IncensePlateBlock.HAS_STICK, true).with(IncensePlateBlock.LIT, true)))
		{
			entityIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 60));
		}
		else if (this.world.getBlockState(this.getPos()).equals(BlockInit.INCENSE_PLATE.get().getDefaultState().with(IncensePlateBlock.STICK_TYPE, 4).with(IncensePlateBlock.HAS_STICK, true).with(IncensePlateBlock.LIT, true)))
		{
			entityIn.addPotionEffect(new EffectInstance(Effects.SPEED, 60));
		}
		else if (this.world.getBlockState(this.getPos()).equals(BlockInit.INCENSE_PLATE.get().getDefaultState().with(IncensePlateBlock.STICK_TYPE, 5).with(IncensePlateBlock.HAS_STICK, true).with(IncensePlateBlock.LIT, true)))
		{
			entityIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 60));
		}
		else if (this.world.getBlockState(this.getPos()).equals(BlockInit.INCENSE_PLATE.get().getDefaultState().with(IncensePlateBlock.STICK_TYPE, 6).with(IncensePlateBlock.HAS_STICK, true).with(IncensePlateBlock.LIT, true)))
		{
			entityIn.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 60));
		}
		else if (this.world.getBlockState(this.getPos()).equals(BlockInit.INCENSE_PLATE.get().getDefaultState().with(IncensePlateBlock.STICK_TYPE, 7).with(IncensePlateBlock.HAS_STICK, true).with(IncensePlateBlock.LIT, true)))
		{
			entityIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 60));
		}
	}

	@Override
	public void tick() {
		boolean dirty = false;
		if (this.world != null && !this.world.isRemote) {
					BlockPos blockpos = this.getPos();
					AxisAlignedBB axisalignedbb = (new AxisAlignedBB(blockpos)).grow(15.0D);
					this.playersInRange = world.getEntitiesWithinAABB(LivingEntity.class, axisalignedbb);
					this.playersInRange.stream().filter(LivingEntity -> (LivingEntity instanceof PlayerEntity) || (LivingEntity instanceof WolfEntity)).forEach(this::effect);
				
				if (dirty) {
					this.markDirty();
					this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
			}
		}
	}

	@Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbt = new CompoundNBT();
		this.write(nbt);
		return new SUpdateTileEntityPacket(this.pos, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.read(pkt.getNbtCompound());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbt = new CompoundNBT();
		this.write(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundNBT nbt) {
		this.read(nbt);
	}
}
