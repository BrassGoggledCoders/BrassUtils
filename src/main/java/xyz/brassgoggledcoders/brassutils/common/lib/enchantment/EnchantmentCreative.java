
package xyz.brassgoggledcoders.brassutils.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.ResourceLocation;

/**
 * @author Surseance
 *
 */
public class EnchantmentCreative extends Enchantment
{
	public EnchantmentCreative(int id, int rarity)
	{
		super(id, new ResourceLocation("creative"), rarity, EnumEnchantmentType.ALL);
		this.setName("creative");
	}
}
