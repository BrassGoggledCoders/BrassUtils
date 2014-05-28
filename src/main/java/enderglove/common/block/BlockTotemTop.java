package enderglove.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enderglove.common.config.ConfigBlocks;
import enderglove.common.config.ConfigItems;
import enderglove.common.lib.LibInfo;

public class BlockTotemTop extends BlockEnderTotem
{
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons( IIconRegister ir)
	{
		//TODO: Custom Texture
		blockIcon = ir.registerIcon(LibInfo.PREFIX + "endertotem");

	}

	public BlockTotemTop()
	{
		super();
		setHardness(3.5F);
		setResistance(6.0F);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		player.addExperience(100);
		player.inventory.addItemStackToInventory(new ItemStack(ConfigItems.itemEnderGlove));
		world.setBlock(x, y, z, ConfigBlocks.blockEnderTotem);
		return true;

	}

}
