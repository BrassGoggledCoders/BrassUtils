/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:03:23 PM] 
 */
package endergloves.client;

import net.minecraft.world.World;
import endergloves.client.lib.UtilsFX;
import endergloves.common.CommonProxy;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class ClientProxy extends CommonProxy
{ 
	@Override
	public void registerDisplayInformation()
	{
		//MinecraftForgeClient.registerItemRenderer(ConfigItems.itemEnderGlove, new ItemEnderGloveRenderer());
	} 
	
	@Override
	public void blockSparkle(World world, int x, int y, int z, int count)
	{
		UtilsFX.blockSparkle(world, x, y, z, count);
	}
	
	@Override
	public void blockFlameFX(World world, int x, int y, int z, int count)
	{
		UtilsFX.blockFlameFX(world, x, y, z, count);
	}
}
