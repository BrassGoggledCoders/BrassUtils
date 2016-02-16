
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
public class EnchantmentReach extends Enchantment
{
	public EnchantmentReach(int id, int rarity)
	{
		super(id, new ResourceLocation("reach"), rarity, EnumEnchantmentType.ALL);
		this.setName("reach");
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
		return 5;
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
		return super.canApplyTogether(enchantment);
	}
}
