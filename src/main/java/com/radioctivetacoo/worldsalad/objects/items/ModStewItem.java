package com.radioctivetacoo.worldsalad.objects.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class ModStewItem extends Item {

	public ModStewItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	
	@Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return entityLiving instanceof PlayerEntity && ((PlayerEntity)entityLiving).abilities.isCreativeMode ? stack : new ItemStack(Items.BOWL);
    }

}
