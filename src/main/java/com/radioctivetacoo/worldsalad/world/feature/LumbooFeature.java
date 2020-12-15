package com.radioctivetacoo.worldsalad.world.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.BambooBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.properties.BambooLeaves;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.BambooFeature;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class LumbooFeature extends BambooFeature {

	private static final BlockState LUMBOO_BASE = BlockInit.LUMBOO.get().getDefaultState().with(BambooBlock.PROPERTY_AGE, Integer.valueOf(1)).with(BambooBlock.PROPERTY_BAMBOO_LEAVES, BambooLeaves.NONE).with(BambooBlock.PROPERTY_STAGE, Integer.valueOf(0));
	   private static final BlockState LUMBOO_LARGE_LEAVES_GROWN = LUMBOO_BASE.with(BambooBlock.PROPERTY_BAMBOO_LEAVES, BambooLeaves.LARGE).with(BambooBlock.PROPERTY_STAGE, Integer.valueOf(1));
	   private static final BlockState LUMBOO_LARGE_LEAVES = LUMBOO_BASE.with(BambooBlock.PROPERTY_BAMBOO_LEAVES, BambooLeaves.LARGE);
	   private static final BlockState LUMBOO_SMALL_LEAVES = LUMBOO_BASE.with(BambooBlock.PROPERTY_BAMBOO_LEAVES, BambooLeaves.SMALL);

	   public LumbooFeature(Function<Dynamic<?>, ? extends ProbabilityConfig> p_i49919_1_) {
	      super(p_i49919_1_);
	   }

	   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, ProbabilityConfig config) {
	      int i = 0;
	      BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(pos);
	      BlockPos.Mutable blockpos$mutable1 = new BlockPos.Mutable(pos);
	      if (worldIn.isAirBlock(blockpos$mutable)) {
	         if (BlockInit.LUMBOO.get().getDefaultState().isValidPosition(worldIn, blockpos$mutable)) {
	            int j = rand.nextInt(12) + 5;
	            if (rand.nextFloat() < config.probability) {
	               int k = rand.nextInt(4) + 1;

	               for(int l = pos.getX() - k; l <= pos.getX() + k; ++l) {
	                  for(int i1 = pos.getZ() - k; i1 <= pos.getZ() + k; ++i1) {
	                     int j1 = l - pos.getX();
	                     int k1 = i1 - pos.getZ();
	                     if (j1 * j1 + k1 * k1 <= k * k) {
	                        blockpos$mutable1.setPos(l, worldIn.getHeight(Heightmap.Type.WORLD_SURFACE, l, i1) - 1, i1);
	                        if (isDirt(worldIn.getBlockState(blockpos$mutable1).getBlock())) {
	                           worldIn.setBlockState(blockpos$mutable1, BlockInit.INFERTILE_SOIL.get().getDefaultState(), 2);
	                        }
	                     }
	                  }
	               }
	            }

	            for(int l1 = 0; l1 < j && worldIn.isAirBlock(blockpos$mutable); ++l1) {
	               worldIn.setBlockState(blockpos$mutable, LUMBOO_BASE, 2);
	               blockpos$mutable.move(Direction.UP, 1);
	            }

	            if (blockpos$mutable.getY() - pos.getY() >= 3) {
	               worldIn.setBlockState(blockpos$mutable, LUMBOO_LARGE_LEAVES_GROWN, 2);
	               worldIn.setBlockState(blockpos$mutable.move(Direction.DOWN, 1), LUMBOO_LARGE_LEAVES, 2);
	               worldIn.setBlockState(blockpos$mutable.move(Direction.DOWN, 1), LUMBOO_SMALL_LEAVES, 2);
	            }
	         }

	         ++i;
	      }

	      return i > 0;
	   }
}
