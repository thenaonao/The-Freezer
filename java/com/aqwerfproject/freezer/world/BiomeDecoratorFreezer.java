package com.aqwerfproject.freezer.world;

import java.util.Random;

import com.aqwerfproject.freezer.init.BlockInit;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorFreezer extends BiomeDecorator {
	
	public WorldGenerator crystalGen = new WorldGenMinable(BlockInit.ORE_CRYSTAL.getDefaultState(), 8, BlockMatcher.forBlock(Blocks.SNOW));
	
	public BiomeDecoratorFreezer() {
		super();
	}
	
	 @Override
	    protected void genDecorations(Biome biomeIn, World worldIn, Random random)
	    {
		 MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(worldIn, random, chunkPos));
		 generateOres(worldIn,random);
		 
		 MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(worldIn, random, chunkPos));
	    }
	
	@Override
    protected void generateOres(World worldIn, Random random)
    {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(worldIn, random, chunkPos));
        if (TerrainGen.generateOre(worldIn, random, crystalGen, chunkPos, OreGenEvent.GenerateMinable.EventType.CUSTOM))
        genStandardOre2(worldIn, random, 4, crystalGen, 42, 40);
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(worldIn, random, chunkPos));
    }

	
}
