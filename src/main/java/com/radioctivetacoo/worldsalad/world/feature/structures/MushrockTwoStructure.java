package com.radioctivetacoo.worldsalad.world.feature.structures;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.radioctivetacoo.worldsalad.WorldSalad;

import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MushrockTwoStructure extends Structure<NoFeatureConfig> {

	public MushrockTwoStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator<?> generatorIn, Random randIn, int chunkX, int chunkZ, Biome biomeIn) {
		ChunkPos pos = this.getStartPositionForPosition(generatorIn, randIn, chunkX, chunkZ, 0, 0);
		if(chunkX == pos.x && chunkZ == pos.z)
		{
			if(generatorIn.hasStructure(biomeIn, this))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public IStartFactory getStartFactory() {
		return MushrockTwoStructure.Start::new;
	}

	@Override
	public String getStructureName() {
		return WorldSalad.MOD_ID + ":mushrock2";
	}
	
	@Override
	protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> chunkGenerator, Random random, int x, int z, int spacingOffsetsX, int spacingOffsetsZ) {
		int maxDistance = 6;
		int minDistance = 1;
		
		int xTemp = x + maxDistance * spacingOffsetsX;
		int ztemp = z + maxDistance * spacingOffsetsZ;
		int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
		int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
		int validChunkX = xTemp2 / maxDistance;
		int validChunkZ = zTemp2 / maxDistance;
		 
		((SharedSeedRandom) random).setLargeFeatureSeedWithSalt(chunkGenerator.getSeed(), validChunkX, validChunkZ, this.getSeedModifier());
		validChunkX = validChunkX * maxDistance;
		validChunkZ = validChunkZ * maxDistance;
		validChunkX = validChunkX + random.nextInt(maxDistance - minDistance);
		validChunkZ = validChunkZ + random.nextInt(maxDistance - minDistance);
		
		return new ChunkPos(validChunkX, validChunkZ);
	}
	
	

	protected int getSeedModifier() {
		return 111142069;
	}

	//unused
	@Override
	public int getSize() {
		return 0;
	}
	
	public static class Start extends StructureStart {

		public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox,
				int reference, long seed) {
			super(structure, chunkX, chunkZ, boundingBox, reference, seed);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ,
				Biome biomeIn) {
			Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
			
			int x = (chunkX << 4) + 7;
			int z = (chunkZ << 4) + 7;
			int y = generator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
			BlockPos pos = new BlockPos(x, y, z);
			
			MushrockTwoPieces.Start(templateManagerIn, pos, rotation, this.components, this.rand);
			
			this.recalculateStructureSize();
		}
		
	}

}
