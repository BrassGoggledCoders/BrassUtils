
package brassutils.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import brassutils.common.BrassUtils;
import brassutils.common.InitItems;
import xyz.brassgoggledcoders.boilerplate.lib.common.blocks.BaseBlock;

/**
 * @author Surseance
 *
 */
public class BlockCrystal extends BaseBlock
{
	public BlockCrystal()
	{
		super(Material.glass);
		this.setHardness(8.5F);
		this.setResistance(-1);
		this.setStepSound(Block.soundTypeGlass);
		this.setCreativeTab(BrassUtils.tabBU);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return InitItems.itemEtherium;
	}
}
