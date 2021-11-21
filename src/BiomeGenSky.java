package net.minecraft.src;

public class BiomeGenSky extends BiomeGenBase {
    public BiomeGenSky(int var1) {
    	super(var1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10));
    }

    public int getSkyColorByTemp(float var1) {
        return 12632319;
    }
}
