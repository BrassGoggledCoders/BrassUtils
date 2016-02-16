
package xyz.brassgoggledcoders.brassutils.client;

import net.minecraft.world.World;

import xyz.brassgoggledcoders.boilerplate.lib.client.utils.EffectUtils;
import xyz.brassgoggledcoders.brassutils.common.CommonProxy;

/**
 * @author Surseance
 *
 */
public class ClientProxy extends CommonProxy
{
	@Override
	public void registerDisplayInformation()
	{
		// TODO
		// RenderingRegistry.registerEntityRenderingHandler(EntityMinedBlock.class,
		// new RenderMinedBlock());

		// Crystal
		// ClientRegistry.bindTileEntitySpecialRenderer(TileCrystal.class, new
		// TileCrystalRenderer());
		// RenderingRegistry.registerBlockHandler(new BlockTESRRenderer(new
		// TileCrystal(), RenderIDs.blockCrystalRI));
	}

	@Override
	public void blockSparkleFX(World world, int x, int y, int z, int count)
	{
		EffectUtils.blockSparkle(world, x, y, z, count);
	}

	@Override
	public void blockFlameFX(World world, int x, int y, int z, int count)
	{
		EffectUtils.blockFlameFX(world, x, y, z, count);
	}
}
