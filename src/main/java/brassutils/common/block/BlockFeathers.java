
package brassutils.common.block;

import net.minecraft.block.material.Material;
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
		this.setResistance(0);
		this.setHardness(0.4F);
	}

	@Override
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6)
	{
		par5Entity.fallDistance = 0;
	}

	@Override
	public void velocityToAddToEntity(World par1World, int par2, int par3, int par4, Entity par5Entity, Vec3 par6Vec3)
	{
		par6Vec3.xCoord = par5Entity.motionX - 10;
		par6Vec3.zCoord = par5Entity.motionZ - 10;
	}
}
