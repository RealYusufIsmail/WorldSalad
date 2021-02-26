package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WorldSalad.MOD_ID)
public class ModLoot {
	private ModLoot() {}

	@SuppressWarnings("unused")
	@SubscribeEvent
	public static void generateLoot(LootTableLoadEvent event) {
		String prefixChestLoot = "minecraft:chests/";
		String prefixMobLoot = "minecraft:entities/";
		String name = event.getName().toString();
		String file = name.substring("minecraft:".length());
		
		event.getTable().addPool(getInjectPool(file));
	}

	private static LootPool getInjectPool(String entryName) {
		return LootPool.builder().addEntry(getInjectEntry(entryName)).name("worldsalad_inject_pool").bonusRolls(0, 1).build();
	}
	
	private static LootEntry.Builder<?> getInjectEntry(String poolName) {
		return TableLootEntry.builder(new ResourceLocation(WorldSalad.MOD_ID, "inject/" + poolName)).weight(1);
	}
}