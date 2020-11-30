package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.GiantToadModel;
import com.radioctivetacoo.worldsalad.entities.GiantToad;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GiantToadRender extends MobRenderer<GiantToad, GiantToadModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/giant_toad.png");

	public GiantToadRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GiantToadModel(), 1.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(GiantToad entity) {
		return TEXTURE;
	}
}