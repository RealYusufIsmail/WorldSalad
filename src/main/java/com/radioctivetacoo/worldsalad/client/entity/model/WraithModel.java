// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.entities.Wraith;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class WraithModel extends AnimatedEntityModel<Wraith> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Robes;
	private final AnimatedModelRenderer Head;
	private final AnimatedModelRenderer RightArm;
	private final AnimatedModelRenderer RightHand;
	private final AnimatedModelRenderer LeftArm;
	private final AnimatedModelRenderer LeftHand;

    public WraithModel()
    {
        textureWidth = 48;
    textureHeight = 38;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 12.0F, 2.0F);
		
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Robes = new AnimatedModelRenderer(this);
		Robes.setRotationPoint(0.0F, -9.0F, -2.0F);
		Body.addChild(Robes);
		Robes.setTextureOffset(0, 16).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 16.0F, 6.0F, 0.0F, false);
		Robes.setModelRendererName("Robes");
		this.registerModelRenderer(Robes);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(0.0F, -9.0F, -2.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

		RightArm = new AnimatedModelRenderer(this);
		RightArm.setRotationPoint(-4.0F, -7.0F, -2.0F);
		Body.addChild(RightArm);
		setRotationAngle(RightArm, -1.5708F, 0.0F, 0.0F);
		RightArm.setTextureOffset(32, 0).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		RightArm.setModelRendererName("RightArm");
		this.registerModelRenderer(RightArm);

		RightHand = new AnimatedModelRenderer(this);
		RightHand.setRotationPoint(-2.0F, 6.0F, 0.0F);
		RightArm.addChild(RightHand);
		RightHand.setTextureOffset(32, 13).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		RightHand.setModelRendererName("RightHand");
		this.registerModelRenderer(RightHand);

		LeftArm = new AnimatedModelRenderer(this);
		LeftArm.setRotationPoint(4.0F, -7.0F, -2.0F);
		Body.addChild(LeftArm);
		setRotationAngle(LeftArm, -1.5708F, 0.0F, 0.0F);
		LeftArm.setTextureOffset(32, 0).addBox(0.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		LeftArm.setModelRendererName("LeftArm");
		this.registerModelRenderer(LeftArm);

		LeftHand = new AnimatedModelRenderer(this);
		LeftHand.setRotationPoint(2.0F, 6.0F, 0.0F);
		LeftArm.addChild(LeftHand);
		LeftHand.setTextureOffset(32, 13).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		LeftHand.setModelRendererName("LeftHand");
		this.registerModelRenderer(LeftHand);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("worldsalad", "animations/wraith.json");
    }
}