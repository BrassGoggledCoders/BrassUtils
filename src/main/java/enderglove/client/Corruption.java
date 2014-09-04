/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package enderglove.client;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Surseance
 *
 */
public class Corruption
{
	Random rand = new Random();
	// ThreadDownloadImageData
	public static final String[] TEXTURE_UPLOADED = new String[] { "textureUploaded", "field_110559_g", "i" };
	public static final String[] BUFFERED_IMAGE = new String[] { "bufferedImage", "field_110560_d", "g" };

	public static void init()
	{
		FMLCommonHandler.instance().bus().register(new Corruption());
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlayerTick(ClientTickEvent event)
	{
		if(event.phase == Phase.END)
		{
			EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
			if((player != null) && (player.ticksExisted > 300))
			{
				// /ThreadDownloadImageData tex = player.getSkin);
				// BufferedImage img = ReflectionHelper.getPrivateValue(ThreadDownloadImageData.class, tex, Corruption.BUFFERED_IMAGE);
				// if(img != null)
				// if(player.getHeldItem() == new ItemStack(ConfigItems.itemEnderGlove))
				// {
				// for(int i = 0; i < 1 + (player.ticksExisted - 300) / 30; i++)
				// corruptRandomPixel(tex, img);
				// }
			}
		}
	}

	public void corruptRandomPixel(ThreadDownloadImageData tex, BufferedImage img)
	{
		int width = img.getWidth();
		int height = img.getHeight();

		int x = this.rand.nextInt(width);
		int y = this.rand.nextInt(height);
		Color color = new Color(img.getRGB(x, y));
		if((color.getRed() + color.getGreen() + color.getRed()) > 0)
			img.setRGB(x, y, color.darker().darker().getRGB());
		ReflectionHelper.setPrivateValue(ThreadDownloadImageData.class, tex, false, Corruption.TEXTURE_UPLOADED);

	}
}
