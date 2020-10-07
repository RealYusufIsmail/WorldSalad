package com.radioctivetacoo.worldsalad.objects.blocks;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class ModLogBlock extends LogBlock {



	public ModLogBlock(MaterialColor verticalColorIn, Properties properties) {
		super(verticalColorIn, properties);
	}

	@SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
            Hand handIn, BlockRayTraceResult hit) {
        if(player.getHeldItem(handIn) != null) {
            Item item = player.getHeldItem(handIn).getItem();
            if (item instanceof AxeItem) {
            	if (this == BlockInit.WILLOW_LOG.get()) {worldIn.setBlockState(pos, BlockInit.STRIPPED_WILLOW_LOG.get().getDefaultState());}
            	if (this == BlockInit.WILLOW_WOOD.get()) {worldIn.setBlockState(pos, BlockInit.STRIPPED_WILLOW_WOOD.get().getDefaultState());}
            	if (this == BlockInit.BLEACHED_LOG.get()) {worldIn.setBlockState(pos, BlockInit.STRIPPED_BLEACHED_LOG.get().getDefaultState());}
            	if (this == BlockInit.BLEACHED_WOOD.get()) {worldIn.setBlockState(pos, BlockInit.STRIPPED_BLEACHED_WOOD.get().getDefaultState());}
                worldIn.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 0.7F, 1F);
            }
       }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
