/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package enderglove.common;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import enderglove.client.gui.GuiHandler;
import enderglove.common.config.Config;
import enderglove.common.gen.EnderGloveWorldGenerator;
import enderglove.common.lib.CreativeTabEnderglove;
import enderglove.common.lib.EventHandlerEntity;
import enderglove.common.lib.EventHandlerWorld;
import enderglove.common.lib.LibInfo;

/**
 * @author Surseance
 * 
 */
@Mod(modid = LibInfo.ID, name = LibInfo.NAME, version = LibInfo.VERSION, dependencies = "required-after:boilerplate")
public class EnderGlove
{
	@SidedProxy(clientSide = LibInfo.CLIENT_PROXY, serverSide = LibInfo.COMMON_PROXY)
	public static CommonProxy proxy;

	@Instance(LibInfo.ID)
	public static EnderGlove instance;

	public static CreativeTabs tabEG = new CreativeTabEnderglove(CreativeTabs.getNextID(), "enderglove", Items.ender_pearl);
	
	public EnderGloveWorldGenerator worldGen;
	public EventHandlerEntity entityEventHandler;
	public EventHandlerWorld worldEventHandler;
	public File directory;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// Ignore this, it's a little thing I am testing *ignores*
		// MinecraftForge.EVENT_BUS.register(new Corruption());
		// FMLCommonHandler.instance().bus().register(new Corruption());
		event.getModMetadata().version = LibInfo.VERSION;
		this.directory = event.getModConfigurationDirectory();

		LanguageRegistry.instance().getStringLocalization("itemGroup.endergloves", "en_US");
		try
		{
			Config.initialize(event.getSuggestedConfigurationFile());
		}
		catch(Exception e)
		{
			FMLLog.severe("EnderGlove could not load its config file!", new Object[0]);
		}
		finally
		{
			if(Config.config != null)
				Config.save();
		}

		this.entityEventHandler = new EventHandlerEntity();
		this.worldEventHandler = new EventHandlerWorld();

		FMLCommonHandler.instance().bus().register(this.entityEventHandler);
		MinecraftForge.EVENT_BUS.register(this.worldEventHandler);

		if(Config.totemGen)
			GameRegistry.registerWorldGenerator(this.worldGen = new EnderGloveWorldGenerator(), 100);
		// MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainGenEventHandler());

		Config.save();

		InitBlocks.init();
		InitItems.init();

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerDisplayInformation();
		InitEntities.init();

		if(Config.recipe)
		{
			GameRegistry.addRecipe(new ItemStack(InitItems.itemEnderGlove), new Object[] { "EEE", "LNL", "LLL", 'L', Items.leather, 'N', Items.nether_star, 'E',
				Items.ender_eye });
		}

		if(Config.chestGen) // TODO: Add this as a method in the Config class
		{
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(InitItems.itemEnderGlove), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(InitItems.itemEnderGlove), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(InitItems.itemEnderGlove), 1, 1, 2));
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
