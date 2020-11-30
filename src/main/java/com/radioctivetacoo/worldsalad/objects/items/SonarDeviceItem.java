package com.radioctivetacoo.worldsalad.objects.items;

import java.util.List;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SonarDeviceItem extends Item {

	private List<LivingEntity> entitiesInRange;
	
	public SonarDeviceItem(Properties properties) {
		super(properties);
	}
	
	private void glow(LivingEntity entityIn) {
	      entityIn.addPotionEffect(new EffectInstance(Effects.GLOWING, 140));
	   }

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
			ItemStack itemstack = playerIn.getHeldItem(handIn);
			if (!worldIn.isRemote) {
					playerIn.getCooldownTracker().setCooldown(this, 200);
					itemstack.damageItem(1, playerIn, (p_220017_1_) -> {
			            p_220017_1_.sendBreakAnimation(handIn);
			         });
					worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_GUARDIAN_AMBIENT_LAND, SoundCategory.PLAYERS, 0.5F, 1F);
					BlockPos blockpos = new BlockPos(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
			    	 AxisAlignedBB axisalignedbb = (new AxisAlignedBB(blockpos)).grow(64.0D);
			         this.entitiesInRange = worldIn.getEntitiesWithinAABB(LivingEntity.class, axisalignedbb);
			         this.entitiesInRange.stream().filter(LivingEntity -> !(LivingEntity instanceof PlayerEntity)).forEach(this::glow);
			}
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}
}
