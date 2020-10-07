package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.Random;
import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AcidBlock extends FlowingFluidBlock {

	public AcidBlock(Supplier<? extends FlowingFluid> supplier, Properties p_i48368_1_) {
		super(supplier, p_i48368_1_);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@OnlyIn(Dist.CLIENT)
	public void animateTick(World worldIn, BlockPos pos, IFluidState state, Random random) {
		BlockPos blockpos = pos.up();
		if (worldIn.getBlockState(blockpos).isAir()
				&& !worldIn.getBlockState(blockpos).isOpaqueCube(worldIn, blockpos)) {
			if (random.nextInt(100) == 0) {
				double d0 = pos.getX() + random.nextFloat();
				double d1 = pos.getY() + 1;
				double d2 = pos.getZ() + random.nextFloat();
				worldIn.addParticle(ParticleTypes.BUBBLE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS,
						0.2F + random.nextFloat() * 0.2F, 0.9F + random.nextFloat() * 0.15F, false);
			}

			if (random.nextInt(200) == 0) {
				worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(),
						SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F,
						0.9F + random.nextFloat() * 0.15F, false);
			}
		}
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (!worldIn.isRemote && worldIn.getDifficulty() != Difficulty.PEACEFUL) {
			if (entityIn instanceof AnimalEntity || entityIn instanceof PlayerEntity) {
				LivingEntity livingentity = (LivingEntity) entityIn;
				livingentity.addPotionEffect(new EffectInstance(Effects.WITHER, 20, 2));
			}
		}
	}
}
