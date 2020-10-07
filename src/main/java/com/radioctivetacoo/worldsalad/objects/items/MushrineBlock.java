package com.radioctivetacoo.worldsalad.objects.items;

import java.util.List;

import com.radioctivetacoo.worldsalad.util.helpers.KeyboardHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class MushrineBlock extends Item {

	public MushrineBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (KeyboardHelper.isHoldingShift()) {
			tooltip.add(new StringTextComponent("\u00A75" + "Mushrine"));
			tooltip.add(new StringTextComponent(
					"\u00A77" + "Used by an ancient people to travel to and from the Hyphae. Right click to trael."));
		} else {
			tooltip.add(
					new StringTextComponent("\u00A77" + "Hold" + "\u00A7e" + " SHIFT " + "\u00A77" + "for more info"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
