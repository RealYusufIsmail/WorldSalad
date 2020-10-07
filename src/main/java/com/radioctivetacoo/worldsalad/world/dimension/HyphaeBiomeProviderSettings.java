package com.radioctivetacoo.worldsalad.world.dimension;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class HyphaeBiomeProviderSettings implements IBiomeProviderSettings {

	private final long seed;
	private final WorldType worldType;
	private HyphaeGenSettings generatorSettings = new HyphaeGenSettings();

	public HyphaeBiomeProviderSettings(WorldInfo info) {
		this.seed = info.getSeed();
		this.worldType = info.getGenerator();
	}

	public HyphaeBiomeProviderSettings setGeneratorSettings(HyphaeGenSettings settings) {
		this.generatorSettings = settings;
		return this;
	}

	public long getSeed() {
		return this.seed;
	}

	public WorldType getWorldType() {
		return this.worldType;
	}

	public HyphaeGenSettings getGeneratorSettings() {
		return this.generatorSettings;
	}
}
