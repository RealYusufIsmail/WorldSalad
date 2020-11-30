package com.radioctivetacoo.worldsalad.tileentity;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.PolymerizationReactorContainer;
import com.radioctivetacoo.worldsalad.init.ItemInit;
import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.DeepFryerBlock;
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

public class PolymerizationReactorTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
	
	private ITextComponent customName;
	public int oilAmount = 0;
	public int fluidMax = 1000;
	public int energyLeft = 0;
	public int energyMax = 1000;
	public int currentProgress = 0;
	public final int maxProgress = 480;
	private WorldSaladItemHandler inventory;

	public PolymerizationReactorTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

		this.inventory = new WorldSaladItemHandler(4);
	}

	public PolymerizationReactorTileEntity() {
		this(TileEntityInit.POLYMERIZATION_REACTOR.get());
	}

	public boolean hasOil() {
		return this.oilAmount > 0;
	}
	
	public boolean isPowered() {
		return this.energyLeft > 0;
	}
	
	public boolean isRunning() {
		return this.currentProgress > 0;
	}

	@Override
	public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
		return new PolymerizationReactorContainer(windowID, playerInv, this);
	}

	@Override
	public void tick() {
		boolean dirty = false;
		if (this.world != null && !this.world.isRemote) {
			
			//reset progress if the input item is removed
			if (!hasOil() || !isPowered()) {
				this.currentProgress = 0;
			} 
			
			if (isRunning()) {
				this.world.setBlockState(this.getPos(), this.getBlockState().with(DeepFryerBlock.LIT, true));
			}
			if (!isRunning()) {
				this.world.setBlockState(this.getPos(), this.getBlockState().with(DeepFryerBlock.LIT, false));
			}
			
			if (this.inventory.getStackInSlot(1).getItem().equals(ItemInit.FLUX_POWDER.get()) && this.energyLeft + 200 <= 1000) {
				this.inventory.decrStackSize(1, 1);
				this.energyLeft = this.energyLeft + 200;
			}
			
			//water input slot
			if (this.inventory.getStackInSlot(0).getItem().equals(ItemInit.REFINED_OIL_BUCKET.get())
					&& this.oilAmount + 100 <= this.fluidMax) {
				this.oilAmount = this.oilAmount + 100;
				this.inventory.decrStackSize(0, 1);
				this.inventory.insertItem(0, new ItemStack(Items.BUCKET), false);
			}
			
			//decide whether it can run and set the fluid type
			if (this.oilAmount >= 50 && isPowered()) {
					this.currentProgress++;
					this.energyLeft--;
			}
			
			//insert new fluid when complete 
			if (this.currentProgress == this.maxProgress) {	
				this.currentProgress = 0;
				this.oilAmount = this.oilAmount - 50;
				this.inventory.insertItem(2, new ItemStack(ItemInit.PLASTIC_SHEET.get()), false);
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
		return new TranslationTextComponent("container." + WorldSalad.MOD_ID + ".polymerization_reactor");
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
		this.oilAmount = compound.getInt("FluidLeft");
		this.energyLeft = compound.getInt("EnergyLeft");

	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (this.customName != null) {
			compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
		}

		ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
		compound.putInt("CurrentProgress", this.currentProgress);
		compound.putInt("FluidLeft", this.oilAmount);
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
