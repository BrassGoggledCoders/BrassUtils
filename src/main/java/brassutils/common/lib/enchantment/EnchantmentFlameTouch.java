
package brassutils.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;

import brassutils.common.item.ItemEnderGlove;

/**
 * @author Surseance
 *
 */
public class EnchantmentFlameTouch extends Enchantment
{
	public EnchantmentFlameTouch(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		this.setName("flametouch");
		silkTouch.canApplyTogether(this);
	}

	@Override
	public int getMinEnchantability(int level)
	{
		return 21;
	}

	@Override
	public int getMaxEnchantability(int level)
	{
		return super.getMinEnchantability(level) + 50;
	}

	@Override
	public int getMaxLevel()
	{
		return 1;
	}

	@Override
	public boolean canApply(ItemStack is)
	{
		return (is.getItem() instanceof ItemEnderGlove) || (is.getItem() instanceof ItemBook);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack is)
	{
		return this.canApply(is);
	}

	@Override
	public boolean canApplyTogether(Enchantment enchantment)
	{
		if (enchantment.effectId == Enchantment.silkTouch.effectId)
		// || enchantment.effectId == Enchantment.fortune.effectId)
		{
			return false;
		}
		else
		{
			return true;
			// return super.canApplyTogether(enchantment);
		}
	}
}
