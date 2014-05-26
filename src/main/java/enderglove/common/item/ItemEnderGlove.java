/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:38:46 PM]
 */
package enderglove.common.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enderglove.common.EnderGlove;
import enderglove.common.config.Config;
import enderglove.common.entity.EntityMinedBlock;
import enderglove.common.lib.InventoryHelper;
import enderglove.common.lib.LibInfo;
import enderglove.common.lib.Utils;

/**
 * This class is the whole point of this mod.
 *
 * @author Surseance (Johnny Eatmon) 
 * <jmaeatmon@gmail.com>
 *
 */
public class ItemEnderGlove extends ItemTool
{
	private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[] { Blocks.cobblestone, Blocks.stone });
	private int xCoord, yCoord, zCoord;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir)
	{
		itemIcon = ir.registerIcon(LibInfo.PREFIX + "enderglove");
	}

	public ItemEnderGlove() 
	{
		super(2.0F, Item.ToolMaterial.STONE, blocksEffectiveAgainst);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setNoRepair();
		this.setMaxDamage(350);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag)
	{
		list.add(EnumChatFormatting.GREEN + "The power of the End");
		list.add(EnumChatFormatting.GREEN + "in your hands!");
	}

	//@Override
	//public float func_150893_a(ItemStack is, Block block) // getStrVsBlock
	//{
	//	int effAmount = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, is);

	//	if (effAmount > 0)
	//		return 1.3F;

	//	return this.blocksEffectiveAgainst.contains(block) ? this.efficiencyOnProperMaterial : 1.0F;
	//}

	@Override
	public boolean hitEntity(ItemStack is, EntityLivingBase target, EntityLivingBase attacker) 
	{
		if (attacker instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)attacker;

			if (player.capabilities.isCreativeMode)
			{
				target.moveEntity(this.xCoord, this.yCoord, this.zCoord);
				target.setPosition(this.xCoord, this.yCoord, this.zCoord);

				//EnderGlove.proxy.blockSparkleFX(player.worldObj, (int)target.prevPosX, (int)target.prevPosY, (int)target.prevPosZ, 4);
				Utils.playSFX(player.worldObj, (int)target.prevPosX, (int)target.prevPosY, (int)target.prevPosZ, "mob.endermen.portal");
			}
		}

		if (target instanceof EntityEnderman)
		{
			EntityEnderman enderman = (EntityEnderman)target;
		}

		return false;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving)
	{
		int md = world.getBlockMetadata(x, y, z);

		if (world.isRemote)
		{
			EntityMinedBlock entBlock = new EntityMinedBlock(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block, md);
			world.spawnEntityInWorld(entBlock);
		}

		EntityPlayer player = (EntityPlayer) entityLiving; 
		InventoryEnderChest enderInv = InventoryHelper.getPlayerEnderChest(player);	

		int flameAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchFlameTouchId, is);
		ItemStack smeltableBlock = Utils.getDroppedItemStack(world, player, block, x, y, z, md);

		if (flameAmount > 0 && Utils.isSmeltable(smeltableBlock))
		{
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			ItemStack drops = FurnaceRecipes.smelting().getSmeltingResult(smeltableBlock);// .copy();

			if (drops != null)
				items.add(drops);

			for (ItemStack stack : items) 
			{
				if (InventoryHelper.isInvEmpty(enderInv, stack) && (world.isRemote))
					InventoryHelper.addItemStackToInventory(InventoryHelper.getPlayerEnderChest(player), stack);
			}

			EnderGlove.proxy.blockFlameFX(world, x, y, z, 4);
			Utils.playSFX(world, x, y, z, "fire.ignite");
		}
		else if (EnchantmentHelper.getSilkTouchModifier(player) && block.canSilkHarvest(world, player, x, y, z, md))
		{
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			ItemStack stack = null;

			if (block instanceof BlockRedstoneOre)
				stack = Utils.createStackedBlock();
			else
				stack = Utils.createStackedBlock(block, md);

			if (stack != null)
				items.add(stack);

			for (ItemStack drops : items)
			{
				if (InventoryHelper.isInvEmpty(enderInv, drops) && (world.isRemote))
					InventoryHelper.addItemStackToInventory(enderInv, drops);
			}

			EnderGlove.proxy.blockSparkleFX(world, x, y, z, 4);
			Utils.playSFX(world, x, y, z, "mob.endermen.portal");
		}
		else
		{
			ArrayList<ItemStack> items = block.getDrops(world, x, y, z, md, EnchantmentHelper.getFortuneModifier(player));

			for (ItemStack drops : items)
			{
				if (InventoryHelper.isInvEmpty(enderInv, drops) && (world.isRemote))
					InventoryHelper.addItemStackToInventory(enderInv, drops);
			}

			EnderGlove.proxy.blockSparkleFX(world, x, y, z, 4);
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
		return toolMaterial.getEnchantability();
	}

	@Override
	public int getHarvestLevel(ItemStack is, String toolClass)
	{
		return Items.iron_pickaxe.getHarvestLevel(is, toolClass);
	}

	@Override
	public float getDigSpeed(ItemStack is, Block block, int metadata)
	{
		int effAmount = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, is);

		if (effAmount > 0)
			return 1.3F;

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

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player)
	{
		int teleAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchTeleportId, is);

		if (teleAmount > 0)
		{
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			is.damageItem(1, player);

			if (!world.isRemote)
				world.spawnEntityInWorld(new EntityEnderPearl(world, player));
		}


		return is;
	}

	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int md, float hitX, float hitY, float hitZ)
	{
		int creativeAmount = EnchantmentHelper.getEnchantmentLevel(Config.enchCreativeId, is);

		if ((creativeAmount > 0) && (player.isSneaking()) && (player.capabilities.isCreativeMode)) 
		{
			this.xCoord = x;
			this.yCoord = y;
			this.zCoord = z; 

			Utils.sendMessage(player, "Position set to: [" + this.xCoord + ", " + this.yCoord + ", " + this.zCoord + "]");
			Utils.playSFX(world, x, y, z, "random.orb");

			return true;
		}

		return super.onItemUse(is, player, world, x, y, z, md, hitX, hitY, hitZ); 
	}
}
