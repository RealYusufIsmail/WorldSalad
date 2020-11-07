package com.radioctivetacoo.worldsalad.tileentity;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.BoilerContainer;
import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.BoilerBlock;
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

public class BoilerTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	private ITextComponent customName;
	public int fuelLeft = 0;
	public int maxFuel = 0;
	private WorldSaladItemHandler inventory;

	public BoilerTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

		this.inventory = new WorldSaladItemHandler(3);
	}

	public BoilerTileEntity() {
		this(TileEntityInit.BOILER.get());
	}
	
	public boolean isBurning()
	{
		return fuelLeft > 0;
	}
	
	protected int getBurnTime(ItemStack fuel) {
	      if (fuel.isEmpty()) {
	         return 0;
	      } else {
	         return net.minecraftforge.common.ForgeHooks.getBurnTime(fuel);
	      }
	   }

	@Override
	public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
		return new BoilerContainer(windowID, playerInv, this);
	}
	@Override
	public void tick() {
		if (this.isBurning())
		{
			this.fuelLeft--;
		}
		boolean dirty = false;
		if (this.world != null && !this.world.isRemote) {
				if (this.getBurnTime(this.inventory.getStackInSlot(0)) > 0 && !this.isBurning()) {
				this.fuelLeft = this.getBurnTime(this.inventory.getStackInSlot(0)) * 2;
				this.maxFuel = this.getBurnTime(this.inventory.getStackInSlot(0)) * 2; 
				if (this.inventory.getStackInSlot(0).getItem().equals(Items.LAVA_BUCKET)) { 
					this.inventory.decrStackSize(0, 1);
					this.inventory.insertItem(0, new ItemStack(Items.BUCKET), false);
				} else {
					this.inventory.decrStackSize(0, 1);
					}
			}
				
			if (this.isBurning()) {
				this.world.setBlockState(this.getPos(), this.getBlockState().with(BoilerBlock.LIT, true));
			}
			if (!this.isBurning()) {
				this.world.setBlockState(this.getPos(), this.getBlockState().with(BoilerBlock.LIT, false));
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
		return new TranslationTextComponent("container." + WorldSalad.MOD_ID + ".boiler");
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
		this.fuelLeft = compound.getInt("FuelLeft");

	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (this.customName != null) {
			compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
		}

		ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
		compound.putInt("FuelLeft", this.fuelLeft);

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
