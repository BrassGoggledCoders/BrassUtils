
package xyz.brassgoggledcoders.brassutils.common.lib;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import xyz.brassgoggledcoders.brassutils.common.item.ItemEnderGlove;

/**
 * @author Surseance
 *
 */
public class Utils
{
	public static boolean isCarryingGlove(EntityPlayer player)
	{
		if ((player != null) && (player.inventory.getCurrentItem() != null)
				&& (player.inventory.getCurrentItem().getItem() instanceof ItemEnderGlove))
		{
			return true;
		}

		return false;
	}

	public static ItemStack createStackedBlock(Block block, int metadata)
	{
		int md = 0;
		Item item = Item.getItemFromBlock(block);

		if ((item != null) && item.getHasSubtypes())
		{
			md = metadata;
		}

		return new ItemStack(item, 1, md);
	}

	public static ItemStack createStackedBlock()
	{
		return new ItemStack(Blocks.redstone_ore);
	}
}
