package com.aqwerfproject.freezer.objects;

import com.aqwerfproject.freezer.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ItemCrystalPickaxe extends ItemPickaxe {

	public ItemCrystalPickaxe(ToolMaterial material, String name) {
		super(material);
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}

}
