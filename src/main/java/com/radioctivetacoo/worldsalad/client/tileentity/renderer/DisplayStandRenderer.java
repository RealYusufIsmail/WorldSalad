package com.radioctivetacoo.worldsalad.client.tileentity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.radioctivetacoo.worldsalad.tileentity.DisplayStandTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DisplayStandRenderer extends TileEntityRenderer<DisplayStandTileEntity> {

	private float degrees;
	
	public DisplayStandRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
		degrees = 0.0f;
	}
	
	@Override
	public void render(DisplayStandTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		NonNullList<ItemStack> items = tileEntityIn.getItems();
		for (ItemStack stack : items) {
			if (!stack.isEmpty()) {
				matrixStackIn.push();
				matrixStackIn.translate(0.5D, 1D, 0.5D);
				matrixStackIn.scale(0.5F, 0.5F, 0.5F);
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(degrees++ / 5));
				renderItem(stack, partialTicks, matrixStackIn, bufferIn, combinedLightIn);
				matrixStackIn.pop();
			}
		}
	}

	private void renderItem(ItemStack stack, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
			int combinedLightIn) {
		Minecraft.getInstance().getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn,
				OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn);
	}
}
