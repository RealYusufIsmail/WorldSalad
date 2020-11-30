package com.radioctivetacoo.worldsalad.container;

import javax.annotation.Nonnull;
import java.util.Objects;

import com.radioctivetacoo.worldsalad.container.slots.FluxPowderSlot;
import com.radioctivetacoo.worldsalad.container.slots.ModOutputSlot;
import com.radioctivetacoo.worldsalad.container.slots.RefinedOilBucketSlot;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.ContainerInit;
import com.radioctivetacoo.worldsalad.tileentity.PolymerizationReactorTileEntity;
import com.radioctivetacoo.worldsalad.util.FunctionalIntReferenceHolder;

import net.minecraft.inventory.container.Slot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PolymerizationReactorContainer extends Container {

	public PolymerizationReactorTileEntity tileEntity;
	private IWorldPosCallable canInteractWithCallable;
	public FunctionalIntReferenceHolder currentProgress;
	public FunctionalIntReferenceHolder oilAmount;
	public FunctionalIntReferenceHolder energyLeft;

	// Server Constructor
	public PolymerizationReactorContainer(final int windowID, final PlayerInventory playerInv, final PolymerizationReactorTileEntity tile) {
		super(ContainerInit.POLYMERIZATION_REACTOR.get(), windowID);

		this.tileEntity = tile;
		this.canInteractWithCallable = IWorldPosCallable.of(tile.getWorld(), tile.getPos());

		final int slotSizePlus2 = 18;
		final int startX = 8;

		// Hotbar
		int hotbarY = 142;
		for (int column = 0; column < 9; column++) {
			this.addSlot(new Slot(playerInv, column, startX + (column * slotSizePlus2), hotbarY));
		}

		// Main Player Inventory
		final int startY = 84;

		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 9; column++) {
				this.addSlot(new Slot(playerInv, 9 + (row * 9) + column, startX + (column * slotSizePlus2),
						startY + (row * slotSizePlus2)));
			}
		}

		// Barrel Slots
		this.addSlot(new RefinedOilBucketSlot(tile.getInventory(), 0, 33, 19));
		this.addSlot(new FluxPowderSlot(tile.getInventory(), 1, 8, 19));
		this.addSlot(new ModOutputSlot(tile.getInventory(), 2, 111, 35));

		this.trackInt(currentProgress = new FunctionalIntReferenceHolder(() -> this.tileEntity.currentProgress,
				value -> this.tileEntity.currentProgress = value));

		this.trackInt(oilAmount = new FunctionalIntReferenceHolder(() -> this.tileEntity.oilAmount,
				value -> this.tileEntity.oilAmount = value));
		
		this.trackInt(energyLeft = new FunctionalIntReferenceHolder(() -> this.tileEntity.energyLeft,
				value -> this.tileEntity.energyLeft = value));
	}

	// Client Constructor
	public PolymerizationReactorContainer(final int windowID, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowID, playerInv, getTileEntity(playerInv, data));
	}

	private static PolymerizationReactorTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof PolymerizationReactorTileEntity) {
			return (PolymerizationReactorTileEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.POLYMERIZATION_REACTOR.get());
	}

	@Nonnull
	@Override
	public ItemStack transferStackInSlot(final PlayerEntity player, final int index) {
		ItemStack returnStack = ItemStack.EMPTY;
		final Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			final ItemStack slotStack = slot.getStack();
			returnStack = slotStack.copy();

			final int containerSlots = this.inventorySlots.size() - player.inventory.mainInventory.size();
			if (index < containerSlots) {
				if (!mergeItemStack(slotStack, containerSlots, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!mergeItemStack(slotStack, 0, containerSlots, false)) {
				return ItemStack.EMPTY;
			}
			if (slotStack.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
			if (slotStack.getCount() == returnStack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(player, slotStack);
		}
		return returnStack;
	}

	@OnlyIn(Dist.CLIENT)
	public int getProgressScaled() {
		return this.currentProgress.get() != 0 && this.tileEntity.maxProgress != 0
				? this.currentProgress.get() * 34 / this.tileEntity.maxProgress
				: 0;
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getEnergyLeftScaled() {
		return this.energyLeft.get() != 0 ? this.energyLeft.get() * 30 / 1000 : 0;
	}

	@OnlyIn(Dist.CLIENT)
	public int getOilAmountScaled() {
		return this.oilAmount.get() != 0 ? this.oilAmount.get() * 30 / this.tileEntity.fluidMax : 0;
	}
}
