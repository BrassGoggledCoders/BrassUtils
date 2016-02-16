
package xyz.brassgoggledcoders.brassutils.common.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import net.minecraftforge.fml.common.IWorldGenerator;

import xyz.brassgoggledcoders.brassutils.common.InitBlocks;
import xyz.brassgoggledcoders.brassutils.common.InitConfig;

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

		if (world.provider.getDimensionId() == -1)
		{
			this.generateNether(world, random, blockChunkX, blockChunkZ);
		}
		if (world.provider.getDimensionId() == 0)
		{
			this.generateSurface(world, random, blockChunkX, blockChunkZ);
		}
		else if (world.provider.getDimensionId() == 1)
		{
			this.generateEnd(world, random, blockChunkX, blockChunkZ);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		if (!InitConfig.totemGen)
			return;
		if (random.nextInt(45) == 0)
		{
			int X = chunkX + random.nextInt(16);
			int Z = chunkZ + random.nextInt(16);
			int Y = random.nextInt(256);
			new WorldGenTotem().generate(world, random, new BlockPos(X, Y, Z));
		}
	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ)
	{
		// if(ConfigWorldGen.netherEtheriumCrystalGenEnabled)
		this.generateOre(world, random, chunkX, chunkZ, InitConfig.netherEtheriumCrystalCluster, 30, 120, 3, InitBlocks.blockCrystal, 0,
				Blocks.netherrack);
	}

	private void generateEnd(final World world, final Random random, final int chunkX, final int chunkZ)
	{
		// if(ConfigWorldGen.endEtheriumCrystalGenEnabled)
		this.generateOre(world, random, chunkX, chunkZ, InitConfig.endEtheriumCrystalCluster, 20, 100, 5, InitBlocks.blockCrystal, 0,
				Blocks.end_stone);
	}

	private void generateOre(World world, Random random, int chunkX, int chunkZ, int blockPerChunk, int minHeight, int maxHeight, int blocks,
			Block ore, int meta, Block blockToGenIn)
	{
		for (int i = 0; i < blockPerChunk; i++)
		{
			int oreXCoord = chunkX + random.nextInt(16);
			int oreYCoord = minHeight + random.nextInt(maxHeight - minHeight);
			int oreZCoord = chunkZ + random.nextInt(16);

			// TODO new WorldGenMinable(ore, meta, blocks,
			// blockToGenIn).generate(world, random, oreXCoord, oreYCoord,
			// oreZCoord);
		}
	}
}
