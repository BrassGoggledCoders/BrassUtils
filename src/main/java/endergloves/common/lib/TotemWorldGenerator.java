/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:25:57 PM] 
 */
package endergloves.common.lib;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class TotemWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{

	}

	private boolean generateEnderTotem(World world, Random random, int chunkX, int chunkY, int chunkZ)
	{
		int posX = chunkX * 16 + random.nextInt(15);
		int posZ = chunkZ * 16 + random.nextInt(15); // Should these values be changed?

		int posY = world.provider.dimensionId == -1 ?

				return false;
	}

	public int getFirstUncoveredY(World world, int x, int z)
	{
		for (int y = 5; !world.isAirBlock(x, y + 1, z); y++)
		{
			return y;
		}
	}
}
