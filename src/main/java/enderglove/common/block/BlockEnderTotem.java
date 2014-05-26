/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:21:56 PM]
 */
package enderglove.common.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enderglove.common.lib.LibInfo;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 * 
 */
public class BlockEnderTotem extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(final IIconRegister ir)
	{
		blockIcon = ir.registerIcon(LibInfo.PREFIX + "endertotem");
		setCreativeTab(CreativeTabs.tabBlock);
	}

	public BlockEnderTotem()
	{
		super(Material.rock);
		setHardness(3.5F);
		setResistance(6.0F);
	}

	@Override
	public TileEntity createNewTileEntity(final World world, final int metadata)
	{
		return null;
	}
}
