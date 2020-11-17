package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.entities.Browncap;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class BrowncapModel extends AnimatedEntityModel<Browncap> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Legs;
	private final AnimatedModelRenderer LeftLeg;
	private final AnimatedModelRenderer RightLeg;
	private final AnimatedModelRenderer Arms;
	private final AnimatedModelRenderer LeftArm;
	private final AnimatedModelRenderer RightArm;
	private final AnimatedModelRenderer Head;
	private final AnimatedModelRenderer Cap;

    public BrowncapModel()
    {
        textureWidth = 64;
    textureHeight = 64;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(3.0F, 24.0F, -2.0F);
		Body.setTextureOffset(16, 0).addBox(-6.5F, -14.0F, 0.0F, 7.0F, 7.0F, 4.0F, 0.0F, false);
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Legs = new AnimatedModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Legs);
		
		Legs.setModelRendererName("Legs");
		this.registerModelRenderer(Legs);

		LeftLeg = new AnimatedModelRenderer(this);
		LeftLeg.setRotationPoint(-2.0F, -7.0F, 2.0F);
		Legs.addChild(LeftLeg);
		LeftLeg.setTextureOffset(46, 0).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, true);
		LeftLeg.setModelRendererName("LeftLeg");
		this.registerModelRenderer(LeftLeg);

		RightLeg = new AnimatedModelRenderer(this);
		RightLeg.setRotationPoint(-4.0F, -7.0F, 2.0F);
		Legs.addChild(RightLeg);
		RightLeg.setTextureOffset(46, 10).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
		RightLeg.setModelRendererName("RightLeg");
		this.registerModelRenderer(RightLeg);

		Arms = new AnimatedModelRenderer(this);
		Arms.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Arms);
		
		Arms.setModelRendererName("Arms");
		this.registerModelRenderer(Arms);

		LeftArm = new AnimatedModelRenderer(this);
		LeftArm.setRotationPoint(0.0F, -12.0F, 2.0F);
		Arms.addChild(LeftArm);
		LeftArm.setTextureOffset(38, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
		LeftArm.setModelRendererName("LeftArm");
		this.registerModelRenderer(LeftArm);

		RightArm = new AnimatedModelRenderer(this);
		RightArm.setRotationPoint(-6.0F, -12.0F, 2.0F);
		Arms.addChild(RightArm);
		RightArm.setTextureOffset(38, 0).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);
		RightArm.setModelRendererName("RightArm");
		this.registerModelRenderer(RightArm);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-5.0F, -17.0F, -1.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

		Cap = new AnimatedModelRenderer(this);
		Cap.setRotationPoint(-3.0F, -15.0F, 2.0F);
		Head.addChild(Cap);
		setRotationAngle(Cap, -0.3491F, 0.0F, 0.0F);
		Cap.setTextureOffset(0, 17).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);
		Cap.setModelRendererName("Cap");
		this.registerModelRenderer(Cap);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("worldsalad", "animations/redcap.json");
    }
}