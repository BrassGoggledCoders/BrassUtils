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
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import endergloves.common.EnderGloves;
import endergloves.common.config.Config;
import endergloves.common.lib.EventHandlerWorld;
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

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(LibInfo.PREFIX + "enderglove");
	}

	public ItemEnderGlove()
	{
		super(2.0F, Item.ToolMaterial.STONE, blocksEffectiveAgainst);
		this.setCreativeTab(EnderGloves.tabEG);
		this.setNoRepair();
	}

	//@Override
	//public float func_150893_a(ItemStack is, Block block) // getStrVsBlock
	//{
	//	return this.blocksEffectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : 1.0F;
	//}

	@Override
	public boolean hitEntity(ItemStack is, EntityLivingBase target, EntityLivingBase attacker) // I think that's the right order xD
	{	
		return false;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving)
	{
		InventoryEnderChest enderInv = InventoryHelper.getPlayerEnderChest((EntityPlayer)entityLiving);

		int flameAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchFlameTouchId, is);
		ItemStack smeltableBlock = (new ItemStack(block));

		if ((flameAmount > 0) && (Utils.isSmeltable(smeltableBlock)))
		{
			ItemStack drops = FurnaceRecipes.smelting().getSmeltingResult(smeltableBlock).copy();
			InventoryHelper.addItemStackToInventory(enderInv, drops);
			EnderGloves.proxy.blockFlameFX(world, x, y, z, 4);
			Utils.playSFX(world, x, y, z, "fire.ignite");
		}
		else if (block.canSilkHarvest(world, (EntityPlayer)entityLiving, x, y, z, world.getBlockMetadata(x, y, z)) && (EnchantmentHelper.getSilkTouchModifier((EntityPlayer)entityLiving)))
		{
			ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
			ItemStack drops = Utils.createStackedBlock(block, world.getBlockMetadata(x, y, z));

			if (drops != null)
				itemList.add(drops);

			for (ItemStack stack : itemList)
			{
				InventoryHelper.addItemStackToInventory(InventoryHelper.getPlayerEnderChest((EntityPlayer)entityLiving), drops);
				EnderGloves.proxy.blockSparkle(world, x, y, z, 4);
				Utils.playSFX(world, x, y, z, "mob.endermen.portal");
			}
		}
		else
		{
			ItemStack drops = Utils.getDroppedItemStack(world, entityLiving, block, x, y, z).copy(); // I dunno why, but you need a copy...
			InventoryHelper.addItemStackToInventory(enderInv, drops);
			EnderGloves.proxy.blockSparkle(world, x, y, z, 4);
			Utils.playSFX(world, x, y, z, "mob.endermen.portal");
		}

		return super.onBlockDestroyed(is, world, block, x, y, z, entityLiving); 
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public int getItemEnchantability()
	{	
		return this.toolMaterial.getEnchantability();
	}

	@Override
	public int getHarvestLevel(ItemStack is, String toolClass)
	{
		return Items.iron_pickaxe.getHarvestLevel(is, toolClass);
	}

	@Override
	public float getDigSpeed(ItemStack is, Block block, int metadata)
	{
		return 1.3F;
	}

	@Override
	public EnumRarity getRarity(ItemStack is)
	{
		return EnumRarity.epic; 
	}

	@Override
	public boolean onBlockStartBreak(ItemStack is, int x, int y, int z, EntityPlayer player)
	{
		return super.onBlockStartBreak(is, x, y, z, player);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		return true;
	}
}
