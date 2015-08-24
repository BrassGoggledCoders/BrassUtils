/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 * Steamcraft 2 is based on the original Steamcraft Mod created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 *
 */
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
