/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 17, 2014, 1:15:45 PM]
 */
package enderglove.common.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;
import enderglove.common.config.Config;
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
		Random ChunkGenRand = new Random();
		int ChunkGenRandomNum = ChunkGenRand.nextInt(4)+1;
		if(ChunkGenRandomNum == 1)
		{
	//	for (int i = 0; i < 50/*Config.totemsPerChunk*/; i++)
	//	{
			int x = chunkX + random.nextInt(16);
			int z = chunkZ + random.nextInt(16);
			int y = random.nextInt(128);

			WorldGenTotem totem = new WorldGenTotem();
			totem.generate(world, random, x, y, z);
			return true;
	//	}
		}
		return false;
	}
}
