/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 8:10:36 PM] 
 */
package endergloves.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class Config
{
	public static Configuration config;
	
	public static void initialize(File file)
	{
		config = new Configuration(file);
		// Categories
		config.load();
		
		// Blah, blah, blah
		
		config.save();
	}
	
	public static void save()
	{
		config.save();
	}
}
