package com.radioctivetacoo.worldsalad.client.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.radioctivetacoo.worldsalad.client.entity.model.InfectedQueenModel;
import com.radioctivetacoo.worldsalad.entities.InfectedQueen;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class InfectedQueenGeoRenderer extends GeoEntityRenderer<InfectedQueen>
{
	@SuppressWarnings("unchecked")
	public InfectedQueenGeoRenderer(EntityRendererManager renderManager)
	{
		super(renderManager, new InfectedQueenModel());
	}

	@Override
	public RenderType getRenderType(InfectedQueen animatable, float partialTicks, MatrixStack stack, IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation)
	{
		return RenderType.getEntityCutoutNoCull(getTextureLocation(animatable));
	}
}
