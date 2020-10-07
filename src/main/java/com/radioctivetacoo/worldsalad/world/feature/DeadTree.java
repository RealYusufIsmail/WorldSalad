package com.radioctivetacoo.worldsalad.world.feature;

import java.util.Random;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

public class DeadTree extends Tree {
	public static final TreeFeatureConfig DEAD_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.BLEACHED_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()), new BlobFoliagePlacer(3, 0))).baseHeight(6)
					.heightRandA(1).foliageHeight(3).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.FANCY_TREE.withConfiguration(DEAD_TREE_CONFIG);
	}
}
