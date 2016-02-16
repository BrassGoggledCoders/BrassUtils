
package xyz.brassgoggledcoders.brassutils.common;

import net.minecraft.item.Item;

import net.minecraftforge.fml.common.registry.GameRegistry;

import xyz.brassgoggledcoders.boilerplate.lib.common.items.BaseArmor;
import xyz.brassgoggledcoders.boilerplate.lib.common.items.BaseItem;
import xyz.brassgoggledcoders.boilerplate.lib.common.items.tools.BaseAxe;
import xyz.brassgoggledcoders.boilerplate.lib.common.items.tools.BaseHoe;
import xyz.brassgoggledcoders.boilerplate.lib.common.items.tools.BasePickaxe;
import xyz.brassgoggledcoders.boilerplate.lib.common.items.tools.BaseShovel;
import xyz.brassgoggledcoders.boilerplate.lib.common.items.tools.BaseSword;
import xyz.brassgoggledcoders.boilerplate.lib.common.utils.helpers.RegistryHelper;
import xyz.brassgoggledcoders.brassutils.common.item.ItemChisel;
import xyz.brassgoggledcoders.brassutils.common.item.ItemEnderGlove;
import xyz.brassgoggledcoders.brassutils.common.item.ItemEnderPocket;
import xyz.brassgoggledcoders.brassutils.common.item.ItemObsidianArmor;
import xyz.brassgoggledcoders.brassutils.common.item.ItemTurfKnife;
import xyz.brassgoggledcoders.brassutils.common.lib.ModInfo;

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
		helmetEtherium = new BaseArmor(InitMaterials.ARMOR_ETHERIUM, 0, "etherium").setUnlocalizedName("itemHelmetEtherium");
		chestplateEtherium = new BaseArmor(InitMaterials.ARMOR_ETHERIUM, 1, "etherium").setUnlocalizedName("itemChestplateEtherium");
		legsEtherium = new BaseArmor(InitMaterials.ARMOR_ETHERIUM, 2, "etherium").setUnlocalizedName("itemLegsEtherium");
		bootsEtherium = new BaseArmor(InitMaterials.ARMOR_ETHERIUM, 3, "etherium").setUnlocalizedName("itemBootsEtherium");

		RegistryHelper.registerArmorSet(helmetEtherium, chestplateEtherium, legsEtherium, bootsEtherium, "Etherium");

		// Obsidian
		helmetObsidian = new ItemObsidianArmor(0).setUnlocalizedName("itemHelmetObsidian");
		chestplateObsidian = new ItemObsidianArmor(1).setUnlocalizedName("itemChestplateObsidian");
		legsObsidian = new ItemObsidianArmor(2).setUnlocalizedName("itemLegsObsidian");
		bootsObsidian = new ItemObsidianArmor(3).setUnlocalizedName("itemBootsObsidian");

		RegistryHelper.registerArmorSet(helmetObsidian, chestplateObsidian, legsObsidian, bootsObsidian, "Obsidian");

		// Etherium
		pickaxeEtherium = new BasePickaxe(InitMaterials.TOOL_ETHERIUM).setUnlocalizedName("itemPickaxeEtherium").setCreativeTab(BrassUtils.tabBU);
		swordEtherium = new BaseSword(InitMaterials.TOOL_ETHERIUM).setUnlocalizedName("itemSwordEtherium").setCreativeTab(BrassUtils.tabBU);
		shovelEtherium = new BaseShovel(InitMaterials.TOOL_ETHERIUM).setUnlocalizedName("itemShovelEtherium").setCreativeTab(BrassUtils.tabBU);
		axeEtherium = new BaseAxe(InitMaterials.TOOL_ETHERIUM).setUnlocalizedName("itemAxeEtherium").setCreativeTab(BrassUtils.tabBU);
		hoeEtherium = new BaseHoe(InitMaterials.TOOL_ETHERIUM).setUnlocalizedName("itemHoeEtherium").setCreativeTab(BrassUtils.tabBU);

		RegistryHelper.registerToolSet(swordEtherium, shovelEtherium, pickaxeEtherium, axeEtherium, hoeEtherium, "Etherium");

		// Obsidian
		pickaxeObsidian = new BasePickaxe(InitMaterials.TOOL_OBSIDIAN).setUnlocalizedName("itemPickaxeObsidian").setCreativeTab(BrassUtils.tabBU);
		swordObsidian = new BaseSword(InitMaterials.TOOL_OBSIDIAN).setUnlocalizedName("itemSwordObsidian").setCreativeTab(BrassUtils.tabBU);
		shovelObsidian = new BaseShovel(InitMaterials.TOOL_OBSIDIAN).setUnlocalizedName("itemShovelObsidian").setCreativeTab(BrassUtils.tabBU);
		axeObsidian = new BaseAxe(InitMaterials.TOOL_OBSIDIAN).setUnlocalizedName("itemAxeObsidian").setCreativeTab(BrassUtils.tabBU);
		hoeObsidian = new BaseHoe(InitMaterials.TOOL_OBSIDIAN).setUnlocalizedName("itemHoeObsidian").setCreativeTab(BrassUtils.tabBU);

		RegistryHelper.registerToolSet(swordObsidian, shovelObsidian, pickaxeObsidian, axeObsidian, hoeObsidian, "Obsidian");

		itemEtherium = new BaseItem().setUnlocalizedName("itemEtherium");
		GameRegistry.registerItem(itemEtherium, "itemEtherium");
		itemEtheriumShard = new BaseItem().setUnlocalizedName("itemEtheriumShard");
		GameRegistry.registerItem(itemEtheriumShard, "itemEtheriumShard");
		itemObsidianSlate = new BaseItem().setUnlocalizedName("itemObsidianSlate");
		GameRegistry.registerItem(itemObsidianSlate, "itemObsidianSlate");

		// TODO
		// IMCHelper.addNewToolMaterial(InitConfig.etheriumMaterialID,
		// "Etherium", 2000, 500, 5, 0.1F, 1, EnumChatFormatting.RED.toString(),
		// 16711935);

		// IMCHelper.addNewPartBuilderMaterial(InitConfig.etheriumMaterialID,
		// new ItemStack(itemEtherium), new ItemStack(itemEtheriumShard), 2);

		itemChisel = new ItemChisel().setUnlocalizedName("itemChisel").setFull3D();
		GameRegistry.registerItem(itemChisel, "ItemChisel");
	}
}
