
package brassutils.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import boilerplate.common.baseclasses.items.RootItem;
import brassutils.common.BrassUtils;
import brassutils.common.lib.ModInfo;

/**
 * @author warlordjones
 *
 */
public class BaseItem extends RootItem
{
	public BaseItem()
	{
		super();
		this.setCreativeTab(BrassUtils.tabBU);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(ModInfo.PREFIX + this.getUnlocalizedName().substring(5));
	}
}
