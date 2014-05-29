package enderglove.common.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import enderglove.common.config.ConfigBlocks;
import enderglove.common.config.ConfigItems;
import enderglove.common.lib.LibInfo;

public class BlockTotemTop extends BlockEnderTotem
{
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir)
	{
		//TODO: Custom Texture
		blockIcon = ir.registerIcon(LibInfo.PREFIX + "endertotem");
	}

	public BlockTotemTop()
	{
		this.setHardness(3.5F);
		this.setResistance(6.0F);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int md, float hitX, float hitY, float hitZ)
	{
		//this.renderDragonFX();
		player.addExperience(100);
		player.inventory.addItemStackToInventory(new ItemStack(ConfigItems.itemEnderGlove));
		world.setBlock(x, y, z, ConfigBlocks.blockEnderTotem);
		return true;
	}
	/*
	private void renderDragonFX()
	{
		Tessellator tessellator = Tessellator.instance;
		 float f1 = 10 / 200.0F;
		 float f2 = 0.0F;
		 Random random = new Random(432L);
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, -1.0F, -2.0F);

         for (int i = 0; (float)i < (f1 + f1 * f1) / 2.0F * 60.0F; ++i)
         {
             GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
             GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
             GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
             GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
             GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
             GL11.glRotatef(random.nextFloat() * 360.0F + f1 * 90.0F, 0.0F, 0.0F, 1.0F);
             tessellator.startDrawing(6);
             float f3 = random.nextFloat() * 20.0F + 5.0F + f2 * 10.0F;
             float f4 = random.nextFloat() * 2.0F + 1.0F + f2 * 2.0F;
             tessellator.setColorRGBA_I(16777215, (int)(255.0F * (1.0F - f2)));
             tessellator.addVertex(0.0D, 0.0D, 0.0D);
             tessellator.setColorRGBA_I(16711935, 0);
             tessellator.addVertex(-0.866D * (double)f4, (double)f3, (double)(-0.5F * f4));
             tessellator.addVertex(0.866D * (double)f4, (double)f3, (double)(-0.5F * f4));
             tessellator.addVertex(0.0D, (double)f3, (double)(1.0F * f4));
             tessellator.addVertex(-0.866D * (double)f4, (double)f3, (double)(-0.5F * f4));
             tessellator.draw();
         }*/
}
