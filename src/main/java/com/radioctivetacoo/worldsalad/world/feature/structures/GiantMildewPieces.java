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

public class GiantMildewPieces {

	private static final ResourceLocation PART_1 = new ResourceLocation(WorldSalad.MOD_ID, "giant_mildew");
	private static final ResourceLocation PART_2 = new ResourceLocation(WorldSalad.MOD_ID, "giant_mildew_lower");
	
	private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(PART_1, new BlockPos(0, 1, 0), PART_2, new BlockPos(0, 2, 0));
	
	public static void Start(TemplateManager manager, BlockPos pos, Rotation rot, List<StructurePiece> pieces, Random rand)
	{
		int x = pos.getX();
		int z = pos.getZ();
		int y = rand.nextInt(11);
		
		BlockPos rotationOffset = new BlockPos(0, -y - 5, 0).rotate(rot);
		BlockPos blockpos =  rotationOffset.add(x, pos.getY(), z);
		pieces.add(new GiantMildewPieces.Piece(manager, PART_1, blockpos, rot));
		BlockPos rotationOffset2 = new BlockPos(0, -y - 17, 0).rotate(rot);
		BlockPos blockpos2 =  rotationOffset2.add(x, pos.getY(), z);
		pieces.add(new GiantMildewPieces.Piece(manager, PART_2, blockpos2, rot));
		BlockPos rotationOffset3 = new BlockPos(0, -y - 29, 0).rotate(rot);
		BlockPos blockpos3 =  rotationOffset3.add(x, pos.getY(), z);
		pieces.add(new GiantMildewPieces.Piece(manager, PART_2, blockpos3, rot));
		BlockPos rotationOffset4 = new BlockPos(0, -y - 41, 0).rotate(rot);
		BlockPos blockpos4 =  rotationOffset4.add(x, pos.getY(), z);
		pieces.add(new GiantMildewPieces.Piece(manager, PART_2, blockpos4, rot));
		BlockPos rotationOffset5 = new BlockPos(0, -y - 53, 0).rotate(rot);
		BlockPos blockpos5 =  rotationOffset5.add(x, pos.getY(), z);
		pieces.add(new GiantMildewPieces.Piece(manager, PART_2, blockpos5, rot));
	}
	
	public static class Piece extends TemplateStructurePiece {
		private ResourceLocation resourceLocation;
		private Rotation rotation;
 
		public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos,
				Rotation rotationIn) {
			super(FeatureInit.GIANT_MILDEW_PIECE, 0);
			this.resourceLocation = resourceLocationIn;
			BlockPos blockpos = GiantMildewPieces.OFFSET.get(resourceLocation);
			this.templatePosition = pos.add(blockpos.getX(), blockpos.getY(), blockpos.getZ());
			this.rotation = rotationIn;
			this.setupPiece(templateManagerIn);
		}
 
		public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
			super(FeatureInit.GIANT_MILDEW_PIECE, tagCompound);
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
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand,
				MutableBoundingBox sbb) {
		}
 
		// create
		@Override
		public boolean create(IWorld worldIn, ChunkGenerator<?> generator, Random randomIn,
				MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkPos) {
			PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation)
					.setMirror(Mirror.NONE);
			BlockPos blockpos = GiantMildewPieces.OFFSET.get(this.resourceLocation);
			this.templatePosition.add(Template.transformedBlockPos(placementsettings,
					new BlockPos(0 - blockpos.getX(), 0, 0 - blockpos.getZ())));
 
			return super.create(worldIn, generator, randomIn, structureBoundingBoxIn, chunkPos);
		}
	}

}
