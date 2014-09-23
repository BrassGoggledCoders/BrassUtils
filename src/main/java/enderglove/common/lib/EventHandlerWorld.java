/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package enderglove.common.lib;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import enderglove.common.InitItems;
import enderglove.common.config.Config;
import enderglove.common.item.ItemEnderGlove;

/**
 * @author Surseance
 *
 */
public class EventHandlerWorld
{
	@SubscribeEvent
	public void harvestDrops(BlockEvent.HarvestDropsEvent event)
	{
		EntityPlayer player = event.harvester;

		if((event.drops != null) && (event.drops.size() > 0) && (Utils.isCarryingGlove(player)))
			event.drops.clear();

		if(Utils.isCarryingGlove(player))
		{
			int prosAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchProspectorId, player.inventory.getCurrentItem());
			if(prosAmount > 0)
			{
				if(event.block == Blocks.dirt || event.block == Blocks.grass || event.block == Blocks.stone)
				{
					Random rand = new Random();
					if(rand.nextInt(10 - prosAmount) == 0)
					{
						event.drops.add(new ItemStack(Items.gold_nugget, 1 + rand.nextInt(3 + prosAmount), 1));
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEnderDragonKilled(LivingDropsEvent event)
	{
		if((event.entityLiving instanceof EntityDragon) && Config.dragonDrop)
		{
			event.entityLiving.dropItem(InitItems.itemEnderGlove, 1);
		}
	}

	@SubscribeEvent
	public void blockBreak(BlockEvent.BreakEvent event)
	{
		EntityPlayer player = event.getPlayer();
		int affAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchAffluencyId, player.inventory.getCurrentItem());

		if(event.getExpToDrop() > 0)
		{
			int XP = event.getExpToDrop();
			int affXP = XP + ((affAmount * affAmount) / 2);

			event.setExpToDrop(affXP);
		}
	}

	@SideOnly(Side.SERVER)
	@SubscribeEvent
	public void enderTeleport(EnderTeleportEvent event)
	{
		if(!event.entityLiving.worldObj.isRemote)
		{
			if(event.entityLiving instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) event.entityLiving;
				int teleAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchTeleportId, player.inventory.getCurrentItem());

				if((Utils.isCarryingGlove(player)) && (teleAmount > 0))
				{
					if(!event.entityLiving.worldObj.isRemote)
						event.attackDamage = 10.0F;
				}
			}
		}
	}

	@SubscribeEvent
	public void playerDrops(PlayerDropsEvent event)
	{
		Iterator<EntityItem> iterator = event.drops.iterator();
		while(iterator.hasNext())
		{
			EntityItem entItem = iterator.next();
			ItemStack is = entItem.getEntityItem();

			if((is != null) && (is.getItem() instanceof ItemEnderGlove))
			{
				is.damageItem(2, event.entityPlayer);
				InventoryUtils.addItemStackToInventory(InventoryUtils.getPlayerEnderChest(event.entityPlayer), is);
				PlayerUtils.sendMessage(event.entityPlayer, EnumChatFormatting.DARK_PURPLE + is.getDisplayName()
						+ " was succesfully saved to your Ender Chest!");
				boilerplate.common.utils.Utils.playSFX(event.entityPlayer.worldObj, (int) entItem.prevPosX, (int) entItem.prevPosY, (int) entItem.prevPosZ,
						"mob.endermen.portal");
				entItem.setDead();
			}
		}
	}

	@SubscribeEvent
	public void livingDrops(LivingDropsEvent event)
	{
		if((event.source.getEntity() != null) && (event.source.getEntity() instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			Iterator<EntityItem> iterator = event.drops.iterator();
			while(iterator.hasNext())
			{
				EntityItem entItem = iterator.next();
				ItemStack is = entItem.getEntityItem();

				if(is != null)
				{
					InventoryUtils.addItemStackToInventory(InventoryUtils.getPlayerEnderChest(player), is);
					entItem.setDead();
				}
			}
		}
	}

	// livingDrops

	// @SubscribeEvent
	public void livingUpdate(LivingEvent.LivingUpdateEvent event)
	{
	}
}
