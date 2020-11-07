package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.MacrobeModel;
import com.radioctivetacoo.worldsalad.entities.Macrobe;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MacrobeRender extends MobRenderer<Macrobe, MacrobeModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/macrobe.png");

	public MacrobeRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MacrobeModel(), 1.2f);
	}

	@Override
	public ResourceLocation getEntityTexture(Macrobe entity) {
		return TEXTURE;
	}
}