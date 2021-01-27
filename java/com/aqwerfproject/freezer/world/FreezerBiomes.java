package com.aqwerfproject.freezer.world;

import com.aqwerfproject.freezer.Main;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Main.MODID)
public class FreezerBiomes { 
	public final static FreezerBiome freezer =null;//= new FreezerBiome();

	@EventBusSubscriber(modid = Main.MODID)
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void onEvent(final RegistryEvent.Register<Biome> event) {
			final IForgeRegistry<Biome> registry = event.getRegistry();

			registry.register(new FreezerBiome().setRegistryName(Main.MODID, "freezer"));
	
		}
	}

	/**
	 * This method should be called during the "init" FML lifecycle because it must
	 * happen after object handler injection.
	 */
	public static void initBiomeManagerAndDictionary() {
		
		BiomeManager.addBiome(BiomeType.ICY, new BiomeEntry(freezer, 0));
		BiomeManager.addSpawnBiome(freezer);
		BiomeDictionary.addTypes(freezer, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.DEAD);
	}
	
}