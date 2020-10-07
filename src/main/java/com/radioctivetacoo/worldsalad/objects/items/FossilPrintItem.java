package com.radioctivetacoo.worldsalad.objects.items;

import java.util.List;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class FossilPrintItem extends Item {

	public FossilPrintItem(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (this == ItemInit.AMBER_SILVERFISH_PRINT.get() || this == ItemInit.COPROLITE_PRINT.get() || this == ItemInit.FERN_FOSSIL_PRINT.get() || this == ItemInit.CREEPER_FOSSIL_PRINT.get()) {
			tooltip.add(new StringTextComponent("\u00A75" + "Overworld Land Fossil"));
		}
		if (this == ItemInit.TRILOBITE_PRINT.get() || this == ItemInit.GASTROPOD_PRINT.get() || this == ItemInit.URCHIN_PRINT.get() || this == ItemInit.SHARKTOOTH_PRINT.get()) {
			tooltip.add(new StringTextComponent("\u00A75" + "Overworld Ocean Fossil"));
		}
		if (this == ItemInit.CRYSTAL_GHAST_TEAR_PRINT.get() || this == ItemInit.NETHER_CACTUS_PRINT.get() || this == ItemInit.NETHER_SHELL_FRAGMENT_PRINT.get()  || this == ItemInit.EXTINGUISHED_BLAZE_ROD_PRINT.get()) {
			tooltip.add(new StringTextComponent("\u00A75" + "Nether Fossil"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
