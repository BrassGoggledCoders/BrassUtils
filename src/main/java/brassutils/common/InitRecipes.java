package brassutils.common;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraftforge.oredict.OreDictionary;

public class InitRecipes
{
	public static void init()
	{
		if (InitConfig.endPortalRecipe)
		{
			GameRegistry.addRecipe(new ItemStack(Blocks.end_portal_frame, 12), new Object[] { "SES", "SDS", "SSS", 'S', Blocks.end_stone, 'E',
					Items.ender_eye, 'D', Blocks.dragon_egg, 'S', Items.nether_star });
		}
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.dispenser), new Object[] { Blocks.dropper, Items.bow });
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.piston), new Object[] { Blocks.sticky_piston, Items.water_bucket });
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sand, 4), new Object[] { Blocks.sandstone });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 4), new Object[] { new ItemStack(Blocks.quartz_block, 1,
				OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 6), new Object[] { Blocks.quartz_stairs });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 2), new Object[] { new ItemStack(Blocks.stone_slab, 1, 7) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 2), new Object[] { new ItemStack(Blocks.wool) });
		GameRegistry.addRecipe(new ItemStack(Blocks.packed_ice), new Object[] { "III", "III", "III", 'I', Blocks.ice });

		if (InitConfig.recipeEnderGlove)
		{
			GameRegistry.addRecipe(new ItemStack(InitItems.itemEnderGlove), new Object[] { "EEE", "LNL", "LLL", 'L', Items.leather, 'N',
					Items.nether_star, 'E', Items.ender_eye });
		}
		if (InitConfig.recipeEnderPocket)
		{
			GameRegistry.addRecipe(new ItemStack(InitItems.itemEnderPocket), new Object[] { "LXL", "XYX", "LXL", 'X', Blocks.obsidian, 'Y',
					Blocks.ender_chest, 'L', Items.leather });
		}
		GameRegistry.addRecipe(new ItemStack(InitBlocks.blockLeafCover, 3, 0), new Object[] { "LL", 'L', new ItemStack(Blocks.leaves, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(InitBlocks.blockLeafCover, 3, 1), new Object[] { "LL", 'L', new ItemStack(Blocks.leaves, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(InitBlocks.blockLeafCover, 3, 2), new Object[] { "LL", 'L', new ItemStack(Blocks.leaves, 1, 2) });
		GameRegistry.addRecipe(new ItemStack(InitBlocks.blockLeafCover, 3, 3), new Object[] { "LL", 'L', new ItemStack(Blocks.leaves, 1, 3) });
		GameRegistry.addRecipe(new ItemStack(InitBlocks.blockLeafCover, 3, 4), new Object[] { "LL", 'L', new ItemStack(Blocks.leaves2, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(InitBlocks.blockLeafCover, 3, 5), new Object[] { "LL", 'L', new ItemStack(Blocks.leaves2, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(Blocks.grass), new Object[] { "T", "D", 'T', InitBlocks.blockTurf, 'D', Blocks.dirt });
		GameRegistry.addShapelessRecipe(new ItemStack(InitItems.itemTurfKnife), new Object[] { Items.iron_sword });
		for (int i = 0; i < 6; i++)
		{
			GameRegistry.addRecipe(new ItemStack(InitBlocks.blockLeafCover, 1, i + 6), new Object[] { "S", "L", 'S', Blocks.sand, 'L',
					new ItemStack(InitBlocks.blockLeafCover, 1, i) });
		}
	}
}