
package brassutils.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.oredict.OreDictionary;

import boilerplate.common.baseclasses.items.BaseMetadataItemBlock;
import boilerplate.common.utils.helpers.RegistryHelper;
import brassutils.common.block.BlockCrystal;
import brassutils.common.block.BlockEnderTotem;
import brassutils.common.block.BlockEngravedVanilla;
import brassutils.common.block.BlockEtherium;
import brassutils.common.block.BlockFeathers;
import brassutils.common.block.BlockFusedQuartz;
import brassutils.common.block.BlockGrassCover;
import brassutils.common.block.BlockLamp;
import brassutils.common.block.BlockLeafCover;
import brassutils.common.block.BlockRedstoneSand;
import brassutils.common.block.BlockTotemTop;
import brassutils.common.block.BlockTurf;
import brassutils.common.block.TileCrystal;
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
	public static Block blockFeathers, blockRedstoneSand, blockFusedQuartz;
	/*
	 * public static Block modularTNT; Block splitterTNT; Block jumpPad,
	 * stickyBlock; Block fuse; Block bonePile, boneBlock; Block
	 * sugarcaneBundle; Block polishedEndstone, polishedObsidian; Block bedroll;
	 * Block paperPane; Block stonePillar; Block antigravField, lowGravField;
	 * Block concrete, rebar; Block ender; Block netherBrickChest;
	 */

	Fluid quarryFluid;
	Block blockQuarryFluid;

	public static Block blockEnderTotem, blockTotemTop;

	public static Block blockCrystal;

	public static Block blockEtherium;

	public static Block blockEngravedVanilla;

	public static Block blockLamp, blockLampOn;

	public static void init()
	{
		initializeBlocks();
	}

	public static void initializeBlocks()
	{
		blockTurf = new BlockTurf(Material.grass);
		blockLeafCover = new BlockLeafCover(Material.leaves);
		blockGrassCover = new BlockGrassCover(Material.grass);
		GameRegistry.registerBlock(blockTurf, ItemBlockTurf.class, "BlockTurf");
		GameRegistry.registerBlock(blockLeafCover, ItemBlockLeafCover.class, "BlockLeafCover");
		GameRegistry.registerBlock(blockGrassCover, "BlockGrassCover");
		blockEnderTotem = new BlockEnderTotem().setBlockName("blockEnderTotem");
		blockTotemTop = new BlockTotemTop().setBlockName("blockEnderTotemTop");
		GameRegistry.registerBlock(blockEnderTotem, "BlockEnderTotem");
		GameRegistry.registerBlock(blockTotemTop, "BlockEnderTotemTop");
		blockFeathers = new BlockFeathers(Material.cloth).setBlockName("blockFeathers");
		GameRegistry.registerBlock(blockFeathers, "BlockFeathers");
		OreDictionary.registerOre("wool", blockFeathers);
		OreDictionary.registerOre("wool", Blocks.wool);
		blockRedstoneSand = new BlockRedstoneSand().setBlockName("blockRedstoneSand").setCreativeTab(BrassUtils.tabBU);
		GameRegistry.registerBlock(blockRedstoneSand, "BlockRedstoneSand");
		blockFusedQuartz = new BlockFusedQuartz(Material.glass).setBlockName("blockFusedQuartz");
		GameRegistry.registerBlock(blockFusedQuartz, "BlockFusedQuartz");

		blockEngravedVanilla = new BlockEngravedVanilla().setBlockName("blockEngravedVanilla");
		GameRegistry.registerBlock(blockEngravedVanilla, BaseMetadataItemBlock.class, "BlockEngravedVanilla");

		blockLamp = new BlockLamp(false).setBlockName("blockLamp");
		blockLampOn = new BlockLamp(true).setBlockName("blockLamp");
		GameRegistry.registerBlock(blockLamp, "BlockLamp");
		GameRegistry.registerBlock(blockLampOn, "BlockLampOn");

		blockCrystal = new BlockCrystal().setBlockName("blockCrystal");

		RegistryHelper.registerContainerBlock(blockCrystal, TileCrystal.class, "BlockCrystal");

		blockEtherium = new BlockEtherium(Material.iron).setBlockName("blockEtherium");
		GameRegistry.registerBlock(blockEtherium, "BlockEtherium");
	}
}
