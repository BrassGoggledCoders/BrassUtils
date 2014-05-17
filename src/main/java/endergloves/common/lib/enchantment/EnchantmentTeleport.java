/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:03:24 PM] 
 */
package endergloves.common.lib.enchantment;

import endergloves.common.config.Config;
import endergloves.common.item.ItemEnderGlove;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EnchantmentTeleport extends Enchantment
{
	public EnchantmentTeleport(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		this.setName("teleport");
	}
	
	@Override
	public int getMinEnchantability(int level)
	{
		return 24;
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
		return (super.canApplyTogether(enchantment)) && ((enchantment.effectId != Enchantment.fortune.effectId) || (enchantment.effectId != Enchantment.silkTouch.effectId) || (enchantment.effectId != Config.enchAffluencyId));
	}
}
