package com.radioctivetacoo.worldsalad.objects.blocks.plants;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class TallLumgrassBlock extends DoublePlantBlock {
	public TallLumgrassBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == BlockInit.FUNGAL_DIRT.get() || block == BlockInit.GLOWING_HYCELIUM.get();
	}

	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XYZ;
	}
}
