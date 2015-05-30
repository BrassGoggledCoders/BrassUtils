package brassutils.common.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;

public class CommandSayCoords extends BaseCommand implements ICommand
{
	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
	{
		// EntityPlayerMP player = getCommandSenderAsPlayer(sender);
		ChunkCoordinates coords = sender.getPlayerCoordinates();
		MinecraftServer
				.getServer()
				.getConfigurationManager()
				.sendChatMsg(
						new ChatComponentText(sender.getCommandSenderName() + " is at X: " + String.valueOf(coords.posX) + " Y: "
								+ String.valueOf(coords.posY) + " Z: " + String.valueOf(coords.posZ)));
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
