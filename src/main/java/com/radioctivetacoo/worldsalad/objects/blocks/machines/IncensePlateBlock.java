package com.radioctivetacoo.worldsalad.objects.blocks.machines;

import java.util.Random;

import com.radioctivetacoo.worldsalad.init.ItemInit;
import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.tileentity.HydraulicPressTileEntity;
import com.radioctivetacoo.worldsalad.util.WorldSaladItemHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class IncensePlateBlock extends ModMachineBlock {
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public static final BooleanProperty HAS_STICK = BooleanProperty.create("has_stick");
	//stick type; 0=empty, 1=burnt out, 2=regen, 3=strength, 4=speed, 5=jump boost, 6=fire resistance, 7=night vision
	public static final IntegerProperty STICK_TYPE = IntegerProperty.create("stick_type", 0, 7);
	private static final VoxelShape SHAPE = Block.makeCuboidShape(4, 0, 4, 12, 10, 12);
	public IncensePlateBlock(Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
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
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getHeldItem(handIn);
		Item item = itemstack.getItem();
		if (item.equals(Items.FLINT_AND_STEEL) && state.get(HAS_STICK) == true && state.get(LIT) == false) {
		    worldIn.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
		    if (!player.abilities.isCreativeMode) {
				itemstack.damageItem(1, player, (p_220017_1_) -> {
		            p_220017_1_.sendBreakAnimation(handIn);
		         });
	            }
		    worldIn.setBlockState(pos, state.with(LIT, true));
		    return ActionResultType.SUCCESS;
		}
		else if (state.get(HAS_STICK) == true) {
				player.inventory.addItemStackToInventory(new ItemStack(ItemInit.INCENSE_STICK.get()));
				worldIn.setBlockState(pos, state.with(HAS_STICK, Boolean.valueOf(false)).with(LIT, Boolean.valueOf(false)));
				return ActionResultType.PASS;
			}
		else if (item.equals(ItemInit.INCENSE_STICK_REGENERATION.get()) && state.get(HAS_STICK) == false) {
	    	worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
	    	if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
                if (itemstack.isEmpty()) {
                   player.inventory.deleteStack(itemstack);
                }
             }
	    	worldIn.setBlockState(pos, state.with(HAS_STICK, Boolean.valueOf(true)).with(STICK_TYPE, 2));
	    	return ActionResultType.SUCCESS;
	    }
		else if (item.equals(ItemInit.INCENSE_STICK_STRENGTH.get()) && state.get(HAS_STICK) == false) {
	    	worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
	    	if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
                if (itemstack.isEmpty()) {
                   player.inventory.deleteStack(itemstack);
                }
             }
	    	worldIn.setBlockState(pos, state.with(HAS_STICK, Boolean.valueOf(true)).with(STICK_TYPE, 3));
	    	return ActionResultType.SUCCESS;
	    } 
		else if (item.equals(ItemInit.INCENSE_STICK_SPEED.get()) && state.get(HAS_STICK) == false) {
	    	worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
	    	if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
                if (itemstack.isEmpty()) {
                   player.inventory.deleteStack(itemstack);
                }
             }
	    	worldIn.setBlockState(pos, state.with(HAS_STICK, Boolean.valueOf(true)).with(STICK_TYPE, 4));
	    	return ActionResultType.SUCCESS;
	    } 
		else if (item.equals(ItemInit.INCENSE_STICK_JUMP_BOOST.get()) && state.get(HAS_STICK) == false) {
	    	worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
	    	if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
                if (itemstack.isEmpty()) {
                   player.inventory.deleteStack(itemstack);
                }
             }
	    	worldIn.setBlockState(pos, state.with(HAS_STICK, Boolean.valueOf(true)).with(STICK_TYPE, 5));
	    	return ActionResultType.SUCCESS;
	    } 
		else if (item.equals(ItemInit.INCENSE_STICK_FIRE_RESISTANCE.get()) && state.get(HAS_STICK) == false) {
	    	worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
	    	if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
                if (itemstack.isEmpty()) {
                   player.inventory.deleteStack(itemstack);
                }
             }
	    	worldIn.setBlockState(pos, state.with(HAS_STICK, Boolean.valueOf(true)).with(STICK_TYPE, 6));
	    	return ActionResultType.SUCCESS;
	    } 
		else if (item.equals(ItemInit.INCENSE_STICK_NIGHT_VISION.get()) && state.get(HAS_STICK) == false) {
	    	worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_BAMBOO_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
	    	if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
                if (itemstack.isEmpty()) {
                   player.inventory.deleteStack(itemstack);
                }
             }
	    	worldIn.setBlockState(pos, state.with(HAS_STICK, Boolean.valueOf(true)).with(STICK_TYPE, 7));
	    	return ActionResultType.SUCCESS;
	    } else {
        return ActionResultType.PASS;
        
     }
	}
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(LIT, false).with(HAS_STICK, false).with(STICK_TYPE, 0);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int getLightValue(BlockState state) {
		return state.get(LIT) ? super.getLightValue(state) : 0;
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(LIT, HAS_STICK, STICK_TYPE);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityInit.INCENSE_PLATE.get().create();
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
	
	@OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (stateIn.get(LIT) == true)
		{
	      double d0 = (double)pos.getX() + 0.5D;
	      double d1 = (double)pos.getY() + 0.7D;
	      double d2 = (double)pos.getZ() + 0.5D;
	      worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	      worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	      worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	      worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	      worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	   }
}
