package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.UrchinModel;
import com.radioctivetacoo.worldsalad.entities.Urchin;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class UrchinRender extends MobRenderer<Urchin, UrchinModel<Urchin>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/urchin.png");

	public UrchinRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new UrchinModel<Urchin>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(Urchin entity) {
		return TEXTURE;
	}
}