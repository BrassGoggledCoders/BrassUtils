/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.client;

import net.minecraft.world.World;

import cpw.mods.fml.client.registry.RenderingRegistry;

import boilerplate.client.renderers.block.RenderMinedBlock;
import boilerplate.client.utils.EffectUtils;
import boilerplate.common.entity.EntityMinedBlock;
import brassutils.common.CommonProxy;

/**
 * @author Surseance
 *
 */
public class ClientProxy extends CommonProxy
{
	@Override
	public void registerDisplayInformation()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMinedBlock.class, new RenderMinedBlock());
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
