package com.radioctivetacoo.worldsalad.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.radioctivetacoo.worldsalad.client.entity.model.RedcapModel;
import com.radioctivetacoo.worldsalad.entities.Redcap;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RedcapGeoRenderer extends GeoEntityRenderer<Redcap>
{
	@SuppressWarnings("unchecked")
	public RedcapGeoRenderer(EntityRendererManager renderManager)
	{
		super(renderManager, new RedcapModel());
	}

	@Override
	public RenderType getRenderType(Redcap animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
	{
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}
