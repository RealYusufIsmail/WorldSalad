package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.WorldSalad;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

@SuppressWarnings("rawtypes")
public class WraithModel extends AnimatedGeoModel
{
	@Override
	public ResourceLocation getAnimationFileLocation(Object entity)
	{
		return new ResourceLocation(WorldSalad.MOD_ID, "animations/wraith.json");
	}

	@Override
	public ResourceLocation getModelLocation(Object entity)
	{
		return new ResourceLocation(WorldSalad.MOD_ID, "geo/wraith.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(Object entity)
	{
		return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/wraith.png");
	}
}