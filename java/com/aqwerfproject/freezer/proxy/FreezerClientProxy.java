package com.aqwerfproject.freezer.proxy;

import java.io.File;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class FreezerClientProxy extends FreezerCommonProxy {

	@Override
	public void preInit(File configFile) {
		super.preInit(configFile);
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(),id));
	}

}
