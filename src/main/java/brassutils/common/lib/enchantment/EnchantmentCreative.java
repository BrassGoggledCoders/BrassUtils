
package brassutils.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

/**
 * @author Surseance
 *
 */
public class EnchantmentCreative extends Enchantment
{
	public EnchantmentCreative(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		this.setName("creative");
	}
}
