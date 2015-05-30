/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
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
		EntityRegistry.registerModEntity(EntityMinedBlock.class, "MinedBlock", Config.entMinedBlockId, BrassUtils.instance, 160, 1, true);
	}
}
