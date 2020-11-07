package com.radioctivetacoo.worldsalad.objects.blocks.machines;

import java.util.stream.Stream;

import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.tileentity.FloatationBinTileEntity;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class FloatationBinBlock extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	private static final VoxelShape SHAPE_NS = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 11, 16),
			Block.makeCuboidShape(1, 11, 1, 15, 16, 15),
			Block.makeCuboidShape(0, 12, 10, 1, 15, 13),
			Block.makeCuboidShape(0, 12, 3, 1, 15, 6),
			Block.makeCuboidShape(15, 12, 10, 16, 15, 13),
			Block.makeCuboidShape(15, 12, 3, 16, 15, 6)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_WE = Stream.of(
			Block.makeCuboidShape(0, 0, 0, 16, 11, 16),
			Block.makeCuboidShape(1, 11, 1, 15, 16, 15),
			Block.makeCuboidShape(3, 12, 0, 6, 15, 1),
			Block.makeCuboidShape(10, 12, 0, 13, 15, 1),
			Block.makeCuboidShape(3, 12, 15, 6, 15, 16),
			Block.makeCuboidShape(10, 12, 15, 13, 15, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	public FloatationBinBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(LIT, false));
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
			return SHAPE_NS;

		case SOUTH:
			return SHAPE_NS;

		case EAST:
			return SHAPE_WE;

		case WEST:
			return SHAPE_WE;

		default:
			return SHAPE_NS;
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
		builder.add(FACING, LIT);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityInit.FLOATATION_BIN.get().create();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (stack.hasDisplayName()) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof FloatationBinTileEntity) {
				((FloatationBinTileEntity) tile).setCustomName(stack.getDisplayName());
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
			if (tile instanceof FloatationBinTileEntity) {
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tile, pos);
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof FloatationBinTileEntity && state.getBlock() != newState.getBlock()) {
			FloatationBinTileEntity furnace = (FloatationBinTileEntity) tile;
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
