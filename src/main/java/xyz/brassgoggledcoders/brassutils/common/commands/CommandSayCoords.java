
package xyz.brassgoggledcoders.brassutils.common.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

public class CommandSayCoords extends BaseCommand implements ICommand
{
	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
	{
		// EntityPlayerMP player = getCommandSenderAsPlayer(sender);
		BlockPos coords = sender.getCommandSenderEntity().getPosition();
		MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentText(sender.getName() + " is at X: "
				+ String.valueOf(coords.getX()) + " Y: " + String.valueOf(coords.getY()) + " Z: " + String.valueOf(coords.getZ())));
	}

	@Override
	public String getCommandName()
	{
		return "saycoords";
	}

	@Override
	public String getCommandUsage(ICommandSender var1)
	{
		return "/saycoords";
	}
}
