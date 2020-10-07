package com.radioctivetacoo.worldsalad.world.dimension;

import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.FluidInit;

import net.minecraft.world.gen.GenerationSettings;

public class HyphaeGenSettings extends GenerationSettings {

	public int getBiomeSize() {
		return 400;
	}

	public int getRiverSize() {
		return 4;
	}

	public int getBiomeId() {
		return -1;
	}

	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}

	public HyphaeGenSettings() {
		this.defaultBlock = BlockInit.TOUGH_HYPHAE.get().getDefaultState().getBlockState();
		this.defaultFluid = FluidInit.ACID_BLOCK.get().getDefaultState();
	}
}
