package com.radioctivetacoo.worldsalad.container;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class OutputBucketSlot extends SlotItemHandler {

	public OutputBucketSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isBucket(stack);
	}

	public static boolean isBucket(ItemStack itemStackIn) {
		return itemStackIn.getItem() == Items.BUCKET;
	}
}
