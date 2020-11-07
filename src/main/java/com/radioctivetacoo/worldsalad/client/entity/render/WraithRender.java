package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.WraithModel;
import com.radioctivetacoo.worldsalad.entities.Wraith;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WraithRender extends MobRenderer<Wraith, WraithModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/wraith.png");

	public WraithRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new WraithModel(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(Wraith entity) {
		return TEXTURE;
	}
}