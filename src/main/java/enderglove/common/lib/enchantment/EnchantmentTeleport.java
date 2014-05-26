/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:03:24 PM]
 */
package enderglove.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import enderglove.common.config.Config;
import enderglove.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 * 
 */
public class EnchantmentTeleport extends Enchantment
{
	public EnchantmentTeleport(final int id, final int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		setName("teleport");
	}

	@Override
	public int getMinEnchantability(final int level)
	{
		return 24;
	}

	@Override
	public int getMaxEnchantability(final int level)
	{
		return super.getMinEnchantability(level) + 50;
	}

	@Override
	public int getMaxLevel()
	{
		return 1;
	}

	@Override
	public boolean canApply(final ItemStack is)
	{
		return is.getItem() instanceof ItemEnderGlove
				|| is.getItem() instanceof ItemBook;
	}

	@Override
	public boolean canApplyAtEnchantingTable(final ItemStack is)
	{
		return canApply(is);
	}

	@Override
	public boolean canApplyTogether(final Enchantment enchantment)
	{
		return super.canApplyTogether(enchantment)
				&& (enchantment.effectId != Enchantment.fortune.effectId
						|| enchantment.effectId != Enchantment.silkTouch.effectId
						|| enchantment.effectId != Config.enchAffluencyId || enchantment.effectId != Config.enchFieldID);
	}
}
