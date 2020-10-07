package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.MothModel;
import com.radioctivetacoo.worldsalad.entities.Moth;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MothRender extends MobRenderer<Moth, MothModel<Moth>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/moth.png");

	public MothRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MothModel<Moth>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(Moth entity) {
		return TEXTURE;
	}

}