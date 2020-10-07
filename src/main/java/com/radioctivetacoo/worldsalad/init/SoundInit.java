package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {
	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			WorldSalad.MOD_ID);

	public static final RegistryObject<SoundEvent> ROCK_MONSTER_AMBIENT = SOUNDS.register("entity.rock_monster_ambient",
			() -> new SoundEvent(new ResourceLocation(WorldSalad.MOD_ID, "entity.rock_monster.ambient")));

	public static final RegistryObject<SoundEvent> ROCK_MONSTER_HURT = SOUNDS.register("entity.rock_monster_hurt",
			() -> new SoundEvent(new ResourceLocation(WorldSalad.MOD_ID, "entity.rock_monster.hurt")));

	public static final RegistryObject<SoundEvent> ROCK_MONSTER_DEATH = SOUNDS.register("entity.rock_monster_death",
			() -> new SoundEvent(new ResourceLocation(WorldSalad.MOD_ID, "entity.rock_monster.death")));
	
	public static final RegistryObject<SoundEvent> WRAITH_AMBIENT = SOUNDS.register("entity.wraith_ambient",
			() -> new SoundEvent(new ResourceLocation(WorldSalad.MOD_ID, "entity.wraith.ambient")));

	public static final RegistryObject<SoundEvent> WRAITH_HURT = SOUNDS.register("entity.wraith_hurt",
			() -> new SoundEvent(new ResourceLocation(WorldSalad.MOD_ID, "entity.wraith.hurt")));

	public static final RegistryObject<SoundEvent> WRAITH_DEATH = SOUNDS.register("entity.wraith_death",
			() -> new SoundEvent(new ResourceLocation(WorldSalad.MOD_ID, "entity.wraith.death")));
}
