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

import brassutils.common.InitConfig;

/**
 * @author Surseance
 *
 */
public class BrassUtilsWorldGenerator implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		int blockChunkX = chunkX * 16;
		int blockChunkZ = chunkZ * 16;

		if (world.provider.dimensionId == 0)
		{
			this.generateSurface(world, random, blockChunkX, blockChunkZ);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		if (InitConfig.totemGen)
		{

		}
		if (random.nextInt(45) == 0)
		{
			int X = chunkX + random.nextInt(16);
			int Z = chunkZ + random.nextInt(16);
			int Y = random.nextInt(256);
			new WorldGenTotem().generate(world, random, X, Y, Z);
		}
	}
}
