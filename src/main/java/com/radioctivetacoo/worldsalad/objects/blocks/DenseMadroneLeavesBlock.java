package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.Random;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

public class DenseMadroneLeavesBlock extends MadroneLeavesBlock {
	public static final IntegerProperty PROPAGATION_COUNT = IntegerProperty.create("propagation_count", 0, 1);
	public static final IntegerProperty PROPAGATION_DISTANCE = IntegerProperty.create("propagation_distance", 0, 6);

	public DenseMadroneLeavesBlock(Properties properties) {
		super(properties);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return false;
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 1;
	}

	public boolean ticksRandomly(BlockState state) {
		return state.get(MADRONEDISTANCE_1_15) == 15 && !state.get(PERSISTENT);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(MADRONEDISTANCE_1_15, PERSISTENT, PROPAGATION_COUNT, PROPAGATION_DISTANCE);
	}

	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (!state.get(PERSISTENT) && state.get(MADRONEDISTANCE_1_15) == 15) {
			spawnDrops(state, worldIn, pos);
			worldIn.removeBlock(pos, false);
		}
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		worldIn.setBlockState(pos, updateDistance(state, worldIn, pos), 3);
		BlockPos north = pos.north();
		BlockPos south = pos.south();
		BlockPos east = pos.east();
		BlockPos west = pos.west();
		int i = state.get(MADRONEDISTANCE_1_15);
		int j = state.get(PROPAGATION_DISTANCE);
		if (!state.get(PERSISTENT) && state.get(MADRONEDISTANCE_1_15) < 14 && state.get(PROPAGATION_COUNT) < 1
				&& state.get(PROPAGATION_DISTANCE) < 6) {
			if (worldIn.isAirBlock(north)) {
				worldIn.setBlockState(north,
						BlockInit.DENSE_MADRONE_LEAVES.get().getDefaultState()
								.with(PROPAGATION_DISTANCE, Integer.valueOf(j + 1))
								.with(MADRONEDISTANCE_1_15, Integer.valueOf(i + 1))
								.with(PROPAGATION_COUNT, Integer.valueOf(0)));
			}
			if (worldIn.isAirBlock(south)) {
				worldIn.setBlockState(south,
						BlockInit.DENSE_MADRONE_LEAVES.get().getDefaultState()
								.with(PROPAGATION_DISTANCE, Integer.valueOf(j + 1))
								.with(MADRONEDISTANCE_1_15, Integer.valueOf(i + 1))
								.with(PROPAGATION_COUNT, Integer.valueOf(0)));
			}
			if (worldIn.isAirBlock(east)) {
				worldIn.setBlockState(east,
						BlockInit.DENSE_MADRONE_LEAVES.get().getDefaultState()
								.with(PROPAGATION_DISTANCE, Integer.valueOf(j + 1))
								.with(MADRONEDISTANCE_1_15, Integer.valueOf(i + 1))
								.with(PROPAGATION_COUNT, Integer.valueOf(0)));
			}
			if (worldIn.isAirBlock(west)) {
				worldIn.setBlockState(west,
						BlockInit.DENSE_MADRONE_LEAVES.get().getDefaultState()
								.with(PROPAGATION_DISTANCE, Integer.valueOf(j + 1))
								.with(MADRONEDISTANCE_1_15, Integer.valueOf(i + 1))
								.with(PROPAGATION_COUNT, Integer.valueOf(0)));
			}
			worldIn.setBlockState(pos, state.with(PROPAGATION_COUNT, Integer.valueOf(1)));
		}
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
}
