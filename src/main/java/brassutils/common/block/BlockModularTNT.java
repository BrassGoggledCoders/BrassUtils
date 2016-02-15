
package brassutils.common.block;

import java.util.HashMap;

import net.minecraft.block.BlockTNT;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author warlordjones
 *
 *         7 Apr 201409:47:45
 */
public class BlockModularTNT extends BlockTNT
{
	/**
	 * @param par1
	 */
	HashMap modules;

	public BlockModularTNT()
	{
		super();
		HashMap modules = new HashMap();
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.setBlockName("modularTNT");
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		// modules.put("power", 4F);

	}

	@Override
	public void func_150114_a(World par1World, int par2, int par3, int par4, int par5, EntityLivingBase par6EntityLivingBase)
	{
		if (!par1World.isRemote)
		{
			if ((par5 & 1) == 1)
			{
				EntityModularTNTPrimed entitytntprimed = new EntityModularTNTPrimed(par1World, par2 + 0.5F, par3 + 0.5F, par4 + 0.5F,
						par6EntityLivingBase);
				entitytntprimed.modules.putAll(this.modules);
				par1World.spawnEntityInWorld(entitytntprimed);
				par1World.playSoundAtEntity(entitytntprimed, "random.fuse", 1.0F, 1.0F);
			}
		}
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8,
			float par9)
	{
		if ((par5EntityPlayer.getCurrentEquippedItem() != null) && (par5EntityPlayer.getCurrentEquippedItem() == new ItemStack(Blocks.wool)))
		{
			this.modules.put("soft", "yes");
			if (!par5EntityPlayer.capabilities.isCreativeMode)
			{
				par5EntityPlayer.getCurrentEquippedItem().splitStack(1);
			}
			return true;
		}
		if ((par5EntityPlayer.getCurrentEquippedItem() != null) && (par5EntityPlayer.getCurrentEquippedItem() == new ItemStack(Items.lava_bucket)))
		{
			this.modules.put("flame", "yes");
			if (!par5EntityPlayer.capabilities.isCreativeMode)
			{
				par5EntityPlayer.getCurrentEquippedItem().splitStack(1);
			}
			return true;
		}
		if ((par5EntityPlayer.getCurrentEquippedItem() != null) && (par5EntityPlayer.getCurrentEquippedItem() == new ItemStack(Items.gunpowder)))
		{
			this.modules.put("power", Float.valueOf(String.valueOf(this.modules.get("power"))) + 4F);
			if (!par5EntityPlayer.capabilities.isCreativeMode)
			{
				par5EntityPlayer.getCurrentEquippedItem().splitStack(1);
			}
			return true;
		}
		if ((par5EntityPlayer.getCurrentEquippedItem() != null) && (par5EntityPlayer.getCurrentEquippedItem() == new ItemStack(Items.string)))
		{
			this.modules.put("fuse", Float.valueOf(String.valueOf(this.modules.get("fuse"))) + 4F);
			if (!par5EntityPlayer.capabilities.isCreativeMode)
			{
				par5EntityPlayer.getCurrentEquippedItem().splitStack(1);
			}
			return true;
		}
		else
		{
			return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
		}
	}

}
