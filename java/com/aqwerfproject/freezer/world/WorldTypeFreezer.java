package com.aqwerfproject.freezer.world;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldTypeFreezer extends WorldType {

	public WorldTypeFreezer() {
		super("freezer");
	}

	@Override
	public BiomeProvider getBiomeProvider(World world) {
		return new BiomeProviderSingle(FreezerBiomes.freezer);
	}

	@Override
	public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
		return new ChunkGeneratorFreezer(world);
		
	}
	@Override
	public double getHorizon(World world) {
		return 63.0D;
	}

	@Override
	public double voidFadeMagnitude() {
		return 0.03125D;
	}

	@Override
	public boolean handleSlimeSpawnReduction(Random random, World world) {
		return true;
	}

	@Override
	public int getMinimumSpawnHeight(World world) {
		return world.getSeaLevel() + 1;
	}

	/**
	 * Called when 'Create New World' button is pressed before starting game.
	 */
	@Override
	public void onGUICreateWorldPress() {
	}

	/**
	 * Gets the spawn fuzz for players who join the world. Useful for void world
	 * types.
	 *
	 * @param world  the world
	 * @param server the server
	 * @return Fuzz for entity initial spawn in blocks.
	 */
	@Override
	public int getSpawnFuzz(WorldServer world, net.minecraft.server.MinecraftServer server) {
		return Math.max(0, server.getSpawnRadius(world));
	}

	/**
	 * Called when the 'Customize' button is pressed on world creation GUI.
	 *
	 * @param mc             The Minecraft instance
	 * @param guiCreateWorld the createworld GUI
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void onCustomizeButton(Minecraft mc, GuiCreateWorld guiCreateWorld) {
	}

	/**
	 * Should world creation GUI show 'Customize' button for this world type?.
	 *
	 * @return if this world type has customization parameters
	 */
	@Override
	public boolean isCustomizable() {
		return false;
	}

	/**
	 * returns true if selecting this worldtype from the customize menu should
	 * display the generator.[worldtype].info message
	 *
	 * @return true, if successful
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasInfoNotice() {
		return true;
	}

}
