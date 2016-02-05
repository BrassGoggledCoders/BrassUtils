
package brassutils.common.block;

import net.minecraft.block.BlockSkull;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author warlordjones
 *
 *         10 Apr 201409:50:23
 */
public class BlockEndermanHead extends BlockSkull
{

	private int isBeingTraced;

	public BlockEndermanHead()
	{
		super();
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockName("endermanHead");

	}

	@Override
	public float getEnchantPowerBonus(World world, int x, int y, int z)
	{
		return 10;
	}

	@SideOnly(Side.CLIENT)
	public boolean addBlockDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer)
	{
		// world.playSound(x, y, par5, par7Str, par8, par9, par10);
		world.playAuxSFX(2003, x, y, z, 0);
		return true;
	}

	@Override
	public void onBlockExploded(World world, int x, int y, int z, Explosion explosion)
	{
		this.teleportNearby(world, x, y, z);
	}

	private void teleportNearby(World par1World, int par2, int par3, int par4)
	{
		if (par1World.getBlock(par2, par3, par4) == this)
		{
			for (int l = 0; l < 1000; ++l)
			{
				int i1 = (par2 + par1World.rand.nextInt(16)) - par1World.rand.nextInt(16);
				int j1 = (par3 + par1World.rand.nextInt(8)) - par1World.rand.nextInt(8);
				int k1 = (par4 + par1World.rand.nextInt(16)) - par1World.rand.nextInt(16);

				if (par1World.isAirBlock(i1, j1, k1))
				{
					if (!par1World.isRemote)
					{
						par1World.setBlock(i1, j1, k1, this, par1World.getBlockMetadata(par2, par3, par4), 2);
						par1World.setBlockToAir(par2, par3, par4);
					}
					else
					{
						short short1 = 128;

						for (int l1 = 0; l1 < short1; ++l1)
						{
							double d0 = par1World.rand.nextDouble();
							float f = (par1World.rand.nextFloat() - 0.5F) * 0.2F;
							float f1 = (par1World.rand.nextFloat() - 0.5F) * 0.2F;
							float f2 = (par1World.rand.nextFloat() - 0.5F) * 0.2F;
							double d1 = i1 + ((par2 - i1) * d0) + ((par1World.rand.nextDouble() - 0.5D) * 1.0D) + 0.5D;
							double d2 = (j1 + ((par3 - j1) * d0) + (par1World.rand.nextDouble() * 1.0D)) - 0.5D;
							double d3 = k1 + ((par4 - k1) * d0) + ((par1World.rand.nextDouble() - 0.5D) * 1.0D) + 0.5D;
							par1World.spawnParticle("portal", d1, d2, d3, f, f1, f2);
						}
					}

					return;
				}
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg)
	{
		this.blockIcon = reg.registerIcon("oddsnends:" + this.getUnlocalizedName().substring(5));
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return this.isBeingTraced;
	}

	@Override
	public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 par5Vec3, Vec3 par6Vec3)
	{
		if (this.isBeingTraced == 0)
		{
			this.isBeingTraced = 15;
		}
		else
		{
			this.isBeingTraced = 0;
		}
		// world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x,
		// y, z) + 30, 2);
		return null;
	}
}