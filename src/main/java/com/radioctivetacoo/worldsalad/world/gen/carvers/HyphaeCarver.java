package com.radioctivetacoo.worldsalad.world.gen.carvers;

import java.util.BitSet;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.Dynamic;
import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.carver.CaveWorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;

public class HyphaeCarver extends CaveWorldCarver {
	public HyphaeCarver(Function<Dynamic<?>, ? extends ProbabilityConfig> p_i49929_1_) {
		super(p_i49929_1_, 180);
		this.carvableBlocks = ImmutableSet.of(BlockInit.TOUGH_HYPHAE.get(), BlockInit.FUNGAL_DIRT.get(),
				BlockInit.HYCELIUM.get(), BlockInit.MOLDGRASS.get(), BlockInit.MUD.get(), BlockInit.CLAYSTONE.get(),
				BlockInit.RED_CLAYSTONE.get(), BlockInit.GREEN_CLAYSTONE.get(), BlockInit.PURPLE_CLAYSTONE.get(),
				BlockInit.WHITE_CLAYSTONE.get(), Blocks.RED_SAND);
	}

	@Override
	protected int generateCaveStartY(Random p_222726_1_) {
		return p_222726_1_.nextInt(this.maxHeight);
	}

	@Override
	protected int func_222724_a() {
		return 10;
	}

	@Override
	protected float generateCaveRadius(Random rand) {
		return (rand.nextFloat() * 5.0F + rand.nextFloat()) * 1.F;
	}

	@Override
	protected double func_222725_b() {
		return 1.0D;
	}

	protected boolean func_225556_a_(IChunk p_225556_1_, Function<BlockPos, Biome> p_225556_2_, BitSet p_225556_3_,
			Random p_225556_4_, BlockPos.Mutable p_225556_5_, BlockPos.Mutable p_225556_6_,
			BlockPos.Mutable p_225556_7_, int p_225556_8_, int p_225556_9_, int p_225556_10_, int p_225556_11_,
			int p_225556_12_, int p_225556_13_, int p_225556_14_, int p_225556_15_, AtomicBoolean p_225556_16_) {
		int i = p_225556_13_ | p_225556_15_ << 4 | p_225556_14_ << 8;
		if (p_225556_3_.get(i)) {
			return false;
		} else {
			p_225556_3_.set(i);
			p_225556_5_.setPos(p_225556_11_, p_225556_14_, p_225556_12_);
			if (this.isCarvable(p_225556_1_.getBlockState(p_225556_5_))) {
				BlockState blockstate;
				if (p_225556_14_ <= 31) {
					blockstate = WATER.getBlockState();
				} else {
					blockstate = AIR;
				}

				p_225556_1_.setBlockState(p_225556_5_, blockstate, false);
				return true;
			} else {
				return false;
			}
		}
	}
}