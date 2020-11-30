package com.radioctivetacoo.worldsalad.container.slots;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class FluxPowderSlot extends SlotItemHandler {

	public FluxPowderSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isFluxPowder(stack);
	}

	public static boolean isFluxPowder(ItemStack itemStackIn) {
		return itemStackIn.getItem() == ItemInit.FLUX_POWDER.get();
	}

}
