/**
 * This class was created by <Surseance> as a part of the EnderGlove mod for
 * Minecraft.
 *
 * This mod is registered under the WTFPL v2.0. Please read the COPYING.WTFPL
 * file for more details.
 *
 * File created @[May 34, 2034, 8:30:36 PM]
 */
package enderglove.common.config;

import java.io.File;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import enderglove.common.lib.enchantment.EnchantmentAffluency;
import enderglove.common.lib.enchantment.EnchantmentArtisan;
import enderglove.common.lib.enchantment.EnchantmentCreative;
import enderglove.common.lib.enchantment.EnchantmentCrystals;
import enderglove.common.lib.enchantment.EnchantmentEnderField;
import enderglove.common.lib.enchantment.EnchantmentFlameTouch;
import enderglove.common.lib.enchantment.EnchantmentMagnetism;
import enderglove.common.lib.enchantment.EnchantmentSpelunker;
import enderglove.common.lib.enchantment.EnchantmentTeleport;

/**
 * @author Surseance (Johnny Eatmon)
 * Email: surseance@autistici.org
 *
 */
public class Config
{
	public static Configuration config;
	public static final String CATEGORY_ENCH = "Enchantments";
	public static final String CATEGORY_ENTITIES = "Entities";
	public static int totemsPerChunk = 2;
	public static int artisanBonusChance = 3;
	public static boolean loadCustomSounds = false;

	public static Enchantment enchAffluency = null;
	public static Enchantment enchArtisan = null;
	public static Enchantment enchSpelunker = null;
	public static Enchantment enchTeleport = null;
	public static Enchantment enchCreative = null;
	public static Enchantment enchFlameTouch = null;
	public static Enchantment enchEnderField = null;
	public static Enchantment enchMagnetism = null;
	public static Enchantment enchCrystals = null;

	public static int enchAffluencyId;
	public static int enchArtisanId;
	public static int enchSpelunkerId;
	public static int enchTeleportId;
	public static int enchCreativeId;
	public static int enchFlameTouchId;
	public static int enchEFieldId;
	public static int enchMagnetismId;
	public static int enchCrystalsId;

	public static int entMinedBlockId;

	public static String line1, line2, line3;
	public static boolean dragonDrop;

	public static void initialize(File file)
	{
		config = new Configuration(file);
		config.addCustomCategoryComment("Enchantments", "Custom enchantments");
		config.addCustomCategoryComment("Entities", "Entity IDs");
		config.load();

		Property tpc = config.get("general", "totems_per_chunk", totemsPerChunk);
		tpc.comment = "The rarity of the Ender Totems. Setting it to 0 will remove Ender Totem generation.";
		totemsPerChunk = tpc.getInt();

		Property atc = config.get("general", "artisan_bonus_chance", artisanBonusChance);
		atc.comment = "The chance of getting a returned ingredient. Increase for more rarity.";
		artisanBonusChance = atc.getInt();

		int enchIndex = 63; // Luck of the Sea is 62

		Property enchAff = config.get("Enchantments", "ench_affluency", enchIndex++);
		enchAffluency = new EnchantmentAffluency(enchAff.getInt(), 3);
		enchAffluencyId = enchAff.getInt();
		Enchantment.addToBookList(enchAffluency);

		Property enchArt = config.get("Enchantments", "ench_artisan", enchIndex++);
		enchArtisan = new EnchantmentArtisan(enchArt.getInt(), 2);
		enchArtisanId = enchArt.getInt();
		Enchantment.addToBookList(enchArtisan);

		Property enchSpe = config.get("Enchantments", "ench_spelunker", enchIndex++);
		enchSpelunker = new EnchantmentSpelunker(enchSpe.getInt(), 2);
		enchSpelunkerId = enchSpe.getInt();
		Enchantment.addToBookList(enchSpelunker);

		Property enchTel = config.get("Enchantments", "ench_teleport", enchIndex++);
		enchTeleport = new EnchantmentTeleport(enchTel.getInt(), 4);
		enchTeleportId = enchTel.getInt();
		Enchantment.addToBookList(enchTeleport);

		Property enchOP = config.get("Enchantments", "ench_creative", enchIndex++);
		enchCreative = new EnchantmentCreative(enchOP.getInt(), 0);
		enchCreativeId = enchOP.getInt();
		Enchantment.addToBookList(enchCreative);

		Property enchFla = config.get("Enchantments", "ench_flametouch", enchIndex++);
		enchFlameTouch = new EnchantmentFlameTouch(enchFla.getInt(), 3);
		enchFlameTouchId = enchFla.getInt();
		Enchantment.addToBookList(enchFlameTouch);

		Property enchEField = config.get("Enchantments", "ench_enderfield", enchIndex++);
		enchEnderField = new EnchantmentEnderField(enchEField.getInt(), 2);
		enchEFieldId = enchEField.getInt();
		Enchantment.addToBookList(enchEnderField);

		Property enchMagnet = config.get("Enchantments", "ench_magnetism", enchIndex++);
		enchMagnetism = new EnchantmentMagnetism(enchMagnet.getInt(), 2);
		enchMagnetismId = enchMagnet.getInt();
		Enchantment.addToBookList(enchMagnetism);

		Property enchCrystal = config.get("Enchantments", "ench_crystals", enchIndex++);
		enchCrystals = new EnchantmentCrystals(enchCrystal.getInt(), 2);
		enchCrystalsId = enchCrystal.getInt();
		Enchantment.addToBookList(enchCrystals);

		int eIdx = 201; // The EntityEnderCrystal is Id = 200

		entMinedBlockId = config.get("Entities", "minedblock", eIdx++).getInt();

		dragonDrop = config.get("Options", "EnderGlove will drop from Dragon", true).getBoolean(true);
		/*
		Property rline1 = config.get("Recipe", "line_1", "EEE");
		line1 = rline1.toString();
		Property rline2 = config.get("Recipe", "line_2", "LNL");
		line2 = rline2.toString();
		Property rline3 = config.get("Recipe", "line_3", "LNL");
		line3 = rline3.toString();
		//Sorry about line wrap...
        config.addCustomCategoryComment("Recipe", "Allows customisation of the recipe. Line one is the top line of the craftin recipe, left to right. Case Sensetive. Possible values: P = Ender Pearl, E = Eye of Ender, N = Nether Star, L = Leather, B = Blaze Rod, D = Dragon Egg, S = Endstone, d = Dimamond block, b = Obsidian");
		 */
		config.save();
	}

	public static void save()
	{
		config.save();
	}
}
