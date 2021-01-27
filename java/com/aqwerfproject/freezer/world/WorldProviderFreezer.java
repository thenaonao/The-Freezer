package com.aqwerfproject.freezer.world;

import javax.annotation.Nullable;

import com.aqwerfproject.freezer.world.FreezerWorldGen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderFreezer extends WorldProvider {

	public void init() {
		this.biomeProvider = new BiomeProviderSingle(FreezerBiomes.freezer);
		this.hasSkyLight = false;
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	protected void generateLightBrightnessTable() {
		for (int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - (float) i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 0.9F + 0.1F;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3d(0.049999999329447746D, 0.049999999329447746D, 0.60000000298023224D);
	}
	
	
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks)
    {
        return 0.5F;
    }

	@Override
	public boolean canDoLightning(net.minecraft.world.chunk.Chunk chunk) {
		return false;
	}

	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}

	@Override
	public boolean canSnowAt(BlockPos pos, boolean checkLight) {
		return true;
	}

	@Override
	public boolean canBlockFreeze(BlockPos pos, boolean byWater) {
		return false;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public double getMovementFactor() {
		return 2.0D;
	}

	public boolean shouldClientCheckLighting() {
		return true;
	}

	@Override
	public DimensionType getDimensionType() {
		return FreezerWorldGen.FREEZER_TYPE;
	}

	@Nullable
	@Override
	@SideOnly(Side.CLIENT)
	public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {

		return null;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorFreezer(world);
	}
}
