package enderglove.common.lib;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenCactus;
import cpw.mods.fml.common.FMLLog;
import enderglove.common.config.ConfigBlocks;

public class WorldGenTotem extends WorldGenCactus
{

	@Override
	public boolean generate(World world, Random random, int x, int y,
			int z)
	{
		 //for (int l = 0; l < 10; ++l)
	      //  {
	            int i1 = x + random.nextInt(8) - random.nextInt(8);
	            int j1 = y + random.nextInt(4) - random.nextInt(4);
	            int k1 = z + random.nextInt(8) - random.nextInt(8);

	            if (world.isAirBlock(i1, j1, k1))
	            {
	                int l1 = 1 + random.nextInt(random.nextInt(3) + 1);

	               // for (int i2 = 0; i2 < l1; ++i2)
	               // {
		world.setBlock(x, y, z, ConfigBlocks.blockEnderTotem, 0, 2);
		FMLLog.info("Ender Totem generated at:" + x + "," + y + "," + z, "");
	              //  }
	            }
	     //   }
		return true;
	}

}
