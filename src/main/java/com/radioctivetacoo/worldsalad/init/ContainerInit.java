package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.ArchaeologyStationContainer;
import com.radioctivetacoo.worldsalad.container.DeepFryerContainer;
import com.radioctivetacoo.worldsalad.container.DisplayStandContainer;
import com.radioctivetacoo.worldsalad.container.HydraulicPressContainer;
import com.radioctivetacoo.worldsalad.container.KilnContainer;
import com.radioctivetacoo.worldsalad.container.LesserInfuserContainer;
import com.radioctivetacoo.worldsalad.container.SeedPressContainer;
import com.radioctivetacoo.worldsalad.container.SpinningWheelContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
			ForgeRegistries.CONTAINERS, WorldSalad.MOD_ID);

	public static final RegistryObject<ContainerType<DeepFryerContainer>> DEEP_FRYER = CONTAINER_TYPES
			.register("deep_fryer", () -> IForgeContainerType.create(DeepFryerContainer::new));

	public static final RegistryObject<ContainerType<SeedPressContainer>> SEED_PRESS = CONTAINER_TYPES
			.register("seed_press", () -> IForgeContainerType.create(SeedPressContainer::new));
	
	public static final RegistryObject<ContainerType<HydraulicPressContainer>> HYDRAULIC_PRESS = CONTAINER_TYPES
			.register("hydraulic_press", () -> IForgeContainerType.create(HydraulicPressContainer::new));
	
	public static final RegistryObject<ContainerType<KilnContainer>> KILN = CONTAINER_TYPES
			.register("kiln", () -> IForgeContainerType.create(KilnContainer::new));

	public static final RegistryObject<ContainerType<SpinningWheelContainer>> SPINNING_WHEEL = CONTAINER_TYPES
			.register("spinning_wheel", () -> IForgeContainerType.create(SpinningWheelContainer::new));
	
	public static final RegistryObject<ContainerType<LesserInfuserContainer>> LESSER_INFUSER = CONTAINER_TYPES
			.register("lesser_infuser", () -> IForgeContainerType.create(LesserInfuserContainer::new));
	
	public static final RegistryObject<ContainerType<ArchaeologyStationContainer>> ARCHAEOLOGY_STATION = CONTAINER_TYPES
			.register("archaeology_station", () -> IForgeContainerType.create(ArchaeologyStationContainer::new));
	
	public static final RegistryObject<ContainerType<DisplayStandContainer>> DISPLAY_STAND = CONTAINER_TYPES
			.register("display_stand", () -> IForgeContainerType.create(DisplayStandContainer::new));
}
