
package brassutils.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import brassutils.common.BrassUtils;

/**
 * @author Surseance
 *
 */
public class BlockEnderTotem extends BaseBlock
{
	public BlockEnderTotem()
	{
		super(Material.rock);
		this.setHardness(3.5F);
		this.setResistance(6.0F);
		this.setCreativeTab(BrassUtils.tabBU);
	}

	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_,
			float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		return false;
	}
}
