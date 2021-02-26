package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.entities.FungalZombie;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FungalZombieModel extends AnimatedGeoModel<FungalZombie>
{
	@Override
	public ResourceLocation getAnimationFileLocation(FungalZombie animatable)
	{
		return new ResourceLocation(WorldSalad.MOD_ID, "animations/fungal_zombie.json");
	}

	@Override
	public ResourceLocation getModelLocation(FungalZombie object)
	{
		if (object.isChild()) {
			return new ResourceLocation(WorldSalad.MOD_ID, "geo/fungal_zombie_baby.geo.json");
		}
		else {
			return new ResourceLocation(WorldSalad.MOD_ID, "geo/fungal_zombie.geo.json");
		}
	}

	@Override
	public ResourceLocation getTextureLocation(FungalZombie object) {
		if (object.isChild())
		{
			return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/fungal_zombie_baby.png");
		}
		else
		{
			return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/fungal_zombie.png");
		}
	}
}