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
import enderglove.common.item.ItemEnderPocket;
import enderglove.common.lib.LibInfo;

/**
 * @author Surseance (Johnny Eatmon)
 * Email: surseance@autistici.org
 *
 */
public class ConfigItems
{
	public static Item itemEnderGlove, itemEnderPocket;

	public static void init()
	{
		initializeItems();
		registerItems();
	}

	public static void initializeItems()
	{
		itemEnderGlove = new ItemEnderGlove().setUnlocalizedName("itemEnderglove");
		itemEnderPocket = new ItemEnderPocket().setUnlocalizedName("itemEnderpocket");
	}

	public static void registerItems()
	{
		GameRegistry.registerItem(itemEnderGlove, "ItemEnderGlove", LibInfo.ID);
		GameRegistry.registerItem(itemEnderPocket, "ItemEnderPocket", LibInfo.ID);
	}
}
