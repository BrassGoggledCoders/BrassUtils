
package brassutils.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import xyz.brassgoggledcoders.boilerplate.lib.common.blocks.BaseBlock;

public class BlockFusedQuartz extends BaseBlock
{
	public BlockFusedQuartz(Material mat)
	{
		super(mat);
	}

	@Override
	public boolean canProvidePower()
	{
		return false;
	}

	@Override
	public int getStrongPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
	{
		return 0;
	}

	public boolean isBlockSolidOnSide(World world, int x, int y, int z, EnumFacing side)
	{
		return true;
	}

}
