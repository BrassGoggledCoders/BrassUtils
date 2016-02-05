
package brassutils.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

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
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	{
		return true;
	}
}
