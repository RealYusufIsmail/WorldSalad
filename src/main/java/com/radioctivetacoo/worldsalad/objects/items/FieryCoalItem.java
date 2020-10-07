package com.radioctivetacoo.worldsalad.objects.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FieryCoalItem extends Item {

	public FieryCoalItem(Properties properties) {
		super(properties);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 3200;
	}
}
