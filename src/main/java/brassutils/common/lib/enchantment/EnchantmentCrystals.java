/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
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
public class EnchantmentCrystals extends Enchantment
{
	public EnchantmentCrystals(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		this.setName("crystals");
		silkTouch.canApplyTogether(this);
	}

	@Override
	public int getMinEnchantability(int level)
	{
		return 11;
	}

	@Override
	public int getMaxEnchantability(int level)
	{
		return super.getMinEnchantability(level) + 30;
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
		return true;
	}
}
