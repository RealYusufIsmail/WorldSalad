package com.radioctivetacoo.worldsalad.objects.blocks;

import javax.annotation.Nullable;

import com.radioctivetacoo.worldsalad.init.FluidInit;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FalseExperienceOreBlock extends ModOreBlock {

	public FalseExperienceOreBlock(Properties properties) {
		super(properties);
	}	
	
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
	      super.harvestBlock(worldIn, player, pos, state, te, stack);
	      if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
	      worldIn.setBlockState(pos, FluidInit.ACID_BLOCK.get().getDefaultState());
	      }
	   }
}
