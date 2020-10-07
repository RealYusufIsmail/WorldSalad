package com.radioctivetacoo.worldsalad.world.biomes;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.world.feature.WillowTree;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.BlockWithContextConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CaveEdgeConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;

public class CragBiome extends Biome {
	BlockClusterFeatureConfig TALL_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(Blocks.TALL_GRASS.getDefaultState()), new DoublePlantBlockPlacer())).tries(148)
					.func_227317_b_().build();
	BlockClusterFeatureConfig LILY_PAD_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(Blocks.LILY_PAD.getDefaultState()), new SimpleBlockPlacer())).tries(1).build();
	TreeFeatureConfig FANCY_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG),
			new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(0, 0)))
					.setSapling((net.minecraftforge.common.IPlantable) Blocks.OAK_SAPLING).build();
	TreeFeatureConfig SPRUCE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG),
			new SimpleBlockStateProvider(SPRUCE_LEAVES), new SpruceFoliagePlacer(2, 1))).baseHeight(6).heightRandA(3)
					.trunkHeight(1).trunkHeightRandom(1).trunkTopOffsetRandom(2).ignoreVines()
					.setSapling((net.minecraftforge.common.IPlantable) Blocks.SPRUCE_SAPLING).build();
	TreeFeatureConfig OAK_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG),
			new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2)
					.foliageHeight(3).ignoreVines()
					.setSapling((net.minecraftforge.common.IPlantable) Blocks.OAK_SAPLING).build();
	BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS),
			new SimpleBlockPlacer())).tries(450).build();
	BlockClusterFeatureConfig LILY_OF_THE_VALLEY_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(LILY_OF_THE_VALLEY), new SimpleBlockPlacer())).tries(128).build();
	BlockClusterFeatureConfig BLUE_ORCHID_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(BLUE_ORCHID), new SimpleBlockPlacer())).tries(128).build();
	BlockClusterFeatureConfig SWEET_BERRY_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(Blocks.SWEET_BERRY_BUSH.getDefaultState()), new SimpleBlockPlacer())).tries(64)
					.whitelist(ImmutableSet.of(GRASS_BLOCK.getBlock())).func_227317_b_().build();
	private static final BlockState DIRT = Blocks.DIRT.getDefaultState();
	private static final BlockState SAND = Blocks.SAND.getDefaultState();
	private static final BlockState CLAY = Blocks.DIRT.getDefaultState();
	private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();
	private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
	private static final BlockState STONE = Blocks.STONE.getDefaultState();
	private static final BlockState WATER = Blocks.WATER.getDefaultState();
	private static final BlockState GRANITE = Blocks.GRANITE.getDefaultState();
	private static final BlockState DIORITE = Blocks.DIORITE.getDefaultState();
	private static final BlockState ANDESITE = Blocks.ANDESITE.getDefaultState();
	private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
	private static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
	private static final BlockState SPRUCE_LEAVES = Blocks.SPRUCE_LEAVES.getDefaultState();
	private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
	private static final BlockState GRASS = Blocks.GRASS.getDefaultState();
	private static final BlockState BLUE_ORCHID = Blocks.BLUE_ORCHID.getDefaultState();
	private static final BlockState LILY_OF_THE_VALLEY = Blocks.LILY_OF_THE_VALLEY.getDefaultState();

	public CragBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 24, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 20, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 15, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.LLAMA, 17, 2, 6));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.WOLF, 2, 1, 3));
		this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COD, 50, 1, 2));
		this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 125, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ILLUSIONER, 1, 1, 1));

		this.addCarver(GenerationStage.Carving.AIR,
				Biome.createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.17547987F)));

		this.addStructure(
				Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
		this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(STONE))
						.withPlacement(Placement.ICEBERG.configure(new ChanceConfig(6))));
		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(ANDESITE))
						.withPlacement(Placement.ICEBERG.configure(new ChanceConfig(340))));
		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(GRANITE))
						.withPlacement(Placement.ICEBERG.configure(new ChanceConfig(340))));
		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(DIORITE))
						.withPlacement(Placement.ICEBERG.configure(new ChanceConfig(340))));
		this.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
				Feature.ICEBERG.withConfiguration(new BlockStateFeatureConfig(BlockInit.SHALE.get().getDefaultState()))
						.withPlacement(Placement.ICEBERG.configure(new ChanceConfig(615))));

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
				Feature.RANDOM_PATCH.withConfiguration(LILY_PAD_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(SWEET_BERRY_BUSH_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SIMPLE_BLOCK
				.withConfiguration(new BlockWithContextConfig(Blocks.SEAGRASS.getDefaultState(),
						new BlockState[] { SAND }, new BlockState[] { WATER }, new BlockState[] { WATER }))
				.withPlacement(
						Placement.CARVING_MASK.configure(new CaveEdgeConfig(GenerationStage.Carving.LIQUID, 0.1F))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(WillowTree.WILLOW_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.00001f, 0))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FLOWER.withConfiguration(BLUE_ORCHID_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.FLOWER.withConfiguration(LILY_OF_THE_VALLEY_CONFIG)
						.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));
		this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.RANDOM_SELECTOR
						.withConfiguration(new MultipleRandomFeatureConfig(
								ImmutableList.of(
										Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG).withChance(0.666F),
										Feature.FANCY_TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F)),
								Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG)))
						.withPlacement(
								Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));

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

		@SuppressWarnings("rawtypes")
		ConfiguredPlacement customConfig0 = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 60, 5, 130));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE
						.withConfiguration(
								new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, GRASS_BLOCK, 100))
						.withPlacement(customConfig0));
		@SuppressWarnings("rawtypes")
		ConfiguredPlacement customConfig1 = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 5, 5, 130));
		this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
						BlockInit.COPPER_ORE.get().getDefaultState(), 8)).withPlacement(customConfig1));
		DefaultBiomeFeatures.addOres(this);
	}

}
