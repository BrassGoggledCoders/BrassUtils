
package xyz.brassgoggledcoders.brassutils.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.ColorizerGrass;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import xyz.brassgoggledcoders.boilerplate.lib.common.blocks.BaseBlock;
import xyz.brassgoggledcoders.brassutils.common.BrassUtils;

public class BlockGrassCover extends BaseBlock
{

	public BlockGrassCover(Material p_i45394_1_)
	{
		super(p_i45394_1_);
		this.setCreativeTab(BrassUtils.tabBU);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerGrass.getGrassColor(d0, d1);
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
