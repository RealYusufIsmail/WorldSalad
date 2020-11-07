package com.radioctivetacoo.worldsalad.objects.items;

import java.util.function.Predicate;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ShootingReedItem extends ShootableItem {
	public ShootingReedItem(Properties propertiesIn) {
		super(propertiesIn);
		// TODO Auto-generated constructor stub
	}

	public static final Predicate<ItemStack> DARTS = (p_220004_0_) -> {
		return p_220004_0_.getItem() == ItemInit.REED_DART.get();
	};

	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return DARTS;
	}

	public Predicate<ItemStack> getAmmoPredicate() {
		return getInventoryAmmoPredicate();
	}
	
	   public int getUseDuration(ItemStack stack) {
	      return 3;
	   }
	   
	   public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		      ItemStack itemstackHand = playerIn.getHeldItem(handIn);
		      ItemStack itemstackAmmo = playerIn.findAmmo(itemstackHand);
		      ArrowItem arrowitem = (ArrowItem)(itemstackAmmo.getItem() instanceof ArrowItem ? itemstackAmmo.getItem() : ItemInit.REED_DART.get());
		      AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstackAmmo, playerIn);
		      boolean flag1 = playerIn.abilities.isCreativeMode || (itemstackAmmo.getItem() instanceof ArrowItem && ((ArrowItem)itemstackAmmo.getItem()).isInfinite(itemstackAmmo, itemstackHand, playerIn));
		      boolean flag2 = playerIn.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, itemstackAmmo) > 0;
		      if (!worldIn.isRemote) {
		    	  if (!itemstackAmmo.isEmpty() || flag2) {
		    		  ArrowEntity Arrowentity = new ArrowEntity(worldIn, playerIn);
		    		  if (itemstackAmmo.isEmpty()) {
		                  itemstackAmmo = new ItemStack(ItemInit.REED_DART.get());
		               }
		    		  playerIn.getCooldownTracker().setCooldown(this, 20);
		    		  worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ITEM_CROSSBOW_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		    		  Arrowentity.setDamage(abstractarrowentity.getDamage() + 2D);
		    		  Arrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
		    		  Arrowentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
		    		  worldIn.addEntity(Arrowentity);
		    		  if (!playerIn.abilities.isCreativeMode)
		    			  itemstackHand.damageItem(1, playerIn, (p_220009_1_) -> {
		                  p_220009_1_.sendBreakAnimation(playerIn.getActiveHand());});
		    	  }
		    	  if (!flag1 && !playerIn.abilities.isCreativeMode) {
	                  itemstackAmmo.shrink(1);
	                  if (itemstackAmmo.isEmpty()) {
	                     playerIn.inventory.deleteStack(itemstackAmmo);
	                  }
	               }
		      }

		      playerIn.addStat(Stats.ITEM_USED.get(this));

		      return ActionResult.resultSuccess(itemstackHand);
		   } 
}
