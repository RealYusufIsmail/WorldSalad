package com.radioctivetacoo.worldsalad.util;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = WorldSalad.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {
	@SubscribeEvent
	public static void RegisterDimensions(final RegisterDimensionsEvent event) {
		if (DimensionType.byName(WorldSalad.HYPHAE_DIM_TYPE) == null) {
			DimensionManager.registerDimension(WorldSalad.HYPHAE_DIM_TYPE, DimensionInit.HYPHAE_DIM.get(), null, false);
		}
		WorldSalad.LOGGER.info("Dimensions Registered");
	}

}
