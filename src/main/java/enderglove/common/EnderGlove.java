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

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import enderglove.common.config.Config;
import enderglove.common.config.ConfigBlocks;
import enderglove.common.config.ConfigEntities;
import enderglove.common.config.ConfigItems;
import enderglove.common.gen.EnderGloveWorldGenerator;
import enderglove.common.lib.EGCraftingManager;
import enderglove.common.lib.EventHandlerEntity;
import enderglove.common.lib.EventHandlerWorld;
import enderglove.common.lib.LibInfo;

/**
 * @author Surseance (Johnny Eatmon)
 * Email: surseance@autistici.org
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

	// public static CreativeTabs tabEG = new CreativeTabEG(CreativeTabs.getNextID(), "enderglove");

	@Mod.EventHandler
	public void foreplay(FMLPreInitializationEvent event)
	{
		//Ignore this, it's a little thing I am testing *ignores*
		//MinecraftForge.EVENT_BUS.register(new Corruption());
		//FMLCommonHandler.instance().bus().register(new Corruption());
		event.getModMetadata().version = LibInfo.VERSION;
		this.directory = event.getModConfigurationDirectory();

		LanguageRegistry.instance().getStringLocalization("itemGroup.endergloves", "en_US");
		try
		{
			Config.initialize(event.getSuggestedConfigurationFile());
		}
		catch (Exception e)
		{
			FMLLog.severe("EnderGlove could not load its config file!", new Object[0]);
		}
		finally
		{
			if (Config.config != null)
				Config.save();
		}

		this.entityEventHandler = new EventHandlerEntity();
		this.worldEventHandler = new EventHandlerWorld();

		FMLCommonHandler.instance().bus().register(entityEventHandler);
		MinecraftForge.EVENT_BUS.register(worldEventHandler);

		if(Config.totemGen)
		GameRegistry.registerWorldGenerator(worldGen = new EnderGloveWorldGenerator(), 100);
		//MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainGenEventHandler());

		Config.save();

		ConfigBlocks.init();
		ConfigItems.init();
	}

	@Mod.EventHandler
	public void orgasm(FMLInitializationEvent event)
	{
		proxy.registerDisplayInformation();

		ConfigEntities.init();
		if(Config.recipe)
		EGCraftingManager.init();

		if(Config.chestGen)
		{
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(ConfigItems.itemEnderGlove), 1, 1, 1));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(ConfigItems.itemEnderGlove), 1, 1, 1));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(ConfigItems.itemEnderGlove), 1, 1, 2));
		}
	}

	@Mod.EventHandler
	public void cuddling(FMLPostInitializationEvent event) {}
}
