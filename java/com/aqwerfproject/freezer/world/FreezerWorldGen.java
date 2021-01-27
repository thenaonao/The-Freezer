package com.aqwerfproject.freezer.world;

import javax.annotation.Nullable;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FreezerWorldGen{

	public static final int FREEZER_ID = findFreeDimensionID();
	public static final DimensionType FREEZER_TYPE = DimensionType.register("freezer", "_freezer", FREEZER_ID, WorldProviderFreezer.class, false);
	public static final WorldType FREEZER_WORLD_TYPE = new WorldTypeFreezer();
	
	
	public static final void registerDimensions() {
		DimensionManager.registerDimension(FREEZER_ID, FREEZER_TYPE);
	}

	@Nullable
	private static Integer findFreeDimensionID() {
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			if (!DimensionManager.isDimensionRegistered(i)) {
				System.out.println("Found free dimension ID = " + i);
				return i;
			}
		}
		System.out.println("ERROR: Could not find free dimension ID");
		return null;
	}
	
	public static void registerWorldGenerators()
    {
        System.out.println("Registering world generators");
    }
	
}
