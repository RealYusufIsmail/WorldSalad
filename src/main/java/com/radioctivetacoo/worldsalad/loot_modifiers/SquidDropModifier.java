package com.radioctivetacoo.worldsalad.loot_modifiers;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.conditions.ILootCondition;
import net.minecraftforge.common.loot.LootModifier;

public class SquidDropModifier extends LootModifier {

	protected SquidDropModifier(ILootCondition[] conditionsIn) {
		super(conditionsIn);
	}

	@Override
	protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
