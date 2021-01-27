package com.aqwerfproject.freezer.objects;

import com.aqwerfproject.freezer.init.BlockInit;
import com.aqwerfproject.freezer.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPortalCreator extends Block {

	public BlockPortalCreator(String name, Material materialIn) {
		super(materialIn);
		setResistance(10.0F);
		this.setBlockUnbreakable();
		this.setLightLevel(1.0F);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		setSoundType(SoundType.GLASS);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (((BlockFreezerPortal) BlockInit.BLOCK_FREEZER_PORTAL).trySpawnPortal(worldIn,pos)) {
			if (!worldIn.getBlockState(pos.down()).isOpaqueCube()) {
				worldIn.setBlockToAir(pos);
			} else {
				worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + worldIn.rand.nextInt(10));
			}
		}
	}


	/**
	 * Hard coded stuff because can't get size.validity work
	 * 
	 * @param world
	 * @param pos
	 * @return
	 */
	private boolean CheckPortalValidity(World world, BlockPos pos) {
		EnumFacing.Axis axisX = EnumFacing.Axis.X;
		EnumFacing.Axis axisZ = EnumFacing.Axis.Z;
		BlockPos corner = null;
		BlockPos corner1 = null;
		boolean isX = false;
		boolean isZ = false;
		boolean isNothing = false;
		int xChecker = 0;
		int yChecker = 0;
		int zChecker = 0;

		return false;
	}
}
