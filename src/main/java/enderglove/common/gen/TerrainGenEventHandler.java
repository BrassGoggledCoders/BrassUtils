package enderglove.common.gen;

import net.minecraftforge.event.terraingen.BiomeEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Deprecated
public class TerrainGenEventHandler
{
	@SubscribeEvent
    public void onCreateDecorator(BiomeEvent.CreateDecorator event1)
	{
        event1.newBiomeDecorator = new EnderGlovesDecorator(event1.biome);
	};
}
