/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package enderglove.common;

import net.minecraft.block.Block;

import cpw.mods.fml.common.registry.GameRegistry;

import enderglove.common.block.BlockEnderTotem;
import enderglove.common.block.BlockTotemTop;

/**
 * @author Surseance
 *
 */
public class InitBlocks
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
