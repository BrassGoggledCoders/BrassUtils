
package xyz.brassgoggledcoders.brassutils.common.commands;

import java.util.Arrays;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

import xyz.brassgoggledcoders.brassutils.common.InitConfig;

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
			return false;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] stringarray) throws PermissionsException
	{
		if (this.getUserLevelRequired() == 1)
		{
			if (isUserLevelSufficient(sender.getCommandSenderEntity().getName(), this.getUserLevelRequired())
					|| isUserLevelSufficient(sender.getCommandSenderEntity().getName(), this.getUserLevelRequired()))
			{
				this.executeCommand(sender, stringarray);
			}
			else
			{
				throw new PermissionsException("No Permissions", new Object[0]);
			}
		}
		else if (this.getUserLevelRequired() == 2)
		{
			if (isUserLevelSufficient(sender.getCommandSenderEntity().getName(), this.getUserLevelRequired()))
			{
				this.executeCommand(sender, stringarray);
			}
			else
			{
				throw new PermissionsException("No Permissions", new Object[0]);
			}
		}
		else
		{
			this.executeCommand(sender, stringarray);
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
			if (Arrays.asList(InitConfig.modArray).contains(playerName) || Arrays.asList(InitConfig.adminArray).contains(playerName))
			{
				return true;
			}
		}
		else if (userLevel == 2)
		{
			if (Arrays.asList(InitConfig.adminArray).contains(playerName))
			{
				return true;
			}
		}
		return false;
	}
}
