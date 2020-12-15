package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MoondustBlock extends Block {
	private final int dustColor;

	   public MoondustBlock(int dustColorIn, Block.Properties properties) {
	      super(properties);
	      this.dustColor = dustColorIn;
	   }

	   @OnlyIn(Dist.CLIENT)
	   public int getDustColor(BlockState state) {
	      return this.dustColor;
	   }
	   
	   @OnlyIn(Dist.CLIENT)
	   public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
	      if (rand.nextInt(4) == 0) {
	         BlockPos blockpos = pos.down();
	         if (worldIn.isAirBlock(blockpos) || canFallThrough(worldIn.getBlockState(blockpos))) {
	            double d0 = (double)pos.getX() + (double)rand.nextFloat();
	            double d1 = (double)pos.getY() - 0.05D;
	            double d2 = (double)pos.getZ() + (double)rand.nextFloat();
	            worldIn.addParticle(new BlockParticleData(ParticleTypes.FALLING_DUST, stateIn), d0, d1, d2, 0.0D, 0.0D, 0.0D);
	         }
	      }

	   }
	   @SuppressWarnings("deprecation")
	public static boolean canFallThrough(BlockState state) {
		      Block block = state.getBlock();
		      Material material = state.getMaterial();
		      return state.isAir() || block == Blocks.FIRE || material.isLiquid() || material.isReplaceable();
		   }
}
