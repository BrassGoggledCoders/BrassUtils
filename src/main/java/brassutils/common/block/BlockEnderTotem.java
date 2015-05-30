/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import brassutils.common.BrassUtils;
import brassutils.common.lib.LibInfo;

/**
 * @author Surseance
 *
 */
public class BlockEnderTotem extends Block
{
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir)
	{
		this.blockIcon = ir.registerIcon(LibInfo.PREFIX + "endertotem");
	}

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
