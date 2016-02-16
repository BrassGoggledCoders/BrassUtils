
package xyz.brassgoggledcoders.brassutils.common.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandFeed extends BaseCommand implements ICommand
{
	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
	{
		if (stringarray.length <= 0)
		{
			EntityPlayerMP user = null;
			try
			{
				user = getCommandSenderAsPlayer(sender);
			} catch (PlayerNotFoundException e)
			{
				e.printStackTrace();
			}
			if (user != null)
			{
				user.getFoodStats().setFoodLevel(20);
				user.getFoodStats().setFoodSaturationLevel(5F);
			}
		}
		else
		{
			EntityPlayerMP player = null;
			try
			{
				player = getPlayer(sender, stringarray[0]);
			} catch (PlayerNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (player != null)
			{
				player.getFoodStats().setFoodLevel(20);
				player.getFoodStats().setFoodSaturationLevel(5F);
			}
		}
	}

	@Override
	public String getCommandName()
	{
		return "feed";
	}

	@Override
	public String getCommandUsage(ICommandSender var1)
	{
		return "/feed [player]";
	}

	@Override
	public int getUserLevelRequired()
	{
		return 1;
	}
}
