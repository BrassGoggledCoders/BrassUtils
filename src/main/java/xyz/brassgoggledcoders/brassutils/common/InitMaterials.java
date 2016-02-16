
package xyz.brassgoggledcoders.brassutils.common;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;

import net.minecraftforge.common.util.EnumHelper;

/**
 * @author Decebaldecebal
 *
 */
public class InitMaterials
{
	// Tool Materials
	public static ToolMaterial TOOL_OBSIDIAN;
	public static ToolMaterial TOOL_ETHERIUM;

	public static ArmorMaterial ARMOR_OBSIDIAN;
	public static ArmorMaterial ARMOR_ETHERIUM;

	public static void initializeMaterials()
	{
		initToolMaterials();
		initArmorMaterials();
	}

	private static void initToolMaterials()
	{
		// Tools
		TOOL_OBSIDIAN = EnumHelper.addToolMaterial("TOOL_OBSIDIAN", 3, -1, 3.0F, 6F, 7);
		TOOL_ETHERIUM = EnumHelper.addToolMaterial("TOOL_ETHERIUM", 3, 2345, 10.5F, 7F, 14);
	}

	private static void initArmorMaterials()
	{
		ARMOR_OBSIDIAN = EnumHelper.addArmorMaterial("ARMOR_OBSIDIAN", /* TODO */"obsidian", -1, new int[] { 5, 8, 8, 5 }, 5);
		ARMOR_ETHERIUM = EnumHelper.addArmorMaterial("ARMOR_ETHERIUM", /* TODO */"etherium", 40, new int[] { 4, 8, 7, 3 }, 18);
	}

}
