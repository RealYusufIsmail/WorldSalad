package com.radioctivetacoo.worldsalad.tileentity;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.DistillingBarrelContainer;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.ItemInit;
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

public class DistillingBarrelTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
	//0 for none, 1 for pine oil, 2 for ethanol
	public int outputFluidType = 0;
	
	private ITextComponent customName;
	public int waterAmount = 0;
	public int outputFluidAmount = 0;
	public int fluidMax = 1000;
	public int currentProgress = 0;
	public final int maxProgress = 480;
	private WorldSaladItemHandler inventory;

	public DistillingBarrelTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);

		this.inventory = new WorldSaladItemHandler(4);
	}

	public DistillingBarrelTileEntity() {
		this(TileEntityInit.DISTILLING_BARREL.get());
	}

	public boolean hasWater() {
		return this.waterAmount > 0;
	}
	
	public boolean hasOutputFluid() {
		return this.outputFluidAmount > 0;
	}
	
	public boolean hasBoiler() {
		return this.world.getBlockState(pos.down()).equals(BlockInit.BOILER.get().getDefaultState().with(BoilerBlock.LIT, true).with(BoilerBlock.FACING, Direction.NORTH)) || 
				this.world.getBlockState(pos.down()).equals(BlockInit.BOILER.get().getDefaultState().with(BoilerBlock.LIT, true).with(BoilerBlock.FACING, Direction.NORTH))|| 
				this.world.getBlockState(pos.down()).equals(BlockInit.BOILER.get().getDefaultState().with(BoilerBlock.LIT, true).with(BoilerBlock.FACING, Direction.EAST)) || 
				this.world.getBlockState(pos.down()).equals(BlockInit.BOILER.get().getDefaultState().with(BoilerBlock.LIT, true).with(BoilerBlock.FACING, Direction.WEST));
	}

	@Override
	public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
		return new DistillingBarrelContainer(windowID, playerInv, this);
	}

	@Override
	public void tick() {
		boolean dirty = false;
		if (this.world != null && !this.world.isRemote) {
			
			//reset progress if the input item is removed
			if (this.inventory.getStackInSlot(1).isEmpty() || !hasWater()) {
				this.currentProgress = 0;
			}
			
			//set fluid type to none if output tank empty
			if (!hasOutputFluid())
			{
				outputFluidType = 0;
			}
			
			//water input slot
			if (this.inventory.getStackInSlot(0).getItem().equals(Items.WATER_BUCKET)
					&& this.waterAmount + 100 <= this.fluidMax) {
				this.waterAmount = this.waterAmount + 100;
				this.inventory.decrStackSize(0, 1);
				this.inventory.insertItem(0, new ItemStack(Items.BUCKET), false);
			}
			
			//decide whether it can run and set the fluid type
			if (this.inventory.getStackInSlot(1).isEmpty() == false && this.outputFluidAmount + 10 <= this.fluidMax && this.waterAmount >= 20) {
				if (this.inventory.getStackInSlot(1).getItem().equals(Items.SPRUCE_LEAVES) && (outputFluidType == 0 || outputFluidType == 1))
				{
					this.currentProgress++;
					if (hasBoiler())
					{
						currentProgress++;
					}
				}
				if (this.inventory.getStackInSlot(1).getItem().equals(Items.WHEAT) && (outputFluidType == 0 || outputFluidType == 2))
				{
					this.currentProgress++;
					if (hasBoiler())
					{
						currentProgress++;
					}
				}
			}
			
			//insert new fluid when complete
			if (this.currentProgress == this.maxProgress) {
				if (this.inventory.getStackInSlot(1).getItem().equals(Items.SPRUCE_LEAVES))
				{
					this.outputFluidType = 1;
				}
				if (this.inventory.getStackInSlot(1).getItem().equals(Items.WHEAT))
				{
					this.outputFluidType = 2;
				}
				this.currentProgress = 0;
				this.inventory.decrStackSize(1, 1);
				this.waterAmount = this.waterAmount - 20;
				this.outputFluidAmount = this.outputFluidAmount + 10;
			}
			
			//output fluid extraction slots
			if (this.inventory.getStackInSlot(2).getItem().equals(Items.BUCKET) && this.outputFluidAmount >= 100 && this.inventory.getStackInSlot(3).isEmpty()) {
				if (this.outputFluidType == 1) {
					this.inventory.insertItem(3, new ItemStack(ItemInit.PINE_OIL_BUCKET.get()), false);
				}
				if (this.outputFluidType == 2) {
					this.inventory.insertItem(3, new ItemStack(ItemInit.ETHANOL_BUCKET.get()), false);
				}
				if (this.outputFluidType == 0) {
					this.inventory.insertItem(3, new ItemStack(Items.WATER_BUCKET), false);
				}
				this.inventory.decrStackSize(2, 1);
				this.outputFluidAmount = this.outputFluidAmount - 100;
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
		return new TranslationTextComponent("container." + WorldSalad.MOD_ID + ".distilling_barrel");
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
		this.waterAmount = compound.getInt("FluidLeft");
		this.outputFluidAmount = compound.getInt("OutputFluidLeft");
		this.outputFluidType = compound.getInt("OutputFluidType");

	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (this.customName != null) {
			compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
		}

		ItemStackHelper.saveAllItems(compound, this.inventory.toNonNullList());
		compound.putInt("CurrentProgress", this.currentProgress);
		compound.putInt("FluidLeft", this.waterAmount);
		compound.putInt("OutputFluidLeft", this.outputFluidAmount);
		compound.putInt("OutputFluidType", this.outputFluidType);

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
