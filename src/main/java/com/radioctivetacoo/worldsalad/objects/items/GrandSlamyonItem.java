package com.radioctivetacoo.worldsalad.objects.items;

import java.util.List;

import com.google.common.collect.Multimap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GrandSlamyonItem extends Item {
	
	private List<LivingEntity> entitiesInRange;

	public GrandSlamyonItem(Properties properties) {
		super(properties);
	}
	
	private void ability(LivingEntity entityIn) {
		if (entityIn.onGround) {
	      entityIn.addPotionEffect(new EffectInstance(Effects.LEVITATION, 7, 20));
	      entityIn.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 7, 50));
	      entityIn.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1));
		}
	   }

	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
	      @SuppressWarnings("deprecation")
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
	      if (equipmentSlot == EquipmentSlotType.MAINHAND) {
	         multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 10.0D, AttributeModifier.Operation.ADDITION));
	         multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)-3.5F, AttributeModifier.Operation.ADDITION));
	      }
	      return multimap;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
			ItemStack itemstack = playerIn.getHeldItem(handIn);
			if (!worldIn.isRemote) {
					playerIn.getCooldownTracker().setCooldown(this, 400);
					itemstack.damageItem(5, playerIn, (p_220017_1_) -> {
			            p_220017_1_.sendBreakAnimation(handIn);
			         });
					worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.PLAYERS, 0.5F, 1F);
					BlockPos blockpos = new BlockPos(playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ());
			    	 AxisAlignedBB axisalignedbb = (new AxisAlignedBB(blockpos)).grow(6.0D);
			         this.entitiesInRange = worldIn.getEntitiesWithinAABB(LivingEntity.class, axisalignedbb);
			         this.entitiesInRange.stream().filter(LivingEntity -> !(LivingEntity instanceof PlayerEntity)).forEach(this::ability);
			}
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}
	
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
	      stack.damageItem(1, attacker, (p_220048_0_) -> {
	         p_220048_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
	      });
	      return true;
	   }
	
	public int getItemEnchantability() {
	      return 1;
	}
}
