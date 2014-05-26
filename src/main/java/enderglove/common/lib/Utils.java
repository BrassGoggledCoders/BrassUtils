/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:07:32 PM]
 */
package enderglove.common.lib;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import enderglove.common.item.ItemEnderGlove;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
public class Utils
{
	/**
	 * Hmm...I wonder what this method does? Indeed! It *does* spawn chickens!
	 *
	 * @param player
	 *            - the player to send the message
	 * @param message
	 *            - the message to send
	 */
	public static void sendMessage( EntityPlayer player,
			 String message)
	{
		 IChatComponent chat = new ChatComponentText(message);

		if (!player.worldObj.isRemote)
		{
			player.addChatMessage(chat);
		}
	}

	/**
	 * Determines what a block's drops are without checking for fortune values
	 * (useful for the Flame Touch enchantment).
	 *
	 * @param world
	 *            - the world "Minecraftia"
	 * @param player
	 *            - the player breaking the block
	 * @param block
	 *            - the block being broken
	 * @param x
	 *            - block xCoord
	 * @param y
	 *            - block yCoord
	 * @param z
	 *            - block zCoord
	 * @param md
	 *            - block metadata
	 * @return the block's drops
	 */
	public static ItemStack getDroppedItemStack( World world,
			 EntityPlayer player,  Block block,  int x,
			 int y,  int z,  int md)
	{
		 ArrayList<ItemStack> items = block.getDrops(world, x, y, z, md,
				EnchantmentHelper.getFortuneModifier(player));
		ItemStack drops = null;

		if (items != null && items.size() > 0)
		{
			for (int size = 0; size < items.size(); size++)
			{
				drops = items.get(size);
			}
		}

		return drops;
	}

	/**
	 * Determines whether the given block stored in the item stack can be
	 * smelted.
	 *
	 * @param is
	 *            - the item stack to check
	 * @return false if it cannot be smelted
	 */
	public static boolean isSmeltable( ItemStack is)
	{
		return is == null
				|| FurnaceRecipes.smelting().getSmeltingResult(is) == null ? false
				: true;
	}

	/**
	 * Plays a sound at the given location. It's an ugly method, that's why I
	 * moved it here.
	 *
	 * @param world
	 *            - the world. What else?
	 * @param x
	 *            - block xCoord
	 * @param y
	 *            - block yCoord
	 * @param z
	 *            - block zCoord
	 * @param sound
	 *            - sound name
	 */
	public static void playSFX( World world,  int x,  int y,
			 int z,  String sound)
	{
		world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, sound, 1.0F,
				world.rand.nextFloat() * 0.4F + 0.8F);
	}

	/**
	 * Determines whether the player is wearing an instance of an Ender Glove.
	 *
	 * @param player
	 *            - the player carrying the item
	 * @return false if not carrying
	 */
	public static boolean isCarryingGlove( EntityPlayer player)
	{
		if (player != null
				&& player.inventory.getCurrentItem() != null
				&& player.inventory.getCurrentItem().getItem() instanceof ItemEnderGlove)
		{
			return true;
		}

		return false;
	}

	/**
	 * Creates a new item-based, metadata-inclusive item stack for the given
	 * block and metadata. Relays the metadata to item subtypes.
	 *
	 * @param block
	 *            - the block to be converted
	 * @param metadata
	 *            - the metadata > subtypes
	 * @return new item stack
	 */
	public static ItemStack createStackedBlock( Block block,
			 int metadata)
	{
		int md = 0;
		 Item item = Item.getItemFromBlock(block);

		if (item != null && item.getHasSubtypes())
		{
			md = metadata;
		}

		return new ItemStack(item, 1, md);
	}

	/**
	 * Only used for BlockRedstoneOre. If you use the above method, it'll crash
	 * your game. Guaranteed.
	 *
	 * @return new item stack
	 */
	public static ItemStack createStackedBlock()
	{
		return new ItemStack(Blocks.redstone_ore);
	}

	@SuppressWarnings("unused")
	private boolean handleTileEntities() // TODO: Some handling for TileEntities
	{
		/*
		 * TileEntityFurnace tileentityfurnace =
		 * (TileEntityFurnace)p_149749_1_.getTileEntity(p_149749_2_,
		 * p_149749_3_, p_149749_4_);
		 *
		 * if (tileentityfurnace != null) { for (int i1 = 0; i1 <
		 * tileentityfurnace.getSizeInventory(); ++i1) { ItemStack itemstack =
		 * tileentityfurnace.getStackInSlot(i1);
		 *
		 * if (itemstack != null) { float f = this.field_149933_a.nextFloat() *
		 * 0.8F + 0.1F; float f1 = this.field_149933_a.nextFloat() * 0.8F +
		 * 0.1F; float f2 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
		 *
		 * while (itemstack.stackSize > 0) { int j1 =
		 * this.field_149933_a.nextInt(21) + 10;
		 *
		 * if (j1 > itemstack.stackSize) { j1 = itemstack.stackSize; }
		 *
		 * itemstack.stackSize -= j1; EntityItem entityitem = new
		 * EntityItem(p_149749_1_, (double)((float)p_149749_2_ + f),
		 * (double)((float)p_149749_3_ + f1), (double)((float)p_149749_4_ + f2),
		 * new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
		 *
		 * if (itemstack.hasTagCompound()) {
		 * entityitem.getEntityItem().setTagCompound
		 * ((NBTTagCompound)itemstack.getTagCompound().copy()); }
		 *
		 * float f3 = 0.05F; entityitem.motionX =
		 * (double)((float)this.field_149933_a.nextGaussian() * f3);
		 * entityitem.motionY =
		 * (double)((float)this.field_149933_a.nextGaussian() * f3 + 0.2F);
		 * entityitem.motionZ =
		 * (double)((float)this.field_149933_a.nextGaussian() * f3);
		 * p_149749_1_.spawnEntityInWorld(entityitem); } } }
		 *
		 * p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_,
		 * p_149749_5_); }
		 */

		return false;
	}
}
