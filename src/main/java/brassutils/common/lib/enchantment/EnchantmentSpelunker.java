
package brassutils.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

/**
 * @author Surseance
 *
 */
public class EnchantmentSpelunker extends Enchantment
{
	public EnchantmentSpelunker(int id, int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		this.setName("spelunker");
	}
}
