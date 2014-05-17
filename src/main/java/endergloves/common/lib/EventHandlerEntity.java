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

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import endergloves.common.config.Config;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EventHandlerEntity
{
	@SubscribeEvent
	public void itemCrafted(PlayerEvent.ItemCraftedEvent event)
	{
		ItemStack currentItem = event.player.inventory.getCurrentItem();
		ItemStack result = event.crafting;
		
		int artisanAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchArtisanId, currentItem);
		
		if (artisanAmount > 0)
		{
			result.copy().equals(new ItemStack(result.getItem(), 2));
		}
	}
}
