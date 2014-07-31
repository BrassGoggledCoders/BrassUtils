package enderglove.common.container;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import boilerplate.common.utils.InventoryUtils;

public class ContainerEnderPocket extends Container
{
	Random random = new Random();
		public ContainerEnderPocket(InventoryPlayer player)
		{
			int var3;

			addSlotToContainer(new SlotEnder(InventoryUtils.getPlayerEnderChest(player.player), random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 40, 13));
			addSlotToContainer(new SlotEnder(InventoryUtils.getPlayerEnderChest(player.player), random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 60, 13));
			addSlotToContainer(new SlotEnder(InventoryUtils.getPlayerEnderChest(player.player), random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 80, 13));
			addSlotToContainer(new SlotEnder(InventoryUtils.getPlayerEnderChest(player.player), random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 40, 33));
			addSlotToContainer(new SlotEnder(InventoryUtils.getPlayerEnderChest(player.player), random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 60, 33));
			addSlotToContainer(new SlotEnder(InventoryUtils.getPlayerEnderChest(player.player), random.nextInt(InventoryUtils.getPlayerEnderChest(player.player).getSizeInventory()), 80, 33));

			//Inv
			for (var3 = 0; var3 < 3; ++var3)
				for (int var4 = 0; var4 < 9; ++var4)
					addSlotToContainer(new Slot(player, var4 + (var3 * 9) + 9, 8 + (var4 * 18), 84 + (var3 * 18)));
			//Hotbar
			for (var3 = 0; var3 < 9; ++var3)
				addSlotToContainer(new Slot(player, var3, 8 + (var3 * 18), 142));
		}
	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
		return true;
	}

}
