
package xyz.brassgoggledcoders.brassutils.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import xyz.brassgoggledcoders.brassutils.common.InitConfig;
import xyz.brassgoggledcoders.brassutils.common.item.ItemEnderGlove;

/**
 * @author Surseance
 *
 */
public class EnchantmentTeleport extends Enchantment
{
	public EnchantmentTeleport(int id, int rarity)
	{
		super(id, new ResourceLocation("teleport"), rarity, EnumEnchantmentType.ALL);
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
		return super.canApplyTogether(enchantment)
				&& ((enchantment.effectId != Enchantment.fortune.effectId) || (enchantment.effectId != Enchantment.silkTouch.effectId)
						|| (enchantment.effectId != InitConfig.enchAffluencyId) || (enchantment.effectId != InitConfig.enchMagnetismId));
	}
}
