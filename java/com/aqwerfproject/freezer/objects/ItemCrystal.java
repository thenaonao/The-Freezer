package com.aqwerfproject.freezer.objects;

import com.aqwerfproject.freezer.Main;
import com.aqwerfproject.freezer.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCrystal extends Item{

	public ItemCrystal(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}

}
