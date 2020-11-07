package com.radioctivetacoo.worldsalad.objects.items.buckets;

import com.radioctivetacoo.worldsalad.init.FluidInit;

import net.minecraft.item.BucketItem;

public class AcidBucketItem extends BucketItem {

	public AcidBucketItem(Properties properties) {
		super(FluidInit.ACID_FLUID, properties);
	}
}
