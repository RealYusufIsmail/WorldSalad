package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.objects.blocks.AcidBlock;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {
	@SuppressWarnings("deprecation")

	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, WorldSalad.MOD_ID);


	// vegetable oil
	public static final ResourceLocation VEGETABLE_OIL_STILL_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/vegetable_oil_still");
	public static final ResourceLocation VEGETABLE_OIL_FLOWING_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/vegetable_oil_flowing");
	public static final ResourceLocation VEGETABLE_OIL_OVERLAY_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/vegetable_oil_overlay");

	public static final RegistryObject<FlowingFluid> VEGETABLE_OIL_FLUID = FLUIDS.register("vegetable_oil_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.VEGETABLE_OIL_PROPERTIES));

	public static final RegistryObject<FlowingFluid> VEGETABLE_OIL_FLOWING = FLUIDS.register("vegetable_oil_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.VEGETABLE_OIL_PROPERTIES));

	public static final ForgeFlowingFluid.Properties VEGETABLE_OIL_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> VEGETABLE_OIL_FLUID.get(), () -> VEGETABLE_OIL_FLOWING.get(),
			FluidAttributes.builder(VEGETABLE_OIL_STILL_RL, VEGETABLE_OIL_FLOWING_RL).density(2).color(0xffD0C25B)
					.viscosity(3).overlay(VEGETABLE_OIL_OVERLAY_RL)).block(() -> FluidInit.VEGETABLE_OIL_BLOCK.get())
							.bucket(() -> ItemInit.VEGETABLE_OIL_BUCKET.get());

	public static final RegistryObject<FlowingFluidBlock> VEGETABLE_OIL_BLOCK = BlockInit.BLOCKS.register(
			"vegetable_oil",
			() -> new FlowingFluidBlock(() -> FluidInit.VEGETABLE_OIL_FLUID.get(),
					Block.Properties.of(Material.WATER).noCollission().friction(1)
							.strength(100.0f, 100.0f).noDrops()));

	// crude oil
	public static final ResourceLocation CRUDE_OIL_STILL_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/crude_oil_still");
	public static final ResourceLocation CRUDE_OIL_FLOWING_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/crude_oil_flowing");
	public static final ResourceLocation CRUDE_OIL_OVERLAY_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/crude_oil_overlay");

	public static final RegistryObject<FlowingFluid> CRUDE_OIL_FLUID = FLUIDS.register("crude_oil_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.CRUDE_OIL_PROPERTIES));

	public static final RegistryObject<FlowingFluid> CRUDE_OIL_FLOWING = FLUIDS.register("crude_oil_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.CRUDE_OIL_PROPERTIES));

	public static final ForgeFlowingFluid.Properties CRUDE_OIL_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> CRUDE_OIL_FLUID.get(), () -> CRUDE_OIL_FLOWING.get(),
			FluidAttributes.builder(CRUDE_OIL_STILL_RL, CRUDE_OIL_FLOWING_RL).density(15).color(0x000000).viscosity(15)
					.overlay(CRUDE_OIL_OVERLAY_RL)).block(() -> FluidInit.CRUDE_OIL_BLOCK.get())
							.bucket(() -> ItemInit.CRUDE_OIL_BUCKET.get());

	public static final RegistryObject<FlowingFluidBlock> CRUDE_OIL_BLOCK = BlockInit.BLOCKS.register("crude_oil",
			() -> new FlowingFluidBlock(() -> FluidInit.CRUDE_OIL_FLUID.get(), Block.Properties.of(Material.WATER)
					.noCollission().friction(1).strength(100.0f, 100.0f).noDrops()));

	// acid
	public static final ResourceLocation ACID_STILL_RL = new ResourceLocation(WorldSalad.MOD_ID, "blocks/acid_still");
	public static final ResourceLocation ACID_FLOWING_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/acid_flowing");
	public static final ResourceLocation ACID_OVERLAY_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/acid_overlay");

	public static final RegistryObject<FlowingFluid> ACID_FLUID = FLUIDS.register("acid_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.ACID_PROPERTIES));

	public static final RegistryObject<FlowingFluid> ACID_FLOWING = FLUIDS.register("acid_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.ACID_PROPERTIES));

	public static final ForgeFlowingFluid.Properties ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> ACID_FLUID.get(), () -> ACID_FLOWING.get(),
			FluidAttributes.builder(ACID_STILL_RL, ACID_FLOWING_RL).density(15).color(0xff0AE090).viscosity(15)
					.overlay(ACID_OVERLAY_RL)).block(() -> FluidInit.ACID_BLOCK.get())
							.bucket(() -> ItemInit.ACID_BUCKET.get());

	public static final RegistryObject<FlowingFluidBlock> ACID_BLOCK = BlockInit.BLOCKS.register("acid",
			() -> new AcidBlock(() -> FluidInit.ACID_FLUID.get(), Block.Properties.of(Material.WATER).randomTicks()
					.noCollission().lightLevel(value -> 3).strength(100.0f, 100.0f).noDrops()));
	
	// refined oil
	public static final ResourceLocation PINE_OIL_STILL_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/pine_oil_still");
	public static final ResourceLocation PINE_OIL_FLOWING_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/pine_oil_flowing");
	public static final ResourceLocation PINE_OIL_OVERLAY_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/pine_oil_overlay");

	public static final RegistryObject<FlowingFluid> PINE_OIL_FLUID = FLUIDS.register("pine_oil_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.PINE_OIL_PROPERTIES));

	public static final RegistryObject<FlowingFluid> PINE_OIL_FLOWING = FLUIDS.register("pine_oil_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.PINE_OIL_PROPERTIES));

	public static final ForgeFlowingFluid.Properties PINE_OIL_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> PINE_OIL_FLUID.get(), () -> PINE_OIL_FLOWING.get(),
			FluidAttributes.builder(PINE_OIL_STILL_RL, PINE_OIL_FLOWING_RL).density(2).color(0xffD0C25B)
					.viscosity(3).overlay(PINE_OIL_OVERLAY_RL)).block(() -> FluidInit.PINE_OIL_BLOCK.get())
							.bucket(() -> ItemInit.PINE_OIL_BUCKET.get());

	public static final RegistryObject<FlowingFluidBlock> PINE_OIL_BLOCK = BlockInit.BLOCKS.register(
			"pine_oil",
			() -> new FlowingFluidBlock(() -> FluidInit.PINE_OIL_FLUID.get(),
					Block.Properties.of(Material.WATER).noCollission().friction(1)
							.strength(100.0f, 100.0f).noDrops()));
	
	//ethanol
	public static final ResourceLocation ETHANOL_STILL_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/ethanol_still");
	public static final ResourceLocation ETHANOL_FLOWING_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/ethanol_flowing");
	public static final ResourceLocation ETHANOL_OVERLAY_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/ethanol_overlay");

	public static final RegistryObject<FlowingFluid> ETHANOL_FLUID = FLUIDS.register("ethanol_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.ETHANOL_PROPERTIES));

	public static final RegistryObject<FlowingFluid> ETHANOL_FLOWING = FLUIDS.register("ethanol_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.ETHANOL_PROPERTIES));

	public static final ForgeFlowingFluid.Properties ETHANOL_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> ETHANOL_FLUID.get(), () -> ETHANOL_FLOWING.get(),
			FluidAttributes.builder(ETHANOL_STILL_RL, ETHANOL_FLOWING_RL).density(2).color(0xffebf2ed)
					.viscosity(3).overlay(ETHANOL_OVERLAY_RL)).block(() -> FluidInit.ETHANOL_BLOCK.get())
							.bucket(() -> ItemInit.ETHANOL_BUCKET.get());

	public static final RegistryObject<FlowingFluidBlock> ETHANOL_BLOCK = BlockInit.BLOCKS.register(
			"ethanol",
			() -> new FlowingFluidBlock(() -> FluidInit.ETHANOL_FLUID.get(),
					Block.Properties.of(Material.WATER).noCollission().friction(1)
							.strength(100.0f, 100.0f).noDrops()));
	
	//refined oil
	public static final ResourceLocation REFINED_OIL_STILL_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/refined_oil_still");
	public static final ResourceLocation REFINED_OIL_FLOWING_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/refined_oil_flowing");
	public static final ResourceLocation REFINED_OIL_OVERLAY_RL = new ResourceLocation(WorldSalad.MOD_ID,
			"blocks/refined_oil_overlay");

	public static final RegistryObject<FlowingFluid> REFINED_OIL_FLUID = FLUIDS.register("refined_oil_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.REFINED_OIL_PROPERTIES));

	public static final RegistryObject<FlowingFluid> REFINED_OIL_FLOWING = FLUIDS.register("refined_oil_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.REFINED_OIL_PROPERTIES));

	public static final ForgeFlowingFluid.Properties REFINED_OIL_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> REFINED_OIL_FLUID.get(), () -> REFINED_OIL_FLOWING.get(),
			FluidAttributes.builder(REFINED_OIL_STILL_RL, REFINED_OIL_FLOWING_RL).density(2).color(0x1e0524)
					.viscosity(3).overlay(REFINED_OIL_OVERLAY_RL)).block(() -> FluidInit.REFINED_OIL_BLOCK.get())
							.bucket(() -> ItemInit.REFINED_OIL_BUCKET.get());

	public static final RegistryObject<FlowingFluidBlock> REFINED_OIL_BLOCK = BlockInit.BLOCKS.register(
			"refined_oil",
			() -> new FlowingFluidBlock(() -> FluidInit.REFINED_OIL_FLUID.get(),
					Block.Properties.of(Material.WATER).noCollission().friction(1)
							.strength(100.0f, 100.0f).noDrops()));
}
