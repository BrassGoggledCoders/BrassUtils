/**
 * This class was created by <Surseance> as a part of the
 * EnderGloves mod for Minecraft. 
 *
 * This mod is registered under the WTFPL v2.0. Please read the
 * COPYING.WTFPL file for more details.
 *
 * File created @[May 25, 2014, 3:05:32 PM] 
 */
package enderglove.common.entity;

import net.minecraft.block.Block;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Surseance (Johnny Eatmon) Email: surseance@autistici.org
 * 
 */
public class EntityMinedBlock extends Entity
{
	public Block block;
	public int metadata;
	public NBTTagCompound tagCompound;

	public static float scale = 0.9F;

	public EntityMinedBlock(final World world)
	{
		super(world);
	}

	public EntityMinedBlock(final World world, final double posX,
			final double posY, final double posZ, final Block block)
	{
		this(world, posX, posY, posZ, block, 0);
	}

	public EntityMinedBlock(final World world, final double posX,
			final double posY, final double posZ, final Block block,
			final int md)
	{
		super(world);
		this.block = block;
		metadata = md;
		// this.preventEntitySpawning = true;
		// this.setSize(0.98F, 0.98F);
		yOffset = height / 2.0F;
		setPosition(posX, posY, posZ);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	protected void entityInit()
	{
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !isDead;
	}

	@Override
	public void onUpdate()
	{
		if ((worldObj.getWorldTime() % 1) == 0)
		{
			scale -= 0.0625F;
		}

		if (scale <= 0)
		{
			scale = 0.9F;
			setDead();
		}
	}

	@Override
	protected void writeEntityToNBT(final NBTTagCompound tagCompound)
	{
		tagCompound.setByte("Tile", (byte) Block.getIdFromBlock(block));
		tagCompound.setInteger("TileID", Block.getIdFromBlock(block));
		tagCompound.setByte("Data", (byte) metadata);

		if (this.tagCompound != null)
		{
			tagCompound.setTag("TileEntityData", this.tagCompound);
		}
	}

	@Override
	protected void readEntityFromNBT(final NBTTagCompound tagCompound)
	{
		if (tagCompound.hasKey("TileID", 99))
		{
			block = Block.getBlockById(tagCompound.getInteger("TileID"));
		}
		else
		{
			block = Block.getBlockById(tagCompound.getByte("Tile") & 255);
		}

		metadata = tagCompound.getByte("Data") & 255;

		if (tagCompound.hasKey("TileEntityData", 10))
		{
			this.tagCompound = tagCompound.getCompoundTag("TileEntityData");
		}
	}

	@Override
	public void addEntityCrashInfo(final CrashReportCategory crc)
	{
		super.addEntityCrashInfo(crc);
		crc.addCrashSection("Immitating block ID",
				Integer.valueOf(Block.getIdFromBlock(block)));
		crc.addCrashSection("Immitating block data", Integer.valueOf(metadata));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getShadowSize()
	{
		return 0.0F;
	}

	@SideOnly(Side.CLIENT)
	public World getWorldObj()
	{
		return worldObj;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean canRenderOnFire()
	{
		return false;
	}

	public Block getBlock()
	{
		return block;
	}
}
