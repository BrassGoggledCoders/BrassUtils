
package brassutils.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
import cpw.mods.fml.common.event.FMLMissingMappingsEvent.MissingMapping;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.Type;

import net.minecraftforge.common.MinecraftForge;

import boilerplate.common.IBoilerplateMod;
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
		// Dirty, but it works
		if (Loader.isModLoaded("EnderGlove"))
		{
			throw new RuntimeException(
					"Please uninstall EnderGlove to continue. EnderGlove has been merged into this mod, and so cannot be used alongside it. Old EnderGlove items will be transferred safely");
		}
		if (Loader.isModLoaded("TurfMod"))
		{
			throw new RuntimeException(
					"Please uninstall TurfMod to continue. TurfMod has been merged into this mod, and so cannot be used alongside it. Old TurfMod items will be transferred safely");
		}
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

	// Remap old items from merged in mods
	@EventHandler
	public void missingMapping(FMLMissingMappingsEvent event)
	{
		for (MissingMapping m : event.getAll())
		{
			if (m.type == Type.BLOCK)
			{
				if (m.name.equals("EnderGlove:BlockEnderTotem"))
				{
					m.remap(GameRegistry.findBlock(ModInfo.ID, "BlockEnderTotem"));
				}
				else if (m.name.equals("EnderGlove:blockTotemTop"))
				{
					m.remap(GameRegistry.findBlock(ModInfo.ID, "BlockEnderTotemTop"));
				}
				else if (m.name.equals("TurfMod:BlockTurf"))
				{
					m.remap(GameRegistry.findBlock(ModInfo.ID, "BlockTurf"));
				}
				else if (m.name.equals("TurfMod:BlockLeafCover"))
				{
					m.remap(GameRegistry.findBlock(ModInfo.ID, "BlockLeafCover"));
				}
				else if (m.name.equals("TurfMod:BlockGrassCover"))
				{
					m.remap(GameRegistry.findBlock(ModInfo.ID, "BlockGrassCover"));
				}
				else if (m.name.equals("steamcraft:BlockEngravedVanilla"))
				{
					m.remap(GameRegistry.findBlock(ModInfo.ID, "BlockEngravedVanilla"));
				}
			}
			else if (m.type == Type.ITEM)
			{
				if (m.name.equals("EnderGlove:ItemEnderGlove"))
				{
					m.remap(GameRegistry.findItem(ModInfo.ID, "ItemEnderGlove"));
				}
				else if (m.name.equals("EnderGlove:ItemEnderPocket"))
				{
					m.remap(GameRegistry.findItem(ModInfo.ID, "ItemEnderPocket"));
				}
				else if (m.name.equals("EnderGlove:BlockEnderTotem"))
				{
					m.remap(Item.getItemFromBlock(GameRegistry.findBlock(ModInfo.ID, "BlockEnderTotem")));
				}
				else if (m.name.equals("EnderGlove:blockTotemTop"))
				{
					m.remap(Item.getItemFromBlock(GameRegistry.findBlock(ModInfo.ID, "BlockEnderTotemTop")));
				}
				else if (m.name.equals("TurfMod:ItemTurfKnife"))
				{
					m.remap(GameRegistry.findItem(ModInfo.ID, "ItemTurfKnife"));
				}
				else if (m.name.equals("TurfMod:BlockTurf"))
				{
					m.remap(Item.getItemFromBlock(GameRegistry.findBlock(ModInfo.ID, "BlockTurf")));
				}
				else if (m.name.equals("TurfMod:BlockLeafCover"))
				{
					m.remap(Item.getItemFromBlock(GameRegistry.findBlock(ModInfo.ID, "BlockLeafCover")));
				}
				else if (m.name.equals("TurfMod:BlockGrassCover"))
				{
					m.remap(Item.getItemFromBlock(GameRegistry.findBlock(ModInfo.ID, "BlockGrassCover")));
				}
				String[] toRemap = new String[] {
						"ItemObsidianHelmet, ItemObsidianChestplate, ItemObsidianLegs, ItemObsidianBoots, ItemEtheriumHelmet, ItemEtheriumChestplate, ItemEtheriumLegs, ItemEtheriumBoots, ItemObsidianSword, ItemObsidianPickaxe, ItemObsidianShovel, ItemObsidianAxe, ItemObsidianHoe, ItemEtheriumSword, ItemEtheriumPickaxe, ItemEtheriumShovel, ItemEtheriumAxe, ItemEtheriumHoe",
						"ItemChisel" };
				for (int i = 0; i < toRemap.length; i++)
				{
					if (m.name.equals("steamcraft:" + toRemap[i]))
					{
						m.remap(Item.getItemFromBlock(GameRegistry.findBlock(ModInfo.ID, toRemap[i])));
					}
				}
			}
		}
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
}
