package com.radioctivetacoo.worldsalad.util.enums;

import java.util.function.Supplier;

import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterials implements IArmorMaterial {
	
	STEEL(WorldSalad.MOD_ID + ":steel", 24, new int[] {3, 5, 7, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1F, () -> {
		return Ingredient.fromItems(ItemInit.STEEL_INGOT.get());
	}),
	
	TITANIUM(WorldSalad.MOD_ID + ":titanium", 41, new int[] {4, 7, 10, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2F, () -> {
		return Ingredient.fromItems(ItemInit.TITANIUM_INGOT.get());
	}),
	
	CHITIN(WorldSalad.MOD_ID + ":scleritome", 23, new int[] {3, 5, 7, 3}, 23, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F, () -> {
		return Ingredient.fromItems(ItemInit.CRYSTAL_SCLERITE.get());
	}),
	
	TRAVELER(WorldSalad.MOD_ID + ":traveler", 10, new int[] {1, 1, 1, 1}, 55, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0F, () -> {
		return Ingredient.fromItems(ItemInit.EXTREMOPLASM.get());
	});
	
	private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final LazyValue<Ingredient> repairMaterial;
	
	private ModArmorMaterials(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
		this.name = nameIn;
		this.maxDamageFactor = maxDamageFactorIn;
		this.damageReductionAmountArray = damageReductionAmountIn;
		this.enchantability = enchantabilityIn;
		this.soundEvent = soundEventIn;
		this.toughness = toughnessIn;
		this.repairMaterial = new LazyValue<>(repairMaterialIn);
	}
	
	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.getValue();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}
}
