
package brassutils.common.block;

import brassutils.common.InitBlocks;
import brassutils.common.InitItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author Surseance
 */
public class BlockTotemTop extends BlockEnderTotem
{

	public BlockTotemTop()
	{
		super();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int md, float hitX,
			float hitY, float hitZ)
	{
		player.addExperience(100);
		player.inventory.addItemStackToInventory(new ItemStack(InitItems.itemEnderGlove));
		world.setBlock(x, y, z, InitBlocks.blockEnderTotem);
		return true;
	}
}
