package com.aqwerfproject.freezer.objects;

import com.aqwerfproject.freezer.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class ItemCrystalShovel extends ItemSpade {

	public ItemCrystalShovel(ToolMaterial material, String name) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}

}
