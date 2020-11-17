package com.radioctivetacoo.worldsalad.objects.effects;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.radioctivetacoo.worldsalad.init.EffectInit;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class ModPotionEffect extends Effect {

	private final Map<IAttribute, AttributeModifier> attributeModifierMap = Maps.newHashMap();
	   private final EffectType type;
	   private final int liquidColor;
	   @Nullable
	   private String name;
	   
	public ModPotionEffect(EffectType typeIn, int liquidColorIn) {
		super(typeIn, liquidColorIn);
		this.type = typeIn;
	    this.liquidColor = liquidColorIn;
	}
	
	@SuppressWarnings("deprecation")
	protected String getOrCreateDescriptionId() {
	      if (this.name == null) {
	         this.name = Util.makeTranslationKey("effect", Registry.EFFECTS.getKey(this));
	      }

	      return this.name;
	   }

	public boolean isReady(int duration, int amplifier) {
		if (this == EffectInit.ACID.get()) {
	         int i = 40 >> amplifier;
	         if (i > 0) {
	            return duration % i == 0;
	         } else {
	            return true;
	         }
		} else {
       	 return false;
        }
	}
	
	public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
	      if (this == EffectInit.ACID.get()) {
	         entityLivingBaseIn.attackEntityFrom(DamageSource.IN_FIRE, 4.0F);
	      }
	   }
}
