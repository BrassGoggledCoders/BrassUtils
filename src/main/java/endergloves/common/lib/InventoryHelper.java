/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:08:06 PM] 
 */
package endergloves.common.lib;

import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDurability;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class InventoryHelper
{
	private static Random random = new Random();

	//@Deprecated
	public static InventoryEnderChest getPlayerEnderChest(EntityPlayer player)
	{
		return player.getInventoryEnderChest();
	}

	public static boolean addItemToEnderInventory(ItemStack is)
	{
		
		return false;
	}	
	
	/**
	 * Determines if a specific item is in the player's inventory.
	 * 
	 * @param player - the player with the inventory to check
	 * @param item - the item stack to look for
	 * @return - the slot in which the specified item sits
	 */
	public static int isInPlayerInventory(EntityPlayer player, Item item)
	{
		for (int slot = 0; slot < player.inventory.mainInventory.length; slot++)
		{
			if ((player.inventory.mainInventory[slot] != null) && (player.inventory.mainInventory[slot].getItem() == item))
				return slot;
		}

		return -1;
	}
}
