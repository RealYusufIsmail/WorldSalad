package com.radioctivetacoo.worldsalad.client.entity.model;

import com.radioctivetacoo.worldsalad.entities.Macrobe;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class MacrobeModel extends AnimatedEntityModel<Macrobe> {

    private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Segments;
	private final AnimatedModelRenderer Bones;
	private final AnimatedModelRenderer Bone1;
	private final AnimatedModelRenderer Bone2;
	private final AnimatedModelRenderer Bone3;
	private final AnimatedModelRenderer Bone4;
	private final AnimatedModelRenderer Bone5;
	private final AnimatedModelRenderer Bone6;
	private final AnimatedModelRenderer Bone7;
	private final AnimatedModelRenderer Bone8;
	private final AnimatedModelRenderer Spine;
	private final AnimatedModelRenderer Vertebra1;
	private final AnimatedModelRenderer Vertebra2;
	private final AnimatedModelRenderer Vertebra3;
	private final AnimatedModelRenderer Vertebra4;
	private final AnimatedModelRenderer Vertebra5;
	private final AnimatedModelRenderer Vertebra6;
	private final AnimatedModelRenderer Arrow3;
	private final AnimatedModelRenderer ArrowHorizontal3;
	private final AnimatedModelRenderer ArrowVertical3;
	private final AnimatedModelRenderer Skulls;
	private final AnimatedModelRenderer Skull2;
	private final AnimatedModelRenderer Skull3;
	private final AnimatedModelRenderer Segment1;
	private final AnimatedModelRenderer Arrow2;
	private final AnimatedModelRenderer ArrowHorizontal2;
	private final AnimatedModelRenderer ArrowVertical2;
	private final AnimatedModelRenderer Arrow1;
	private final AnimatedModelRenderer ArrowHorizontal1;
	private final AnimatedModelRenderer ArrowVertical1;
	private final AnimatedModelRenderer Ribcage;
	private final AnimatedModelRenderer Segment2;
	private final AnimatedModelRenderer Skull1;

    public MacrobeModel()
    {
        textureWidth = 96;
    textureHeight = 134;
    Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Segments = new AnimatedModelRenderer(this);
		Segments.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Segments);
		setRotationAngle(Segments, 0.0F, 0.2618F, 0.0F);
		Segments.setTextureOffset(36, 110).addBox(-7.0F, -10.0F, 6.0F, 18.0F, 15.0F, 9.0F, 0.0F, false);
		Segments.setTextureOffset(22, 105).addBox(-17.0F, -10.0F, -13.0F, 12.0F, 15.0F, 14.0F, 0.0F, false);
		Segments.setTextureOffset(17, 105).addBox(1.0F, -33.0F, -7.0F, 15.0F, 14.0F, 15.0F, 0.0F, false);
		Segments.setTextureOffset(4, 107).addBox(-10.0F, -32.0F, -11.0F, 21.0F, 6.0F, 21.0F, 0.0F, false);
		Segments.setTextureOffset(24, 112).addBox(-6.0F, -8.0F, -19.0F, 12.0F, 13.0F, 9.0F, 0.0F, false);
		Segments.setTextureOffset(0, 80).addBox(-12.0F, -27.0F, -12.0F, 24.0F, 30.0F, 24.0F, 0.0F, false);
		Segments.setModelRendererName("Segments");
		this.registerModelRenderer(Segments);

		Bones = new AnimatedModelRenderer(this);
		Bones.setRotationPoint(0.0F, 0.0F, 0.0F);
		Segments.addChild(Bones);
		
		Bones.setModelRendererName("Bones");
		this.registerModelRenderer(Bones);

		Bone1 = new AnimatedModelRenderer(this);
		Bone1.setRotationPoint(-10.9048F, -19.0F, -6.7017F);
		Bones.addChild(Bone1);
		setRotationAngle(Bone1, 0.6545F, -0.0873F, -1.0036F);
		Bone1.setTextureOffset(48, 2).addBox(-2.0F, -11.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Bone1.setModelRendererName("Bone1");
		this.registerModelRenderer(Bone1);

		Bone2 = new AnimatedModelRenderer(this);
		Bone2.setRotationPoint(-10.0776F, -23.0F, 1.8021F);
		Bones.addChild(Bone2);
		setRotationAngle(Bone2, -0.6545F, 0.0F, -0.6981F);
		Bone2.setTextureOffset(48, 2).addBox(-2.0F, -11.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Bone2.setModelRendererName("Bone2");
		this.registerModelRenderer(Bone2);

		Bone3 = new AnimatedModelRenderer(this);
		Bone3.setRotationPoint(11.4316F, -23.0F, 6.5302F);
		Bones.addChild(Bone3);
		setRotationAngle(Bone3, -0.3054F, 0.0F, 0.6545F);
		Bone3.setTextureOffset(48, 2).addBox(-2.0F, -11.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Bone3.setModelRendererName("Bone3");
		this.registerModelRenderer(Bone3);

		Bone4 = new AnimatedModelRenderer(this);
		Bone4.setRotationPoint(-2.4889F, -23.0F, 12.1177F);
		Bones.addChild(Bone4);
		setRotationAngle(Bone4, -0.48F, 0.0F, -0.0436F);
		Bone4.setTextureOffset(48, 2).addBox(-1.2243F, -9.6319F, -2.5547F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Bone4.setModelRendererName("Bone4");
		this.registerModelRenderer(Bone4);

		Bone5 = new AnimatedModelRenderer(this);
		Bone5.setRotationPoint(10.3963F, -17.0F, 10.3939F);
		Bones.addChild(Bone5);
		setRotationAngle(Bone5, -0.6981F, 0.0F, 0.5236F);
		Bone5.setTextureOffset(48, 2).addBox(-9.7274F, -11.0F, -2.0706F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Bone5.setModelRendererName("Bone5");
		this.registerModelRenderer(Bone5);

		Bone6 = new AnimatedModelRenderer(this);
		Bone6.setRotationPoint(-3.196F, -22.0F, 10.893F);
		Bones.addChild(Bone6);
		setRotationAngle(Bone6, -2.4871F, 0.3927F, 2.8362F);
		Bone6.setTextureOffset(48, 2).addBox(-2.0F, -11.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Bone6.setModelRendererName("Bone6");
		this.registerModelRenderer(Bone6);

		Bone7 = new AnimatedModelRenderer(this);
		Bone7.setRotationPoint(5.2385F, -26.0F, 14.1883F);
		Bones.addChild(Bone7);
		setRotationAngle(Bone7, 0.0F, 0.0F, 0.3491F);
		Bone7.setTextureOffset(48, 2).addBox(-0.4285F, -16.0F, -21.3197F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Bone7.setModelRendererName("Bone7");
		this.registerModelRenderer(Bone7);

		Bone8 = new AnimatedModelRenderer(this);
		Bone8.setRotationPoint(5.5667F, -23.0F, 9.0998F);
		Bones.addChild(Bone8);
		setRotationAngle(Bone8, -0.48F, 0.0F, 0.0436F);
		Bone8.setTextureOffset(48, 2).addBox(-2.965F, -10.9179F, -0.249F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Bone8.setModelRendererName("Bone8");
		this.registerModelRenderer(Bone8);

		Spine = new AnimatedModelRenderer(this);
		Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		Segments.addChild(Spine);
		
		Spine.setModelRendererName("Spine");
		this.registerModelRenderer(Spine);

		Vertebra1 = new AnimatedModelRenderer(this);
		Vertebra1.setRotationPoint(0.0F, -43.0F, 15.0F);
		Spine.addChild(Vertebra1);
		setRotationAngle(Vertebra1, 0.5672F, 0.0F, 0.0F);
		Vertebra1.setTextureOffset(32, 9).addBox(-1.0F, -3.0242F, -2.9028F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		Vertebra1.setTextureOffset(44, 9).addBox(0.5F, -3.5032F, 0.0516F, 0.0F, 5.0F, 2.0F, 0.0F, false);
		Vertebra1.setModelRendererName("Vertebra1");
		this.registerModelRenderer(Vertebra1);

		Vertebra2 = new AnimatedModelRenderer(this);
		Vertebra2.setRotationPoint(0.0F, -44.0F, 12.0F);
		Spine.addChild(Vertebra2);
		setRotationAngle(Vertebra2, 0.9599F, 0.0F, 0.0F);
		Vertebra2.setTextureOffset(32, 9).addBox(-1.0F, -3.9F, 0.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		Vertebra2.setTextureOffset(44, 9).addBox(0.5F, -4.4791F, 2.9544F, 0.0F, 5.0F, 2.0F, 0.0F, false);
		Vertebra2.setModelRendererName("Vertebra2");
		this.registerModelRenderer(Vertebra2);

		Vertebra3 = new AnimatedModelRenderer(this);
		Vertebra3.setRotationPoint(0.0F, -40.0F, 13.0F);
		Spine.addChild(Vertebra3);
		setRotationAngle(Vertebra3, 0.0873F, 0.0F, 0.0F);
		Vertebra3.setTextureOffset(32, 9).addBox(-1.0F, -1.0568F, 0.0418F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		Vertebra3.setTextureOffset(44, 9).addBox(0.5F, -1.5359F, 2.9962F, 0.0F, 5.0F, 2.0F, 0.0F, false);
		Vertebra3.setModelRendererName("Vertebra3");
		this.registerModelRenderer(Vertebra3);

		Vertebra4 = new AnimatedModelRenderer(this);
		Vertebra4.setRotationPoint(0.0F, -36.0F, 13.0F);
		Spine.addChild(Vertebra4);
		setRotationAngle(Vertebra4, -0.1745F, 0.0F, 0.0F);
		Vertebra4.setTextureOffset(32, 9).addBox(-1.0F, -1.178F, 0.2642F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		Vertebra4.setTextureOffset(44, 9).addBox(0.5F, -2.178F, 3.2186F, 0.0F, 5.0F, 2.0F, 0.0F, false);
		Vertebra4.setModelRendererName("Vertebra4");
		this.registerModelRenderer(Vertebra4);

		Vertebra5 = new AnimatedModelRenderer(this);
		Vertebra5.setRotationPoint(0.0F, -32.0F, 12.0F);
		Spine.addChild(Vertebra5);
		setRotationAngle(Vertebra5, -0.3491F, 0.0F, 0.0F);
		Vertebra5.setTextureOffset(32, 9).addBox(-1.0F, -1.178F, 0.2642F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		Vertebra5.setTextureOffset(44, 9).addBox(0.5F, -2.178F, 3.2186F, 0.0F, 5.0F, 2.0F, 0.0F, false);
		Vertebra5.setModelRendererName("Vertebra5");
		this.registerModelRenderer(Vertebra5);

		Vertebra6 = new AnimatedModelRenderer(this);
		Vertebra6.setRotationPoint(0.0F, -32.0F, 12.0F);
		Spine.addChild(Vertebra6);
		setRotationAngle(Vertebra6, -0.5236F, 0.0F, 0.0F);
		Vertebra6.setTextureOffset(32, 9).addBox(-1.0F, 2.9228F, 0.6926F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		Vertebra6.setTextureOffset(44, 9).addBox(0.5F, 1.9228F, 3.647F, 0.0F, 5.0F, 2.0F, 0.0F, false);
		Vertebra6.setModelRendererName("Vertebra6");
		this.registerModelRenderer(Vertebra6);

		Arrow3 = new AnimatedModelRenderer(this);
		Arrow3.setRotationPoint(3.0F, -40.8195F, -10.5841F);
		Segments.addChild(Arrow3);
		setRotationAngle(Arrow3, -2.837F, -0.6858F, 2.6307F);
		
		Arrow3.setModelRendererName("Arrow3");
		this.registerModelRenderer(Arrow3);

		ArrowHorizontal3 = new AnimatedModelRenderer(this);
		ArrowHorizontal3.setRotationPoint(9.0F, 38.0F, -6.0F);
		Arrow3.addChild(ArrowHorizontal3);
		ArrowHorizontal3.setTextureOffset(32, 0).addBox(-17.9972F, -21.5653F, -5.994F, 16.0F, 5.0F, 0.0F, 0.0F, false);
		ArrowHorizontal3.setModelRendererName("ArrowHorizontal3");
		this.registerModelRenderer(ArrowHorizontal3);

		ArrowVertical3 = new AnimatedModelRenderer(this);
		ArrowVertical3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arrow3.addChild(ArrowVertical3);
		setRotationAngle(ArrowVertical3, 1.5708F, 0.0F, 0.0F);
		ArrowVertical3.setTextureOffset(32, 0).addBox(-8.9972F, -14.6997F, -19.2447F, 16.0F, 5.0F, 0.0F, 0.0F, false);
		ArrowVertical3.setModelRendererName("ArrowVertical3");
		this.registerModelRenderer(ArrowVertical3);

		Skulls = new AnimatedModelRenderer(this);
		Skulls.setRotationPoint(0.0F, -46.568F, 3.6703F);
		Segments.addChild(Skulls);
		setRotationAngle(Skulls, -0.4363F, -0.0873F, -0.1309F);
		
		Skulls.setModelRendererName("Skulls");
		this.registerModelRenderer(Skulls);

		Skull2 = new AnimatedModelRenderer(this);
		Skull2.setRotationPoint(-12.0123F, 13.1548F, 13.9768F);
		Skulls.addChild(Skull2);
		setRotationAngle(Skull2, 0.0F, 2.618F, 0.0F);
		Skull2.setTextureOffset(0, 0).addBox(-5.0011F, -4.9094F, -4.7761F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Skull2.setModelRendererName("Skull2");
		this.registerModelRenderer(Skull2);

		Skull3 = new AnimatedModelRenderer(this);
		Skull3.setRotationPoint(4.0723F, 32.3641F, 1.4074F);
		Skulls.addChild(Skull3);
		setRotationAngle(Skull3, 0.6109F, -1.1345F, 0.0F);
		Skull3.setTextureOffset(0, 0).addBox(-6.3837F, -3.8814F, -5.8484F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Skull3.setModelRendererName("Skull3");
		this.registerModelRenderer(Skull3);

		Segment1 = new AnimatedModelRenderer(this);
		Segment1.setRotationPoint(0.0F, -38.0F, 2.0F);
		Segments.addChild(Segment1);
		setRotationAngle(Segment1, -0.2618F, 0.0F, 0.0F);
		Segment1.setTextureOffset(0, 40).addBox(-9.0F, -10.0F, -9.0F, 18.0F, 22.0F, 18.0F, 0.0F, false);
		Segment1.setModelRendererName("Segment1");
		this.registerModelRenderer(Segment1);

		Arrow2 = new AnimatedModelRenderer(this);
		Arrow2.setRotationPoint(-13.0F, -18.8195F, 12.4159F);
		Segment1.addChild(Arrow2);
		setRotationAngle(Arrow2, -0.3372F, -0.6269F, 0.4862F);
		
		Arrow2.setModelRendererName("Arrow2");
		this.registerModelRenderer(Arrow2);

		ArrowHorizontal2 = new AnimatedModelRenderer(this);
		ArrowHorizontal2.setRotationPoint(9.0F, 38.0F, -6.0F);
		Arrow2.addChild(ArrowHorizontal2);
		ArrowHorizontal2.setTextureOffset(32, 0).addBox(-17.9972F, -21.5653F, -5.994F, 16.0F, 5.0F, 0.0F, 0.0F, false);
		ArrowHorizontal2.setModelRendererName("ArrowHorizontal2");
		this.registerModelRenderer(ArrowHorizontal2);

		ArrowVertical2 = new AnimatedModelRenderer(this);
		ArrowVertical2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arrow2.addChild(ArrowVertical2);
		setRotationAngle(ArrowVertical2, 1.5708F, 0.0F, 0.0F);
		ArrowVertical2.setTextureOffset(32, 0).addBox(-8.9972F, -14.6997F, -19.2447F, 16.0F, 5.0F, 0.0F, 0.0F, false);
		ArrowVertical2.setModelRendererName("ArrowVertical2");
		this.registerModelRenderer(ArrowVertical2);

		Arrow1 = new AnimatedModelRenderer(this);
		Arrow1.setRotationPoint(-7.0F, 0.0F, 4.0F);
		Segment1.addChild(Arrow1);
		setRotationAngle(Arrow1, 0.0692F, 0.2527F, 0.4015F);
		
		Arrow1.setModelRendererName("Arrow1");
		this.registerModelRenderer(Arrow1);

		ArrowHorizontal1 = new AnimatedModelRenderer(this);
		ArrowHorizontal1.setRotationPoint(9.0F, 38.0F, -6.0F);
		Arrow1.addChild(ArrowHorizontal1);
		ArrowHorizontal1.setTextureOffset(32, 0).addBox(-25.0F, -40.7578F, 5.9479F, 16.0F, 5.0F, 0.0F, 0.0F, false);
		ArrowHorizontal1.setModelRendererName("ArrowHorizontal1");
		this.registerModelRenderer(ArrowHorizontal1);

		ArrowVertical1 = new AnimatedModelRenderer(this);
		ArrowVertical1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Arrow1.addChild(ArrowVertical1);
		setRotationAngle(ArrowVertical1, 1.5708F, 0.0F, 0.0F);
		ArrowVertical1.setTextureOffset(32, 0).addBox(-16.0F, -2.7578F, -0.0521F, 16.0F, 5.0F, 0.0F, 0.0F, false);
		ArrowVertical1.setModelRendererName("ArrowVertical1");
		this.registerModelRenderer(ArrowVertical1);

		Ribcage = new AnimatedModelRenderer(this);
		Ribcage.setRotationPoint(1.0F, 0.4495F, -8.4142F);
		Segment1.addChild(Ribcage);
		Ribcage.setTextureOffset(0, 16).addBox(-7.0F, -8.6237F, -2.4626F, 12.0F, 14.0F, 5.0F, 0.0F, false);
		Ribcage.setModelRendererName("Ribcage");
		this.registerModelRenderer(Ribcage);

		Segment2 = new AnimatedModelRenderer(this);
		Segment2.setRotationPoint(0.0F, -10.0F, -1.0F);
		Segment1.addChild(Segment2);
		setRotationAngle(Segment2, 0.48F, 0.0F, 0.0F);
		Segment2.setTextureOffset(25, 97).addBox(-5.0F, -6.6593F, -4.5882F, 11.0F, 16.0F, 11.0F, 0.0F, false);
		Segment2.setModelRendererName("Segment2");
		this.registerModelRenderer(Segment2);

		Skull1 = new AnimatedModelRenderer(this);
		Skull1.setRotationPoint(-0.7399F, -1.4211F, -4.7749F);
		Segment2.addChild(Skull1);
		setRotationAngle(Skull1, -0.0436F, 0.0F, 0.0F);
		Skull1.setTextureOffset(0, 0).addBox(-2.7782F, -11.6223F, -1.1109F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Skull1.setModelRendererName("Skull1");
		this.registerModelRenderer(Skull1);

    this.rootBones.add(Body);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("worldsalad", "animations/macrobe.json");
    }
}