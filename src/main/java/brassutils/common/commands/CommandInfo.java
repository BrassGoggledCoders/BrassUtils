package brassutils.common.commands;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CommandInfo extends BaseCommand implements ICommand
{
	@Override
	public void executeCommand(ICommandSender sender, String[] stringarray)
	{
		if (stringarray.length == 0)
		{
			throw new WrongUsageException("Command usage is /info <target>. Available targets are: 'player' and 'world'", new Object[0]);
		}
		if (stringarray[0].contains("player"))
		{
			EntityPlayerMP user = getCommandSenderAsPlayer(sender);
			sender.addChatMessage(new ChatComponentText("Saturation: " + String.valueOf(user.getFoodStats().getSaturationLevel())));
			sender.addChatMessage(new ChatComponentText("IP: " + String.valueOf(user.getPlayerIP())));
			sender.addChatMessage(new ChatComponentText("Score: " + String.valueOf(user.getScore())));
		}
		else if (stringarray[0].contains("world"))
		{
			World world = sender.getEntityWorld();
			sender.addChatMessage(new ChatComponentText("Seed: " + world.getSeed()));
			sender.addChatMessage(new ChatComponentText("World Name: " + world.getWorldInfo().getWorldName()));
			sender.addChatMessage(new ChatComponentText("World Time: " + world.getWorldInfo().getWorldTime()));
			sender.addChatMessage(new ChatComponentText("World Spawn Pos: X: " + world.getWorldInfo().getSpawnX() + " Y: "
					+ world.getWorldInfo().getSpawnY() + " Z: " + world.getWorldInfo().getSpawnZ()));
		}
		else
		{
			throw new WrongUsageException("Could not get info about specified thing", new Object[0]);
		}
	}

	@Override
	public String getCommandName()
	{
		return "info";
	}

	@Override
	public String getCommandUsage(ICommandSender var1)
	{
		return "/info <target>";
	}
}
