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

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

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

		if (!player.worldObj.isRemote)
			player.addChatMessage(chat);
	}

	public static ItemStack getDroppedItemStack(World world, EntityLivingBase entityLiving, Block block, int x, int y, int z)
	{
		ArrayList<ItemStack>drops = block.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), EnchantmentHelper.getFortuneModifier(entityLiving));
		ItemStack is = (ItemStack)drops.get(0);

		return is;
	}
}
