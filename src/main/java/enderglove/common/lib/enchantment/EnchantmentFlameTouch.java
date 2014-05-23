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
import enderglove.common.config.Config;
import enderglove.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EnchantmentFlameTouch extends Enchantment
{
	public EnchantmentFlameTouch(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		this.setName("flametouch");
		this.silkTouch.canApplyTogether(this);
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
		if ((enchantment.effectId == Enchantment.silkTouch.effectId) || (enchantment.effectId == Enchantment.fortune.effectId))
			return false;
		else
			return true;
		//return super.canApplyTogether(enchantment);
	}	
}
