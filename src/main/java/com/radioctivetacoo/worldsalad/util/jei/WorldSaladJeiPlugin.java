package com.radioctivetacoo.worldsalad.util.jei;

import com.radioctivetacoo.worldsalad.WorldSalad;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.util.ResourceLocation;

//[WIP]
@JeiPlugin
public class WorldSaladJeiPlugin implements IModPlugin {
	
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(WorldSalad.MOD_ID, "main");
	}
}
