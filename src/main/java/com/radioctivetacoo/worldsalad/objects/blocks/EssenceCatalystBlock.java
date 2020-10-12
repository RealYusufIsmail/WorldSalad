package com.radioctivetacoo.worldsalad.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class EssenceCatalystBlock extends Block {
	
	private static final VoxelShape SHAPE = Block.makeCuboidShape(5, 1, 5, 11, 7, 11);

	public EssenceCatalystBlock(Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

}
