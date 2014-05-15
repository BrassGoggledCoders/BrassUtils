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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import endergloves.common.item.ItemEnderGlove;

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

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return helper != IItemRenderer.ItemRendererHelper.BLOCK_3D;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		Minecraft mc = Minecraft.getMinecraft();

		if ((item == null) || (!(item.getItem() instanceof ItemEnderGlove)))
			return;

		ItemEnderGlove glove = (ItemEnderGlove)item.getItem();
		EntityLivingBase wielder = null;

		if ((type == IItemRenderer.ItemRenderType.EQUIPPED) || (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON))
			wielder = (EntityLivingBase)data[1];

		GL11.glPushMatrix();

		if (type != IItemRenderer.ItemRenderType.INVENTORY) 
		{
			if (type == IItemRenderer.ItemRenderType.ENTITY)
			{
				GL11.glTranslated(0.0D, 1.0D, 0.0D);
			}
			else 
			{
				GL11.glTranslated(0.5D, 1.5D, 0.5D);
			
				if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON)
					GL11.glScaled(1.0D, 1.1D, 1.0D);
			}
		}
		else 
		{
			GL11.glRotatef(66.0F, 0.0F, 0.0F, 1.0F);
			GL11.glTranslated(0.0D, 0.6D, 0.0D);
		}
		
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    this.modelGlove.render(item);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	}
}
