/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 16, 2014, 7:27:41 PM]
 */
package enderglove.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import enderglove.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
public class EnchantmentCrystals extends Enchantment
{
	public EnchantmentCrystals( int id,  int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		setName("crystals");
		silkTouch.canApplyTogether(this);
	}

	@Override
	public int getMinEnchantability( int level)
	{
		return 11;
	}

	@Override
	public int getMaxEnchantability( int level)
	{
		return super.getMinEnchantability(level) + 30;
	}

	@Override
	public int getMaxLevel()
	{
		return 1;
	}

	@Override
	public boolean canApply( ItemStack is)
	{
		return is.getItem() instanceof ItemEnderGlove
				|| is.getItem() instanceof ItemBook;
	}

	@Override
	public boolean canApplyAtEnchantingTable( ItemStack is)
	{
		return canApply(is);
	}

	@Override
	public boolean canApplyTogether( Enchantment enchantment)
	{
		return true;
	}
}