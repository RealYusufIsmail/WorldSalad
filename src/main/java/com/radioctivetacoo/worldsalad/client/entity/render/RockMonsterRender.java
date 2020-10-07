package com.radioctivetacoo.worldsalad.client.entity.render;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.RockMonsterModel;
import com.radioctivetacoo.worldsalad.entities.RockMonster;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RockMonsterRender extends MobRenderer<RockMonster, RockMonsterModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/rock_monster.png");

	public RockMonsterRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RockMonsterModel(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(RockMonster entity) {
		return TEXTURE;
	}
}