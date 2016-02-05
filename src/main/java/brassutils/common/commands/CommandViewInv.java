
package brassutils.common.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class CommandViewInv extends BaseCommand implements ICommand
{
	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
	{
		EntityPlayerMP player = getPlayer(sender, stringarray[0]);
		// player.inventory.openInventory();
	}

	@Override
	public String getCommandName()
	{
		return "inv";
	}

	@Override
	public String getCommandUsage(ICommandSender var1)
	{
		return "/inv [player]";
	}

	@Override
	public int getUserLevelRequired()
	{
		return 1;
	}
}
