
package xyz.brassgoggledcoders.brassutils.common.gen;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenCactus;

import net.minecraftforge.fml.common.FMLLog;

import xyz.brassgoggledcoders.brassutils.common.InitBlocks;

/**
 * @author Surseance
 *
 */
public class WorldGenTotem extends WorldGenCactus
{
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		for (int l = 0; l < 2; ++l)
		{
			int x = (position.getX() + rand.nextInt(4)) - rand.nextInt(4);
			int y = position.getY();
			int z = (position.getZ() + rand.nextInt(4)) - rand.nextInt(4);

			while (worldIn.isAirBlock(new BlockPos(x, y - 1, z)))
			{
				y--;
			}

			if (worldIn.isAirBlock(new BlockPos(x, y, z)))
			{
				// int l1 = 2 + par2Random.nextInt(par2Random.nextInt(3) + 1);

				// for (int i2 = 0; i2 < l1; ++i2)
				// {
				worldIn.setBlockState(new BlockPos(x, y, z), InitBlocks.blockEnderTotem.getDefaultState());
				worldIn.setBlockState(new BlockPos(x, y + 1, z), InitBlocks.blockEnderTotem.getDefaultState());
				worldIn.setBlockState(new BlockPos(x, y + 2, z), InitBlocks.blockEnderTotem.getDefaultState());
				worldIn.setBlockState(new BlockPos(x, y + 3, z), InitBlocks.blockTotemTop.getDefaultState());
				FMLLog.info("Ender Totem generated at:" + x + "," + y + "," + z, "");
				// }
			}
		}

		return true;
	}
}
