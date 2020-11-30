package com.radioctivetacoo.worldsalad.container.slots;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class PineOilBucketSlot extends SlotItemHandler {

	public PineOilBucketSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isPineOilBucket(stack);
	}

	public static boolean isPineOilBucket(ItemStack itemStackIn) {
		return itemStackIn.getItem() == ItemInit.PINE_OIL_BUCKET.get();
	}
}
