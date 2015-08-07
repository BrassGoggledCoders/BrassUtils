/**
 * This class was created by <MrArcane111> or his SC2 development team.
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 * Steamcraft 2 is based on the original Steamcraft created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 *
 * Some code is derived from PowerCraft created by MightyPork which is registered
 * under the MMPL v1.0.
 * PowerCraft (c) MightyPork 2012
 *
 * File created @ [6 Apr 2014, 20:34:16]
 */
package brassutils.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * @author warlordjones
 *
 *         6 Apr 201420:34:16
 */
public class BlockFeathers extends BaseBlock
{

	/**
	 * @param par1
	 * @param par2Material
	 */
	public BlockFeathers(Material par2Material)
	{
		super(par2Material);
		this.setBlockName("featherBlock");
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setResistance(0);
		this.setHardness(0.4F);
	}

	@Override
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		par5Entity.fallDistance = 0;
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		par1World.spawnParticle("snowballpoof", par2, par3, par4, 0, 0, 0);
	}

	@Override
	public void velocityToAddToEntity(World par1World, int par2, int par3, int par4, Entity par5Entity, Vec3 par6Vec3)
	{
		par6Vec3.xCoord = par5Entity.motionX - 10;
		par6Vec3.zCoord = par5Entity.motionZ - 10;
	}
}
