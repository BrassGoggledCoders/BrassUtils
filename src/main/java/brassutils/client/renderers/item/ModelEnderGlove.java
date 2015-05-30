/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.client.renderers.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Surseance
 *
 */
@SideOnly(Side.CLIENT)
public class ModelEnderGlove extends ModelBase
{
	// fields
	ModelRenderer wrist;
	ModelRenderer palm;
	ModelRenderer finger1;
	ModelRenderer finger2;
	ModelRenderer finger3;
	ModelRenderer lfinger1;
	ModelRenderer lfinger2;
	ModelRenderer lfinger3;
	ModelRenderer eyebase;
	ModelRenderer llfinger1;
	ModelRenderer llfinger2;
	ModelRenderer llfinger3;
	ModelRenderer thumb;
	ModelRenderer thumb2;
	ModelRenderer eyeholder;
	ModelRenderer eyeholder1;
	ModelRenderer eyeholder2;
	ModelRenderer eyeholder3;
	ModelRenderer wrist2;
	ModelRenderer wrist3;
	ModelRenderer finger4;
	ModelRenderer lfinger4;
	ModelRenderer llfinger4;
	ModelRenderer palm2;

	public ModelEnderGlove()
	{
		// textureWidth = 64;
		// textureHeight = 32;
		this.wrist = new ModelRenderer(this, 0, 0);
		this.wrist.addBox(0F, 0F, 0F, 3, 1, 3);
		this.wrist.setRotationPoint(-1F, -0.5F, 0F);
		this.wrist.setTextureSize(64, 32);
		this.wrist.mirror = true;
		this.setRotation(this.wrist, 0F, 0F, 0F);
		this.palm = new ModelRenderer(this, 0, 3);
		this.palm.addBox(0F, 0F, 0F, 5, 2, 5);
		this.palm.setRotationPoint(-6F, -1.5F, -1F);
		this.palm.setTextureSize(64, 32);
		this.palm.mirror = true;
		this.setRotation(this.palm, 0F, 0F, 0F);
		this.finger1 = new ModelRenderer(this, 0, 30);
		this.finger1.addBox(0F, 0F, 0F, 3, 1, 1);
		this.finger1.setRotationPoint(-5F, -1F, 0.5F);
		this.finger1.setTextureSize(64, 32);
		this.finger1.mirror = true;
		this.setRotation(this.finger1, 0.0136322F, 0.0012186F, 2.490967F);
		this.finger2 = new ModelRenderer(this, 0, 30);
		this.finger2.addBox(0F, 0F, 0F, 3, 1, 1);
		this.finger2.setRotationPoint(-5F, -1F, 2F);
		this.finger2.setTextureSize(64, 32);
		this.finger2.mirror = true;
		this.setRotation(this.finger2, 0.0136322F, 0.0012186F, 2.490967F);
		this.finger3 = new ModelRenderer(this, 0, 30);
		this.finger3.addBox(0F, 0F, 0F, 3, 1, 1);
		this.finger3.setRotationPoint(-5F, -1F, -1F);
		this.finger3.setTextureSize(64, 32);
		this.finger3.mirror = true;
		this.setRotation(this.finger3, 0.0136322F, 0.0012186F, 2.490967F);
		this.lfinger1 = new ModelRenderer(this, 0, 28);
		this.lfinger1.addBox(0F, 0F, 0F, 2, 1, 1);
		this.lfinger1.setRotationPoint(-7.5F, 1F, -1F);
		this.lfinger1.setTextureSize(64, 32);
		this.lfinger1.mirror = true;
		this.setRotation(this.lfinger1, 0.0136322F, 0.0012186F, 0.669215F);
		this.lfinger2 = new ModelRenderer(this, 0, 28);
		this.lfinger2.addBox(0F, 0F, 0F, 2, 1, 1);
		this.lfinger2.setRotationPoint(-7F, 0F, 0.5F);
		this.lfinger2.setTextureSize(64, 32);
		this.lfinger2.mirror = true;
		this.setRotation(this.lfinger2, 0.0136322F, 0.0012186F, 1.635859F);
		this.lfinger3 = new ModelRenderer(this, 0, 28);
		this.lfinger3.addBox(0F, 0F, 0F, 2, 1, 1);
		this.lfinger3.setRotationPoint(-7F, 0F, 2F);
		this.lfinger3.setTextureSize(64, 32);
		this.lfinger3.mirror = true;
		this.setRotation(this.lfinger3, 0.0136322F, 0.0012186F, 1.635859F);
		this.eyebase = new ModelRenderer(this, 0, 18);
		this.eyebase.addBox(0F, 0F, 0F, 3, 1, 3);
		this.eyebase.setRotationPoint(-5F, -2.466667F, 0F);
		this.eyebase.setTextureSize(64, 32);
		this.eyebase.mirror = true;
		this.setRotation(this.eyebase, 0F, 0F, 0F);
		this.llfinger1 = new ModelRenderer(this, 0, 26);
		this.llfinger1.addBox(0F, 0F, 0F, 2, 1, 1);
		this.llfinger1.setRotationPoint(-7F, 0F, -1F);
		this.llfinger1.setTextureSize(64, 32);
		this.llfinger1.mirror = true;
		this.setRotation(this.llfinger1, 0.0136322F, 0.0012186F, 1.635859F);
		this.llfinger2 = new ModelRenderer(this, 0, 26);
		this.llfinger2.addBox(0F, 0F, 0F, 2, 1, 1);
		this.llfinger2.setRotationPoint(-7.5F, 1F, 0.5F);
		this.llfinger2.setTextureSize(64, 32);
		this.llfinger2.mirror = true;
		this.setRotation(this.llfinger2, 0.0136322F, 0.0012186F, 0.669215F);
		this.llfinger3 = new ModelRenderer(this, 0, 26);
		this.llfinger3.addBox(0F, 0F, 0F, 2, 1, 1);
		this.llfinger3.setRotationPoint(-7.5F, 1F, 2F);
		this.llfinger3.setTextureSize(64, 32);
		this.llfinger3.mirror = true;
		this.setRotation(this.llfinger3, 0.0136322F, 0.0012186F, 0.669215F);
		this.thumb = new ModelRenderer(this, 0, 24);
		this.thumb.addBox(0F, 0F, 0F, 2, 1, 1);
		this.thumb.setRotationPoint(-4F, 0F, 0F);
		this.thumb.setTextureSize(64, 32);
		this.thumb.mirror = true;
		this.setRotation(this.thumb, -1.547869F, -0.6308178F, 2.714039F);
		this.thumb2 = new ModelRenderer(this, 0, 22);
		this.thumb2.addBox(0F, 0F, 0F, 2, 1, 1);
		this.thumb2.setRotationPoint(-5F, 1F, -1F);
		this.thumb2.setTextureSize(64, 32);
		this.thumb2.mirror = true;
		this.setRotation(this.thumb2, -1.585048F, -0.03596F, 2.714039F);
		this.eyeholder = new ModelRenderer(this, 0, 16);
		this.eyeholder.addBox(0F, 0F, 0F, 0, 1, 1);
		this.eyeholder.setRotationPoint(-2F, -3.5F, 1F);
		this.eyeholder.setTextureSize(64, 32);
		this.eyeholder.mirror = true;
		this.setRotation(this.eyeholder, 0F, 0F, 0F);
		this.eyeholder1 = new ModelRenderer(this, 0, 17);
		this.eyeholder1.addBox(0F, 0F, 0F, 1, 1, 0);
		this.eyeholder1.setRotationPoint(-4F, -3.5F, 3F);
		this.eyeholder1.setTextureSize(64, 32);
		this.eyeholder1.mirror = true;
		this.setRotation(this.eyeholder1, 0F, 0F, 0F);
		this.eyeholder2 = new ModelRenderer(this, 0, 17);
		this.eyeholder2.addBox(0F, 0F, 0F, 1, 1, 0);
		this.eyeholder2.setRotationPoint(-4F, -3.5F, 0F);
		this.eyeholder2.setTextureSize(64, 32);
		this.eyeholder2.mirror = true;
		this.setRotation(this.eyeholder2, 0F, 0F, 0F);
		this.eyeholder3 = new ModelRenderer(this, 0, 16);
		this.eyeholder3.addBox(0F, 0F, 0F, 0, 1, 1);
		this.eyeholder3.setRotationPoint(-5F, -3.5F, 1F);
		this.eyeholder3.setTextureSize(64, 32);
		this.eyeholder3.mirror = true;
		this.setRotation(this.eyeholder3, 0F, 0F, 0F);
		this.wrist2 = new ModelRenderer(this, 12, 0);
		this.wrist2.addBox(0F, 0F, 0F, 2, 1, 1);
		this.wrist2.setRotationPoint(-1F, -0.5F, -0.5F);
		this.wrist2.setTextureSize(64, 32);
		this.wrist2.mirror = true;
		this.setRotation(this.wrist2, 0F, 0F, 0F);
		this.wrist2 = new ModelRenderer(this, 18, 0);
		this.wrist2.addBox(0F, 0F, 0F, 2, 1, 2);
		this.wrist2.setRotationPoint(-1F, -1F, 0F);
		this.wrist2.setTextureSize(64, 32);
		this.wrist2.mirror = true;
		this.setRotation(this.wrist2, 0F, 0F, 0F);
		this.finger4 = new ModelRenderer(this, 0, 30);
		this.finger4.addBox(0F, 0F, 0F, 3, 1, 1);
		this.finger4.setRotationPoint(-5F, -1F, 3.5F);
		this.finger4.setTextureSize(64, 32);
		this.finger4.mirror = true;
		this.setRotation(this.finger4, 0.0136322F, 0.0012186F, 2.490967F);
		this.lfinger4 = new ModelRenderer(this, 0, 28);
		this.lfinger4.addBox(0F, 0F, 0F, 2, 1, 1);
		this.lfinger4.setRotationPoint(-7F, 0F, 3.5F);
		this.lfinger4.setTextureSize(64, 32);
		this.lfinger4.mirror = true;
		this.setRotation(this.lfinger4, 0.0136322F, 0.0012186F, 1.635859F);
		this.llfinger4 = new ModelRenderer(this, 0, 28);
		this.llfinger4.addBox(0F, 0F, 0F, 2, 1, 1);
		this.llfinger4.setRotationPoint(-7.5F, 1F, 3.5F);
		this.llfinger4.setTextureSize(64, 32);
		this.llfinger4.mirror = true;
		this.setRotation(this.llfinger4, 0.0136322F, 0.0012186F, 0.669215F);
		this.palm2 = new ModelRenderer(this, 0, 10);
		this.palm2.addBox(0F, 0F, 0F, 3, 2, 1);
		this.palm2.setRotationPoint(-5F, -1.5F, 3.5F);
		this.palm2.setTextureSize(64, 32);
		this.palm2.mirror = true;
		this.setRotation(this.palm2, 0F, 0F, 0F);
		// Add Children
		/*
		 * this.wrist.addChild(palm); this.wrist.addChild(finger1);
		 * this.wrist.addChild(finger2); this.wrist.addChild(finger3);
		 * this.wrist.addChild(lfinger1); this.wrist.addChild(lfinger2);
		 * this.wrist.addChild(lfinger3); this.wrist.addChild(eyebase);
		 * this.wrist.addChild(llfinger1); this.wrist.addChild(llfinger2);
		 * this.wrist.addChild(llfinger3); this.wrist.addChild(thumb);
		 * this.wrist.addChild(thumb2); this.wrist.addChild(eyeholder);
		 * this.wrist.addChild(eyeholder1); this.wrist.addChild(eyeholder2);
		 * this.wrist.addChild(eyeholder3); this.wrist.addChild(wrist2);
		 * this.wrist.addChild(wrist2); this.wrist.addChild(finger4);
		 * this.wrist.addChild(lfinger4); this.wrist.addChild(llfinger4);
		 * this.wrist.addChild(palm2);
		 */
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.wrist = new ModelRenderer(this, 0, 0);
		this.wrist.addBox(0F, 0F, 0F, 3, 1, 3);
		this.wrist.setRotationPoint(-1F, -0.5F, 0F);
		this.wrist.setTextureSize(64, 32);
		this.wrist.mirror = false;
		this.setRotation(this.wrist, 0F, 0F, 0F);
		this.palm = new ModelRenderer(this, 0, 3);
		this.palm.addBox(0F, 0F, 0F, 5, 2, 5);
		this.palm.setRotationPoint(-6F, -1.5F, -1F);
		this.palm.setTextureSize(64, 32);
		this.palm.mirror = false;
		this.setRotation(this.palm, 0F, 0F, 0F);
		this.finger1 = new ModelRenderer(this, 0, 30);
		this.finger1.addBox(0F, 0F, 0F, 3, 1, 1);
		this.finger1.setRotationPoint(-5F, -1F, 0.5F);
		this.finger1.setTextureSize(64, 32);
		this.finger1.mirror = false;
		this.setRotation(this.finger1, 0.0136322F, 0.0012186F, 2.490967F);
		this.finger2 = new ModelRenderer(this, 0, 30);
		this.finger2.addBox(0F, 0F, 0F, 3, 1, 1);
		this.finger2.setRotationPoint(-5F, -1F, 2F);
		this.finger2.setTextureSize(64, 32);
		this.finger2.mirror = false;
		this.setRotation(this.finger2, 0.0136322F, 0.0012186F, 2.490967F);
		this.finger3 = new ModelRenderer(this, 0, 30);
		this.finger3.addBox(0F, 0F, 0F, 3, 1, 1);
		this.finger3.setRotationPoint(-5F, -1F, -1F);
		this.finger3.setTextureSize(64, 32);
		this.finger3.mirror = false;
		this.setRotation(this.finger3, 0.0136322F, 0.0012186F, 2.490967F);
		this.lfinger1 = new ModelRenderer(this, 0, 28);
		this.lfinger1.addBox(0F, 0F, 0F, 2, 1, 1);
		this.lfinger1.setRotationPoint(-7.5F, 1F, -1F);
		this.lfinger1.setTextureSize(64, 32);
		this.lfinger1.mirror = false;
		this.setRotation(this.lfinger1, 0.0136322F, 0.0012186F, 0.669215F);
		this.lfinger2 = new ModelRenderer(this, 0, 28);
		this.lfinger2.addBox(0F, 0F, 0F, 2, 1, 1);
		this.lfinger2.setRotationPoint(-7F, 0F, 0.5F);
		this.lfinger2.setTextureSize(64, 32);
		this.lfinger2.mirror = false;
		this.setRotation(this.lfinger2, 0.0136322F, 0.0012186F, 1.635859F);
		this.lfinger3 = new ModelRenderer(this, 0, 28);
		this.lfinger3.addBox(0F, 0F, 0F, 2, 1, 1);
		this.lfinger3.setRotationPoint(-7F, 0F, 2F);
		this.lfinger3.setTextureSize(64, 32);
		this.lfinger3.mirror = false;
		this.setRotation(this.lfinger3, 0.0136322F, 0.0012186F, 1.635859F);
		this.eyebase = new ModelRenderer(this, 0, 18);
		this.eyebase.addBox(0F, 0F, 0F, 3, 1, 3);
		this.eyebase.setRotationPoint(-5F, -2.466667F, 0F);
		this.eyebase.setTextureSize(64, 32);
		this.eyebase.mirror = false;
		this.setRotation(this.eyebase, 0F, 0F, 0F);
		this.llfinger1 = new ModelRenderer(this, 0, 26);
		this.llfinger1.addBox(0F, 0F, 0F, 2, 1, 1);
		this.llfinger1.setRotationPoint(-7F, 0F, -1F);
		this.llfinger1.setTextureSize(64, 32);
		this.llfinger1.mirror = false;
		this.setRotation(this.llfinger1, 0.0136322F, 0.0012186F, 1.635859F);
		this.llfinger2 = new ModelRenderer(this, 0, 26);
		this.llfinger2.addBox(0F, 0F, 0F, 2, 1, 1);
		this.llfinger2.setRotationPoint(-7.5F, 1F, 0.5F);
		this.llfinger2.setTextureSize(64, 32);
		this.llfinger2.mirror = false;
		this.setRotation(this.llfinger2, 0.0136322F, 0.0012186F, 0.669215F);
		this.llfinger3 = new ModelRenderer(this, 0, 26);
		this.llfinger3.addBox(0F, 0F, 0F, 2, 1, 1);
		this.llfinger3.setRotationPoint(-7.5F, 1F, 2F);
		this.llfinger3.setTextureSize(64, 32);
		this.llfinger3.mirror = false;
		this.setRotation(this.llfinger3, 0.0136322F, 0.0012186F, 0.669215F);
		this.thumb = new ModelRenderer(this, 0, 24);
		this.thumb.addBox(0F, 0F, 0F, 2, 1, 1);
		this.thumb.setRotationPoint(-4F, 0F, 0F);
		this.thumb.setTextureSize(64, 32);
		this.thumb.mirror = false;
		this.setRotation(this.thumb, -1.547869F, -0.6308178F, 2.714039F);
		this.thumb2 = new ModelRenderer(this, 0, 22);
		this.thumb2.addBox(0F, 0F, 0F, 2, 1, 1);
		this.thumb2.setRotationPoint(-5F, 1F, -1F);
		this.thumb2.setTextureSize(64, 32);
		this.thumb2.mirror = false;
		this.setRotation(this.thumb2, -1.585048F, -0.03596F, 2.714039F);
		this.eyeholder = new ModelRenderer(this, 0, 16);
		this.eyeholder.addBox(0F, 0F, 0F, 0, 1, 1);
		this.eyeholder.setRotationPoint(-2F, -3.5F, 1F);
		this.eyeholder.setTextureSize(64, 32);
		this.eyeholder.mirror = false;
		this.setRotation(this.eyeholder, 0F, 0F, 0F);
		this.eyeholder1 = new ModelRenderer(this, 0, 17);
		this.eyeholder1.addBox(0F, 0F, 0F, 1, 1, 0);
		this.eyeholder1.setRotationPoint(-4F, -3.5F, 3F);
		this.eyeholder1.setTextureSize(64, 32);
		this.eyeholder1.mirror = false;
		this.setRotation(this.eyeholder1, 0F, 0F, 0F);
		this.eyeholder2 = new ModelRenderer(this, 0, 17);
		this.eyeholder2.addBox(0F, 0F, 0F, 1, 1, 0);
		this.eyeholder2.setRotationPoint(-4F, -3.5F, 0F);
		this.eyeholder2.setTextureSize(64, 32);
		this.eyeholder2.mirror = false;
		this.setRotation(this.eyeholder2, 0F, 0F, 0F);
		this.eyeholder3 = new ModelRenderer(this, 0, 16);
		this.eyeholder3.addBox(0F, 0F, 0F, 0, 1, 1);
		this.eyeholder3.setRotationPoint(-5F, -3.5F, 1F);
		this.eyeholder3.setTextureSize(64, 32);
		this.eyeholder3.mirror = false;
		this.setRotation(this.eyeholder3, 0F, 0F, 0F);
		this.wrist2 = new ModelRenderer(this, 12, 0);
		this.wrist2.addBox(0F, 0F, 0F, 2, 1, 1);
		this.wrist2.setRotationPoint(-1F, -0.5F, -0.5F);
		this.wrist2.setTextureSize(64, 32);
		this.wrist2.mirror = false;
		this.setRotation(this.wrist2, 0F, 0F, 0F);
		this.wrist2 = new ModelRenderer(this, 18, 0);
		this.wrist2.addBox(0F, 0F, 0F, 2, 1, 2);
		this.wrist2.setRotationPoint(-1F, -1F, 0F);
		this.wrist2.setTextureSize(64, 32);
		this.wrist2.mirror = false;
		this.setRotation(this.wrist2, 0F, 0F, 0F);
		this.finger4 = new ModelRenderer(this, 0, 30);
		this.finger4.addBox(0F, 0F, 0F, 3, 1, 1);
		this.finger4.setRotationPoint(-5F, -1F, 3.5F);
		this.finger4.setTextureSize(64, 32);
		this.finger4.mirror = false;
		this.setRotation(this.finger4, 0.0136322F, 0.0012186F, 2.490967F);
		this.lfinger4 = new ModelRenderer(this, 0, 28);
		this.lfinger4.addBox(0F, 0F, 0F, 2, 1, 1);
		this.lfinger4.setRotationPoint(-7F, 0F, 3.5F);
		this.lfinger4.setTextureSize(64, 32);
		this.lfinger4.mirror = false;
		this.setRotation(this.lfinger4, 0.0136322F, 0.0012186F, 1.635859F);
		this.llfinger4 = new ModelRenderer(this, 0, 28);
		this.llfinger4.addBox(0F, 0F, 0F, 2, 1, 1);
		this.llfinger4.setRotationPoint(-7.5F, 1F, 3.5F);
		this.llfinger4.setTextureSize(64, 32);
		this.llfinger4.mirror = false;
		this.setRotation(this.llfinger4, 0.0136322F, 0.0012186F, 0.669215F);
		this.palm2 = new ModelRenderer(this, 0, 10);
		this.palm2.addBox(0F, 0F, 0F, 3, 2, 1);
		this.palm2.setRotationPoint(-5F, -1.5F, 3.5F);
		this.palm2.setTextureSize(64, 32);
		this.palm2.mirror = false;
		this.setRotation(this.palm2, 0F, 0F, 0F);
		// Add Children
		this.wrist.addChild(this.palm);
		this.wrist.addChild(this.finger1);
		this.wrist.addChild(this.finger2);
		this.wrist.addChild(this.finger3);
		this.wrist.addChild(this.lfinger1);
		this.wrist.addChild(this.lfinger2);
		this.wrist.addChild(this.lfinger3);
		this.wrist.addChild(this.eyebase);
		this.wrist.addChild(this.llfinger1);
		this.wrist.addChild(this.llfinger2);
		this.wrist.addChild(this.llfinger3);
		this.wrist.addChild(this.thumb);
		this.wrist.addChild(this.thumb2);
		this.wrist.addChild(this.eyeholder);
		this.wrist.addChild(this.eyeholder1);
		this.wrist.addChild(this.eyeholder2);
		this.wrist.addChild(this.eyeholder3);
		this.wrist.addChild(this.wrist2);
		this.wrist.addChild(this.wrist2);
		this.wrist.addChild(this.finger4);
		this.wrist.addChild(this.lfinger4);
		this.wrist.addChild(this.llfinger4);
		this.wrist.addChild(this.palm2);
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
