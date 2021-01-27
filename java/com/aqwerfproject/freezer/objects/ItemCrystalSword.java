package com.aqwerfproject.freezer.objects;

import com.aqwerfproject.freezer.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemCrystalSword extends ItemSword {

	public ItemCrystalSword(ToolMaterial material, String name) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}

}
