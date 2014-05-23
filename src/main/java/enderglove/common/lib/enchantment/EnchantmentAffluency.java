/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:57:04 PM] 
 */
package enderglove.common.lib.enchantment;

import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import enderglove.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EnchantmentAffluency extends Enchantment
{
	public EnchantmentAffluency(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		this.setName("affluency");
	}

	@Override
	public int getMinEnchantability(int level)
	{
		return 5 + 11 * (level - 1);
	}

	@Override
	public int getMaxEnchantability(int level)
	{
		return super.getMinEnchantability(level) + 50;
	}

	@Override
	public int getMaxLevel()
	{
		return 3;
	}

	@Override
	public boolean canApply(ItemStack is)
	{
		return ((is.getItem() instanceof ItemEnderGlove) || (is.getItem() instanceof ItemBook));
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack is)
	{
		return canApply(is);
	}

	@Override
	public boolean canApplyTogether(Enchantment enchantment)
	{
		return super.canApplyTogether(enchantment);
	}
}
