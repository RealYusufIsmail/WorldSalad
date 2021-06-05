package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BioluminescentOreBlock extends ModOreBlock {

	public BioluminescentOreBlock(Properties properties) {
		super(properties);
	}	
	
	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (worldIn.isAirBlock(pos.down())) {
			 if (rand.nextInt(2) == 1) {
		worldIn.addParticle(ParticleTypes.CRIT, (double)pos.getX() + rand.nextFloat() - 0.05f, (double)pos.getY(), (double)pos.getZ() + rand.nextFloat(), 0F, -0.05F, 0F);
			 }
		}
	}
}