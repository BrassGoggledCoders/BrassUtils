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
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import endergloves.common.EnderGloves;
import endergloves.common.config.Config;
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
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setNoRepair();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag)
	{
		list.add("\247O\2472The power of the End");
		list.add("\247O\2472in your hands!");
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
		EntityPlayer player = (EntityPlayer)entityLiving;
		InventoryEnderChest enderInv = InventoryHelper.getPlayerEnderChest(player);
		int md = world.getBlockMetadata(x, y, z);

		int flameAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchFlameTouchId, is);
		ItemStack smeltableBlock = (new ItemStack(block));

		if ((flameAmount > 0) && (Utils.isSmeltable(smeltableBlock)))
		{
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			ItemStack drops = FurnaceRecipes.smelting().getSmeltingResult(smeltableBlock).copy();

			if (drops != null)
				items.add(drops);

			for (ItemStack stack : items)
			{
				InventoryHelper.addItemStackToInventory(enderInv, stack);
				EnderGloves.proxy.blockFlameFX(world, x, y, z, 4);
				Utils.playSFX(world, x, y, z, "fire.ignite");
			}
		}
		else if (block.canSilkHarvest(world, player, x, y, z, md) && (EnchantmentHelper.getSilkTouchModifier(player)))
		{
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			ItemStack drops = Utils.createStackedBlock(block, md);

			if (drops != null)
				items.add(drops);

			for (ItemStack stack : items) 
			{
				InventoryHelper.addItemStackToInventory(enderInv, stack);
				EnderGloves.proxy.blockSparkle(world, x, y, z, 4);
				Utils.playSFX(world, x, y, z, "mob.endermen.portal");
			}
		}
		else
		{
			ArrayList<ItemStack> items = block.getDrops(world, x, y, z, md, EnchantmentHelper.getFortuneModifier(player));
			
			for (ItemStack stack : items)
			{
				InventoryHelper.addItemStackToInventory(enderInv, stack);
				//this.addBlockToChest(world, player, x, y, z, md, 1.0F, fortune);
				EnderGloves.proxy.blockSparkle(world, x, y, z, 4);
				Utils.playSFX(world, x, y, z, "mob.endermen.portal");
			}
		}

		return super.onBlockDestroyed(is, world, block, x, y, z, entityLiving); 
	}

	public void addBlockToChest(World world, EntityPlayer player, int x, int y, int z, int md, float chance, int enchantmentModifier)
	{
		Block block = world.getBlock(x, y, z);

		if (!world.isRemote)
		{
			ArrayList<ItemStack> items = block.getDrops(world, x, y, z, md, enchantmentModifier);

			for (ItemStack item : items)
			{
				if (world.rand.nextFloat() <= chance)
					InventoryHelper.addItemStackToInventory(InventoryHelper.getPlayerEnderChest(player), item);//this.dropBlockAsItem(world, x, y, z, item);
			}
		}
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
