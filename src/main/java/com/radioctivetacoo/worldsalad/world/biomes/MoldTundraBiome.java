package com.radioctivetacoo.worldsalad.world.biomes;

import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.world.feature.DeadTree;
import com.radioctivetacoo.worldsalad.world.gen.carvers.HyphaeCarver;

import net.minecraft.block.BlockState;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockBlobConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MoldTundraBiome extends Biome {

	@Override
	@OnlyIn(Dist.CLIENT)
	public int getSkyColor() {
		return 0x929496;
	}

	@Override
	public float getSpawningChance() {
		return 8F;
	}

	private static final BlockState ROTTING_GRASS = BlockInit.ROTTING_GRASS.get().getDefaultState();
	private static final BlockState MOLD_GROWTH = BlockInit.MOLD_GROWTH.get().getDefaultState();
	BlockClusterFeatureConfig MOLD_GROWTH_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(MOLD_GROWTH), new SimpleBlockPlacer())).tries(12).build();
	BlockClusterFeatureConfig ROTTING_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(ROTTING_GRASS), new SimpleBlockPlacer())).tries(50).build();

	public MoldTundraBiome(Builder biomeBuilder) {

		super(biomeBuilder);

		this.addCarver(GenerationStage.Carving.LIQUID,
				Biome.createCarver(new HyphaeCarver(ProbabilityConfig::deserialize), new ProbabilityConfig(0.2f)));

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FANCY_TREE.withConfiguration(DeadTree.DEAD_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0f, 0))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(MOLD_GROWTH_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(ROTTING_GRASS_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));

		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.FOREST_ROCK
						.withConfiguration(new BlockBlobConfig(BlockInit.MOLD_BLOCK.get().getDefaultState(), 1))
						.withPlacement(Placement.FOREST_ROCK.configure(new FrequencyConfig(2))));

		@SuppressWarnings("rawtypes")
		ConfiguredPlacement customConfig0 = Placement.COUNT_RANGE.configure(new CountRangeConfig(9, 60, 5, 230));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(
						OreFeatureConfig.FillerBlockType.create("MOLDGRASS", null,
								new BlockMatcher(BlockInit.MOLDGRASS.get())),
						BlockInit.INFERTILE_SOIL.get().getDefaultState(), 90)).withPlacement(customConfig0));

	}
}
