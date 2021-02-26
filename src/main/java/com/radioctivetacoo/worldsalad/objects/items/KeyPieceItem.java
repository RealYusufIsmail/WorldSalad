package com.radioctivetacoo.worldsalad.objects.items;

import java.util.List;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class KeyPieceItem extends Item {

	public KeyPieceItem(Properties properties) {
		super(properties);
	}

	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (this == ItemInit.LUMINANT_KEY_PIECE.get())
		{
		tooltip.add(new StringTextComponent("\u00A73" + "Part of an ancient key, protected by a half-creature, half-construct..."));
		}
		else if (this == ItemInit.PATHOGEN_KEY_PIECE.get())
		{
		tooltip.add(new StringTextComponent("\u00A73" + "Part of an ancient key, protected by a roaming conglomerate of death..."));
		}
		else if (this == ItemInit.PLATED_KEY_PIECE.get())
		{
		tooltip.add(new StringTextComponent("\u00A73" + "Part of an ancient key, protected by a fallen royalty..."));
		}
		else if (this == ItemInit.HYPHAE_KEY.get())
		{
		tooltip.add(new StringTextComponent("\u00A73" + "The guardians have been defeated. Where could it lead?"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
