package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.WorldSalad.WorldSaladFoodItemGroup;
import com.radioctivetacoo.worldsalad.WorldSalad.WorldSaladItemsItemGroup;
import com.radioctivetacoo.worldsalad.WorldSalad.WorldSaladMaterialsItemGroup;
import com.radioctivetacoo.worldsalad.WorldSalad.WorldSaladSpawnEggsItemGroup;
import com.radioctivetacoo.worldsalad.WorldSalad.WorldSaladToolsItemGroup;
import com.radioctivetacoo.worldsalad.objects.items.AshenNeedleItem;
import com.radioctivetacoo.worldsalad.objects.items.BreathingReedItem;
import com.radioctivetacoo.worldsalad.objects.items.DartItem;
import com.radioctivetacoo.worldsalad.objects.items.DragonflySaddleItem;
import com.radioctivetacoo.worldsalad.objects.items.EssenceCrystalItem;
import com.radioctivetacoo.worldsalad.objects.items.EssenceCrystalizerItem;
import com.radioctivetacoo.worldsalad.objects.items.FieryCoalItem;
import com.radioctivetacoo.worldsalad.objects.items.FossilPrintItem;
import com.radioctivetacoo.worldsalad.objects.items.GrandSlamyonItem;
import com.radioctivetacoo.worldsalad.objects.items.KeyPieceItem;
import com.radioctivetacoo.worldsalad.objects.items.MitochondrionItem;
import com.radioctivetacoo.worldsalad.objects.items.ModSpawnEggItem;
import com.radioctivetacoo.worldsalad.objects.items.ModStewItem;
import com.radioctivetacoo.worldsalad.objects.items.ShootingReedItem;
import com.radioctivetacoo.worldsalad.objects.items.SonarDeviceItem;
import com.radioctivetacoo.worldsalad.objects.items.TravelersBootsArmorItem;
import com.radioctivetacoo.worldsalad.objects.items.VaultingReedItem;
import com.radioctivetacoo.worldsalad.objects.items.buckets.AcidBucketItem;
import com.radioctivetacoo.worldsalad.objects.items.buckets.CrudeOilBucketItem;
import com.radioctivetacoo.worldsalad.objects.items.buckets.EthanolBucketItem;
import com.radioctivetacoo.worldsalad.objects.items.buckets.PineOilBucketItem;
import com.radioctivetacoo.worldsalad.objects.items.buckets.RefinedOilBucketItem;
import com.radioctivetacoo.worldsalad.objects.items.buckets.VegetableOilBucketItem;
import com.radioctivetacoo.worldsalad.util.enums.ModArmorMaterials;
import com.radioctivetacoo.worldsalad.util.enums.ModItemTiers;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, WorldSalad.MOD_ID);
	// armor
	public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
			() -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
			() -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
			() -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
			() -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet",
			() -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlotType.HEAD, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	 
	public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate",
			() -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlotType.CHEST, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings",
			() -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlotType.LEGS, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots",
			() -> new ArmorItem(ModArmorMaterials.TITANIUM, EquipmentSlotType.FEET, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> SCLERITOME_HELMET = ITEMS.register("scleritome_helmet",
			() -> new ArmorItem(ModArmorMaterials.CHITIN, EquipmentSlotType.HEAD, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	 
	public static final RegistryObject<Item> SCLERITOME_CHESTPLATE = ITEMS.register("scleritome_chestplate",
			() -> new ArmorItem(ModArmorMaterials.CHITIN, EquipmentSlotType.CHEST, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> SCLERITOME_LEGGINGS = ITEMS.register("scleritome_leggings",
			() -> new ArmorItem(ModArmorMaterials.CHITIN, EquipmentSlotType.LEGS, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> SCLERITOME_BOOTS = ITEMS.register("scleritome_boots",
			() -> new ArmorItem(ModArmorMaterials.CHITIN, EquipmentSlotType.FEET, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> TRAVELERS_BOOTS = ITEMS.register("travelers_boots",
			() -> new TravelersBootsArmorItem(ModArmorMaterials.TRAVELER, EquipmentSlotType.FEET, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	// tools
	public static final RegistryObject<Item> BREATHING_REED = ITEMS.register("breathing_reed",
			() -> new BreathingReedItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1).maxDamage(24)));
	
	public static final RegistryObject<Item> SONAR_DEVICE = ITEMS.register("sonar_device",
			() -> new SonarDeviceItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1).maxDamage(64)));
	
	public static final RegistryObject<Item> MITOCHONDRION = ITEMS.register("mitochondrion",
			() -> new MitochondrionItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1).maxDamage(16)));
	
	public static final RegistryObject<Item> ESSENCE_CRYSTALIZER = ITEMS.register("essence_crystalizer",
			() -> new EssenceCrystalizerItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1).maxDamage(64)));
	
	public static final RegistryObject<Item> VAULTING_REED = ITEMS.register("vaulting_reed",
			() -> new VaultingReedItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(16)));
	
	public static final RegistryObject<Item> SHOOTING_REED = ITEMS.register("shooting_reed",
			() -> new ShootingReedItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1).maxDamage(48)));
	
	public static final RegistryObject<Item> REED_DART = ITEMS.register("reed_dart",
			() -> new DartItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword",
			() -> new SwordItem(ModItemTiers.STEEL, 0, -2.4F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe",
			() -> new PickaxeItem(ModItemTiers.STEEL, -2, 1F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe",
			() -> new HoeItem(ModItemTiers.STEEL, 2.0F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe",
			() -> new AxeItem(ModItemTiers.STEEL, 4, -3.1F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel",
			() -> new ShovelItem(ModItemTiers.STEEL, -3, 1.5F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword",
			() -> new SwordItem(ModItemTiers.TITANIUM, 0, -2.4F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe",
			() -> new PickaxeItem(ModItemTiers.TITANIUM, -2, 1F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe",
			() -> new HoeItem(ModItemTiers.TITANIUM, 2.0F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe",
			() -> new AxeItem(ModItemTiers.TITANIUM, 4, -3.1F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel",
			() -> new ShovelItem(ModItemTiers.TITANIUM, -3, 1.5F, new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> GRAND_SLAMYON = ITEMS.register("grand_slamyon",
			() -> new GrandSlamyonItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1).maxDamage(748)));
	
	public static final RegistryObject<Item> ASHEN_NEEDLE = ITEMS.register("ashen_needle",
			() -> new AshenNeedleItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1).maxDamage(250)));
	
	public static final RegistryObject<Item> DRAGONFLY_SADDLE = ITEMS.register("dragonfly_saddle",
			() -> new DragonflySaddleItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> LUMINANT_KEY_PIECE = ITEMS.register("luminant_key_piece",
			() -> new KeyPieceItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> PATHOGEN_KEY_PIECE = ITEMS.register("pathogen_key_piece",
			() -> new KeyPieceItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> PLATED_KEY_PIECE = ITEMS.register("plated_key_piece",
			() -> new KeyPieceItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> HYPHAE_KEY = ITEMS.register("hyphae_key",
			() -> new KeyPieceItem(new Item.Properties().group(WorldSaladToolsItemGroup.instance).maxStackSize(1)));
	
	// items
	public static final RegistryObject<Item> PLACEHOLDER = ITEMS.register("placeholder",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> INCENSE_STICK = ITEMS.register("incense_stick",
			() -> new Item(new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> INCENSE_STICK_REGENERATION = ITEMS.register("incense_stick_regeneration",
			() -> new Item(new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> INCENSE_STICK_STRENGTH = ITEMS.register("incense_stick_strength",
			() -> new Item(new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> INCENSE_STICK_SPEED = ITEMS.register("incense_stick_speed",
			() -> new Item(new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> INCENSE_STICK_JUMP_BOOST = ITEMS.register("incense_stick_jump_boost",
			() -> new Item(new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> INCENSE_STICK_NIGHT_VISION = ITEMS.register("incense_stick_night_vision",
			() -> new Item(new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> INCENSE_STICK_FIRE_RESISTANCE = ITEMS.register("incense_stick_fire_resistance",
			() -> new Item(new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<Item> SILICON_WAFER = ITEMS.register("silicon_wafer",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> IRON_ROD = ITEMS.register("iron_rod",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> GOLD_ROD = ITEMS.register("gold_rod",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> COPPER_ROD = ITEMS.register("copper_rod",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> CELL_CULTURE = ITEMS.register("cell_culture",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> RESIN = ITEMS.register("resin",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> SAWDUST = ITEMS.register("sawdust",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> CRYSTAL_SCLERITE = ITEMS.register("crystal_sclerite",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> PLASTIC_SHEET = ITEMS.register("plastic_sheet",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> EXTREMOPLASM = ITEMS.register("extremoplasm",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> LUMEN_ESSENCE = ITEMS.register("lumen_essence",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> ECTOPLASM = ITEMS.register("ectoplasm",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> HOTCOFFEE_SEED = ITEMS.register("hotcoffee_seeds",
			() -> new BlockItem(BlockInit.HOTCOFFEE_CROP.get(), new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> PASSION_FRUIT_SEEDS = ITEMS.register("passion_fruit_seeds",
			() -> new BlockItem(BlockInit.PASSION_VINE_CROP.get(), new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> FIERY_COAL = ITEMS.register("fiery_coal",
			() -> new FieryCoalItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> SILK_BOLT = ITEMS.register("silk_bolt",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> CLOTH_BOLT = ITEMS.register("cloth_bolt",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> FIBERGLASS_SHEET = ITEMS.register("fiberglass_sheet",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> WORLD_SALAD = ITEMS.register("world_salad",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> THATCH = ITEMS.register("thatch",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));

	public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));

	public static final RegistryObject<Item> SMALL_BATTERY = ITEMS.register("small_battery",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));

	public static final RegistryObject<Item> MEDIUM_BATTERY = ITEMS.register("medium_battery",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));

	public static final RegistryObject<Item> LARGE_BATTERY = ITEMS.register("large_battery",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));

	public static final RegistryObject<Item> FLUX_POWDER = ITEMS.register("flux_powder",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));

	public static final RegistryObject<Item> OIL = ITEMS.register("oil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));

	public static final RegistryObject<Item> SILK_STRAND = ITEMS.register("silk_strand",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> PLAGUE_SEED = ITEMS.register("plague_seed",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> ANT_EGG = ITEMS.register("ant_egg",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> ESSENCE_CRYSTAL = ITEMS.register("essence_crystal",
			() -> new EssenceCrystalItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> URCHIN_SHELL = ITEMS.register("urchin_shell",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> CHITIN_SHARD = ITEMS.register("chitin_shard",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> DORMANT_MITOCHONDRION = ITEMS.register("dormant_mitochondrion",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> TOADSTONE = ITEMS.register("toadstone",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> REDSTONE_PROCESSING_MATRIX = ITEMS.register("redstone_processing_matrix",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> REDSTONE_MEMORY_MATRIX = ITEMS.register("redstone_memory_matrix",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> REDSTONE_DATA_MATRIX = ITEMS.register("redstone_data_matrix",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> REDSTONE_INTELLIGENCE_MATRIX = ITEMS.register("redstone_intelligence_matrix",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> SIMPLE_CIRCUITBOARD = ITEMS.register("simple_circuitboard",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> INTERMEDIATE_CIRCUITBOARD = ITEMS.register("intermediate_circuitboard",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> ADVANCED_CIRCUITBOARD = ITEMS.register("advanced_circuitboard",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> STRANGE_MECHANICAL_COMPONENT = ITEMS.register("strange_mechanical_component",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));
	
	public static final RegistryObject<Item> STRANGE_OPTICAL_COMPONENT = ITEMS.register("strange_optical_component",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance)));

	
	// buckets
	public static final RegistryObject<Item> CRUDE_OIL_BUCKET = ITEMS.register("crude_oil_bucket",
			() -> new CrudeOilBucketItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> REFINED_OIL_BUCKET = ITEMS.register("refined_oil_bucket",
			() -> new RefinedOilBucketItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> VEGETABLE_OIL_BUCKET = ITEMS.register("vegetable_oil_bucket",
			() -> new VegetableOilBucketItem(
					new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> PINE_OIL_BUCKET = ITEMS.register("pine_oil_bucket",
			() -> new PineOilBucketItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> ACID_BUCKET = ITEMS.register("acid_bucket",
			() -> new AcidBucketItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> ETHANOL_BUCKET = ITEMS.register("ethanol_bucket",
			() -> new EthanolBucketItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	// fossils
	public static final RegistryObject<Item> URCHIN_SKELETON = ITEMS.register("urchin_skeleton",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> TRILOBITE_SKELETON = ITEMS.register("trilobite_skeleton",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> SHARKTOOTH_SKELETON = ITEMS.register("sharktooth_skeleton",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> GASTROPOD_SKELETON = ITEMS.register("gastropod_skeleton",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> COPROLITE = ITEMS.register("coprolite",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> AMBER_SILVERFISH = ITEMS.register("amber_silverfish",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> FERN_FOSSIL = ITEMS.register("fern_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> CREEPER_FOSSIL = ITEMS.register("creeper_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> CRYSTAL_GHAST_TEAR_FOSSIL = ITEMS.register("crystal_ghast_tear_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> EXTINGUISHED_BLAZE_ROD_FOSSIL = ITEMS.register("extinguished_blaze_rod_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> NETHER_SHELL_FRAGMENT_FOSSIL = ITEMS.register("nether_shell_fragment_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> NETHER_CACTUS_FOSSIL = ITEMS.register("nether_cactus_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> ANCIENT_ENDER_PEARL_FOSSIL = ITEMS.register("ancient_ender_pearl_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> ENDER_BONE_FOSSIL = ITEMS.register("ender_bone_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> ENDERMITE_EGG_FOSSIL = ITEMS.register("endermite_egg_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> SHULKER_SHELL_FOSSIL = ITEMS.register("shulker_shell_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> TRUFFLE_FOSSIL = ITEMS.register("truffle_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> ANT_SHELL_FRAGMENT_FOSSIL = ITEMS.register("ant_shell_fragment_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> BACTERIUM_FOSSIL = ITEMS.register("bacterium_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> MOTH_FOSSIL = ITEMS.register("moth_fossil",
			() -> new Item(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> COPROLITE_PRINT = ITEMS.register("coprolite_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> AMBER_SILVERFISH_PRINT = ITEMS.register("amber_silverfish_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> FERN_FOSSIL_PRINT = ITEMS.register("fern_fossil_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> CREEPER_FOSSIL_PRINT = ITEMS.register("creeper_fossil_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> URCHIN_PRINT = ITEMS.register("urchin_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> TRILOBITE_PRINT = ITEMS.register("trilobite_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> SHARKTOOTH_PRINT = ITEMS.register("sharktooth_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> GASTROPOD_PRINT = ITEMS.register("gastropod_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> CRYSTAL_GHAST_TEAR_PRINT = ITEMS.register("crystal_ghast_tear_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> EXTINGUISHED_BLAZE_ROD_PRINT = ITEMS.register("extinguished_blaze_rod_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> NETHER_SHELL_FRAGMENT_PRINT = ITEMS.register("nether_shell_fragment_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> NETHER_CACTUS_PRINT = ITEMS.register("nether_cactus_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> ANCIENT_ENDER_PEARL_PRINT = ITEMS.register("ancient_ender_pearl_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> ENDER_BONE_PRINT = ITEMS.register("ender_bone_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> ENDERMITE_EGG_PRINT = ITEMS.register("endermite_egg_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> SHULKER_SHELL_PRINT = ITEMS.register("shulker_shell_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> TRUFFLE_PRINT = ITEMS.register("truffle_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> ANT_SHELL_FRAGMENT_PRINT = ITEMS.register("ant_shell_fragment_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> BACTERIUM_PRINT = ITEMS.register("bacterium_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));
	
	public static final RegistryObject<Item> MOTH_PRINT = ITEMS.register("moth_print",
			() -> new FossilPrintItem(new Item.Properties().group(WorldSaladItemsItemGroup.instance).maxStackSize(1)));

	// ores
	public static final RegistryObject<Item> BIOLUMINESCENT_CRYSTAL = ITEMS.register("bioluminescent_crystal",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> SPORE_QUARTZ = ITEMS.register("spore_quartz",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> BLOOD_QUARTZ = ITEMS.register("blood_quartz",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> VOID_QUARTZ = ITEMS.register("void_quartz",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> SALT = ITEMS.register("salt",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> LITHIUM_DUST = ITEMS.register("lithium_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> SILICON_INGOT = ITEMS.register("silicon_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> SILICON_NUGGET = ITEMS.register("silicon_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> LEAD_NUGGET = ITEMS.register("lead_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> PLATINUM_NUGGET = ITEMS.register("platinum_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> URANIUM_NUGGET = ITEMS.register("uranium_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> MOLYBDENUM_NUGGET = ITEMS.register("molybdenum_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> MITHRIL_NUGGET = ITEMS.register("mithril_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> MOLYSTEEL_INGOT = ITEMS.register("molysteel_ingot",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> MOLYSTEEL_NUGGET = ITEMS.register("molysteel_nugget",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> ZINC_DUST = ITEMS.register("zinc_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	public static final RegistryObject<Item> MANGANESE_DUST = ITEMS.register("manganese_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> DIRTY_COPPER_DUST = ITEMS.register("dirty_copper_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> DIRTY_IRON_DUST = ITEMS.register("dirty_iron_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> DIRTY_GOLD_DUST = ITEMS.register("dirty_gold_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> DIRTY_ALUMINUM_DUST = ITEMS.register("dirty_aluminum_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> MITHRIL_DUST = ITEMS.register("mithril_dust",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> COAL_POWDER = ITEMS.register("coal_powder",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> CRUSHED_LIMESTONE = ITEMS.register("crushed_limestone",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> ALLOY_BLEND = ITEMS.register("alloy_blend",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> AMBER = ITEMS.register("amber",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));
	
	public static final RegistryObject<Item> AMBER_DROPLET = ITEMS.register("amber_droplet",
			() -> new Item(new Item.Properties().group(WorldSaladMaterialsItemGroup.instance)));

	// food
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> FRIED_CHICKEN = ITEMS.register("fried_chicken",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(7).saturation(0.8f)
							.effect(new EffectInstance(Effects.REGENERATION, 100, 1), 1f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> BACON = ITEMS.register("bacon",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(7).saturation(0.8f).setAlwaysEdible()
							.effect(new EffectInstance(Effects.STRENGTH, 200, 0), 1f).build())));
	public static final RegistryObject<Item> GREEN_APPLE = ITEMS.register("green_apple",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(4).saturation(0.3f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> GHOST_GRAPES = ITEMS.register("ghost_grapes",
			() -> new BlockItem(BlockInit.GHOST_GRAPE_BUSH.get(),
					new Item.Properties().group(WorldSaladFoodItemGroup.instance)
							.food(new Food.Builder().hunger(1).saturation(0f).setAlwaysEdible().fastToEat()
									.effect(new EffectInstance(Effects.SLOW_FALLING, 20, 1), 1f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> LUMBERRY = ITEMS.register("lumberry",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(1).saturation(0f).setAlwaysEdible().fastToEat()
							.effect(new EffectInstance(Effects.NIGHT_VISION, 400, 0), 1f).build())));

	public static final RegistryObject<Item> FUNGBERRY = ITEMS.register("fungberry",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(1).saturation(0f).fastToEat().build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> MOLDBERRY = ITEMS.register("moldberry",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(1).saturation(0f).setAlwaysEdible().fastToEat()
							.effect(new EffectInstance(Effects.BLINDNESS, 400, 0), 1f).build())));
	
	public static final RegistryObject<Item> RAW_SQUID = ITEMS.register("raw_squid",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(2).saturation(0f).build())));
	
	public static final RegistryObject<Item> COOKED_SQUID = ITEMS.register("cooked_squid",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(6).saturation(0.2f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> FRIED_CALAMARI = ITEMS.register("fried_calamari",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(6).saturation(0.5f).effect(new EffectInstance(Effects.WATER_BREATHING, 400, 0), 1f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> FRENCH_FRIES = ITEMS.register("french_fries",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(4).saturation(0.5f).effect(new EffectInstance(Effects.HASTE, 600, 1), 1f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> FRIED_MOREL = ITEMS.register("fried_morel",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(6).saturation(0.5f).effect(new EffectInstance(Effects.RESISTANCE, 1800, 0), 1f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> HOTCOFFEE_BEANS = ITEMS.register("hotcoffee_beans",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(0).saturation(0f).fastToEat()
							.effect(new EffectInstance(Effects.HUNGER, 100, 0), 1f).build())));
	
	public static final RegistryObject<Item> CHOCOLATE_HOTCOFFEE_BEANS = ITEMS.register("chocolate_hotcoffee_beans",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(4).saturation(0f).setAlwaysEdible().fastToEat()
							.build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> EARTHWORMS = ITEMS.register("earthworms",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(1).saturation(0f).setAlwaysEdible().fastToEat()
							.effect(new EffectInstance(Effects.HASTE, 200, 0), 1f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> GUMMY_WORMS = ITEMS.register("gummy_worms",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(4).saturation(0f).setAlwaysEdible().fastToEat()
							.effect(new EffectInstance(Effects.HASTE, 500, 0), 1f).build())));
	
	public static final RegistryObject<Item> RAW_ENOKI_BULB = ITEMS.register("raw_enoki_bulb",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(2).saturation(0f).build())));
	
	public static final RegistryObject<Item> SMOKED_ENOKI_BULB = ITEMS.register("smoked_enoki_bulb",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(5).saturation(0.2f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> RAW_TOAD = ITEMS.register("raw_toad",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(2).saturation(0f).effect(new EffectInstance(Effects.POISON, 500, 0), 0.2f).build())));
	
	public static final RegistryObject<Item> COOKED_TOAD = ITEMS.register("cooked_toad",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(5).saturation(0.6f).build())));
	
	public static final RegistryObject<Item> HYPHAE_BERRY_PIE = ITEMS.register("hyphae_berry_pie",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(8).saturation(0.35f).build())));
	
	public static final RegistryObject<Item> PASSION_FRUIT = ITEMS.register("passion_fruit",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(4).saturation(0.2f).build())));
	
	public static final RegistryObject<Item> MADRONEBERRY = ITEMS.register("madroneberry",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(2).saturation(0.1f).build())));
	
	public static final RegistryObject<Item> URCHIN_ROE = ITEMS.register("urchin_roe",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(4).saturation(0.45f).build())));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> GLOWSHROOM_STEW = ITEMS.register("glowshroom_stew",
			() -> new ModStewItem(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(5).saturation(0.2f).effect(new EffectInstance(Effects.GLOWING, 2400, 0), 1f).build()).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> GREATER_MUSHROOM_STEW = ITEMS.register("greater_mushroom_stew",
			() -> new ModStewItem(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(9).saturation(0.5f).effect(new EffectInstance(Effects.ABSORPTION, 2400, 2), 1f).build()).maxStackSize(1)));
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> MEGA_STUFFED_MUSHROOM = ITEMS.register("mega_stuffed_mushroom",
			() -> new Item(new Item.Properties().group(WorldSaladFoodItemGroup.instance)
					.food(new Food.Builder().hunger(10).saturation(1.0F).setAlwaysEdible().fastToEat()
							.effect(new EffectInstance(Effects.STRENGTH, 800, 0), 1f).effect(new EffectInstance(Effects.REGENERATION, 40, 3), 1f).effect(new EffectInstance(Effects.RESISTANCE, 1200, 0), 1f).build())));

	// spawn eggs
	public static final RegistryObject<ModSpawnEggItem> MOTH_SPAWN_EGG = ITEMS.register("moth_spawn_egg",
			() -> new ModSpawnEggItem(EntityInit.MOTH, 0x9bd494, 0x563b63,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));

	public static final RegistryObject<ModSpawnEggItem> ROCK_MONSTER_SPAWN_EGG = ITEMS
			.register("rock_monster_spawn_egg", () -> new ModSpawnEggItem(EntityInit.ROCK_MONSTER, 0xaab1b3, 0x4e5557,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> EXOSKELETON_SPAWN_EGG = ITEMS
			.register("exoskeleton_spawn_egg", () -> new ModSpawnEggItem(EntityInit.EXOSKELETON, 0xe6e6e6, 0x9be04c,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> CORDYCEPS_ANT_SPAWN_EGG = ITEMS
			.register("cordyceps_ant_spawn_egg", () -> new ModSpawnEggItem(EntityInit.CORDYCEPS_ANT, 0x57370a, 0x597848,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> WRAITH_SPAWN_EGG = ITEMS
			.register("wraith_spawn_egg", () -> new ModSpawnEggItem(EntityInit.WRAITH, 0x1c0610, 0xb0d0d1,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> URCHIN_SPAWN_EGG = ITEMS
			.register("urchin_spawn_egg", () -> new ModSpawnEggItem(EntityInit.URCHIN, 0x211f21, 0x631863,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> SOLDIER_ANT_SPAWN_EGG = ITEMS
			.register("soldier_ant_spawn_egg", () -> new ModSpawnEggItem(EntityInit.SOLDIER_ANT, 0x57370a, 0xc72020,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> TRADER_ANT_SPAWN_EGG = ITEMS
			.register("trader_ant_spawn_egg", () -> new ModSpawnEggItem(EntityInit.TRADER_ANT, 0x57370a, 0x20bcc7,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> WORKER_ANT_SPAWN_EGG = ITEMS
			.register("worker_ant_spawn_egg", () -> new ModSpawnEggItem(EntityInit.WORKER_ANT, 0x57370a, 0xde9b2f,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> FUNGAL_ZOMBIE_SPAWN_EGG = ITEMS
			.register("fungal_zombie_spawn_egg", () -> new ModSpawnEggItem(EntityInit.FUNGAL_ZOMBIE, 0x47705f, 0x9bb06a,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> MACROBE_SPAWN_EGG = ITEMS
			.register("macrobe_spawn_egg", () -> new ModSpawnEggItem(EntityInit.MACROBE, 0x50ad80f, 0xe6e6e6,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> REDCAP_SPAWN_EGG = ITEMS
			.register("redcap_spawn_egg", () -> new ModSpawnEggItem(EntityInit.REDCAP, 0xf2ddb6, 0xbd2f2f,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	 
	public static final RegistryObject<ModSpawnEggItem> BROWNCAP_SPAWN_EGG = ITEMS
			.register("browncap_spawn_egg", () -> new ModSpawnEggItem(EntityInit.BROWNCAP, 0xf2ddb6, 0x876e3e,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> BLUECAP_SPAWN_EGG = ITEMS
			.register("bluecap_spawn_egg", () -> new ModSpawnEggItem(EntityInit.BLUECAP, 0xf2ddb6, 0x5ae0cc,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> GIANT_TOAD_SPAWN_EGG = ITEMS
			.register("giant_toad_spawn_egg", () -> new ModSpawnEggItem(EntityInit.GIANT_TOAD, 0x6c8548, 0x69582f,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> BIOLUMINARY_SPAWN_EGG = ITEMS
			.register("bioluminary_spawn_egg", () -> new ModSpawnEggItem(EntityInit.BIOLUMINARY, 0x82d1d0, 0xc99a49,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> DRAGONFLY_SPAWN_EGG = ITEMS
			.register("dragonfly_spawn_egg", () -> new ModSpawnEggItem(EntityInit.DRAGONFLY, 0xccecf0, 0x253d70,
					new Item.Properties().group(WorldSaladSpawnEggsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> GLOWING_COG = ITEMS
			.register("glowing_cog", () -> new ModSpawnEggItem(EntityInit.BIOLUMINESCENT_HORROR, 0xccecf0, 0x253d70,
					new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
	
	public static final RegistryObject<ModSpawnEggItem> INFESTED_EGG = ITEMS
			.register("infested_egg", () -> new ModSpawnEggItem(EntityInit.INFECTED_QUEEN, 0xccecf0, 0x253d70,
					new Item.Properties().group(WorldSaladToolsItemGroup.instance)));
}
