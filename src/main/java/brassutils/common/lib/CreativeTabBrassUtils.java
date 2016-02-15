
package brassutils.common.lib;

import net.minecraft.item.Item;

import brassutils.common.InitItems;
import xyz.brassgoggledcoders.boilerplate.lib.common.BaseCreativeTab;

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
