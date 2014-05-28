/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:19:09 PM]
 */
package enderglove.common.config;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import enderglove.common.block.BlockEnderTotem;
import enderglove.common.block.BlockTotemTop;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
public class ConfigBlocks
{
	public static Block blockEnderTotem, blockTotemTop;

	public static void init()
	{
		initializeBlocks();
		registerBlocks();
		registerTileEntities();
	}

	public static void initializeBlocks()
	{
		blockEnderTotem = new BlockEnderTotem().setBlockName("endertotem");
		blockTotemTop = new BlockTotemTop().setBlockName("endertotemtop");
	}

	public static void registerBlocks()
	{
		GameRegistry.registerBlock(blockEnderTotem, "BlockEnderTotem");
		GameRegistry.registerBlock(blockTotemTop, "blockTotemTop");
	}

	public static void registerTileEntities()
	{

	}
}
