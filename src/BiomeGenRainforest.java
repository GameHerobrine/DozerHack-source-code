package net.minecraft.src;

import java.util.Random;

public class BiomeGenRainforest extends BiomeGenBase {
    protected BiomeGenRainforest(int var1) {
		super(var1);
 	}

	public WorldGenerator getRandomWorldGenForTrees(Random var1) {
        return (WorldGenerator)(var1.nextInt(3) == 0 ? new WorldGenBigTree() : new WorldGenTrees());
    }
}
