package com.radioctivetacoo.worldsalad.objects.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class BlightEffect extends Effect {
	public BlightEffect(EffectType type, int liquidColorIn) {
	      super(type, liquidColorIn);
	   }

	   public void removeAttributesModifiersFromEntity(LivingEntity entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier) {
	      super.removeAttributesModifiersFromEntity(entityLivingBaseIn, attributeMapIn, amplifier);
	      if (entityLivingBaseIn.getHealth() != entityLivingBaseIn.getMaxHealth()) {
	         entityLivingBaseIn.setHealth(entityLivingBaseIn.getMaxHealth());
	      }

	   }
}
