package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.BrowncapModel;
import com.radioctivetacoo.worldsalad.entities.Browncap;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BrowncapRender extends MobRenderer<Browncap, BrowncapModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/browncap.png");

	public BrowncapRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BrowncapModel(), 0.65f);
	}

	@Override
	public ResourceLocation getEntityTexture(Browncap entity) {
		return TEXTURE;
	}
}