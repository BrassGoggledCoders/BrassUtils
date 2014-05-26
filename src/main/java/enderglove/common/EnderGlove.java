/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:00:01 PM]
 */
package enderglove.common;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import enderglove.common.config.Config;
import enderglove.common.config.ConfigBlocks;
import enderglove.common.config.ConfigEntities;
import enderglove.common.config.ConfigItems;
import enderglove.common.lib.EGCraftingManager;
import enderglove.common.lib.EnderGloveWorldGenerator;
import enderglove.common.lib.EventHandlerEntity;
import enderglove.common.lib.EventHandlerWorld;
import enderglove.common.lib.LibInfo;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
@Mod(modid = LibInfo.ID, name = LibInfo.NAME, version = LibInfo.VERSION)
public class EnderGlove
{
	@SidedProxy(clientSide = LibInfo.CLIENT_PROXY, serverSide = LibInfo.COMMON_PROXY)
	public static CommonProxy proxy;

	@Mod.Instance(LibInfo.ID)
	public static EnderGlove instance;
	public EnderGloveWorldGenerator worldGen;
	public EventHandlerEntity entityEventHandler;
	public EventHandlerWorld worldEventHandler;
	public File directory;

	// public static CreativeTabs tabEG = new
	// CreativeTabEG(CreativeTabs.getNextID(), "enderglove");

	@Mod.EventHandler
	public void foreplay(FMLPreInitializationEvent event)
	{
		event.getModMetadata().version = LibInfo.VERSION;
		directory = event.getModConfigurationDirectory();

		LanguageRegistry.instance().getStringLocalization("itemGroup.endergloves", "en_US");
		try
		{
			Config.initialize(event.getSuggestedConfigurationFile());
		} catch (Exception e)
		{
			FMLLog.severe("EnderGlove could not load its config file!",
					new Object[0]);
		} finally
		{
			if (Config.config != null)
				Config.save();
		}

		entityEventHandler = new EventHandlerEntity();
		worldEventHandler = new EventHandlerWorld();
		FMLCommonHandler.instance().bus().register(entityEventHandler);
		MinecraftForge.EVENT_BUS.register(worldEventHandler);
		// GameRegistry.registerWorldGenerator(this.worldGen = new
		// EnderGloveWorldGenerator(), 0);

		Config.save();

		ConfigBlocks.init();
		ConfigItems.init();
		EGCraftingManager.init();
	}

	@Mod.EventHandler
	public void orgasm(FMLInitializationEvent event)
	{
		proxy.registerDisplayInformation();
		
		ConfigEntities.init();
	}

	@Mod.EventHandler
	public void cuddling(FMLPostInitializationEvent event) {}
}
