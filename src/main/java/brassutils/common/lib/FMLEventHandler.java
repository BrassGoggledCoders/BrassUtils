/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.common.lib;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

import brassutils.common.InitConfig;
import brassutils.common.item.ItemEnderGlove;

/**
 * @author Surseance
 *
 */
public class FMLEventHandler
{
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void itemCrafted(PlayerEvent.ItemCraftedEvent event)
	{
		Random random = event.player.worldObj.rand;
		ItemStack heldItem = event.player.inventory.getCurrentItem();
		int artisanAmount = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchArtisanId, heldItem);

		if ((heldItem != null) && (heldItem.getItem() instanceof ItemEnderGlove) && (artisanAmount > 0))
		{
			IInventory craft = event.craftMatrix;
			int randomSlot = random.nextInt(8);

			if (craft.getStackInSlot(randomSlot) != null)
			{
				ItemStack stack = craft.getStackInSlot(randomSlot);

				if ((random.nextInt(InitConfig.artisanBonusChance) == 0) && (stack.stackSize < stack.getMaxStackSize()))
				{
					craft.decrStackSize(randomSlot, -1);
				}
			}
		}
	}
}
