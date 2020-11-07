package com.radioctivetacoo.worldsalad.objects.blocks.plants;

import java.util.Random;

import com.radioctivetacoo.worldsalad.objects.blocks.ModMushroomBlock;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DeathcapBlock extends ModMushroomBlock {
	public DeathcapBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (!worldIn.isRemote && worldIn.getDifficulty() != Difficulty.PEACEFUL) {
			if (entityIn instanceof PlayerEntity) {
				LivingEntity livingentity = (LivingEntity) entityIn;
				livingentity.addPotionEffect(new EffectInstance(Effects.WITHER, 60, 2));
				livingentity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 120));
				livingentity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 240));
			}

		}
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		VoxelShape voxelshape = this.getShape(stateIn, worldIn, pos, ISelectionContext.dummy());
		Vec3d vec3d = voxelshape.getBoundingBox().getCenter();
		double d0 = pos.getX() + vec3d.x;
		double d1 = pos.getZ() + vec3d.z;

		for (int i = 0; i < 3; ++i) {
			if (rand.nextBoolean()) {
				worldIn.addParticle(ParticleTypes.SMOKE, d0 + rand.nextFloat() / 5.0F,
						pos.getY() + (0.5D - rand.nextFloat()),
						d1 + rand.nextFloat() / 5.0F, 0.0D, 0.0D, 0.0D);
			}
		}

	}
}
