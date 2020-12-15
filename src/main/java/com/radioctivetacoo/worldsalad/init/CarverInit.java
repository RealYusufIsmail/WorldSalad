package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.world.gen.carvers.HyphaeAcidOceanCarver;
import com.radioctivetacoo.worldsalad.world.gen.carvers.HyphaeCarver;
import com.radioctivetacoo.worldsalad.world.gen.carvers.HyphaeGlowingMushroomCarver;
import com.radioctivetacoo.worldsalad.world.gen.carvers.LavafieldCarver;

import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CarverInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<WorldCarver<?>> CARVERS = new DeferredRegister<>(ForgeRegistries.WORLD_CARVERS,
			WorldSalad.MOD_ID);

	public static final RegistryObject<WorldCarver<ProbabilityConfig>> HYPHAE_GLOWING_CARVER = CARVERS
			.register("hyphae_glowing_carver", () -> new HyphaeGlowingMushroomCarver(ProbabilityConfig::deserialize));

	public static final RegistryObject<WorldCarver<ProbabilityConfig>> HYPHAE_CARVER = CARVERS.register("hyphae_carver",
			() -> new HyphaeCarver(ProbabilityConfig::deserialize));
	
	public static final RegistryObject<WorldCarver<ProbabilityConfig>> HYPHAE_ACID_OCEAN_CARVER = CARVERS.register("hyphae_acid_ocean_carver",
			() -> new HyphaeAcidOceanCarver(ProbabilityConfig::deserialize));
	
	public static final RegistryObject<WorldCarver<ProbabilityConfig>> LAVAFIELD_CARVER = CARVERS.register("lavafield_carver",
			() -> new LavafieldCarver(ProbabilityConfig::deserialize));

}