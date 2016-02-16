
package xyz.brassgoggledcoders.brassutils.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

import xyz.brassgoggledcoders.boilerplate.lib.common.blocks.BaseBlock;

/**
 * @author Surseance
 *
 */
public class BlockEtherium extends BaseBlock
{
	public BlockEtherium(Material mat)
	{
		super(mat);
		this.setResistance(-1);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		return true;
	}
}
