package com.radioctivetacoo.worldsalad.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.FungalZombieBabyModel;
import com.radioctivetacoo.worldsalad.client.entity.model.FungalZombieModel;
import com.radioctivetacoo.worldsalad.entities.FungalZombie;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

public class FungalZombieRender extends MobRenderer<FungalZombie, EntityModel<FungalZombie>> {
	
	 private static final FungalZombieModel MODEL = new FungalZombieModel();
	 private static final FungalZombieBabyModel CHILD_MODEL = new FungalZombieBabyModel();

	protected static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/fungal_zombie.png");
	protected static final ResourceLocation BABY_TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/entity/fungal_zombie_baby.png");

	public FungalZombieRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new FungalZombieModel(), 0.65f);
	}
	
	public void render(FungalZombie entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        if (entity.isChild()) {
            entityModel = CHILD_MODEL;
        } else {
            entityModel = MODEL;
        }
        super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
	

	@Override
	public ResourceLocation getEntityTexture(FungalZombie entity) {
		if (entity.isChild()) {
            return BABY_TEXTURE;
        } else {
            return TEXTURE;
        }
	}
	
	public boolean isAggressive(FungalZombie entityIn) {
	      return entityIn.isAggressive();
	   }
}