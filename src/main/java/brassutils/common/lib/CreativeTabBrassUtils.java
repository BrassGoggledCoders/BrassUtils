
package brassutils.common.lib;

import net.minecraft.item.Item;

import boilerplate.common.baseclasses.BaseCreativeTab;
import brassutils.common.InitItems;

/**
 * @author Surseance
 *
 */
public class CreativeTabBrassUtils extends BaseCreativeTab
{
	public CreativeTabBrassUtils(String name)
	{
		super(name);
	}

	@Override
	public Item getTabIconItem()
	{
		return InitItems.itemEnderGlove;
	}
}
