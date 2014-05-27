/**
 * This class was created by <Surseance> as a part of the
 * EnderGlove mod for Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 15, 2014, 4:06:42 PM]
 */
package enderglove.client.renderers.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Surseance (Johnny Eatmon) <jmaeatmon@gmail.com>
 *
 */
@SideOnly(Side.CLIENT)
public class ModelEnderGlove extends ModelBase
{
	 //fields
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
    textureWidth = 64;
    textureHeight = 32;

      wrist = new ModelRenderer(this, 0, 0);
      wrist.addBox(0F, 0F, 0F, 3, 1, 3);
      wrist.setRotationPoint(-1F, -0.5F, 0F);
      wrist.setTextureSize(64, 32);
      wrist.mirror = true;
      setRotation(wrist, 0F, 0F, 0F);
      palm = new ModelRenderer(this, 0, 3);
      palm.addBox(0F, 0F, 0F, 5, 2, 5);
      palm.setRotationPoint(-6F, -1.5F, -1F);
      palm.setTextureSize(64, 32);
      palm.mirror = true;
      setRotation(palm, 0F, 0F, 0F);
      finger1 = new ModelRenderer(this, 0, 30);
      finger1.addBox(0F, 0F, 0F, 3, 1, 1);
      finger1.setRotationPoint(-5F, -1F, 0.5F);
      finger1.setTextureSize(64, 32);
      finger1.mirror = true;
      setRotation(finger1, 0.0136322F, 0.0012186F, 2.490967F);
      finger2 = new ModelRenderer(this, 0, 30);
      finger2.addBox(0F, 0F, 0F, 3, 1, 1);
      finger2.setRotationPoint(-5F, -1F, 2F);
      finger2.setTextureSize(64, 32);
      finger2.mirror = true;
      setRotation(finger2, 0.0136322F, 0.0012186F, 2.490967F);
      finger3 = new ModelRenderer(this, 0, 30);
      finger3.addBox(0F, 0F, 0F, 3, 1, 1);
      finger3.setRotationPoint(-5F, -1F, -1F);
      finger3.setTextureSize(64, 32);
      finger3.mirror = true;
      setRotation(finger3, 0.0136322F, 0.0012186F, 2.490967F);
      lfinger1 = new ModelRenderer(this, 0, 28);
      lfinger1.addBox(0F, 0F, 0F, 2, 1, 1);
      lfinger1.setRotationPoint(-7.5F, 1F, -1F);
      lfinger1.setTextureSize(64, 32);
      lfinger1.mirror = true;
      setRotation(lfinger1, 0.0136322F, 0.0012186F, 0.669215F);
      lfinger2 = new ModelRenderer(this, 0, 28);
      lfinger2.addBox(0F, 0F, 0F, 2, 1, 1);
      lfinger2.setRotationPoint(-7F, 0F, 0.5F);
      lfinger2.setTextureSize(64, 32);
      lfinger2.mirror = true;
      setRotation(lfinger2, 0.0136322F, 0.0012186F, 1.635859F);
      lfinger3 = new ModelRenderer(this, 0, 28);
      lfinger3.addBox(0F, 0F, 0F, 2, 1, 1);
      lfinger3.setRotationPoint(-7F, 0F, 2F);
      lfinger3.setTextureSize(64, 32);
      lfinger3.mirror = true;
      setRotation(lfinger3, 0.0136322F, 0.0012186F, 1.635859F);
      eyebase = new ModelRenderer(this, 0, 18);
      eyebase.addBox(0F, 0F, 0F, 3, 1, 3);
      eyebase.setRotationPoint(-5F, -2.466667F, 0F);
      eyebase.setTextureSize(64, 32);
      eyebase.mirror = true;
      setRotation(eyebase, 0F, 0F, 0F);
      llfinger1 = new ModelRenderer(this, 0, 26);
      llfinger1.addBox(0F, 0F, 0F, 2, 1, 1);
      llfinger1.setRotationPoint(-7F, 0F, -1F);
      llfinger1.setTextureSize(64, 32);
      llfinger1.mirror = true;
      setRotation(llfinger1, 0.0136322F, 0.0012186F, 1.635859F);
      llfinger2 = new ModelRenderer(this, 0, 26);
      llfinger2.addBox(0F, 0F, 0F, 2, 1, 1);
      llfinger2.setRotationPoint(-7.5F, 1F, 0.5F);
      llfinger2.setTextureSize(64, 32);
      llfinger2.mirror = true;
      setRotation(llfinger2, 0.0136322F, 0.0012186F, 0.669215F);
      llfinger3 = new ModelRenderer(this, 0, 26);
      llfinger3.addBox(0F, 0F, 0F, 2, 1, 1);
      llfinger3.setRotationPoint(-7.5F, 1F, 2F);
      llfinger3.setTextureSize(64, 32);
      llfinger3.mirror = true;
      setRotation(llfinger3, 0.0136322F, 0.0012186F, 0.669215F);
      thumb = new ModelRenderer(this, 0, 24);
      thumb.addBox(0F, 0F, 0F, 2, 1, 1);
      thumb.setRotationPoint(-4F, 0F, 0F);
      thumb.setTextureSize(64, 32);
      thumb.mirror = true;
      setRotation(thumb, -1.547869F, -0.6308178F, 2.714039F);
      thumb2 = new ModelRenderer(this, 0, 22);
      thumb2.addBox(0F, 0F, 0F, 2, 1, 1);
      thumb2.setRotationPoint(-5F, 1F, -1F);
      thumb2.setTextureSize(64, 32);
      thumb2.mirror = true;
      setRotation(thumb2, -1.585048F, -0.03596F, 2.714039F);
      eyeholder = new ModelRenderer(this, 0, 16);
      eyeholder.addBox(0F, 0F, 0F, 0, 1, 1);
      eyeholder.setRotationPoint(-2F, -3.5F, 1F);
      eyeholder.setTextureSize(64, 32);
      eyeholder.mirror = true;
      setRotation(eyeholder, 0F, 0F, 0F);
      eyeholder1 = new ModelRenderer(this, 0, 17);
      eyeholder1.addBox(0F, 0F, 0F, 1, 1, 0);
      eyeholder1.setRotationPoint(-4F, -3.5F, 3F);
      eyeholder1.setTextureSize(64, 32);
      eyeholder1.mirror = true;
      setRotation(eyeholder1, 0F, 0F, 0F);
      eyeholder2 = new ModelRenderer(this, 0, 17);
      eyeholder2.addBox(0F, 0F, 0F, 1, 1, 0);
      eyeholder2.setRotationPoint(-4F, -3.5F, 0F);
      eyeholder2.setTextureSize(64, 32);
      eyeholder2.mirror = true;
      setRotation(eyeholder2, 0F, 0F, 0F);
      eyeholder3 = new ModelRenderer(this, 0, 16);
      eyeholder3.addBox(0F, 0F, 0F, 0, 1, 1);
      eyeholder3.setRotationPoint(-5F, -3.5F, 1F);
      eyeholder3.setTextureSize(64, 32);
      eyeholder3.mirror = true;
      setRotation(eyeholder3, 0F, 0F, 0F);
      wrist2 = new ModelRenderer(this, 12, 0);
      wrist2.addBox(0F, 0F, 0F, 2, 1, 1);
      wrist2.setRotationPoint(-1F, -0.5F, -0.5F);
      wrist2.setTextureSize(64, 32);
      wrist2.mirror = true;
      setRotation(wrist2, 0F, 0F, 0F);
      wrist2 = new ModelRenderer(this, 18, 0);
      wrist2.addBox(0F, 0F, 0F, 2, 1, 2);
      wrist2.setRotationPoint(-1F, -1F, 0F);
      wrist2.setTextureSize(64, 32);
      wrist2.mirror = true;
      setRotation(wrist2, 0F, 0F, 0F);
      finger4 = new ModelRenderer(this, 0, 30);
      finger4.addBox(0F, 0F, 0F, 3, 1, 1);
      finger4.setRotationPoint(-5F, -1F, 3.5F);
      finger4.setTextureSize(64, 32);
      finger4.mirror = true;
      setRotation(finger4, 0.0136322F, 0.0012186F, 2.490967F);
      lfinger4 = new ModelRenderer(this, 0, 28);
      lfinger4.addBox(0F, 0F, 0F, 2, 1, 1);
      lfinger4.setRotationPoint(-7F, 0F, 3.5F);
      lfinger4.setTextureSize(64, 32);
      lfinger4.mirror = true;
      setRotation(lfinger4, 0.0136322F, 0.0012186F, 1.635859F);
      llfinger4 = new ModelRenderer(this, 0, 28);
      llfinger4.addBox(0F, 0F, 0F, 2, 1, 1);
      llfinger4.setRotationPoint(-7.5F, 1F, 3.5F);
      llfinger4.setTextureSize(64, 32);
      llfinger4.mirror = true;
      setRotation(llfinger4, 0.0136322F, 0.0012186F, 0.669215F);
      palm2 = new ModelRenderer(this, 0, 10);
      palm2.addBox(0F, 0F, 0F, 3, 2, 1);
      palm2.setRotationPoint(-5F, -1.5F, 3.5F);
      palm2.setTextureSize(64, 32);
      palm2.mirror = true;
      setRotation(palm2, 0F, 0F, 0F);
      //Add Children
      this.wrist.addChild(palm);
      this.wrist.addChild(finger1);
      this.wrist.addChild(finger2);
      this.wrist.addChild(finger3);
      this.wrist.addChild(lfinger1);
      this.wrist.addChild(lfinger2);
      this.wrist.addChild(lfinger3);
      this.wrist.addChild(eyebase);
      this.wrist.addChild(llfinger1);
      this.wrist.addChild(llfinger2);
      this.wrist.addChild(llfinger3);
      this.wrist.addChild(thumb);
      this.wrist.addChild(thumb2);
      this.wrist.addChild(eyeholder);
      this.wrist.addChild(eyeholder1);
      this.wrist.addChild(eyeholder2);
      this.wrist.addChild(eyeholder3);
      this.wrist.addChild(wrist2);
      this.wrist.addChild(wrist2);
      this.wrist.addChild(finger4);
      this.wrist.addChild(lfinger4);
      this.wrist.addChild(llfinger4);
      this.wrist.addChild(palm2);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    wrist.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
   super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }


}
