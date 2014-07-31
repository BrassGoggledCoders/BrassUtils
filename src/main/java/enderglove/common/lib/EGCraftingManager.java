/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:27:33 PM]
 */
package enderglove.common.lib;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import enderglove.common.config.ConfigItems;

/**
 * @author Surseance (Johnny Eatmon)
 * Email: surseance@autistici.org
 *
 */
public class EGCraftingManager
{
	public static void init()
	{
		/*if (Config.line1 != null && Config.line2 != null && Config.line3 != null)
		{
			FMLLog.severe(Config.line1.toString());
			GameRegistry.addShapedRecipe(new ItemStack(ConfigItems.itemEnderGlove), new Object[] {
				Config.line1,
				Config.line2,
				Config.line3, 'L',
				Items.leather, 'N',
				Items.nether_star, 'E',
				Items.ender_eye
			});

		}
		else
		{*/
			GameRegistry.addRecipe(new ItemStack(ConfigItems.itemEnderGlove), new Object[] {"EEE", "LNL", "LLL", 'L', Items.leather, 'N', Items.nether_star, 'E', Items.ender_eye});
		//}
	}

	/*, 'P',
	Items.ender_pearl, 'B', Items.blaze_rod, 'D',
	Blocks.dragon_egg, 'S', Blocks.end_stone, 'd',
	Blocks.diamond_block, 'b', Blocks.obsidian*/
}