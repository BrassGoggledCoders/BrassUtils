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

import net.minecraftforge.client.MinecraftForgeClient;
import endergloves.client.renderers.item.ItemEnderGloveRenderer;
import endergloves.common.CommonProxy;
import endergloves.common.config.ConfigItems;

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
}
