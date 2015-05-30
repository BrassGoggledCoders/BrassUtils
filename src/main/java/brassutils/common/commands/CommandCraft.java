package brassutils.common.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandCraft extends BaseCommand implements ICommand
{
	private List<String> aliases;

	public CommandCraft()
	{
		this.aliases = new ArrayList<String>();
		this.aliases.add("crafting");
	}

	@Override
	public List<String> getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
	{
		EntityPlayerMP user = getCommandSenderAsPlayer(sender);
		user.displayGUIWorkbench(user.serverPosX, user.serverPosY, user.serverPosZ);
	}

	@Override
	public String getCommandName()
	{
		return "craft";
	}

	@Override
	public String getCommandUsage(ICommandSender var1)
	{
		return "/craft";
	}

	@Override
	public int getUserLevelRequired()
	{
		return 1;
	}
}
