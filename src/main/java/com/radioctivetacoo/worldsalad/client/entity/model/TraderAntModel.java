package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.entities.TraderAnt;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class TraderAntModel extends AnimatedEntityModel<TraderAnt> {

    private final AnimatedModelRenderer Body;
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
	private final AnimatedModelRenderer LeftMandible;
	private final AnimatedModelRenderer RightMandible;
	private final AnimatedModelRenderer LeftAntenna;
	private final AnimatedModelRenderer RightAntenna;

    public TraderAntModel()
    {
        textureWidth = 40;
    textureHeight = 40;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 1.0F);
		setRotationAngle(Body, 0.0F, 3.1416F, 0.0F);
		Body.setTextureOffset(5, 1).addBox(-1.5F, -7.0F, -1.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Legs = new AnimatedModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Legs);
		
		Legs.setModelRendererName("Legs");
		this.registerModelRenderer(Legs);

		FrontRight = new AnimatedModelRenderer(this);
		FrontRight.setRotationPoint(1.0F, -5.0F, 3.0F);
		Legs.addChild(FrontRight);
		setRotationAngle(FrontRight, 0.3491F, 0.0F, -0.6981F);
		FrontRight.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		FrontRight.setModelRendererName("FrontRight");
		this.registerModelRenderer(FrontRight);

		MiddleLeft = new AnimatedModelRenderer(this);
		MiddleLeft.setRotationPoint(-2.0F, -5.0F, 1.0F);
		Legs.addChild(MiddleLeft);
		setRotationAngle(MiddleLeft, 0.0F, 0.0F, 0.6981F);
		MiddleLeft.setTextureOffset(0, 0).addBox(-0.4095F, -0.5897F, 0.0972F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		MiddleLeft.setModelRendererName("MiddleLeft");
		this.registerModelRenderer(MiddleLeft);

		BackRight = new AnimatedModelRenderer(this);
		BackRight.setRotationPoint(2.0F, -5.0F, 0.0F);
		Legs.addChild(BackRight);
		setRotationAngle(BackRight, -0.3491F, 0.0F, -0.6981F);
		BackRight.setTextureOffset(0, 0).addBox(-0.8051F, -0.6746F, -1.1218F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		BackRight.setModelRendererName("BackRight");
		this.registerModelRenderer(BackRight);

		FrontLeft = new AnimatedModelRenderer(this);
		FrontLeft.setRotationPoint(-1.0F, -5.0F, 3.0F);
		Legs.addChild(FrontLeft);
		setRotationAngle(FrontLeft, 0.3491F, 0.0F, 0.6981F);
		FrontLeft.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		FrontLeft.setModelRendererName("FrontLeft");
		this.registerModelRenderer(FrontLeft);

		MiddleRight = new AnimatedModelRenderer(this);
		MiddleRight.setRotationPoint(2.0F, -5.0F, 2.0F);
		Legs.addChild(MiddleRight);
		setRotationAngle(MiddleRight, 0.0F, 0.0F, -0.6981F);
		MiddleRight.setTextureOffset(0, 0).addBox(-0.6309F, -0.5897F, -0.9028F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		MiddleRight.setModelRendererName("MiddleRight");
		this.registerModelRenderer(MiddleRight);

		BackLeft = new AnimatedModelRenderer(this);
		BackLeft.setRotationPoint(-1.0F, -5.0F, -1.0F);
		Legs.addChild(BackLeft);
		setRotationAngle(BackLeft, -0.3491F, 0.0F, 0.6981F);
		BackLeft.setTextureOffset(0, 0).addBox(-1.0F, -0.3746F, 0.0782F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		BackLeft.setModelRendererName("BackLeft");
		this.registerModelRenderer(BackLeft);

		Back = new AnimatedModelRenderer(this);
		Back.setRotationPoint(0.0F, -5.0F, -2.0F);
		Body.addChild(Back);
		setRotationAngle(Back, 0.2618F, 0.0F, 0.0F);
		Back.setTextureOffset(21, 0).addBox(-1.5F, -1.4483F, -2.8093F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		Back.setModelRendererName("Back");
		this.registerModelRenderer(Back);

		End = new AnimatedModelRenderer(this);
		End.setRotationPoint(0.0F, 1.0F, -3.0F);
		Back.addChild(End);
		setRotationAngle(End, 0.2618F, 0.0F, 0.0F);
		End.setTextureOffset(30, 11).addBox(-1.0F, -1.1895F, -1.8434F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		End.setModelRendererName("End");
		this.registerModelRenderer(End);

		Sting = new AnimatedModelRenderer(this);
		Sting.setRotationPoint(0.0F, 1.0F, -4.0F);
		Back.addChild(Sting);
		setRotationAngle(Sting, 0.6981F, 0.0F, 0.0F);
		Sting.setTextureOffset(24, 9).addBox(-0.5F, -1.6525F, -1.2344F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Sting.setModelRendererName("Sting");
		this.registerModelRenderer(Sting);

		Petiole = new AnimatedModelRenderer(this);
		Petiole.setRotationPoint(0.0F, 0.0F, 0.0F);
		Back.addChild(Petiole);
		Petiole.setTextureOffset(22, 12).addBox(-1.0F, -1.0341F, -0.2588F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Petiole.setModelRendererName("Petiole");
		this.registerModelRenderer(Petiole);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(0.0F, -6.0F, 4.0F);
		Body.addChild(Head);
		setRotationAngle(Head, -0.2618F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 9).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

		LeftMandible = new AnimatedModelRenderer(this);
		LeftMandible.setRotationPoint(-2.0F, 1.5176F, 3.0681F);
		Head.addChild(LeftMandible);
		setRotationAngle(LeftMandible, 0.0F, 0.4363F, 0.0F);
		LeftMandible.setTextureOffset(16, 13).addBox(-1.0F, -0.1375F, -0.3598F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		LeftMandible.setModelRendererName("LeftMandible");
		this.registerModelRenderer(LeftMandible);

		RightMandible = new AnimatedModelRenderer(this);
		RightMandible.setRotationPoint(2.0F, 1.5176F, 3.0681F);
		Head.addChild(RightMandible);
		setRotationAngle(RightMandible, 0.0F, -0.3491F, 0.0F);
		RightMandible.setTextureOffset(16, 13).addBox(-0.0603F, -0.1375F, -0.3598F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		RightMandible.setModelRendererName("RightMandible");
		this.registerModelRenderer(RightMandible);

		LeftAntenna = new AnimatedModelRenderer(this);
		LeftAntenna.setRotationPoint(-1.0F, -1.0F, 3.0F);
		Head.addChild(LeftAntenna);
		setRotationAngle(LeftAntenna, -0.2618F, -0.3491F, -0.2618F);
		LeftAntenna.setTextureOffset(4, 1).addBox(0.0F, -2.7765F, -0.1022F, 0.0F, 3.0F, 1.0F, 0.0F, false);
		LeftAntenna.setModelRendererName("LeftAntenna");
		this.registerModelRenderer(LeftAntenna);

		RightAntenna = new AnimatedModelRenderer(this);
		RightAntenna.setRotationPoint(1.0F, -1.0F, 3.0F);
		Head.addChild(RightAntenna);
		setRotationAngle(RightAntenna, -0.2618F, 0.3491F, 0.1745F);
		RightAntenna.setTextureOffset(4, 1).addBox(0.0F, -2.7765F, -0.1022F, 0.0F, 3.0F, 1.0F, 0.0F, false);
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