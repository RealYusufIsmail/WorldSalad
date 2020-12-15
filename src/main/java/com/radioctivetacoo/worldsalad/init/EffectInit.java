package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.objects.effects.BlightEffect;
import com.radioctivetacoo.worldsalad.objects.effects.ModPotionEffect;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectInit {
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Effect> EFFECTS = new DeferredRegister<>(ForgeRegistries.POTIONS, WorldSalad.MOD_ID);
	
	public static final RegistryObject<Effect> ACID = EFFECTS.register("acid", 
			() -> new ModPotionEffect(EffectType.HARMFUL, 0x42f584));
	
	public static final RegistryObject<Effect> BLIGHT = EFFECTS.register("blight", 
			() -> new BlightEffect(EffectType.HARMFUL, 0x42f584).addAttributesModifier(SharedMonsterAttributes.MAX_HEALTH, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", -4.0D, AttributeModifier.Operation.ADDITION));
}
