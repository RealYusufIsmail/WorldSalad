package com.radioctivetacoo.worldsalad.container;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class DistillerBucketSlot extends SlotItemHandler {

	public DistillerBucketSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isDistillerBucket(stack);
	}

	public static boolean isDistillerBucket(ItemStack itemStackIn) {
		return itemStackIn.getItem() == Items.WATER_BUCKET || itemStackIn.getItem() == ItemInit.CRUDE_OIL_BUCKET.get();
	}
}
