package brassutils.common.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;

import brassutils.common.config.Config;

public class BaseCommand extends CommandBase implements ICommand
{

	@Override
	public String getCommandName()
	{
		return "";
	}

	@Override
	public String getCommandUsage(ICommandSender var1)
	{
		return "";
	}

	/**
	 *
	 * Return the required permission level for this command.
	 */
	@Override
	public int getRequiredPermissionLevel()
	{
		return 0;
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		if (icommandsender instanceof EntityPlayer)
			return true;
		else
		{
			throw new WrongUsageException("Command can only be executed by player", new Object[0]);
		}
	}

	@Override
	public void processCommand(ICommandSender sender, String[] stringarray)
	{
		// TODO
		if (getUserLevelRequired() == 1)
		{
			if (isUserLevelSufficient(sender.getCommandSenderName(), Config.modArray)
					|| isUserLevelSufficient(sender.getCommandSenderName(), Config.adminArray))
				executeCommand(sender, stringarray);
			else
				throw new PermissionsException("No Permissions", new Object[0]);
		}
		else if (getUserLevelRequired() == 2)
		{
			if (isUserLevelSufficient(sender.getCommandSenderName(), Config.adminArray))
				executeCommand(sender, stringarray);
			else
				throw new PermissionsException("No Permissions", new Object[0]);
		}
		else
		{
			executeCommand(sender, stringarray);
		}
	}

	public int getUserLevelRequired()
	{
		return 0;
	}

	public void executeCommand(ICommandSender sender, String[] stringarray)
	{

	}

	public static boolean isUserLevelSufficient(String inputString, String[] items)
	{
		for (int i = 0; i < items.length; i++)
		{
			if (inputString.equals(items[i]))
			{
				return true;
			}
		}
		return false;
	}
}
