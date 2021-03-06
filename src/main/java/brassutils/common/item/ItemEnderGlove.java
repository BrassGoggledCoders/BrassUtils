
package brassutils.common.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import boilerplate.common.entity.EntityMinedBlock;
import boilerplate.common.utils.InventoryUtils;
import boilerplate.common.utils.ItemStackUtils;
import boilerplate.common.utils.PlayerUtils;
import brassutils.common.BrassUtils;
import brassutils.common.InitConfig;
import brassutils.common.InitItems;
import brassutils.common.lib.ModInfo;
import brassutils.common.lib.Utils;
import com.google.common.collect.Sets;

/**
 * @author Surseance
 *
 */
public class ItemEnderGlove extends ItemTool
{
	private static final Set<Block> blocksEffectiveAgainst = Sets.newHashSet(new Block[] { Blocks.cobblestone, Blocks.stone });
	private int xCoord, yCoord, zCoord;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir)
	{
		this.itemIcon = ir.registerIcon(ModInfo.PREFIX + "enderglove");
	}

	public ItemEnderGlove()
	{
		super(1.0F, getToolLevel(), blocksEffectiveAgainst);
		this.setFull3D();
		this.setCreativeTab(BrassUtils.tabBU);
		this.setNoRepair();

		if (InitConfig.hasDurability)
		{
			this.setMaxDamage(InitConfig.durability);
		}
	}

	private static ToolMaterial getToolLevel()
	{
		int crystalsLevel = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchCrystalsId, new ItemStack(InitItems.itemEnderGlove));

		if (crystalsLevel > 0)
		{
			return Item.ToolMaterial.EMERALD;
		}
		else
		{
			return Item.ToolMaterial.IRON;
		}
	}

	@SuppressWarnings("all")
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag)
	{
		list.add(EnumChatFormatting.GREEN + "The power of the End");
		list.add(EnumChatFormatting.GREEN + "in your hands!");
	}

	@Override
	public boolean hitEntity(ItemStack is, EntityLivingBase target, EntityLivingBase attacker)
	{
		if (attacker instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) attacker;

			if ((player.capabilities.isCreativeMode) && (EnchantmentHelper.getEnchantmentLevel(InitConfig.enchCreativeId, is) > 0))
			{
				target.moveEntity(this.xCoord, this.yCoord, this.zCoord);
				target.setPosition(this.xCoord, this.yCoord, this.zCoord);

				// EnderGlove.proxy.blockSparkleFX(player.worldObj,
				// (int)target.prevPosX, (int)target.prevPosY,
				// (int)target.prevPosZ, 4);
				boilerplate.common.utils.Utils.playSFX(player.worldObj, (int) target.prevPosX, (int) target.prevPosY, (int) target.prevPosZ,
						"mob.endermen.portal");
			}
		}

		return false;
	}

	@Override
	// TODO: Clean up this method. It needs halp.
	public boolean onBlockDestroyed(ItemStack is, World world, Block block, int x, int y, int z, EntityLivingBase entityLiving)
	{
		EntityPlayer player = (EntityPlayer) entityLiving;
		InventoryEnderChest enderInv = InventoryUtils.getPlayerEnderChest(player);

		int md = world.getBlockMetadata(x, y, z);
		FMLLog.warning("" + md, "");

		if (world.isRemote)
		{
			world.spawnEntityInWorld(new EntityMinedBlock(world, x + 0.5F, y + 0.5F, z + 0.5F, block, md, true));
		}

		int flameAmount = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchFlameTouchId, is);
		ItemStack smeltableBlock = ItemStackUtils.getDroppedItemStack(world, player, block, x, y, z, md);

		if ((flameAmount > 0) && ItemStackUtils.isSmeltable(smeltableBlock))
		{
			ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(smeltableBlock).copy();

			byte level = (byte) EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, is);

			if (block.getLocalizedName().contains("Ore"))
			{
				switch (level)
				{
				case 1:
					stack.stackSize += world.rand.nextInt(2);
					break;
				case 2:
					stack.stackSize += 1;
					break;
				case 3:
					stack.stackSize += (1 + (world.rand.nextInt(7) / 6));
					break;
				}
			}

			if (!world.isRemote)
			{
				if (InventoryUtils.isInvEmpty(enderInv, stack))
				{
					InventoryUtils.addItemStackToInventory(InventoryUtils.getPlayerEnderChest(player), stack);
					// Utils.spawnBlockEntity(player, block, x, y, z, md,
					// stack);
				}
				else
				{
					ItemStackUtils.spawnStackInWorld(world, x, y, z, stack);
				}
			}

			BrassUtils.proxy.blockFlameFX(world, x, y, z, 4);
			boilerplate.common.utils.Utils.playSFX(world, x, y, z, "fire.ignite");
		}
		else if (EnchantmentHelper.getSilkTouchModifier(player) && block.canSilkHarvest(world, player, x, y, z, md))
		{
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
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

			for (ItemStack drops : items)
			{
				if (!world.isRemote)
				{
					if (InventoryUtils.isInvEmpty(enderInv, drops))
					{
						InventoryUtils.addItemStackToInventory(enderInv, drops);
						// Utils.spawnBlockEntity(player, block, x, y, z, md,
						// drops);
					}
					else
					{
						ItemStackUtils.spawnStackInWorld(world, x, y, z, drops);
					}
				}
			}

			BrassUtils.proxy.blockSparkleFX(world, x, y, z, 4);
			boilerplate.common.utils.Utils.playSFX(world, x, y, z, "mob.endermen.portal");
		}
		else
		{
			ArrayList<ItemStack> items = block.getDrops(world, x, y, z, md, EnchantmentHelper.getFortuneModifier(player));

			for (ItemStack drops : items)
			{
				if (!world.isRemote)
				{
					if (InventoryUtils.isInvEmpty(enderInv, drops))
					{
						InventoryUtils.addItemStackToInventory(enderInv, drops);
						// Utils.spawnBlockEntity(player, block, x, y, z, md,
						// drops);
					}
					else
					{
						ItemStackUtils.spawnStackInWorld(world, x, y, z, drops);
					}
				}
			}

			BrassUtils.proxy.blockSparkleFX(world, x, y, z, 4);
			boilerplate.common.utils.Utils.playSFX(world, x, y, z, "mob.endermen.portal");
		}

		return super.onBlockDestroyed(is, world, block, x, y, z, entityLiving);
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
	public float getDigSpeed(ItemStack is, Block block, int md)
	{
		return 2.0F;
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
		int teleAmount = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchTeleportId, is);

		if (teleAmount > 0)
		{
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / ((itemRand.nextFloat() * 0.4F) + 0.8F));
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
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int md, float hitX, float hitY, float hitZ)
	{
		int creativeAmount = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchCreativeId, is);

		if ((creativeAmount > 0) && (player.isSneaking()) && (player.capabilities.isCreativeMode))
		{
			this.xCoord = x;
			this.yCoord = y;
			this.zCoord = z;

			PlayerUtils.sendMessage(player, "Position set to: [" + this.xCoord + ", " + this.yCoord + ", " + this.zCoord + "]");
			boilerplate.common.utils.Utils.playSFX(world, x, y, z, "random.orb");

			return true;
		}
		int teleAmount = EnchantmentHelper.getEnchantmentLevel(InitConfig.enchTeleportId, is);
		if (player.inventory.hasItemStack(new ItemStack(Blocks.ender_chest)) && (teleAmount == 0))
		{
			world.setBlock(x, y + 1, z, Blocks.ender_chest, getRotationMeta(player), 2);
			player.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.ender_chest));

			return true;
		}
		else if (InventoryUtils.isInInventory(InventoryUtils.getPlayerEnderChest(player), new ItemStack(Blocks.ender_chest)) != -1)
		{
			world.setBlock(x, y + 1, z, Blocks.ender_chest, getRotationMeta(player), 2);
			// InventoryUtils.consumeEnderInventoryItem(player,
			// Item.getItemFromBlock(Blocks.ender_chest));

			return true;
		}

		return super.onItemUse(is, player, world, x, y, z, md, hitX, hitY, hitZ);
	}

	/**
	 * Called each tick as long the item is on a player inventory. Uses by maps
	 * to check if is on a player hand and update it's contents.
	 */
	@Override
	public void onUpdate(ItemStack stack, World world, Entity holder, int p_77663_4_, boolean selected)
	{
		if (!world.isRemote && (holder instanceof EntityPlayerMP))
		{
			EntityPlayerMP player = (EntityPlayerMP) holder;
			if (selected)
			{
				player.theItemInWorldManager.setBlockReachDistance(5D + EnchantmentHelper.getEnchantmentLevel(InitConfig.enchReachId, stack));
			}
			// else
			// player.theItemInWorldManager.setBlockReachDistance(5D);
		}
	}

	public static int getRotationMeta(EntityLivingBase entLiving)
	{
		int md = 0;
		int rot = MathHelper.floor_double(((entLiving.rotationYaw * 4.0F) / 360.0F) + 0.5D) & 3;

		switch (rot)
		{
		case 0:
			md = 2;
		case 1:
			md = 5;
		case 2:
			md = 3;
		case 3:
			md = 4;
		}

		return md;
	}
}
