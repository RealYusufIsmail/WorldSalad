package com.radioctivetacoo.worldsalad.world.feature.structures;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.ImmutableMap;
import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.init.FeatureInit;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class OilWellPieces {
	
	private static final ResourceLocation OIL_WELL_SMALL = new ResourceLocation(WorldSalad.MOD_ID, "oil_well_small");
	private static final ResourceLocation OIL_WELL_LARGE = new ResourceLocation(WorldSalad.MOD_ID, "oil_well_large");
	private static ResourceLocation wellType = OIL_WELL_SMALL;
	
	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(OIL_WELL_SMALL, new BlockPos(0, 0, 0), OIL_WELL_LARGE, new BlockPos(0, 1, 0));
	
	public static void setWellType(ResourceLocation type) {
		wellType = type;
	}
	
	public static ResourceLocation getWellType()
	{
		return wellType;
	}
	
	public static void Start(TemplateManager manager, BlockPos pos, Rotation rot, List<StructurePiece> pieces, Random rand)
	{
		int x = pos.getX();
		int z = pos.getZ();
		int generator = rand.nextInt(5);
		if (generator >= 0 && generator <= 3) {setWellType(OIL_WELL_SMALL);}
		else if (generator == 4) {setWellType(OIL_WELL_LARGE);}
		
		BlockPos rotationOffset = new BlockPos(0, -rand.nextInt(20) - 30 , 0).rotate(rot);
		BlockPos blockpos =  rotationOffset.add(x, pos.getY(), z);
		pieces.add(new OilWellPieces.Piece(manager, getWellType(), blockpos, rot));
	}
	
	public static class Piece extends TemplateStructurePiece {
		private ResourceLocation resourceLocation;
		private Rotation rotation;
 
		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
				Rotation rotationIn) {
			super(FeatureInit.OIL_WELL_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
			BlockPos blockpos = OilWellPieces.OFFSET.get(resourceLocation);
			this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
			this.rotation = rotationIn;
			this.setupPiece(templateManagerIn);
		}
 
		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
			super(FeatureInit.OIL_WELL_PIECE, tagCompound);
			this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
			this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
			this.setupPiece(templateManagerIn);
		}
 
		private void setupPiece(TemplateManager templateManager) {
			Template template = templateManager.getTemplateDefaulted(this.resourceLocation);
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
					.setMirror(Mirror.NONE);
			this.setup(template, this.templatePosition, placementsettings);
		}
 
		@Override
		protected void readAdditional(CompoundNBT tagCompound) {
			super.readAdditional(tagCompound);
			tagCompound.putString("Template", this.resourceLocation.toString());
			tagCompound.putString("Rot", this.rotation.name());
		}
 
		@Override
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {
		}
 
		// create
		@Override
		public boolean create(IWorld worldIn, ChunkGenerator<?> generator, Random randomIn,
				MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos) {
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
					.setMirror(Mirror.NONE);
			BlockPos blockpos = OilWellPieces.OFFSET.get(this.resourceLocation);
			this.templatePosition.add(Template.transformedBlockPos(placementsettings,
					new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));
 
			return super.create(worldIn, generator, randomIn, structureBoundingBoxIn, chunkPos);
		}
	}

}
