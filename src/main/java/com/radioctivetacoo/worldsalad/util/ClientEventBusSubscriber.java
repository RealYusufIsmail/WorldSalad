package com.radioctivetacoo.worldsalad.util;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.render.ExoskeletonRender;
import com.radioctivetacoo.worldsalad.client.entity.render.MothRender;
import com.radioctivetacoo.worldsalad.client.entity.render.RockMonsterRender;
import com.radioctivetacoo.worldsalad.client.entity.render.SoldierAntRender;
import com.radioctivetacoo.worldsalad.client.entity.render.TraderAntRender;
import com.radioctivetacoo.worldsalad.client.entity.render.UrchinRender;
import com.radioctivetacoo.worldsalad.client.entity.render.WorkerAntRender;
import com.radioctivetacoo.worldsalad.client.entity.render.WraithRender;
import com.radioctivetacoo.worldsalad.client.gui.AlloyFurnaceScreen;
import com.radioctivetacoo.worldsalad.client.gui.ArchaeologyStationScreen;
import com.radioctivetacoo.worldsalad.client.gui.DeepFryerScreen;
import com.radioctivetacoo.worldsalad.client.gui.DisplayStandScreen;
import com.radioctivetacoo.worldsalad.client.gui.HydraulicPressScreen;
import com.radioctivetacoo.worldsalad.client.gui.KilnScreen;
import com.radioctivetacoo.worldsalad.client.gui.LesserInfuserScreen;
import com.radioctivetacoo.worldsalad.client.gui.SeedPressScreen;
import com.radioctivetacoo.worldsalad.client.gui.SpinningWheelScreen;
import com.radioctivetacoo.worldsalad.client.tileentity.renderer.DisplayStandRenderer;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.ContainerInit;
import com.radioctivetacoo.worldsalad.init.EntityInit;
import com.radioctivetacoo.worldsalad.init.FluidInit;
import com.radioctivetacoo.worldsalad.init.TileEntityInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = WorldSalad.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ContainerInit.DEEP_FRYER.get(), DeepFryerScreen::new);
		ScreenManager.registerFactory(ContainerInit.SEED_PRESS.get(), SeedPressScreen::new);
		ScreenManager.registerFactory(ContainerInit.SPINNING_WHEEL.get(), SpinningWheelScreen::new);
		ScreenManager.registerFactory(ContainerInit.KILN.get(), KilnScreen::new);
		ScreenManager.registerFactory(ContainerInit.LESSER_INFUSER.get(), LesserInfuserScreen::new);
		ScreenManager.registerFactory(ContainerInit.HYDRAULIC_PRESS.get(), HydraulicPressScreen::new);
		ScreenManager.registerFactory(ContainerInit.ARCHAEOLOGY_STATION.get(), ArchaeologyStationScreen::new);
		ScreenManager.registerFactory(ContainerInit.DISPLAY_STAND.get(), DisplayStandScreen::new);
		ScreenManager.registerFactory(ContainerInit.ALLOY_FURNACE.get(), AlloyFurnaceScreen::new);

		RenderTypeLookup.setRenderLayer(FluidInit.VEGETABLE_OIL_FLOWING.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(FluidInit.VEGETABLE_OIL_FLUID.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(FluidInit.ACID_FLOWING.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(FluidInit.ACID_FLUID.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BLUE_GLOWING_MUSHROOM.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PINK_GLOWING_MUSHROOM.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GREEN_GLOWING_MUSHROOM.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.BLUE_MUSHROOM_BLOCK.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.PINK_MUSHROOM_BLOCK.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.GREEN_MUSHROOM_BLOCK.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.WILLOW_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TALL_LUMGRASS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FOUNTAIN_GRASS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.MOLD_GROWTH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LUMGRASS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.FUNGRASS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ROTTING_GRASS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.TALL_FUNGRASS.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.GHOST_GRAPE_BUSH.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.WILLOW_DOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.WILLOW_TRAPDOOR.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DRY_REED.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SPINNING_WHEEL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.DEEP_FRYER.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.AMBER_GLASS.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.AMBER_GLASS_PANE.get(), RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(BlockInit.HOTCOFFEE_CROP.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.POTTED_WILLOW_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LICHEN.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ESSENCE_CATALYST.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PASSION_VINE_CROP.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PASSION_FRUIT_BLOCK.get(), RenderType.getCutout());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.ROCK_MONSTER.get(), RockMonsterRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.MOTH.get(), MothRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.URCHIN.get(), UrchinRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.EXOSKELETON.get(), ExoskeletonRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.TRADER_ANT.get(), TraderAntRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.SOLDIER_ANT.get(), SoldierAntRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.WRAITH.get(), WraithRender::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityInit.WORKER_ANT.get(), WorkerAntRender::new);
		
		ClientRegistry.bindTileEntityRenderer(TileEntityInit.DISPLAY_STAND.get(), DisplayStandRenderer::new);
	}
}