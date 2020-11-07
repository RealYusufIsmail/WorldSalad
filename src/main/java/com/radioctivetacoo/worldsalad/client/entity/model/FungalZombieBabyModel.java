package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.entities.FungalZombie;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class FungalZombieBabyModel extends AnimatedEntityModel<FungalZombie> {

	private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Head;
	private final AnimatedModelRenderer HeadMushroom;
	private final AnimatedModelRenderer LeftArm;
	private final AnimatedModelRenderer RightArm;
	private final AnimatedModelRenderer LeftLeg;
	private final AnimatedModelRenderer RightLeg;

    public FungalZombieBabyModel()
    {
        textureWidth = 32;
    textureHeight = 32;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(8, 0).addBox(-2.0F, -12.0F, -1.0F, 4.0F, 6.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(8, 22).addBox(-2.35F, -8.8F, -1.35F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(8, 22).addBox(-2.5F, -8.0F, -1.125F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(18, 18).addBox(-3.52F, -18.27F, -3.025F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(16, 44).addBox(-2.5F, -9.5F, -0.625F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(0.0F, -12.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 16).addBox(-2.9F, -5.6F, -3.1F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(18, 18).addBox(2.5F, -6.9F, -1.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(18, 18).addBox(1.87F, -6.54F, -3.23F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		Head.setTextureOffset(18, 18).addBox(-1.63F, -6.54F, 1.07F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

		HeadMushroom = new AnimatedModelRenderer(this);
		HeadMushroom.setRotationPoint(-1.0F, -4.0F, -1.5F);
		Head.addChild(HeadMushroom);
		setRotationAngle(HeadMushroom, 0.0F, 0.0F, -0.2182F);
		
		HeadMushroom.setModelRendererName("HeadMushroom");
		this.registerModelRenderer(HeadMushroom);

		LeftArm = new AnimatedModelRenderer(this);
		LeftArm.setRotationPoint(2.0F, -11.0F, 0.0F);
		Body.addChild(LeftArm);
		setRotationAngle(LeftArm, -1.5708F, 0.0F, 0.0F);
		LeftArm.setTextureOffset(20, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		LeftArm.setModelRendererName("LeftArm");
		this.registerModelRenderer(LeftArm);

		RightArm = new AnimatedModelRenderer(this);
		RightArm.setRotationPoint(-2.0F, -11.0F, 0.0F);
		Body.addChild(RightArm);
		setRotationAngle(RightArm, -1.5708F, 0.0F, 0.0F);
		RightArm.setTextureOffset(20, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		RightArm.setModelRendererName("RightArm");
		this.registerModelRenderer(RightArm);

		LeftLeg = new AnimatedModelRenderer(this);
		LeftLeg.setRotationPoint(1.0F, -6.0F, 0.0F);
		Body.addChild(LeftLeg);
		LeftLeg.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		LeftLeg.setTextureOffset(8, 22).addBox(0.35F, 3.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(8, 22).addBox(0.1F, 4.5F, 0.65F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftLeg.setModelRendererName("LeftLeg");
		this.registerModelRenderer(LeftLeg);

		RightLeg = new AnimatedModelRenderer(this);
		RightLeg.setRotationPoint(-1.0F, -6.0F, 0.0F);
		Body.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 8).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		RightLeg.setModelRendererName("RightLeg");
		this.registerModelRenderer(RightLeg);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("worldsalad", "animations/fungal_zombie.json");
    }
}