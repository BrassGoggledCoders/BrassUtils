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
	public static void blockSparkle(final World world, final int x,
			final int y, final int z, int count)
	{
		if (!world.isRemote)
		{
			return;
		}

		for (; count < 10; ++count)
		{
			final double startX = x + world.rand.nextFloat();
			final double startY = y + world.rand.nextFloat() * 1.0F;
			final double startZ = z + world.rand.nextFloat();

			final double endX = world.rand.nextGaussian() * 0.02D;
			final double endY = world.rand.nextGaussian() * 0.02D;
			final double endZ = world.rand.nextGaussian() * 0.02D;

			final EntityFlameFX ef = new EntityFlameFX(world, startX, startY,
					startZ, endX, endY, endZ);
			ef.setRBGColorF(0.45F, 0.0F, 0.35F);
			ef.setParticleTextureIndex(82); // I like the way the flames spread
											// out, but I wanted the
											// happyVillager particle texture
			FMLClientHandler.instance().getClient().effectRenderer
					.addEffect(ef);
		}
	}

	public static void blockFlameFX(final World world, final int x,
			final int y, final int z, int count)
	{
		for (; count < 10; ++count)
		{
			final double startX = x + world.rand.nextFloat();
			final double startY = y + world.rand.nextFloat() * 1.0F;
			final double startZ = z + world.rand.nextFloat();

			final double endX = world.rand.nextGaussian() * 0.02D;
			final double endY = world.rand.nextGaussian() * 0.02D;
			final double endZ = world.rand.nextGaussian() * 0.02D;

			final EntityFlameFX ef = new EntityFlameFX(world, startX, startY,
					startZ, endX, endY, endZ);
			FMLClientHandler.instance().getClient().effectRenderer
					.addEffect(ef);
		}
	}
}
