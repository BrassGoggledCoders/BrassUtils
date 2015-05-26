/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.common;

import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;

import brassutils.common.item.ItemEnderGlove;
import brassutils.common.item.ItemEnderPocket;
import brassutils.common.lib.LibInfo;

/**
 * @author Surseance
 *
 */
public class InitItems
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
