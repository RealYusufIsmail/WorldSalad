package com.radioctivetacoo.worldsalad.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.radioctivetacoo.worldsalad.client.entity.model.TraderAntModel;
import com.radioctivetacoo.worldsalad.entities.TraderAnt;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TraderAntGeoRenderer extends GeoEntityRenderer<TraderAnt>
{
	@SuppressWarnings("unchecked")
	public TraderAntGeoRenderer(EntityRendererManager renderManager)
	{
		super(renderManager, new TraderAntModel());
	}

	@Override
	public RenderType getRenderType(TraderAnt animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
	{
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}
