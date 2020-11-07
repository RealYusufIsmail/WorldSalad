package com.radioctivetacoo.worldsalad.world.biomes;

import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.world.gen.carvers.HyphaeCarver;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MushroomCanyonFlatsBiome extends Biome {
	@Override
	@OnlyIn(Dist.CLIENT)
	public int getSkyColor() {
		return 0xd4d385;
	}

	@Override
	public float getSpawningChance() {
		return 8F;
	}
	
	private static final BlockState DESERT_SHAGGY_MANE = BlockInit.DESERT_SHAGGY_MANE.get().getDefaultState();
	private static final BlockState LICHENBLOCK = BlockInit.LICHEN.get().getDefaultState();
	BlockClusterFeatureConfig SHAGGYMANE = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DESERT_SHAGGY_MANE), new SimpleBlockPlacer())).tries(4).func_227317_b_().build();
	public static final BlockClusterFeatureConfig SUGAR_CANE_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.DRY_REED.get().getDefaultState()), new ColumnBlockPlacer(2, 2)))
					.tries(70).xSpread(4).ySpread(0).zSpread(4).func_227317_b_().requiresWater().build();
	BlockClusterFeatureConfig LICHEN = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LICHENBLOCK), new SimpleBlockPlacer())).tries(15).func_227317_b_().build();

	public MushroomCanyonFlatsBiome(Builder biomeBuilder) {
		super(biomeBuilder);

		this.addCarver(GenerationStage.Carving.LIQUID,
				Biome.createCarver(new HyphaeCarver(ProbabilityConfig::deserialize), new ProbabilityConfig(0.2f)));

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(SUGAR_CANE_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1000))));
		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.WATER.getDefaultState()))
						.withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(4))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(SHAGGYMANE).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(7, 0.05F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(LICHEN).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(5, 0.05F))));

		@SuppressWarnings("rawtypes")
		ConfiguredPlacement customConfig0 = Placement.COUNT_RANGE.configure(new CountRangeConfig(150, 10, 5, 230));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(
						OreFeatureConfig.FillerBlockType.create("DIRT", null,
								new BlockMatcher(Blocks.DIRT)),
						BlockInit.FUNGAL_DIRT.get().getDefaultState(), 100)).withPlacement(customConfig0));
	}
}
