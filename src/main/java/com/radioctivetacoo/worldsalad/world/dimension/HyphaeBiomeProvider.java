package com.radioctivetacoo.worldsalad.world.dimension;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.radioctivetacoo.worldsalad.init.BiomeInit;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

public class HyphaeBiomeProvider extends BiomeProvider {
	private static final Set<Biome> biomeList = ImmutableSet.of(BiomeInit.MUSHROOM_FOREST_BIOME.get(),
			BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get(), BiomeInit.GLOWING_MUSHROOM_BIOME.get(),
			BiomeInit.MOLD_TUNDRA_BIOME.get(), BiomeInit.MILDEW_FOREST_BIOME.get(),
			BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get(), BiomeInit.MUSHROOM_CANYON_FLATS_BIOME.get(), BiomeInit.ACID_OCEAN_BIOME.get());
	@SuppressWarnings("unused")
	private Random rand;
	private final double biomeSize = 125.0D;
	private VoronoiGenerator biomeNoise;

	public HyphaeBiomeProvider(HyphaeBiomeProviderSettings settings) {
		super(biomeList);
		rand = new Random();
		this.biomeNoise = new VoronoiGenerator();
		this.biomeNoise.setSeed((int) settings.getSeed());
	}

	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return getBiome(new LinkedList<Biome>(biomeList),
				biomeNoise.getValue(x / biomeSize, y - 4, z / biomeSize));
	}

	public Biome getBiome(List<Biome> biomeList, double noiseVal) {
		for (int i = biomeList.size(); i >= 0; i--) {
			if (noiseVal > (2.0f / biomeList.size()) * i - 1)
				return biomeList.get(i);
		}
		return biomeList.get(biomeList.size() - 1);
	}

}