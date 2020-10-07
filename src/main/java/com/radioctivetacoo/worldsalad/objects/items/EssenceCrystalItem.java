package com.radioctivetacoo.worldsalad.objects.items;

import java.util.Random;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class EssenceCrystalItem extends Item {
	protected final Random rand = new Random();

	public EssenceCrystalItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			playerIn.giveExperiencePoints(20);
			worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 1.2F / (random.nextFloat() * 0.8F + 0.8F));
			if (!playerIn.abilities.isCreativeMode) {
				itemstack.shrink(1);
			}
		}
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
