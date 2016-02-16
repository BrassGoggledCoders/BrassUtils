
package xyz.brassgoggledcoders.brassutils.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.util.ResourceLocation;

/**
 * @author Surseance
 *
 */
public class EnchantmentSpelunker extends Enchantment
{
	public EnchantmentSpelunker(int id, int rarity)
	{
		super(id, new ResourceLocation("spelunker"), rarity, EnumEnchantmentType.ALL);
		this.setName("spelunker");
	}
}
