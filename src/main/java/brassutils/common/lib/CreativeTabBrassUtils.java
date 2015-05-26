/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.common.lib;

import net.minecraft.item.Item;

import boilerplate.common.baseclasses.CreativeTabBase;
import brassutils.common.InitItems;

/**
 * @author Surseance
 *
 */
public class CreativeTabBrassUtils extends CreativeTabBase
{
	public CreativeTabBrassUtils(int id, String name)
	{
		super(id, name);
	}

	@Override
	public Item getTabIconItem()
	{
		return InitItems.itemEnderGlove;
	}
}
