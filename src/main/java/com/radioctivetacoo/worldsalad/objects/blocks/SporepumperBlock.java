package com.radioctivetacoo.worldsalad.objects.blocks;

import java.util.Random;
import java.util.stream.Stream;

import com.radioctivetacoo.worldsalad.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SporepumperBlock extends Block {
	private static final VoxelShape SHAPE = Stream.of(Block.makeCuboidShape(4, 0, 4, 12, 10, 12)).reduce((v1, v2) -> {
		return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
	}).get();

	@Override
	public VoxelShape getRenderShape(BlockState var1, IBlockReader var2, BlockPos var3) {
		return SHAPE;
	}

	public SporepumperBlock(Properties properties) {
		super(properties);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		@SuppressWarnings("deprecation")
		VoxelShape voxelshape = this.getShape(stateIn, worldIn, pos, ISelectionContext.dummy());
		Vec3d vec3d = voxelshape.getBoundingBox().getCenter();
		double d0 = pos.getX() + vec3d.x;
		double d1 = pos.getZ() + vec3d.z;

		for (int i = 0; i < 3; ++i) {
			if (rand.nextBoolean()) {
				worldIn.addParticle(ParticleTypes.MYCELIUM, d0 + rand.nextFloat() / -0.6F,
						pos.getY() + (1.2D - rand.nextFloat()),
						d1 + rand.nextFloat() / -0.6F, 0.0D, 0.0D, 0.0D);
				worldIn.addParticle(ParticleTypes.MYCELIUM, d0 + rand.nextFloat() / 0.6F,
						pos.getY() + (1.2D - rand.nextFloat()),
						d1 + rand.nextFloat() / -0.6F, 0.0D, 0.0D, 0.0D);
				worldIn.addParticle(ParticleTypes.MYCELIUM, d0 + rand.nextFloat() / -0.6F,
						pos.getY() + (1.2D - rand.nextFloat()),
						d1 + rand.nextFloat() / 0.6F, 0.0D, 0.0D, 0.0D);
				worldIn.addParticle(ParticleTypes.MYCELIUM, d0 + rand.nextFloat() / 0.6F,
						pos.getY() + (1.2D - rand.nextFloat()),
						d1 + rand.nextFloat() / 0.6F, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		Block block = blockstate.getBlock();
		if (block != BlockInit.MOLDGRASS.get() && block != BlockInit.HYCELIUM.get()
				&& block != BlockInit.CLAYSTONE.get() && block != BlockInit.MUDSTONE.get()
				&& block != BlockInit.TOUGH_HYPHAE.get() && block != Blocks.MYCELIUM && block != Blocks.PODZOL
				&& block != BlockInit.PLACEHOLDER_BLOCK.get() && block != BlockInit.GLOWING_HYCELIUM.get()
				&& block != Blocks.GRASS_BLOCK && block != Blocks.PODZOL && block != Blocks.MYCELIUM
				&& block != Blocks.DIRT && block != Blocks.COARSE_DIRT && block != BlockInit.FUNGAL_DIRT.get()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return true;
	}

}
