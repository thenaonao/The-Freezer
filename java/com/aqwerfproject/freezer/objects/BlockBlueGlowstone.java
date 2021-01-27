package com.aqwerfproject.freezer.objects;

import java.util.Random;

import com.aqwerfproject.freezer.init.BlockInit;
import com.aqwerfproject.freezer.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockBlueGlowstone extends Block {

	public BlockBlueGlowstone(String name,Material materialIn) {
		super(materialIn);
		setResistance(0.3F);
		setHardness(0.3F); 
		this.setLightLevel(1.0F);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		setSoundType(SoundType.GLASS);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}
	
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return MathHelper.clamp(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
    }

    public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(3);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ItemInit.BLUEGLOWSTONE_DUST;
    }
	
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return MapColor.ICE;
    }
}
