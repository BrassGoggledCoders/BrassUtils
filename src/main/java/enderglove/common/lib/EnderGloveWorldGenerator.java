/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 17, 2014, 1:15:45 PM]
 */
package enderglove.common.lib;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import enderglove.common.config.ConfigBlocks;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 * 
 */
public class EnderGloveWorldGenerator implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		worldGeneration(world, random, chunkX, chunkZ);
	}

	private void worldGeneration(World world, Random random, int x, int z)
	{
		switch (world.provider.dimensionId)
		{
		case -1:
			break;
		case 1:
			break;
		case 0:
			generateSurface(world, random, x, z);
		}
	}
	private boolean generateSurface( World world,  Random random, int chunkX,  int chunkZ)
	{
		for (int i = 0; i < 300/* Config.totemsPerChunk */; i++)
		{
			 int x = chunkX + random.nextInt(16) + 8;
			 int z = chunkZ + random.nextInt(16) + 8;

			 int y = random.nextInt(world.getHeightValue(x, z) * 2);

			generateTotem(world, random, x, y, z);
		}
		return false;
	}
	private boolean generateTotem( World world,  Random random,
			 int x,  int y,  int z)
	{
		// for (int rarity = 0; rarity < 10; ++rarity)
		// {
		// int posX = x + random.nextInt(8) - random.nextInt(8);
		// int posY = y + random.nextInt(4) - random.nextInt(4);
		// int posZ = z + random.nextInt(8) - random.nextInt(8);

		if (world.isAirBlock(x, y, z))
		{
			 int maxHeight = 1 + random.nextInt(random.nextInt(3) + 1);

			for (int height = 0; height < maxHeight; ++height)
			{
				world.setBlock(x, y + height, z, ConfigBlocks.blockEnderTotem,
						0, 2);
				System.out.println(x + "," + y + "," + z);
			}
		}
		// }
		return true;
		// return true;
	}
}
