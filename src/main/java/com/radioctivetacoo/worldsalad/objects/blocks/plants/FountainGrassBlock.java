package com.radioctivetacoo.worldsalad.objects.blocks.plants;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class FountainGrassBlock extends DoublePlantBlock {
	public FountainGrassBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT
				|| block == Blocks.PODZOL || block == Blocks.FARMLAND || block == BlockInit.LAVAROCK.get();
	}

	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XYZ;
	}
}
