/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import cpw.mods.fml.common.registry.GameRegistry;

import brassutils.common.block.BlockEnderTotem;
import brassutils.common.block.BlockGrassCover;
import brassutils.common.block.BlockTotemTop;
import brassutils.common.block.LeafCoverBlock;
import brassutils.common.block.TurfBlock;
import brassutils.common.item.ItemBlockLeafCover;
import brassutils.common.item.ItemBlockTurf;

/**
 * @author Surseance
 *
 */
public class InitBlocks
{
	public static Block blockTurf;
	public static Block blockLeafCover;
	public static Block blockGrassCover;

	public static Block blockEnderTotem, blockTotemTop;

	public static void init()
	{
		initializeBlocks();
	}

	public static void initializeBlocks()
	{
		blockTurf = new TurfBlock(Material.grass);
		blockLeafCover = new LeafCoverBlock(Material.leaves);
		blockGrassCover = new BlockGrassCover(Material.grass);
		GameRegistry.registerBlock(blockTurf, ItemBlockTurf.class, "BlockTurf");
		GameRegistry.registerBlock(blockLeafCover, ItemBlockLeafCover.class, "BlockLeafCover");
		GameRegistry.registerBlock(blockGrassCover, "BlockGrassCover");
		blockEnderTotem = new BlockEnderTotem().setBlockName("blockEnderTotem");
		blockTotemTop = new BlockTotemTop().setBlockName("blockEnderTotemTop");
		GameRegistry.registerBlock(blockEnderTotem, "BlockEnderTotem");
		GameRegistry.registerBlock(blockTotemTop, "BlockEnderTotemTop");
	}
}
