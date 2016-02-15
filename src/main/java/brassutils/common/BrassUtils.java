
package brassutils.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import brassutils.client.gui.GuiHandler;
import brassutils.common.commands.CommandDeathNote;
import brassutils.common.commands.CommandFeed;
import brassutils.common.commands.CommandHeal;
import brassutils.common.commands.CommandHome;
import brassutils.common.commands.CommandInfo;
import brassutils.common.commands.CommandSayCoords;
import brassutils.common.gen.BrassUtilsWorldGenerator;
import brassutils.common.lib.CreativeTabBrassUtils;
import brassutils.common.lib.FMLEventHandler;
import brassutils.common.lib.ForgeEventHandler;
import brassutils.common.lib.ModInfo;
import xyz.brassgoggledcoders.boilerplate.lib.common.IBoilerplateMod;
import xyz.brassgoggledcoders.boilerplate.lib.common.utils.ModLogger;
import xyz.brassgoggledcoders.boilerplate.mod.Boilerplate;

/**
 * @author Surseance
 *
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:boilerplate; after:TConstruct")
public class BrassUtils implements IBoilerplateMod
{

	// http://pastebin.com/3pk16QgA
	@SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.COMMON_PROXY)
	public static CommonProxy proxy;

	@Instance(ModInfo.ID)
	public static BrassUtils instance;

	public static CreativeTabs tabBU = new CreativeTabBrassUtils(ModInfo.ID);

	public BrassUtilsWorldGenerator worldGen;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// Config
		InitConfig.initialize(event.getSuggestedConfigurationFile());
		// Event Handlers
		FMLCommonHandler.instance().bus().register(new FMLEventHandler());
		MinecraftForge.EVENT_BUS.register(new ForgeEventHandler());

		// Worldgen Handler
		GameRegistry.registerWorldGenerator(this.worldGen = new BrassUtilsWorldGenerator(), 100);
		// Config
		InitConfig.save();
		// Blocks & Items
		InitBlocks.init();
		InitMaterials.initializeMaterials();
		InitItems.init();
		// Gui
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerDisplayInformation();
		InitEntities.init();

		// Set creative tabs for some blocks
		if (InitConfig.creativeCommandBlock)
		{
			Blocks.command_block.setCreativeTab(CreativeTabs.tabRedstone);
		}
		Blocks.dragon_egg.setCreativeTab(CreativeTabs.tabDecorations);
		Blocks.farmland.setCreativeTab(CreativeTabs.tabBlock);

		// Sending IMC
		if (Loader.isModLoaded("TConstruct"))
		{
			MATTHandler.addVanillaSmelting();
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		// Recipes
		InitRecipes.init();
		// Loot
		DungeonLootHandler.init();
	}

	@Mod.EventHandler
	public void serverStart(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandDeathNote());
		event.registerServerCommand(new CommandHeal());
		// event.registerServerCommand(new CommandCraft());
		event.registerServerCommand(new CommandHome());
		event.registerServerCommand(new CommandSayCoords());
		event.registerServerCommand(new CommandFeed());
		event.registerServerCommand(new CommandInfo());
		// event.registerServerCommand(new CommandViewInv());
	}

	@Override
	public Object getInstance()
	{
		return BrassUtils.instance;
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return BrassUtils.tabBU;
	}

	@Override
	public String getID()
	{
		return ModInfo.ID;
	}

	@Override
	public String getName()
	{
		return ModInfo.NAME;
	}

	@Override
	public String getVersion()
	{
		return ModInfo.VERSION;
	}

	@Override
	public String getPrefix()
	{
		return ModInfo.PREFIX;
	}

	@Override
	public String getClientProxyPath()
	{
		return ModInfo.CLIENT_PROXY;
	}

	@Override
	public String getCommonProxyPath()
	{
		return ModInfo.COMMON_PROXY;
	}

	@Override
	public ModLogger getLogger()
	{
		// TODO
		return Boilerplate.logger;
	}
}
