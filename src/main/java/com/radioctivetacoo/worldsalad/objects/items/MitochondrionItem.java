package com.radioctivetacoo.worldsalad.objects.items;

import java.util.List;

import com.radioctivetacoo.worldsalad.entities.SoldierAnt;
import com.radioctivetacoo.worldsalad.entities.TraderAnt;
import com.radioctivetacoo.worldsalad.entities.WorkerAnt;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.passive.WolfEntity;
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

public class MitochondrionItem extends Item {

	private List<LivingEntity> entitiesInRange;
	
	public MitochondrionItem(Properties properties) {
		super(properties);
	}
	
	private void poison(LivingEntity entityIn) {
	      entityIn.addPotionEffect(new EffectInstance(Effects.POISON, 80));
	   }
	private void boost(LivingEntity entityIn) {
	      entityIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200));
	      entityIn.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 200, 1));
	      entityIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20, 10, true, false));
	   }

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
			ItemStack itemstack = playerIn.getHeldItem(handIn);
			if (!worldIn.isRemote && playerIn.getHealth() >= 11) {
					playerIn.getCooldownTracker().setCooldown(this, 800);
					itemstack.damageItem(1, playerIn, (p_220017_1_) -> {
			            p_220017_1_.sendBreakAnimation(handIn);
			         });
					 worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.PLAYERS, 0.5F, 1F);
					 playerIn.setHealth(playerIn.getHealth() - 10);
					 BlockPos blockpos = new BlockPos(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
			    	 AxisAlignedBB axisalignedbb = (new AxisAlignedBB(blockpos)).grow(10.0D);
			         this.entitiesInRange = worldIn.getEntitiesWithinAABB(LivingEntity.class, axisalignedbb);
			         this.entitiesInRange.stream().filter(LivingEntity -> !(LivingEntity instanceof PlayerEntity) && !(LivingEntity instanceof VillagerEntity) 
			         && !(LivingEntity instanceof WolfEntity) && !(LivingEntity instanceof IronGolemEntity) && !(LivingEntity instanceof SnowGolemEntity)
			         && !(LivingEntity instanceof SoldierAnt) && !(LivingEntity instanceof WorkerAnt) && !(LivingEntity instanceof TraderAnt) 
			         && !(LivingEntity instanceof WitherEntity) && !(LivingEntity instanceof EnderDragonEntity)).forEach(this::poison);
			         this.entitiesInRange.stream().filter(LivingEntity -> (LivingEntity instanceof PlayerEntity)
					 || (LivingEntity instanceof WolfEntity) || (LivingEntity instanceof IronGolemEntity)).forEach(this::boost);
			}
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
