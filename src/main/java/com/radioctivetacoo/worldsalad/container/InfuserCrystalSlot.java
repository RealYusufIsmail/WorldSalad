package com.radioctivetacoo.worldsalad.container;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class InfuserCrystalSlot extends SlotItemHandler {

	public InfuserCrystalSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isCrystal(stack);
	}

	public static boolean isCrystal(ItemStack itemStackIn) {
		return itemStackIn.getItem() == ItemInit.ESSENCE_CRYSTAL.get();
	}
}
