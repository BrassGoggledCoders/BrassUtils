
package brassutils.common;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class MATTHandler
{
	/** The value of one ingot in millibuckets */
	public static final int ingotLiquidValue = 144;
	public static final int oreLiquidValue = ingotLiquidValue * 2;
	public static final int blockLiquidValue = ingotLiquidValue * 9;
	public static final int chunkLiquidValue = ingotLiquidValue / 2;
	public static final int nuggetLiquidValue = ingotLiquidValue / 9;
	public static final int stoneLiquidValue = ingotLiquidValue / 8;

	public static Fluid moltenIronFluid = FluidRegistry.getFluid("iron");
	public static Fluid moltenGoldFluid = FluidRegistry.getFluid("gold");
	public static Fluid moltenGlassFluid = FluidRegistry.getFluid("glass");

	public static void addVanillaSmelting()
	{
		if (moltenIronFluid == null || moltenGoldFluid == null || moltenGlassFluid == null)
			return;
		/* TODO */
		// IMCHelper.addNewSmeltable(Items.bucket, 0, Blocks.iron_block, new
		// FluidStack(moltenIronFluid, ingotLiquidValue * 3), 600);
		// IMCHelper.addNewSmeltable(Item.getItemFromBlock(Blocks.anvil), 0,
		// Blocks.anvil,
		// new FluidStack(moltenIronFluid, (blockLiquidValue * 3) +
		// (ingotLiquidValue * 4)), 600);
		// IMCHelper.addNewSmeltable(Items.golden_apple, 0, Blocks.gold_block,
		// new FluidStack(moltenGoldFluid, ingotLiquidValue * 4), 540);
		// IMCHelper.addNewSmeltable(Items.clock, 0, Blocks.gold_block, new
		// FluidStack(moltenGoldFluid, ingotLiquidValue * 4), 400);
		// IMCHelper.addNewSmeltable(Item.getItemFromBlock(Blocks.hopper), 0,
		// Blocks.hopper, new FluidStack(moltenIronFluid, ingotLiquidValue * 5),
		// 600);
		// IMCHelper.addNewSmeltable(Items.iron_door, 0, Blocks.iron_block, new
		// FluidStack(moltenIronFluid, ingotLiquidValue * 6), 600);
		// for (int i = 0; i < 16; i++)
		// {
		// IMCHelper.addNewSmeltable(Item.getItemFromBlock(Blocks.stained_glass),
		// i, Blocks.stained_glass,
		// new FluidStack(moltenGlassFluid, blockLiquidValue), 100);
		// }
		// IMCHelper.addNewSmeltable(Item.getItemFromBlock(Blocks.rail), 0,
		// Blocks.rail, new FluidStack(moltenIronFluid, ingotLiquidValue * 6),
		// 600);
		// IMCHelper.addNewSmeltable(Item.getItemFromBlock(Blocks.iron_bars), 0,
		// Blocks.iron_bars, new FluidStack(moltenIronFluid, ingotLiquidValue *
		// 6),
		// 600);
		// IMCHelper.addNewSmeltable(Items.minecart, 0, Blocks.iron_block, new
		// FluidStack(moltenIronFluid, ingotLiquidValue * 5), 600);
		// IMCHelper.addNewSmeltable(Items.hopper_minecart, 0,
		// Blocks.iron_block, new FluidStack(moltenIronFluid, ingotLiquidValue *
		// 10), 600);
		// IMCHelper.addNewSmeltable(Items.compass, 0, Blocks.iron_block, new
		// FluidStack(moltenIronFluid, ingotLiquidValue * 4), 600);
		// IMCHelper.addNewSmeltable(Items.shears, 0, Blocks.iron_block, new
		// FluidStack(moltenIronFluid, ingotLiquidValue * 2), 600);
		// Item[] equip = new Item[] { Items.iron_boots, Items.iron_leggings,
		// Items.iron_chestplate, Items.iron_helmet, Items.iron_axe,
		// Items.iron_hoe,
		// Items.iron_pickaxe, Items.iron_shovel, Items.iron_sword,
		// Items.golden_boots, Items.golden_leggings, Items.golden_chestplate,
		// Items.golden_helmet, Items.golden_axe, Items.golden_hoe,
		// Items.golden_pickaxe, Items.golden_shovel, Items.golden_sword };
		// int[] amount = new int[] { 4, 7, 8, 5, 3, 2, 3, 1, 2, 4, 7, 8, 5, 3,
		// 2, 3, 1, 2 };
		// for (int i = 0; i < equip.length; i++)
		// {
		// Block block = null;
		// Fluid fluid = null;
		// if (i < (equip.length / 2))
		// {
		// block = Blocks.iron_block;
		// fluid = moltenIronFluid;
		// }
		// else
		// {
		// block = Blocks.gold_block;
		// fluid = moltenGoldFluid;
		// }
		//
		// // if(equip[i])
		// IMCHelper.addNewSmeltable(equip[i], 0, block, new FluidStack(fluid,
		// ingotLiquidValue * amount[i]), 600);
		// }
	}

}
