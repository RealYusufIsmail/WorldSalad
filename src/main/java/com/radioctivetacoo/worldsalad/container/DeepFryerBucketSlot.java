package com.radioctivetacoo.worldsalad.container;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class DeepFryerBucketSlot extends SlotItemHandler {

	public DeepFryerBucketSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isDeepFryerOil(stack);
	}

	public static boolean isDeepFryerOil(ItemStack itemStackIn) {
		return itemStackIn.getItem() == ItemInit.VEGETABLE_OIL_BUCKET.get();
	}
}
