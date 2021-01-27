package com.aqwerfproject.freezer.world;

import java.util.Random;

import com.aqwerfproject.freezer.init.BlockInit;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBlueGlowStone1 extends WorldGenerator
{
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        if (!worldIn.isAirBlock(position))
        {
            return false;
        }
        else if (worldIn.getBlockState(position.up()).getBlock() != Blocks.SNOW)
        {
            return false;
        }
        else
        {
            worldIn.setBlockState(position, BlockInit.BLOCK_BLUEGLOWSTONE.getDefaultState(), 2);

            for (int i = 0; i < 1500; ++i)
            {
                BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));

                if (worldIn.isAirBlock(blockpos))
                {
                    int j = 0;

                    for (EnumFacing enumfacing : EnumFacing.values())
                    {
                        if (worldIn.getBlockState(blockpos.offset(enumfacing)).getBlock() == BlockInit.BLOCK_BLUEGLOWSTONE)
                        {
                            ++j;
                        }

                        if (j > 1)
                        {
                            break;
                        }
                    }

                    if (j == 1)
                    {
                        worldIn.setBlockState(blockpos, BlockInit.BLOCK_BLUEGLOWSTONE.getDefaultState(), 2);
                    }
                }
            }

            return true;
        }
    }
}