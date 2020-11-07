package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.SoldierAntModel;
import com.radioctivetacoo.worldsalad.entities.SoldierAnt;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SoldierAntRender extends MobRenderer<SoldierAnt, SoldierAntModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/soldier_ant.png");

	public SoldierAntRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SoldierAntModel(), 0.65f);
	}

	@Override
	public ResourceLocation getEntityTexture(SoldierAnt entity) {
		return TEXTURE;
	}
}