package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FireGeyserBlock extends Block {

	public FireGeyserBlock(Properties properties) {
		super(properties);
	}

	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
	      if (!entityIn.isImmuneToFire() && entityIn instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entityIn)) {
	         entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 3.0F);
	      }
	      super.onEntityWalk(worldIn, pos, entityIn);
	   }
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		if (rand.nextInt(10) == 0) {
			worldIn.playSound(pos.getX() + 0.5F, pos.getY() + 0.5F,
					pos.getZ() + 0.5F, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS,
					0.5F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.6F, false);
		}

		if (rand.nextInt(1) == 0) {
			for (int i = 0; i < rand.nextInt(1) + 1; ++i) {
				worldIn.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F,
						pos.getY() + 1.0F, pos.getZ() + 0.5F,
						rand.nextFloat() / 2.0F, 10.0E-1D, rand.nextFloat() / 2.0F);
				worldIn.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5F,
						pos.getY() + 1.0F, pos.getZ() + 0.5F,
						rand.nextFloat() / 2.0F, 10.0E-1D, rand.nextFloat() / 2.0F);
			}
		}

	}

}
