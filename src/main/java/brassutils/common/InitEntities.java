
package brassutils.common;

import cpw.mods.fml.common.registry.EntityRegistry;

import boilerplate.common.entity.EntityMinedBlock;

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
