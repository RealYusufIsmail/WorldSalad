package com.radioctivetacoo.worldsalad.objects.blocks.machines;

import java.util.stream.Stream;

import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.tileentity.DistillerTileEntity;
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
import net.minecraft.state.BooleanProperty;
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

public class DistillerBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public static final BooleanProperty HAS_BOILER = BooleanProperty.create("has_boiler");
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(2, 8, 3, 14, 9, 6),
			Block.makeCuboidShape(3, 8, 5, 13, 16, 15),
			Block.makeCuboidShape(2, 0, 3, 14, 3, 6),
			Block.makeCuboidShape(0, 0, 0, 16, 3, 3),
			Block.makeCuboidShape(0, 0, 3, 2, 9, 6),
			Block.makeCuboidShape(14, 0, 3, 16, 9, 6),
			Block.makeCuboidShape(0, 4, 12, 16, 7, 15),
			Block.makeCuboidShape(2, 3, 2, 14, 8, 16),
			Block.makeCuboidShape(0, 0, 6, 16, 3, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(10, 8, 2, 13, 9, 14),
			Block.makeCuboidShape(1, 8, 3, 11, 16, 13),
			Block.makeCuboidShape(10, 0, 2, 13, 3, 14),
			Block.makeCuboidShape(13, 0, 0, 16, 3, 16),
			Block.makeCuboidShape(10, 0, 0, 13, 9, 2),
			Block.makeCuboidShape(10, 0, 14, 13, 9, 16),
			Block.makeCuboidShape(1, 4, 0, 4, 7, 16),
			Block.makeCuboidShape(0, 3, 2, 14, 8, 14),
			Block.makeCuboidShape(0, 0, 0, 10, 3, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(3, 8, 2, 6, 9, 14),
			Block.makeCuboidShape(5, 8, 3, 15, 16, 13),
			Block.makeCuboidShape(3, 0, 2, 6, 3, 14),
			Block.makeCuboidShape(0, 0, 0, 3, 3, 16),
			Block.makeCuboidShape(3, 0, 0, 6, 9, 2),
			Block.makeCuboidShape(3, 0, 14, 6, 9, 16),
			Block.makeCuboidShape(12, 4, 0, 15, 7, 16),
			Block.makeCuboidShape(2, 3, 2, 16, 8, 14),
			Block.makeCuboidShape(6, 0, 0, 16, 3, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(2, 8, 10, 14, 9, 13),
			Block.makeCuboidShape(3, 8, 1, 13, 16, 11),
			Block.makeCuboidShape(2, 0, 10, 14, 3, 13),
			Block.makeCuboidShape(0, 0, 13, 16, 3, 16),
			Block.makeCuboidShape(0, 0, 10, 2, 9, 13),
			Block.makeCuboidShape(14, 0, 10, 16, 9, 13),
			Block.makeCuboidShape(0, 4, 1, 16, 7, 4),
			Block.makeCuboidShape(2, 3, 0, 14, 8, 14),
			Block.makeCuboidShape(0, 0, 0, 16, 3, 10)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public DistillerBlock(Properties properties) {
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
		return this.getDefaultState().with(LIT, false).with(FACING, context.getPlacementHorizontalFacing().getOpposite());
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
		builder.add(FACING, LIT);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityInit.DISTILLER.get().create();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (stack.hasDisplayName()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof DistillerTileEntity) {
				((DistillerTileEntity) tile).setCustomName(stack.getDisplayName());
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
			if (tile instanceof DistillerTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof DistillerTileEntity && state.getBlock() != newState.getBlock()) {
			DistillerTileEntity furnace = (DistillerTileEntity) tile;
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
