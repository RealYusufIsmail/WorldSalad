package com.radioctivetacoo.worldsalad.container.slots;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class RefinedOilBucketSlot extends SlotItemHandler {

	public RefinedOilBucketSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isRefinedOilBucket(stack);
	}

	public static boolean isRefinedOilBucket(ItemStack itemStackIn) {
		return itemStackIn.getItem() == ItemInit.REFINED_OIL_BUCKET.get();
	}
}
