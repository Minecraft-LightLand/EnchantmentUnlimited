package dev.xkmc.enchantment_unlimited;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EnchantmentUnlimited.MODID)
public class EnchantmentUnlimited {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "enchantment_unlimited";
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();

	public EnchantmentUnlimited() {
		ModConfig.init();
	}

}
