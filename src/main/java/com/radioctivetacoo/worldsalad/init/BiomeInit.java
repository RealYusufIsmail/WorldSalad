package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.world.biomes.AcidOceanBiome;
import com.radioctivetacoo.worldsalad.world.biomes.CragBiome;
import com.radioctivetacoo.worldsalad.world.biomes.DenseMushroomForestBiome;
import com.radioctivetacoo.worldsalad.world.biomes.GlowingMushroomBiome;
import com.radioctivetacoo.worldsalad.world.biomes.GlowingMushroomBiomeSurfaceBuilder;
import com.radioctivetacoo.worldsalad.world.biomes.LavafieldBiome;
import com.radioctivetacoo.worldsalad.world.biomes.MildewForestBiome;
import com.radioctivetacoo.worldsalad.world.biomes.MoldTundraBiome;
import com.radioctivetacoo.worldsalad.world.biomes.MushroomCanyonShatteredBiome;
import com.radioctivetacoo.worldsalad.world.biomes.MushroomCanyonBiomeSurfaceBuilder;
import com.radioctivetacoo.worldsalad.world.biomes.MushroomCanyonFlatsBiome;
import com.radioctivetacoo.worldsalad.world.biomes.MushroomCanyonFlatsBiomeSurfaceBuilder;
import com.radioctivetacoo.worldsalad.world.biomes.MushroomForestBiome;

import net.minecraft.util.registry.Registry;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES,
			WorldSalad.MOD_ID);

	public static final RegistryObject<Biome> CRAG_BIOME = BIOMES.register("crag_biome",
			() -> new CragBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.15f).temperature(0.2f)
					.waterColor(8036321).waterFogColor(9284076)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(),
									Blocks.SAND.getDefaultState()))
					.category(Category.TAIGA).downfall(0.6f).depth(0f).parent(null)));

	public static final RegistryObject<Biome> LAVAFIELD_BIOME = BIOMES.register("lavafield_biome",
			() -> new LavafieldBiome(new Biome.Builder().precipitation(RainType.NONE).scale(0.085f).temperature(2.8f)
					.waterColor(0xff2d5fb5).waterFogColor(0xff6187c9)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.LAVAROCK.get().getDefaultState(),
									BlockInit.INFERTILE_SOIL.get().getDefaultState(), Blocks.GRAVEL.getDefaultState()))
					.category(Category.SAVANNA).downfall(0f).depth(0.3f).parent(null)));

	public static final RegistryObject<Biome> GLOWING_MUSHROOM_BIOME = BIOMES.register("glowing_mushroom_biome",
			() -> new GlowingMushroomBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.075f)
					.temperature(0.8f).waterColor(8245176).waterFogColor(12582868)
					.surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
							register(WorldSalad.MOD_ID + ":glowing_mushroom_surface",
									new GlowingMushroomBiomeSurfaceBuilder(
											SurfaceBuilderConfig::deserialize)),
							new SurfaceBuilderConfig(BlockInit.GLOWING_HYCELIUM.get().getDefaultState(),
									Blocks.DIRT.getDefaultState(), BlockInit.FUNGAL_DIRT.get().getDefaultState())))
					.category(Category.PLAINS).downfall(0.3f).depth(-0.2f).parent(null)));

	public static final RegistryObject<Biome> MUSHROOM_FOREST_BIOME = BIOMES.register("mushroom_forest_biome",
			() -> new MushroomForestBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.25f)
					.temperature(0.8f).waterColor(8245176).waterFogColor(12582868)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.HYCELIUM.get().getDefaultState(),
									BlockInit.FUNGAL_DIRT.get().getDefaultState(),
									BlockInit.MUD.get().getDefaultState()))
					.category(Category.FOREST).downfall(0.3f).depth(2f).parent(null)));

	public static final RegistryObject<Biome> DENSE_MUSHROOM_FOREST_BIOME = BIOMES.register(
			"dense_mushroom_forest_biome",
			() -> new DenseMushroomForestBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.25f)
					.temperature(0.8f).waterColor(8245176).waterFogColor(12582868)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.HYCELIUM.get().getDefaultState(),
									BlockInit.FUNGAL_DIRT.get().getDefaultState(),
									BlockInit.MUD.get().getDefaultState()))
					.category(Category.FOREST).downfall(0.3f).depth(2f).parent("mushroom_forest_biome")));

	public static final RegistryObject<Biome> MOLD_TUNDRA_BIOME = BIOMES.register("mold_tundra_biome",
			() -> new MoldTundraBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.02f).temperature(0.8f)
					.waterColor(8245176).waterFogColor(12582868)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.MOLDGRASS.get().getDefaultState(),
									BlockInit.FUNGAL_DIRT.get().getDefaultState(),
									BlockInit.MUD.get().getDefaultState()))
					.category(Category.TAIGA).downfall(0.3f).depth(2f).parent(null)));

	public static final RegistryObject<Biome> MILDEW_FOREST_BIOME = BIOMES.register("mildew_forest_biome",
			() -> new MildewForestBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.02f).temperature(0.8f)
					.waterColor(8245176).waterFogColor(12582868)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.MOLDGRASS.get().getDefaultState(),
									BlockInit.FUNGAL_DIRT.get().getDefaultState(),
									BlockInit.MUD.get().getDefaultState()))
					.category(Category.TAIGA).downfall(0.3f).depth(2f).parent("mold_tundra_biome")));

	public static final RegistryObject<Biome> MUSHROOM_CANYON_SHATTERED_BIOME = BIOMES
			.register("mushroom_canyon_shattered_biome",
					() -> new MushroomCanyonShatteredBiome(
							new Biome.Builder().precipitation(RainType.NONE).scale(0.8f).temperature(1.8f)
									.waterColor(8245176).waterFogColor(12582868)
									.surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
											register(WorldSalad.MOD_ID + ":mushroom_canyon_surface",
													new MushroomCanyonBiomeSurfaceBuilder(
															SurfaceBuilderConfig::deserialize)),
											new SurfaceBuilderConfig(Blocks.DIRT.getDefaultState(),
													Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())))
									.category(Category.MESA).downfall(0.3f).depth(3.9f).parent("mushroom_canyon_flats_biome")));
	
	public static final RegistryObject<Biome> MUSHROOM_CANYON_FLATS_BIOME = BIOMES.register("mushroom_canyon_flats_biome",
			() -> new MushroomCanyonFlatsBiome(new Biome.Builder().precipitation(RainType.NONE).scale(0.01f).temperature(1.8f)
					.waterColor(8245176).waterFogColor(12582868).surfaceBuilder(new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
							register(WorldSalad.MOD_ID + ":mushroom_canyon_flats_surface",
									new MushroomCanyonFlatsBiomeSurfaceBuilder(
											SurfaceBuilderConfig::deserialize)),
							new SurfaceBuilderConfig(Blocks.DIRT.getDefaultState(),
									Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())))
					.category(Category.MESA).downfall(0.3f).depth(3.9f).parent(null)));
	
	public static final RegistryObject<Biome> ACID_OCEAN_BIOME = BIOMES.register("acid_ocean_biome",
			() -> new AcidOceanBiome(new Biome.Builder().precipitation(RainType.RAIN).scale(0.25f)
					.temperature(0.9f).waterColor(8245176).waterFogColor(12582868)
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(BlockInit.HYCELIUM.get().getDefaultState(),
									BlockInit.MUD.get().getDefaultState(),
									BlockInit.MUD.get().getDefaultState()))
					.category(Category.OCEAN).downfall(0.3f).depth(-1.4f).parent(null)));

	

	public static void registerBiomes() {
		registerBiome(CRAG_BIOME.get(), Type.COLD, Type.OVERWORLD);
		registerBiome(GLOWING_MUSHROOM_BIOME.get(), Type.PLAINS, Type.BEACH);
		registerBiome(MUSHROOM_FOREST_BIOME.get(), Type.FOREST, Type.OVERWORLD);
		registerBiome(DENSE_MUSHROOM_FOREST_BIOME.get(), Type.FOREST, Type.OVERWORLD);
		registerBiome(MOLD_TUNDRA_BIOME.get(), Type.COLD, Type.OVERWORLD);
		registerBiome(MILDEW_FOREST_BIOME.get(), Type.FOREST, Type.OVERWORLD);
		registerBiome(MUSHROOM_CANYON_SHATTERED_BIOME.get(), Type.FOREST, Type.OVERWORLD);
		registerBiome(MUSHROOM_CANYON_FLATS_BIOME.get(), Type.FOREST, Type.OVERWORLD);
		registerBiome(LAVAFIELD_BIOME.get(), Type.HOT, Type.OVERWORLD);
	}

	private static void registerBiome(Biome biome, Type... types) {
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(CRAG_BIOME.get(), 6));
		BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(LAVAFIELD_BIOME.get(), 4));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(CRAG_BIOME.get());
		BiomeManager.addSpawnBiome(LAVAFIELD_BIOME.get());
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
		return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
	}
}
