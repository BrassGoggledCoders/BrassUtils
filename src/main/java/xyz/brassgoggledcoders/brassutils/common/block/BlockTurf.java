
package xyz.brassgoggledcoders.brassutils.common.block;

import net.minecraft.block.material.Material;

import xyz.brassgoggledcoders.boilerplate.lib.common.blocks.BaseBlock;
import xyz.brassgoggledcoders.brassutils.common.BrassUtils;

public class BlockTurf extends BaseBlock
{
	public BlockTurf(Material mat)
	{
		super(mat);
		this.setCreativeTab(BrassUtils.tabBU);
	}
}