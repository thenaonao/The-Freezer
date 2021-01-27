package com.aqwerfproject.freezer.objects;

import java.util.Random;

import com.aqwerfproject.freezer.Main;
import com.aqwerfproject.freezer.init.BlockInit;
import com.aqwerfproject.freezer.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockOreCrystal extends Block {

	public BlockOreCrystal(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.SNOW);
		setResistance(5.0F);
		setHardness(6.0F);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	   {
	       return ItemInit.CRYSTAL;
	   }
}
