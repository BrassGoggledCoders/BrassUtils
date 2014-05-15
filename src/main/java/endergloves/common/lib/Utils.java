/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:07:32 PM] 
 */
package endergloves.common.lib;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class Utils
{
	public static void sendMessage(EntityPlayer player, String message)
	{
		IChatComponent chat = new ChatComponentText(message);
		player.addChatMessage(chat);
	}
	
	public static void sendMessageToPlayer(EntityPlayer player, String message, String playerName)
	{
		IChatComponent chat = new ChatComponentText("[" + player.getDisplayName() + "] " + message);
		
		if (player.getDisplayName().equals(playerName))
			player.addChatMessage(chat);
	}	
	
	@Deprecated
	public static InventoryEnderChest getPlayerEnderChest(EntityPlayer player)
	{
		return player.getInventoryEnderChest();
	}
}
