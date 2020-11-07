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

public class MadroneTree extends Tree {
	public static final TreeFeatureConfig MADRONE_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.MADRONE_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.MADRONE_LEAVES.get().getDefaultState()), new AcaciaFoliagePlacer(3, 0)))
					.baseHeight(6).heightRandA(2).foliageHeight(4)
					.setSapling((IPlantable) BlockInit.MADRONE_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return Feature.ACACIA_TREE.withConfiguration(MADRONE_TREE_CONFIG);
	}
}
