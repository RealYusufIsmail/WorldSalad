package com.radioctivetacoo.worldsalad.objects.items;

import java.util.List;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class EssenceCrystalizerItem extends Item {

	public EssenceCrystalizerItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			if (playerIn.experienceTotal >= 150) {
				playerIn.giveExperiencePoints(-150);
				playerIn.dropItem(new ItemStack(ItemInit.ESSENCE_CRYSTAL.get()), true, false);
				worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 0.5F, 1F);
				itemstack.damageItem(1, playerIn, (p_220017_1_) -> {
		            p_220017_1_.sendBreakAnimation(handIn);
		         });
				if (!playerIn.abilities.isCreativeMode) { 
					playerIn.getCooldownTracker().setCooldown(this, 40);
					playerIn.setHealth(playerIn.getHealth() - 6);
					
				}
			}
			else
			{
				worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.BLOCK_NOTE_BLOCK_BIT, SoundCategory.PLAYERS, 0.5F, 0.5F);
			}
		}
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A73" + "Right Click to extract your XP into an item."));
		tooltip.add(new StringTextComponent("\u00A78" + "\u00A7o" + "'Store away part of your soul.'"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}
