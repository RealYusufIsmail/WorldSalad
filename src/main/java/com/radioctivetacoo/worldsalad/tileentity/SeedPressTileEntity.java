package com.radioctivetacoo.worldsalad.tileentity;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.SeedPressContainer;
import com.radioctivetacoo.worldsalad.init.ItemInit;
import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.util.WorldSaladItemHandler;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class SeedPressTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	private ITextComponent customName;
	public int fluidAmount = 0;
	public int fluidMax = 1000;
	public int currentProgress = 0;
	public final int maxProgress = 100;
	public int bonemealProgress = 0;
	private WorldSaladItemHandler inventory;

	public SeedPressTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

		this.inventory = new WorldSaladItemHandler(4);
	}

	public SeedPressTileEntity() {
		this(TileEntityInit.SEED_PRESS.get());
	}

	public boolean hasFluid() {
		return this.fluidAmount > 0;
	}

	@Override
	public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
		return new SeedPressContainer(windowID, playerInv, this);
	}

	@Override
	public void tick() {
		boolean dirty = false;
		if (this.world != null && !this.world.isRemote) {
			if (this.inventory.getStackInSlot(0).isEmpty()) {
				this.currentProgress = 0;
			}
			if (this.inventory.getStackInSlot(1).getItem().equals(Items.BUCKET)
					&& this.inventory.getStackInSlot(3).isEmpty() && this.fluidAmount - 100 >= 0) {
				this.fluidAmount = this.fluidAmount - 100;
				this.inventory.decrStackSize(1, 1);
				this.inventory.insertItem(3, new ItemStack(ItemInit.VEGETABLE_OIL_BUCKET.get()), false);
			}
			if (this.inventory.getStackInSlot(0).isEmpty() == false && this.fluidAmount + 25 <= this.fluidMax  && this.inventory.getStackInSlot(2).getCount() < 64) {
				this.currentProgress++;
			}
			if (this.currentProgress == this.maxProgress) {
				this.currentProgress = 0;
				this.bonemealProgress = this.bonemealProgress + 1;
				this.inventory.decrStackSize(0, 1);
				this.fluidAmount = this.fluidAmount + 25;
				if (this.bonemealProgress >= 4) {
					this.bonemealProgress = 0;
					this.inventory.insertItem(2, new ItemStack(Items.BONE_MEAL), false);
				}
			}

			if (dirty) {
				this.markDirty();
				this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(),
						Constants.BlockFlags.BLOCK_UPDATE);
			}
		}
	}

	public void setCustomName(ITextComponent name) {
		this.customName = name;
	}

	public ITextComponent getName() {
		return this.customName != null ? this.customName : this.getDefaultName();
	}

	private ITextComponent getDefaultName() {
		return new TranslationTextComponent("container." + WorldSalad.MOD_ID + ".seed_press");
	}

	@Override
	public ITextComponent getDisplayName() {
		return this.getName();
	}

	@Nullable
	public ITextComponent getCustomName() {
		return this.customName;
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		if (compound.contains("CustomName", Constants.NBT.TAG_STRING)) {
			this.customName = ITextComponent.Serializer.fromJson(compound.getString("CustomName"));
		}

		NonNullList<ItemStack> inv = NonNullList.<ItemStack>withSize(this.inventory.getSlots(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, inv);
		this.inventory.setNonNullList(inv);
		this.currentProgress = compound.getInt("CurrentProgress");
		this.fluidAmount = compound.getInt("FluidLeft");

	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (this.customName != null) {
			compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
		}

		ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
		compound.putInt("CurrentProgress", this.currentProgress);
		compound.putInt("FluidLeft", this.fluidAmount);

		return compound;
	}

	public final IItemHandlerModifiable getInventory() {
		return this.inventory;
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

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> this.inventory));
	}
}
