package dev.xkmc.enchantment_unlimited;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class MagicReductionCalculation {

	public static float calculateMagicAbsorb(LivingEntity entity, DamageSource source, float amount) {
		return (float) (amount * Math.exp(-getReduction(entity, source)));
	}

	public static double getReduction(LivingEntity entity, DamageSource source) {
		if (source.isBypassMagic()) {
			return 0;
		}
		double reduction = 0;
		var eff = entity.getEffect(MobEffects.DAMAGE_RESISTANCE);
		if (eff != null && source != DamageSource.OUT_OF_WORLD) {
			reduction += (eff.getAmplifier() + 1) * ModConfig.COMMON.potionReduction.get();
		}
		if (source.isBypassEnchantments()) {
			return reduction;
		}
		int k = EnchantmentHelper.getDamageProtection(entity.getArmorSlots(), source);
		if (k > 0) {
			reduction += k * ModConfig.COMMON.enchantmentReduction.get();
		}
		return reduction;
	}

}
