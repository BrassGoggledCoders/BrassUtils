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
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
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
import enderglove.common.lib.InventoryHelper;
import enderglove.common.lib.LibInfo;
import enderglove.common.lib.Utils;

/**
 * This class is the whole point of this mod.
 *
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
public class ItemEnderGlove extends ItemTool
{
	private static final Set blocksEffectiveAgainst = Sets
			.newHashSet(new Block[] { Blocks.cobblestone, Blocks.stone });

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir)
	{
		itemIcon = ir.registerIcon(LibInfo.PREFIX + "enderglove");
	}

	public ItemEnderGlove()
	{
		super(2.0F, Item.ToolMaterial.STONE, blocksEffectiveAgainst);
		setCreativeTab(CreativeTabs.tabTools);
		setNoRepair();
		setMaxDamage(350);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List list,
			boolean flag)
	{
		list.add(EnumChatFormatting.GREEN + "The power of the End");
		list.add(EnumChatFormatting.GREEN + "in your hands!");
	}

	// @Override
	// public float func_150893_a(ItemStack is, Block block) // getStrVsBlock
	// {
	// return this.blocksEffectiveAgainst.contains(block) ?
	// this.efficiencyOnProperMaterial : 1.0F;
	// }

	@Override
	public boolean hitEntity(ItemStack is, EntityLivingBase target,
			EntityLivingBase attacker) // I think that's the right order xD
	{
		return false;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack is, World world, Block block,
			int x, int y, int z, EntityLivingBase entityLiving)
	{
		EntityPlayer player = (EntityPlayer) entityLiving;
		InventoryEnderChest enderInv = InventoryHelper
				.getPlayerEnderChest(player);
		int md = world.getBlockMetadata(x, y, z);

		int flameAmount = EnchantmentHelper.getEnchantmentLevel(
				Config.enchFlameTouchId, is);
		ItemStack smeltableBlock = Utils.getDroppedItemStack(world, player,
				block, x, y, z, md);

		if (flameAmount > 0 && Utils.isSmeltable(smeltableBlock))
		{
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			ItemStack drops = FurnaceRecipes.smelting().getSmeltingResult(
					smeltableBlock);// .copy();

			if (drops != null)
				items.add(drops);

			for (ItemStack stack : items)
			{
				if (InventoryHelper.isInvEmpty(enderInv, stack))
					InventoryHelper.addItemStackToInventory(
							InventoryHelper.getPlayerEnderChest(player), stack);
			}

			EnderGlove.proxy.blockFlameFX(world, x, y, z, 4);
			Utils.playSFX(world, x, y, z, "fire.ignite");
		}
		else if (EnchantmentHelper.getSilkTouchModifier(player)
				&& block.canSilkHarvest(world, player, x, y, z, md))
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
				if (InventoryHelper.isInvEmpty(enderInv, drops))
					InventoryHelper.addItemStackToInventory(enderInv, drops);
			}

			EnderGlove.proxy.blockSparkleFX(world, x, y, z, 4);
			Utils.playSFX(world, x, y, z, "mob.endermen.portal");
		}
		else
		{
			ArrayList<ItemStack> items = block.getDrops(world, x, y, z, md,
					EnchantmentHelper.getFortuneModifier(player));

			for (ItemStack drops : items)
			{
				if (InventoryHelper.isInvEmpty(enderInv, drops))
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
		return 1.3F;
	}

	@Override
	public EnumRarity getRarity(ItemStack is)
	{
		return EnumRarity.epic;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack is, int x, int y, int z,
			EntityPlayer player)
	{
		return super.onBlockStartBreak(is, x, y, z, player);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world,
			EntityPlayer player)
	{
		int teleAmount = EnchantmentHelper.getEnchantmentLevel(
				Config.enchTeleportId, is);

		if (teleAmount > 0)
		{
			world.playSoundAtEntity(player, "random.bow", 0.5F,
					0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			is.damageItem(3, player);

			if (!world.isRemote)
				world.spawnEntityInWorld(new EntityEnderPearl(world, player));
		}

		return is;
	}

	/*
	 * TODO: Might use this for a better, cleaner teleport public static
	 * MovingObjectPosition getTargetBlock(World world, Entity entity, boolean
	 * flag) { float var4 = 1.0F; float var5 = entity.prevRotationPitch +
	 * (entity.rotationPitch - entity.prevRotationPitch) * var4; float var6 =
	 * entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) *
	 * var4; double var7 = entity.prevPosX + (entity.posX - entity.prevPosX) *
	 * var4; double var9 = entity.prevPosY + (entity.posY - entity.prevPosY) *
	 * var4 + 1.62D - entity.yOffset; double var11 = entity.prevPosZ +
	 * (entity.posZ - entity.prevPosZ) * var4; Vec3 var13 =
	 * world.getWorldVec3Pool().getVecFromPool(var7, var9, var11); float var14 =
	 * MathHelper.cos(-var6 * 0.01745329F - 3.141593F); float var15 =
	 * MathHelper.sin(-var6 * 0.01745329F - 3.141593F); float var16 =
	 * -MathHelper.cos(-var5 * 0.01745329F); float var17 = MathHelper.sin(-var5
	 * * 0.01745329F); float var18 = var15 * var16; float var20 = var14 * var16;
	 * double var21 = 10.0D; Vec3 var23 = var13.addVector(var18 * var21, var17 *
	 * var21, var20 * var21); return world.rayTraceBlocks(var13, var23, flag); }
	 */
}
