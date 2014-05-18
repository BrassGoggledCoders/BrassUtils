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

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import endergloves.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EventHandlerWorld
{
	// TODO: The Ender Glove only places a single stack associated with a block into the Ender Chest.
	// Thus, if I destroyed wheat with the Ender Glove, either the wheat OR the seeds will be placed
	// into the chest, but not both. I hope to fix this issue by some later update. It is not very
	// pressing at the moment because it doesn't really affect game-play that much. (Why would you be
	// destroying wheat with your Ender Glove anyway?)
	
	@SubscribeEvent
	public void harvestDrops(BlockEvent.HarvestDropsEvent event)
	{	
		EntityPlayer player = event.harvester;
		
		if ((event.drops != null) && (event.drops.size() > 0) && (this.isCarryingGlove(player)))
			event.drops.clear();
		else
			return;
	}
	
	public boolean isCarryingGlove(EntityPlayer player)
	{
		if ((player != null) && (player.inventory.getCurrentItem() != null) && (player.inventory.getCurrentItem().getItem() instanceof ItemEnderGlove))
			return true;
		
		return false;
	}
	
	@SubscribeEvent
	public void itemToss(ItemTossEvent event)
	{
		System.out.println("WOOF");
		EntityItem entItem = event.entityItem;
		
		if ((entItem.getEntityItem() != null) && (entItem.getEntityItem().getItem() instanceof ItemEnderGlove) && (entItem.age > 4800)) 
		{
			InventoryHelper.addItemStackToInventory(InventoryHelper.getPlayerEnderChest(event.player), entItem.getEntityItem());
			Utils.sendMessage(event.player, "Your Ender Glove is safe and sound!");
			entItem.setDead();
		}
	}	
}
