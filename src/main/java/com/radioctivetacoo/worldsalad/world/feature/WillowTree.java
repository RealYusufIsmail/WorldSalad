package com.radioctivetacoo.worldsalad.world.feature;

import java.util.Random;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class WillowTree extends Tree {
	public static final TreeFeatureConfig WILLOW_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.WILLOW_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.WILLOW_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(3, 0)))
					.baseHeight(6).heightRandA(1).foliageHeight(3)
					.setSapling((IPlantable) BlockInit.WILLOW_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.NORMAL_TREE.withConfiguration(WILLOW_TREE_CONFIG);
	}
}
