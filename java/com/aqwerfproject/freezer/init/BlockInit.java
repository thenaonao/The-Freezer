package com.aqwerfproject.freezer.init;

import java.util.ArrayList;
import java.util.List;

import com.aqwerfproject.freezer.objects.BlockBlueGlowstone;
import com.aqwerfproject.freezer.objects.BlockBlueIce;
import com.aqwerfproject.freezer.objects.BlockFreezerPortal;
import com.aqwerfproject.freezer.objects.BlockOreCrystal;
import com.aqwerfproject.freezer.objects.BlockPortalCreator;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>(); 
	
	public static final Block ORE_CRYSTAL = new BlockOreCrystal("ore_crystal",Material.CRAFTED_SNOW);
	public static final Block BLOCK_BLUEICE = new BlockBlueIce("block_blueice", Material.PACKED_ICE,false);
	public static final Block BLOCK_BLUEICEDAMAGE = new BlockBlueIce("block_blueice_dmg", Material.PACKED_ICE, true);
	public static final Block BLOCK_BLUEGLOWSTONE = new BlockBlueGlowstone("block_blueglowstone",Material.GLASS);
	public static final Block BLOCK_FREEZER_PORTAL = new BlockFreezerPortal("freezer_portal",Material.PORTAL);
	public static final Block Block_PORTALCREATOR = new BlockPortalCreator("block_portalcreator",Material.BARRIER);
}
