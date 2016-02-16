
package xyz.brassgoggledcoders.brassutils.common.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandHome extends BaseCommand implements ICommand
{
	private List<String> aliases;

	public CommandHome()
	{
		this.aliases = new ArrayList<String>();
		this.aliases.add("h");
	}

	@Override
	public List<String> getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
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
		if (user != null && user.getBedLocation(0) != null)
		{
			user.playerNetServerHandler.setPlayerLocation(user.getBedLocation(0).getX(), user.getBedLocation(0).getY(), user.getBedLocation(0).getZ(),
					0, 0);
		}
	}

	@Override
	public String getCommandName()
	{
		return "home";
	}

	@Override
	public String getCommandUsage(ICommandSender var1)
	{
		return "/home";
	}

	@Override
	public int getUserLevelRequired()
	{
		return 0;
	}
}
