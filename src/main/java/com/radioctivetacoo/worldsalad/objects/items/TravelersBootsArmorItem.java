package com.radioctivetacoo.worldsalad.objects.items;

import com.radioctivetacoo.worldsalad.init.ItemInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class TravelersBootsArmorItem extends ArmorItem {

	public TravelersBootsArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
	{		
		if(player.inventory.armorItemInSlot(0).getItem() == ItemInit.TRAVELERS_BOOTS.get())
		{
			if(!player.isPotionActive(Effects.SPEED))
			{
				player.addPotionEffect(new EffectInstance(Effects.SPEED, 1, 0, false, false, false));
			}
			if(!player.isPotionActive(Effects.JUMP_BOOST))
			{
				player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 1, 1, false, false, false));
			}
		}
	}
}
