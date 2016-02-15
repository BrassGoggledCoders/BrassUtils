
package brassutils.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import brassutils.common.BrassUtils;
import brassutils.common.InitMaterials;
import xyz.brassgoggledcoders.boilerplate.lib.common.items.BaseArmor;

/**
 * @author Decebaldecebal
 *
 */
public class ItemObsidianArmor extends BaseArmor
{
	public ItemObsidianArmor(int armorType)
	{
		super(InitMaterials.ARMOR_OBSIDIAN, armorType, "obsidian");
		this.setCreativeTab(BrassUtils.tabBU);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack is)
	{
		// Slowness
		player.motionX *= 0.4;
		player.motionZ *= 0.4;
		// Fire resist
		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20, 5));
		player.extinguish();
		// Sinking
		if (player.isInWater())
			player.motionY--;
	}

}
