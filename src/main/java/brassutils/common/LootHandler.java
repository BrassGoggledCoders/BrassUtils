/**
 * This class was created by <MrArcane111> or his SC2 development team.
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 * Steamcraft 2 is based on the original Steamcraft created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 *
 * Some code is derived from PowerCraft created by MightyPork which is registered
 * under the MMPL v1.0.
 * PowerCraft (c) MightyPork 2012
 *
 * File created @ [10 Apr 2014, 21:07:58]
 */
package brassutils.common;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;

import net.minecraftforge.common.ChestGenHooks;

/**
 * @author warlordjones
 *
 *         10 Apr 201421:07:58
 */
public class LootHandler
{

	/**
	 *
	 */
	public static void registerLootSpawns()
	{
		registerBonusChestSpawns();
	}

	/**
	 *
	 */
	private static void registerBonusChestSpawns()
	{
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Blocks.anvil), 400, 1, 30));

	}
}
