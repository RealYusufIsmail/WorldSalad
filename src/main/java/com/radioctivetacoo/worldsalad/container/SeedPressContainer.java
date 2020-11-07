package com.radioctivetacoo.worldsalad.container;

import javax.annotation.Nonnull;
import java.util.Objects;

import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.ContainerInit;
import com.radioctivetacoo.worldsalad.tileentity.SeedPressTileEntity;
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

public class SeedPressContainer extends Container {

	public SeedPressTileEntity tileEntity;
	private IWorldPosCallable canInteractWithCallable;
	public FunctionalIntReferenceHolder currentProgress;
	public FunctionalIntReferenceHolder fluidAmount;

	// Server Constructor
	public SeedPressContainer(final int windowID, final PlayerInventory playerInv, final SeedPressTileEntity tile) {
		super(ContainerInit.SEED_PRESS.get(), windowID);

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

		// Frier Slots
		this.addSlot(new SeedPressSeedSlot(tile.getInventory(), 0, 18, 33));
		this.addSlot(new EmptyBucketSlot(tile.getInventory(), 1, 120, 52));
		this.addSlot(new ModOutputSlot(tile.getInventory(), 2, 86, 33));
		this.addSlot(new ModOutputSlot(tile.getInventory(), 3, 144, 52));

		this.trackInt(currentProgress = new FunctionalIntReferenceHolder(() -> this.tileEntity.currentProgress,
				value -> this.tileEntity.currentProgress = value));

		this.trackInt(fluidAmount = new FunctionalIntReferenceHolder(() -> this.tileEntity.fluidAmount,
				value -> this.tileEntity.fluidAmount = value));
	}

	// Client Constructor
	public SeedPressContainer(final int windowID, final PlayerInventory playerInv, final PacketBuffer data) {
		this(windowID, playerInv, getTileEntity(playerInv, data));
	}

	private static SeedPressTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof SeedPressTileEntity) {
			return (SeedPressTileEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.SEED_PRESS.get());
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
				? this.currentProgress.get() * 24 / this.tileEntity.maxProgress
				: 0;
	}

	@OnlyIn(Dist.CLIENT)
	public int getFluidAmountScaled() {
		return this.fluidAmount.get() != 0 ? this.fluidAmount.get() * 30 / 1000 : 0;
	}
}
