/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:26:45 PM] 
 */
package endergloves.common.lib;

import java.util.Random;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EventHandlerEntity
{
	Random random = new Random();

	@SubscribeEvent
	public void itemCrafted(PlayerEvent.ItemCraftedEvent event)
	{
		IInventory craft = event.craftMatrix;
		int randomSlot = random.nextInt(8);

		if (craft.getStackInSlot(randomSlot) != null)
		{
			ItemStack result = new ItemStack(craft.getStackInSlot(randomSlot).getItem(), 2);
			craft.setInventorySlotContents(randomSlot, result);
		}   
	}
}
