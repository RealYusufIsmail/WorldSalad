package com.radioctivetacoo.worldsalad.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class DirtCakeBlock extends CakeBlock {

	public DirtCakeBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	      if (worldIn.isRemote) {
	         ItemStack itemstack = player.getHeldItem(handIn);
	         if (this.eatCake(worldIn, pos, state, player) == ActionResultType.SUCCESS) {
	            return ActionResultType.SUCCESS;
	         }

	         if (itemstack.isEmpty()) {
	            return ActionResultType.CONSUME;
	         }
	      }

	      return this.eatCake(worldIn, pos, state, player);
	   }
	
	private ActionResultType eatCake(IWorld worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
	      if (!playerIn.canEat(false)) {
	         return ActionResultType.PASS;
	      } else {
	         playerIn.addStat(Stats.EAT_CAKE_SLICE);
	         playerIn.getFoodStats().addStats(2, 0.1F);
	         playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 2400, 0));
	         int i = state.get(BITES);
	         if (i < 6) {
	            worldIn.setBlockState(pos, state.with(BITES, Integer.valueOf(i + 1)), 3);
	         } else {
	            worldIn.removeBlock(pos, false);
	         }

	         return ActionResultType.SUCCESS;
	      }
	   }
}
