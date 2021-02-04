package com.radioctivetacoo.worldsalad.objects.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class VaultingReedItem extends Item {

	public VaultingReedItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (playerIn.onGround) {
			ItemStack itemstack = playerIn.getHeldItem(handIn);
			if (!worldIn.isRemote) {
				playerIn.addPotionEffect(new EffectInstance(Effects.LEVITATION, 7, 16));
				if (!playerIn.abilities.isCreativeMode) {
					itemstack.shrink(1);
				}
			}

		}
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}
	
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A73" + "Right Click to throw yourself into the air."));
		tooltip.add(new StringTextComponent("\u00A78" + "\u00A7o" + "'Bane of walnuts.'"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
