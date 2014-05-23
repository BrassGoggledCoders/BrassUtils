/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 16, 2014, 10:46:05 PM]
 */
package enderglove.client.lib;

import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
public class UtilsFX
{
	public static void blockSparkle(World world, int x, int y, int z, int count)
	{
		if (!world.isRemote)
			return;

		for (; count < 10; ++count)
		{
			double startX = x + world.rand.nextFloat();
			double startY = y + world.rand.nextFloat() * 1.0F;
			double startZ = z + world.rand.nextFloat();

			double endX = world.rand.nextGaussian() * 0.02D;
			double endY = world.rand.nextGaussian() * 0.02D;
			double endZ = world.rand.nextGaussian() * 0.02D;

			EntityFlameFX ef = new EntityFlameFX(world, startX, startY, startZ, endX, endY, endZ);
			ef.setRBGColorF(0.45F, 0.0F, 0.35F);
			ef.setParticleTextureIndex(82); // I like the way the flames spread
											// out, but I wanted the
											// happyVillager particle texture
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(ef);
		}
	}

	public static void blockFlameFX(World world, int x, int y, int z, int count)
	{
		for (; count < 10; ++count)
		{
			double startX = x + world.rand.nextFloat();
			double startY = y + world.rand.nextFloat() * 1.0F;
			double startZ = z + world.rand.nextFloat();

			double endX = world.rand.nextGaussian() * 0.02D;
			double endY = world.rand.nextGaussian() * 0.02D;
			double endZ = world.rand.nextGaussian() * 0.02D;

			EntityFlameFX ef = new EntityFlameFX(world, startX, startY, startZ, endX, endY, endZ);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(ef);
		}
	}
}
