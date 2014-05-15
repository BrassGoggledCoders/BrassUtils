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
public class TotemWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {}

	private boolean generateEnderTotem(World world, Random random, int chunkX, int chunkY, int chunkZ)
	{
		int posX = chunkX * 16 + random.nextInt(15);
		int posZ = chunkZ * 16 + random.nextInt(15); // Should these values be changed?

		int posY = world.provider.dimensionId == -1 ? this.getAvailablePosY(world, posX, posZ, 3) - 1 : world.getHeightValue(posX, posZ) - 1;

		if (posY > world.getActualHeight())
			return false;

		if ((world.getBlock(posX, posY, posZ) == Blocks.grass) || (world.getBlock(posX, posY, posZ) == Blocks.sand) || (world.getBlock(posX, posY, posZ) == Blocks.dirt) || (world.getBlock(posX, posY, posZ) == Blocks.stone) || (world.getBlock(posX, posY, posZ) == Blocks.end_stone))
		{
			int count = 1;

			/* I need this to loop through the y-axis and place three vertical (or more) vertical blocks for the totem. 
			 * This is mostly posX/posZ stuff.
			while (((world.isAirBlock(posX, posY + count, posZ)) || (world.getBlock(posX, posY + count, posZ) == Blocks.snow) || (world.getBlock(posX, posY + count, posZ) == Blocks.tallgrass)) && (count < 3)) 
				count++;
			
			if (count >= 2) 
			{
				world.setBlock(posX, posY, posZ, ConfigBlocks.blockEnderTotem, 1, 3);
				count = 1;

				while (((world.isAirBlock(posX, posY + count, posZ)) || (world.getBlock(posX, posY + count, posZ) == Blocks.snow) || (world.getBlock(posX, posY + count, posZ) == Blocks.tallgrass)) && (count < 5)) 
				{
					world.setBlock(posX, posY + count, posZ, ConfigBlocks.blockEnderTotem, 0, 3);
					
					if ((count > 1) && (random.nextInt(4) == 0))
					{
						world.setBlock(posX, posY + count, posZ, ConfigBlocks.blockEnderTotem, 8, 3);
						count = 5;
					}
					
					count++;
					
					if ((count >= 5)) 
					{
						world.setBlock(posX, posY + 5, posZ, ConfigBlocks.blockEnderTotem, 8, 3);
					}
				}
			}*/
		}

		return false;
	}

	public int getAvailablePosY(World world, int posX, int posZ, int height)
	{	
		int posY = 0;

		for (; !world.isAirBlock(posX, height + 1, posZ); height++)
		{
			height = posY;
		}

		return posY;
	}
}
