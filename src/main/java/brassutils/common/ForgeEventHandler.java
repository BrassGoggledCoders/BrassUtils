package brassutils.common;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.world.BlockEvent;

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
}
