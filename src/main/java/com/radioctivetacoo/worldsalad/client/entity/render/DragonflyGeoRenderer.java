package com.radioctivetacoo.worldsalad.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.client.entity.model.DragonflyModel;
import com.radioctivetacoo.worldsalad.entities.Dragonfly;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DragonflyGeoRenderer extends GeoEntityRenderer<Dragonfly>
{
	@SuppressWarnings("unchecked")
	public DragonflyGeoRenderer(EntityRendererManager renderManager)
	{
		super(renderManager, new DragonflyModel());
	}

	@Override
	public RenderType getRenderType(Dragonfly animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
	{
		return RenderType.getEntityCutout(getTextureLocation(animatable));

	}

	@Override
	public ResourceLocation getTextureLocation(Dragonfly entity) {
		if (entity.getVariant() == 0) {
			if (entity.getSaddled() == true) {
				return new ResourceLocation(WorldSalad.MOD_ID,
						"textures/models/entity/dragonfly/dragonfly_blue_saddled.png");
			} else {
				return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/dragonfly/dragonfly_blue.png");
			}
		} else if (entity.getVariant() == 1) {
			if (entity.getSaddled() == true) {
				return new ResourceLocation(WorldSalad.MOD_ID,
						"textures/models/entity/dragonfly/dragonfly_red_saddled.png");
			} else {
				return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/dragonfly/dragonfly_red.png");
			}
		} else if (entity.getVariant() == 2) {
			if (entity.getSaddled() == true) {
				return new ResourceLocation(WorldSalad.MOD_ID,
						"textures/models/entity/dragonfly/dragonfly_green_saddled.png");
			} else {
				return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/dragonfly/dragonfly_green.png");
			}
		} else if (entity.getVariant() == 3) {
			if (entity.getSaddled() == true) {
				return new ResourceLocation(WorldSalad.MOD_ID,
						"textures/models/entity/dragonfly/dragonfly_pink_saddled.png");
			} else {
				return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/dragonfly/dragonfly_pink.png");
			}
		} else if (entity.getVariant() == 4) {
			if (entity.getSaddled() == true) {
				return new ResourceLocation(WorldSalad.MOD_ID,
						"textures/models/entity/dragonfly/dragonfly_white_saddled.png");
			} else {
				return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/dragonfly/dragonfly_white.png");
			}
		} else if (entity.getVariant() == 5) {
			if (entity.getSaddled() == true) {
				return new ResourceLocation(WorldSalad.MOD_ID,
						"textures/models/entity/dragonfly/dragonfly_black_saddled.png");
			} else {
				return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/dragonfly/dragonfly_black.png");
			}
		} else if (entity.getVariant() == 6) {
			if (entity.getSaddled() == true) {
				return new ResourceLocation(WorldSalad.MOD_ID,
						"textures/models/entity/dragonfly/dragonfly_gold_saddled.png");
			} else {
				return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/dragonfly/dragonfly_gold.png");
			}
		} else {
			if (entity.getSaddled() == true) {
				return new ResourceLocation(WorldSalad.MOD_ID,
						"textures/models/entity/dragonfly/dragonfly_blue_saddled.png");
			} else {
				return new ResourceLocation(WorldSalad.MOD_ID, "textures/models/entity/dragonfly/dragonfly_blue.png");
			}
		}
	}
}
