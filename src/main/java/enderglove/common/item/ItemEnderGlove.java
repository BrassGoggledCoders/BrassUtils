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
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
public class ItemEnderGlove extends ItemTool
{
	private static final Set<Block> blocksEffectiveAgainst = Sets
			.newHashSet(new Block[] { Blocks.cobblestone, Blocks.stone });
	private int xCoord, yCoord, zCoord;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(final IIconRegister ir)
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

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(final ItemStack is, final EntityPlayer player,
			@SuppressWarnings("rawtypes") final List list, final boolean flag)
	{
		list.add(EnumChatFormatting.GREEN + "The power of the End");
		list.add(EnumChatFormatting.GREEN + "in your hands!");
	}

	@Override
	public float func_150893_a(final ItemStack is, final Block block) // getStrVsBlock
	{
		final int effAmount = EnchantmentHelper.getEnchantmentLevel(
				Enchantment.efficiency.effectId, is);

		if (effAmount > 0)
		{
			return 1.3F;
		}

		return blocksEffectiveAgainst.contains(block) ? efficiencyOnProperMaterial
				: 1.0F;
	}

	@Override
	public boolean hitEntity(final ItemStack is, final EntityLivingBase target,
			final EntityLivingBase attacker)
	{
		if (attacker instanceof EntityPlayer)
		{
			final EntityPlayer player = (EntityPlayer) attacker;

			if (player.capabilities.isCreativeMode)
			{
				target.moveEntity(xCoord, yCoord, zCoord);
				target.setPosition(xCoord, yCoord, zCoord);

				// EnderGlove.proxy.blockSparkleFX(player.worldObj,
				// (int)target.prevPosX, (int)target.prevPosY,
				// (int)target.prevPosZ, 4);
				Utils.playSFX(player.worldObj, (int) target.prevPosX,
						(int) target.prevPosY, (int) target.prevPosZ,
						"mob.endermen.portal");
			}
		}

		if (target instanceof EntityEnderman)
		{
		}

		return false;
	}

	@Override
	public boolean onBlockDestroyed(final ItemStack is, final World world,
			final Block block, final int x, final int y, final int z,
			final EntityLivingBase entityLiving)
	{
		final int md = world.getBlockMetadata(x, y, z);

		if (world.isRemote)
		{
			final EntityMinedBlock entBlock = new EntityMinedBlock(world,
					x + 0.5F, y + 0.5F, z + 0.5F, block, md);
			world.spawnEntityInWorld(entBlock);
		}

		final EntityPlayer player = (EntityPlayer) entityLiving;
		final InventoryEnderChest enderInv = InventoryHelper
				.getPlayerEnderChest(player);

		final int flameAmount = EnchantmentHelper.getEnchantmentLevel(
				Config.enchFlameTouchId, is);
		final ItemStack smeltableBlock = Utils.getDroppedItemStack(world,
				player, block, x, y, z, md);

		if (flameAmount > 0 && Utils.isSmeltable(smeltableBlock))
		{
			final ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			final ItemStack drops = FurnaceRecipes.smelting()
					.getSmeltingResult(smeltableBlock);// .copy();

			if (drops != null)
			{
				items.add(drops);
			}

			for (final ItemStack stack : items)
			{
				if (InventoryHelper.isInvEmpty(enderInv, stack)
						&& (world.isRemote))
				{
					InventoryHelper.addItemStackToInventory(
							InventoryHelper.getPlayerEnderChest(player), stack);
				}
			}

			EnderGlove.proxy.blockFlameFX(world, x, y, z, 4);
			Utils.playSFX(world, x, y, z, "fire.ignite");
		}
		else if (EnchantmentHelper.getSilkTouchModifier(player)
				&& block.canSilkHarvest(world, player, x, y, z, md))
		{
			final ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			ItemStack stack = null;

			if (block instanceof BlockRedstoneOre)
			{
				stack = Utils.createStackedBlock();
			}
			else
			{
				stack = Utils.createStackedBlock(block, md);
			}

			if (stack != null)
			{
				items.add(stack);
			}

			for (final ItemStack drops : items)
			{
				if (InventoryHelper.isInvEmpty(enderInv, drops)
						&& (world.isRemote))
				{
					InventoryHelper.addItemStackToInventory(enderInv, drops);
				}
			}

			EnderGlove.proxy.blockSparkleFX(world, x, y, z, 4);
			Utils.playSFX(world, x, y, z, "mob.endermen.portal");
		}
		else
		{
			final ArrayList<ItemStack> items = block.getDrops(world, x, y, z,
					md, EnchantmentHelper.getFortuneModifier(player));

			for (final ItemStack drops : items)
			{
				if (InventoryHelper.isInvEmpty(enderInv, drops)
						&& (world.isRemote))
				{
					InventoryHelper.addItemStackToInventory(enderInv, drops);
				}
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
	public int getHarvestLevel(final ItemStack is, final String toolClass)
	{
		return Items.iron_pickaxe.getHarvestLevel(is, toolClass);
	}

	@Override
	public float getDigSpeed(final ItemStack is, final Block block,
			final int metadata)
	{
		final int effAmount = EnchantmentHelper.getEnchantmentLevel(
				Enchantment.efficiency.effectId, is);

		if (effAmount > 0)
		{
			return 1.3F;
		}

		return 1.3F;
	}

	@Override
	public EnumRarity getRarity(final ItemStack is)
	{
		return EnumRarity.epic;
	}

	@Override
	public boolean onBlockStartBreak(final ItemStack is, final int x,
			final int y, final int z, final EntityPlayer player)
	{
		return super.onBlockStartBreak(is, x, y, z, player);
	}

	@Override
	public boolean onDroppedByPlayer(final ItemStack item,
			final EntityPlayer player)
	{
		return true;
	}

	@Override
	public ItemStack onItemRightClick(final ItemStack is, final World world,
			final EntityPlayer player)
	{
		final int teleAmount = EnchantmentHelper.getEnchantmentLevel(
				Config.enchTeleportId, is);

		if (teleAmount > 0)
		{
			world.playSoundAtEntity(player, "random.bow", 0.5F,
					0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			is.damageItem(1, player);

			if (!world.isRemote)
			{
				world.spawnEntityInWorld(new EntityEnderPearl(world, player));
			}

			// player.mountEntity(pearl); Fun, but broken, and not really a
			// teleport anymore
		}

		return is;
	}

	@Override
	public boolean onItemUse(final ItemStack is, final EntityPlayer player,
			final World world, final int x, final int y, final int z,
			final int md, final float hitX, final float hitY, final float hitZ)
	{
		final int creativeAmount = EnchantmentHelper.getEnchantmentLevel(
				Config.enchCreativeId, is);

		if ((creativeAmount > 0) && (player.isSneaking())
				&& (player.capabilities.isCreativeMode))
		{
			xCoord = x;
			yCoord = y;
			zCoord = z;

			Utils.sendMessage(player, "Position set to: [" + xCoord + ", "
					+ yCoord + ", " + zCoord + "]");
			Utils.playSFX(world, x, y, z, "random.orb");

			return true;
		}

		return super
				.onItemUse(is, player, world, x, y, z, md, hitX, hitY, hitZ);
	}
}
