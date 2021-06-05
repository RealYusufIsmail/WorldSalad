package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.entities.AntQueen;
import com.radioctivetacoo.worldsalad.entities.Bioluminary;
import com.radioctivetacoo.worldsalad.entities.BioluminescentHorror;
import com.radioctivetacoo.worldsalad.entities.Bluecap;
import com.radioctivetacoo.worldsalad.entities.Browncap;
import com.radioctivetacoo.worldsalad.entities.CordycepsAnt;
import com.radioctivetacoo.worldsalad.entities.Dragonfly;
import com.radioctivetacoo.worldsalad.entities.Exoskeleton;
import com.radioctivetacoo.worldsalad.entities.FungalZombie;
import com.radioctivetacoo.worldsalad.entities.GiantToad;
import com.radioctivetacoo.worldsalad.entities.InfectedQueen;
import com.radioctivetacoo.worldsalad.entities.Macrobe;
import com.radioctivetacoo.worldsalad.entities.Moth;
import com.radioctivetacoo.worldsalad.entities.Redcap;
import com.radioctivetacoo.worldsalad.entities.RockMonster;
import com.radioctivetacoo.worldsalad.entities.SoldierAnt;
import com.radioctivetacoo.worldsalad.entities.TraderAnt;
import com.radioctivetacoo.worldsalad.entities.Urchin;
import com.radioctivetacoo.worldsalad.entities.WorkerAnt;
import com.radioctivetacoo.worldsalad.entities.Wraith;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntitySpawnPlacementRegistry.IPlacementPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
			WorldSalad.MOD_ID);

	public static void registerEntityWorldSpawns(EntityType<?> entity, int weight, int minGroupCountIn,
			int maxGroupCountIn, EntityClassification classification, Biome... biomes) {
		for (Biome biome : biomes) {
			if (biome != null) {
				biome.getSpawns(classification)
						.add(new SpawnListEntry(entity, weight, minGroupCountIn, maxGroupCountIn));
			}
		}
	}

	public static void registerEntityWorldSpawn() {
		
		//hostile mobs
		registerEntityWorldSpawns(ROCK_MONSTER.get(), 80, 1, 3, EntityClassification.MONSTER,
				BiomeInit.CRAG_BIOME.get(), Biomes.MOUNTAINS, Biomes.GRAVELLY_MOUNTAINS, Biomes.MOUNTAIN_EDGE, Biomes.MODIFIED_GRAVELLY_MOUNTAINS, Biomes.SNOWY_MOUNTAINS);
		
		registerEntityWorldSpawns(MOTH.get(), 175, 1, 3, EntityClassification.MONSTER,
				BiomeInit.GLOWING_MUSHROOM_BIOME.get());
		
		registerEntityWorldSpawns(BIOLUMINARY.get(), 110, 1, 3, EntityClassification.MONSTER,
				BiomeInit.GLOWING_MUSHROOM_BIOME.get());
		
		registerEntityWorldSpawns(BLUECAP.get(), 50, 1, 3, EntityClassification.MONSTER,
				BiomeInit.GLOWING_MUSHROOM_BIOME.get());
		
		registerEntityWorldSpawns(EXOSKELETON.get(), 150, 1, 3, EntityClassification.MONSTER,
				BiomeInit.MOLD_TUNDRA_BIOME.get(), BiomeInit.MILDEW_FOREST_BIOME.get(), BiomeInit.MUSHROOM_CANYON_FLATS_BIOME.get(), BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get());
		
		registerEntityWorldSpawns(WRAITH.get(), 125, 1, 1, EntityClassification.MONSTER,
				BiomeInit.MOLD_TUNDRA_BIOME.get(), BiomeInit.MILDEW_FOREST_BIOME.get());
		
		registerEntityWorldSpawns(WRAITH.get(), 1, 0, 1, EntityClassification.MONSTER,
				Biomes.END_BARRENS, Biomes.END_HIGHLANDS, Biomes.END_MIDLANDS, Biomes.SMALL_END_ISLANDS);
		
		registerEntityWorldSpawns(MACROBE.get(), 4, 1, 1, EntityClassification.MONSTER,
				BiomeInit.MOLD_TUNDRA_BIOME.get(), BiomeInit.MILDEW_FOREST_BIOME.get(), BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get(), BiomeInit.GLOWING_MUSHROOM_BIOME.get(), 
				BiomeInit.MUSHROOM_CANYON_FLATS_BIOME.get(), BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get(),
				BiomeInit.MUSHROOM_FOREST_BIOME.get());
		
		registerEntityWorldSpawns(CORDYCEPS_ANT.get(), 100, 1, 3, EntityClassification.MONSTER,
				BiomeInit.MOLD_TUNDRA_BIOME.get(), BiomeInit.MILDEW_FOREST_BIOME.get());
		
		registerEntityWorldSpawns(FUNGAL_ZOMBIE.get(), 200, 1, 4, EntityClassification.MONSTER,
				BiomeInit.MOLD_TUNDRA_BIOME.get(), BiomeInit.MILDEW_FOREST_BIOME.get(), 
				BiomeInit.MUSHROOM_CANYON_FLATS_BIOME.get(), BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get(), 
				BiomeInit.ACID_OCEAN_BIOME.get(), BiomeInit.GLOWING_MUSHROOM_BIOME.get(), 
				BiomeInit.MUSHROOM_FOREST_BIOME.get(), BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get());
		
		registerEntityWorldSpawns(GIANT_TOAD.get(), 200, 1, 4, EntityClassification.MONSTER,
				BiomeInit.MOLD_TUNDRA_BIOME.get(), BiomeInit.MILDEW_FOREST_BIOME.get(), 
				BiomeInit.ACID_OCEAN_BIOME.get(), BiomeInit.GLOWING_MUSHROOM_BIOME.get(), 
				BiomeInit.MUSHROOM_FOREST_BIOME.get(), BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get());
		
		registerEntityWorldSpawns(REDCAP.get(), 25, 2, 6, EntityClassification.MONSTER,
				BiomeInit.MUSHROOM_FOREST_BIOME.get(), BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get());
		
		registerEntityWorldSpawns(BROWNCAP.get(), 15, 2, 6, EntityClassification.MONSTER,
				BiomeInit.MUSHROOM_FOREST_BIOME.get(), BiomeInit.DENSE_MUSHROOM_FOREST_BIOME.get());
		
		//neutral
		registerEntityWorldSpawns(WORKER_ANT.get(), 100, 2, 3, EntityClassification.CREATURE,
				BiomeInit.MUSHROOM_CANYON_FLATS_BIOME.get(), BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get());
		
		registerEntityWorldSpawns(URCHIN.get(), 150, 3, 4, EntityClassification.MONSTER,
				Biomes.BEACH, Biomes.DEEP_COLD_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN, 
				Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.FROZEN_OCEAN, Biomes.WARM_OCEAN);
	
		//passive
		registerEntityWorldSpawns(DRAGONFLY.get(), 70, 2, 3, EntityClassification.CREATURE,
				BiomeInit.MUSHROOM_CANYON_FLATS_BIOME.get(), BiomeInit.MUSHROOM_CANYON_SHATTERED_BIOME.get());
		}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void registerPlacementTypes(EntityType type, Heightmap.Type heightMap, EntitySpawnPlacementRegistry.PlacementType spawnType, IPlacementPredicate placementType)
	{
		EntitySpawnPlacementRegistry.register(type, spawnType, heightMap, placementType);
	}
	
	public static void registerPlacementType()
	{
		//hostile mobs
		registerPlacementTypes(ROCK_MONSTER.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawnInLight);
		registerPlacementTypes(WRAITH.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawnInLight);
		registerPlacementTypes(BIOLUMINARY.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawn);
		registerPlacementTypes(MOTH.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawn);
		registerPlacementTypes(EXOSKELETON.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawnInLight);
		registerPlacementTypes(CORDYCEPS_ANT.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawn);
		registerPlacementTypes(FUNGAL_ZOMBIE.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, ZombieEntity::canMonsterSpawnInLight);
		registerPlacementTypes(MACROBE.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawn);
		registerPlacementTypes(GIANT_TOAD.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MobEntity::canSpawnOn);
		//neutral
		registerPlacementTypes(WORKER_ANT.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MobEntity::canSpawnOn);
		registerPlacementTypes(REDCAP.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawn);
		registerPlacementTypes(BLUECAP.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawn);
		registerPlacementTypes(BROWNCAP.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MonsterEntity::canMonsterSpawn);
		registerPlacementTypes(URCHIN.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.IN_WATER, Urchin::func_223332_b);
		//passive
		registerPlacementTypes(DRAGONFLY.get(), Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, MobEntity::canSpawnOn);
	}

	// hostile mobs
	public static final RegistryObject<EntityType<RockMonster>> ROCK_MONSTER = ENTITY_TYPES.register("rock_monster",
			() -> EntityType.Builder.<RockMonster>create(RockMonster::new, EntityClassification.MONSTER)
					.size(0.8f, 1.0f).build(new ResourceLocation(WorldSalad.MOD_ID, "rock_monster").toString()));

	public static final RegistryObject<EntityType<Moth>> MOTH = ENTITY_TYPES.register("moth",
			() -> EntityType.Builder.<Moth>create(Moth::new, EntityClassification.MONSTER).size(0.6f, 0.3f)
					.build(new ResourceLocation(WorldSalad.MOD_ID, "moth").toString()));
	
	public static final RegistryObject<EntityType<Exoskeleton>> EXOSKELETON = ENTITY_TYPES.register("exoskeleton",
			() -> EntityType.Builder.<Exoskeleton>create(Exoskeleton::new, EntityClassification.MONSTER)
					.size(0.7f, 0.5f).build(new ResourceLocation(WorldSalad.MOD_ID, "exoskeleton").toString()));
	 
	public static final RegistryObject<EntityType<Wraith>> WRAITH = ENTITY_TYPES.register("wraith",
			() -> EntityType.Builder.<Wraith>create(Wraith::new, EntityClassification.MONSTER)
					.size(0.7f, 1.7f).build(new ResourceLocation(WorldSalad.MOD_ID, "wraith").toString()));
	
	public static final RegistryObject<EntityType<FungalZombie>> FUNGAL_ZOMBIE = ENTITY_TYPES.register("fungal_zombie",
			() -> EntityType.Builder.<FungalZombie>create(FungalZombie::new, EntityClassification.MONSTER)
					.size(0.6f, 1.95f).build(new ResourceLocation(WorldSalad.MOD_ID, "fungal_zombie").toString()));
	
	public static final RegistryObject<EntityType<CordycepsAnt>> CORDYCEPS_ANT = ENTITY_TYPES.register("cordyceps_ant",
			() -> EntityType.Builder.<CordycepsAnt>create(CordycepsAnt::new, EntityClassification.MONSTER)
					.size(0.85f, 0.6f).build(new ResourceLocation(WorldSalad.MOD_ID, "cordyceps_ant").toString()));
	
	public static final RegistryObject<EntityType<GiantToad>> GIANT_TOAD = ENTITY_TYPES.register("giant_toad",
			() -> EntityType.Builder.<GiantToad>create(GiantToad::new, EntityClassification.MONSTER)
					.size(1.1f, 0.9f).build(new ResourceLocation(WorldSalad.MOD_ID, "giant_toad").toString()));
	
	public static final RegistryObject<EntityType<Bioluminary>> BIOLUMINARY = ENTITY_TYPES.register("bioluminary",
			() -> EntityType.Builder.<Bioluminary>create(Bioluminary::new, EntityClassification.MONSTER)
					.size(0.4f, 2.7f).build(new ResourceLocation(WorldSalad.MOD_ID, "bioluminary").toString()));

	// neutral mobs
	public static final RegistryObject<EntityType<Urchin>> URCHIN = ENTITY_TYPES.register("urchin",
			() -> EntityType.Builder.<Urchin>create(Urchin::new, EntityClassification.MONSTER).size(0.5f, 0.6f)
					.build(new ResourceLocation(WorldSalad.MOD_ID, "urchin").toString()));
	
	public static final RegistryObject<EntityType<SoldierAnt>> SOLDIER_ANT = ENTITY_TYPES.register("soldier_ant",
			() -> EntityType.Builder.<SoldierAnt>create(SoldierAnt::new, EntityClassification.CREATURE)
					.size(0.85f, 0.6f).build(new ResourceLocation(WorldSalad.MOD_ID, "soldier_ant").toString()));
	
	public static final RegistryObject<EntityType<WorkerAnt>> WORKER_ANT = ENTITY_TYPES.register("worker_ant",
			() -> EntityType.Builder.<WorkerAnt>create(WorkerAnt::new, EntityClassification.CREATURE)
					.size(0.7f, 0.5f).build(new ResourceLocation(WorldSalad.MOD_ID, "worker_ant").toString()));
	
	public static final RegistryObject<EntityType<Redcap>> REDCAP = ENTITY_TYPES.register("redcap",
			() -> EntityType.Builder.<Redcap>create(Redcap::new, EntityClassification.CREATURE)
					.size(0.8f, 1.2f).build(new ResourceLocation(WorldSalad.MOD_ID, "redcap").toString()));
	
	public static final RegistryObject<EntityType<Browncap>> BROWNCAP = ENTITY_TYPES.register("browncap",
			() -> EntityType.Builder.<Browncap>create(Browncap::new, EntityClassification.CREATURE)
					.size(0.8f, 1.2f).build(new ResourceLocation(WorldSalad.MOD_ID, "browncap").toString()));
	
	public static final RegistryObject<EntityType<Bluecap>> BLUECAP = ENTITY_TYPES.register("bluecap",
			() -> EntityType.Builder.<Bluecap>create(Bluecap::new, EntityClassification.CREATURE)
					.size(0.8f, 1.2f).build(new ResourceLocation(WorldSalad.MOD_ID, "bluecap").toString()));
	
	public static final RegistryObject<EntityType<AntQueen>> ANT_QUEEN = ENTITY_TYPES.register("ant_queen",
			() -> EntityType.Builder.<AntQueen>create(AntQueen::new, EntityClassification.CREATURE)
					.size(1.3f, 1.1f).build(new ResourceLocation(WorldSalad.MOD_ID, "ant_queen").toString()));
	
	// passive mobs
	public static final RegistryObject<EntityType<TraderAnt>> TRADER_ANT = ENTITY_TYPES.register("trader_ant",
			() -> EntityType.Builder.<TraderAnt>create(TraderAnt::new, EntityClassification.MONSTER)
					.size(0.7f, 0.5f).build(new ResourceLocation(WorldSalad.MOD_ID, "trader_ant").toString()));
	
	public static final RegistryObject<EntityType<Dragonfly>> DRAGONFLY = ENTITY_TYPES.register("dragonfly",
			() -> EntityType.Builder.<Dragonfly>create(Dragonfly::new, EntityClassification.CREATURE)
					.size(1.4f, 0.7f).build(new ResourceLocation(WorldSalad.MOD_ID, "dragonfly").toString()));
	
	// bosses
	public static final RegistryObject<EntityType<BioluminescentHorror>> BIOLUMINESCENT_HORROR = ENTITY_TYPES.register("bioluminescent_horror",
			() -> EntityType.Builder.<BioluminescentHorror>create(BioluminescentHorror::new, EntityClassification.MONSTER)
					.size(4f, 1.6f).build(new ResourceLocation(WorldSalad.MOD_ID, "bioluminescent_horror").toString()));
	
	public static final RegistryObject<EntityType<Macrobe>> MACROBE = ENTITY_TYPES.register("macrobe",
			() -> EntityType.Builder.<Macrobe>create(Macrobe::new, EntityClassification.MONSTER)
					.size(1.3f, 3.8f).build(new ResourceLocation(WorldSalad.MOD_ID, "macrobe").toString()));
	
	public static final RegistryObject<EntityType<InfectedQueen>> INFECTED_QUEEN = ENTITY_TYPES.register("infected_queen",
			() -> EntityType.Builder.<InfectedQueen>create(InfectedQueen::new, EntityClassification.MONSTER)
					.size(1.3f, 1.1f).build(new ResourceLocation(WorldSalad.MOD_ID, "infected_queen").toString()));
}
