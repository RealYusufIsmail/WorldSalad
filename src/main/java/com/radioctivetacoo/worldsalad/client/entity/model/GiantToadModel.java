package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.entities.GiantToad;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class GiantToadModel extends AnimatedEntityModel<GiantToad> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer BodyCube;
	private final AnimatedModelRenderer Legs;
	private final AnimatedModelRenderer LeftLeg;
	private final AnimatedModelRenderer LeftFoot;
	private final AnimatedModelRenderer RightLeg;
	private final AnimatedModelRenderer RightFoot;
	private final AnimatedModelRenderer Arms;
	private final AnimatedModelRenderer LeftArm;
	private final AnimatedModelRenderer LeftHand;
	private final AnimatedModelRenderer RightArm;
	private final AnimatedModelRenderer RightHand;
	private final AnimatedModelRenderer Head;

    public GiantToadModel()
    {
        textureWidth = 96;
    textureHeight = 134;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 25.0F, 0.0F);
		
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		BodyCube = new AnimatedModelRenderer(this);
		BodyCube.setRotationPoint(0.0F, -7.0F, 1.0F);
		Body.addChild(BodyCube);
		setRotationAngle(BodyCube, -0.3491F, 0.0F, 0.0F);
		BodyCube.setTextureOffset(0, 0).addBox(-7.0F, -3.0F, -8.0F, 14.0F, 6.0F, 17.0F, 0.0F, false);
		BodyCube.setTextureOffset(0, 23).addBox(-6.0F, -1.8047F, -5.4366F, 12.0F, 6.0F, 11.0F, 0.0F, false);
		BodyCube.setTextureOffset(0, 40).addBox(-4.0F, -4.2817F, -5.4023F, 8.0F, 7.0F, 16.0F, 0.0F, false);
		BodyCube.setTextureOffset(0, 64).addBox(-5.0F, -2.9054F, 5.135F, 10.0F, 5.0F, 7.0F, 0.0F, false);
		BodyCube.setModelRendererName("BodyCube");
		this.registerModelRenderer(BodyCube);

		Legs = new AnimatedModelRenderer(this);
		Legs.setRotationPoint(0.0F, 7.0F, -1.0F);
		BodyCube.addChild(Legs);
		
		Legs.setModelRendererName("Legs");
		this.registerModelRenderer(Legs);

		LeftLeg = new AnimatedModelRenderer(this);
		LeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(LeftLeg);
		LeftLeg.setTextureOffset(0, 90).addBox(-10.0F, -6.8712F, 1.6121F, 3.0F, 2.0F, 7.0F, 0.0F, false);
		LeftLeg.setModelRendererName("LeftLeg");
		this.registerModelRenderer(LeftLeg);

		LeftFoot = new AnimatedModelRenderer(this);
		LeftFoot.setRotationPoint(-8.0F, -5.1809F, 7.0261F);
		LeftLeg.addChild(LeftFoot);
		setRotationAngle(LeftFoot, 0.3491F, 0.1745F, 0.0F);
		LeftFoot.setTextureOffset(0, 99).addBox(-2.0F, 0.4736F, -8.0782F, 3.0F, 2.0F, 9.0F, 0.0F, false);
		LeftFoot.setModelRendererName("LeftFoot");
		this.registerModelRenderer(LeftFoot);

		RightLeg = new AnimatedModelRenderer(this);
		RightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		Legs.addChild(RightLeg);
		RightLeg.setTextureOffset(0, 90).addBox(7.0F, -6.8712F, 1.6121F, 3.0F, 2.0F, 7.0F, 0.0F, true);
		RightLeg.setModelRendererName("RightLeg");
		this.registerModelRenderer(RightLeg);

		RightFoot = new AnimatedModelRenderer(this);
		RightFoot.setRotationPoint(9.0F, -4.658F, 8.0603F);
		RightLeg.addChild(RightFoot);
		setRotationAngle(RightFoot, 0.3491F, -0.1309F, 0.0F);
		RightFoot.setTextureOffset(0, 99).addBox(-2.0F, -0.2104F, -8.9054F, 3.0F, 2.0F, 9.0F, 0.0F, false);
		RightFoot.setModelRendererName("RightFoot");
		this.registerModelRenderer(RightFoot);

		Arms = new AnimatedModelRenderer(this);
		Arms.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyCube.addChild(Arms);
		
		Arms.setModelRendererName("Arms");
		this.registerModelRenderer(Arms);

		LeftArm = new AnimatedModelRenderer(this);
		LeftArm.setRotationPoint(-7.0F, 2.3941F, -6.5778F);
		Arms.addChild(LeftArm);
		setRotationAngle(LeftArm, 0.0F, 0.0F, -0.1745F);
		LeftArm.setTextureOffset(0, 110).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		LeftArm.setModelRendererName("LeftArm");
		this.registerModelRenderer(LeftArm);

		LeftHand = new AnimatedModelRenderer(this);
		LeftHand.setRotationPoint(-0.9848F, 4.8264F, 0.0F);
		LeftArm.addChild(LeftHand);
		setRotationAngle(LeftHand, 0.0F, 0.2182F, 0.3054F);
		LeftHand.setTextureOffset(0, 119).addBox(-0.9679F, -0.8695F, -0.2146F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		LeftHand.setModelRendererName("LeftHand");
		this.registerModelRenderer(LeftHand);

		RightArm = new AnimatedModelRenderer(this);
		RightArm.setRotationPoint(7.0F, 2.0F, -6.0F);
		Arms.addChild(RightArm);
		setRotationAngle(RightArm, 0.0F, 0.0F, 0.1745F);
		RightArm.setTextureOffset(0, 110).addBox(0.0F, -0.6059F, -0.5778F, 2.0F, 7.0F, 2.0F, 0.0F, true);
		RightArm.setModelRendererName("RightArm");
		this.registerModelRenderer(RightArm);

		RightHand = new AnimatedModelRenderer(this);
		RightHand.setRotationPoint(-0.0594F, 4.6632F, 0.9397F);
		RightArm.addChild(RightHand);
		setRotationAngle(RightHand, 0.0F, -0.2182F, -0.3054F);
		RightHand.setTextureOffset(0, 119).addBox(-4.0853F, -0.0057F, -1.7321F, 6.0F, 2.0F, 2.0F, 0.0F, true);
		RightHand.setModelRendererName("RightHand");
		this.registerModelRenderer(RightHand);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(0.0F, -9.0F, -5.0F);
		Body.addChild(Head);
		setRotationAngle(Head, -0.1309F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 76).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 6.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(84, 0).addBox(-5.2F, -3.1997F, -6.2097F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(84, 0).addBox(2.2F, -3.1997F, -6.2097F, 3.0F, 3.0F, 3.0F, 0.0F, true);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("worldsalad", "animations/giant_toad.json");
    }
}