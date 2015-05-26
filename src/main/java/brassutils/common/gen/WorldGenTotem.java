/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.common.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenCactus;

import cpw.mods.fml.common.FMLLog;

import brassutils.common.InitBlocks;

/**
 * @author Surseance
 *
 */
public class WorldGenTotem extends WorldGenCactus
{
	@Override
	public boolean generate(World world, Random par2Random, int par3, int par4, int par5)
	{
		for(int l = 0; l < 2; ++l)
		{
			int x = (par3 + par2Random.nextInt(4)) - par2Random.nextInt(4);
			int y = par4;
			int z = (par5 + par2Random.nextInt(4)) - par2Random.nextInt(4);

			while(world.isAirBlock(x, y - 1, z))
			{
				y--;
			}

			if(world.isAirBlock(x, y, z))
			{
				// int l1 = 2 + par2Random.nextInt(par2Random.nextInt(3) + 1);

				// for (int i2 = 0; i2 < l1; ++i2)
				// {
				world.setBlock(x, y, z, InitBlocks.blockEnderTotem, 0, 2);
				world.setBlock(x, y + 1, z, InitBlocks.blockEnderTotem, 0, 2);
				world.setBlock(x, y + 2, z, InitBlocks.blockEnderTotem, 0, 2);
				world.setBlock(x, y + 3, z, InitBlocks.blockTotemTop, 0, 2);
				FMLLog.info("Ender Totem generated at:" + x + "," + y + "," + z, "");
				// }
			}
		}

		return true;
	}
}
