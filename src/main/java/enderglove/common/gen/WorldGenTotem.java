package enderglove.common.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenCactus;
import cpw.mods.fml.common.FMLLog;
import enderglove.common.config.ConfigBlocks;

public class WorldGenTotem extends WorldGenCactus
{
	   public boolean generate(World world, Random par2Random, int par3, int par4, int par5)
       {
               for (int l = 0; l < 2; ++l)
               {
                       int x = par3 + par2Random.nextInt(4) - par2Random.nextInt(4);
                       int y = par4;
                       int z = par5 + par2Random.nextInt(4) - par2Random.nextInt(4);

                       while(world.isAirBlock(x, y-1, z))
                       {
                    	   y--;
                       }

                       if (world.isAirBlock(x, y, z))
                       {
                              // int l1 = 2 + par2Random.nextInt(par2Random.nextInt(3) + 1);

                               //for (int i2 = 0; i2 < l1; ++i2)
                               //{
                                            world.setBlock(x, y, z, ConfigBlocks.blockEnderTotem, 0, 2);
                                            world.setBlock(x, y + 1, z, ConfigBlocks.blockEnderTotem, 0, 2);
                                            world.setBlock(x, y + 2, z, ConfigBlocks.blockEnderTotem, 0, 2);
                                            world.setBlock(x, y + 3, z, ConfigBlocks.blockTotemTop, 0, 2);
                                       		FMLLog.info("Ender Totem generated at:" + x + "," + y + "," + z, "");
                                    //   }
                       }
                       }

               return true;
       }
}
