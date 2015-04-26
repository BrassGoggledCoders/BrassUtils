/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package enderglove.common.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import enderglove.common.InitBlocks;
import enderglove.common.InitItems;
import enderglove.common.lib.LibInfo;

/**
 * @author Surseance
 *
 */
public class BlockTotemTop extends BlockEnderTotem
{
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir)
	{
		this.blockIcon = ir.registerIcon(LibInfo.PREFIX + "endertotem");
	}

	public BlockTotemTop()
	{
		super();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int md, float hitX, float hitY, float hitZ)
	{
		player.addExperience(100);
		player.inventory.addItemStackToInventory(new ItemStack(InitItems.itemEnderGlove));
		world.setBlock(x, y, z, InitBlocks.blockEnderTotem);
		return true;
	}
}
