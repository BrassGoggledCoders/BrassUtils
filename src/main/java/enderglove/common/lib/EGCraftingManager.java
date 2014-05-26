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
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 * 
 */
public class EGCraftingManager
{
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(ConfigItems.itemEnderGlove),
				new Object[] { "EEE", "LNL", "LLL", 'L', Items.leather, 'N',
						Items.nether_star, 'E', Items.ender_eye });
	}
}
