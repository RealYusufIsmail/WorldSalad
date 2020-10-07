package com.radioctivetacoo.worldsalad.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class AmanitaBlock extends ModMushroomBlock {
	
	public AmanitaBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (!worldIn.isRemote && worldIn.getDifficulty() != Difficulty.PEACEFUL) {
			if (entityIn instanceof PlayerEntity) {
				LivingEntity livingentity = (LivingEntity) entityIn;
				livingentity.addPotionEffect(new EffectInstance(Effects.HUNGER, 40, 3));
				livingentity.addPotionEffect(new EffectInstance(Effects.NAUSEA, 240));
				livingentity.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 240, 3));
			}

		}
	}
}
