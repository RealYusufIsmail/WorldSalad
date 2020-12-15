package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.AlloyFurnaceContainer;
import com.radioctivetacoo.worldsalad.container.ArchaeologyStationContainer;
import com.radioctivetacoo.worldsalad.container.BoilerContainer;
import com.radioctivetacoo.worldsalad.container.DeepFryerContainer;
import com.radioctivetacoo.worldsalad.container.DisplayStandContainer;
import com.radioctivetacoo.worldsalad.container.DistillerContainer;
import com.radioctivetacoo.worldsalad.container.DistillingBarrelContainer;
import com.radioctivetacoo.worldsalad.container.FloatationBinContainer;
import com.radioctivetacoo.worldsalad.container.HydraulicPressContainer;
import com.radioctivetacoo.worldsalad.container.IndustrialGrinderContainer;
import com.radioctivetacoo.worldsalad.container.KilnContainer;
import com.radioctivetacoo.worldsalad.container.LesserInfuserContainer;
import com.radioctivetacoo.worldsalad.container.PolymerizationReactorContainer;
import com.radioctivetacoo.worldsalad.container.SeedPressContainer;
import com.radioctivetacoo.worldsalad.container.SpinningWheelContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerInit {

	@SuppressWarnings("deprecation")
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
	
	public static final RegistryObject<ContainerType<AlloyFurnaceContainer>> ALLOY_FURNACE = CONTAINER_TYPES
			.register("alloy_furnace", () -> IForgeContainerType.create(AlloyFurnaceContainer::new));
	
	public static final RegistryObject<ContainerType<IndustrialGrinderContainer>> INDUSTRIAL_GRINDER = CONTAINER_TYPES
			.register("industrial_grinder", () -> IForgeContainerType.create(IndustrialGrinderContainer::new));
	
	public static final RegistryObject<ContainerType<FloatationBinContainer>> FLOATATION_BIN = CONTAINER_TYPES
			.register("floatation_bin", () -> IForgeContainerType.create(FloatationBinContainer::new));
	
	public static final RegistryObject<ContainerType<DistillingBarrelContainer>> DISTILLING_BARREL = CONTAINER_TYPES
			.register("distilling_barrel", () -> IForgeContainerType.create(DistillingBarrelContainer::new));
	
	public static final RegistryObject<ContainerType<BoilerContainer>> BOILER = CONTAINER_TYPES
			.register("boiler", () -> IForgeContainerType.create(BoilerContainer::new));
	
	public static final RegistryObject<ContainerType<DistillerContainer>> DISTILLER = CONTAINER_TYPES
			.register("distiller", () -> IForgeContainerType.create(DistillerContainer::new));
	
	public static final RegistryObject<ContainerType<PolymerizationReactorContainer>> POLYMERIZATION_REACTOR = CONTAINER_TYPES
			.register("polymerization_reactor", () -> IForgeContainerType.create(PolymerizationReactorContainer::new));
}
