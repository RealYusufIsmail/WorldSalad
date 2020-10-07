package com.radioctivetacoo.worldsalad.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.radioctivetacoo.worldsalad.entities.Moth;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class MothModel<T extends Moth> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer LeftWing;
	private final ModelRenderer RightWing;
	private final ModelRenderer LeftAntena;
	private final ModelRenderer RightAntena;

	public MothModel() {
		textureWidth = 23;
		textureHeight = 23;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(1.0F, 24.0F, -1.0F);
		Body.setTextureOffset(8, 18).addBox(-1.5F, -1.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(-1.5F, -1.0F, 0.0F);
		Body.addChild(LeftWing);
		setRotationAngle(LeftWing, -0.0873F, 0.0F, 0.0F);
		LeftWing.setTextureOffset(0, 8).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 0.0F, 8.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-0.5F, -1.0F, 0.0F);
		Body.addChild(RightWing);
		setRotationAngle(RightWing, -0.0873F, 0.0F, 0.0F);
		RightWing.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -2.0F, 4.0F, 0.0F, 8.0F, 0.0F, false);

		LeftAntena = new ModelRenderer(this);
		LeftAntena.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(LeftAntena);
		setRotationAngle(LeftAntena, 0.0F, 0.3491F, -0.1745F);
		LeftAntena.setTextureOffset(8, 18).addBox(-0.5F, -2.0F, -4.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		RightAntena = new ModelRenderer(this);
		RightAntena.setRotationPoint(-2.0F, 0.0F, 0.0F);
		Body.addChild(RightAntena);
		setRotationAngle(RightAntena, 0.0F, -0.3491F, 0.1745F);
		RightAntena.setTextureOffset(8, 18).addBox(0.5F, -2.0F, -4.042F, 0.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		boolean flag = entityIn.onGround;
		if (flag) {
			this.RightWing.rotateAngleY = 0.0F;
			this.RightWing.rotateAngleZ = 0.0F;
			this.RightWing.rotateAngleX = -0.0873F;
			this.LeftWing.rotateAngleX = -0.0873F;
			this.LeftWing.rotateAngleY = 0.0F;
			this.LeftWing.rotateAngleZ = 0.0F;
			this.Body.rotateAngleX = 0.0F;
		} else {
			this.RightWing.rotateAngleZ = MathHelper.cos(ageInTicks * 0.6F) * (float) Math.PI * 0.15F;
			this.LeftWing.rotateAngleZ = -this.RightWing.rotateAngleZ;
			this.Body.rotateAngleX = MathHelper.cos(ageInTicks * 0.6F) * (float) Math.PI * 0.02F;
		}
	}

	public boolean isAggressive(T entityIn) {
		return entityIn.isAggressive();
	}
}