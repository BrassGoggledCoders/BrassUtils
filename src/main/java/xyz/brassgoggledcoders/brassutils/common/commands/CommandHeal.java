
package xyz.brassgoggledcoders.brassutils.common.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandHeal extends BaseCommand implements ICommand
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (user != null)
				user.heal(user.getMaxHealth());
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
				player.heal(player.getMaxHealth());
		}
	}

	@Override
	public String getCommandName()
	{
		return "heal";
	}

	@Override
	public String getCommandUsage(ICommandSender var1)
	{
		return "/heal [player]";
	}

	@Override
	public int getUserLevelRequired()
	{
		return 1;
	}
}
