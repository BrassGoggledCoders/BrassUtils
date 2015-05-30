package brassutils.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import brassutils.common.BrassUtils;

public class BlockLeafCover extends BlockTurf

{
	private IIcon[] icons = new IIcon[12];

	public BlockLeafCover(Material mat)

	{
		super(mat);
		this.setBlockName("blockLeafCover");
		this.setCreativeTab(BrassUtils.tabBU);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.icons[0] = par1IconRegister.registerIcon("leaves_oak");
		this.icons[1] = par1IconRegister.registerIcon("leaves_spruce");
		this.icons[2] = par1IconRegister.registerIcon("leaves_jungle");
		this.icons[3] = par1IconRegister.registerIcon("leaves_birch");
		this.icons[4] = par1IconRegister.registerIcon("leaves_acacia");
		this.icons[5] = par1IconRegister.registerIcon("leaves_big_oak");
		this.icons[6] = par1IconRegister.registerIcon("leaves_oak_opaque");
		this.icons[7] = par1IconRegister.registerIcon("leaves_spruce_opaque");
		this.icons[8] = par1IconRegister.registerIcon("leaves_jungle_opaque");
		this.icons[9] = par1IconRegister.registerIcon("leaves_birch_opaque");
		this.icons[10] = par1IconRegister.registerIcon("leaves_acacia_opaque");
		this.icons[11] = par1IconRegister.registerIcon("leaves_big_oak_opaque");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.icons[meta];
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < this.icons.length; i++)
		{
			par3List.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerFoliage.getFoliageColor(d0, d1);
	}

	/**
	 * Returns the color this block should be rendered. Used by leaves.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int p_149741_1_)
	{
		return ColorizerFoliage.getFoliageColorBasic();
	}

	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied
	 * against the blocks color. Note only called when first determining what to
	 * render.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
	{
		int l = 0;
		int i1 = 0;
		int j1 = 0;

		for (int k1 = -1; k1 <= 1; ++k1)
		{
			for (int l1 = -1; l1 <= 1; ++l1)
			{
				int i2 = p_149720_1_.getBiomeGenForCoords(p_149720_2_ + l1, p_149720_4_ + k1).getBiomeFoliageColor(p_149720_2_ + l1, p_149720_3_,
						p_149720_4_ + k1);
				l += (i2 & 16711680) >> 16;
				i1 += (i2 & 65280) >> 8;
				j1 += i2 & 255;
			}
		}

		return (((l / 9) & 255) << 16) | (((i1 / 9) & 255) << 8) | ((j1 / 9) & 255);
	}

	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
	{
		if (p_149734_1_.canLightningStrikeAt(p_149734_2_, p_149734_3_ + 1, p_149734_4_)
				&& !World.doesBlockHaveSolidTopSurface(p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) && (p_149734_5_.nextInt(15) == 1))
		{
			double d0 = p_149734_2_ + p_149734_5_.nextFloat();
			double d1 = p_149734_3_ - 0.05D;
			double d2 = p_149734_4_ + p_149734_5_.nextFloat();
			p_149734_1_.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	/**
	 * Pass true to draw this block using fancy graphics, or false for fast
	 * graphics.
	 */
	@SideOnly(Side.CLIENT)
	public void setGraphicsLevel(boolean p_150122_1_)
	{
		p_150122_1_ = true;
	}
}