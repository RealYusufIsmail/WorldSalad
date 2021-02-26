package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.function.Function;
import java.util.stream.Stream;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.DimensionInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ITeleporter;

public class MushrineBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(2, 0, 2, 14, 3, 14), Block.makeCuboidShape(3, 3, 3, 13, 4, 13),
					Block.makeCuboidShape(13, 0, 1, 15, 11, 3), Block.makeCuboidShape(1, 0, 1, 3, 11, 3),
					Block.makeCuboidShape(1, 0, 13, 3, 11, 15), Block.makeCuboidShape(13, 0, 13, 15, 11, 15),
					Block.makeCuboidShape(7, 4, 7, 9, 10, 9), Block.makeCuboidShape(5, 10, 5, 11, 13, 11),
					Block.makeCuboidShape(6, 13, 6, 10, 14, 10), Block.makeCuboidShape(11, 10, 6, 12, 12, 10),
					Block.makeCuboidShape(4, 10, 6, 5, 12, 10), Block.makeCuboidShape(6, 10, 4, 10, 12, 5),
					Block.makeCuboidShape(6, 10, 11, 10, 12, 12), Block.makeCuboidShape(7, 2, 1, 9, 4, 3))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(2, 0, 2, 14, 3, 14), Block.makeCuboidShape(3, 3, 3, 13, 4, 13),
					Block.makeCuboidShape(13, 0, 13, 15, 11, 15), Block.makeCuboidShape(13, 0, 1, 15, 11, 3),
					Block.makeCuboidShape(1, 0, 1, 3, 11, 3), Block.makeCuboidShape(1, 0, 13, 3, 11, 15),
					Block.makeCuboidShape(7, 4, 7, 9, 10, 9), Block.makeCuboidShape(5, 10, 5, 11, 13, 11),
					Block.makeCuboidShape(6, 13, 6, 10, 14, 10), Block.makeCuboidShape(6, 10, 11, 10, 12, 12),
					Block.makeCuboidShape(6, 10, 4, 10, 12, 5), Block.makeCuboidShape(11, 10, 6, 12, 12, 10),
					Block.makeCuboidShape(4, 10, 6, 5, 12, 10), Block.makeCuboidShape(13, 2, 7, 15, 4, 9))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream
			.of(Block.makeCuboidShape(2, 0, 2, 14, 3, 14), Block.makeCuboidShape(3, 3, 3, 13, 4, 13),
					Block.makeCuboidShape(1, 0, 13, 3, 11, 15), Block.makeCuboidShape(13, 0, 13, 15, 11, 15),
					Block.makeCuboidShape(13, 0, 1, 15, 11, 3), Block.makeCuboidShape(1, 0, 1, 3, 11, 3),
					Block.makeCuboidShape(7, 4, 7, 9, 10, 9), Block.makeCuboidShape(5, 10, 5, 11, 13, 11),
					Block.makeCuboidShape(6, 13, 6, 10, 14, 10), Block.makeCuboidShape(4, 10, 6, 5, 12, 10),
					Block.makeCuboidShape(11, 10, 6, 12, 12, 10), Block.makeCuboidShape(6, 10, 11, 10, 12, 12),
					Block.makeCuboidShape(6, 10, 4, 10, 12, 5), Block.makeCuboidShape(7, 2, 13, 9, 4, 15))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream
			.of(Block.makeCuboidShape(2, 0, 2, 14, 3, 14), Block.makeCuboidShape(3, 3, 3, 13, 4, 13),
					Block.makeCuboidShape(1, 0, 1, 3, 11, 3), Block.makeCuboidShape(1, 0, 13, 3, 11, 15),
					Block.makeCuboidShape(13, 0, 13, 15, 11, 15), Block.makeCuboidShape(13, 0, 1, 15, 11, 3),
					Block.makeCuboidShape(7, 4, 7, 9, 10, 9), Block.makeCuboidShape(5, 10, 5, 11, 13, 11),
					Block.makeCuboidShape(6, 13, 6, 10, 14, 10), Block.makeCuboidShape(6, 10, 4, 10, 12, 5),
					Block.makeCuboidShape(6, 10, 11, 10, 12, 12), Block.makeCuboidShape(4, 10, 6, 5, 12, 10),
					Block.makeCuboidShape(11, 10, 6, 12, 12, 10), Block.makeCuboidShape(1, 2, 7, 3, 4, 9))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public MushrineBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case NORTH:
			return SHAPE_N;

		case SOUTH:
			return SHAPE_S;

		case EAST:
			return SHAPE_E;

		case WEST:
			return SHAPE_W;

		default:
			return SHAPE_N;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote()) {
			if (player.dimension == DimensionType.OVERWORLD) {
				teleportToDimension(player, DimensionManager.registerOrGetDimension(WorldSalad.HYPHAE_DIM_TYPE,
						DimensionInit.HYPHAE_DIM.get(), null, true), pos);
			} else if (player.dimension == DimensionType.THE_END || player.dimension == DimensionType.THE_NETHER) {
				return null;
			} else if (player.dimension == DimensionManager.registerOrGetDimension(WorldSalad.HYPHAE_DIM_TYPE,
					DimensionInit.HYPHAE_DIM.get(), null, true)) {
				teleportToDimension(player, DimensionType.OVERWORLD, pos);
			}
		}
		return ActionResultType.SUCCESS;
	}

	private void teleportToDimension(PlayerEntity player, DimensionType dimension, BlockPos pos) {
		player.changeDimension(dimension, new ITeleporter() {
			@Override
			public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw,
					Function<Boolean, Entity> repositionEntity) {

				entity = repositionEntity.apply(false);

				int i = 0;
				while (!entity.world.getBlockState(new BlockPos(pos.getX(), pos.getY() + i, pos.getZ())).getBlock().equals(Blocks.AIR) && !entity.world.getBlockState(new BlockPos(pos.getX(), pos.getY() + i + 1, pos.getZ())).getBlock().equals(Blocks.AIR)) {
					i++;
				}
				while (entity.world.getBlockState(new BlockPos(pos.getX(), pos.getY() + i - 1, pos.getZ())).getBlock().equals(Blocks.AIR)) {
					i--;
				}
				Material material = entity.world.getBlockState(new BlockPos(pos.getX(), pos.getY() + i - 1, pos.getZ())).getMaterial();
				Material materialup = entity.world.getBlockState(new BlockPos(pos.getX(), pos.getY() + i, pos.getZ())).getMaterial();
				entity.setPositionAndUpdate(pos.getX(), pos.getY() + i + 1, pos.getZ());
				
				{
					if (materialup.isLiquid()) {
						destWorld.setBlockState(new BlockPos(pos.getX(), pos.getY() + i, pos.getZ()), BlockInit.FUNGAL_DIRT.get().getDefaultState());
						destWorld.setBlockState(new BlockPos(pos.getX(), pos.getY() + i, pos.getZ() - 1), BlockInit.FUNGAL_DIRT.get().getDefaultState());
						destWorld.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + i, pos.getZ() - 1), BlockInit.FUNGAL_DIRT.get().getDefaultState());
						destWorld.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + i, pos.getZ()), BlockInit.FUNGAL_DIRT.get().getDefaultState());
						}
				else if (material.isLiquid()) {
					destWorld.setBlockState(new BlockPos(pos.getX(), pos.getY() + i - 1, pos.getZ()), BlockInit.FUNGAL_DIRT.get().getDefaultState());
					destWorld.setBlockState(new BlockPos(pos.getX(), pos.getY() + i - 1, pos.getZ() - 1), BlockInit.FUNGAL_DIRT.get().getDefaultState());
					destWorld.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + i - 1, pos.getZ() - 1), BlockInit.FUNGAL_DIRT.get().getDefaultState());
					destWorld.setBlockState(new BlockPos(pos.getX() - 1, pos.getY() + i - 1, pos.getZ()), BlockInit.FUNGAL_DIRT.get().getDefaultState());
					}

				return entity;
				}
			}
		});
	}
}
