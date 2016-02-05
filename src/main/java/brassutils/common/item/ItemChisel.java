
package brassutils.common.item;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import brassutils.api.IEngravable;
import brassutils.common.InitBlocks;
import brassutils.common.lib.ModInfo;

/**
 * @author Surseance
 *
 */
public class ItemChisel extends BaseItem
{
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(ModInfo.PREFIX + "itemChisel");
	}

	public ItemChisel()
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(20);
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		Block block = world.getBlock(x, y, z);

		if (block == Blocks.diamond_block)
		{
			world.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 0, 2);
		}
		else if (block == Blocks.gold_block)
		{
			world.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 1, 2);
		}
		else if (block == Blocks.iron_block)
		{
			world.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 2, 2);
		}
		else if (block == Blocks.lapis_block)
		{
			world.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 3, 2);
		}
		else if (block == Blocks.stone)
		{
			world.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 4, 2);
		}
		else if (block == Blocks.emerald_block)
		{
			world.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 5, 2);
		}
		else if (block == Blocks.redstone_block)
		{
			world.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 6, 2);
		}
		else if (block == Blocks.quartz_block)
		{
			world.setBlock(x, y, z, Blocks.quartz_block, 1, 2);
		}
		else if (block == Blocks.redstone_lamp)
		{
			world.setBlock(x, y, z, InitBlocks.blockLamp, 0, 2);
		}
		else if (block == Blocks.lit_redstone_lamp)
		{
			world.setBlock(x, y, z, InitBlocks.blockLampOn, 0, 2);
		}
		// TODO out of the box implementation for common metals?
		else if (block instanceof IEngravable)

		{
			Block newBlock = ((IEngravable) block).getChiseledVariant();
			int meta = ((IEngravable) block).getChiseledVariantMeta();
			if (meta == -1)
				world.setBlock(x, y, z, newBlock, world.getBlockMetadata(x, y, z), 2);
			else
				world.setBlock(x, y, z, newBlock, meta, 2);
		}

		Random random = world.rand;
		world.spawnParticle("smoke", x, y, z, 0, random.nextInt(3), 0);
		is.damageItem(1, player);

		return true;
	}
}
