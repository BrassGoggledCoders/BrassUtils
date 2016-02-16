
package xyz.brassgoggledcoders.brassutils.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import xyz.brassgoggledcoders.brassutils.common.item.ItemEnderGlove;

/**
 * @author Surseance
 *
 */
public class EnchantmentCrystals extends Enchantment
{
	public EnchantmentCrystals(int id, int rarity)
	{
		super(id, new ResourceLocation("crystals"), rarity, EnumEnchantmentType.ALL);
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
