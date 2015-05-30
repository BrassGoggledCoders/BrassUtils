package brassutils.common.commands;

import java.util.Arrays;

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
		if (getUserLevelRequired() == 1)
		{
			if (isUserLevelSufficient(sender.getCommandSenderName(), getUserLevelRequired())
					|| isUserLevelSufficient(sender.getCommandSenderName(), getUserLevelRequired()))
				executeCommand(sender, stringarray);
			else
				throw new PermissionsException("No Permissions", new Object[0]);
		}
		else if (getUserLevelRequired() == 2)
		{
			if (isUserLevelSufficient(sender.getCommandSenderName(), getUserLevelRequired()))
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

	public static boolean isUserLevelSufficient(String playerName, int userLevel)
	{
		if (userLevel == 1)
		{
			if (Config.modArray == null)
				return false;
			if (Arrays.asList(Config.modArray).contains(playerName))
				return true;
		}
		else if (userLevel == 2)
		{
			if (Config.adminArray == null)
				return false;
			if (Arrays.asList(Config.adminArray).contains(playerName))
				return true;
		}
		return false;
	}
}
