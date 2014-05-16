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

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import endergloves.common.config.ConfigItems;

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
		List<ItemStack> drops = event.drops;
		
		if (event.harvester.inventory.getCurrentItem().getItem() == ConfigItems.itemEnderGlove)
			drops.clear();
		else
			return;
	}
}
