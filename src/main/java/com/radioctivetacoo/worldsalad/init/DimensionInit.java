package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.world.dimension.HyphaeModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(
			ForgeRegistries.MOD_DIMENSIONS, WorldSalad.MOD_ID);

	public static final RegistryObject<ModDimension> HYPHAE_DIM = MOD_DIMENSIONS.register("hyphae_dim",
			() -> new HyphaeModDimension());
}
