package com.radioctivetacoo.worldsalad.init;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.recipes.AlloyFurnaceRecipe;
import com.radioctivetacoo.worldsalad.recipes.DeepFryerRecipe;
import com.radioctivetacoo.worldsalad.recipes.FloatationBinRecipe;
import com.radioctivetacoo.worldsalad.recipes.HydraulicPressRecipe;
import com.radioctivetacoo.worldsalad.recipes.IndustrialGrinderRecipe;
import com.radioctivetacoo.worldsalad.recipes.KilnRecipe;
import com.radioctivetacoo.worldsalad.recipes.LesserInfuserRecipe;
import com.radioctivetacoo.worldsalad.recipes.SpinningWheelRecipe;
import com.radioctivetacoo.worldsalad.recipes.interfaces.IAlloyFurnaceRecipe;
import com.radioctivetacoo.worldsalad.recipes.interfaces.IDeepFryerRecipe;
import com.radioctivetacoo.worldsalad.recipes.interfaces.IFloatationBinRecipe;
import com.radioctivetacoo.worldsalad.recipes.interfaces.IHydraulicPressRecipe;
import com.radioctivetacoo.worldsalad.recipes.interfaces.IIndustrialGrinderRecipe;
import com.radioctivetacoo.worldsalad.recipes.interfaces.IKilnRecipe;
import com.radioctivetacoo.worldsalad.recipes.interfaces.ILesserInfuserRecipe;
import com.radioctivetacoo.worldsalad.recipes.interfaces.ISpinningWheelRecipe;
import com.radioctivetacoo.worldsalad.recipes.serializers.AlloyFurnaceRecipeSerializer;
import com.radioctivetacoo.worldsalad.recipes.serializers.DeepFryerRecipeSerializer;
import com.radioctivetacoo.worldsalad.recipes.serializers.FloatationBinRecipeSerializer;
import com.radioctivetacoo.worldsalad.recipes.serializers.HydraulicPressRecipeSerializer;
import com.radioctivetacoo.worldsalad.recipes.serializers.IndustrialGrinderRecipeSerializer;
import com.radioctivetacoo.worldsalad.recipes.serializers.KilnRecipeSerializer;
import com.radioctivetacoo.worldsalad.recipes.serializers.LesserInfuserRecipeSerializer;
import com.radioctivetacoo.worldsalad.recipes.serializers.SpinningWheelRecipeSerializer;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unchecked")
public class RecipeSerializerInit {

	public static final IRecipeSerializer<DeepFryerRecipe> DEEP_FRYER_RECIPE_SERIALIZER = new DeepFryerRecipeSerializer();
	public static final IRecipeType<DeepFryerRecipe> DEEP_FRYER_TYPE = registerType(IDeepFryerRecipe.RECIPE_TYPE_ID);
	public static final IRecipeSerializer<SpinningWheelRecipe> SPINNING_WHEEL_RECIPE_SERIALIZER = new SpinningWheelRecipeSerializer();
	public static final IRecipeType<SpinningWheelRecipe> SPINNING_WHEEL_TYPE = registerType(ISpinningWheelRecipe.RECIPE_TYPE_ID);
	public static final IRecipeSerializer<KilnRecipe> KILN_RECIPE_SERIALIZER = new KilnRecipeSerializer();
	public static final IRecipeType<KilnRecipe> KILN_TYPE = registerType(IKilnRecipe.RECIPE_TYPE_ID);
	public static final IRecipeSerializer<LesserInfuserRecipe> LESSER_INFUSER_RECIPE_SERIALIZER = new LesserInfuserRecipeSerializer();
	public static final IRecipeType<LesserInfuserRecipe> LESSER_INFUSER_TYPE = registerType(ILesserInfuserRecipe.RECIPE_TYPE_ID);
	public static final IRecipeSerializer<HydraulicPressRecipe> HYDRAULIC_PRESS_RECIPE_SERIALIZER = new HydraulicPressRecipeSerializer();
	public static final IRecipeType<HydraulicPressRecipe> HYDRAULIC_PRESS_TYPE = registerType(IHydraulicPressRecipe.RECIPE_TYPE_ID);
	public static final IRecipeSerializer<AlloyFurnaceRecipe> ALLOY_FURNACE_RECIPE_SERIALIZER = new AlloyFurnaceRecipeSerializer();
	public static final IRecipeType<AlloyFurnaceRecipe> ALLOY_FURNACE_TYPE = registerType(IAlloyFurnaceRecipe.RECIPE_TYPE_ID);
	public static final IRecipeSerializer<IndustrialGrinderRecipe> INDUSTRIAL_GRINDER_RECIPE_SERIALIZER = new IndustrialGrinderRecipeSerializer();
	public static final IRecipeType<IndustrialGrinderRecipe> INDUSTRIAL_GRINDER_TYPE = registerType(IIndustrialGrinderRecipe.RECIPE_TYPE_ID);
	public static final IRecipeSerializer<FloatationBinRecipe> FLOATATION_BIN_RECIPE_SERIALIZER = new FloatationBinRecipeSerializer();
	public static final IRecipeType<FloatationBinRecipe> FLOATATION_BIN_TYPE = registerType(IFloatationBinRecipe.RECIPE_TYPE_ID);

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = new DeferredRegister<>(
			ForgeRegistries.RECIPE_SERIALIZERS, WorldSalad.MOD_ID);

	public static final RegistryObject<IRecipeSerializer<?>> DEEP_FRYER_SERIALIZER = RECIPE_SERIALIZERS
			.register("deepfryer", () -> DEEP_FRYER_RECIPE_SERIALIZER);

	public static final RegistryObject<IRecipeSerializer<?>> SPINNING_WHEEL_SERIALIZER = RECIPE_SERIALIZERS
			.register("spinningwheel", () -> SPINNING_WHEEL_RECIPE_SERIALIZER);
	
	public static final RegistryObject<IRecipeSerializer<?>> KILN_SERIALIZER = RECIPE_SERIALIZERS
			.register("kiln", () -> KILN_RECIPE_SERIALIZER);
	
	public static final RegistryObject<IRecipeSerializer<?>> LESSER_INFUSER_SERIALIZER = RECIPE_SERIALIZERS
			.register("lesserinfuser", () -> LESSER_INFUSER_RECIPE_SERIALIZER);
	
	public static final RegistryObject<IRecipeSerializer<?>> HYDRAULIC_PRESS_SERIALIZER = RECIPE_SERIALIZERS
			.register("hydraulicpress", () -> HYDRAULIC_PRESS_RECIPE_SERIALIZER);
	
	public static final RegistryObject<IRecipeSerializer<?>> ALLOY_FURNACE_SERIALIZER = RECIPE_SERIALIZERS
			.register("alloyfurnace", () -> ALLOY_FURNACE_RECIPE_SERIALIZER);
	
	public static final RegistryObject<IRecipeSerializer<?>> INDUSTRIAL_GRINDER_SERIALIZER = RECIPE_SERIALIZERS
			.register("industrialgrinder", () -> INDUSTRIAL_GRINDER_RECIPE_SERIALIZER);
	
	public static final RegistryObject<IRecipeSerializer<?>> FLOATATION_BIN_SERIALIZER = RECIPE_SERIALIZERS
			.register("floatationbin", () -> FLOATATION_BIN_RECIPE_SERIALIZER);

	private static class RecipeType<T extends IRecipe<?>> implements IRecipeType<T> {
		@Override
		public String toString() {
			return Registry.RECIPE_TYPE.getKey(this).toString();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) {
		return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RecipeType<>());
	}

}
