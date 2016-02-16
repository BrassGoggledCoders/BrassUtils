
package xyz.brassgoggledcoders.brassutils.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import net.minecraftforge.fml.common.network.IGuiHandler;

import xyz.brassgoggledcoders.brassutils.common.container.ContainerEnderPocket;

/**
 * @author Surseance
 *
 */
public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
		case 0:
			return new ContainerEnderPocket(player.inventory);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		switch (ID)
		{
		case 0:
			return new GuiEnderPocket(new ContainerEnderPocket(player.inventory));
		}
		return null;
	}

}
