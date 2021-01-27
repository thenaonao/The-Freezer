package com.aqwerfproject.freezer;

import org.apache.logging.log4j.Logger;

import com.aqwerfproject.freezer.init.BlockInit;
import com.aqwerfproject.freezer.init.ItemInit;
import com.aqwerfproject.freezer.proxy.FreezerCommonProxy;
import com.aqwerfproject.freezer.world.FreezerBiomes;
import com.aqwerfproject.freezer.world.FreezerWorldGen;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main {

	public static final String MODID = "freezer";
	public static final String NAME = "The Freezer";
	public static final String VERSION = "0.1";

	@Instance(Main.MODID)
	public static Main instance;
	@SidedProxy(clientSide = "com.aqwerfproject.freezer.proxy.FreezerClientProxy", serverSide ="com.aqwerfproject.freezer.proxy.FreezerServerProxy")
	public static FreezerCommonProxy proxy;

	public static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		logger = e.getModLog();
		
		FreezerWorldGen.registerDimensions();
		
		proxy.preInit(e.getSuggestedConfigurationFile());
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		FreezerWorldGen.registerWorldGenerators();
		FreezerBiomes.initBiomeManagerAndDictionary();
		GameRegistry.addSmelting(BlockInit.ORE_CRYSTAL, new ItemStack(ItemInit.CRYSTAL), 1.0F);
		
		proxy.init();
		}

}
