
package brassutils.common.item;

import boilerplate.common.baseclasses.items.BaseArmor;
import brassutils.common.BrassUtils;
import brassutils.common.lib.ModInfo;

/**
 * @author Decebaldecebal
 *
 */
public class ItemNormalArmor extends BaseArmor
{
	public ItemNormalArmor(ArmorMaterial mat, int type, String textureName)
	{
		super(mat, type, textureName, ModInfo.PREFIX);
		this.setCreativeTab(BrassUtils.tabBU);
	}
}
