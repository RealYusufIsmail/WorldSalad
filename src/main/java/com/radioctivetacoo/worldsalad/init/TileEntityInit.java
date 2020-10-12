package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.tileentity.AlloyFurnaceTileEntity;
import com.radioctivetacoo.worldsalad.tileentity.ArchaeologyStationTileEntity;
import com.radioctivetacoo.worldsalad.tileentity.DeepFryerTileEntity;
import com.radioctivetacoo.worldsalad.tileentity.DisplayStandTileEntity;
import com.radioctivetacoo.worldsalad.tileentity.HydraulicPressTileEntity;
import com.radioctivetacoo.worldsalad.tileentity.KilnTileEntity;
import com.radioctivetacoo.worldsalad.tileentity.LesserInfuserTileEntity;
import com.radioctivetacoo.worldsalad.tileentity.SeedPressTileEntity;
import com.radioctivetacoo.worldsalad.tileentity.SpinningWheelTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, WorldSalad.MOD_ID);

	public static final RegistryObject<TileEntityType<DeepFryerTileEntity>> DEEP_FRYER = TILE_ENTITY_TYPES.register(
			"deep_fryer",
			() -> TileEntityType.Builder.create(DeepFryerTileEntity::new, BlockInit.DEEP_FRYER.get()).build(null));
	
	public static final RegistryObject<TileEntityType<KilnTileEntity>> KILN = TILE_ENTITY_TYPES.register(
			"kiln",
			() -> TileEntityType.Builder.create(KilnTileEntity::new, BlockInit.KILN.get()).build(null));

	public static final RegistryObject<TileEntityType<SeedPressTileEntity>> SEED_PRESS = TILE_ENTITY_TYPES.register(
			"seed_press",
			() -> TileEntityType.Builder.create(SeedPressTileEntity::new, BlockInit.SEED_PRESS.get()).build(null));

	public static final RegistryObject<TileEntityType<SpinningWheelTileEntity>> SPINNING_WHEEL = TILE_ENTITY_TYPES
			.register("spinning_wheel", () -> TileEntityType.Builder
					.create(SpinningWheelTileEntity::new, BlockInit.SPINNING_WHEEL.get()).build(null));
	
	public static final RegistryObject<TileEntityType<LesserInfuserTileEntity>> LESSER_INFUSER = TILE_ENTITY_TYPES.register(
			"lesser_infuser",
			() -> TileEntityType.Builder.create(LesserInfuserTileEntity::new, BlockInit.LESSER_INFUSER.get()).build(null));
	
	public static final RegistryObject<TileEntityType<HydraulicPressTileEntity>> HYDRAULIC_PRESS = TILE_ENTITY_TYPES.register(
			"hydraulic_press",
			() -> TileEntityType.Builder.create(HydraulicPressTileEntity::new, BlockInit.HYDRAULIC_PRESS.get()).build(null));
	
	public static final RegistryObject<TileEntityType<ArchaeologyStationTileEntity>> ARCHAEOLOGY_STATION = TILE_ENTITY_TYPES.register(
			"archaeology_station",
			() -> TileEntityType.Builder.create(ArchaeologyStationTileEntity::new, BlockInit.ARCHAEOLOGY_STATION.get()).build(null));
	
	public static final RegistryObject<TileEntityType<DisplayStandTileEntity>> DISPLAY_STAND = TILE_ENTITY_TYPES.register(
			"display_stand",
			() -> TileEntityType.Builder.create(DisplayStandTileEntity::new, BlockInit.DISPLAY_STAND.get()).build(null));
	
	public static final RegistryObject<TileEntityType<AlloyFurnaceTileEntity>> ALLOY_FURNACE = TILE_ENTITY_TYPES.register(
			"alloy_furnace",
			() -> TileEntityType.Builder.create(AlloyFurnaceTileEntity::new, BlockInit.ALLOY_FURNACE.get()).build(null));
}
