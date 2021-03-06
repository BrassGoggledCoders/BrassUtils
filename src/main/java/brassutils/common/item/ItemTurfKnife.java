
package brassutils.common.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraftforge.common.BiomeDictionary;

import brassutils.common.InitBlocks;
import brassutils.common.lib.ModInfo;

public class ItemTurfKnife extends Item
{
	@SideOnly(Side.CLIENT)
	protected IIcon itemIcon;

	public ItemTurfKnife()
	{
		super();

	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase harvester)
	{
		if (harvester instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) harvester;
			if (block == Blocks.grass)
			{
				if (BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords(x, z), BiomeDictionary.Type.SWAMP)
						|| BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords(x, z), BiomeDictionary.Type.WATER)
						|| BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords(x, z), BiomeDictionary.Type.BEACH))
				{
					player.inventory.addItemStackToInventory(new ItemStack(InitBlocks.blockTurf, 1, 1));
				}
				else if (BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords(x, z), BiomeDictionary.Type.DRY)
						|| BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords(x, z), BiomeDictionary.Type.NETHER))
				{
					player.inventory.addItemStackToInventory(new ItemStack(InitBlocks.blockTurf, 1, 2));
				}
				else if (BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords(x, z), BiomeDictionary.Type.COLD))
				{
					player.inventory.addItemStackToInventory(new ItemStack(InitBlocks.blockTurf, 1, 3));
				}
				else if (BiomeDictionary.isBiomeOfType(world.getBiomeGenForCoords(x, z), BiomeDictionary.Type.JUNGLE))
				{
					player.inventory.addItemStackToInventory(new ItemStack(InitBlocks.blockTurf, 1, 4));
				}
				else
				{
					player.inventory.addItemStackToInventory(new ItemStack(InitBlocks.blockTurf, 1, 0));
				}
			}
			if (block == Blocks.mycelium)
			{
				player.inventory.addItemStackToInventory(new ItemStack(InitBlocks.blockTurf, 1, 5));
			}
			if ((block == Blocks.dirt) && (world.getBlockMetadata(x, y, z) == 2))
			{
				player.inventory.addItemStackToInventory(new ItemStack(InitBlocks.blockTurf, 1, 6));
			}
		}
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ModInfo.PREFIX + "itemTurfKnife");
	}

	/**
	 * Gets an icon index based on an item's damage value
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int p_77617_1_)
	{
		return this.itemIcon;
	}
}
