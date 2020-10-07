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

public class GeodeBlock extends Block {
	private static final VoxelShape SHAPE = Stream.of(Block.makeCuboidShape(5, 0, 5, 11, 6, 11)).reduce((v1, v2) -> {
		return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
	}).get();

	public GeodeBlock(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
}
