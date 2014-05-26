/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:20:10 PM]
 */
package enderglove.common.config;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import enderglove.common.item.ItemEnderGlove;
import enderglove.common.lib.LibInfo;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 * 
 */
public class ConfigItems
{
	public static Item itemEnderGlove;

	public static void init()
	{
		initializeItems();
		registerItems();
	}

	public static void initializeItems()
	{
		itemEnderGlove = new ItemEnderGlove().setUnlocalizedName("enderglove");
	}

	public static void registerItems()
	{
		GameRegistry.registerItem(itemEnderGlove, "ItemEnderGlove", LibInfo.ID);
	}
}
