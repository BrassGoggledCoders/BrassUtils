
package xyz.brassgoggledcoders.brassutils.common;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import xyz.brassgoggledcoders.boilerplate.lib.common.recipes.RecipeUtils;

public class InitRecipes
{
	public static void init()
	{
		// Extra Vanilla Recipes
		if (InitConfig.endPortalRecipe)
		{
			GameRegistry.addRecipe(new ItemStack(Blocks.end_portal_frame, 12), new Object[] { "SES", "SDS", "SSS", 'S', Blocks.end_stone, 'E',
					Items.ender_eye, 'D', Blocks.dragon_egg, 'S', Items.nether_star });
		}
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.dispenser), new Object[] { Blocks.dropper, Items.bow });
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.piston), new Object[] { Blocks.sticky_piston, Items.water_bucket });
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sand, 4), new Object[] { Blocks.sandstone });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 4),
				new Object[] { new ItemStack(Blocks.quartz_block, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 6), new Object[] { Blocks.quartz_stairs });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz, 2), new Object[] { new ItemStack(Blocks.stone_slab, 1, 7) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 2), new Object[] { new ItemStack(Blocks.wool) });
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 6, 15), new Object[] { Items.bone, Items.rotten_flesh });
		GameRegistry.addRecipe(new ItemStack(Blocks.packed_ice), new Object[] { "III", "III", "III", 'I', Blocks.ice });

		if (InitConfig.recipeEnderGlove)
		{
			GameRegistry.addRecipe(new ItemStack(InitItems.itemEnderGlove),
					new Object[] { "EEE", "LNL", "LLL", 'L', Items.leather, 'N', Items.nether_star, 'E', Items.ender_eye });
		}
		if (InitConfig.recipeEnderPocket)
		{
			GameRegistry.addRecipe(new ItemStack(InitItems.itemEnderPocket),
					new Object[] { "LXL", "XYX", "LXL", 'X', Blocks.obsidian, 'Y', Blocks.ender_chest, 'L', Items.leather });
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
			GameRegistry.addRecipe(new ItemStack(InitBlocks.blockLeafCover, 1, i + 6),
					new Object[] { "S", "L", 'S', Blocks.sand, 'L', new ItemStack(InitBlocks.blockLeafCover, 1, i) });
		}

		GameRegistry.addRecipe(new ItemStack(InitBlocks.blockFeathers), new Object[] { "XX", "XX", 'X', Items.feather });
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocks.blockRedstoneSand), new Object[] { Blocks.sand, Items.redstone });

		// Etherium
		RecipeUtils.addArmorSet(new ItemStack(InitItems.itemEtherium), new ItemStack[] { new ItemStack(InitItems.helmetEtherium),
				new ItemStack(InitItems.chestplateEtherium), new ItemStack(InitItems.legsEtherium), new ItemStack(InitItems.bootsEtherium) });

		// Obsidian
		RecipeUtils.addArmorSet(new ItemStack(InitItems.itemObsidianSlate), new ItemStack[] { new ItemStack(InitItems.helmetObsidian),
				new ItemStack(InitItems.chestplateObsidian), new ItemStack(InitItems.legsObsidian), new ItemStack(InitItems.bootsObsidian) });

		// Etherium
		RecipeUtils.addToolSet(new ItemStack(InitItems.itemEtherium),
				new ItemStack[] { new ItemStack(InitItems.pickaxeEtherium), new ItemStack(InitItems.shovelEtherium),
						new ItemStack(InitItems.axeEtherium), new ItemStack(InitItems.hoeEtherium), new ItemStack(InitItems.swordEtherium) });
		// Obsidian
		RecipeUtils.addToolSet(new ItemStack(InitItems.itemObsidianSlate),
				new ItemStack[] { new ItemStack(InitItems.pickaxeObsidian), new ItemStack(InitItems.shovelObsidian),
						new ItemStack(InitItems.axeObsidian), new ItemStack(InitItems.hoeObsidian), new ItemStack(InitItems.swordObsidian) });

		GameRegistry.addShapedRecipe(new ItemStack(InitBlocks.blockEtherium), "UUU", "UUU", "UUU", 'U', new ItemStack(InitItems.itemEtherium));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitItems.itemChisel), " I", " S", 'I', "ingotIron", 'S', "stickWood"));
	}
}
