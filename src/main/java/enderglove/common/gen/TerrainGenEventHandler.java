package enderglove.common.gen;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.terraingen.BiomeEvent;

@Deprecated
public class TerrainGenEventHandler
{
	@SubscribeEvent
    public void onCreateDecorator(BiomeEvent.CreateDecorator event1)
	{
        event1.newBiomeDecorator = new EnderGlovesDecorator(event1.biome);
	};
}
