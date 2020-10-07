package com.radioctivetacoo.worldsalad.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class GlowshroomBlock extends HugeMushroomBlock {

	@Override
	public VoxelShape getRenderShape(BlockState var1, IBlockReader var2, BlockPos var3) {
		return VoxelShapes.empty();
	}

	public GlowshroomBlock(Properties properties) {
		super(properties);
	}
}
