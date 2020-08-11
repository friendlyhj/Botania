/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package vazkii.botania.common.core;

import net.minecraft.stats.IStatFormatter;
import net.minecraft.util.ResourceLocation;

import vazkii.botania.common.lib.LibMisc;
import vazkii.botania.mixin.AccessorStats;

public class ModStats {
	public static final ResourceLocation CORPOREA_ITEMS_REQUESTED =
			AccessorStats.botania_callRegisterCustom(LibMisc.MOD_ID + ":corporea_items_requested", IStatFormatter.DEFAULT);

	public static void init() {

	}
}