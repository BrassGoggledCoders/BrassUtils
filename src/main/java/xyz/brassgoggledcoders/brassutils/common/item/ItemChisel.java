
package xyz.brassgoggledcoders.brassutils.common.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import xyz.brassgoggledcoders.boilerplate.lib.common.items.BaseItem;

/**
 * @author Surseance
 *
 */
public class ItemChisel extends BaseItem
{
	public ItemChisel()
	{
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(20);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		Block block = worldIn.getBlockState(pos).getBlock();

		// if (block == Blocks.diamond_block)
		// {
		// worldIn.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 0, 2);
		// }
		// else if (block == Blocks.gold_block)
		// {
		// worldIn.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 1, 2);
		// }
		// else if (block == Blocks.iron_block)
		// {
		// worldIn.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 2, 2);
		// }
		// else if (block == Blocks.lapis_block)
		// {
		// worldIn.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 3, 2);
		// }
		// else if (block == Blocks.stone)
		// {
		// worldIn.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 4, 2);
		// }
		// else if (block == Blocks.emerald_block)
		// {
		// worldIn.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 5, 2);
		// }
		// else if (block == Blocks.redstone_block)
		// {
		// worldIn.setBlock(x, y, z, InitBlocks.blockEngravedVanilla, 6, 2);
		// }
		// else if (block == Blocks.quartz_block)
		// {
		// worldIn.setBlock(x, y, z, Blocks.quartz_block, 1, 2);
		// }
		// else if (block == Blocks.redstone_lamp)
		// {
		// world.setBlock(x, y, z, InitBlocks.blockLamp, 0, 2);
		// }
		// else if (block == Blocks.lit_redstone_lamp)
		// {
		// world.setBlock(x, y, z, InitBlocks.blockLampOn, 0, 2);
		// }
		// // TODO out of the box implementation for common metals?
		// else if (block instanceof IEngravable)
		//
		// {
		// Block newBlock = ((IEngravable) block).getChiseledVariant();
		// int meta = ((IEngravable) block).getChiseledVariantMeta();
		// if (meta == -1)
		// world.setBlock(x, y, z, newBlock, world.getBlockMetadata(x, y, z),
		// 2);
		// else
		// world.setBlock(x, y, z, newBlock, meta, 2);
		// }
		//
		// Random random = world.rand;
		// world.spawnParticle("smoke", x, y, z, 0, random.nextInt(3), 0);
		// is.damageItem(1, player);

		return true;
	}
}
