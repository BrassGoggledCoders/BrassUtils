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
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import endergloves.common.config.Config;
import endergloves.common.lib.LibInfo;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
@Mod(modid = LibInfo.ID, name = LibInfo.NAME, version = LibInfo.VERSION) // @version: major, minor, revision
public class EnderGloves
{
	@Mod.Instance(LibInfo.ID)
	public static EnderGloves instance;
	
	@SidedProxy(clientSide = LibInfo.CLIENT_PROXY, serverSide = LibInfo.COMMON_PROXY)
	public static CommonProxy proxy;
	
	public File directory;
	
	@Mod.EventHandler
	public void foreplay(FMLPreInitializationEvent event)
	{
		event.getModMetadata().version = LibInfo.VERSION;
		this.directory = event.getModConfigurationDirectory();
		
		LanguageRegistry.instance().getStringLocalization("itemGroup.endergloves", "en_US"); // For the Creative Tab
		
		try
		{
			Config.initialize(event.getSuggestedConfigurationFile());
		} 
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "EnderGloves could not load its config file!", new Object[0]);
		}
		finally 
		{
			
		}
	}
	
	@Mod.EventHandler
	public void orgasm(FMLInitializationEvent event)
	{
		
	}
	
	@Mod.EventHandler
	public void cuddling(FMLPostInitializationEvent event)
	{
		
	}
}
