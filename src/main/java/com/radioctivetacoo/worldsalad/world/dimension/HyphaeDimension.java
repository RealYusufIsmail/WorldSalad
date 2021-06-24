package com.radioctivetacoo.worldsalad.world.dimension;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IRenderHandler;

public class HyphaeDimension extends Dimension {

	public HyphaeDimension(World world, DimensionType type) {
		super(world, type, 0.0f);
	}

	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		return new HyphaeChunkGenerator(world,
				new HyphaeBiomeProvider(new HyphaeBiomeProviderSettings(this.world.getWorldInfo())),
				new HyphaeGenSettings());
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		return findSpawn(chunkPosIn, checkValid);
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return findSpawn(posX, posZ, checkValid);
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		double d0 = MathHelper.frac(worldTime / 24000.0D - 0.25D);
		double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
		return (float) (d0 * 2.0D + d1) / 3.0F;
	}

	@Override
	public boolean isSurfaceWorld() {
		return true;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		float f = MathHelper.cos(celestialAngle * ((float) Math.PI * 2F)) * 2.0F + 0.5F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		float f1 = 0.7529412F;
		float f2 = 0.7029412F;
		float f3 = 1.0F;
		f1 = f1 * (f * 0.94F + 0.06F);
		f2 = f2 * (f * 0.94F + 0.06F);
		f3 = f3 * (f * 0.91F + 0.09F);
		return new Vec3d(f1, f2, f3);
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		return false;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW;
	}

	@Override
	public int getActualHeight() {
		return 256;
	}

	@Override
	public int getSeaLevel() {
		return 63;
	}

	@Override
	public int getMoonPhase(long worldTime) {
		return (int) (worldTime / 24000L % 8L + 8L) % 8;
	}

	@Override
	public float getLightBrightness(int p_227174_1_) {
		return this.lightBrightnessTable[p_227174_1_];
	}

	@Override
	public boolean hasSkyLight() {
		return true;
	}

	@Override
	public boolean isSkyColored() {
		return true;
	}

	@Override
	public void setSkyRenderer(IRenderHandler skyRenderer) {
		super.setSkyRenderer(skyRenderer);
	}

	@Override
	public IRenderHandler getSkyRenderer() {
		return super.getSkyRenderer();
	}
}
