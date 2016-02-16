
package xyz.brassgoggledcoders.brassutils.common.lib;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import xyz.brassgoggledcoders.boilerplate.lib.common.utils.InventoryUtils;
import xyz.brassgoggledcoders.boilerplate.lib.common.utils.PlayerUtils;
import xyz.brassgoggledcoders.brassutils.common.InitConfig;
import xyz.brassgoggledcoders.brassutils.common.InitItems;
import xyz.brassgoggledcoders.brassutils.common.item.ItemEnderGlove;

public class BrassEventHandler
{
	Random rand = new Random();

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void itemCrafted(ItemCraftedEvent event)
	{
		Random random = event.player.worldObj.rand;
		ItemStack heldItem = event.player.inventory.getCurrentItem();
		int artisanAmount = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchArtisanId, heldItem);

		if ((heldItem != null) && (heldItem.getItem() instanceof ItemEnderGlove) && (artisanAmount > 0))
		{
			IInventory craft = event.craftMatrix;
			int randomSlot = random.nextInt(8);

			if (craft.getStackInSlot(randomSlot) != null)
			{
				ItemStack stack = craft.getStackInSlot(randomSlot);

				if ((random.nextInt(InitConfig.artisanBonusChance) == 0) && (stack.stackSize < stack.getMaxStackSize()))
				{
					craft.decrStackSize(randomSlot, -1);
				}
			}
		}
	}

	@SubscribeEvent
	public void onLivingDrops(LivingDropsEvent event)
	{
		if (InitConfig.extraBlockDrops)
		{
			if (event.entityLiving instanceof EntityAnimal)
			{
				event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ,
						new ItemStack(Items.bone, this.rand.nextInt(3) * event.lootingLevel, 1)));
			}
			else if (event.entityLiving instanceof EntityCreeper)
			{
				if (this.rand.nextInt(50) > 5)
				{
					event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY,
							event.entityLiving.posZ, new ItemStack(Blocks.tnt, this.rand.nextInt(1) + event.lootingLevel, 1)));
				}
			}
			else if (event.entityLiving instanceof EntityEnderman)
			{
				EntityEnderman enderman = (EntityEnderman) event.entityLiving;
				event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ,
						enderman.getHeldItem()));
			}
		}
		else if ((event.entityLiving instanceof EntityDragon) && InitConfig.dragonDrop)
		{
			event.entityLiving.dropItem(InitItems.itemEnderGlove, 1);
		}
		if (event.source.getEntity() instanceof EntityPlayer)
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

	@SubscribeEvent
	public void onBonemealed(BonemealEvent event)
	{
		BlockPos posUp = new BlockPos(event.pos.getX(), event.pos.getY() + 2, event.pos.getZ());
		if ((event.world.getBlockState(event.pos).getBlock().getMaterial() == Material.water) && (this.rand.nextInt(5) == 0)
				&& event.world.isAirBlock(posUp))
		{
			event.world.setBlockState(posUp, Blocks.waterlily.getDefaultState());
		}
		event.entityPlayer.inventory.consumeInventoryItem(event.entityPlayer.getHeldItem().getItem());
	}

	@SubscribeEvent
	public void harvestBlockDrops(BlockEvent.HarvestDropsEvent event)
	{
		if (InitConfig.extraBlockDrops)
		{
			if (event.state == Blocks.mob_spawner)
			{
				event.drops.add(new ItemStack(Items.skull, 1, this.rand.nextInt(5)));
			}
			else if ((event.state == Blocks.dirt) || (event.state == Blocks.grass))
			{
				int random = this.rand.nextInt(80);
				ItemStack[] items = new ItemStack[] { new ItemStack(Items.bone), new ItemStack(Items.flint), new ItemStack(Items.bowl),
						new ItemStack(Items.map), new ItemStack(Items.stick), new ItemStack(Blocks.planks), new ItemStack(Items.skull) };
				if (random < items.length)
				{
					event.drops.add(items[random]);
				}
			}
			else if ((event.state == Blocks.leaves) || (event.state == Blocks.leaves2))
			{
				if (this.rand.nextInt(10) == 0)
				{
					event.drops.add(new ItemStack(Items.stick, this.rand.nextInt(3)));
				}
			}
		}
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
				if ((event.state == Blocks.dirt) || (event.state == Blocks.grass) || (event.state == Blocks.stone))
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
	public void onBlockBreak(BlockEvent.BreakEvent event)
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
	public void onEnderTeleport(EnderTeleportEvent event)
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
	public void onPlayerDrops(PlayerDropsEvent event)
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
				PlayerUtils.sendMessage(event.entityPlayer,
						EnumChatFormatting.DARK_PURPLE + is.getDisplayName() + " was succesfully saved to your Ender Chest!");
				// boilerplate.common.utils.Utils.playSFX(event.entityPlayer.worldObj,
				// (int) entItem.prevPosX, (int) entItem.prevPosY,
				// (int) entItem.prevPosZ, "mob.endermen.portal");
				entItem.setDead();
			}
		}
	}

	public int ticksSinceLastKill;
	public int entitiesKilled;

	public void onLivingDeath(LivingDeathEvent event)
	{
		if (event.source.getDamageType() == "player")
		{
			EntityPlayer cause = (EntityPlayer) event.source.getEntity();
			this.ticksSinceLastKill = 0;
			this.entitiesKilled++;
			cause.addExperienceLevel(300);
		}
	}

	public void onPlayerUpdate(LivingUpdateEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			this.ticksSinceLastKill++;
			System.out.print(this.ticksSinceLastKill);
			System.out.print(this.entitiesKilled);
			if ((this.ticksSinceLastKill == 0) && (this.entitiesKilled == 2))
			{
				player.addChatMessage(new ChatComponentText("Works"));
				System.out.print("Works");
			}
			/*
			 * else { entitiesKilled--; }
			 */
		}
	}

	@SubscribeEvent
	public void onLivingSpawn(LivingSpawnEvent event)
	{
		int chance = event.world.rand.nextInt(1000);
		int armorType = event.world.rand.nextInt(2);

		if (chance < 1)
			if ((event.entityLiving instanceof EntityZombie) || (event.entityLiving instanceof EntitySkeleton))
			{
				int sword = event.world.rand.nextInt(100);
				int helmet = event.world.rand.nextInt(100);
				int chestplate = event.world.rand.nextInt(100);
				int leggings = event.world.rand.nextInt(100);
				int boots = event.world.rand.nextInt(100);

				if (armorType == 0)
				{
					if ((event.entityLiving instanceof EntityZombie) && (sword < 50))
						event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(InitItems.swordEtherium));
					if (helmet < 50)
						event.entityLiving.setCurrentItemOrArmor(1, new ItemStack(InitItems.helmetEtherium));
					if (chestplate < 50)
						event.entityLiving.setCurrentItemOrArmor(2, new ItemStack(InitItems.chestplateEtherium));
					if (leggings < 50)
						event.entityLiving.setCurrentItemOrArmor(3, new ItemStack(InitItems.legsEtherium));
					if (boots < 50)
						event.entityLiving.setCurrentItemOrArmor(4, new ItemStack(InitItems.bootsEtherium));
				}
				else if (armorType == 1)
				{
					if ((event.entityLiving instanceof EntityZombie) && (sword < 50))
						event.entityLiving.setCurrentItemOrArmor(0, new ItemStack(InitItems.swordObsidian));
					if (helmet < 50)
						event.entityLiving.setCurrentItemOrArmor(1, new ItemStack(InitItems.helmetObsidian));
					if (chestplate < 50)
						event.entityLiving.setCurrentItemOrArmor(2, new ItemStack(InitItems.chestplateObsidian));
					if (leggings < 50)
						event.entityLiving.setCurrentItemOrArmor(3, new ItemStack(InitItems.legsObsidian));
					if (boots < 50)
						event.entityLiving.setCurrentItemOrArmor(4, new ItemStack(InitItems.bootsObsidian));
				}
			}
	}
}
