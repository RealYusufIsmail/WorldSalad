package com.radioctivetacoo.worldsalad.recipes;

import com.radioctivetacoo.worldsalad.init.RecipeSerializerInit;
import com.radioctivetacoo.worldsalad.recipes.interfaces.IAlloyFurnaceRecipe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

public class AlloyFurnaceRecipe implements IAlloyFurnaceRecipe {

	private final ResourceLocation id;
	private final Ingredient input;
	private final Ingredient input2;
	private final Ingredient input3;
	private final ItemStack output;

	public AlloyFurnaceRecipe(ResourceLocation id, Ingredient input, Ingredient input2, Ingredient input3, ItemStack output) {
		this.id = id;
		this.output = output;
		this.input = input;
		this.input2 = input2;
		this.input3 = input3;
	}

	@Override
	public boolean matches(RecipeWrapper inv, World worldIn) {
		if (this.input.test(inv.getStackInSlot(0)) && this.input2.test(inv.getStackInSlot(1)) && this.input3.test(inv.getStackInSlot(2))) {
			return true;
		}
		return false;
	}

	@Override
	public ItemStack getCraftingResult(RecipeWrapper inv) {
		return this.output;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return this.output;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return RecipeSerializerInit.ALLOY_FURNACE_SERIALIZER.get();
	}

	@Override
	public Ingredient getInput() {
		return this.input;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return NonNullList.from(null, this.input);
	}

	@Override
	public Ingredient getInput2() {
		return this.input2;
	}

	@Override
	public Ingredient getInput3() {
		return this.input3;
	}
}
