/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:03:23 PM]
 */
package enderglove.client;

import net.minecraft.world.World;
import cpw.mods.fml.client.registry.RenderingRegistry;
import enderglove.client.lib.UtilsFX;
import enderglove.client.renderers.block.RenderMinedBlock;
import enderglove.common.CommonProxy;
import enderglove.common.entity.EntityMinedBlock;

/**
 * @author Surseance (Johnny Eatmon)
 * Email: sursesance@autistici.org
 *
 */
public class ClientProxy extends CommonProxy
{
	@Override
	public void registerDisplayInformation()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMinedBlock.class, new RenderMinedBlock());
		//MinecraftForgeClient.registerItemRenderer(ConfigItems.itemEnderGlove, new ItemEnderGloveRenderer());
	}

	@Override
	public void blockSparkleFX(World world, int x, int y, int z, int count)
	{
		UtilsFX.blockSparkle(world, x, y, z, count);
	}

	@Override
	public void blockFlameFX(World world, int x, int y, int z, int count)
	{
		UtilsFX.blockFlameFX(world, x, y, z, count);
	}
}
