package com.radioctivetacoo.worldsalad.world.feature;

import java.util.Random;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;

import net.minecraftforge.common.IPlantable;

public class TallMadroneTree extends Tree {
	public static final TreeFeatureConfig TALL_MADRONE_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.MADRONE_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.DENSE_MADRONE_LEAVES.get().getDefaultState()), new AcaciaFoliagePlacer(4, 0)))
					.baseHeight(14).heightRandA(0).foliageHeight(1)
					.setSapling((IPlantable) BlockInit.MADRONE_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.ACACIA_TREE.withConfiguration(TALL_MADRONE_TREE_CONFIG);
	}
}
