
package brassutils.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import xyz.brassgoggledcoders.boilerplate.lib.common.blocks.BaseBlock;

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
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
	{
		entityIn.fallDistance = 0;
	}

	@Override
	public Vec3 modifyAcceleration(World worldIn, BlockPos pos, Entity entityIn, Vec3 motion)
	{
		return motion.addVector(entityIn.motionX - 10, 0, entityIn.motionZ - 10);
	}
}
