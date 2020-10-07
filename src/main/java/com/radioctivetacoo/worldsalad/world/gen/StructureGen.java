package com.radioctivetacoo.worldsalad.world.gen;

import com.radioctivetacoo.worldsalad.init.BiomeInit;
import com.radioctivetacoo.worldsalad.init.FeatureInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class StructureGen {

	public static void generateStructures() {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome == BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get() || biome == BiomeInit.MUSHROOM_FOREST_BIOME.get() || biome == BiomeInit.GLOWING_MUSHROOM_BIOME.get() || biome == BiomeInit.MILDEW_FOREST_BIOME.get() || biome == BiomeInit.MOLD_TUNDRA_BIOME.get() || biome == BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get() ) {
				biome.addStructure(FeatureInit.ANCIENT_HYPHAE_SHRINE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.WRAITH_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.EXOSKELETON_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			if (biome == BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get() || biome == BiomeInit.MUSHROOM_FOREST_BIOME.get()) {
				biome.addStructure(FeatureInit.SHROOMHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.EMPTY_SHROOMHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));	
			}
			if (biome == BiomeInit.MUSHROOM_CANYON_FLATS_BIOME.get()) {
				biome.addStructure(FeatureInit.MUSHROCK1.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));	
				biome.addStructure(FeatureInit.MUSHROCK2.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.MUSHROCK3.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.MUSHROCK4.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.MUSHROCK5.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.MUSHROCK6.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addStructure(FeatureInit.MUSHROCK7.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			}
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.MUSHROCK1.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.MUSHROCK2.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.MUSHROCK3.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.MUSHROCK4.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.MUSHROCK5.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.MUSHROCK6.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.MUSHROCK7.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.EXOSKELETON_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));	
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.WRAITH_MUSH_ROOM.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.EMPTY_SHROOMHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.SHROOMHOUSE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			biome.addFeature(Decoration.SURFACE_STRUCTURES, FeatureInit.ANCIENT_HYPHAE_SHRINE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
		}
	}
}

