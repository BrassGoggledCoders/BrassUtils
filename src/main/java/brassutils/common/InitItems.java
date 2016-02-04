/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import cpw.mods.fml.common.registry.GameRegistry;

import boilerplate.common.baseclasses.items.tools.BaseAxe;
import boilerplate.common.baseclasses.items.tools.BaseHoe;
import boilerplate.common.baseclasses.items.tools.BasePickaxe;
import boilerplate.common.baseclasses.items.tools.BaseShovel;
import boilerplate.common.baseclasses.items.tools.BaseSword;
import boilerplate.common.utils.helpers.IMCHelper;
import boilerplate.common.utils.helpers.RegistryHelper;
import brassutils.common.item.BaseItem;
import brassutils.common.item.ItemChisel;
import brassutils.common.item.ItemEnderGlove;
import brassutils.common.item.ItemEnderPocket;
import brassutils.common.item.ItemNormalArmor;
import brassutils.common.item.ItemObsidianArmor;
import brassutils.common.item.ItemTurfKnife;
import brassutils.common.lib.ModInfo;

/**
 * @author Surseance
 *
 */
public class InitItems
{
	public static Item itemTurfKnife;
	public static Item itemEnderGlove, itemEnderPocket;

	public static Item helmetEtherium, chestplateEtherium, legsEtherium, bootsEtherium;
	public static Item helmetObsidian, chestplateObsidian, legsObsidian, bootsObsidian;

	public static Item pickaxeEtherium, swordEtherium, shovelEtherium, axeEtherium, hoeEtherium;

	public static Item pickaxeObsidian, swordObsidian, shovelObsidian, axeObsidian, hoeObsidian;

	public static Item itemEtherium, itemEtheriumShard, itemObsidianSlate;

	public static Item itemChisel;

	public static void init()
	{
		initializeItems();
	}

	public static void initializeItems()
	{
		itemTurfKnife = new ItemTurfKnife().setCreativeTab(BrassUtils.tabBU).setUnlocalizedName("itemTurfKnife");
		GameRegistry.registerItem(itemTurfKnife, "ItemTurfKnife");

		itemEnderGlove = new ItemEnderGlove().setUnlocalizedName("itemEnderglove");
		itemEnderPocket = new ItemEnderPocket().setUnlocalizedName("itemEnderpocket");
		GameRegistry.registerItem(itemEnderGlove, "ItemEnderGlove", ModInfo.ID);
		GameRegistry.registerItem(itemEnderPocket, "ItemEnderPocket", ModInfo.ID);

		// Etherium
		helmetEtherium = new ItemNormalArmor(InitMaterials.ARMOR_ETHERIUM, 0, "etherium").setUnlocalizedName("itemHelmetEtherium");
		chestplateEtherium = new ItemNormalArmor(InitMaterials.ARMOR_ETHERIUM, 1, "etherium").setUnlocalizedName("itemChestplateEtherium");
		legsEtherium = new ItemNormalArmor(InitMaterials.ARMOR_ETHERIUM, 2, "etherium").setUnlocalizedName("itemLegsEtherium");
		bootsEtherium = new ItemNormalArmor(InitMaterials.ARMOR_ETHERIUM, 3, "etherium").setUnlocalizedName("itemBootsEtherium");

		RegistryHelper.registerArmorSet(helmetEtherium, chestplateEtherium, legsEtherium, bootsEtherium, "Etherium", ModInfo.ID);

		// Obsidian
		helmetObsidian = new ItemObsidianArmor(0).setUnlocalizedName("itemHelmetObsidian");
		chestplateObsidian = new ItemObsidianArmor(1).setUnlocalizedName("itemChestplateObsidian");
		legsObsidian = new ItemObsidianArmor(2).setUnlocalizedName("itemLegsObsidian");
		bootsObsidian = new ItemObsidianArmor(3).setUnlocalizedName("itemBootsObsidian");

		RegistryHelper.registerArmorSet(helmetObsidian, chestplateObsidian, legsObsidian, bootsObsidian, "Obsidian", ModInfo.ID);

		// Etherium
		pickaxeEtherium = new BasePickaxe(InitMaterials.TOOL_ETHERIUM, ModInfo.PREFIX).setUnlocalizedName("itemPickaxeEtherium")
				.setCreativeTab(BrassUtils.tabBU);
		swordEtherium = new BaseSword(InitMaterials.TOOL_ETHERIUM, ModInfo.PREFIX).setUnlocalizedName("itemSwordEtherium")
				.setCreativeTab(BrassUtils.tabBU);
		shovelEtherium = new BaseShovel(InitMaterials.TOOL_ETHERIUM, ModInfo.PREFIX).setUnlocalizedName("itemShovelEtherium")
				.setCreativeTab(BrassUtils.tabBU);
		axeEtherium = new BaseAxe(InitMaterials.TOOL_ETHERIUM, ModInfo.PREFIX).setUnlocalizedName("itemAxeEtherium").setCreativeTab(BrassUtils.tabBU);
		hoeEtherium = new BaseHoe(InitMaterials.TOOL_ETHERIUM, ModInfo.PREFIX).setUnlocalizedName("itemHoeEtherium").setCreativeTab(BrassUtils.tabBU);

		RegistryHelper.registerToolSet(swordEtherium, shovelEtherium, pickaxeEtherium, axeEtherium, hoeEtherium, "Etherium", ModInfo.ID);

		// Obsidian
		pickaxeObsidian = new BasePickaxe(InitMaterials.TOOL_OBSIDIAN, ModInfo.PREFIX).setUnlocalizedName("itemPickaxeObsidian")
				.setCreativeTab(BrassUtils.tabBU);
		swordObsidian = new BaseSword(InitMaterials.TOOL_OBSIDIAN, ModInfo.PREFIX).setUnlocalizedName("itemSwordObsidian")
				.setCreativeTab(BrassUtils.tabBU);
		shovelObsidian = new BaseShovel(InitMaterials.TOOL_OBSIDIAN, ModInfo.PREFIX).setUnlocalizedName("itemShovelObsidian")
				.setCreativeTab(BrassUtils.tabBU);
		axeObsidian = new BaseAxe(InitMaterials.TOOL_OBSIDIAN, ModInfo.PREFIX).setUnlocalizedName("itemAxeObsidian").setCreativeTab(BrassUtils.tabBU);
		hoeObsidian = new BaseHoe(InitMaterials.TOOL_OBSIDIAN, ModInfo.PREFIX).setUnlocalizedName("itemHoeObsidian").setCreativeTab(BrassUtils.tabBU);

		RegistryHelper.registerToolSet(swordObsidian, shovelObsidian, pickaxeObsidian, axeObsidian, hoeObsidian, "Obsidian", ModInfo.ID);

		itemEtherium = new BaseItem().setUnlocalizedName("itemEtherium");
		GameRegistry.registerItem(itemEtherium, "itemEtherium");
		itemEtheriumShard = new BaseItem().setUnlocalizedName("itemEtheriumShard");
		GameRegistry.registerItem(itemEtheriumShard, "itemEtheriumShard");
		itemObsidianSlate = new BaseItem().setUnlocalizedName("itemObsidianSlate");
		GameRegistry.registerItem(itemObsidianSlate, "itemObsidianSlate");

		IMCHelper.addNewToolMaterial(InitConfig.etheriumMaterialID, "Etherium", 2000, 500, 5, 0.1F, 1, EnumChatFormatting.RED.toString(), 16711935);

		IMCHelper.addNewPartBuilderMaterial(InitConfig.etheriumMaterialID, new ItemStack(InitItems.itemEtherium),
				new ItemStack(InitItems.itemEtheriumShard), 2);

		itemChisel = new ItemChisel().setUnlocalizedName("itemChisel").setFull3D();
		GameRegistry.registerItem(itemChisel, "ItemChisel");
	}
}
