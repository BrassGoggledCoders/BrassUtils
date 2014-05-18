/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:26:54 PM] 
 */
package endergloves.common.lib;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import endergloves.common.EnderGloves;
import endergloves.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EventHandlerWorld
{
	public static boolean timesUp = false;

	// TODO: The Ender Glove only places a single stack associated with a block into the Ender Chest.
	// Thus, if I destroyed wheat with the Ender Glove, either the wheat OR the seeds will be placed
	// into the chest, but not both. I hope to fix this issue by some later update. It is not very
	// pressing at the moment because it doesn't really affect game-play that much. (Why would you be
	// destroying wheat with your Ender Glove anyway?)

	@SubscribeEvent
	public void harvestDrops(BlockEvent.HarvestDropsEvent event)
	{	
		EntityPlayer player = event.harvester;

		if ((event.drops != null) && (event.drops.size() > 0) && (Utils.isCarryingGlove(player)))
			event.drops.clear();
		else
			return;
	}

	@SubscribeEvent
	public void playerDrops(PlayerDropsEvent event)
	{
		Iterator iterator = event.drops.iterator();

		while (iterator.hasNext())
		{
			EntityItem entItem = (EntityItem)iterator.next();
			ItemStack is = entItem.getEntityItem();

			if ((is != null) && (is.getItem() instanceof ItemEnderGlove))
			{
				is.damageItem(1, event.entityPlayer);
				InventoryHelper.addItemStackToInventory(InventoryHelper.getPlayerEnderChest(event.entityPlayer), is);
				Utils.sendMessage(event.entityPlayer, "\2475Your Ender Glove was succesfully put in your Ender Chest!");
				Utils.playSFX(event.entityPlayer.worldObj, (int)entItem.prevPosX, (int)entItem.prevPosY, (int)entItem.prevPosZ, "mob.endermen.portal");
				entItem.setDead();
			}
		}
	}

	// TODO: Grab a better instance of the EntityPlayer here. Additionally, make it check that the
	// thrower of the item is also the owner so as to go to the proper Ender chest inventory.

	//@SubscribeEvent
	public void itemExpire(ItemExpireEvent event) 
	{
		EntityItem entItem = event.entityItem;
		String name = entItem.getEntityData().getString("Thrower");

		if ((entItem.getEntityItem() != null) && (entItem.getEntityItem().getItem() instanceof ItemEnderGlove)) 
		{
			this.timesUp = true;
			event.setCanceled(true);
		}
		else
		{
			return;
		}
	}	
}
