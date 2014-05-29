/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 25, 2014, 3:21:14 PM] 
 */
package enderglove.common.config;

import boilerplate.common.entity.EntityMinedBlock;
import cpw.mods.fml.common.registry.EntityRegistry;
import enderglove.common.EnderGlove;

/**
 * @author Surseance (Johnny Eatmon) 
 * Email: surseance@autistici.org
 * 
 */
public class ConfigEntities
{
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityMinedBlock.class, "MinedBlock", Config.entMinedBlockId, EnderGlove.instance, 160, 1, true);
	}
}
