package com.aqwerfproject.freezer.util.handler;

import com.aqwerfproject.freezer.init.BlockInit;
import com.aqwerfproject.freezer.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void OnItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void OnBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		event.getRegistry().register(BlockInit.BLOCK_FREEZER_PORTAL);
	}
	
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void OnModelRegister(ModelRegistryEvent event) {
		for(Item item: ItemInit.ITEMS) {	
			ModelLoader.setCustomModelResourceLocation(item, 0 , new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}   
		for(Block block: BlockInit.BLOCKS) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0 , new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}
	}
}
