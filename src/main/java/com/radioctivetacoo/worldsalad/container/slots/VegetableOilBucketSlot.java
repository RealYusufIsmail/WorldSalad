package com.radioctivetacoo.worldsalad.container.slots;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class VegetableOilBucketSlot extends SlotItemHandler {

	public VegetableOilBucketSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isVegetableOil(stack);
	}

	public static boolean isVegetableOil(ItemStack itemStackIn) {
		return itemStackIn.getItem() == ItemInit.VEGETABLE_OIL_BUCKET.get();
	}
}
