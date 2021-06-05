package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.Random;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

public class ModOreBlock extends OreBlock {

	public ModOreBlock(Properties properties) {
		super(properties);
	}

	protected int getExperience(Random rand) {
	      if (this == BlockInit.BIOLUMINESCENT_ORE.get() || this == BlockInit.HYPHAE_HEMATITE_ORE.get() || this == BlockInit.FALSE_EXPERIENCE_ORE.get()) {
	         return MathHelper.nextInt(rand, 0, 2);
	      } else if (this == BlockInit.SULPHUR_ORE.get() || this == BlockInit.LITHIUM_ORE.get() || this == BlockInit.ZINC_ORE.get() || this == BlockInit.MANGANESE_ORE.get()) {
		     return MathHelper.nextInt(rand, 1, 2);
	      } else if (this == BlockInit.HYPHAE_AMBER_ORE.get() || this == BlockInit.AMBERED_ADOBE.get()) {
				 return MathHelper.nextInt(rand, 4, 5);
	      } else if (this == BlockInit.EXPERIENCE_ORE.get()) {
				 return MathHelper.nextInt(rand, 15, 25);
	      } else {
	         return this == BlockInit.BLOOD_QUARTZ_ORE.get() || this == BlockInit.SPORE_QUARTZ_ORE.get() || this == BlockInit.VOID_QUARTZ_ORE.get() ? MathHelper.nextInt(rand, 2, 5) : 0;
	      }
	   }
}
