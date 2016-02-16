
package xyz.brassgoggledcoders.brassutils.api;

import net.minecraft.block.Block;

/**
 * The Interface IChiselable.
 *
 * @author warlordjones
 */
public interface IEngravable
{

	/**
	 *
	 * @return the block created when our chisel is used on this block
	 */
	public Block getChiseledVariant();

	/**
	 * @return the metadata of the block created when our chisel is used on this
	 *         block
	 */
	public int getChiseledVariantMeta();
}
