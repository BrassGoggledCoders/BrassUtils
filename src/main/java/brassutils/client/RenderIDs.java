
package brassutils.client;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderIDs
{
	public static int blockCrystalRI;

	public static void setIDs()
	{
		blockCrystalRI = RenderingRegistry.getNextAvailableRenderId();

	}
}
