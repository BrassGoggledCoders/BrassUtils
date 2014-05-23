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

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import enderglove.common.block.BlockEnderTotem;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class ConfigBlocks
{
	public static Block blockEnderTotem;
	
	public static void init()
	{
		initializeBlocks();
		registerBlocks();
		registerTileEntities();
	}
	
	public static void initializeBlocks()
	{
		blockEnderTotem = new BlockEnderTotem().setBlockName("endertotem");
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(blockEnderTotem, "BlockEnderTotem");
	}
	
	public static void registerTileEntities()
	{
		
	}
}
