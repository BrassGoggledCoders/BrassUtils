/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:27:09 PM] 
 */
package enderglove.common.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class CreativeTabEG extends CreativeTabs
{
	public CreativeTabEG(int id, String name)
	{
		super(id, name);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Item getTabIconItem()
	{
		return Items.apple; // XXX: temp
	}
}
