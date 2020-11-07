package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.RedcapModel;
import com.radioctivetacoo.worldsalad.entities.Redcap;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RedcapRender extends MobRenderer<Redcap, RedcapModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/redcap.png");

	public RedcapRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RedcapModel(), 0.65f);
	}

	@Override
	public ResourceLocation getEntityTexture(Redcap entity) {
		return TEXTURE;
	}
}