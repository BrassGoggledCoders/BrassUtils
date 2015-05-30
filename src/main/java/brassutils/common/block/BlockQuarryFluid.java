package brassutils.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraftforge.fluids.BlockFluidFinite;
import net.minecraftforge.fluids.Fluid;

public class BlockQuarryFluid extends BlockFluidFinite
{

	public BlockQuarryFluid(Fluid fluid, Material material)
	{
		super(fluid, material);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}

}
