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

import net.minecraft.init.Items;
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
		int slot = random.nextInt(8);

		if (event.craftMatrix.getStackInSlot(slot) != null)
		{
			ItemStack stackInSlot = event.craftMatrix.getStackInSlot(slot);

			if (stackInSlot != null)
			{
				ItemStack result = new ItemStack(stackInSlot.copy().getItem(), 1);
				
				if (stackInSlot.isItemDamaged())
					result.damageItem(stackInSlot.getItemDamage(), event.player);
				
				event.craftMatrix.setInventorySlotContents(slot, result);
			}
		}      
	}
}
