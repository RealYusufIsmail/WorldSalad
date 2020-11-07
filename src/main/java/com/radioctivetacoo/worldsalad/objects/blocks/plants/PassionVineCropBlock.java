package com.radioctivetacoo.worldsalad.objects.blocks.plants;

import java.util.Random;

import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

public class PassionVineCropBlock extends CropsBlock {
	
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
			Block.makeCuboidShape(3.0D, 9.0D, 3.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(3.0D, 9.0D, 3.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(3.0D, 6.0D, 3.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(3.0D, 6.0D, 3.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(3.0D, 6.0D, 3.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(3.0D, 4.0D, 3.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(3.0D, 4.0D, 3.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D) };

	public PassionVineCropBlock(Properties builder) {
		super(builder);
	}

	@Override
	protected IItemProvider getSeedsItem() {
		return ItemInit.PASSION_FRUIT_SEED.get();
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
	}
	
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.MYCELIUM || state.getBlock() == Blocks.PODZOL || state.getBlock() == Blocks.COARSE_DIRT;
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.up();
	    return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
	}
	
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
	      super.tick(state, worldIn, pos, rand);
	      if (!worldIn.isAreaLoaded(pos, 1)) return;
	      if (worldIn.getLightSubtracted(pos, 0) >= 9) {
	         float f = CropsBlock.getGrowthChance(this, worldIn, pos);
	         if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
	            int i = state.get(AGE);
	            if (i < 7) {
	               worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
	            } else {
	               BlockPos blockpos = pos.down();
	               if (worldIn.isAirBlock(blockpos)) {
	                  worldIn.setBlockState(blockpos, BlockInit.PASSION_FRUIT_BLOCK.get().getDefaultState());
	               }
	            }
	            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
	        }

	    }
	}
}
