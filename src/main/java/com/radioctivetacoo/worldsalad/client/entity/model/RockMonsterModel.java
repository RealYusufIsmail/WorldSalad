package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.entities.RockMonster;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class RockMonsterModel extends AnimatedEntityModel<RockMonster> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Legs;
	private final AnimatedModelRenderer RightLeg;
	private final AnimatedModelRenderer LeftLeg;
	private final AnimatedModelRenderer Head;
	private final AnimatedModelRenderer Arms;
	private final AnimatedModelRenderer RightArm;
	private final AnimatedModelRenderer LeftArm;

    public RockMonsterModel()
    {
        textureWidth = 40;
    textureHeight = 50;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(1.0F, 16.0F, -1.0F);
		Body.setTextureOffset(0, 35).addBox(-6.0F, -4.0F, -2.0F, 10.0F, 8.0F, 7.0F, 0.0F, false);
		Body.setTextureOffset(6, 42).addBox(-5.0F, -2.0F, -3.0F, 8.0F, 5.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(0, 39).addBox(-5.0F, -6.0F, -1.0F, 8.0F, 4.0F, 7.0F, 0.0F, false);
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Legs = new AnimatedModelRenderer(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Legs);
		
		Legs.setModelRendererName("Legs");
		this.registerModelRenderer(Legs);

		RightLeg = new AnimatedModelRenderer(this);
		RightLeg.setRotationPoint(2.0F, 4.0F, 2.0F);
		Legs.addChild(RightLeg);
		RightLeg.setTextureOffset(12, 29).addBox(-2.0F, 3.0F, -4.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 29).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		RightLeg.setModelRendererName("RightLeg");
		this.registerModelRenderer(RightLeg);

		LeftLeg = new AnimatedModelRenderer(this);
		LeftLeg.setRotationPoint(-4.0F, 4.0F, 1.0F);
		Legs.addChild(LeftLeg);
		LeftLeg.setTextureOffset(12, 29).addBox(-1.0F, 3.0F, -3.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 29).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		LeftLeg.setModelRendererName("LeftLeg");
		this.registerModelRenderer(LeftLeg);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(-1.0F, -7.0F, 1.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 19).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 4.0F, 6.0F, 0.0F, false);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

		Arms = new AnimatedModelRenderer(this);
		Arms.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Arms);
		
		Arms.setModelRendererName("Arms");
		this.registerModelRenderer(Arms);

		RightArm = new AnimatedModelRenderer(this);
		RightArm.setRotationPoint(-6.0F, -3.4142F, 2.4142F);
		Arms.addChild(RightArm);
		RightArm.setTextureOffset(0, 43).addBox(-3.0F, -1.7574F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(7, 38).addBox(-3.0F, 1.2426F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		RightArm.setModelRendererName("RightArm");
		this.registerModelRenderer(RightArm);

		LeftArm = new AnimatedModelRenderer(this);
		LeftArm.setRotationPoint(3.0F, -4.0F, 2.4142F);
		Arms.addChild(LeftArm);
		LeftArm.setTextureOffset(0, 43).addBox(0.0F, -1.0503F, -2.1213F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		LeftArm.setTextureOffset(7, 38).addBox(1.0F, 1.9497F, -2.1213F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		LeftArm.setModelRendererName("LeftArm");
		this.registerModelRenderer(LeftArm);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("worldsalad", "animations/rock_monster.json");
    }
}