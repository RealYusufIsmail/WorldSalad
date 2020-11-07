package com.radioctivetacoo.worldsalad.objects.blocks.plants;

import java.util.Random;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class LumgrassBlock extends TallGrassBlock {
	public LumgrassBlock(Properties properties) {
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

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		DoublePlantBlock doubleplantblock = (DoublePlantBlock) (BlockInit.TALL_LUMGRASS.get());
		if (doubleplantblock.getDefaultState().isValidPosition(worldIn, pos) && worldIn.isAirBlock(pos.up())) {
			doubleplantblock.placeAt(worldIn, pos, 2);
		}

	}
}
