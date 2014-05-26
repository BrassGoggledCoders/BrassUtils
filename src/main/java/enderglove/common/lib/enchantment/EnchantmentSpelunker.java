/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:02:39 PM]
 */
package enderglove.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 * 
 */
public class EnchantmentSpelunker extends Enchantment
{
	public EnchantmentSpelunker( int id,  int rarity)
	{
		super(id, rarity, EnumEnchantmentType.all);
		setName("spelunker");
	}
}
