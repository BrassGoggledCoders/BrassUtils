/**
 * This class was created by <MrArcane111> or his SC2 development team.
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 * Steamcraft 2 is based on the original Steamcraft created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 *
 * Some code is derived from PowerCraft created by MightyPork which is registered
 * under the MMPL v1.0.
 * PowerCraft (c) MightyPork 2012
 *
 * File created @ [30 Mar 2014, 20:00:28]
 */
package brassutils.common;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * @author warlordjones
 *
 *         30 Mar 201420:00:28
 */
public class ConfigHandler
{

	public static boolean endPortalRecipe;
	public static boolean creativeCommandBlock;

	/**
	 * @param suggestedConfigurationFile
	 */
	public static void handleConfig(File suggestedConfigurationFile)
	{
		final Configuration config = new Configuration(suggestedConfigurationFile);
		config.load();
		endPortalRecipe = config.getBoolean("End Portal Recipe", Configuration.CATEGORY_GENERAL, true,
				"Enables/Disables (Expensive) End Portal Recipe");
		creativeCommandBlock = config.getBoolean("CommandBlock Creative Tab", Configuration.CATEGORY_GENERAL, true,
				"Enables/Disables adding command block to redstone creative tab");
		config.save();
	}

}
