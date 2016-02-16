
package xyz.brassgoggledcoders.brassutils.common.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;

public class CommandDeathNote extends BaseCommand
{
	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
	{
		EntityPlayerMP entityplayermp = null;
		try
		{
			entityplayermp = getPlayer(sender, stringarray[0]);
		} catch (PlayerNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (stringarray.length == 2 && entityplayermp != null)
		{
			if (stringarray[1].equalsIgnoreCase("fire"))
			{
				entityplayermp.attackEntityFrom(DamageSource.inFire, Float.MAX_VALUE);
			}
			else if (stringarray[1].equalsIgnoreCase("anvil"))
			{
				entityplayermp.attackEntityFrom(DamageSource.anvil, Float.MAX_VALUE);
			}
			else if (stringarray[1].equalsIgnoreCase("cactus"))
			{
				entityplayermp.attackEntityFrom(DamageSource.cactus, Float.MAX_VALUE);
			}
			else if (stringarray[1].equalsIgnoreCase("drown"))
			{
				entityplayermp.attackEntityFrom(DamageSource.drown, Float.MAX_VALUE);
			}
			else if (stringarray[1].equalsIgnoreCase("fall"))
			{
				entityplayermp.attackEntityFrom(DamageSource.fall, Float.MAX_VALUE);
			}
			else if (stringarray[1].equalsIgnoreCase("suffocation"))
			{
				entityplayermp.attackEntityFrom(DamageSource.inWall, Float.MAX_VALUE);
			}
			else if (stringarray[1].equalsIgnoreCase("lava"))
			{
				entityplayermp.attackEntityFrom(DamageSource.lava, Float.MAX_VALUE);
			}
			else if (stringarray[1].equalsIgnoreCase("magic"))
			{
				entityplayermp.attackEntityFrom(DamageSource.magic, Float.MAX_VALUE);
			}
			else if (stringarray[1].equalsIgnoreCase("starve"))
			{
				entityplayermp.attackEntityFrom(DamageSource.starve, Float.MAX_VALUE);
			}
			else if (stringarray[1].equalsIgnoreCase("wither"))
			{
				entityplayermp.attackEntityFrom(DamageSource.wither, Float.MAX_VALUE);
			}
			else
			{
				entityplayermp.attackEntityFrom(DamageSource.generic, Float.MAX_VALUE);
			}
		}
		else
		{
			entityplayermp.attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
		}
	}

	@Override
	public String getCommandName()
	{
		return "deathnote";
	}

	@Override
	public String getCommandUsage(ICommandSender var1)
	{
		return "/deathnote <player> [cause]";
	}

	@Override
	public int getUserLevelRequired()
	{
		return 1;
	}

}
