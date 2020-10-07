package com.radioctivetacoo.worldsalad.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.radioctivetacoo.worldsalad.entities.Urchin;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class UrchinModel<T extends Urchin> extends EntityModel<T> {
	private final ModelRenderer body;
	private final ModelRenderer spine2;
	private final ModelRenderer spine1;
	private final ModelRenderer spine3;

	public UrchinModel() {
		textureWidth = 44;
		textureHeight = 11;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, -1.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(24, 0).addBox(-5.0F, -7.0F, 1.0F, 10.0F, 7.0F, 0.0F, 0.0F, false);

		spine2 = new ModelRenderer(this);
		spine2.setRotationPoint(1.0F, 0.0F, -3.0F);
		body.addChild(spine2);
		setRotationAngle(spine2, 0.0F, -1.5708F, 0.0F);
		spine2.setTextureOffset(24, 0).addBox(-1.0F, -7.0F, 1.0F, 10.0F, 7.0F, 0.0F, 0.0F, false);

		spine1 = new ModelRenderer(this);
		spine1.setRotationPoint(-4.0F, 0.0F, -1.0F);
		body.addChild(spine1);
		setRotationAngle(spine1, 0.0F, -0.7854F, 0.0F);
		spine1.setTextureOffset(24, 0).addBox(-0.7071F, -7.0F, -1.2929F, 10.0F, 7.0F, 0.0F, 0.0F, false);

		spine3 = new ModelRenderer(this);
		spine3.setRotationPoint(-2.0F, 0.0F, 5.0F);
		body.addChild(spine3);
		setRotationAngle(spine3, 0.0F, 0.7854F, 0.0F);
		spine3.setTextureOffset(24, 0).addBox(-0.7071F, -7.0F, -1.2929F, 10.0F, 7.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}