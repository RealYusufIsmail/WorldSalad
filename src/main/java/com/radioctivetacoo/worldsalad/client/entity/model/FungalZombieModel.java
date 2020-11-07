package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.entities.FungalZombie;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class FungalZombieModel extends AnimatedEntityModel<FungalZombie> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Head;
	private final AnimatedModelRenderer HeadMushroom;
	private final AnimatedModelRenderer LeftArm;
	private final AnimatedModelRenderer RightArm;
	private final AnimatedModelRenderer LeftLeg;
	private final AnimatedModelRenderer RightLeg;

    public FungalZombieModel()
    {
    	super();
        textureWidth = 64;
    textureHeight = 64;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(16, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(16, 44).addBox(-4.7F, -17.6F, -2.7F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(16, 44).addBox(-5.0F, -16.0F, -2.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(16, 44).addBox(-4.8F, -32.3F, -2.25F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(16, 44).addBox(-5.0F, -19.0F, -1.25F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		Body.setTextureOffset(24, 44).addBox(2.0F, -16.0F, -3.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(24, 44).addBox(-5.0F, -20.0F, 1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(24, 44).addBox(1.3F, -17.0F, -4.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(24, 44).addBox(-4.7F, -18.0F, 0.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(0.0F, -24.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(16, 44).addBox(3.0F, -9.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(16, 44).addBox(2.3F, -8.6F, -4.7F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		Head.setTextureOffset(16, 44).addBox(-2.7F, -8.6F, 2.3F, 2.0F, 2.0F, 2.0F, 0.0F, true);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

		HeadMushroom = new AnimatedModelRenderer(this);
		HeadMushroom.setRotationPoint(-2.0F, -8.0F, -3.0F);
		Head.addChild(HeadMushroom);
		setRotationAngle(HeadMushroom, 0.0F, 0.0F, -0.2182F);
		HeadMushroom.setTextureOffset(18, 45).addBox(-1.2164F, -1.0237F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		HeadMushroom.setTextureOffset(24, 44).addBox(-2.2214F, -1.9763F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		HeadMushroom.setModelRendererName("HeadMushroom");
		this.registerModelRenderer(HeadMushroom);

		LeftArm = new AnimatedModelRenderer(this);
		LeftArm.setRotationPoint(4.0F, -22.0F, 0.0F);
		Body.addChild(LeftArm);
		setRotationAngle(LeftArm, -1.5708F, 0.0F, 0.0F);
		LeftArm.setTextureOffset(40, 16).addBox(0.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		LeftArm.setModelRendererName("LeftArm");
		this.registerModelRenderer(LeftArm);

		RightArm = new AnimatedModelRenderer(this);
		RightArm.setRotationPoint(-4.0F, -22.0F, 0.0F);
		Body.addChild(RightArm);
		setRotationAngle(RightArm, -1.5708F, 0.0F, 0.0F);
		RightArm.setTextureOffset(40, 16).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		RightArm.setModelRendererName("RightArm");
		this.registerModelRenderer(RightArm);

		LeftLeg = new AnimatedModelRenderer(this);
		LeftLeg.setRotationPoint(2.0F, -12.0F, 0.0F);
		Body.addChild(LeftLeg);
		LeftLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
		LeftLeg.setTextureOffset(16, 44).addBox(0.7F, 7.0F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(16, 44).addBox(0.2F, 9.0F, 1.3F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		LeftLeg.setModelRendererName("LeftLeg");
		this.registerModelRenderer(LeftLeg);

		RightLeg = new AnimatedModelRenderer(this);
		RightLeg.setRotationPoint(-2.0F, -12.0F, 0.0F);
		Body.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);
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