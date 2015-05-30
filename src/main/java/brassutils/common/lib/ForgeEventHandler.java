package brassutils.common.lib;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.BlockEvent;

import boilerplate.common.utils.InventoryUtils;
import boilerplate.common.utils.PlayerUtils;
import brassutils.common.InitConfig;
import brassutils.common.InitItems;
import brassutils.common.item.ItemEnderGlove;

public class ForgeEventHandler
{
	Random rand = new Random();

	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event)
	{
		if (event.entityLiving instanceof EntityAnimal)
		{
			event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ,
					new ItemStack(Items.bone, this.rand.nextInt(3) * event.lootingLevel, 1)));
		}
		if (event.entityLiving instanceof EntityCreeper)
		{
			if (this.rand.nextInt(50) > 5)
			{
				event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY,
						event.entityLiving.posZ, new ItemStack(Blocks.tnt, this.rand.nextInt(1) + event.lootingLevel, 1)));
			}
		}
		if (event.entityLiving instanceof EntityEnderman)
		{
			EntityEnderman enderman = (EntityEnderman) event.entityLiving;
			event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ,
					enderman.getHeldItem()));
		}
	}

	@SubscribeEvent
	public void onBonemealed(BonemealEvent event)
	{
		if ((event.world.getBlock(event.x, event.y + 1, event.z).getMaterial() == Material.water) && (this.rand.nextInt(5) == 0)
				&& event.world.isAirBlock(event.x, event.y + 2, event.z))
		{
			event.world.setBlock(event.x, event.y + 2, event.z, Blocks.waterlily);
		}
		event.entityPlayer.inventory.consumeInventoryItem(event.entityPlayer.getHeldItem().getItem());
	}

	@SubscribeEvent
	public void harvestBlockDrops(BlockEvent.HarvestDropsEvent event)
	{
		if (event.block == Blocks.mob_spawner)
		{
			event.drops.add(new ItemStack(Items.skull, 1, this.rand.nextInt(5)));
		}
		else if ((event.block == Blocks.dirt) || (event.block == Blocks.grass))
		{
			int random = this.rand.nextInt(80);
			ItemStack[] items = new ItemStack[] { new ItemStack(Items.bone), new ItemStack(Items.flint), new ItemStack(Items.bowl),
					new ItemStack(Items.map), new ItemStack(Items.stick), new ItemStack(Blocks.planks), new ItemStack(Items.skull) };
			if (random < items.length)
			{
				event.drops.add(items[random]);
			}
		}
	}

	@SubscribeEvent
	public void harvestDrops(BlockEvent.HarvestDropsEvent event)
	{
		EntityPlayer player = event.harvester;

		if ((event.drops != null) && (event.drops.size() > 0) && (Utils.isCarryingGlove(player)))
		{
			event.drops.clear();
		}

		if (Utils.isCarryingGlove(player))
		{
			int prosAmount = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchProspectorId, player.inventory.getCurrentItem());
			if (prosAmount > 0)
			{
				if ((event.block == Blocks.dirt) || (event.block == Blocks.grass) || (event.block == Blocks.stone))
				{
					Random rand = new Random();
					if (rand.nextInt(10 - prosAmount) == 0)
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
		if ((event.entityLiving instanceof EntityDragon) && InitConfig.dragonDrop)
		{
			event.entityLiving.dropItem(InitItems.itemEnderGlove, 1);
		}
	}

	@SubscribeEvent
	public void blockBreak(BlockEvent.BreakEvent event)
	{
		EntityPlayer player = event.getPlayer();
		int affAmount = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchAffluencyId, player.inventory.getCurrentItem());

		if (event.getExpToDrop() > 0)
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
		if (!event.entityLiving.worldObj.isRemote)
		{
			if (event.entityLiving instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) event.entityLiving;
				int teleAmount = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchTeleportId, player.inventory.getCurrentItem());

				if ((Utils.isCarryingGlove(player)) && (teleAmount > 0))
				{
					if (!event.entityLiving.worldObj.isRemote)
					{
						event.attackDamage = 10.0F;
					}
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
			EntityItem entItem = iterator.next();
			ItemStack is = entItem.getEntityItem();

			if ((is != null) && (is.getItem() instanceof ItemEnderGlove))
			{
				is.damageItem(2, event.entityPlayer);
				InventoryUtils.addItemStackToInventory(InventoryUtils.getPlayerEnderChest(event.entityPlayer), is);
				PlayerUtils.sendMessage(event.entityPlayer, EnumChatFormatting.DARK_PURPLE + is.getDisplayName()
						+ " was succesfully saved to your Ender Chest!");
				boilerplate.common.utils.Utils.playSFX(event.entityPlayer.worldObj, (int) entItem.prevPosX, (int) entItem.prevPosY,
						(int) entItem.prevPosZ, "mob.endermen.portal");
				entItem.setDead();
			}
		}
	}

	@SubscribeEvent
	public void livingDrops(LivingDropsEvent event)
	{
		if ((event.source.getEntity() != null) && (event.source.getEntity() instanceof EntityPlayer))
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			Iterator<EntityItem> iterator = event.drops.iterator();
			while (iterator.hasNext())
			{
				EntityItem entItem = iterator.next();
				ItemStack is = entItem.getEntityItem();

				if (is != null)
				{
					InventoryUtils.addItemStackToInventory(InventoryUtils.getPlayerEnderChest(player), is);
					entItem.setDead();
				}
			}
		}
	}
}
