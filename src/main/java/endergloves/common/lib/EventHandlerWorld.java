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

import com.apple.concurrent.Dispatch.Priority;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import endergloves.common.config.ConfigItems;
import endergloves.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EventHandlerWorld
{
	@SubscribeEvent
	public void harvestDrops(BlockEvent.HarvestDropsEvent event)
	{
		boolean shouldDrop = ItemEnderGlove.destroyedWithGloves;

		System.out.println("Well!");
		
		if (event.harvester.inventory.getCurrentItem().getItem().equals(ConfigItems.itemEnderGlove))
		{
			if (!shouldDrop)
				event.drops.clear();
			else
				return;
		}
	}
}
