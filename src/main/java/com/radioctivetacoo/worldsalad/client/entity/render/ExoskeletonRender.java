package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.ExoskeletonModel;
import com.radioctivetacoo.worldsalad.entities.Exoskeleton;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ExoskeletonRender extends MobRenderer<Exoskeleton, ExoskeletonModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/exoskeleton.png");

	public ExoskeletonRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ExoskeletonModel(), 0.4f);
	}

	@Override
	public ResourceLocation getEntityTexture(Exoskeleton entity) {
		return TEXTURE;
	}
}