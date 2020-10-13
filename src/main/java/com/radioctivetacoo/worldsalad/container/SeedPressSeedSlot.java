package com.radioctivetacoo.worldsalad.container;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class SeedPressSeedSlot extends SlotItemHandler {

	public SeedPressSeedSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return isSeeds(stack);
	}

	public static boolean isSeeds(ItemStack itemStackIn) {
		return itemStackIn.getItem() == Items.WHEAT_SEEDS || itemStackIn.getItem() == Items.BEETROOT_SEEDS
				|| itemStackIn.getItem() == Items.MELON_SEEDS || itemStackIn.getItem() == Items.PUMPKIN_SEEDS || itemStackIn.getItem() == ItemInit.HOTCOFFEE_SEED.get();
	}
}
