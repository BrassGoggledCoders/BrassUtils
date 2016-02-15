
package brassutils.common;

import net.minecraftforge.fml.common.registry.EntityRegistry;

import xyz.brassgoggledcoders.boilerplate.lib.common.entity.EntityMinedBlock;

/**
 * @author Surseance
 *
 */
public class InitEntities
{
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityMinedBlock.class, "MinedBlock", InitConfig.entMinedBlockId, BrassUtils.instance, 160, 1, true);
	}
}
