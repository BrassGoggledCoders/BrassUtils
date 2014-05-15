/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 15, 2014, 4:06:42 PM] 
 */
package endergloves.client.renderers.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import endergloves.common.item.ItemEnderGlove;
import endergloves.common.lib.LibInfo;

/**
 * @author Surseance (Johnny Eatmon)
 * <jmaeatmon@gmail.com>
 *
 */
@SideOnly(Side.CLIENT)
public class ModelEnderGlove extends ModelBiped
{
	private ResourceLocation gloveTex = new ResourceLocation(LibInfo.PREFIX.replace(":", ""), "models/modelglove");
	
	public ModelRenderer eye;
	public ModelRenderer eye2;
	public ModelRenderer eye3;
	public ModelRenderer eyebase;
	public ModelRenderer finger;
	public ModelRenderer finger2;
	public ModelRenderer finger3;
	public ModelRenderer finger4;
	public ModelRenderer lfinger;
	public ModelRenderer lfinger2;
	public ModelRenderer lfinger3;
	public ModelRenderer lfinger4;
	public ModelRenderer lthumb;
	public ModelRenderer palm;
	public ModelRenderer palm2;
	public ModelRenderer thumb;
	public ModelRenderer wrist;

	public ModelEnderGlove()
	{
		//super(scale, 0, 64, 128);

		eye = new ModelRenderer(this, 44, 0);
		eye.addBox(0F, 0F, 0F, 4, 4, 4);
		eye.setRotationPoint(6F, 6F, 0F);

		eye2 = new ModelRenderer(this, 36, 10);
		eye2.addBox(0F, 0F, 0F, 2, 2, 6);
		eye2.setRotationPoint(7F, 7F, -1F);

		eye3 = new ModelRenderer(this, 46, 12);
		eye3.addBox(0F, 0F, 0F, 6, 2, 2);
		eye3.setRotationPoint(5F, 7F, 1F);

		eyebase = new ModelRenderer(this, 38, 0);
		eyebase.addBox(0F, 0F, 0F, 2, 1, 2);
		eyebase.setRotationPoint(7F, 4F, 1F);

		finger = new ModelRenderer(this, 0, 7);
		finger.addBox(0F, 0F, 0F, 5, 1, 1);
		finger.setRotationPoint(11F, 3F, -1F);
		finger.rotateAngleY = 6.126105674500097F;
		finger.rotateAngleZ = 6.09119908946021F;

		finger2 = new ModelRenderer(this, 0, 7);
		finger2.addBox(0F, 0F, 0F, 5, 1, 1);
		finger2.setRotationPoint(11F, 3F, 0F);
		finger2.rotateAngleZ = 0.24434609527920614F;

		finger3 = new ModelRenderer(this, 0, 7);
		finger3.addBox(0F, 0F, 0F, 5, 1, 1);
		finger3.setRotationPoint(11F, 3F, 2F);
		finger3.rotateAngleZ = 6.14355896702004F;

		finger4 = new ModelRenderer(this, 0, 7);
		finger4.addBox(0F, 0F, 0F, 5, 1, 1);
		finger4.setRotationPoint(11F, 3F, 4F);
		finger4.rotateAngleZ = 6.14355896702004F;

		lfinger = new ModelRenderer(this, 0, 9);
		lfinger.addBox(0F, 0F, 0F, 3, 1, 1);
		lfinger.setRotationPoint(15F, 4F, 2F);
		lfinger.rotateAngleZ = 0.5759586531581288F;

		lfinger2 = new ModelRenderer(this, 0, 9);
		lfinger2.addBox(0F, -1F, 0F, 3, 1, 1);
		lfinger2.setRotationPoint(15F, 3F, 0F);
		lfinger2.rotateAngleZ = 0.5061454830783556F;

		lfinger3 = new ModelRenderer(this, 0, 9);
		lfinger3.addBox(0F, 0F, 0F, 3, 1, 1);
		lfinger3.setRotationPoint(15F, 4F, -2F);
		lfinger3.rotateAngleZ = 0.15707963267948966F;

		lfinger4 = new ModelRenderer(this, 0, 9);
		lfinger4.addBox(0F, 0F, 0F, 3, 1, 1);
		lfinger4.setRotationPoint(15F, 4F, 4F);
		lfinger4.rotateAngleZ = 0.3839724354387525F;

		lthumb = new ModelRenderer(this, 0, 9);
		lthumb.addBox(0F, 0F, 0F, 3, 1, 1);
		lthumb.setRotationPoint(13F, 2F, -4F);
		lthumb.rotateAngleX = 0.03490658503988659F;
		lthumb.rotateAngleY = 6.1086523819801535F;
		lthumb.rotateAngleZ = 6.1086523819801535F;

		palm = new ModelRenderer(this, 18, 0);
		palm.addBox(0F, 0F, 0F, 7, 4, 6);
		palm.setRotationPoint(5F, 0F, -1F);

		palm2 = new ModelRenderer(this, 18, 10);
		palm2.addBox(0F, 0F, 0F, 5, 3, 8);
		palm2.setRotationPoint(6F, 1F, -2F);

		thumb = new ModelRenderer(this, 0, 11);
		thumb.addBox(0F, 0F, 0F, 4, 1, 1);
		thumb.setRotationPoint(11F, 1F, -1F);
		thumb.rotateAngleX = 0.3839724354387525F;
		thumb.rotateAngleY = 5.3930673886624785F;
		thumb.rotateAngleZ = 6.1086523819801535F;

		wrist = new ModelRenderer(this, 0, 0);
		wrist.addBox(0F, 0F, 0F, 5, 3, 4);

		this.bipedRightArm.addChild(eye);
		this.bipedRightArm.addChild(eye2);
		this.bipedRightArm.addChild(eye3);
		this.bipedRightArm.addChild(eyebase);
		this.bipedRightArm.addChild(finger);
		this.bipedRightArm.addChild(finger2);
		this.bipedRightArm.addChild(finger3);
		this.bipedRightArm.addChild(finger4);
		this.bipedRightArm.addChild(lfinger);
		this.bipedRightArm.addChild(lfinger2);
		this.bipedRightArm.addChild(lfinger3);
		this.bipedRightArm.addChild(lfinger4);
		this.bipedRightArm.addChild(palm);
		this.bipedRightArm.addChild(palm2);
		this.bipedRightArm.addChild(thumb);
		this.bipedRightArm.addChild(wrist);
	}

	//@Override
	public void render(ItemStack is)//, float f, float f1, float f2, float f3, float f4, float f5)
	{
		if (RenderManager.instance.renderEngine == null) 
			return;
		
		ItemEnderGlove wand = (ItemEnderGlove)is.getItem();
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		Minecraft.getMinecraft().renderEngine.bindTexture(this.gloveTex);
		GL11.glPushMatrix();

		float scale = 0.0625F;
		eye.render(scale);
		eye2.render(scale);
		eye3.render(scale);
		eyebase.render(scale);
		finger.render(scale);
		finger2.render(scale);
		finger3.render(scale);
		finger4.render(scale);
		lfinger.render(scale);
		lfinger2.render(scale);
		lfinger3.render(scale);
		lfinger4.render(scale);
		lthumb.render(scale);
		palm.render(scale);
		palm2.render(scale);
		thumb.render(scale);
		wrist.render(scale);
		
		GL11.glPopMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
