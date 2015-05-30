package brassutils.common.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandHome extends BaseCommand implements ICommand
{
	private List<String> aliases;

	public CommandHome()
	{
		this.aliases = new ArrayList<String>();
		aliases.add("h");
	}

	@Override
	public List<String> getCommandAliases()
	{
		return aliases;
	}

	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
	{
		EntityPlayerMP user = getCommandSenderAsPlayer(sender);
		if (user.getBedLocation(0) != null)
			user.playerNetServerHandler
					.setPlayerLocation(user.getBedLocation(0).posX, user.getBedLocation(0).posY, user.getBedLocation(0).posZ, 0, 0);
		else
			throw new NotFoundException();
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
