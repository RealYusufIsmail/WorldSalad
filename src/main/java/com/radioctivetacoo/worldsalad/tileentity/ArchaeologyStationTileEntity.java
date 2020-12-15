package com.radioctivetacoo.worldsalad.tileentity;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.ArchaeologyStationContainer;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.ItemInit;
import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.util.WorldSaladItemHandler;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

public class ArchaeologyStationTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider{

	private ITextComponent customName;
	public int energyLeft = 0;
	public int energyMax = 1000;
	public int currentSmeltTime = 0;
	public final int maxSmeltTime = 50;
	private WorldSaladItemHandler inventory;
	final Random rand = new Random();

	public ArchaeologyStationTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

		this.inventory = new WorldSaladItemHandler(14);
	}

	public ArchaeologyStationTileEntity() {
		this(TileEntityInit.ARCHAEOLOGY_STATION.get());
	}

	public boolean isPowered() {
		return this.energyLeft > 0;
	}

	@Override
	public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
		return new ArchaeologyStationContainer(windowID, playerInv, this);
	}
	
	@Override
	public void tick() {
		boolean dirty = false;
		//find next empty slot
		int nextEmptySlot = 2;
			if (this.inventory.getStackInSlot(2).isEmpty()) {nextEmptySlot = 2;}
			else if (this.inventory.getStackInSlot(3).isEmpty()) {nextEmptySlot = 3;}
			else if (this.inventory.getStackInSlot(4).isEmpty()) {nextEmptySlot = 4;}
			else if (this.inventory.getStackInSlot(5).isEmpty()) {nextEmptySlot = 5;}
			else if (this.inventory.getStackInSlot(6).isEmpty()) {nextEmptySlot = 6;}
			else if (this.inventory.getStackInSlot(7).isEmpty()) {nextEmptySlot = 7;}
			else if (this.inventory.getStackInSlot(8).isEmpty()) {nextEmptySlot = 8;}
			else if (this.inventory.getStackInSlot(9).isEmpty()) {nextEmptySlot = 9;}
			else if (this.inventory.getStackInSlot(10).isEmpty()) {nextEmptySlot = 10;}
			else if (this.inventory.getStackInSlot(11).isEmpty()) {nextEmptySlot = 11;}
			else if (this.inventory.getStackInSlot(12).isEmpty()) {nextEmptySlot = 12;}
			else if (this.inventory.getStackInSlot(13).isEmpty()) {nextEmptySlot = 13;}
			else {nextEmptySlot = 0;}
		//reset empty machine
		if (this.world != null && !this.world.isRemote) {
			if (this.inventory.getStackInSlot(0).isEmpty() || this.energyLeft == 0) {
				this.currentSmeltTime = 0;
			}
		//add energy
			if (this.inventory.getStackInSlot(1).getItem().equals(ItemInit.FLUX_POWDER.get()) && this.energyLeft + 200 <= this.energyMax) {
				this.inventory.decrStackSize(1, 1);
				this.energyLeft = this.energyLeft + 200;
				}
			}
		//progress crafting
			if (this.isPowered() && !this.inventory.getStackInSlot(0).isEmpty() && this.inventory.getStackInSlot(nextEmptySlot).isEmpty()) {
				if (this.currentSmeltTime != this.maxSmeltTime) {
					this.energyLeft--;
					this.currentSmeltTime++;
					dirty = true;
					}
			}
		//finish crafting
			if (this.currentSmeltTime == this.maxSmeltTime) {
				this.world.playSound((PlayerEntity)null, this.pos, SoundEvents.BLOCK_BAMBOO_BREAK, SoundCategory.BLOCKS, 0.7F, 0.8F);
				Item output = null;
				Item print1 = null;
				Item print2 = null;
				Item print3 = null;
				Item print4 = null;
				Item fossil1 = null;
				Item fossil2 = null;
				Item fossil3 = null;
				Item fossil4 = null;
				Item resource1 = null;
				Item resource2 = null;
				Item sediment = null;
				int randomOutput = rand.nextInt(99);
				// decide output options based on inputed block
				if (this.inventory.getStackInSlot(0).getItem().equals(BlockInit.BLACK_SHALE.get().asItem())) {
					print1 = ItemInit.OIL.get();
					print2 = ItemInit.OIL.get();
					print3 = ItemInit.OIL.get();
					print4 = ItemInit.OIL.get();
					fossil1 = ItemInit.OIL.get();
					fossil2 = ItemInit.OIL.get();
					fossil3 = Items.COAL;
					fossil4 = ItemInit.OIL.get();
					resource1 = ItemInit.OIL.get();
					resource2 = ItemInit.OIL.get();
					sediment = Items.GRAVEL;
				}
				if (this.inventory.getStackInSlot(0).getItem().equals(BlockInit.SHALE.get().asItem())) {
					print1 = ItemInit.TRILOBITE_PRINT.get();
					print2 = ItemInit.GASTROPOD_PRINT.get();
					print3 = ItemInit.URCHIN_PRINT.get();
					print4 = ItemInit.SHARKTOOTH_PRINT.get();
					fossil1 = ItemInit.TRILOBITE_SKELETON.get();
					fossil2 = ItemInit.GASTROPOD_SKELETON.get();
					fossil3 = ItemInit.URCHIN_SKELETON.get();
					fossil4 = ItemInit.SHARKTOOTH_SKELETON.get();
					resource1 = ItemInit.OIL.get();
					resource2 = Items.COAL;
					sediment = Items.GRAVEL;
				}
				if (this.inventory.getStackInSlot(0).getItem().equals(BlockInit.SILT.get().asItem())) {
					print1 = ItemInit.CREEPER_FOSSIL_PRINT.get();
					print2 = ItemInit.AMBER_SILVERFISH_PRINT.get();
					print3 = ItemInit.COPROLITE_PRINT.get();
					print4 = ItemInit.FERN_FOSSIL_PRINT.get();
					fossil1 = ItemInit.CREEPER_FOSSIL.get();
					fossil2 = ItemInit.AMBER_SILVERFISH.get();
					fossil3 = ItemInit.COPROLITE.get();
					fossil4 = ItemInit.FERN_FOSSIL.get();
					resource1 = ItemInit.COPPER_NUGGET.get();
					resource2 = Items.IRON_NUGGET;
					sediment = Items.SAND;
				}
				if (this.inventory.getStackInSlot(0).getItem().equals(BlockInit.VOLCANIC_GRAVEL.get().asItem())) {
					print1 = ItemInit.CRYSTAL_GHAST_TEAR_PRINT.get();
					print2 = ItemInit.NETHER_SHELL_FRAGMENT_PRINT.get();
					print3 = ItemInit.NETHER_CACTUS_PRINT.get();
					print4 = ItemInit.EXTINGUISHED_BLAZE_ROD_PRINT.get();
					fossil1 = ItemInit.CRYSTAL_GHAST_TEAR_FOSSIL.get();
					fossil2 = ItemInit.NETHER_SHELL_FRAGMENT_FOSSIL.get();
					fossil3 = ItemInit.NETHER_CACTUS_FOSSIL.get();
					fossil4 = ItemInit.EXTINGUISHED_BLAZE_ROD_FOSSIL.get();
					resource1 = Items.MAGMA_CREAM;
					resource2 = Items.FLINT;
					sediment = Items.GRAVEL;
				}
				if (this.inventory.getStackInSlot(0).getItem().equals(BlockInit.MOONDUST.get().asItem())) {
					print1 = ItemInit.ENDERMITE_EGG_PRINT.get();
					print2 = ItemInit.ANCIENT_ENDER_PEARL_PRINT.get();
					print3 = ItemInit.SHULKER_SHELL_PRINT.get();
					print4 = ItemInit.ENDER_BONE_PRINT.get();
					fossil1 = ItemInit.ENDERMITE_EGG_FOSSIL.get();
					fossil2 = ItemInit.ANCIENT_ENDER_PEARL_FOSSIL.get();
					fossil3 = ItemInit.SHULKER_SHELL_FOSSIL.get();
					fossil4 = ItemInit.ENDER_BONE_FOSSIL.get();
					resource1 = ItemInit.MITHRIL_NUGGET.get();
					resource2 = ItemInit.MOLYBDENUM_NUGGET.get();
					sediment = Items.SAND;
				}
				if (this.inventory.getStackInSlot(0).getItem().equals(BlockInit.BIOSEDIMENT.get().asItem())) {
					print1 = ItemInit.TRUFFLE_PRINT.get();
					print2 = ItemInit.ANT_SHELL_FRAGMENT_PRINT.get();
					print3 = ItemInit.BACTERIUM_PRINT.get();
					print4 = ItemInit.MOTH_PRINT.get();
					fossil1 = ItemInit.TRUFFLE_FOSSIL.get();
					fossil2 = ItemInit.ANT_SHELL_FRAGMENT_FOSSIL.get();
					fossil3 = ItemInit.BACTERIUM_FOSSIL.get();
					fossil4 = ItemInit.MOTH_FOSSIL.get();
					resource1 = ItemInit.AMBER_DROPLET.get();
					resource2 = ItemInit.BIOLUMINESCENT_CRYSTAL.get();
					sediment = Items.SAND;
				}
				// pick output option
				if (randomOutput == 0) { output = print1; }
				else if (randomOutput == 1) { output = print2; }
				else if (randomOutput == 2) { output = print3; }
				else if (randomOutput == 3) { output = print4; }
				else if (randomOutput == 4) { output = fossil1; }
				else if (randomOutput == 5) { output = fossil2; }
				else if (randomOutput == 6) { output = fossil3; }
				else if (randomOutput == 7) { output = fossil4; }
				else if (randomOutput >= 8 && randomOutput <= 19) { output = resource1; }
				else if (randomOutput >= 20 && randomOutput <= 31) { output = resource2; }
				else if (randomOutput > 31) { output = sediment; }
				// finish outputting
					this.inventory.insertItem(nextEmptySlot, new ItemStack(output), false);
					this.currentSmeltTime = 0;
					this.inventory.decrStackSize(0, 1);
				dirty = true;
			}

			if (dirty) {
				this.markDirty();
				this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(),
						Constants.BlockFlags.BLOCK_UPDATE);
			}
		}
	
	public void setCustomName(ITextComponent name) {
		this.customName = name;
	}

	public ITextComponent getName() {
		return this.customName != null ? this.customName : this.getDefaultName();
	}

	private ITextComponent getDefaultName() {
		return new TranslationTextComponent("container." + WorldSalad.MOD_ID + ".archaeology_station");
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
		this.currentSmeltTime = compound.getInt("CurrentSmeltTime");
		this.energyLeft = compound.getInt("EnergyLeft");

	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (this.customName != null) {
			compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
		}

		ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
		compound.putInt("CurrentSmeltTime", this.currentSmeltTime);
		compound.putInt("EnergyLeft", this.energyLeft);

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
