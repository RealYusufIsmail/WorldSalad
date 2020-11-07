package com.radioctivetacoo.worldsalad.world.biomes;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.world.gen.carvers.LavafieldCarver;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.LiquidsConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;

public class LavafieldBiome extends Biome {

	@Override
	public int getSkyColor() {
		return 0xd6d9ab;
	}

	BlockClusterFeatureConfig DEAD_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(DEAD_BUSH), new SimpleBlockPlacer())).tries(4).build();
	BlockClusterFeatureConfig TALL_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.FOUNTAIN_GRASS.get().getDefaultState()),
			new DoublePlantBlockPlacer())).tries(248).func_227317_b_().build();
	BlockClusterFeatureConfig LILY_OF_THE_VALLEY_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(LILY_OF_THE_VALLEY), new SimpleBlockPlacer())).tries(128).build();
	private static final BlockState DEAD_BUSH = Blocks.DEAD_BUSH.getDefaultState();
	private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
	private static final BlockState SAND = Blocks.SAND.getDefaultState();
	private static final BlockState CLAY = Blocks.DIRT.getDefaultState();
	private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
	private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
	private static final BlockState STONE = Blocks.STONE.getDefaultState();
	private static final BlockState GRANITE = Blocks.GRANITE.getDefaultState();
	private static final BlockState DIORITE = Blocks.DIORITE.getDefaultState();
	private static final BlockState ANDESITE = Blocks.ANDESITE.getDefaultState();
	private static final BlockState LILY_OF_THE_VALLEY = Blocks.LILY_OF_THE_VALLEY.getDefaultState();
	private static final BlockState LAVA = Blocks.LAVA.getDefaultState();
	public static final LiquidsConfig LAVA_SPRING_CONFIG = new LiquidsConfig(Fluids.LAVA.getDefaultState(), true, 8, 1,
			ImmutableSet.of(BlockInit.LAVAROCK.get(), Blocks.OBSIDIAN));

	public LavafieldBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.LLAMA, 17, 2, 6));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.RABBIT, 17, 2, 6));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.DONKEY, 17, 2, 6));
		this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ILLUSIONER, 5, 1, 1));

		this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(
				new LavafieldCarver(ProbabilityConfig::deserialize), new ProbabilityConfig(0.17547987F)));

		this.addStructure(
				Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
		this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(LAVA))
						.withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(35))));

		this.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES,
				Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES,
				Feature.MONSTER_ROOM.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
						.withPlacement(Placement.DUNGEONS.configure(new ChanceConfig(7))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES,
				Feature.MINESHAFT
						.withConfiguration(new MineshaftConfig(0.004F, MineshaftStructure.Type.NORMAL))
						.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(TALL_GRASS_CONFIG)
						.withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 0, 7))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FLOWER.withConfiguration(LILY_OF_THE_VALLEY_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));

		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.DISK
						.withConfiguration(new SphereReplaceConfig(SAND, 7, 2, Lists.newArrayList(STONE, GRASS_BLOCK)))
						.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(35))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.DISK.withConfiguration(new SphereReplaceConfig(CLAY, 4, 1, Lists.newArrayList(SAND, CLAY)))
						.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(5))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.DISK
						.withConfiguration(new SphereReplaceConfig(GRAVEL, 6, 2, Lists.newArrayList(SAND, GRASS_BLOCK)))
						.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(5))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIRT, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 256))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GRAVEL, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 256))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GRANITE, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, DIORITE, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ANDESITE, 33))
						.withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(20))));
		@SuppressWarnings("rawtypes")
		ConfiguredPlacement customConfig4 = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 60, 5, 130));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.create("LAVAROCK", null, new BlockMatcher(BlockInit.LAVAROCK.get())),
				BlockInit.ASH_BLOCK.get().getDefaultState(), 90)).withPlacement(customConfig4));
		@SuppressWarnings("rawtypes")
		ConfiguredPlacement customConfig2 = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 60, 5, 150));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.create("LAVAROCK", null, new BlockMatcher(BlockInit.LAVAROCK.get())),
				Blocks.OBSIDIAN.getDefaultState(), 14)).withPlacement(customConfig2));
		@SuppressWarnings("rawtypes")
		ConfiguredPlacement customConfig5 = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 60, 5, 150));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.create("LAVAROCK", null, new BlockMatcher(BlockInit.LAVAROCK.get())),
				Blocks.MAGMA_BLOCK.getDefaultState(), 14)).withPlacement(customConfig5));
		@SuppressWarnings("rawtypes")
		ConfiguredPlacement customConfig6 = Placement.COUNT_RANGE.configure(new CountRangeConfig(100, 60, 5, 150));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(
						OreFeatureConfig.FillerBlockType.create("LAVAROCK", null,
								new BlockMatcher(BlockInit.LAVAROCK.get())),
						BlockInit.FIREGEYSER.get().getDefaultState(), 3)).withPlacement(customConfig6));
		
		DefaultBiomeFeatures.addOres(this);
	}

}
