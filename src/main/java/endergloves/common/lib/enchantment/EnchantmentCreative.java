/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:03:54 PM] 
 */
package endergloves.common.lib.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EnchantmentCreative extends Enchantment
{
	public EnchantmentCreative(int id, int something)
	{
		super(id, something, EnumEnchantmentType.all);
		this.setName("creative");
	}
}
