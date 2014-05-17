/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 16, 2014, 10:46:05 PM] 
 */
package endergloves.client.lib;

import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class UtilsFX 
{
	public static void blockSparkle(World world, int x, int y, int z, int count)
	{
		if (!world.isRemote)
			return;

		for (; count < world.rand.nextInt(10); ++count)
		{
			double startX = (double)(x + world.rand.nextFloat());
			double startY = (double)(y + world.rand.nextFloat() * 1.0F);
			double startZ = (double)(z + world.rand.nextFloat());

			double endX = world.rand.nextGaussian() * 0.02D;
			double endY = world.rand.nextGaussian() * 0.02D;
			double endZ = world.rand.nextGaussian() * 0.02D;

			world.spawnParticle("happyVillager", startX, startY, startZ, endX, endY, endZ);
		}
	}

	public static void blockFlameFX(World world, int x, int y, int z, int count)
	{
		for (; count < 10; ++count)
		{
			double startX = (double)(x + world.rand.nextFloat());
			double startY = (double)(y + world.rand.nextFloat() * 1.0F);
			double startZ = (double)(z + world.rand.nextFloat());

			double endX = world.rand.nextGaussian() * 0.02D;
			double endY = world.rand.nextGaussian() * 0.02D;
			double endZ = world.rand.nextGaussian() * 0.02D;

			EntityFlameFX ef = new EntityFlameFX(world, startX, startY, startZ, endX, endY, endZ);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(ef);
		}
	}
}
