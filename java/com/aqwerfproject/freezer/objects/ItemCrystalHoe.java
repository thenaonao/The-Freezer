package com.aqwerfproject.freezer.objects;

import java.util.Set;

import com.aqwerfproject.freezer.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemTool;

public class ItemCrystalHoe extends ItemHoe {

	public ItemCrystalHoe(ToolMaterial material,String name) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}


}
