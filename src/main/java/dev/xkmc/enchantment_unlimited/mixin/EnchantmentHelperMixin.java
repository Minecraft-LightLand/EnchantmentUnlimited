package dev.xkmc.enchantment_unlimited.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

	@Inject(at = @At("HEAD"), method = "getEnchantmentLevel(Lnet/minecraft/nbt/CompoundTag;)I", cancellable = true)
	private static void enchantment_unlimited$getEnchantmentLevel(CompoundTag tag, CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(Mth.clamp(tag.getInt("lvl"), 0, Integer.MAX_VALUE));
	}

}
