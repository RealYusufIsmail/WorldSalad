package com.radioctivetacoo.worldsalad.world.gen;

import com.radioctivetacoo.worldsalad.init.BiomeInit;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.FluidInit;

import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModOreGen {
	public static void generateOre() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == Biomes.COLD_OCEAN || biome == Biomes.DEEP_COLD_OCEAN || biome == Biomes.DEEP_FROZEN_OCEAN
					|| biome == Biomes.DEEP_LUKEWARM_OCEAN || biome == Biomes.DEEP_OCEAN
					|| biome == Biomes.DEEP_WARM_OCEAN || biome == Biomes.FROZEN_OCEAN || biome == Biomes.FROZEN_RIVER
					|| biome == Biomes.LUKEWARM_OCEAN || biome == Biomes.OCEAN || biome == Biomes.RIVER
					|| biome == Biomes.SWAMP || biome == Biomes.SWAMP_HILLS || biome == Biomes.WARM_OCEAN) {
				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfigShale = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(15, 0, 0, 130));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										BlockInit.SHALE.get().getDefaultState(), 25))
								.withPlacement(customConfigShale));

				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfigCobalt = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(8, 35, 0, 130));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
										BlockInit.COBALT_ORE.get().getDefaultState(), 4))
								.withPlacement(customConfigCobalt));

			}
			if (biome == BiomeInit.CRAG_BIOME.get() || biome == Biomes.BEACH) {
				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfigSnowSalt = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(118, 0, 0, 130));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.create("SNOW", null,
												new BlockMatcher(Blocks.SNOW_BLOCK)),
										BlockInit.ROCK_SALT.get().getDefaultState(), 200))
								.withPlacement(customConfigSnowSalt));
				@SuppressWarnings("rawtypes")

				ConfiguredPlacement customConfigSandSalt = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(4, 55, 0, 130));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.create("SAND", null,
												new BlockMatcher(Blocks.SAND)),
										BlockInit.ROCK_SALT.get().getDefaultState(), 18))
								.withPlacement(customConfigSandSalt));
			}
			if (biome == Biomes.DESERT || biome == Biomes.DESERT_LAKES || biome == Biomes.DESERT_HILLS) {
				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfigSiltStone = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(8, 0, 0, 130));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.create("SANDSTONE", null,
												new BlockMatcher(Blocks.SANDSTONE)),
										BlockInit.SILTSTONE.get().getDefaultState(), 20))
								.withPlacement(customConfigSiltStone));

				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfigSilt = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(8, 0, 0, 130));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE.withConfiguration(new OreFeatureConfig(
								OreFeatureConfig.FillerBlockType.create("SAND", null, new BlockMatcher(Blocks.SAND)),
								BlockInit.SILT.get().getDefaultState(), 20)).withPlacement(customConfigSilt));
			}
			if (biome == Biomes.BADLANDS || biome == Biomes.BADLANDS_PLATEAU || biome == Biomes.ERODED_BADLANDS
					|| biome == Biomes.MODIFIED_BADLANDS_PLATEAU || biome == Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU
					|| biome == Biomes.WOODED_BADLANDS_PLATEAU) {
				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfigSiltStone = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(8, 0, 0, 130));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.create("REDSANDSTONE", null,
												new BlockMatcher(Blocks.RED_SANDSTONE)),
										BlockInit.SILTSTONE.get().getDefaultState(), 80))
								.withPlacement(customConfigSiltStone));

				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfigSilt = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(8, 0, 0, 130));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE
								.withConfiguration(new OreFeatureConfig(
										OreFeatureConfig.FillerBlockType.create("REDSAND", null,
												new BlockMatcher(Blocks.RED_SAND)),
										BlockInit.SILT.get().getDefaultState(), 35))
								.withPlacement(customConfigSilt));
			}
			if (biome == Biomes.FROZEN_RIVER || biome == Biomes.RIVER || biome == Biomes.SWAMP) {
				@SuppressWarnings("rawtypes")
				ConfiguredPlacement customConfigRiverMud = Placement.COUNT_RANGE
						.configure(new CountRangeConfig(60, 50, 0, 130));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
						Feature.ORE.withConfiguration(new OreFeatureConfig(
								OreFeatureConfig.FillerBlockType.create("DIRT", null, new BlockMatcher(Blocks.DIRT)),
								BlockInit.MUD.get().getDefaultState(), 25)).withPlacement(customConfigRiverMud));

			}

			// HYPHAE--------------------------------
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigMudstone = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(16, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
											new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
									BlockInit.MUDSTONE.get().getDefaultState(), 40))
							.withPlacement(customConfigMudstone));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigMushroomClay = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(12, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
											new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
									Blocks.CLAY.getDefaultState(), 12))
							.withPlacement(customConfigMushroomClay));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigMushroomClaystone = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(12, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
											new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
									BlockInit.CLAYSTONE.get().getDefaultState(), 50))
							.withPlacement(customConfigMushroomClaystone));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigMushroomFungalDirt = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(12, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
											new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
									BlockInit.FUNGAL_DIRT.get().getDefaultState(), 30))
							.withPlacement(customConfigMushroomFungalDirt));
			
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigBlackShale = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(10, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("PURPLE_CLAYSTONE", null,
											new BlockMatcher(BlockInit.PURPLE_CLAYSTONE.get())),
									BlockInit.BLACK_SHALE.get().getDefaultState(), 35))
							.withPlacement(customConfigBlackShale));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigMushroomSQuartz = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(40, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
											new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
									BlockInit.SPORE_QUARTZ_ORE.get().getDefaultState(), 10))
							.withPlacement(customConfigMushroomSQuartz));
			
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigBioCrystal = Placement.COUNT_RANGE.configure(new CountRangeConfig(28, 5, 5, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(
							OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
									new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
							BlockInit.BIOLUMINESCENT_ORE.get().getDefaultState(), 8)).withPlacement(customConfigBioCrystal));
			
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigAmber = Placement.COUNT_RANGE.configure(new CountRangeConfig(7, 5, 5, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(
							OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
									new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
							BlockInit.HYPHAE_AMBER_ORE.get().getDefaultState(), 4)).withPlacement(customConfigAmber));
			
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigHematite = Placement.COUNT_RANGE.configure(new CountRangeConfig(17, 5, 5, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(
							OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
									new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
							BlockInit.HYPHAE_HEMATITE_ORE.get().getDefaultState(), 7)).withPlacement(customConfigHematite));
			
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigEXPOre = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 5, 5, 30));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(
							OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
									new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
							BlockInit.EXPERIENCE_ORE.get().getDefaultState(), 4)).withPlacement(customConfigEXPOre));
			
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigFakeEXPOre = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 5, 5, 30));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(
							OreFeatureConfig.FillerBlockType.create("HYPHAESTONE", null,
									new BlockMatcher(BlockInit.TOUGH_HYPHAE.get())),
							BlockInit.FALSE_EXPERIENCE_ORE.get().getDefaultState(), 4)).withPlacement(customConfigFakeEXPOre));

			// VANILLA WORLD ORES--------------------------------
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigLavaRock = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(10, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("N", null,
											new BlockMatcher(Blocks.NETHERRACK)),
									BlockInit.LAVAROCK.get().getDefaultState(), 25))
							.withPlacement(customConfigLavaRock));
			
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigAsh = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(10, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("N", null,
											new BlockMatcher(Blocks.NETHERRACK)),
									BlockInit.ASH_BLOCK.get().getDefaultState(), 25))
							.withPlacement(customConfigAsh));
			
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigVolcanicGravel = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(10, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("N", null,
											new BlockMatcher(Blocks.NETHERRACK)),
									BlockInit.VOLCANIC_GRAVEL.get().getDefaultState(), 25))
							.withPlacement(customConfigVolcanicGravel));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigCopper = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(4, 40, 0, 65));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockInit.COPPER_ORE.get().getDefaultState(), 8))
							.withPlacement(customConfigCopper));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigLead = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 30, 0, 50));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.LEAD_ORE.get().getDefaultState(), 8)).withPlacement(customConfigLead));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigBauxite = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(5, 50, 0, 50));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockInit.BAUXITE_ORE.get().getDefaultState(), 15))
							.withPlacement(customConfigBauxite));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigZinc = Placement.COUNT_RANGE.configure(new CountRangeConfig(3, 1, 0, 40));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
							BlockInit.ZINC_ORE.get().getDefaultState(), 3)).withPlacement(customConfigZinc));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigPlat = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 1, 0, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockInit.PLATINUM_ORE.get().getDefaultState(), 4))
							.withPlacement(customConfigPlat));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigManga = Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 1, 0, 50));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockInit.MANGANESE_ORE.get().getDefaultState(), 8))
							.withPlacement(customConfigManga));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigUranium = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(1, 1, 0, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockInit.URANIUM_ORE.get().getDefaultState(), 4))
							.withPlacement(customConfigUranium));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigNetherSulphur = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(15, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("NR", null,
											new BlockMatcher(Blocks.NETHERRACK)),
									BlockInit.SULPHUR_ORE.get().getDefaultState(), 10))
							.withPlacement(customConfigNetherSulphur));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigNetherTitanium = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(1, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("NR", null,
											new BlockMatcher(Blocks.NETHERRACK)),
									BlockInit.TITANIUM_ORE.get().getDefaultState(), 8))
							.withPlacement(customConfigNetherTitanium));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigNetherLithium = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(9, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("NR", null,
											new BlockMatcher(Blocks.NETHERRACK)),
									BlockInit.LITHIUM_ORE.get().getDefaultState(), 9))
							.withPlacement(customConfigNetherLithium));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigNetherTungsten = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(1, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("NR", null,
											new BlockMatcher(Blocks.NETHERRACK)),
									BlockInit.TUNGSTEN_ORE.get().getDefaultState(), 8))
							.withPlacement(customConfigNetherTungsten));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigNetherMystery = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(1, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("NR", null,
											new BlockMatcher(Blocks.NETHERRACK)),
									BlockInit.NETHER_MYSTERY_ORE.get().getDefaultState(), 3))
							.withPlacement(customConfigNetherMystery));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigNetherBQuartz = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(8, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("NR", null,
											new BlockMatcher(Blocks.NETHERRACK)),
									BlockInit.BLOOD_QUARTZ_ORE.get().getDefaultState(), 12))
							.withPlacement(customConfigNetherBQuartz));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigEndMystery = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(1, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("ED", null,
											new BlockMatcher(Blocks.END_STONE)),
									BlockInit.END_MYSTERY_ORE.get().getDefaultState(), 3))
							.withPlacement(customConfigEndMystery));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigEndVQuartz = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(10, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("ED", null,
											new BlockMatcher(Blocks.END_STONE)),
									BlockInit.VOID_QUARTZ_ORE.get().getDefaultState(), 12))
							.withPlacement(customConfigEndVQuartz));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigEndMithril = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(4, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("ED", null,
											new BlockMatcher(Blocks.END_STONE)),
									BlockInit.MITHRIL_ORE.get().getDefaultState(), 12))
							.withPlacement(customConfigEndMithril));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigEndMoly = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(1, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(
									OreFeatureConfig.FillerBlockType.create("ED", null,
											new BlockMatcher(Blocks.END_STONE)),
									BlockInit.MOLYBDENUM_ORE.get().getDefaultState(), 8))
							.withPlacement(customConfigEndMoly));

			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigLimestone = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(8, 0, 0, 130));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									BlockInit.LIMESTONE.get().getDefaultState(), 20))
							.withPlacement(customConfigLimestone));
			
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement customConfigOil = Placement.COUNT_RANGE
					.configure(new CountRangeConfig(1, 11, 0, 25));
			biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
									FluidInit.CRUDE_OIL_BLOCK.get().getDefaultState(), 40))
							.withPlacement(customConfigOil));

			BlockClusterFeatureConfig AMANITAOVERWORLD = (new BlockClusterFeatureConfig.Builder(
					new SimpleBlockStateProvider(BlockInit.AMANITA.get().getDefaultState()), new SimpleBlockPlacer()))
							.tries(4).func_227317_b_().build();
			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_PATCH.withConfiguration(AMANITAOVERWORLD).withPlacement(
							Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(0, 0.1F))));

			BlockClusterFeatureConfig DEATHCAPOVERWORLD = (new BlockClusterFeatureConfig.Builder(
					new SimpleBlockStateProvider(BlockInit.DEATHCAP.get().getDefaultState()), new SimpleBlockPlacer()))
							.tries(4).func_227317_b_().build();
			biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_PATCH.withConfiguration(DEATHCAPOVERWORLD).withPlacement(
							Placement.COUNT_CHANCE_HEIGHTMAP.configure(new HeightWithChanceConfig(0, 0.07F))));
			
			BlockClusterFeatureConfig OAK_LEAF_PILE_CONFIG = (new BlockClusterFeatureConfig.Builder(
					new SimpleBlockStateProvider(BlockInit.OAK_LEAF_PILE.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
			BlockClusterFeatureConfig SPRUCE_LEAF_PILE_CONFIG = (new BlockClusterFeatureConfig.Builder(
					new SimpleBlockStateProvider(BlockInit.SPRUCE_LEAF_PILE.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
			BlockClusterFeatureConfig BIRCH_LEAF_PILE_CONFIG = (new BlockClusterFeatureConfig.Builder(
					new SimpleBlockStateProvider(BlockInit.BIRCH_LEAF_PILE.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
			BlockClusterFeatureConfig ACACIA_LEAF_PILE_CONFIG = (new BlockClusterFeatureConfig.Builder(
					new SimpleBlockStateProvider(BlockInit.ACACIA_LEAF_PILE.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
			BlockClusterFeatureConfig DARK_OAK_LEAF_PILE_CONFIG = (new BlockClusterFeatureConfig.Builder(
					new SimpleBlockStateProvider(BlockInit.DARK_OAK_LEAF_PILE.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
			BlockClusterFeatureConfig BROWN_LEAF_PILE_CONFIG = (new BlockClusterFeatureConfig.Builder(
					new SimpleBlockStateProvider(BlockInit.BROWN_LEAF_PILE.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
			BlockClusterFeatureConfig JUNGLE_LEAF_PILE_CONFIG = (new BlockClusterFeatureConfig.Builder(
					new SimpleBlockStateProvider(BlockInit.JUNGLE_LEAF_PILE.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();
			
			if (biome == Biomes.DARK_FOREST || biome == Biomes.DARK_FOREST_HILLS)
			{
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(DARK_OAK_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(6))));
			}
			
			if (biome == Biomes.FOREST || biome == Biomes.DARK_FOREST || biome == Biomes.DARK_FOREST_HILLS)
			{
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(OAK_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(6))));
				
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(BIRCH_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
				
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(BROWN_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			}
			
			if (biome == Biomes.GIANT_SPRUCE_TAIGA || biome == Biomes.GIANT_SPRUCE_TAIGA_HILLS || biome == Biomes.GIANT_TREE_TAIGA || biome == Biomes.GIANT_TREE_TAIGA_HILLS || biome == Biomes.TAIGA || biome == Biomes.TAIGA_HILLS || biome == Biomes.TAIGA_MOUNTAINS)
			{
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(SPRUCE_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(7))));
				
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(BROWN_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
			}
			
			if (biome == Biomes.BIRCH_FOREST || biome == Biomes.BIRCH_FOREST_HILLS || biome == Biomes.TALL_BIRCH_HILLS || biome == Biomes.TALL_BIRCH_FOREST)
			{
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(BIRCH_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));
			}
			
			if (biome == Biomes.SAVANNA || biome == Biomes.SAVANNA_PLATEAU || biome == Biomes.SHATTERED_SAVANNA || biome == Biomes.SHATTERED_SAVANNA_PLATEAU)
			{
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(ACACIA_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			}
			
			if (biome == Biomes.WOODED_BADLANDS_PLATEAU || biome == Biomes.FLOWER_FOREST)
			{
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(BROWN_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
			}
			
			if (biome == Biomes.BAMBOO_JUNGLE || biome == Biomes.JUNGLE_EDGE || biome == Biomes.JUNGLE || biome == Biomes.BAMBOO_JUNGLE_HILLS || biome == Biomes.JUNGLE_HILLS || biome == Biomes.MODIFIED_JUNGLE)
			{
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(OAK_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
				
				biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
						Feature.RANDOM_PATCH.withConfiguration(JUNGLE_LEAF_PILE_CONFIG)
								.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));
			}
		}
	}
}
