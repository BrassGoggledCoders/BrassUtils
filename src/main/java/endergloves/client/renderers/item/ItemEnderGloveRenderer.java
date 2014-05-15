/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 14, 2014, 9:06:20 PM] 
 */
package endergloves.client.renderers.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import endergloves.common.item.ItemEnderGlove;
import endergloves.common.lib.LibInfo;

/**
 * The ItemRenderer for the ender glove item.
 * 
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
public class ItemEnderGloveRenderer implements IItemRenderer
{
	private ModelEnderGlove modelGlove = new ModelEnderGlove();
	private ResourceLocation gloveTex = new ResourceLocation(LibInfo.PREFIX.replace(":", ""), "textures/models/modelglove.png");

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch (type)
		{
			case EQUIPPED_FIRST_PERSON:
				return true;
			case EQUIPPED:
				return true;
			default:
				return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
			case EQUIPPED:
			{
				GL11.glPushMatrix();
				float scale = 1.4F;
				GL11.glScalef(scale, scale, scale);
				Minecraft.getMinecraft().renderEngine.bindTexture(gloveTex);
				this.modelGlove.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			default:
				break;
		}
	}
}
