package com.radioctivetacoo.worldsalad.objects.blocks.machines;

import java.util.stream.Stream;

import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.tileentity.HydraulicPressTileEntity;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class HydraulicPressBlock extends ModMachineBlock {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 3, 16),
			Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
			Block.makeCuboidShape(2, 3, 2, 14, 4, 14),
			Block.makeCuboidShape(14, 3, 10, 16, 13, 16),
			Block.makeCuboidShape(0, 3, 10, 2, 13, 16),
			Block.makeCuboidShape(2, 3, 14, 14, 13, 16),
			Block.makeCuboidShape(0, 11, 0, 2, 13, 10),
			Block.makeCuboidShape(14, 11, 0, 16, 13, 10),
			Block.makeCuboidShape(3, 12, 3, 13, 13, 13),
			Block.makeCuboidShape(0, 16, 8, 3, 19, 15),
			Block.makeCuboidShape(5, 16, 5, 11, 23, 11),
			Block.makeCuboidShape(6, 23, 6, 10, 25, 11),
			Block.makeCuboidShape(3, 16, 8, 6, 24, 11),
			Block.makeCuboidShape(3, 16, 11, 15, 22, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 3, 16),
			Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
			Block.makeCuboidShape(2, 3, 2, 14, 4, 14),
			Block.makeCuboidShape(0, 3, 14, 6, 13, 16),
			Block.makeCuboidShape(0, 3, 0, 6, 13, 2),
			Block.makeCuboidShape(0, 3, 2, 2, 13, 14),
			Block.makeCuboidShape(6, 11, 0, 16, 13, 2),
			Block.makeCuboidShape(6, 11, 14, 16, 13, 16),
			Block.makeCuboidShape(3, 12, 3, 13, 13, 13),
			Block.makeCuboidShape(1, 16, 0, 8, 19, 3),
			Block.makeCuboidShape(5, 16, 5, 11, 23, 11),
			Block.makeCuboidShape(5, 23, 6, 10, 25, 10),
			Block.makeCuboidShape(5, 16, 3, 8, 24, 6),
			Block.makeCuboidShape(0, 16, 3, 5, 22, 15)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 3, 16),
			Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
			Block.makeCuboidShape(2, 3, 2, 14, 4, 14),
			Block.makeCuboidShape(0, 3, 0, 2, 13, 6),
			Block.makeCuboidShape(14, 3, 0, 16, 13, 6),
			Block.makeCuboidShape(2, 3, 0, 14, 13, 2),
			Block.makeCuboidShape(14, 11, 6, 16, 13, 16),
			Block.makeCuboidShape(0, 11, 6, 2, 13, 16),
			Block.makeCuboidShape(3, 12, 3, 13, 13, 13),
			Block.makeCuboidShape(13, 16, 1, 16, 19, 8),
			Block.makeCuboidShape(5, 16, 5, 11, 23, 11),
			Block.makeCuboidShape(6, 23, 5, 10, 25, 10),
			Block.makeCuboidShape(10, 16, 5, 13, 24, 8),
			Block.makeCuboidShape(1, 16, 0, 13, 22, 5)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 3, 16),
			Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
			Block.makeCuboidShape(2, 3, 2, 14, 4, 14),
			Block.makeCuboidShape(10, 3, 0, 16, 13, 2),
			Block.makeCuboidShape(10, 3, 14, 16, 13, 16),
			Block.makeCuboidShape(14, 3, 2, 16, 13, 14),
			Block.makeCuboidShape(0, 11, 14, 10, 13, 16),
			Block.makeCuboidShape(0, 11, 0, 10, 13, 2),
			Block.makeCuboidShape(3, 12, 3, 13, 13, 13),
			Block.makeCuboidShape(8, 16, 13, 15, 19, 16),
			Block.makeCuboidShape(5, 16, 5, 11, 23, 11),
			Block.makeCuboidShape(6, 23, 6, 11, 25, 10),
			Block.makeCuboidShape(8, 16, 10, 11, 24, 13),
			Block.makeCuboidShape(11, 16, 1, 16, 22, 13)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public HydraulicPressBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
	      return true;
	   }
	
	 @OnlyIn(Dist.CLIENT)
	   public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      return 1.0F;
	   }
	
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      return false;
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
		return TileEntityInit.HYDRAULIC_PRESS.get().create();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (stack.hasDisplayName()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof HydraulicPressTileEntity) {
				((HydraulicPressTileEntity) tile).setCustomName(stack.getDisplayName());
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
			if (tile instanceof HydraulicPressTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof HydraulicPressTileEntity && state.getBlock() != newState.getBlock()) {
			HydraulicPressTileEntity furnace = (HydraulicPressTileEntity) tile;
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
