
package xyz.brassgoggledcoders.brassutils.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import xyz.brassgoggledcoders.boilerplate.lib.common.blocks.BaseBlock;
import xyz.brassgoggledcoders.boilerplate.lib.common.utils.helpers.RegistryHelper;
import xyz.brassgoggledcoders.brassutils.common.block.BlockCrystal;
import xyz.brassgoggledcoders.brassutils.common.block.BlockEngravedVanilla;
import xyz.brassgoggledcoders.brassutils.common.block.BlockEtherium;
import xyz.brassgoggledcoders.brassutils.common.block.BlockFeathers;
import xyz.brassgoggledcoders.brassutils.common.block.BlockFusedQuartz;
import xyz.brassgoggledcoders.brassutils.common.block.BlockGrassCover;
import xyz.brassgoggledcoders.brassutils.common.block.BlockLamp;
import xyz.brassgoggledcoders.brassutils.common.block.BlockLeafCover;
import xyz.brassgoggledcoders.brassutils.common.block.BlockRedstoneSand;
import xyz.brassgoggledcoders.brassutils.common.block.BlockTotemTop;
import xyz.brassgoggledcoders.brassutils.common.block.BlockTurf;
import xyz.brassgoggledcoders.brassutils.common.block.TileCrystal;

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
		GameRegistry.registerBlock(blockTurf, "BlockTurf");
		GameRegistry.registerBlock(blockLeafCover, "BlockLeafCover");
		GameRegistry.registerBlock(blockGrassCover, "BlockGrassCover");
		blockEnderTotem = new BaseBlock(Material.rock).setUnlocalizedName("blockEnderTotem").setHardness(3.5F).setResistance(6.0F);
		blockTotemTop = new BlockTotemTop(Material.rock).setUnlocalizedName("blockEnderTotemTop");
		GameRegistry.registerBlock(blockEnderTotem, "BlockEnderTotem");
		GameRegistry.registerBlock(blockTotemTop, "BlockEnderTotemTop");
		blockFeathers = new BlockFeathers(Material.cloth).setUnlocalizedName("blockFeathers");
		GameRegistry.registerBlock(blockFeathers, "BlockFeathers");
		OreDictionary.registerOre("wool", blockFeathers);
		OreDictionary.registerOre("wool", Blocks.wool);
		blockRedstoneSand = new BlockRedstoneSand().setUnlocalizedName("blockRedstoneSand").setCreativeTab(BrassUtils.tabBU);
		GameRegistry.registerBlock(blockRedstoneSand, "BlockRedstoneSand");
		blockFusedQuartz = new BlockFusedQuartz(Material.glass).setUnlocalizedName("blockFusedQuartz");
		GameRegistry.registerBlock(blockFusedQuartz, "BlockFusedQuartz");

		blockEngravedVanilla = new BlockEngravedVanilla().setUnlocalizedName("blockEngravedVanilla");
		GameRegistry.registerBlock(blockEngravedVanilla, "BlockEngravedVanilla");

		blockLamp = new BlockLamp(false).setUnlocalizedName("blockLamp");
		blockLampOn = new BlockLamp(true).setUnlocalizedName("blockLamp");
		GameRegistry.registerBlock(blockLamp, "BlockLamp");
		GameRegistry.registerBlock(blockLampOn, "BlockLampOn");

		blockCrystal = new BlockCrystal().setUnlocalizedName("blockCrystal");

		RegistryHelper.registerContainerBlock(blockCrystal, TileCrystal.class, "BlockCrystal");

		blockEtherium = new BlockEtherium(Material.iron).setUnlocalizedName("blockEtherium");
		GameRegistry.registerBlock(blockEtherium, "BlockEtherium");
	}
}
