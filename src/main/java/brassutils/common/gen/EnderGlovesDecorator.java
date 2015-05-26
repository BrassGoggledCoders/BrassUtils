/**
 * This class was created by BrassGoggledCoders modding team.
 * This class is available as part of the EnderGloves Mod for Minecraft.
 *
 * EnderGloves is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 */
package brassutils.common.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * @author Surseance
 *
 */
@Deprecated
public class EnderGlovesDecorator extends BiomeDecorator
{
	public WorldGenerator totemGen;

	public EnderGlovesDecorator(BiomeGenBase par1BiomeGenBase)
	{
		super();
		this.totemGen = new WorldGenTotem();
	};

	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		if(this.currentWorld != null)
		{
			throw new RuntimeException("Already decorating!!");
		}
		else
		{
			this.currentWorld = par1World;
			this.randomGenerator = par2Random;
			this.chunk_X = par3;
			this.chunk_Z = par4;
			super.decorateChunk(par1World, par2Random, null, par4, par4);
			this.decorate();
			this.currentWorld = null;
			this.randomGenerator = null;
		}
	}

	public void decorate()
	{
		int j, k, l, i1;
		for(j = 0; j < 100; ++j)
		{
			k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			i1 = this.randomGenerator.nextInt(128);
			this.totemGen.generate(this.currentWorld, this.randomGenerator, k, i1, l);
		}
		for(j = 0; j < 100; ++j)
		{
			k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			l = this.randomGenerator.nextInt(128);
			i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			this.totemGen.generate(this.currentWorld, this.randomGenerator, k, l, i1);
		}
	};
}
