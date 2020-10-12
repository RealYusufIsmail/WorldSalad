package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.WorkerAntModel;
import com.radioctivetacoo.worldsalad.entities.WorkerAnt;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class WorkerAntRender extends MobRenderer<WorkerAnt, WorkerAntModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/worker_ant.png");

	public WorkerAntRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new WorkerAntModel(), 0.4f);
	}

	@Override
	public ResourceLocation getEntityTexture(WorkerAnt entity) {
		return TEXTURE;
	}
}