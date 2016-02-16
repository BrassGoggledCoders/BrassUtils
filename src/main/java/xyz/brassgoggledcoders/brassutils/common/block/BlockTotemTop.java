
package xyz.brassgoggledcoders.brassutils.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import xyz.brassgoggledcoders.boilerplate.lib.common.blocks.BaseBlock;
import xyz.brassgoggledcoders.brassutils.common.InitBlocks;
import xyz.brassgoggledcoders.brassutils.common.InitItems;

/**
 * @author Surseance
 *
 */
public class BlockTotemTop extends BaseBlock
{
	public BlockTotemTop(Material mat)
	{
		super(mat);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY,
			float hitZ)
	{
		playerIn.addExperience(100);
		playerIn.inventory.addItemStackToInventory(new ItemStack(InitItems.itemEnderGlove));
		worldIn.setBlockState(pos, InitBlocks.blockEnderTotem.getDefaultState());
		return true;
	}
}
