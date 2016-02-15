
package brassutils.common.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;

import xyz.brassgoggledcoders.boilerplate.lib.common.utils.PlayerUtils;

/**
 * @author warlordjones
 *
 *         9 Apr 201416:49:19
 */
public class CommandRTD extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "rtd";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "/rtd";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		if (icommandsender instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) icommandsender;
			// cooldown = Cooldown.getCooldown("RTDCooldown",
			// player.getCommandSenderName(), 15000);
			// if(cooldown.getTimeLeft() == 0)
			// {
			/*
			 * Commands that don't work: Tp into air Webbing Zeus Adventuring
			 * Sneaking Seeing crafting table Commands that need tweaks: Potions
			 * should last longer Giving Itemss dosn't work properly Anvil
			 * should disappear
			 */
			int r = (int) ((Math.random() * (30 - 0)) + 0);
			if (r == 1)
			{
				player.addChatMessage(new ChatComponentText("LOL"));
				PlayerUtils.sendChatToServer("Player  " + player.getCommandSenderName() + " rolled the dice and got laughed at");
			}
			else if (r == 2)
			{
				player.curePotionEffects(new ItemStack(Items.milk_bucket));
				PlayerUtils.sendChatToServer("Player  " + player.getCommandSenderName() + " rolled the dice and got cured");
			}
			else if (r == 3)
			{
				player.setPosition(player.posX, 100, player.posZ);
				PlayerUtils.sendChatToServer("Player  " + player.getCommandSenderName() + " rolled the dice and got teleported into the air");
			}
			else if (r == 4)
			{
				player.setFire(100);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and got burnt");
			}
			else if (r == 5)
			{
				player.setSneaking(true);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was forced to sneak for a while");
			}
			else if (r == 6)
			{
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 10));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was blinded");
			}
			else if (r == 7)
			{
				player.addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 10));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was nauseated");
			}
			else if (r == 8)
			{
				player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 100, 10));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and went invisible");
			}
			else if (r == 9)
			{
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 10));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and got regeneration");
			}
			else if (r == 10)
			{
				player.addExhaustion(3000);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and got hungry");
			}
			else if (r == 11)
			{
				if (player.getCurrentArmor(0) != null)
				{
					player.entityDropItem(player.getCurrentArmor(0), 1);
				}
				player.setCurrentItemOrArmor(1, new ItemStack(Blocks.dirt));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and got a dirty head");
			}
			else if (r == 12)
			{
				player.dropOneItem(true);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and dropped what they were holding");
			}
			else if (r == 13)
			{
				player.attackEntityFrom(DamageSource.magic, 10);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was damaged");
			}
			else if (r == 14)
			{
				player.worldObj.createExplosion(player, player.posX, player.posY, player.posZ, 1F, false);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and created an explosion");
			}
			else if (r == 15)
			{
				player.worldObj.getWorldInfo().setRaining(true);
				;
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and toggled the rain");
			}
			else if (r == 16)
			{
				player.inventory.addItemStackToInventory(new ItemStack(Items.apple, 1));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was given an apple");
			}
			else if (r == 17)
			{
				player.inventory.addItemStackToInventory(new ItemStack(Items.stick, 1));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was given a stick");
			}
			else if (r == 18)
			{
				player.inventory.addItemStackToInventory(new ItemStack(Items.gold_nugget, 1));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was given a nugget of gold");
			}
			else if (r == 19)
			{
				player.inventory.addItemStackToInventory(new ItemStack(Items.brick, 1));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was given a brick");
			}
			else if (r == 20)
			{
				player.inventory.addItemStackToInventory(new ItemStack(Blocks.pumpkin, 1));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was given a pumpkin");
			}
			else if (r == 21)
			{
				player.inventory.addItemStackToInventory(new ItemStack(Blocks.tnt, 1));
				PlayerUtils.sendChatToServer(
						"Player " + player.getCommandSenderName() + " rolled the dice and was given some dynamite! Watch out for them!");
			}
			else if (r == 22)
			{
				player.worldObj.setBlock((int) Math.round(player.posX), (int) Math.round(player.posY) + 20, (int) Math.round(player.posZ),
						Blocks.anvil, 2, 2);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and had an anvil dropped on their head");
			}
			else if (r == 23)
			{
				player.extinguish();
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was extinguished");
			}
			else if (r == 24)
			{
				player.setPosition(player.worldObj.getClosestPlayer(player.posX, player.posY, player.posZ, -1).posX,
						player.worldObj.getClosestPlayer(player.posX, player.posY, player.posZ, -1).posY,
						player.worldObj.getClosestPlayer(player.posX, player.posY, player.posZ, -1).posZ);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was teleported to "
						+ player.worldObj.getClosestPlayer(player.posX, player.posY, player.posZ, -1).getCommandSenderName());
			}
			else if (r == 25)
			{
				player.setInWeb();
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and was webbed");
			}
			else if (r == 26)
			{
				if (player.getCurrentArmor(0) != null)
				{
					player.entityDropItem(player.getCurrentArmor(0), 1);
				}
				player.setCurrentItemOrArmor(1, new ItemStack(Blocks.pumpkin));
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and got a pumpkin helmet");
			}
			// else if(r == 27) {player.setGameType();
			// PlayerUtils.sendChatToServer("Player " +
			// player.getCommandSenderName() +
			// " rolled the dice and was made an adventurer");}
			else if (r == 28)
			{
				player.worldObj.setWorldTime(12500);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and set the time to night");
			}
			else if (r == 29)
			{
				Utils.spawnEntityAtCoords(player.worldObj, new EntityPig(player.worldObj), player.serverPosX, player.serverPosY, player.serverPosZ);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and spawned a pig");
			}
			else
			{
				player.addExperience(10);
				PlayerUtils.sendChatToServer("Player " + player.getCommandSenderName() + " rolled the dice and became experienced");
			}
		}
		// }
		// else{
		// EntityPlayer player = (EntityPlayer ) icommandsender;
		// player.addChatMessage("You can't roll the dice again yet. Wait
		// another"
		// + cooldown.getTimeLeft() + "seconds");
		// }
	}
}
