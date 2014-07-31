package enderglove.common.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import boilerplate.common.baseclasses.RootItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enderglove.common.EnderGlove;
import enderglove.common.lib.LibInfo;

public class ItemEnderPocket extends RootItem
{
	public ItemEnderPocket()
	{
		super();
		this.setFull3D();
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setNoRepair();
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(LibInfo.PREFIX + "enderpocket");
	}
	  /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	player.openGui(EnderGlove.instance, 0, world, x, y, z);
        return true;
    }
}
