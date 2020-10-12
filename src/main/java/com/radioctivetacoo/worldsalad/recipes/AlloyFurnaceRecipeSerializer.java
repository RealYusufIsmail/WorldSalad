package com.radioctivetacoo.worldsalad.recipes;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class AlloyFurnaceRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
		implements IRecipeSerializer<AlloyFurnaceRecipe> {

	@Override
	public AlloyFurnaceRecipe read(ResourceLocation recipeId, JsonObject json) {
		ItemStack output = CraftingHelper.getItemStack(JSONUtils.getJsonObject(json, "output"), true);
		Ingredient input = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input"));
		Ingredient input2 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input2"));
		Ingredient input3 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "input3"));

		return new AlloyFurnaceRecipe(recipeId, input, input2, input3, output);
	}

	@Override
	public AlloyFurnaceRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
		ItemStack output = buffer.readItemStack();
		Ingredient input = Ingredient.read(buffer);
		Ingredient input2 = Ingredient.read(buffer);
		Ingredient input3 = Ingredient.read(buffer);

		return new AlloyFurnaceRecipe(recipeId, input, input2, input3, output);
	}

	@Override
	public void write(PacketBuffer buffer, AlloyFurnaceRecipe recipe) {
		Ingredient input = recipe.getIngredients().get(0);
		Ingredient input2 = recipe.getIngredients().get(1);
		Ingredient input3 = recipe.getIngredients().get(2);
		input.write(buffer);
		input2.write(buffer);
		input3.write(buffer);

		buffer.writeItemStack(recipe.getRecipeOutput(), false);
	}

}
