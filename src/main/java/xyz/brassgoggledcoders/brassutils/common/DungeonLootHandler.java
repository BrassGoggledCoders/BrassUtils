
package xyz.brassgoggledcoders.brassutils.common;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;

import net.minecraftforge.common.ChestGenHooks;

public class DungeonLootHandler
{
	public static void init()
	{
		// More stuff for blacksmith chests
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Blocks.anvil), 1, 1, 5));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Items.compass), 1, 1, 15));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Blocks.iron_bars), 1, 16, 20));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Items.emerald), 1, 3, 1));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Blocks.piston), 5, 16, 30));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Blocks.hopper), 1, 1, 10));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Blocks.iron_block), 1, 1, 10));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Items.diamond_pickaxe), 1, 1, 1));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Items.cauldron), 1, 1, 10));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Items.map), 1, 1, 30));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(Items.experience_bottle), 1, 10, 5));
		// Ender Gloves
		if (InitConfig.chestGen)
		{
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR,
					new WeightedRandomChestContent(new ItemStack(InitItems.itemEnderGlove), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING,
					new WeightedRandomChestContent(new ItemStack(InitItems.itemEnderGlove), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(InitItems.itemEnderGlove), 1, 1, 2));
		}
	}
}
