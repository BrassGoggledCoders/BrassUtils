/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:26:45 PM]
 */
package enderglove.common.lib;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import enderglove.common.config.Config;
import enderglove.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
public class EventHandlerEntity
{
	public static boolean playerDead = false;
	Random random = new Random();
	@SubscribeEvent
	public void enderTeleport(EnderTeleportEvent event)
	{
		//Tell me there is a better way to do this, pl0x
		Iterator<?> i = event.entityLiving.worldObj.playerEntities.iterator();
		while(i.hasNext())
		{
			EntityPlayer player = (EntityPlayer) i.next();
			if(Utils.isCarryingGlove(player))
			{
			AxisAlignedBB axisalignedbb = AxisAlignedBB.getAABBPool().getAABB((double)player.posX, (double)player.posY, (double)player.posZ, (double)(player.posX + 1), (double)(player.posY + 1), (double)(player.posY + 1)).expand(30, 30, 30);
			List<EntityEnderman> l = player.worldObj.getEntitiesWithinAABB(EntityEnderman.class, axisalignedbb);
			Iterator<EntityEnderman> i2 = l.iterator();
			while(i2.hasNext())
			{
			i2.next();
			event.setCanceled(true);
			}
		}
		}
	}
	/*Broken \/
	@SubscribeEvent
	public void livingDropsEvent(LivingDropsEvent event)
	{
		Iterator<EntityItem> iterator = event.drops.iterator();
		while (iterator.hasNext())
		{
			EntityItem entItem = (EntityItem) iterator.next();
			ItemStack is = entItem.getEntityItem();
			if(is.getItem() == Items.blaze_rod)
			{
				event.setCanceled(true);
			}
		}
	}*/
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void itemCrafted(PlayerEvent.ItemCraftedEvent event)
	{
		ItemStack heldItem = event.player.inventory.getCurrentItem();
		int artisanAmount = EnchantmentHelper.getEnchantmentLevel(
				Config.enchArtisanId, heldItem);

		if (heldItem != null && heldItem.getItem() instanceof ItemEnderGlove
				&& artisanAmount > 0)
		{
			IInventory craft = event.craftMatrix;
			int randomSlot = random.nextInt(8);

			if (craft.getStackInSlot(randomSlot) != null)
			{
				ItemStack result = new ItemStack(craft
						.getStackInSlot(randomSlot).copy().getItem(), 2);

				if (random.nextInt(Config.artisanBonusChance) == 0)
				{
					craft.setInventorySlotContents(randomSlot, result);
					heldItem.damageItem(1, event.player);
				}
			}
		}
	}
}
