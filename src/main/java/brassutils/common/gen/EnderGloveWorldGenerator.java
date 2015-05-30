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
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;

/**
 * @author Surseance
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
		case 0:
			this.generateSurface(world, random, x, z);
		}
	}

	private boolean generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		Random ChunkGenRand = new Random();
		int ChunkGenRandomNum = ChunkGenRand.nextInt(80);
		if (ChunkGenRandomNum == 1)
		{
			// for (int i = 0; i < 50/*Config.totemsPerChunk*/; i++)
			// {
			int x = chunkX + random.nextInt(16);
			int z = chunkZ + random.nextInt(16);
			int y = random.nextInt(128);

			WorldGenTotem totem = new WorldGenTotem();
			totem.generate(world, random, x, y, z);
			return true;
			// }
		}
		return false;
	}
}
