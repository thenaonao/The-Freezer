package com.aqwerfproject.freezer.objects;

import com.aqwerfproject.freezer.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class ItemCrystalAxe extends ItemAxe {

	public ItemCrystalAxe(ToolMaterial material,String name) { 
		super(material, 8.0F, -3.0F);

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);

		ItemInit.ITEMS.add(this);
	}


}
