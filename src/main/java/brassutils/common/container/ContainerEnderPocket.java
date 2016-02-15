
package brassutils.common.container;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

import xyz.brassgoggledcoders.boilerplate.lib.common.utils.InventoryUtils;

/**
 * @author Surseance
 *
 */
public class ContainerEnderPocket extends Container
{
	Random random = new Random();

	public ContainerEnderPocket(InventoryPlayer player)
	{
		int var3;

		this.addSlotToContainer(new Slot(InventoryUtils.getPlayerEnderChest(player.player),
				this.random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 63, 25));
		this.addSlotToContainer(new Slot(InventoryUtils.getPlayerEnderChest(player.player),
				this.random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 81, 25));
		this.addSlotToContainer(new Slot(InventoryUtils.getPlayerEnderChest(player.player),
				this.random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 99, 25));
		this.addSlotToContainer(new Slot(InventoryUtils.getPlayerEnderChest(player.player),
				this.random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 63, 43));
		this.addSlotToContainer(new Slot(InventoryUtils.getPlayerEnderChest(player.player),
				this.random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 81, 43));
		this.addSlotToContainer(new Slot(InventoryUtils.getPlayerEnderChest(player.player),
				this.random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 99, 43));

		// Inv
		for (var3 = 0; var3 < 3; ++var3)
		{
			for (int var4 = 0; var4 < 9; ++var4)
			{
				this.addSlotToContainer(new Slot(player, var4 + (var3 * 9) + 9, 8 + (var4 * 18), 84 + (var3 * 18)));
			}
		}
		// Hotbar
		for (var3 = 0; var3 < 9; ++var3)
		{
			this.addSlotToContainer(new Slot(player, var3, 8 + (var3 * 18), 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return true;
	}
}
