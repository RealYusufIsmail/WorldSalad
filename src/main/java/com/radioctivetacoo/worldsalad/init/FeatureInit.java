package com.radioctivetacoo.worldsalad.init;

import java.util.Locale;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.world.feature.structures.AncientHyphaeShrinePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.AncientHyphaeShrineStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.EmptyShroomHousePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.EmptyShroomHouseStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.ExoskeletonMushRoomPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.ExoskeletonMushRoomStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockFivePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockFiveStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockFourPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockFourStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockOnePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockOneStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockSevenPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockSevenStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockSixPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockSixStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockThreePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockThreeStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockTwoPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.MushrockTwoStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.ShroomHousePieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.ShroomHouseStructure;
import com.radioctivetacoo.worldsalad.world.feature.structures.WraithMushRoomPieces;
import com.radioctivetacoo.worldsalad.world.feature.structures.WraithMushRoomStructure;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
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
	public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<Feature<?>>(
			ForgeRegistries.FEATURES, WorldSalad.MOD_ID);
	
	public static IStructurePieceType SHRINE_PIECE = AncientHyphaeShrinePieces.Piece::new;
	public static IStructurePieceType SHROOMHOUSE_PIECE = ShroomHousePieces.Piece::new;
	public static IStructurePieceType EMPTY_SHROOMHOUSE_PIECE = EmptyShroomHousePieces.Piece::new;
	public static IStructurePieceType WRAITH_MUSH_ROOM_PIECE = WraithMushRoomPieces.Piece::new;
	public static IStructurePieceType EXOSKELETON_MUSH_ROOM_PIECE = ExoskeletonMushRoomPieces.Piece::new;
	public static IStructurePieceType MUSHROCK1_PIECE = MushrockOnePieces.Piece::new;
	public static IStructurePieceType MUSHROCK2_PIECE = MushrockTwoPieces.Piece::new;
	public static IStructurePieceType MUSHROCK3_PIECE = MushrockThreePieces.Piece::new;
	public static IStructurePieceType MUSHROCK4_PIECE = MushrockFourPieces.Piece::new;
	public static IStructurePieceType MUSHROCK5_PIECE = MushrockFivePieces.Piece::new;
	public static IStructurePieceType MUSHROCK6_PIECE = MushrockSixPieces.Piece::new;
	public static IStructurePieceType MUSHROCK7_PIECE = MushrockSevenPieces.Piece::new;

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
	
	public static final RegistryObject<MushrockOneStructure> MUSHROCK1 = FEATURES.register("mushrock1", 
			() -> new MushrockOneStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<MushrockTwoStructure> MUSHROCK2 = FEATURES.register("mushrock2", 
			() -> new MushrockTwoStructure(NoFeatureConfig::deserialize));

	public static final RegistryObject<MushrockThreeStructure> MUSHROCK3 = FEATURES.register("mushrock3", 
			() -> new MushrockThreeStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<MushrockFourStructure> MUSHROCK4 = FEATURES.register("mushrock4", 
			() -> new MushrockFourStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<MushrockFiveStructure> MUSHROCK5 = FEATURES.register("mushrock5", 
			() -> new MushrockFiveStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<MushrockSixStructure> MUSHROCK6 = FEATURES.register("mushrock6", 
			() -> new MushrockSixStructure(NoFeatureConfig::deserialize));
	
	public static final RegistryObject<MushrockSevenStructure> MUSHROCK7 = FEATURES.register("mushrock7", 
			() -> new MushrockSevenStructure(NoFeatureConfig::deserialize));
	
	@SubscribeEvent
	public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event)
	{
		Registry.register(Registry.STRUCTURE_PIECE, "ANCIENT_HYPHAE_SHRINE".toLowerCase(Locale.ROOT), SHRINE_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "SHROOMHOUSE".toLowerCase(Locale.ROOT), SHROOMHOUSE_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "EMPTY_SHROOMHOUSE".toLowerCase(Locale.ROOT), EMPTY_SHROOMHOUSE_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "WRAITH_MUSH_ROOM".toLowerCase(Locale.ROOT), WRAITH_MUSH_ROOM_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "EXOSKELETON_MUSH_ROOM".toLowerCase(Locale.ROOT), EXOSKELETON_MUSH_ROOM_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MUSHROCK1".toLowerCase(Locale.ROOT), MUSHROCK1_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MUSHROCK2".toLowerCase(Locale.ROOT), MUSHROCK2_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MUSHROCK3".toLowerCase(Locale.ROOT), MUSHROCK3_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MUSHROCK4".toLowerCase(Locale.ROOT), MUSHROCK4_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MUSHROCK5".toLowerCase(Locale.ROOT), MUSHROCK5_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MUSHROCK6".toLowerCase(Locale.ROOT), MUSHROCK6_PIECE);
		Registry.register(Registry.STRUCTURE_PIECE, "MUSHROCK7".toLowerCase(Locale.ROOT), MUSHROCK7_PIECE);
	}
}
