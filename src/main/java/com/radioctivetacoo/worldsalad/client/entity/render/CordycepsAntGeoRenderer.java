package com.radioctivetacoo.worldsalad.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.radioctivetacoo.worldsalad.client.entity.model.CordycepsAntModel;
import com.radioctivetacoo.worldsalad.entities.CordycepsAnt;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CordycepsAntGeoRenderer extends GeoEntityRenderer<CordycepsAnt>
{
	@SuppressWarnings("unchecked")
	public CordycepsAntGeoRenderer(EntityRendererManager renderManager)
	{
		super(renderManager, new CordycepsAntModel());
	}

	@Override
	public RenderType getRenderType(CordycepsAnt animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
	{
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}
