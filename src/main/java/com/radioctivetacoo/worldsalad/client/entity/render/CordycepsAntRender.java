package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.CordycepsAntModel;
import com.radioctivetacoo.worldsalad.entities.CordycepsAnt;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CordycepsAntRender extends MobRenderer<CordycepsAnt, CordycepsAntModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/cordyceps_ant.png");

	public CordycepsAntRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CordycepsAntModel(), 0.65f);
	}

	@Override
	public ResourceLocation getEntityTexture(CordycepsAnt entity) {
		return TEXTURE;
	}
}