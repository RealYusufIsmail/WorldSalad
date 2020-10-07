package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.TraderAntModel;
import com.radioctivetacoo.worldsalad.entities.TraderAnt;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class TraderAntRender extends MobRenderer<TraderAnt, TraderAntModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/trader_ant.png");

	public TraderAntRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new TraderAntModel(), 0.4f);
	}

	@Override
	public ResourceLocation getEntityTexture(TraderAnt entity) {
		return TEXTURE;
	}
}