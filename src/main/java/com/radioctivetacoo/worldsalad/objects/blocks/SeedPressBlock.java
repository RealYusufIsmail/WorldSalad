package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.stream.Stream;

import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.tileentity.SeedPressTileEntity;
import com.radioctivetacoo.worldsalad.util.WorldSaladItemHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
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
import net.minecraftforge.fml.network.NetworkHooks;

public class SeedPressBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(7, 12, 7, 9, 25, 9),
			Block.makeCuboidShape(5, 4, 2, 11, 6, 3), Block.makeCuboidShape(3, 5, 13, 13, 14, 15),
			Block.makeCuboidShape(13, 5, 2, 15, 8, 7), Block.makeCuboidShape(13, 5, 10, 15, 8, 15),
			Block.makeCuboidShape(13, 8, 2, 15, 14, 15), Block.makeCuboidShape(1, 5, 2, 3, 14, 15),
			Block.makeCuboidShape(0, 14, 0, 16, 16, 16), Block.makeCuboidShape(3, 11, 3, 13, 12, 13),
			Block.makeCuboidShape(3, 5, 3, 13, 6, 13), Block.makeCuboidShape(0, 0, 0, 16, 5, 16)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream
			.of(Block.makeCuboidShape(7, 12, 7, 9, 25, 9), Block.makeCuboidShape(3, 5, 1, 13, 14, 3),
					Block.makeCuboidShape(1, 5, 9, 3, 8, 14), Block.makeCuboidShape(1, 5, 1, 3, 8, 6),
					Block.makeCuboidShape(1, 8, 1, 3, 14, 14), Block.makeCuboidShape(13, 5, 1, 15, 14, 14),
					Block.makeCuboidShape(0, 14, 0, 16, 16, 16), Block.makeCuboidShape(3, 11, 3, 13, 12, 13),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13), Block.makeCuboidShape(0, 0, 0, 16, 5, 16))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream
			.of(Block.makeCuboidShape(7, 12, 7, 9, 25, 9), Block.makeCuboidShape(13, 5, 3, 15, 14, 13),
					Block.makeCuboidShape(2, 5, 1, 7, 8, 3), Block.makeCuboidShape(10, 5, 1, 15, 8, 3),
					Block.makeCuboidShape(2, 8, 1, 15, 14, 3), Block.makeCuboidShape(2, 5, 13, 15, 14, 15),
					Block.makeCuboidShape(0, 14, 0, 16, 16, 16), Block.makeCuboidShape(3, 11, 3, 13, 12, 13),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13), Block.makeCuboidShape(0, 0, 0, 16, 5, 16))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(7, 12, 7, 9, 25, 9), Block.makeCuboidShape(1, 5, 3, 3, 14, 13),
					Block.makeCuboidShape(9, 5, 13, 14, 8, 15), Block.makeCuboidShape(1, 5, 13, 6, 8, 15),
					Block.makeCuboidShape(1, 8, 13, 14, 14, 15), Block.makeCuboidShape(1, 5, 1, 14, 14, 3),
					Block.makeCuboidShape(0, 14, 0, 16, 16, 16), Block.makeCuboidShape(3, 11, 3, 13, 12, 13),
					Block.makeCuboidShape(3, 5, 3, 13, 6, 13), Block.makeCuboidShape(0, 0, 0, 16, 5, 16))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public SeedPressBlock(Properties properties) {
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
		super.fillStateContainer(builder);
		builder.add(FACING);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityInit.SEED_PRESS.get().create();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (stack.hasDisplayName()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof SeedPressTileEntity) {
				((SeedPressTileEntity) tile).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (worldIn != null && !worldIn.isRemote) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof SeedPressTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof SeedPressTileEntity && state.getBlock() != newState.getBlock()) {
			SeedPressTileEntity furnace = (SeedPressTileEntity) tile;
			((WorldSaladItemHandler) furnace.getInventory()).toNonNullList().forEach(item -> {
				ItemEntity itemEntity = new ItemEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), item);
				worldIn.addEntity(itemEntity);
			});
		}

		if (state.hasTileEntity() && state.getBlock() != newState.getBlock()) {
			worldIn.removeTileEntity(pos);
		}
	}
}
