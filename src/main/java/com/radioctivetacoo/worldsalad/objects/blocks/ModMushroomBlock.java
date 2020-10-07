package com.radioctivetacoo.worldsalad.objects.blocks;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class ModMushroomBlock extends MushroomBlock {

	private static final VoxelShape SHAPE = Block.makeCuboidShape(4, 0, 4, 12, 10, 12);

	public ModMushroomBlock(Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		Block block = blockstate.getBlock();
		if (block == BlockInit.DESERT_SHAGGY_MANE.get()) {
			if (block != BlockInit.MOLDGRASS.get() && block != BlockInit.HYCELIUM.get() && block != Blocks.MYCELIUM
					&& block != Blocks.PODZOL && block != BlockInit.PLACEHOLDER_BLOCK.get()
					&& block != BlockInit.GLOWING_HYCELIUM.get() && block != Blocks.GRASS_BLOCK && block != Blocks.DIRT
					&& block != Blocks.COARSE_DIRT && block != BlockInit.FUNGAL_DIRT.get() && block != Blocks.SAND
					&& block != BlockInit.CLAYSTONE.get() && block != BlockInit.GREEN_CLAYSTONE.get()
					&& block != BlockInit.PURPLE_CLAYSTONE.get() && block != BlockInit.RED_CLAYSTONE.get()
					&& block != BlockInit.WHITE_CLAYSTONE.get()) {
				return worldIn.getLightSubtracted(pos, 0) < 13
						&& blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.util.Direction.UP, this);
			}
		}
		if (block != BlockInit.MOLDGRASS.get() && block != BlockInit.HYCELIUM.get() && block != Blocks.MYCELIUM
				&& block != Blocks.PODZOL && block != BlockInit.PLACEHOLDER_BLOCK.get()
				&& block != BlockInit.GLOWING_HYCELIUM.get() && block != Blocks.GRASS_BLOCK && block != Blocks.DIRT
				&& block != Blocks.COARSE_DIRT && block != BlockInit.FUNGAL_DIRT.get()) {
			return worldIn.getLightSubtracted(pos, 0) < 13
					&& blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.util.Direction.UP, this);
		} else {
			return true;
		}
	}

	@Override
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XYZ;
	}
}
