package enderglove.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import enderglove.common.lib.LibInfo;

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

		mc.renderEngine.bindTexture(guitexture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		this.drawTexturedModalRect(guiLeft + 12, guiTop + 64, 176, 56, 16, 1);
	}
}
