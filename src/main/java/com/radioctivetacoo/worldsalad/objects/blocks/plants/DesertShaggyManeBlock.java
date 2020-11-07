package com.radioctivetacoo.worldsalad.objects.blocks.plants;

import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.objects.blocks.ModMushroomBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class DesertShaggyManeBlock extends ModMushroomBlock {

	public DesertShaggyManeBlock(Properties properties) {
		super(properties);
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		Block block = blockstate.getBlock();
			if (block != BlockInit.MOLDGRASS.get() && block != BlockInit.HYCELIUM.get() && block != Blocks.MYCELIUM
					&& block != Blocks.PODZOL && block != BlockInit.PLACEHOLDER_BLOCK.get()
					&& block != BlockInit.GLOWING_HYCELIUM.get() && block != Blocks.GRASS_BLOCK && block != Blocks.DIRT
					&& block != Blocks.COARSE_DIRT && block != BlockInit.FUNGAL_DIRT.get() && block != Blocks.SAND
					&& block != BlockInit.CLAYSTONE.get() && block != BlockInit.GREEN_CLAYSTONE.get()
					&& block != BlockInit.PURPLE_CLAYSTONE.get() && block != BlockInit.RED_CLAYSTONE.get()
					&& block != BlockInit.WHITE_CLAYSTONE.get()) {
				return worldIn.getLightSubtracted(pos, 0) < 13 && blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.util.Direction.UP, this);
		} else {
			return true;
		}
	}
}
