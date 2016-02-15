
package brassutils.common.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import brassutils.common.InitBlocks;
import brassutils.common.InitItems;
import brassutils.common.lib.ModInfo;

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
		this.blockIcon = ir.registerIcon(ModInfo.PREFIX + "endertotem");
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
