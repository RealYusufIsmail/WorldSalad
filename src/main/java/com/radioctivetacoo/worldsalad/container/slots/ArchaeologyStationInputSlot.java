package com.radioctivetacoo.worldsalad.container.slots;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class ArchaeologyStationInputSlot extends SlotItemHandler {

	public ArchaeologyStationInputSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isValidBlock(stack);
	}

	public static boolean isValidBlock(ItemStack itemStackIn) {
		return itemStackIn.getItem() == BlockInit.SHALE.get().asItem() || itemStackIn.getItem() == BlockInit.BLACK_SHALE.get().asItem() || itemStackIn.getItem() == BlockInit.SILT.get().asItem() || itemStackIn.getItem() == BlockInit.STARDUST.get().asItem() || itemStackIn.getItem() == BlockInit.BIOSEDIMENT.get().asItem() || itemStackIn.getItem() == BlockInit.VOLCANIC_GRAVEL.get().asItem();
	}
}
