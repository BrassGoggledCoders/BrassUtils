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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Surseance (Johnny Eatmon)
 * Email: surseance@autistici.org
 *
 */
public class EntityMinedBlock extends Entity
{
	public Block block;
	public int metadata;

	public float scale;

	public EntityMinedBlock(World world)
	{
		super(world);
		this.preventEntitySpawning = true;
		this.renderDistanceWeight = 20.0D;
		this.scale = 0.9F;
	}

<<<<<<< HEAD
	//public EntityMinedBlock(World world, double x, double y, double z, Block block)
	//{
	//	this(world, x, y, z, block, 0);
	//}
=======
	public EntityMinedBlock(World world, double posX, double posY, double posZ, Block block, float scale)
	{
		this(world, posX, posY, posZ, block, 0, scale);
		EntityMinedBlock.scale = scale;
	}
>>>>>>> FETCH_HEAD

	public EntityMinedBlock(World world, double x, double y, double z, Block block, int md)
	{
		super(world);
		this.block = block;
		this.metadata = md;
		this.preventEntitySpawning = true;
		// this.setSize(0.98F, 0.98F);
		this.yOffset = this.height / 2.0F; 
		this.setPosition(x, y, z);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
<<<<<<< HEAD
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.scale = 0.9F;
=======
		this.prevPosX = posX;
		this.prevPosY = posY;
		this.prevPosZ = posZ;
		EntityMinedBlock.scale = scale;
>>>>>>> FETCH_HEAD
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	protected void entityInit() {} 

	@Override
	public boolean canBeCollidedWith()
	{
		return false;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.getBlock() != null)
		{
			if ((this.worldObj.getWorldTime() % 1) == 0)
				this.scale -= 0.0625F;

			if (this.scale <= 0.0F)
				this.setDead();
		}
<<<<<<< HEAD
	}

	@Override
	public AxisAlignedBB getBoundingBox()
	{
		return null;
=======

		//this.scale = 0.9F;
>>>>>>> FETCH_HEAD
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		tagCompound.setByte("Tile", (byte) Block.getIdFromBlock(this.block));
		tagCompound.setInteger("TileID", Block.getIdFromBlock(this.block));
		tagCompound.setByte("Data", (byte) this.metadata);
<<<<<<< HEAD
=======
		tagCompound.setFloat("Scale", EntityMinedBlock.scale);

		if (this.tagCompound != null)
			tagCompound.setTag("TileEntityData", this.tagCompound);
>>>>>>> FETCH_HEAD
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		if (tagCompound.hasKey("TileID", 99))
			this.block = Block.getBlockById(tagCompound.getInteger("TileID"));
		else
			this.block = Block.getBlockById(tagCompound.getByte("Tile") & 255);

		this.metadata = tagCompound.getByte("Data") & 255;
<<<<<<< HEAD
=======

		if (tagCompound.hasKey("TileEntityData", 10))
			this.tagCompound = tagCompound.getCompoundTag("TileEntityData");

		EntityMinedBlock.scale = tagCompound.getFloat("Scale");
	}

	@Override
	public void addEntityCrashInfo(CrashReportCategory crc)
	{
		super.addEntityCrashInfo(crc);
		crc.addCrashSection("Imitating block ID",
				Integer.valueOf(Block.getIdFromBlock(this.block)));
		crc.addCrashSection("Imitating block data", Integer.valueOf(this.metadata));
>>>>>>> FETCH_HEAD
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
		return this.worldObj;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean canRenderOnFire()
	{
		return false;
	}

	public Block getBlock()
	{
		return this.block;
	}
}
