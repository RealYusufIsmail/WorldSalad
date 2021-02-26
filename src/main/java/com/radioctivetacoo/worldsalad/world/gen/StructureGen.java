package com.radioctivetacoo.worldsalad.world.gen;

import com.radioctivetacoo.worldsalad.init.BiomeInit;
import com.radioctivetacoo.worldsalad.init.FeatureInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidWithNoiseConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class StructureGen {

	public static void generateStructures() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			
		// set home biomes
			if (biome == BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get() || biome == BiomeInit.MUSHROOM_FOREST_BIOME.get() || biome == BiomeInit.GLOWING_MUSHROOM_BIOME.get() || biome == BiomeInit.MILDEW_FOREST_BIOME.get() || biome == BiomeInit.MOLD_TUNDRA_BIOME.get() || biome == BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get() ) {
				biome.addStructure(FeatureInit.ANCIENT_HYPHAE_SHRINE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.WRAITH_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.EXOSKELETON_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			if (biome == BiomeInit.ACID_OCEAN_BIOME.get()) {
				biome.addStructure(FeatureInit.WRAITH_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.EXOSKELETON_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			if (biome == BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get() || biome == BiomeInit.MUSHROOM_FOREST_BIOME.get()) {
				biome.addStructure(FeatureInit.SHROOMHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.EMPTY_SHROOMHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));	
			}
			if (biome == BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get()) {
				biome.addStructure(FeatureInit.ANT_HIVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));	
			}
			if (biome == BiomeInit.MUSHROOM_CANYON_FLATS_BIOME.get()) {
				biome.addStructure(FeatureInit.MUSHROCK.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));	
				biome.addStructure(FeatureInit.ANT_HIVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));	
			}
			if (biome == BiomeInit.MILDEW_FOREST_BIOME.get()) {
				biome.addStructure(FeatureInit.GIANT_MILDEW.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			if (biome == BiomeInit.GLOWING_MUSHROOM_BIOME.get())
			{
				biome.addFeature(Decoration.VEGETAL_DECORATION, FeatureInit.LUMBOO.get().withConfiguration(new ProbabilityConfig(0.02F)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(40, 80.0D, 0.3D, Heightmap.Type.WORLD_SURFACE_WG))));
			}
			if (biome == Biomes.NETHER)
			{
				biome.addStructure(FeatureInit.NETHER_SHRINE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			if (biome != Biomes.NETHER && biome != Biomes.END_BARRENS && biome != Biomes.END_HIGHLANDS && biome != Biomes.END_MIDLANDS && biome != Biomes.SMALL_END_ISLANDS && biome != Biomes.THE_VOID &&
				biome != BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get() && biome != BiomeInit.MUSHROOM_FOREST_BIOME.get() && biome != BiomeInit.GLOWING_MUSHROOM_BIOME.get() && biome != BiomeInit.MILDEW_FOREST_BIOME.get() && biome != BiomeInit.MOLD_TUNDRA_BIOME.get() && biome != BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get() )
			{
				biome.addStructure(FeatureInit.OIL_WELL.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			
		// allow generation between biomes
			
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.MUSHROCK.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.GIANT_MILDEW.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.EXOSKELETON_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));	
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.WRAITH_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.EMPTY_SHROOMHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.SHROOMHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.ANCIENT_HYPHAE_SHRINE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.ANT_HIVE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.OIL_WELL.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.UNDERGROUND_STRUCTURES, FeatureInit.NETHER_SHRINE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		}
	}
}

