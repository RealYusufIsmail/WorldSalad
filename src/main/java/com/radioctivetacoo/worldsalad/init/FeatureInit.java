package com.radioctivetacoo.worldsalad.init;

import java.util.Locale;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.world.feature.LumbooFeature;
import com.radioctivetacoo.worldsalad.world.feature.structures.AncientHyphaeShrinePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.AncientHyphaeShrineStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.AntHivePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.AntHiveStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.EmptyShroomHousePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.EmptyShroomHouseStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.ExoskeletonMushRoomPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.ExoskeletonMushRoomStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.GiantMildewPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.GiantMildewStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.NetherShrinePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.NetherShrineStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.ShroomHousePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.ShroomHouseStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.WraithMushRoomPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.WraithMushRoomStructure;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Bus.MOD, modid = WorldSalad.MOD_ID)
public class FeatureInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(
			ForgeRegistries.FEATURES, WorldSalad.MOD_ID);
	
	@SubscribeEvent
	public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event)
	{
		Registry.register(Registry.STRUCTURE_PIECE, "ANCIENT_HYPHAE_SHRINE".toLowerCase(Locale.ROOT), SHRINE_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "SHROOMHOUSE".toLowerCase(Locale.ROOT), SHROOMHOUSE_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "EMPTY_SHROOMHOUSE".toLowerCase(Locale.ROOT), EMPTY_SHROOMHOUSE_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "WRAITH_MUSH_ROOM".toLowerCase(Locale.ROOT), WRAITH_MUSH_ROOM_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "EXOSKELETON_MUSH_ROOM".toLowerCase(Locale.ROOT), EXOSKELETON_MUSH_ROOM_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "GIANT_MILDEW".toLowerCase(Locale.ROOT), GIANT_MILDEW_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MUSHROCK".toLowerCase(Locale.ROOT), MUSHROCK_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "NETHER_SHRINE".toLowerCase(Locale.ROOT), NETHER_SHRINE_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "ANT_HIVE".toLowerCase(Locale.ROOT), ANT_HIVE_PIECE);
	}
	
	public static IStructurePieceType SHRINE_PIECE = AncientHyphaeShrinePieces.Piece::new;
	public static IStructurePieceType SHROOMHOUSE_PIECE = ShroomHousePieces.Piece::new;
	public static IStructurePieceType EMPTY_SHROOMHOUSE_PIECE = EmptyShroomHousePieces.Piece::new;
	public static IStructurePieceType WRAITH_MUSH_ROOM_PIECE = WraithMushRoomPieces.Piece::new;
	public static IStructurePieceType EXOSKELETON_MUSH_ROOM_PIECE = ExoskeletonMushRoomPieces.Piece::new;
	public static IStructurePieceType GIANT_MILDEW_PIECE = GiantMildewPieces.Piece::new;
	public static IStructurePieceType MUSHROCK_PIECE = MushrockPieces.Piece::new;
	public static IStructurePieceType NETHER_SHRINE_PIECE = NetherShrinePieces.Piece::new;
	public static IStructurePieceType ANT_HIVE_PIECE = AntHivePieces.Piece::new;

	//structures
	public static final RegistryObject<AncientHyphaeShrineStructure> ANCIENT_HYPHAE_SHRINE = FEATURES.register("ancient_hyphae_shrine", 
			() -> new AncientHyphaeShrineStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<ShroomHouseStructure> SHROOMHOUSE = FEATURES.register("shroomhouse", 
			() -> new ShroomHouseStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<EmptyShroomHouseStructure> EMPTY_SHROOMHOUSE = FEATURES.register("empty_shroomhouse", 
			() -> new EmptyShroomHouseStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<WraithMushRoomStructure> WRAITH_MUSH_ROOM = FEATURES.register("wraith_mush_room", 
			() -> new WraithMushRoomStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<ExoskeletonMushRoomStructure> EXOSKELETON_MUSH_ROOM = FEATURES.register("exoskeleton_mush_room", 
			() -> new ExoskeletonMushRoomStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<MushrockStructure> MUSHROCK = FEATURES.register("mushrock", 
			() -> new MushrockStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<GiantMildewStructure> GIANT_MILDEW = FEATURES.register("giant_mildew", 
			() -> new GiantMildewStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<NetherShrineStructure> NETHER_SHRINE = FEATURES.register("nether_shrine", 
			() -> new NetherShrineStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<AntHiveStructure> ANT_HIVE = FEATURES.register("ant_hive", 
			() -> new AntHiveStructure(NoFeatureConfig::deserialize));
	
	//vegetation
	public static final RegistryObject<LumbooFeature> LUMBOO = FEATURES.register("lumboo", 
			() -> new LumbooFeature(ProbabilityConfig::deserialize));
}
