/**
 * This class was created by <Surseance> or his SC2 development team.
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 * Steamcraft 2 is based on the original Steamcraft Mod created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 *
 * File created @ 23-May-2014
 */
package brassutils.common.commands;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class Boilerplate.
 */
@Mod(modid = "commands+", name = "CommandsPlus", version = "1.0.0")
public class CommandsPlus
{
	// @SidedProxy(clientSide = "boilerplate.client.ClientProxy", serverSide =
	// "boilerplate.common.CommonProxy")
	// public static CommonProxy proxy;

	@Instance
	public static CommandsPlus instance;

	/**
	 * Pre init.
	 *
	 * @param event
	 *            the event
	 */
	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event)
	{

	}
}
