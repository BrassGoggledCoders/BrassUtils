
package brassutils.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import brassutils.client.RenderIDs;
import brassutils.common.BrassUtils;
import brassutils.common.InitItems;

/**
 * @author Surseance
 *
 */
public class BlockCrystal extends BlockContainer
{
	public BlockCrystal()
	{
		super(Material.glass);
		this.setHardness(8.5F);
		this.setResistance(-1);
		this.setStepSound(Block.soundTypeGlass);
		this.setCreativeTab(BrassUtils.tabBU);
	}

	@Override
	public TileEntity createNewTileEntity(final World world, final int metadata)
	{
		return new TileCrystal();
	}

	@Override
	public int getRenderType()
	{
		return RenderIDs.blockCrystalRI;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean canCreatureSpawn(final EnumCreatureType type, final IBlockAccess world, final int x, final int y, final int z)
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean addDestroyEffects(final World world, final int x, final int y, final int z, final int metadata,
			final EffectRenderer effectRenderer)
	{
		return super.addDestroyEffects(world, x, y, z, metadata, effectRenderer);
	}

	@Override
	public int tickRate(final World world)
	{
		return 10;
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return InitItems.itemEtherium;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir)
	{
		// this.blockIcon = ir.registerIcon(ModInfo.PREFIX + "blockCrystal");
	}
}
