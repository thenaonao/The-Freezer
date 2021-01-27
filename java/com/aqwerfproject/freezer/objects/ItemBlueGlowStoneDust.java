package com.aqwerfproject.freezer.objects;

import com.aqwerfproject.freezer.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBlueGlowStoneDust extends Item {
	public ItemBlueGlowStoneDust(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}
}
