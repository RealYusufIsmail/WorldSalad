package com.radioctivetacoo.worldsalad.container;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class ModFuelSlot extends SlotItemHandler {

	public ModFuelSlot(IItemHandlerModifiable inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	public boolean isItemValid(ItemStack stack) {
	      return this.isFuel(stack);
	   }
	
	protected boolean isFuel(ItemStack stack) {
	      return AbstractFurnaceTileEntity.isFuel(stack);
	   }
}
