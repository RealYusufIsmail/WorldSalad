package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class AluminumPlatformBlock extends Block {

	public AluminumPlatformBlock(Properties properties) {
		super(properties);
	}

	protected static final VoxelShape SHAPE =  Stream.of(
			Block.makeCuboidShape(0.0D, 16.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.makeCuboidShape(1.0D, 6.0D, 1.0D, 15.0D, 12.0D, 15.0D)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
}
