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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enderglove.common.lib.LibInfo;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
public class BlockEnderTotem extends Block
{
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons( IIconRegister ir)
	{
		blockIcon = ir.registerIcon(LibInfo.PREFIX + "endertotem");

	}

	public BlockEnderTotem()
	{
		super(Material.rock);
		setHardness(3.5F);
		setResistance(6.0F);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		return false;
	}
}
