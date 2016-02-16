
package xyz.brassgoggledcoders.brassutils.common.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

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
		// TODO
		// EntityPlayerMP user = null;
		// try
		// {
		// user = getCommandSenderAsPlayer(sender);
		// } catch (PlayerNotFoundException e)
		// {
		// e.printStackTrace();
		// }
		// if(user != null)
		// user.displayGui(new GuiCrafting(user.inventory, user.worldObj));
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
