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
	public void generate( Random random,  int chunkX,
			 int chunkZ,  World world,
			 IChunkProvider chunkGenerator,
			 IChunkProvider chunkProvider)
	{
		worldGeneration(world, random, chunkX, chunkZ);
	}

	private void worldGeneration( World world,  Random random,
			 int x,  int z)
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

	@SuppressWarnings("unused")
	private boolean generateSurface( World world,  Random random,
			 int chunkX,  int chunkZ)
	{
		for (int i = 0; i < 300/* Config.totemsPerChunk */; i++)
		{
			int x = chunkX + random.nextInt(16);
			int z = chunkZ + random.nextInt(16);
			generateTotem(world, random, x, world.getActualHeight(), z);
			return true;
		}
		return false;
	}

	private boolean generateTotem( World world,  Random random,
			 int x,  int y,  int z)
	{
		/*
		 * Find the lowest ground block while (world.isAirBlock(x, y, z) && y >
		 * 2) { --y;x } //Don't generate on water if (world.getBlock(x, y, z) ==
		 * Blocks.water) { return false; } else {
		 */
		world.setBlock(x, y, z, ConfigBlocks.blockEnderTotem);
		world.setBlock(x, y + 1, z, ConfigBlocks.blockEnderTotem);
		world.setBlock(x, y + 2, z, ConfigBlocks.blockEnderTotem);
		return true;
		// return true;
	}
}