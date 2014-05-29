/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:07:32 PM]
 */
package enderglove.common.lib;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import enderglove.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon)
 * Email: surseance@autistici.org
 *
 */
public class Utils
{
	/**
	 * Determines whether the player is wearing an instance of an Ender Glove.
	 *
	 * @param player - the player carrying the item
	 *
	 * @return false if not carrying
	 */
	public static boolean isCarryingGlove(EntityPlayer player)
	{
		if (player != null && player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemEnderGlove)
			return true;

		return false;
	}

	/**
	 * Creates a new item-based, metadata-inclusive item stack for the given
	 * block and metadata. Relays the metadata to item subtypes.
	 *
	 * @param block - the block to be converted
	 * @param metadata - the metadata > subtypes
	 *
	 * @return new item stack
	 */
	public static ItemStack createStackedBlock(Block block, int metadata)
	{
		int md = 0;
		Item item = Item.getItemFromBlock(block);

		if (item != null && item.getHasSubtypes())
			md = metadata;

		return new ItemStack(item, 1, md);
	}

	/**
	 * Only used for BlockRedstoneOre. If you use the above method, it'll crash
	 * your game. Guaranteed. Don't believe me? Give it a go.
	 * 
	 * @return new item stack
	 */
	public static ItemStack createStackedBlock()
	{
		return new ItemStack(Blocks.redstone_ore);
	}

	//private boolean handleTileEntities() // TODO: Some handling for TileEntities
	//{
	//	return false;
	//}
}
