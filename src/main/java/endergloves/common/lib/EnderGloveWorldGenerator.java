/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 17, 2014, 1:15:45 PM] 
 */
package endergloves.common.lib;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import endergloves.common.config.ConfigBlocks;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class EnderGloveWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		this.worldGeneration(world, random, chunkX, chunkZ);
	}

	private void worldGeneration(World world, Random random, int x, int z)
	{
		switch (world.provider.dimensionId) 
		{
			case -1:
				break;
			case 1:
				break;
			default:
				this.generateTotem(world, random, x, z);
		}
	}

	private boolean generateTotem(World world, Random random, int chunkX, int chunkZ)
	{
		int x = chunkX + 8 * random.nextInt(16);
		int z = chunkZ + 8 * random.nextInt(16);

		int y = world.getHeightValue(x, z);

		if (y > world.getActualHeight() + 1)
			return false;
		if ((world.getBlock(x, y, z) == Blocks.water) && (world.getBlock(x, y, z) == Blocks.leaves))
			return false;

		int totemHeight = y + random.nextInt(2) + 3;

		for (int yy = 0; yy < totemHeight; yy++)
		{
			world.setBlock(x, yy, z, ConfigBlocks.blockEnderTotem, 0, 3);
		}

		return false;
	}
}
