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

	/**
	 * Checks certain preconditions before determining
	 * whether to insert the item. Handles inventory
	 * updating.
	 * 
	 * @param inventory - the inventory to put the item in
	 * @param is - the item stack to put in the inventory
	 * @param shouldUpdate - should the inventory update
	 * @return - the item stack being inserted (a copy)
	 */
	public static ItemStack addItemStackToInventory(IInventory inventory, ItemStack is, boolean shouldUpdate)
	{
		ItemStack stackCopy = is.copy();
		ItemStack stackToInsert = addStack(inventory, stackCopy, shouldUpdate);

		if ((stackToInsert == null) || (stackToInsert.stackSize == 0))
		{
			if (shouldUpdate) 
				inventory.markDirty();

			return null;
		}

		is = stackToInsert;

		return is.copy();
	}

	/**
	 * Checks the slots for availability before inserting.
	 * Also handles inventory updating.
	 * 
	 * @param inventory - the inventory to put the item in
	 * @param is - the item stack to put in the inventory
	 * @param shouldUpdate - should the inventory update
	 * @return - the item stack being inserted
	 */
	private static ItemStack addStack(IInventory inventory, ItemStack is, boolean shouldUpdate)
	{
		int invSize = inventory.getSizeInventory();

		for (int slot = 0; (slot < invSize) && (is != null) && (is.stackSize > 0); slot++)
		{
			is = attemptInsertion(inventory, is, slot, shouldUpdate);
		}

		if ((is != null) && (is.stackSize == 0))
			is = null;

		return is;
	}

	/**
	 * Actually inserts the item stack into the specified
	 * inventory. Also handles inventory updating.
	 * 
	 * @param inventory - the inventory to put the item in
	 * @param is - the item stack to put in the inventory
	 * @param slot - the slot in which to put the item
	 * @param shouldUpdate - should the inventory update
	 * @return - the item stack being inserted
	 */
	private static ItemStack attemptInsertion(IInventory inventory, ItemStack is, int slot, boolean shouldUpdate)
	{
		ItemStack stackInSlot = inventory.getStackInSlot(slot);

		if (canInsertItemIntoInventory(inventory, is, slot))
		{
			boolean go = false;

			if (stackInSlot == null)
			{
				if (inventory.getInventoryStackLimit() < is.stackSize)
				{
					ItemStack stackToInsert = is.splitStack(inventory.getInventoryStackLimit());

					if (shouldUpdate) 
						inventory.setInventorySlotContents(slot, stackToInsert); 
				}
				else
				{
					if (shouldUpdate) 
						inventory.setInventorySlotContents(slot, is);

					is = null;
				}

				go = true;
			}

			if ((go) && (shouldUpdate))
				inventory.markDirty();
		}

		return is;
	}

	/**
	 * Determines if the specified item stack is appropriate for
	 * the specified inventory.
	 * 
	 * @param inventory - the possibly compatible inventory
	 * @param is - the item stack in question
	 * @param slot - the slot in which to check for compatibility
	 * @return - the isItemValidForSlot boolean
	 */
	public static boolean canInsertItemIntoInventory(IInventory inventory, ItemStack is, int slot)
	{
		return inventory.isItemValidForSlot(slot, is);
	}

	/**
	 * Uses one of the specified items in the player's inventory.
	 * If the player does not have the item, nothing happens.
	 * 
	 * @param player - the player with the inventory to check
	 * @param is - the item stack with an item to consume
	 * @param metadata - the damage (if any) of the item stack
	 * @return - true if uses item, false if not
	 */
	public static boolean useInventoryItem(EntityPlayer player, ItemStack is, int metadata)
	{
		for (int slot = 0; slot < player.inventory.mainInventory.length; slot++)
		{
			if ((player.inventory.mainInventory[slot] == null) || (player.inventory.mainInventory[slot] != is) || (player.inventory.mainInventory[slot].getItemDamage() != metadata))
				continue;

			if (--player.inventory.mainInventory[slot].stackSize <= 0)
				player.inventory.mainInventory[slot] = null;

			return true;
		}

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

	/**
	 * Damages an item stack by a specified amount. Calculates
	 * damage based on enchantments and previous item damage.
	 * 
	 * @param is - the item stack to damage
	 * @param amount - the amount to damage the stack by
	 * @return - the item stack being damaged
	 */
	public static ItemStack damageItem(ItemStack is, int amount)
	{
		if (is.isItemStackDamageable())
		{
			if (amount > 0)
			{
				int enchantLevel = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, is);
				int enchantAmount = 0;

				for (int damage = 0; (enchantLevel > 0) && (damage < amount); damage++)
				{
					if (!EnchantmentDurability.negateDamage(is, enchantLevel, random))
						continue;

					enchantAmount++;
				}

				amount -= enchantAmount;

				if (amount <= 0)
					return is;
			}

			is.setItemDamage(is.getItemDamage() + amount);

			if (is.getItemDamage() > is.getMaxDamage())
			{
				is.stackSize -= 1;

				if (is.stackSize < 0)
					is.stackSize = 0;

				is.setItemDamage(0);
			}
		}

		return is;
	}
}
