/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:38:46 PM] 
 */
package endergloves.common.item;

import java.util.ArrayList;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import endergloves.common.EnderGloves;
import endergloves.common.lib.InventoryHelper;
import endergloves.common.lib.LibInfo;
import endergloves.common.lib.Utils;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class ItemEnderGlove extends ItemTool 
{
	private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] { Blocks.cobblestone, Blocks.stone });
	public static boolean hasFired = false;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(LibInfo.PREFIX + "temp");
	}

	public ItemEnderGlove()
	{
		super(2.0F, Item.ToolMaterial.STONE, blocksEffectiveAgainst);
		this.setCreativeTab(EnderGloves.tabEG);
	}

	@Override
	public float func_150893_a(ItemStack is, Block block) // getStrVsBlock
	{
		return this.blocksEffectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : 1.0F;
	}

	@Override
	public boolean hitEntity(ItemStack is, EntityLivingBase target, EntityLivingBase attacker) // I think that's the right order xD
	{	
		return false;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving)
	{
		super.onBlockDestroyed(is, world, block, x, y, z, entityLiving);
		InventoryEnderChest enderInv = InventoryHelper.getPlayerEnderChest((EntityPlayer)entityLiving);
		//ItemStack drop = block.get
		
		if ((InventoryHelper.getFirstEmptySlot(enderInv, new ItemStack(block)) != -1) && (InventoryHelper.getNonFilledStack(enderInv, new ItemStack(block)) != -1))
			InventoryHelper.addItemStackToInventory(enderInv, new ItemStack(block));
		else
			Utils.sendMessageToPlayer((EntityPlayer)entityLiving, "Oh noes! No room in your Ender Chest!", ((EntityPlayer)entityLiving).getDisplayName());
		
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack is1, ItemStack is2)
	{
		return false;
	}

	@Override
	public int getHarvestLevel(ItemStack is, String toolClass)
	{
		return Items.stone_pickaxe.getHarvestLevel(is, toolClass);
	}

	@Override
	public float getDigSpeed(ItemStack is, Block block, int metadata)
	{
		return 2.0F;
	}

	@Override
	public EnumRarity getRarity(ItemStack is)
	{
		return EnumRarity.epic; 
	}

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			ChunkPosition chunkPos = world.findClosestStructure("Stronghold", (int)player.posX, (int)player.posY, (int)player.posZ);

			if (chunkPos != null)
			{
				EntityEnderEye enderEye = new EntityEnderEye(world, player.posX, player.posY + 1.62D - (double)player.yOffset, player.posZ);
				enderEye.moveTowards((double)chunkPos.chunkPosX, chunkPos.chunkPosY, (double)chunkPos.chunkPosZ);
				world.spawnEntityInWorld(enderEye);
				world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				world.playAuxSFXAtEntity((EntityPlayer)null, 1002, (int)player.posX, (int)player.posY, (int)player.posZ, 0);
				this.hasFired = true;
			}
		}
		
		return is;
	}
}
