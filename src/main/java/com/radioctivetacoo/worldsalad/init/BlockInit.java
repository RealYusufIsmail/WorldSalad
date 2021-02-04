 package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.objects.blocks.AluminumPlatformBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.DenseMadroneLeavesBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.DirtCakeBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.FalseExperienceOreBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.FireGeyserBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.GeodeBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.GlowingHyceliumBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.GlowshroomBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.HyceliumBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.LeafPileBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.LumbooBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.MadroneLeavesBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModCarpetBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModDoorBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModLogBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModMushroomBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModOreBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModPaneBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModPressurePlateBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModSaplingBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModTrapDoorBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.ModWoodButtonBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.MoldgrassBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.MoondustBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.MushrineBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.AlloyFurnaceBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.ArchaeologyStationBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.BoilerBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.DeepFryerBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.DisplayStandBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.DistillerBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.DistillingBarrelBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.EssenceCatalystBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.FloatationBinBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.HydraulicPressBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.IncensePlateBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.IndustrialGrinderBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.KilnBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.LesserInfuserBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.PolymerizationReactorBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.SeedPressBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.machines.SpinningWheelBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.AmanitaBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.DeathcapBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.DesertShaggyManeBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.DryReedBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.FountainGrassBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.FungrassBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.GhostGrapeBushBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.HotcoffeeCropBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.LichenBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.LumgrassBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.MoldGrowthBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.MorelBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.PassionFruitBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.PassionVineCropBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.TallFungrassBlock;
import com.radioctivetacoo.worldsalad.objects.blocks.plants.TallLumgrassBlock;
import com.radioctivetacoo.worldsalad.world.feature.MadroneTree;
import com.radioctivetacoo.worldsalad.world.feature.WillowTree;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.HayBlock;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			WorldSalad.MOD_ID);

	// Special Blocks
	public static final RegistryObject<Block> DEEP_FRYER = BLOCKS.register("deep_fryer",
			() -> new DeepFryerBlock(
					Block.Properties.create(Material.IRON).lightValue(11).hardnessAndResistance(2.0f, 10.0f)
							.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> KILN = BLOCKS.register("kiln",
			() -> new KilnBlock(Block.Properties.create(Material.ROCK).lightValue(11).hardnessAndResistance(1.8f, 7.0f)
							.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> SEED_PRESS = BLOCKS.register("seed_press",
			() -> new SeedPressBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.6f, 4.0f)
					.harvestTool(ToolType.AXE).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> SPINNING_WHEEL = BLOCKS.register("spinning_wheel",
			() -> new SpinningWheelBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.6f, 4.0f)
					.harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> LESSER_INFUSER = BLOCKS.register("lesser_infuser",
			() -> new LesserInfuserBlock(Block.Properties.create(Material.ROCK).lightValue(11).hardnessAndResistance(2.0f, 99.0f)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> HYDRAULIC_PRESS = BLOCKS.register("hydraulic_press",
			() -> new HydraulicPressBlock(Block.Properties.from(Blocks.IRON_BLOCK)));
	
	public static final RegistryObject<Block> MUSHRINE = BLOCKS.register("mushrine",
			() -> new MushrineBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(6.6f, 99.0f)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> ARCHAEOLOGY_STATION = BLOCKS.register("archaeology_station",
			() -> new ArchaeologyStationBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(4.6f, 99.0f)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> ALLOY_FURNACE = BLOCKS.register("alloy_furnace",
			() -> new AlloyFurnaceBlock(Block.Properties.create(Material.IRON).lightValue(11).hardnessAndResistance(4.6f, 99.0f)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> FLOATATION_BIN = BLOCKS.register("floatation_bin",
			() -> new FloatationBinBlock(Block.Properties.create(Material.IRON).lightValue(11).hardnessAndResistance(4.6f, 99.0f)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> INDUSTRIAL_GRINDER = BLOCKS.register("industrial_grinder",
			() -> new IndustrialGrinderBlock(Block.Properties.create(Material.IRON).lightValue(11).hardnessAndResistance(4.6f, 99.0f)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> DISPLAY_STAND = BLOCKS.register("display_stand",
			() -> new DisplayStandBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.6f, 99.0f)
					.harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> DISTILLING_BARREL = BLOCKS.register("distilling_barrel",
			() -> new DistillingBarrelBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.6f, 99.0f)
					.harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> DIRT_CAKE = BLOCKS.register("dirt_cake",
			() -> new DirtCakeBlock(Block.Properties.from(Blocks.CAKE)));
	
	public static final RegistryObject<Block> ESSENCE_CATALYST = BLOCKS.register("essence_catalyst",
			() -> new EssenceCatalystBlock(Block.Properties.from(Blocks.STONE).doesNotBlockMovement().lightValue(14)));
	
	public static final RegistryObject<Block> DISTILLATION_TOWER_BLOCK = BLOCKS.register("distillation_tower_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2f, 99.0f)));
	
	public static final RegistryObject<Block> DISTILLER = BLOCKS.register("distiller",
			() -> new DistillerBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.6f, 99.0f)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> BOILER = BLOCKS.register("boiler",
			() -> new BoilerBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.6f, 99.0f)
					.harvestLevel(1).lightValue(11).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> POLYMERIZATION_REACTOR = BLOCKS.register("polymerization_reactor",
			() -> new PolymerizationReactorBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.6f, 99.0f)
					.harvestLevel(1).lightValue(11).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> INCENSE_PLATE = BLOCKS.register("incense_plate",
			() -> new IncensePlateBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(1.6f, 99.0f)
					.lightValue(4).sound(SoundType.METAL)));

	// Decorations
	public static final RegistryObject<Block> MAGIC_CHALK_BLOCK = BLOCKS.register("magic_chalk_block",
			() -> new Block(Block.Properties.from(Blocks.STONE).hardnessAndResistance(0.4f, 2f)));
	
	public static final RegistryObject<Block> ALUMINUM_PLATE_WALL = BLOCKS.register("aluminum_plate_wall",
			() -> new Block(Block.Properties.from(Blocks.STONE).sound(SoundType.METAL).hardnessAndResistance(1.1f, 2f)));
	
	public static final RegistryObject<Block> ALUMINUM_PLATFORM = BLOCKS.register("aluminum_platform",
			() -> new AluminumPlatformBlock(Block.Properties.from(Blocks.STONE).sound(SoundType.METAL).hardnessAndResistance(1.1f, 2f)));
	
	public static final RegistryObject<Block> MAGIC_CHALK_BRICKS = BLOCKS.register("magic_chalk_bricks",
			() -> new Block(Block.Properties.from(Blocks.STONE).hardnessAndResistance(0.4f, 2f)));
	
	public static final RegistryObject<Block> MAGIC_CHALK_PAVER = BLOCKS.register("magic_chalk_paver",
			() -> new Block(Block.Properties.from(Blocks.STONE).hardnessAndResistance(0.4f, 2f)));
	
	public static final RegistryObject<Block> FIREGEYSER = BLOCKS.register("firegeyser",
			() -> new FireGeyserBlock(Block.Properties.from(Blocks.STONE)));

	public static final RegistryObject<Block> PLACEHOLDER_BLOCK = BLOCKS.register("placeholder_block", 
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 99.0f).sound(SoundType.GLASS)));
	
	public static final RegistryObject<Block> HYPHAE_BRICKS = BLOCKS.register("hyphae_bricks",
			() -> new Block(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> CHISELLED_HYPHAE_BRICK = BLOCKS.register("chiselled_hyphae_brick",
			() -> new Block(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> WEATHERED_HYPHAE_BRICKS = BLOCKS.register("weathered_hyphae_bricks",
			() -> new Block(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> MOLDY_HYPHAE_BRICKS = BLOCKS.register("moldy_hyphae_bricks",
			() -> new Block(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> ADOBE_BRICKS = BLOCKS.register("adobe_bricks",
			() -> new Block(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> SIMPLE_MACHINE_CASING = BLOCKS.register("simple_machine_casing",
			() -> new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
	
	public static final RegistryObject<Block> ADVANCED_MACHINE_CASING = BLOCKS.register("advanced_machine_casing",
			() -> new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
	
	public static final RegistryObject<Block> AMBER_LAMP = BLOCKS.register("amber_lamp",
			() -> new Block(Block.Properties.from(Blocks.STONE).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> BLACK_NEON_BLOCK = BLOCKS.register("black_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> GRAY_NEON_BLOCK = BLOCKS.register("gray_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> LIGHT_GRAY_NEON_BLOCK = BLOCKS.register("light_gray_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> WHITE_NEON_BLOCK = BLOCKS.register("white_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> BLUE_NEON_BLOCK = BLOCKS.register("blue_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> ORANGE_NEON_BLOCK = BLOCKS.register("orange_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> YELLOW_NEON_BLOCK = BLOCKS.register("yellow_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> RED_NEON_BLOCK = BLOCKS.register("red_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> LIGHT_BLUE_NEON_BLOCK = BLOCKS.register("light_blue_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> PINK_NEON_BLOCK = BLOCKS.register("pink_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> PURPLE_NEON_BLOCK = BLOCKS.register("purple_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));

	public static final RegistryObject<Block> LIME_NEON_BLOCK = BLOCKS.register("lime_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> MAGENTA_NEON_BLOCK = BLOCKS.register("magenta_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> CYAN_NEON_BLOCK = BLOCKS.register("cyan_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> GREEN_NEON_BLOCK = BLOCKS.register("green_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> BROWN_NEON_BLOCK = BLOCKS.register("brown_neon_block",
			() -> new Block(Block.Properties.from(Blocks.GLASS).sound(SoundType.GLASS).lightValue(14)));
	
	public static final RegistryObject<Block> MADRONE_LEAF_PILE = BLOCKS.register("madrone_leaf_pile",
			() -> new LeafPileBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> OAK_LEAF_PILE = BLOCKS.register("oak_leaf_pile",
			() -> new LeafPileBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> BIRCH_LEAF_PILE = BLOCKS.register("birch_leaf_pile",
			() -> new LeafPileBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> SPRUCE_LEAF_PILE = BLOCKS.register("spruce_leaf_pile",
			() -> new LeafPileBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> DARK_OAK_LEAF_PILE = BLOCKS.register("dark_oak_leaf_pile",
			() -> new LeafPileBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> ACACIA_LEAF_PILE = BLOCKS.register("acacia_leaf_pile",
			() -> new LeafPileBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> JUNGLE_LEAF_PILE = BLOCKS.register("jungle_leaf_pile",
			() -> new LeafPileBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> WILLOW_LEAF_PILE = BLOCKS.register("willow_leaf_pile",
			() -> new LeafPileBlock(Block.Properties.from(Blocks.OAK_LEAVES)));;
	
	public static final RegistryObject<Block> BROWN_LEAF_PILE = BLOCKS.register("brown_leaf_pile",
			() -> new LeafPileBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	// Stones and dirts
	public static final RegistryObject<Block> MOLDY_HYPHAE_COBBLESTONE = BLOCKS.register("moldy_hyphae_cobblestone",
			() -> new Block(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> GLOWING_HYCELIUM = BLOCKS.register("glowing_hycelium",
			() -> new GlowingHyceliumBlock(Block.Properties.from(Blocks.GRASS_BLOCK).lightValue(6)));

	public static final RegistryObject<Block> HYCELIUM = BLOCKS.register("hycelium",
			() -> new HyceliumBlock(Block.Properties.from(Blocks.GRASS_BLOCK)));

	public static final RegistryObject<Block> MOLDGRASS = BLOCKS.register("moldgrass",
			() -> new MoldgrassBlock(Block.Properties.from(Blocks.GRASS_BLOCK)));

	public static final RegistryObject<Block> FUNGAL_DIRT = BLOCKS.register("fungal_dirt",
			() -> new Block(Block.Properties.from(Blocks.DIRT)));

	public static final RegistryObject<Block> TOUGH_HYPHAE = BLOCKS.register("tough_hyphae",
			() -> new Block(Block.Properties.from(Blocks.STONE)));

	public static final RegistryObject<Block> HYPHAE_COBBLESTONE = BLOCKS.register("hyphae_cobblestone",
			() -> new Block(Block.Properties.from(Blocks.STONE)));
	
	public static final RegistryObject<Block> INFERTILE_SOIL = BLOCKS.register("infertile_soil",
			() -> new Block(Block.Properties.from(Blocks.DIRT)));

	public static final RegistryObject<Block> SHALE = BLOCKS.register("shale",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.0f, 4.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> BLACK_SHALE = BLOCKS.register("black_shale",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 4.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> LAVAROCK = BLOCKS.register("lavarock",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8f, 4.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> GYPSUM = BLOCKS.register("gypsum",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6.0f, 4.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> LIMESTONE = BLOCKS.register("limestone",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.4f, 4.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> SILTSTONE = BLOCKS.register("siltstone",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.4f, 4.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> SILT = BLOCKS.register("silt",
			() -> new FallingBlock(Block.Properties.from(Blocks.SAND)));
	
	public static final RegistryObject<Block> MOONDUST = BLOCKS.register("moondust",
			() -> new MoondustBlock(0xd613d0, Block.Properties.create(Material.EARTH, MaterialColor.LIGHT_GRAY).sound(SoundType.SAND).hardnessAndResistance(0.7f, 1f).harvestTool(ToolType.SHOVEL)));
	
	public static final RegistryObject<Block> BIOSEDIMENT = BLOCKS.register("biosediment",
			() -> new FallingBlock(Block.Properties.from(Blocks.SAND)));
	
	public static final RegistryObject<Block> ASH_BLOCK = BLOCKS.register("ash_block",
			() -> new FallingBlock(Block.Properties.from(Blocks.SAND)));
	
	public static final RegistryObject<Block> VOLCANIC_GRAVEL = BLOCKS.register("volcanic_gravel",
			() -> new FallingBlock(Block.Properties.from(Blocks.GRAVEL)));

	public static final RegistryObject<Block> MUD = BLOCKS.register("mud",
			() -> new Block(Block.Properties.from(Blocks.DIRT)));

	public static final RegistryObject<Block> MUDSTONE = BLOCKS.register("mudstone",
			() -> new Block(Block.Properties.from(Blocks.TERRACOTTA)));

	public static final RegistryObject<Block> CLAYSTONE = BLOCKS.register("claystone",
			() -> new Block(Block.Properties.from(Blocks.TERRACOTTA)));

	public static final RegistryObject<Block> GREEN_CLAYSTONE = BLOCKS.register("green_claystone",
			() -> new Block(Block.Properties.from(Blocks.TERRACOTTA)));

	public static final RegistryObject<Block> RED_CLAYSTONE = BLOCKS.register("red_claystone",
			() -> new Block(Block.Properties.from(Blocks.TERRACOTTA)));

	public static final RegistryObject<Block> PURPLE_CLAYSTONE = BLOCKS.register("purple_claystone",
			() -> new Block(Block.Properties.from(Blocks.TERRACOTTA)));

	public static final RegistryObject<Block> WHITE_CLAYSTONE = BLOCKS.register("white_claystone",
			() -> new Block(Block.Properties.from(Blocks.TERRACOTTA)));
	
	public static final RegistryObject<Block> ADOBE_BLOCK = BLOCKS.register("adobe_block",
			() -> new Block(Block.Properties.from(Blocks.TERRACOTTA)));

	public static final RegistryObject<Block> ROCK_SALT = BLOCKS.register("rock_salt",
			() -> new Block(Block.Properties.from(Blocks.TERRACOTTA)));

	public static final RegistryObject<Block> SLATE = BLOCKS.register("slate",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.4f, 4.0f)
					.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> FOUNTAIN_GRASS = BLOCKS.register("fountain_grass",
			() -> new FountainGrassBlock(Block.Properties.from(Blocks.TALL_GRASS)));
	
	public static final RegistryObject<Block> THATCH_BLOCK = BLOCKS.register("thatch_block",
			() -> new HayBlock(Block.Properties.from(Blocks.HAY_BLOCK)));
	
	public static final RegistryObject<Block> THATCH_MAT = BLOCKS.register("thatch_mat",
			() -> new ModCarpetBlock(Block.Properties.from(Blocks.HAY_BLOCK)));
	
	public static final RegistryObject<Block> WET_GRASS_BLOCK = BLOCKS.register("wet_grass_block",
			() -> new HayBlock(Block.Properties.from(Blocks.HAY_BLOCK)));
	
	public static final RegistryObject<Block> WET_GRASS_MAT = BLOCKS.register("wet_grass_mat",
			() -> new ModCarpetBlock(Block.Properties.from(Blocks.HAY_BLOCK)));
	
	public static final RegistryObject<Block> REED_BLOCK = BLOCKS.register("reed_block",
			() -> new HayBlock(Block.Properties.from(Blocks.HAY_BLOCK)));
	
	public static final RegistryObject<Block> REED_MAT = BLOCKS.register("reed_mat",
			() -> new ModCarpetBlock(Block.Properties.from(Blocks.HAY_BLOCK)));
	
	public static final RegistryObject<Block> GEODE = BLOCKS.register("geode",
			() -> new GeodeBlock(Block.Properties.from(Blocks.STONE).hardnessAndResistance(0.5f, 4.0f)));
	
	public static final RegistryObject<Block> HOTCOFFEE_CROP = BLOCKS.register("hotcoffee_crop",
			() -> new HotcoffeeCropBlock(Block.Properties.from(Blocks.WHEAT)));
	
	public static final RegistryObject<Block> PASSION_VINE_CROP = BLOCKS.register("passion_vine_crop",
			() -> new PassionVineCropBlock(Block.Properties.from(Blocks.WHEAT)));
	
	public static final RegistryObject<Block> PASSION_FRUIT_BLOCK = BLOCKS.register("passion_fruit_block",
			() -> new PassionFruitBlock(Block.Properties.create(Material.BAMBOO).sound(SoundType.BAMBOO_SAPLING).hardnessAndResistance(0.0f, 1.0f).doesNotBlockMovement()));
	
	public static final RegistryObject<Block> AMBER_GLASS = BLOCKS.register("amber_glass",
			() -> new GlassBlock(Block.Properties.from(Blocks.GLASS)));
	
	public static final RegistryObject<Block> AMBER_GLASS_PANE = BLOCKS.register("amber_glass_pane",
			() -> new ModPaneBlock(Block.Properties.from(Blocks.GLASS_PANE)));
	
	public static final RegistryObject<Block> LUMINANT_BIOMASS_BLOCK = BLOCKS.register("luminant_biomass_block",
			() -> new Block(Block.Properties.from(Blocks.DIRT).hardnessAndResistance(0.3f, 0.1f).sound(SoundType.SLIME).lightValue(14)));

	// Quartz Blocks
	public static final RegistryObject<Block> SPORE_QUARTZ_PILLAR = BLOCKS.register("spore_quartz_pillar",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLOOD_QUARTZ_PILLAR = BLOCKS.register("blood_quartz_pillar",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> VOID_QUARTZ_PILLAR = BLOCKS.register("void_quartz_pillar",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> CHISELLED_SPORE_QUARTZ = BLOCKS.register("chiselled_spore_quartz",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> CHISELLED_BLOOD_QUARTZ = BLOCKS.register("chiselled_blood_quartz",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> CHISELLED_VOID_QUARTZ = BLOCKS.register("chiselled_void_quartz",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> SPORE_QUARTZ_BLOCK = BLOCKS.register("spore_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLOOD_QUARTZ_BLOCK = BLOCKS.register("blood_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> VOID_QUARTZ_BLOCK = BLOCKS.register("void_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SMOOTH_SPORE_QUARTZ = BLOCKS.register("smooth_spore_quartz",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SMOOTH_BLOOD_QUARTZ = BLOCKS.register("smooth_blood_quartz",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SMOOTH_VOID_QUARTZ = BLOCKS.register("smooth_void_quartz",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> BORDERED_BLOOD_QUARTZ_STAIRS = BLOCKS.register("bordered_blood_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_BLOOD_QUARTZ.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> BORDERED_SPORE_QUARTZ_STAIRS = BLOCKS.register("bordered_spore_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_SPORE_QUARTZ.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLUE).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> BORDERED_VOID_QUARTZ_STAIRS = BLOCKS.register("bordered_void_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_VOID_QUARTZ.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> BORDERED_SPORE_QUARTZ_SLAB = BLOCKS.register("bordered_spore_quartz_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.SMOOTH_SPORE_QUARTZ.get())));

	public static final RegistryObject<Block> BORDERED_BLOOD_QUARTZ_SLAB = BLOCKS.register("bordered_blood_quartz_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.SMOOTH_BLOOD_QUARTZ.get())));

	public static final RegistryObject<Block> BORDERED_VOID_QUARTZ_SLAB = BLOCKS.register("bordered_void_quartz_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.SMOOTH_VOID_QUARTZ.get())));

	public static final RegistryObject<Block> BLOOD_QUARTZ_STAIRS = BLOCKS.register("blood_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_BLOOD_QUARTZ.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> SPORE_QUARTZ_STAIRS = BLOCKS.register("spore_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_SPORE_QUARTZ.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLUE).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> VOID_QUARTZ_STAIRS = BLOCKS.register("void_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_VOID_QUARTZ.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.BLACK).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));

	public static final RegistryObject<Block> SPORE_QUARTZ_SLAB = BLOCKS.register("spore_quartz_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.SMOOTH_SPORE_QUARTZ.get())));

	public static final RegistryObject<Block> BLOOD_QUARTZ_SLAB = BLOCKS.register("blood_quartz_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.SMOOTH_BLOOD_QUARTZ.get())));

	public static final RegistryObject<Block> VOID_QUARTZ_SLAB = BLOCKS.register("void_quartz_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.SMOOTH_VOID_QUARTZ.get())));

	// Mineral blocks
	public static final RegistryObject<Block> FIBERGLASS_BLOCK = BLOCKS.register("fiberglass_block", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 2.0f).sound(SoundType.CLOTH)));

	public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 60.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> MOLYSTEEL_BLOCK = BLOCKS.register("molysteel_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 60.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	
	public static final RegistryObject<Block> AMBER_BLOCK = BLOCKS.register("amber_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.1f, 6.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> PLATINUM_BLOCK = BLOCKS.register("platinum_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> ALUMINUM_BLOCK = BLOCKS.register("aluminum_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).lightValue(9).sound(SoundType.METAL)));

	public static final RegistryObject<Block> MANGANESE_BLOCK = BLOCKS.register("manganese_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> ZINC_BLOCK = BLOCKS.register("zinc_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> COBALT_BLOCK = BLOCKS.register("cobalt_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> BIOLUMINESCENT_CRYSTAL_BLOCK = BLOCKS.register(
			"bioluminescent_crystal_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).lightValue(14).sound(SoundType.METAL)));

	public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> TUNGSTEN_BLOCK = BLOCKS.register("tungsten_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> SULFUR_BLOCK = BLOCKS.register("sulfur_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> LITHIUM_BLOCK = BLOCKS.register("lithium_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> MOLYBDENUM_BLOCK = BLOCKS.register("molybdenum_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	public static final RegistryObject<Block> MITHRIL_BLOCK = BLOCKS.register("mithril_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(1.5f, 6.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).lightValue(9).sound(SoundType.METAL)));

	// Willow
	public static final RegistryObject<Block> WILLOW_PLANKS = BLOCKS.register("willow_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> WILLOW_LOG = BLOCKS.register("willow_log",
			() -> new ModLogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> WILLOW_WOOD = BLOCKS.register("willow_wood",
			() -> new ModLogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> STRIPPED_WILLOW_LOG = BLOCKS.register("stripped_willow_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> STRIPPED_WILLOW_WOOD = BLOCKS.register("stripped_willow_wood",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> WILLOW_LEAVES = BLOCKS.register("willow_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> WILLOW_SAPLING = BLOCKS.register("willow_sapling",
			() -> new ModSaplingBlock(() -> new WillowTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

	public static final RegistryObject<Block> WILLOW_STAIRS = BLOCKS.register("willow_stairs",
			() -> new StairsBlock(() -> BlockInit.WILLOW_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2f, 3.0f)
							.sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

	public static final RegistryObject<Block> WILLOW_FENCE = BLOCKS.register("willow_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN)
					.hardnessAndResistance(2f, 3.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

	public static final RegistryObject<Block> WILLOW_BUTTON = BLOCKS.register("willow_button",
			() -> new ModWoodButtonBlock(
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2f, 3.0f)
							.sound(SoundType.WOOD).doesNotBlockMovement().harvestTool(ToolType.AXE)));

	public static final RegistryObject<Block> WILLOW_PRESSURE_PLATE = BLOCKS.register("willow_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2f, 3.0f)
							.doesNotBlockMovement().sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

	public static final RegistryObject<Block> WILLOW_SLAB = BLOCKS.register("willow_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.WILLOW_PLANKS.get())));

	public static final RegistryObject<Block> WILLOW_DOOR = BLOCKS.register("willow_door",
			() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)));

	public static final RegistryObject<Block> WILLOW_TRAPDOOR = BLOCKS.register("willow_trapdoor",
			() -> new ModTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)));

	public static final RegistryObject<Block> WILLOW_FENCE_GATE = BLOCKS.register("willow_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
	
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Block> POTTED_WILLOW_SAPLING = BLOCKS.register("potted_willow_sapling",
			() -> new FlowerPotBlock(WILLOW_SAPLING.get(), Block.Properties.from(Blocks.FLOWER_POT).notSolid()));

	// Willow
		public static final RegistryObject<Block> MADRONE_PLANKS = BLOCKS.register("madrone_planks",
				() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

		public static final RegistryObject<Block> MADRONE_LOG = BLOCKS.register("madrone_log",
				() -> new ModLogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));
		
		public static final RegistryObject<Block> MADRONE_WOOD = BLOCKS.register("madrone_wood",
				() -> new ModLogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));
		
		public static final RegistryObject<Block> STRIPPED_MADRONE_LOG = BLOCKS.register("stripped_madrone_log",
				() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));
		
		public static final RegistryObject<Block> STRIPPED_MADRONE_WOOD = BLOCKS.register("stripped_madrone_wood",
				() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));

		public static final RegistryObject<Block> MADRONE_LEAVES = BLOCKS.register("madrone_leaves",
				() -> new MadroneLeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
		
		public static final RegistryObject<Block> DENSE_MADRONE_LEAVES = BLOCKS.register("dense_madrone_leaves",
				() -> new DenseMadroneLeavesBlock(Block.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT)));

		public static final RegistryObject<Block> MADRONE_SAPLING = BLOCKS.register("madrone_sapling",
				() -> new ModSaplingBlock(() -> new MadroneTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

		public static final RegistryObject<Block> MADRONE_STAIRS = BLOCKS.register("madrone_stairs",
				() -> new StairsBlock(() -> BlockInit.MADRONE_PLANKS.get().getDefaultState(),
						Block.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2f, 3.0f)
								.sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

		public static final RegistryObject<Block> MADRONE_FENCE = BLOCKS.register("madrone_fence",
				() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GREEN)
						.hardnessAndResistance(2f, 3.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

		public static final RegistryObject<Block> MADRONE_BUTTON = BLOCKS.register("madrone_button",
				() -> new ModWoodButtonBlock(
						Block.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2f, 3.0f)
								.sound(SoundType.WOOD).doesNotBlockMovement().harvestTool(ToolType.AXE)));

		public static final RegistryObject<Block> MADRONE_PRESSURE_PLATE = BLOCKS.register("madrone_pressure_plate",
				() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING,
						Block.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2f, 3.0f)
								.doesNotBlockMovement().sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

		public static final RegistryObject<Block> MADRONE_SLAB = BLOCKS.register("madrone_slab",
				() -> new SlabBlock(Block.Properties.from(BlockInit.MADRONE_PLANKS.get())));

		public static final RegistryObject<Block> MADRONE_DOOR = BLOCKS.register("madrone_door",
				() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)));

		public static final RegistryObject<Block> MADRONE_TRAPDOOR = BLOCKS.register("madrone_trapdoor",
				() -> new ModTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)));

		public static final RegistryObject<Block> MADRONE_FENCE_GATE = BLOCKS.register("madrone_fence_gate",
				() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));
		
		@SuppressWarnings("deprecation")
		public static final RegistryObject<Block> POTTED_MADRONE_SAPLING = BLOCKS.register("potted_madrone_sapling",
				() -> new FlowerPotBlock(MADRONE_SAPLING.get(), Block.Properties.from(Blocks.FLOWER_POT).notSolid()));
		
	// Bleached
	public static final RegistryObject<Block> BLEACHED_PLANKS = BLOCKS.register("bleached_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> BLEACHED_LOG = BLOCKS.register("bleached_log",
			() -> new ModLogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> STRIPPED_BLEACHED_LOG = BLOCKS.register("stripped_bleached_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> STRIPPED_BLEACHED_WOOD = BLOCKS.register("stripped_bleached_wood",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> BLEACHED_WOOD = BLOCKS.register("bleached_wood",
			() -> new ModLogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> BLEACHED_STAIRS = BLOCKS.register("bleached_stairs",
			() -> new StairsBlock(() -> BlockInit.BLEACHED_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.GREEN).hardnessAndResistance(2f, 3.0f)
							.sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

	public static final RegistryObject<Block> BLEACHED_FENCE = BLOCKS.register("bleached_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.GRAY)
					.hardnessAndResistance(2f, 3.0f).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

	public static final RegistryObject<Block> BLEACHED_BUTTON = BLOCKS.register("bleached_button",
			() -> new ModWoodButtonBlock(
					Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2f, 3.0f)
							.doesNotBlockMovement().sound(SoundType.WOOD).harvestTool(ToolType.AXE)));

	public static final RegistryObject<Block> BLEACHED_PRESSURE_PLATE = BLOCKS.register("bleached_pressure_plate",
			() -> new ModPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.GRAY).hardnessAndResistance(2f, 3.0f)
							.sound(SoundType.WOOD).doesNotBlockMovement().harvestTool(ToolType.AXE)));

	public static final RegistryObject<Block> BLEACHED_SLAB = BLOCKS.register("bleached_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.BLEACHED_PLANKS.get())));

	public static final RegistryObject<Block> BLEACHED_DOOR = BLOCKS.register("bleached_door",
			() -> new ModDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)));

	public static final RegistryObject<Block> BLEACHED_TRAPDOOR = BLOCKS.register("bleached_trapdoor",
			() -> new ModTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)));

	public static final RegistryObject<Block> BLEACHED_FENCE_GATE = BLOCKS.register("bleached_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));

	// Plants
	public static final RegistryObject<Block> LUMBOO = BLOCKS.register("lumboo",
			() -> new LumbooBlock(Block.Properties.from(Blocks.BAMBOO).lightValue(7)));
	
	public static final RegistryObject<Block> LICHEN = BLOCKS.register("lichen",
			() -> new LichenBlock(Block.Properties.from(Blocks.DANDELION)));
	
	public static final RegistryObject<Block> GREEN_GLOWING_MUSHROOM = BLOCKS.register("green_glowing_mushroom",
			() -> new ModMushroomBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM).lightValue(8)));

	public static final RegistryObject<Block> BLUE_GLOWING_MUSHROOM = BLOCKS.register("blue_glowing_mushroom",
			() -> new ModMushroomBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM).lightValue(8)));

	public static final RegistryObject<Block> PINK_GLOWING_MUSHROOM = BLOCKS.register("pink_glowing_mushroom",
			() -> new ModMushroomBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM).lightValue(8)));

	public static final RegistryObject<Block> AMANITA = BLOCKS.register("amanita",
			() -> new AmanitaBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM).lightValue(0)));
	
	public static final RegistryObject<Block> TOADSTOOL = BLOCKS.register("toadstool",
			() -> new ModMushroomBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM).lightValue(0)));
	
	public static final RegistryObject<Block> DESERT_SHAGGY_MANE = BLOCKS.register("desert_shaggy_mane",
			() -> new DesertShaggyManeBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM).lightValue(0)));

	public static final RegistryObject<Block> DEATHCAP = BLOCKS.register("deathcap",
			() -> new DeathcapBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM).lightValue(0)));

	public static final RegistryObject<Block> MOREL = BLOCKS.register("morel",
			() -> new MorelBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM).lightValue(0)));

	public static final RegistryObject<Block> MOLD_BLOCK = BLOCKS.register("mold_block",
			() -> new Block(Block.Properties.from(Blocks.DIRT).hardnessAndResistance(0.15f, 0.1f).sound(SoundType.SLIME)));

	public static final RegistryObject<Block> MILDEW_BLOCK = BLOCKS.register("mildew_block",
			() -> new Block(Block.Properties.from(Blocks.DIRT).hardnessAndResistance(0.15f, 0.1f).sound(SoundType.SLIME)));
	
	public static final RegistryObject<Block> ANT_FUNGUS_BLOCK = BLOCKS.register("ant_fungus_block",
			() -> new Block(Block.Properties.from(Blocks.DIRT).hardnessAndResistance(0.15f, 0.1f).sound(SoundType.SLIME)));
	
	public static final RegistryObject<Block> MILDEW_HYPHAE = BLOCKS.register("mildew_hyphae",
			() -> new Block(Block.Properties.from(Blocks.DIRT).hardnessAndResistance(0.15f, 0.1f).sound(SoundType.SLIME)));

	public static final RegistryObject<Block> FUNGRASS = BLOCKS.register("fungrass",
			() -> new FungrassBlock(Block.Properties.from(Blocks.GRASS)));

	public static final RegistryObject<Block> TALL_FUNGRASS = BLOCKS.register("tall_fungrass",
			() -> new TallFungrassBlock(Block.Properties.from(Blocks.TALL_GRASS)));

	public static final RegistryObject<Block> MOLD_GROWTH = BLOCKS.register("mold_growth",
			() -> new MoldGrowthBlock(Block.Properties.from(Blocks.GRASS)));

	public static final RegistryObject<Block> ROTTING_GRASS = BLOCKS.register("rotting_grass",
			() -> new MoldGrowthBlock(Block.Properties.from(Blocks.GRASS)));

	public static final RegistryObject<Block> GHOST_GRAPE_BUSH = BLOCKS.register("ghost_grape_bush",
			() -> new GhostGrapeBushBlock(Block.Properties.from(Blocks.SWEET_BERRY_BUSH)));

	public static final RegistryObject<Block> LUMGRASS = BLOCKS.register("lumgrass",
			() -> new LumgrassBlock(Block.Properties.from(Blocks.GRASS).lightValue(11)));

	public static final RegistryObject<Block> TALL_LUMGRASS = BLOCKS.register("tall_lumgrass",
			() -> new TallLumgrassBlock(Block.Properties.from(Blocks.TALL_GRASS).lightValue(11)));

	public static final RegistryObject<Block> GREEN_MUSHROOM_BLOCK = BLOCKS.register("green_mushroom_block",
			() -> new GlowshroomBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM_BLOCK).lightValue(8)));

	public static final RegistryObject<Block> BLUE_MUSHROOM_BLOCK = BLOCKS.register("blue_mushroom_block",
			() -> new GlowshroomBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM_BLOCK).lightValue(8)));

	public static final RegistryObject<Block> PINK_MUSHROOM_BLOCK = BLOCKS.register("pink_mushroom_block",
			() -> new GlowshroomBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM_BLOCK).lightValue(8)));

	public static final RegistryObject<Block> HUGE_TOADSTOOL_BLOCK = BLOCKS.register("huge_toadstool_block",
			() -> new HugeMushroomBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM_BLOCK)));

	public static final RegistryObject<Block> HUGE_ENOKI_BLOCK = BLOCKS.register("huge_enoki_block",
			() -> new HugeMushroomBlock(Block.Properties.from(Blocks.BROWN_MUSHROOM_BLOCK)));

	public static final RegistryObject<Block> DRY_REED = BLOCKS.register("dry_reed",
			() -> new DryReedBlock(Block.Properties.from(Blocks.SUGAR_CANE)));
	
	public static final RegistryObject<Block> GLOWING_CORAL = BLOCKS.register("glowing_coral",
			() -> new Block(Block.Properties.from(Blocks.BRAIN_CORAL_BLOCK).lightValue(12)));

	// Ores
	public static final RegistryObject<Block> BIOLUMINESCENT_ORE = BLOCKS.register("bioluminescent_ore",
			() -> new ModOreBlock(Block.Properties.from(Blocks.COAL_ORE).lightValue(12)));
	
	public static final RegistryObject<Block> EXPERIENCE_ORE = BLOCKS.register("experience_ore",
			() -> new ModOreBlock(Block.Properties.from(Blocks.IRON_ORE).lightValue(4)));
	
	public static final RegistryObject<Block> FALSE_EXPERIENCE_ORE = BLOCKS.register("false_experience_ore",
			() -> new FalseExperienceOreBlock(Block.Properties.from(Blocks.IRON_ORE).lightValue(4)));

	public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> ZINC_ORE = BLOCKS.register("zinc_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BAUXITE_ORE = BLOCKS.register("bauxite_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(0)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.8f, 8.0f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 8.0f).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> MANGANESE_ORE = BLOCKS.register("manganese_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.5f, 8.0f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> TITANIUM_ORE = BLOCKS.register("titanium_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(7.0f, 8.0f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> LITHIUM_ORE = BLOCKS.register("lithium_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> BLOOD_QUARTZ_ORE = BLOCKS.register("blood_quartz_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 8.0f).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> TUNGSTEN_ORE = BLOCKS.register("tungsten_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(7.0f, 8.0f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SULPHUR_ORE = BLOCKS.register("sulphur_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> END_MYSTERY_ORE = BLOCKS.register("end_mystery_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.0f, 8.0f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> NETHER_MYSTERY_ORE = BLOCKS.register("nether_mystery_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(4.0f, 8.0f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> MITHRIL_ORE = BLOCKS.register("mithril_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 8.0f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> MOLYBDENUM_ORE = BLOCKS.register("molybdenum_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.8f, 8.0f).harvestLevel(4)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SPORE_QUARTZ_ORE = BLOCKS.register("spore_quartz_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> VOID_QUARTZ_ORE = BLOCKS.register("void_quartz_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> HYPHAE_HEMATITE_ORE = BLOCKS.register("hyphae_hematite_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> HYPHAE_AMBER_ORE = BLOCKS.register("hyphae_amber_ore",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.8f, 8.0f).harvestLevel(2)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> AMBERED_ADOBE = BLOCKS.register("ambered_adobe",
			() -> new ModOreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8f, 8.0f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	
	// Walls
	public static final RegistryObject<Block> HYPHAE_COBBLESTONE_WALL = BLOCKS.register("hyphae_cobblestone_wall", 
				() -> new WallBlock(Block.Properties.from(BlockInit.HYPHAE_COBBLESTONE.get())));
	
	public static final RegistryObject<Block> MOLDY_HYPHAE_COBBLESTONE_WALL = BLOCKS.register("moldy_hyphae_cobblestone_wall", 
			() -> new WallBlock(Block.Properties.from(BlockInit.HYPHAE_COBBLESTONE.get())));
	
	public static final RegistryObject<Block> MOLDY_HYPHAE_BRICK_WALL = BLOCKS.register("moldy_hyphae_brick_wall", 
			() -> new WallBlock(Block.Properties.from(BlockInit.HYPHAE_COBBLESTONE.get())));
	
	public static final RegistryObject<Block> HYPHAE_BRICK_WALL = BLOCKS.register("hyphae_brick_wall", 
			() -> new WallBlock(Block.Properties.from(BlockInit.HYPHAE_COBBLESTONE.get())));
	
	public static final RegistryObject<Block> MAGIC_CHALK_WALL = BLOCKS.register("magic_chalk_wall", 
			() -> new WallBlock(Block.Properties.from(BlockInit.MAGIC_CHALK_BLOCK.get())));
	
	public static final RegistryObject<Block> MAGIC_CHALK_BRICK_WALL = BLOCKS.register("magic_chalk_brick_wall", 
			() -> new WallBlock(Block.Properties.from(BlockInit.MAGIC_CHALK_BLOCK.get())));
	
	public static final RegistryObject<Block> MAGIC_CHALK_PAVER_WALL = BLOCKS.register("magic_chalk_paver_wall", 
			() -> new WallBlock(Block.Properties.from(BlockInit.MAGIC_CHALK_BLOCK.get())));
		
	// Slabs
	public static final RegistryObject<Block> HYPHAE_COBBLESTONE_SLAB = BLOCKS.register("hyphae_cobblestone_slab",
				() -> new SlabBlock(Block.Properties.from(BlockInit.HYPHAE_COBBLESTONE.get())));
	
	public static final RegistryObject<Block> MOLDY_HYPHAE_COBBLESTONE_SLAB = BLOCKS.register("moldy_hyphae_cobblestone_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.HYPHAE_COBBLESTONE.get())));

	public static final RegistryObject<Block> MOLDY_HYPHAE_BRICK_SLAB = BLOCKS.register("moldy_hyphae_brick_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.HYPHAE_COBBLESTONE.get())));
	
	public static final RegistryObject<Block> HYPHAE_BRICK_SLAB = BLOCKS.register("hyphae_brick_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.HYPHAE_COBBLESTONE.get())));
	
	public static final RegistryObject<Block> ADOBE_BRICK_SLAB = BLOCKS.register("adobe_brick_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.ADOBE_BLOCK.get())));
	
	public static final RegistryObject<Block> ADOBE_SLAB = BLOCKS.register("adobe_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.ADOBE_BLOCK.get())));
	
	public static final RegistryObject<Block> MAGIC_CHALK_SLAB = BLOCKS.register("magic_chalk_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.MAGIC_CHALK_BLOCK.get())));
	
	public static final RegistryObject<Block> MAGIC_CHALK_BRICK_SLAB = BLOCKS.register("magic_chalk_brick_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.MAGIC_CHALK_BLOCK.get())));
	
	public static final RegistryObject<Block> MAGIC_CHALK_PAVER_SLAB = BLOCKS.register("magic_chalk_paver_slab",
			() -> new SlabBlock(Block.Properties.from(BlockInit.MAGIC_CHALK_BLOCK.get())));

	// Stairs
	public static final RegistryObject<Block> HYPHAE_COBBLESTONE_STAIRS = BLOCKS.register("hyphae_cobblestone_stairs",
				() -> new StairsBlock(() -> BlockInit.HYPHAE_COBBLESTONE.get().getDefaultState(),
						Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(1.8f, 3.0f)
								.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> MOLDY_HYPHAE_COBBLESTONE_STAIRS = BLOCKS.register("moldy_hyphae_cobblestone_stairs",
			() -> new StairsBlock(() -> BlockInit.MOLDY_HYPHAE_COBBLESTONE.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> MOLDY_HYPHAE_BRICK_STAIRS = BLOCKS.register("moldy_hyphae_brick_stairs",
			() -> new StairsBlock(() -> BlockInit.MOLDY_HYPHAE_BRICKS.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> HYPHAE_BRICK_STAIRS = BLOCKS.register("hyphae_brick_stairs",
			() -> new StairsBlock(() -> BlockInit.HYPHAE_BRICKS.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> ADOBE_BRICK_STAIRS = BLOCKS.register("adobe_brick_stairs",
			() -> new StairsBlock(() -> BlockInit.ADOBE_BRICKS.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> ADOBE_STAIRS = BLOCKS.register("adobe_stairs",
			() -> new StairsBlock(() -> BlockInit.ADOBE_BLOCK.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.PURPLE).hardnessAndResistance(1.8f, 3.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> MAGIC_CHALK_STAIRS = BLOCKS.register("magic_chalk_stairs",
			() -> new StairsBlock(() -> BlockInit.MAGIC_CHALK_BLOCK.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(0.5f, 2.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> MAGIC_CHALK_BRICK_STAIRS = BLOCKS.register("magic_chalk_brick_stairs",
			() -> new StairsBlock(() -> BlockInit.MAGIC_CHALK_BRICKS.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(0.5f, 2.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
	
	public static final RegistryObject<Block> MAGIC_CHALK_PAVER_STAIRS = BLOCKS.register("magic_chalk_paver_stairs",
			() -> new StairsBlock(() -> BlockInit.MAGIC_CHALK_PAVER.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.GRAY).hardnessAndResistance(0.5f, 2.0f)
							.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)));
}
