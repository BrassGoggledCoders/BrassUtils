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
		if (Config.endPortalRecipe)
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
	}
}
