package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.entities.CordycepsAnt;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class CordycepsAntModel extends AnimatedEntityModel<CordycepsAnt> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Mushroom1;
	private final AnimatedModelRenderer Legs;
	private final AnimatedModelRenderer FrontRight;
	private final AnimatedModelRenderer MiddleLeft;
	private final AnimatedModelRenderer BackRight;
	private final AnimatedModelRenderer FrontLeft;
	private final AnimatedModelRenderer MiddleRight;
	private final AnimatedModelRenderer BackLeft;
	private final AnimatedModelRenderer Back;
	private final AnimatedModelRenderer End;
	private final AnimatedModelRenderer Sting;
	private final AnimatedModelRenderer Petiole;
	private final AnimatedModelRenderer Head;
	private final AnimatedModelRenderer Mushroom2;
	private final AnimatedModelRenderer LeftMandible;
	private final AnimatedModelRenderer RightMandible;
	private final AnimatedModelRenderer LeftAntenna;
	private final AnimatedModelRenderer RightAntenna;

    public CordycepsAntModel()
    {
        textureWidth = 40;
    textureHeight = 40;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 1.0F);
		setRotationAngle(Body, 0.0F, 3.1416F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-2.5F, -8.0F, -3.0F, 5.0F, 4.0F, 7.0F, 0.0F, false);
		Body.setTextureOffset(20, 9).addBox(0.0F, -9.0F, -3.0F, 0.0F, 1.0F, 7.0F, 0.0F, false);
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Mushroom1 = new AnimatedModelRenderer(this);
		Mushroom1.setRotationPoint(-1.0F, -2.0F, 0.0F);
		Body.addChild(Mushroom1);
		setRotationAngle(Mushroom1, 0.1745F, 0.0F, -0.1745F);
		Mushroom1.setTextureOffset(34, 2).addBox(-1.0F, -9.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		Mushroom1.setTextureOffset(24, 35).addBox(-2.4372F, -9.7286F, -1.4609F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Mushroom1.setModelRendererName("Mushroom1");
		this.registerModelRenderer(Mushroom1);

		Legs = new AnimatedModelRenderer(this);
		Legs.setRotationPoint(-17.0F, 0.0F, 0.0F);
		Body.addChild(Legs);
		
		Legs.setModelRendererName("Legs");
		this.registerModelRenderer(Legs);

		FrontRight = new AnimatedModelRenderer(this);
		FrontRight.setRotationPoint(19.0F, -5.0F, 3.0F);
		Legs.addChild(FrontRight);
		setRotationAngle(FrontRight, 0.3491F, 0.0F, -0.6981F);
		FrontRight.setTextureOffset(24, 2).addBox(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		FrontRight.setModelRendererName("FrontRight");
		this.registerModelRenderer(FrontRight);

		MiddleLeft = new AnimatedModelRenderer(this);
		MiddleLeft.setRotationPoint(15.0F, -5.0F, 1.0F);
		Legs.addChild(MiddleLeft);
		setRotationAngle(MiddleLeft, 0.0F, 0.0F, 0.6981F);
		MiddleLeft.setTextureOffset(24, 2).addBox(-1.1756F, 0.053F, -0.9028F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		MiddleLeft.setModelRendererName("MiddleLeft");
		this.registerModelRenderer(MiddleLeft);

		BackRight = new AnimatedModelRenderer(this);
		BackRight.setRotationPoint(19.0F, -5.0F, -2.0F);
		Legs.addChild(BackRight);
		setRotationAngle(BackRight, -0.3491F, 0.0F, -0.6981F);
		BackRight.setTextureOffset(24, 2).addBox(-0.0391F, -0.0705F, -0.902F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		BackRight.setModelRendererName("BackRight");
		this.registerModelRenderer(BackRight);

		FrontLeft = new AnimatedModelRenderer(this);
		FrontLeft.setRotationPoint(15.0F, -5.0F, 3.0F);
		Legs.addChild(FrontLeft);
		setRotationAngle(FrontLeft, 0.3491F, 0.0F, 0.6981F);
		FrontLeft.setTextureOffset(24, 2).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		FrontLeft.setModelRendererName("FrontLeft");
		this.registerModelRenderer(FrontLeft);

		MiddleRight = new AnimatedModelRenderer(this);
		MiddleRight.setRotationPoint(19.0F, -5.0F, 1.0F);
		Legs.addChild(MiddleRight);
		setRotationAngle(MiddleRight, 0.0F, 0.0F, -0.6981F);
		MiddleRight.setTextureOffset(24, 2).addBox(0.1351F, 0.0531F, -0.9028F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		MiddleRight.setModelRendererName("MiddleRight");
		this.registerModelRenderer(MiddleRight);

		BackLeft = new AnimatedModelRenderer(this);
		BackLeft.setRotationPoint(15.0F, -5.0F, -2.0F);
		Legs.addChild(BackLeft);
		setRotationAngle(BackLeft, -0.3491F, 0.0F, 0.6981F);
		BackLeft.setTextureOffset(24, 2).addBox(-1.0F, -0.0326F, -0.8615F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		BackLeft.setModelRendererName("BackLeft");
		this.registerModelRenderer(BackLeft);

		Back = new AnimatedModelRenderer(this);
		Back.setRotationPoint(0.0F, -7.0F, -16.0F);
		Body.addChild(Back);
		setRotationAngle(Back, -0.4363F, 0.0F, 0.0F);
		Back.setTextureOffset(0, 26).addBox(-3.0F, -7.5225F, 6.8889F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Back.setTextureOffset(0, 11).addBox(-2.0F, -6.3129F, 5.1122F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		Back.setTextureOffset(20, 10).addBox(0.0F, -7.3646F, 5.1215F, 0.0F, 1.0F, 6.0F, 0.0F, false);
		Back.setModelRendererName("Back");
		this.registerModelRenderer(Back);

		End = new AnimatedModelRenderer(this);
		End.setRotationPoint(0.0F, 1.0F, -3.0F);
		Back.addChild(End);
		setRotationAngle(End, -0.2182F, 0.0F, 0.0F);
		End.setTextureOffset(20, 11).addBox(-1.0F, -8.3518F, 4.8382F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		End.setModelRendererName("End");
		this.registerModelRenderer(End);

		Sting = new AnimatedModelRenderer(this);
		Sting.setRotationPoint(0.0F, 1.0F, -4.0F);
		Back.addChild(Sting);
		setRotationAngle(Sting, 0.5672F, 0.0F, 0.0F);
		Sting.setTextureOffset(30, 3).addBox(-0.5F, -3.8856F, 9.2517F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Sting.setModelRendererName("Sting");
		this.registerModelRenderer(Sting);

		Petiole = new AnimatedModelRenderer(this);
		Petiole.setRotationPoint(0.0F, -4.442F, 9.0152F);
		Back.addChild(Petiole);
		setRotationAngle(Petiole, 0.1309F, 0.0F, 0.0F);
		Petiole.setTextureOffset(20, 17).addBox(-1.0F, -0.9988F, -0.3951F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		Petiole.setModelRendererName("Petiole");
		this.registerModelRenderer(Petiole);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(0.0F, -6.0F, 11.0F);
		Body.addChild(Head);
		setRotationAngle(Head, -0.2618F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 30).addBox(-3.0F, -0.413F, -7.0544F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(0, 26).addBox(1.8F, -1.0F, -2.9319F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

		Mushroom2 = new AnimatedModelRenderer(this);
		Mushroom2.setRotationPoint(2.0F, -1.0F, -3.0F);
		Head.addChild(Mushroom2);
		setRotationAngle(Mushroom2, 0.0F, 0.0F, 0.3491F);
		Mushroom2.setTextureOffset(34, 2).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Mushroom2.setTextureOffset(26, 36).addBox(-1.9F, -2.3866F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		Mushroom2.setModelRendererName("Mushroom2");
		this.registerModelRenderer(Mushroom2);

		LeftMandible = new AnimatedModelRenderer(this);
		LeftMandible.setRotationPoint(-3.0F, 2.5176F, -1.9319F);
		Head.addChild(LeftMandible);
		setRotationAngle(LeftMandible, 0.0F, 0.4363F, 0.0F);
		LeftMandible.setTextureOffset(28, 7).addBox(-1.072F, 0.1566F, -0.2054F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		LeftMandible.setModelRendererName("LeftMandible");
		this.registerModelRenderer(LeftMandible);

		RightMandible = new AnimatedModelRenderer(this);
		RightMandible.setRotationPoint(3.0F, 2.5176F, -1.9319F);
		Head.addChild(RightMandible);
		setRotationAngle(RightMandible, 0.0F, -0.3491F, 0.0F);
		RightMandible.setTextureOffset(31, 11).addBox(-0.002F, 0.1566F, -0.1998F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		RightMandible.setModelRendererName("RightMandible");
		this.registerModelRenderer(RightMandible);

		LeftAntenna = new AnimatedModelRenderer(this);
		LeftAntenna.setRotationPoint(-2.0F, 0.0F, -2.0F);
		Head.addChild(LeftAntenna);
		setRotationAngle(LeftAntenna, -0.2618F, -0.3491F, -0.2618F);
		LeftAntenna.setTextureOffset(28, 3).addBox(0.1331F, -3.3664F, -0.4079F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		LeftAntenna.setModelRendererName("LeftAntenna");
		this.registerModelRenderer(LeftAntenna);

		RightAntenna = new AnimatedModelRenderer(this);
		RightAntenna.setRotationPoint(2.0F, 0.0F, -2.0F);
		Head.addChild(RightAntenna);
		setRotationAngle(RightAntenna, -0.2618F, 0.3491F, 0.1745F);
		RightAntenna.setTextureOffset(28, 3).addBox(-0.0794F, -3.3837F, -0.3923F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		RightAntenna.setModelRendererName("RightAntenna");
		this.registerModelRenderer(RightAntenna);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("worldsalad", "animations/exoskeleton.json");
    }
}