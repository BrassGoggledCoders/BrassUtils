
package brassutils.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import brassutils.common.BrassUtils;
import xyz.brassgoggledcoders.boilerplate.lib.common.blocks.BaseMetadataBlock;

/**
 * @author Surseance
 *
 */
public class BlockEngravedVanilla extends BaseMetadataBlock
{
	// private final IIcon[] icon = new IIcon[7];

	public BlockEngravedVanilla()
	{
		super(Material.iron);
		this.setHardness(3.0F);
		this.setResistance(15.0F);
		this.setStepSound(Block.soundTypeMetal);
		this.setTickRandomly(true);
		this.setCreativeTab(BrassUtils.tabBU);
	}

	// @Override
	// @SideOnly(Side.CLIENT)
	// public IIcon getIcon(final int side, final int metadata)
	// {
	// if (metadata < this.icon.length)
	// return this.icon[metadata];
	// else
	// return this.icon[0];
	// }
	//
	// @Override
	// @SideOnly(Side.CLIENT)
	// public void registerBlockIcons(IIconRegister ir)
	// {
	// this.icon[0] = ir.registerIcon(ModInfo.PREFIX + "blockEngravedDiamond");
	// this.icon[1] = ir.registerIcon(ModInfo.PREFIX + "blockEngravedGold");
	// this.icon[2] = ir.registerIcon(ModInfo.PREFIX + "blockEngravedIron");
	// this.icon[3] = ir.registerIcon(ModInfo.PREFIX + "blockEngravedLapis");
	// this.icon[4] = ir.registerIcon(ModInfo.PREFIX + "blockEngravedStone");
	// this.icon[5] = ir.registerIcon(ModInfo.PREFIX + "blockEngravedEmerald");
	// this.icon[6] = ir.registerIcon(ModInfo.PREFIX + "blockEngravedRedstone");
	// }
	//
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// @Override
	// @SideOnly(Side.CLIENT)
	// public void getSubBlocks(Item item, CreativeTabs tab, List l)
	// {
	// for (int var4 = 0; var4 < this.icon.length; ++var4)
	// l.add(new ItemStack(InitBlocks.blockEngravedVanilla, 1, var4));
	// }
	//
	// @Override
	// public int damageDropped(int meta)
	// {
	// return meta;
	// }
}
