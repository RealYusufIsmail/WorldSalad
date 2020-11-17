package com.radioctivetacoo.worldsalad.objects.blocks.machines;

import java.util.stream.Stream;

import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.tileentity.DistillingBarrelTileEntity;
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

public class DistillingBarrelBlock extends ModMachineBlock {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(3, 2, 2, 13, 12, 15), Block.makeCuboidShape(2, 3, 2, 3, 11, 15),
					Block.makeCuboidShape(4, 12, 2, 12, 13, 15), Block.makeCuboidShape(12, 4, 15, 13, 10, 16),
					Block.makeCuboidShape(3, 4, 15, 4, 10, 16), Block.makeCuboidShape(5, 2, 1, 11, 3, 2),
					Block.makeCuboidShape(5, 11, 1, 11, 12, 2), Block.makeCuboidShape(3, 4, 1, 4, 10, 2),
					Block.makeCuboidShape(12, 4, 1, 13, 10, 2), Block.makeCuboidShape(4, 3, 1, 12, 11, 2),
					Block.makeCuboidShape(5, 2, 15, 11, 3, 16), Block.makeCuboidShape(5, 11, 15, 11, 12, 16),
					Block.makeCuboidShape(4, 3, 15, 12, 11, 16), Block.makeCuboidShape(7, 3, 0, 9, 6, 1),
					Block.makeCuboidShape(2, 0, 3, 14, 2, 5), Block.makeCuboidShape(2, 0, 12, 14, 2, 14),
					Block.makeCuboidShape(13, 3, 2, 14, 11, 15), Block.makeCuboidShape(4, 1, 2, 12, 2, 15))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream
			.of(Block.makeCuboidShape(2, 2, 3, 15, 12, 13), Block.makeCuboidShape(2, 3, 13, 15, 11, 14),
					Block.makeCuboidShape(2, 12, 4, 15, 13, 12), Block.makeCuboidShape(15, 4, 3, 16, 10, 4),
					Block.makeCuboidShape(15, 4, 12, 16, 10, 13), Block.makeCuboidShape(1, 2, 5, 2, 3, 11),
					Block.makeCuboidShape(1, 11, 5, 2, 12, 11), Block.makeCuboidShape(1, 4, 12, 2, 10, 13),
					Block.makeCuboidShape(1, 4, 3, 2, 10, 4), Block.makeCuboidShape(1, 3, 4, 2, 11, 12),
					Block.makeCuboidShape(15, 2, 5, 16, 3, 11), Block.makeCuboidShape(15, 11, 5, 16, 12, 11),
					Block.makeCuboidShape(15, 3, 4, 16, 11, 12), Block.makeCuboidShape(0, 3, 7, 1, 6, 9),
					Block.makeCuboidShape(3, 0, 2, 5, 2, 14), Block.makeCuboidShape(12, 0, 2, 14, 2, 14),
					Block.makeCuboidShape(2, 3, 2, 15, 11, 3), Block.makeCuboidShape(2, 1, 4, 15, 2, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(1, 2, 3, 14, 12, 13), Block.makeCuboidShape(1, 3, 2, 14, 11, 3),
					Block.makeCuboidShape(1, 12, 4, 14, 13, 12), Block.makeCuboidShape(0, 4, 12, 1, 10, 13),
					Block.makeCuboidShape(0, 4, 3, 1, 10, 4), Block.makeCuboidShape(14, 2, 5, 15, 3, 11),
					Block.makeCuboidShape(14, 11, 5, 15, 12, 11), Block.makeCuboidShape(14, 4, 3, 15, 10, 4),
					Block.makeCuboidShape(14, 4, 12, 15, 10, 13), Block.makeCuboidShape(14, 3, 4, 15, 11, 12),
					Block.makeCuboidShape(0, 2, 5, 1, 3, 11), Block.makeCuboidShape(0, 11, 5, 1, 12, 11),
					Block.makeCuboidShape(0, 3, 4, 1, 11, 12), Block.makeCuboidShape(15, 3, 7, 16, 6, 9),
					Block.makeCuboidShape(11, 0, 2, 13, 2, 14), Block.makeCuboidShape(2, 0, 2, 4, 2, 14),
					Block.makeCuboidShape(1, 3, 13, 14, 11, 14), Block.makeCuboidShape(1, 1, 4, 14, 2, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream
			.of(Block.makeCuboidShape(3, 2, 1, 13, 12, 14), Block.makeCuboidShape(13, 3, 1, 14, 11, 14),
					Block.makeCuboidShape(4, 12, 1, 12, 13, 14), Block.makeCuboidShape(3, 4, 0, 4, 10, 1),
					Block.makeCuboidShape(12, 4, 0, 13, 10, 1), Block.makeCuboidShape(5, 2, 14, 11, 3, 15),
					Block.makeCuboidShape(5, 11, 14, 11, 12, 15), Block.makeCuboidShape(12, 4, 14, 13, 10, 15),
					Block.makeCuboidShape(3, 4, 14, 4, 10, 15), Block.makeCuboidShape(4, 3, 14, 12, 11, 15),
					Block.makeCuboidShape(5, 2, 0, 11, 3, 1), Block.makeCuboidShape(5, 11, 0, 11, 12, 1),
					Block.makeCuboidShape(4, 3, 0, 12, 11, 1), Block.makeCuboidShape(7, 3, 15, 9, 6, 16),
					Block.makeCuboidShape(2, 0, 11, 14, 2, 13), Block.makeCuboidShape(2, 0, 2, 14, 2, 4),
					Block.makeCuboidShape(2, 3, 1, 3, 11, 14), Block.makeCuboidShape(4, 1, 1, 12, 2, 14))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public DistillingBarrelBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

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
		return TileEntityInit.DISTILLING_BARREL.get().create();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (stack.hasDisplayName()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof DistillingBarrelTileEntity) {
				((DistillingBarrelTileEntity) tile).setCustomName(stack.getDisplayName());
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
			if (tile instanceof DistillingBarrelTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof DistillingBarrelTileEntity && state.getBlock() != newState.getBlock()) {
			DistillingBarrelTileEntity furnace = (DistillingBarrelTileEntity) tile;
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
