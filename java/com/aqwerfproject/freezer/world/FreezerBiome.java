package com.aqwerfproject.freezer.world;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

public class FreezerBiome extends Biome {

	protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();

	public FreezerBiome() {
		super(new BiomeProperties("freezer").setTemperature(0.1F).setBaseHeight(1.0F));
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();

		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityGhast.class, 5, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityEnderman.class, 3, 1, 1));
		this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityCreeper.class, 10, 1, 3));

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		BiomeDecorator biomeDecorator = new BiomeDecoratorFreezer();
		
		biomeDecorator.generateFalls = true;
		
		return getModdedBiomeDecorator(biomeDecorator);
	}
	
	@Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
		
	}

}
