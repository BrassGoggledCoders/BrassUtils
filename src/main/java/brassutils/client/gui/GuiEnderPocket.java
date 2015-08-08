/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import brassutils.common.lib.LibInfo;
import org.lwjgl.opengl.GL11;

/**
 * @author Surseance
 *
 */
public class GuiEnderPocket extends GuiContainer
{
	private static ResourceLocation guitexture = new ResourceLocation(LibInfo.PREFIX + "textures/gui/enderpocket.png");

	public GuiEnderPocket(Container p_i1072_1_)
	{
		super(p_i1072_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		this.mc.renderEngine.bindTexture(guitexture);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

		this.drawTexturedModalRect(this.guiLeft + 12, this.guiTop + 64, 176, 56, 16, 1);
	}
}
