package brassutils.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.event.FMLInterModComms;

public class IMCHelper
{
	public static void addNewSmeltable(Item item, int metadata, Block toRender, FluidStack toProduce, int tempRequired)
	{
		NBTTagCompound tag = new NBTTagCompound();
		NBTTagCompound itemtag = new NBTTagCompound();
		(new ItemStack(item, 1, metadata)).writeToNBT(itemtag);
		tag.setTag("Item", itemtag);
		NBTTagCompound block = new NBTTagCompound();
		(new ItemStack(toRender, 1)).writeToNBT(block);
		tag.setTag("Block", block);
		toProduce.writeToNBT(tag);
		tag.setInteger("Temperature", tempRequired);
		FMLInterModComms.sendMessage("TConstruct", "addSmelteryMelting", tag);
	}
}
