package com.radioctivetacoo.worldsalad.objects.blocks.plants;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.fluid.IFluidState;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class DryReedBlock extends SugarCaneBlock {

	public DryReedBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState soil = worldIn.getBlockState(pos.down());
		if (soil.canSustainPlant(worldIn, pos.down(), Direction.UP, this))
			return true;
		Block block = worldIn.getBlockState(pos.down()).getBlock();
		if (block == this) {
			return true;
		} else {
			if (block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT
					|| block == Blocks.PODZOL || block == Blocks.SAND || block == Blocks.RED_SAND
					|| block == BlockInit.CLAYSTONE.get() || block == BlockInit.RED_CLAYSTONE.get()
					|| block == BlockInit.GREEN_CLAYSTONE.get() || block == BlockInit.PURPLE_CLAYSTONE.get()
					|| block == BlockInit.WHITE_CLAYSTONE.get()) {
				BlockPos blockpos = pos.down();

				for (Direction direction : Direction.Plane.HORIZONTAL) {
					BlockState blockstate = worldIn.getBlockState(blockpos.offset(direction));
					IFluidState ifluidstate = worldIn.getFluidState(blockpos.offset(direction));
					if (ifluidstate.isTagged(FluidTags.WATER) || blockstate.getBlock() == Blocks.FROSTED_ICE) {
						return true;
					}
				}
			}

			return false;
		}
	}

}
