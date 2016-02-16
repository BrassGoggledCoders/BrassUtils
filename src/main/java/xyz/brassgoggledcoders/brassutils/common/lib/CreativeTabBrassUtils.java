
package xyz.brassgoggledcoders.brassutils.common.lib;

import net.minecraft.item.Item;

import xyz.brassgoggledcoders.boilerplate.lib.common.BaseCreativeTab;
import xyz.brassgoggledcoders.brassutils.common.InitItems;

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
