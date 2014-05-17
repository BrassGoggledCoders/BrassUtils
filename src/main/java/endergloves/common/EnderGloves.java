/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:00:01 PM] 
 */
package endergloves.common;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import endergloves.common.config.Config;
import endergloves.common.config.ConfigBlocks;
import endergloves.common.config.ConfigItems;
import endergloves.common.lib.CreativeTabEG;
import endergloves.common.lib.EnderGloveWorldGenerator;
import endergloves.common.lib.EventHandlerEntity;
import endergloves.common.lib.EventHandlerWorld;
import endergloves.common.lib.LibInfo;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
@Mod(modid = LibInfo.ID, name = LibInfo.NAME, version = LibInfo.VERSION) 
public class EnderGloves
{
	@SidedProxy(clientSide = LibInfo.CLIENT_PROXY, serverSide = LibInfo.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@Mod.Instance(LibInfo.ID)
	public static EnderGloves instance;
	public EnderGloveWorldGenerator worldGen;
	public EventHandlerEntity entityEventHandler;
	public EventHandlerWorld worldEventHandler;
	public File directory;

	public static CreativeTabs tabEG = new CreativeTabEG(CreativeTabs.getNextID(), "endergloves");

	@Mod.EventHandler
	public void foreplay(FMLPreInitializationEvent event)
	{
		event.getModMetadata().version = LibInfo.VERSION;
		this.directory = event.getModConfigurationDirectory();

		LanguageRegistry.instance().getStringLocalization("itemGroup.endergloves", "en_US"); 
		try
		{
			Config.initialize(event.getSuggestedConfigurationFile());
		} 
		catch (Exception e)
		{
			FMLLog.severe("EnderGloves could not load its config file!", new Object[0]); //(Level.SEVERE, e, "EnderGloves could not load its config file!", new Object[0]);
		}
		finally 
		{
			if (Config.config != null)
				Config.save();
		}

		this.entityEventHandler = new EventHandlerEntity();
		this.worldEventHandler = new EventHandlerWorld();
		MinecraftForge.EVENT_BUS.register(this.worldEventHandler);
		MinecraftForge.EVENT_BUS.register(this.entityEventHandler);
		//GameRegistry.registerWorldGenerator(this.worldGen = new EnderGloveWorldGenerator(), 0);

		Config.save();

		ConfigBlocks.init();
		ConfigItems.init();
	}

	@Mod.EventHandler
	public void orgasm(FMLInitializationEvent event)
	{
		proxy.registerDisplayInformation();
	}

	@Mod.EventHandler
	public void cuddling(FMLPostInitializationEvent event) {}
}
