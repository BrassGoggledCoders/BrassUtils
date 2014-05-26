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
	int totemsPerChunk = -1;

	@Override
	public void generate(final Random random, final int chunkX,
			final int chunkZ, final World world,
			final IChunkProvider chunkGenerator,
			final IChunkProvider chunkProvider)
	{
		worldGeneration(world, random, chunkX, chunkZ);
	}

	private void worldGeneration(final World world, final Random random,
			final int x, final int z)
	{
		switch (world.provider.dimensionId)
		{
		case -1:
			break;
		case 1:
			break;
		default:
			generateSurface(world, random, x, z);
		}
	}

	private boolean generateSurface(final World world, final Random random,
			final int chunkX, final int chunkZ)
	{
		for (int amount = 0; amount < totemsPerChunk; ++amount)
		{
			final int x = chunkX + random.nextInt(16) + 8;
			final int z = chunkZ + random.nextInt(16) + 8;

			final int y = random.nextInt(world.getHeightValue(x, z) * 2);

			generateTotem(world, random, x, y, z);
		}

		return true;
	}

	private boolean generateTotem(final World world, final Random random,
			final int x, final int y, final int z)
	{
		// for (int rarity = 0; rarity < 10; ++rarity)
		// {
		// int posX = x + random.nextInt(8) - random.nextInt(8);
		// int posY = y + random.nextInt(4) - random.nextInt(4);
		// int posZ = z + random.nextInt(8) - random.nextInt(8);

		if (world.isAirBlock(x, y, z))
		{
			final int maxHeight = 1 + random.nextInt(random.nextInt(3) + 1);

			for (int height = 0; height < maxHeight; ++height)
			{
				world.setBlock(x, y + height, z, ConfigBlocks.blockEnderTotem,
						0, 2);
				System.out.println(x + "," + y + "," + z);
			}
		}
		// }

		return true;
	}
}
