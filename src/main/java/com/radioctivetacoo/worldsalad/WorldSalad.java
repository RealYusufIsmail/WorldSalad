package com.radioctivetacoo.worldsalad;

import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import software.bernie.geckolib3.GeckoLib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.radioctivetacoo.worldsalad.init.BiomeInit;
import com.radioctivetacoo.worldsalad.init.BlockInit;
import com.radioctivetacoo.worldsalad.init.CarverInit;
import com.radioctivetacoo.worldsalad.init.ContainerInit;
import com.radioctivetacoo.worldsalad.init.DimensionInit;
import com.radioctivetacoo.worldsalad.init.EffectInit;
import com.radioctivetacoo.worldsalad.init.EntityInit;
import com.radioctivetacoo.worldsalad.init.FeatureInit;
import com.radioctivetacoo.worldsalad.init.FluidInit;
import com.radioctivetacoo.worldsalad.init.ItemInit;
import com.radioctivetacoo.worldsalad.init.RecipeSerializerInit;
import com.radioctivetacoo.worldsalad.init.SoundInit;
import com.radioctivetacoo.worldsalad.init.TileEntityInit;
import com.radioctivetacoo.worldsalad.objects.blocks.DirtCakeBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.ModMachineBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.GhostGrapeBushBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.HotcoffeeCropBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.PassionFruitBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.PassionVineCropBlock;
import com.radioctivetacoo.worldsalad.objects.items.ModSpawnEggItem;
import com.radioctivetacoo.worldsalad.world.gen.ModOreGen;
import com.radioctivetacoo.worldsalad.world.gen.StructureGen;

@Mod("worldsalad")
@Mod.EventBusSubscriber(modid = WorldSalad.MOD_ID, bus = Bus.MOD)
public class WorldSalad {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "worldsalad";
	public static WorldSalad instance;
	public static final ResourceLocation HYPHAE_DIM_TYPE = new ResourceLocation(MOD_ID, "hyphae");
	
	public WorldSalad() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);

		SoundInit.SOUNDS.register(modEventBus);
		EffectInit.EFFECTS.register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		RecipeSerializerInit.RECIPE_SERIALIZERS.register(modEventBus);
		BlockInit.BLOCKS.register(modEventBus);
		FluidInit.FLUIDS.register(modEventBus);
		CarverInit.CARVERS.register(modEventBus);
		TileEntityInit.TILE_ENTITY_TYPES.register(modEventBus);
		ContainerInit.CONTAINER_TYPES.register(modEventBus);
		EntityInit.ENTITY_TYPES.register(modEventBus);
		BiomeInit.BIOMES.register(modEventBus);
		DimensionInit.MOD_DIMENSIONS.register(modEventBus);
		FeatureInit.FEATURES.register(modEventBus);
		GeckoLib.initialize();

		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInit.BLOCKS.getEntries().stream().filter(
				block -> !(block.get() instanceof GhostGrapeBushBlock) && !(block.get() instanceof FlowingFluidBlock) && !(block.get() instanceof PassionFruitBlock) && 
				!(block.get() instanceof PassionVineCropBlock) && !(block.get() instanceof HotcoffeeCropBlock) && !(block.get().equals(BlockInit.DISTILLATION_TOWER_BLOCK.get())) 
				&& !(block.get() instanceof FlowerPotBlock) && !(block.get() instanceof ModMachineBlock) && !(block.get() instanceof DirtCakeBlock))
				.map(RegistryObject::get).forEach(block -> {
					final Item.Properties properties = new Item.Properties().group(WorldSaladBlocksItemGroup.instance);
					final BlockItem blockItem = new BlockItem(block, properties);
					blockItem.setRegistryName(block.getRegistryName());
					registry.register(blockItem);
				});
		
		BlockInit.BLOCKS.getEntries().stream().filter(
				block -> (block.get() instanceof ModMachineBlock) || (block.get().equals(BlockInit.DISTILLATION_TOWER_BLOCK.get())))
				.map(RegistryObject::get).forEach(block -> {
					final Item.Properties properties = new Item.Properties().group(WorldSaladMachinesItemGroup.instance);
					final BlockItem blockItem = new BlockItem(block, properties);
					blockItem.setRegistryName(block.getRegistryName());
					registry.register(blockItem);
				});
		
		BlockInit.BLOCKS.getEntries().stream().filter(
				block -> (block.get() instanceof DirtCakeBlock))
				.map(RegistryObject::get).forEach(block -> {
					final Item.Properties properties = new Item.Properties().group(WorldSaladFoodItemGroup.instance);
					final BlockItem blockItem = new BlockItem(block, properties);
					blockItem.setRegistryName(block.getRegistryName());
					registry.register(blockItem);
				});
	}

	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		BiomeInit.registerBiomes();
	}


	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
		EntityInit.registerEntityWorldSpawn();
		EntityInit.registerPlacementType();
		ModSpawnEggItem.initSpawnEggs();
	}

	private void setup(final FMLCommonSetupEvent event) {
		ComposterBlock.registerCompostable(0.3f, BlockInit.WILLOW_LEAVES.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.WILLOW_SAPLING.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.MADRONE_LEAVES.get());
		ComposterBlock.registerCompostable(0.5f, BlockInit.DENSE_MADRONE_LEAVES.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.MADRONE_SAPLING.get());
		ComposterBlock.registerCompostable(0.65f, ItemInit.GREEN_APPLE.get());
		ComposterBlock.registerCompostable(0.65f, ItemInit.GHOST_GRAPES.get());
		ComposterBlock.registerCompostable(0.65f, ItemInit.HOTCOFFEE_BEANS.get());
		ComposterBlock.registerCompostable(0.65f, ItemInit.CHOCOLATE_HOTCOFFEE_BEANS.get());
		ComposterBlock.registerCompostable(0.3f, ItemInit.HOTCOFFEE_SEED.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.AMANITA.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.DEATHCAP.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.DESERT_SHAGGY_MANE.get());
		ComposterBlock.registerCompostable(0.2f, BlockInit.TOADSTOOL.get());
		ComposterBlock.registerCompostable(1.0f, BlockInit.MOREL.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.LUMGRASS.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.TALL_LUMGRASS.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.FUNGRASS.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.TALL_FUNGRASS.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.MOLDGRASS.get());
		ComposterBlock.registerCompostable(0.3f, BlockInit.MOLD_GROWTH.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.DRY_REED.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.MOLD_BLOCK.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.MILDEW_BLOCK.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.ANT_FUNGUS_BLOCK.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.RAW_ENOKI_BULB.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.SMOKED_ENOKI_BULB.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.PASSION_FRUIT.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.LUMBERRY.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.FUNGBERRY.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.MOLDBERRY.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.THATCH.get());
		ComposterBlock.registerCompostable(1f, ItemInit.HYPHAE_BERRY_PIE.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.MADRONEBERRY.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.FOUNTAIN_GRASS.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.MADRONEBERRY.get());
		ComposterBlock.registerCompostable(0.1f, ItemInit.PASSION_FRUIT_SEEDS.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.PINK_GLOWING_MUSHROOM.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.BLUE_GLOWING_MUSHROOM.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.GREEN_GLOWING_MUSHROOM.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.PRICKLEWEED.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.LICHEN.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.PINK_MUSHROOM_BLOCK.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.BLUE_MUSHROOM_BLOCK.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.GREEN_MUSHROOM_BLOCK.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.HUGE_TOADSTOOL_BLOCK.get());
		ComposterBlock.registerCompostable(0.1f, BlockInit.HUGE_ENOKI_BLOCK.get());
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

	@SubscribeEvent
	public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
		ModOreGen.generateOre();
		StructureGen.generateStructures();
	}

	public static class WorldSaladItemsItemGroup extends ItemGroup {
		public static final WorldSaladItemsItemGroup instance = new WorldSaladItemsItemGroup(ItemGroup.GROUPS.length,
				"worldsaladitems");

		private WorldSaladItemsItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.WORLD_SALAD.get());
		}
	}
	
	public static class WorldSaladBlocksItemGroup extends ItemGroup {
		public static final WorldSaladBlocksItemGroup instance = new WorldSaladBlocksItemGroup(ItemGroup.GROUPS.length,
				"worldsaladblocks");

		private WorldSaladBlocksItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.HYCELIUM.get());
		}
	}
	
	public static class WorldSaladToolsItemGroup extends ItemGroup {
		public static final WorldSaladToolsItemGroup instance = new WorldSaladToolsItemGroup(ItemGroup.GROUPS.length,
				"worldsaladtools");

		private WorldSaladToolsItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.ESSENCE_CRYSTALIZER.get());
		}
	}
	
	public static class WorldSaladMachinesItemGroup extends ItemGroup {
		public static final WorldSaladMachinesItemGroup instance = new WorldSaladMachinesItemGroup(ItemGroup.GROUPS.length,
				"worldsaladmachines");

		private WorldSaladMachinesItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.ALLOY_FURNACE.get());
		}
	}
	
	public static class WorldSaladMaterialsItemGroup extends ItemGroup {
		public static final WorldSaladMaterialsItemGroup instance = new WorldSaladMaterialsItemGroup(ItemGroup.GROUPS.length,
				"worldsaladmaterials");

		private WorldSaladMaterialsItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.STEEL_INGOT.get());
		}
	}
	
	public static class WorldSaladSpawnEggsItemGroup extends ItemGroup {
		public static final WorldSaladSpawnEggsItemGroup instance = new WorldSaladSpawnEggsItemGroup(ItemGroup.GROUPS.length,
				"worldsaladspawneggs");

		private WorldSaladSpawnEggsItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.CORDYCEPS_ANT_SPAWN_EGG.get());
		}
	}
	
	public static class WorldSaladFoodItemGroup extends ItemGroup {
		public static final WorldSaladFoodItemGroup instance = new WorldSaladFoodItemGroup(ItemGroup.GROUPS.length,
				"worldsaladfoods");

		private WorldSaladFoodItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.DIRT_CAKE.get());
		}
	}
}
