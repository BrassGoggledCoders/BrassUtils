
package xyz.brassgoggledcoders.brassutils.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import xyz.brassgoggledcoders.boilerplate.lib.common.items.BaseItem;
import xyz.brassgoggledcoders.brassutils.common.BrassUtils;

/**
 * @author Surseance
 *
 */
public class ItemEnderPocket extends BaseItem
{
	public ItemEnderPocket()
	{
		super();
		this.setFull3D();
		this.setCreativeTab(BrassUtils.tabBU);
		this.setNoRepair();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.openGui(BrassUtils.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		return stack;
	}

	@SuppressWarnings("all")
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag)
	{
		// TODO
		list.add(EnumChatFormatting.GREEN + "Shows a random");
		list.add(EnumChatFormatting.GREEN + "six slots from your ender chest");
	}

	@Override
	public EnumRarity getRarity(ItemStack is)
	{
		return EnumRarity.RARE;
	}
}
