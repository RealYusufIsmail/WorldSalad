package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.BluecapModel;
import com.radioctivetacoo.worldsalad.entities.Bluecap;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BluecapRender extends MobRenderer<Bluecap, BluecapModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/bluecap.png");

	public BluecapRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BluecapModel(), 0.65f);
	}

	@Override
	public ResourceLocation getEntityTexture(Bluecap entity) {
		return TEXTURE;
	}
}