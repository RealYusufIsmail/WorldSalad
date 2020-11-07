package com.radioctivetacoo.worldsalad.objects.blocks.machines;

import java.util.stream.Stream;

import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.tileentity.ArchaeologyStationTileEntity;
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

public class ArchaeologyStationBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(2, 10, 2, 14, 11, 8),
			Block.makeCuboidShape(2, 10, 8, 14, 11, 10),
			Block.makeCuboidShape(2, 10, 0, 14, 11, 2),
			Block.makeCuboidShape(14, 10, 0, 16, 11, 10),
			Block.makeCuboidShape(0, 10, 0, 2, 11, 10),
			Block.makeCuboidShape(0, 10, 10, 16, 16, 16),
			Block.makeCuboidShape(0, 0, 0, 16, 10, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(2, 10, 2, 8, 11, 14),
			Block.makeCuboidShape(8, 10, 2, 10, 11, 14),
			Block.makeCuboidShape(0, 10, 2, 2, 11, 14),
			Block.makeCuboidShape(0, 10, 0, 10, 11, 2),
			Block.makeCuboidShape(0, 10, 14, 10, 11, 16),
			Block.makeCuboidShape(10, 10, 0, 16, 16, 16),
			Block.makeCuboidShape(0, 0, 0, 16, 10, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(8, 10, 2, 14, 11, 14),
			Block.makeCuboidShape(6, 10, 2, 8, 11, 14),
			Block.makeCuboidShape(14, 10, 2, 16, 11, 14),
			Block.makeCuboidShape(6, 10, 14, 16, 11, 16),
			Block.makeCuboidShape(6, 10, 0, 16, 11, 2),
			Block.makeCuboidShape(0, 10, 0, 6, 16, 16),
			Block.makeCuboidShape(0, 0, 0, 16, 10, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(2, 10, 8, 14, 11, 14),
			Block.makeCuboidShape(2, 10, 6, 14, 11, 8),
			Block.makeCuboidShape(2, 10, 14, 14, 11, 16),
			Block.makeCuboidShape(0, 10, 6, 2, 11, 16),
			Block.makeCuboidShape(14, 10, 6, 16, 11, 16),
			Block.makeCuboidShape(0, 10, 0, 16, 16, 6),
			Block.makeCuboidShape(0, 0, 0, 16, 10, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public ArchaeologyStationBlock(Properties properties) {
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
		return TileEntityInit.ARCHAEOLOGY_STATION.get().create();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (stack.hasDisplayName()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof ArchaeologyStationTileEntity) {
				((ArchaeologyStationTileEntity) tile).setCustomName(stack.getDisplayName());
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
			if (tile instanceof ArchaeologyStationTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof ArchaeologyStationTileEntity && state.getBlock() != newState.getBlock()) {
			ArchaeologyStationTileEntity furnace = (ArchaeologyStationTileEntity) tile;
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
