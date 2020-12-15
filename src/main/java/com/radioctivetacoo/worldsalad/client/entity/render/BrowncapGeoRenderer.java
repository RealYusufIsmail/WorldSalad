package com.radioctivetacoo.worldsalad.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.radioctivetacoo.worldsalad.client.entity.model.BrowncapModel;
import com.radioctivetacoo.worldsalad.entities.Browncap;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BrowncapGeoRenderer extends GeoEntityRenderer<Browncap>
{
	@SuppressWarnings("unchecked")
	public BrowncapGeoRenderer(EntityRendererManager renderManager)
	{
		super(renderManager, new BrowncapModel());
	}

	@Override
	public RenderType getRenderType(Browncap animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
	{
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}
