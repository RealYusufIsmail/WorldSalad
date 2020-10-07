package com.radioctivetacoo.worldsalad.world.biomes;

import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.FluidInit;
import com.radioctivetacoo.worldsalad.world.gen.carvers.HyphaeGlowingMushroomCarver;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockWithContextConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.TwoFeatureChoiceConfig;
import net.minecraft.world.gen.placement.CaveEdgeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GlowingMushroomBiome extends Biome {
	@Override
	@OnlyIn(Dist.CLIENT)
	public int getSkyColor() {
		return 0x6d6bb5;
	}

	@Override
	public float getSpawningChance() {
		return 8F;
	}

	private static final BlockState MUSHROOM_STEM = Blocks.MUSHROOM_STEM.getDefaultState()
			.with(HugeMushroomBlock.UP, Boolean.valueOf(false)).with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
	private static final BlockState PINK_MUSHROOM_BLOCK = BlockInit.PINK_MUSHROOM_BLOCK.get().getDefaultState()
			.with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
	private static final BlockState GREEN_MUSHROOM_BLOCK = BlockInit.GREEN_MUSHROOM_BLOCK.get().getDefaultState()
			.with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
	private static final BlockState BLUE_MUSHROOM_BLOCK = BlockInit.BLUE_MUSHROOM_BLOCK.get().getDefaultState()
			.with(HugeMushroomBlock.UP, Boolean.valueOf(true)).with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
	private static final BlockState LILY_PAD = Blocks.LILY_PAD.getDefaultState();
	private static final BlockState BLUE_GLOWING_MUSHROOM = BlockInit.BLUE_GLOWING_MUSHROOM.get().getDefaultState();
	private static final BlockState GREEN_GLOWING_MUSHROOM = BlockInit.GREEN_GLOWING_MUSHROOM.get().getDefaultState();
	private static final BlockState PINK_GLOWING_MUSHROOM = BlockInit.PINK_GLOWING_MUSHROOM.get().getDefaultState();
	private static final BlockState MORELBLOCK = BlockInit.MOREL.get().getDefaultState();
	private static final BlockState DEATHCAPBLOCK = BlockInit.DEATHCAP.get().getDefaultState();
	private static final BlockState AMANITABLOCK = BlockInit.AMANITA.get().getDefaultState();
	private static final BlockState LUMGRASS = BlockInit.LUMGRASS.get().getDefaultState();
	private static final BlockState SPOREPUMPERBLOCK = BlockInit.SPOREPUMPER.get().getDefaultState();
	private static final BlockState TALL_LUMGRASS = BlockInit.TALL_LUMGRASS.get().getDefaultState();
	public static final BlockClusterFeatureConfig TALL_LUMGRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(TALL_LUMGRASS), new DoublePlantBlockPlacer())).tries(64).func_227317_b_()
					.build();
	BlockClusterFeatureConfig LILY_PAD_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(LILY_PAD), new SimpleBlockPlacer())).tries(10).build();
	BlockClusterFeatureConfig GLOWSHROOM1 = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(BLUE_GLOWING_MUSHROOM), new SimpleBlockPlacer())).tries(12).func_227317_b_()
					.build();
	BlockClusterFeatureConfig GLOWSHROOM2 = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(GREEN_GLOWING_MUSHROOM), new SimpleBlockPlacer())).tries(9).func_227317_b_()
					.build();
	BlockClusterFeatureConfig GLOWSHROOM3 = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(PINK_GLOWING_MUSHROOM), new SimpleBlockPlacer())).tries(9).func_227317_b_()
					.build();
	BlockClusterFeatureConfig MOREL = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(MORELBLOCK),
			new SimpleBlockPlacer())).tries(1).func_227317_b_().build();
	BlockClusterFeatureConfig SPOREPUMPER = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(SPOREPUMPERBLOCK), new SimpleBlockPlacer())).tries(1).func_227317_b_().build();
	BlockClusterFeatureConfig AMANITA = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(AMANITABLOCK), new SimpleBlockPlacer())).tries(2).func_227317_b_().build();
	BlockClusterFeatureConfig DEATHCAP = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(DEATHCAPBLOCK), new SimpleBlockPlacer())).tries(2).func_227317_b_().build();
	BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(LUMGRASS), new SimpleBlockPlacer())).tries(32).build();
	BigMushroomFeatureConfig BIG_PINK_MUSHROOM = new BigMushroomFeatureConfig(
			new SimpleBlockStateProvider(PINK_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 2);
	BigMushroomFeatureConfig BIG_GREEN_MUSHROOM = new BigMushroomFeatureConfig(
			new SimpleBlockStateProvider(GREEN_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 2);
	BigMushroomFeatureConfig BIG_BLUE_MUSHROOM = new BigMushroomFeatureConfig(
			new SimpleBlockStateProvider(BLUE_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 3);

	public GlowingMushroomBiome(Builder biomeBuilder) {
		super(biomeBuilder);

		this.addCarver(GenerationStage.Carving.LIQUID, Biome.createCarver(
				new HyphaeGlowingMushroomCarver(ProbabilityConfig::deserialize), new ProbabilityConfig(0.2f)));

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.SIMPLE_BLOCK
						.withConfiguration(new BlockWithContextConfig(Blocks.SEAGRASS.getDefaultState(),
								new BlockState[] { BlockInit.MUD.get().getDefaultState() },
								new BlockState[] { FluidInit.ACID_BLOCK.get().getDefaultState() },
								new BlockState[] { FluidInit.ACID_BLOCK.get().getDefaultState() }))
						.withPlacement(Placement.CARVING_MASK
								.configure(new CaveEdgeConfig(GenerationStage.Carving.LIQUID, 0.1F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(GLOWSHROOM1).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(8, 0.25F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(GLOWSHROOM2).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(8, 0.25F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(GLOWSHROOM3).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(8, 0.25F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(MOREL)
				.withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(3, 0.04F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(SPOREPUMPER).withPlacement(
						Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(8, 0.14F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(AMANITA)
				.withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(5, 0.07F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEATHCAP)
				.withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(5, 0.07F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_BOOLEAN_SELECTOR
				.withConfiguration(
						new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(BIG_GREEN_MUSHROOM),
								Feature.HUGE_BROWN_MUSHROOM.withConfiguration(BIG_BLUE_MUSHROOM)))
				.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_BOOLEAN_SELECTOR
				.withConfiguration(
						new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(BIG_PINK_MUSHROOM),
								Feature.HUGE_BROWN_MUSHROOM.withConfiguration(BIG_BLUE_MUSHROOM)))
				.withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(TALL_LUMGRASS_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));
	}
}
