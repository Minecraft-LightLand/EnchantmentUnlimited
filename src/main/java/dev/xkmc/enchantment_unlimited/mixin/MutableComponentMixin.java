package dev.xkmc.enchantment_unlimited.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MutableComponent.class)
public class MutableComponentMixin {

	@Inject(at = @At("HEAD"), method = "create", cancellable = true)
	private static void enchantment_unlimited$create$getEnchantmentLevel(ComponentContents comp, CallbackInfoReturnable<MutableComponent> cir) {
		if (comp instanceof TranslatableContents trans) {
			String key = trans.getKey();
			if (key.startsWith("enchantment.level.")) {
				String num = key.substring(18);
				try {
					int val = Integer.parseInt(num);
					if (val > 10) {
						cir.setReturnValue(Component.literal(num));
					}
				} catch (Exception ignored) {

				}
			}
		}
	}

}
