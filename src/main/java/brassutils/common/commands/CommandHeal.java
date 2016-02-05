
package brassutils.common.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandHeal extends BaseCommand implements ICommand
{
	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
	{
		if (stringarray.length <= 0)
		{
			EntityPlayerMP user = getCommandSenderAsPlayer(sender);
			user.heal(user.getMaxHealth());
		}
		else
		{
			EntityPlayerMP player = getPlayer(sender, stringarray[0]);
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
