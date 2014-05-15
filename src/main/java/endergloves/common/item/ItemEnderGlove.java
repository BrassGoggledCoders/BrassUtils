/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:38:46 PM] 
 */
package endergloves.common.item;

import java.util.Set;

import endergloves.common.EnderGloves;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class ItemEnderGlove extends ItemTool
{
	protected Item.ToolMaterial toolMat;
	protected Set<Block> blocksEffectiveAgainst;

	public ItemEnderGlove(float damageVsEntity, Item.ToolMaterial toolMat, Set blockSet)
	{
		super(damageVsEntity, toolMat, blockSet);
		this.toolMat = toolMat;
		this.blocksEffectiveAgainst = blockSet;
		this.setCreativeTab(EnderGloves.tabEG);
	}

	@Override
	public float func_150893_a(ItemStack is, Block block) // getStrVsBlock
	{
		return this.blocksEffectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : 1.0F;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving)
	{
		super.onBlockDestroyed(is, world, block, x, y, z, entityLiving);


		return true;
	}

	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return false;
	}
}
