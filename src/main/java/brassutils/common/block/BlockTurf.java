package brassutils.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import brassutils.common.BrassUtils;
import brassutils.common.lib.LibInfo;

public class BlockTurf extends Block
{
	private IIcon[] icons = new IIcon[7];

	public BlockTurf(Material mat)
	{
		super(mat);
		this.setBlockName("blockTurf");
		this.setCreativeTab(BrassUtils.tabBU);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.icons[0] = par1IconRegister.registerIcon(LibInfo.PREFIX + "turfNormal");
		this.icons[1] = par1IconRegister.registerIcon(LibInfo.PREFIX + "turfSwamp");
		this.icons[2] = par1IconRegister.registerIcon(LibInfo.PREFIX + "turfDry");
		this.icons[3] = par1IconRegister.registerIcon(LibInfo.PREFIX + "turfFrozen");
		this.icons[4] = par1IconRegister.registerIcon(LibInfo.PREFIX + "turfJungle");
		this.icons[5] = par1IconRegister.registerIcon(LibInfo.PREFIX + "turfMycelium");
		this.icons[6] = par1IconRegister.registerIcon(LibInfo.PREFIX + "turfPodzol");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return this.icons[meta];
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

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		byte b0 = 0;
		float f = 0.0625F;
		return AxisAlignedBB.getBoundingBox(p_149668_2_ + this.minX, p_149668_3_ + this.minY, p_149668_4_ + this.minZ, p_149668_2_ + this.maxX,
				p_149668_3_ + (b0 * f), p_149668_4_ + this.maxZ);
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

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	/**
	 * Sets the block's bounds for rendering it as an item
	 */
	@Override
	public void setBlockBoundsForItemRender()
	{
		this.func_150089_b(0);
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
	{
		this.func_150089_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));
	}

	protected void func_150089_b(int p_150089_1_)
	{
		byte b0 = 0;
		float f = (1 * (1 + b0)) / 16.0F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
	{
		return super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_)
				&& this.canBlockStay(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_);
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor Block
	 */
	@Override
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
	{
		this.func_150090_e(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
	}

	private boolean func_150090_e(World p_150090_1_, int p_150090_2_, int p_150090_3_, int p_150090_4_)
	{
		if (!this.canBlockStay(p_150090_1_, p_150090_2_, p_150090_3_, p_150090_4_))
		{
			this.dropBlockAsItem(p_150090_1_, p_150090_2_, p_150090_3_, p_150090_4_,
					p_150090_1_.getBlockMetadata(p_150090_2_, p_150090_3_, p_150090_4_), 0);
			p_150090_1_.setBlockToAir(p_150090_2_, p_150090_3_, p_150090_4_);
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Can this block stay at this position. Similar to canPlaceBlockAt except
	 * gets checked often with plants.
	 */
	@Override
	public boolean canBlockStay(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_)
	{
		return !p_149718_1_.isAirBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_);
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if
	 * the adjacent block is at the given coordinates. Args: blockAccess, x, y,
	 * z, side
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
	{
		return p_149646_5_ == 1 ? true : super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and
	 * wood.
	 */
	@Override
	public int damageDropped(int p_149692_1_)
	{
		return p_149692_1_;
	}
}