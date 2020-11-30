package com.radioctivetacoo.worldsalad.container.slots;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class WaterBucketSlot extends SlotItemHandler {

	public WaterBucketSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isWaterBucket(stack);
	}

	public static boolean isWaterBucket(ItemStack itemStackIn) {
		return itemStackIn.getItem() == Items.WATER_BUCKET;
	}
}
