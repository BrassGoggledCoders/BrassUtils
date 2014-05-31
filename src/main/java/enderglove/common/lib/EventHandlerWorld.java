/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:26:54 PM]
 */
package enderglove.common.lib;

import java.util.Iterator;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import boilerplate.common.utils.InventoryUtils;
import boilerplate.common.utils.PlayerUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enderglove.common.config.Config;
import enderglove.common.config.ConfigItems;
import enderglove.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon)
 * Email: surseance@autistici.org
 *
 */
public class EventHandlerWorld
{
	@SubscribeEvent
	public void harvestDrops(BlockEvent.HarvestDropsEvent event)
	{
		EntityPlayer player = event.harvester;

		if ((event.drops != null) && (event.drops.size() > 0) && (Utils.isCarryingGlove(player)))
			event.drops.clear();
	}

	@SubscribeEvent
	public void onEnderDragonKilled(LivingDropsEvent event)
	{
		if (event.entityLiving instanceof EntityDragon && Config.dragonDrop)
		{
			event.entityLiving.dropItem(ConfigItems.itemEnderGlove, 1);
		}
	}

	@SubscribeEvent
	public void blockBreak(BlockEvent.BreakEvent event)
	{
		EntityPlayer player = event.getPlayer();
		int affAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchAffluencyId, player.inventory.getCurrentItem());

		if (event.getExpToDrop() > 0)
		{
			int XP = event.getExpToDrop();
			int affXP = XP + affAmount * affAmount / 2;

			event.setExpToDrop(affXP);
		}
	}

	@SideOnly(Side.SERVER)
	@SubscribeEvent
	public void enderTeleport(EnderTeleportEvent event)
	{
		if (!event.entityLiving.worldObj.isRemote)
		{
			if (event.entityLiving instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)event.entityLiving;
				int teleAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchTeleportId, player.inventory.getCurrentItem());

				if ((Utils.isCarryingGlove(player)) && (teleAmount > 0))
				{
					if (!event.entityLiving.worldObj.isRemote)
						event.attackDamage = 10.0F;
				}
			}
		}
	}

	@SubscribeEvent
	public void playerDrops(PlayerDropsEvent event)
	{
		Iterator<EntityItem> iterator = event.drops.iterator();
		while (iterator.hasNext())
		{
			EntityItem entItem = (EntityItem)iterator.next();
			ItemStack is = entItem.getEntityItem();

			if ((is != null) && (is.getItem() instanceof ItemEnderGlove))
			{
				is.damageItem(2, event.entityPlayer);
				InventoryUtils.addItemStackToInventory(InventoryUtils.getPlayerEnderChest(event.entityPlayer), is);
				PlayerUtils.sendMessage(event.entityPlayer, EnumChatFormatting.DARK_PURPLE + is.getDisplayName() + " was succesfully saved to your Ender Chest!");
				boilerplate.common.utils.Utils.playSFX(event.entityPlayer.worldObj, (int)entItem.prevPosX, (int)entItem.prevPosY, (int)entItem.prevPosZ, "mob.endermen.portal");
				entItem.setDead();
			}
		}
	}

	//livingDrops

	//@SubscribeEvent
	public void livingUpdate(LivingEvent.LivingUpdateEvent event) {}
}
