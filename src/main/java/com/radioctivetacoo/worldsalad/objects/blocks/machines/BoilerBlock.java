package com.radioctivetacoo.worldsalad.objects.blocks.machines;

import java.util.stream.Stream;

import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.tileentity.BoilerTileEntity;
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

public class BoilerBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 2, 2, 16),
			Block.makeCuboidShape(0, 2, 14, 2, 14, 16),
			Block.makeCuboidShape(14, 2, 14, 16, 14, 16),
			Block.makeCuboidShape(14, 2, 0, 16, 14, 2),
			Block.makeCuboidShape(0, 2, 0, 2, 14, 2),
			Block.makeCuboidShape(14, 0, 0, 16, 2, 16),
			Block.makeCuboidShape(14, 14, 0, 16, 16, 16),
			Block.makeCuboidShape(0, 14, 0, 2, 16, 16),
			Block.makeCuboidShape(2, 14, 0, 14, 16, 2),
			Block.makeCuboidShape(2, 14, 14, 14, 16, 16),
			Block.makeCuboidShape(3, 0, 0, 13, 10, 16),
			Block.makeCuboidShape(3, 10, 10, 6, 16, 13),
			Block.makeCuboidShape(10, 10, 10, 13, 16, 13),
			Block.makeCuboidShape(5, 10, 2, 11, 11, 8)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 2, 2),
			Block.makeCuboidShape(0, 2, 0, 2, 14, 2),
			Block.makeCuboidShape(0, 2, 14, 2, 14, 16),
			Block.makeCuboidShape(14, 2, 14, 16, 14, 16),
			Block.makeCuboidShape(14, 2, 0, 16, 14, 2),
			Block.makeCuboidShape(0, 0, 14, 16, 2, 16),
			Block.makeCuboidShape(0, 14, 14, 16, 16, 16),
			Block.makeCuboidShape(0, 14, 0, 16, 16, 2),
			Block.makeCuboidShape(14, 14, 2, 16, 16, 14),
			Block.makeCuboidShape(0, 14, 2, 2, 16, 14),
			Block.makeCuboidShape(0, 0, 3, 16, 10, 13),
			Block.makeCuboidShape(3, 10, 3, 6, 16, 6),
			Block.makeCuboidShape(3, 10, 10, 6, 16, 13),
			Block.makeCuboidShape(8, 10, 5, 14, 11, 11)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 2, 2),
			Block.makeCuboidShape(14, 2, 0, 16, 14, 2),
			Block.makeCuboidShape(14, 2, 14, 16, 14, 16),
			Block.makeCuboidShape(0, 2, 14, 2, 14, 16),
			Block.makeCuboidShape(0, 2, 0, 2, 14, 2),
			Block.makeCuboidShape(0, 0, 14, 16, 2, 16),
			Block.makeCuboidShape(0, 14, 14, 16, 16, 16),
			Block.makeCuboidShape(0, 14, 0, 16, 16, 2),
			Block.makeCuboidShape(0, 14, 2, 2, 16, 14),
			Block.makeCuboidShape(14, 14, 2, 16, 16, 14),
			Block.makeCuboidShape(0, 0, 3, 16, 10, 13),
			Block.makeCuboidShape(10, 10, 3, 13, 16, 6),
			Block.makeCuboidShape(10, 10, 10, 13, 16, 13),
			Block.makeCuboidShape(2, 10, 5, 8, 11, 11)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 2, 2, 16),
			Block.makeCuboidShape(0, 2, 0, 2, 14, 2),
			Block.makeCuboidShape(14, 2, 0, 16, 14, 2),
			Block.makeCuboidShape(14, 2, 14, 16, 14, 16),
			Block.makeCuboidShape(0, 2, 14, 2, 14, 16),
			Block.makeCuboidShape(14, 0, 0, 16, 2, 16),
			Block.makeCuboidShape(14, 14, 0, 16, 16, 16),
			Block.makeCuboidShape(0, 14, 0, 2, 16, 16),
			Block.makeCuboidShape(2, 14, 14, 14, 16, 16),
			Block.makeCuboidShape(2, 14, 0, 14, 16, 2),
			Block.makeCuboidShape(3, 0, 0, 13, 10, 16),
			Block.makeCuboidShape(3, 10, 3, 6, 16, 6),
			Block.makeCuboidShape(10, 10, 3, 13, 16, 6),
			Block.makeCuboidShape(5, 10, 8, 11, 11, 14)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public BoilerBlock(Properties properties) {
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
	
	@SuppressWarnings("deprecation")
	@Override
	public int getLightValue(BlockState state) {
		return state.get(LIT) ? super.getLightValue(state) : 0;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityInit.BOILER.get().create();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (stack.hasDisplayName()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof BoilerTileEntity) {
				((BoilerTileEntity) tile).setCustomName(stack.getDisplayName());
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
			if (tile instanceof BoilerTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof BoilerTileEntity && state.getBlock() != newState.getBlock()) {
			BoilerTileEntity furnace = (BoilerTileEntity) tile;
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
