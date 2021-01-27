package com.aqwerfproject.freezer.objects;

import java.util.Random;

import javax.annotation.Nullable;

import org.objectweb.asm.Type;

import com.aqwerfproject.freezer.Main;
import com.aqwerfproject.freezer.init.BlockInit;
import com.aqwerfproject.freezer.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBlueIce extends Block {

	private final boolean isDamaging;

	public BlockBlueIce(String name, Material materialIn, boolean isDmg) {
		super(materialIn);
		this.isDamaging = isDmg;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		if (this.isDamaging) {
			this.setLightLevel(0.8F);
		}
		setSoundType(SoundType.GLASS);
		setHarvestLevel("pickaxe", 2);
		setResistance(5.0F);
		setHardness(8.0F);
		slipperiness = 0.98F;
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state,
			@Nullable TileEntity te, ItemStack stack) {
		player.addStat(StatList.getBlockStats(this));
		player.addExhaustion(0.005F);
		if (!this.isDamaging) {
			if (this.canSilkHarvest(worldIn, pos, state, player)
					&& EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0) {
				java.util.List<ItemStack> items = new java.util.ArrayList<ItemStack>();
				items.add(this.getSilkTouchDrop(state));

				net.minecraftforge.event.ForgeEventFactory.fireBlockHarvesting(items, worldIn, pos, state, 0, 1.0f,
						true, player);
				for (ItemStack is : items)
					spawnAsEntity(worldIn, pos, is);
			} else {
				if (worldIn.provider.doesWaterVaporize()) {
					worldIn.setBlockToAir(pos);
					return;
				}

				int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
				harvesters.set(player);
				this.dropBlockAsItem(worldIn, pos, state, i);
				harvesters.set(null);
				Material material = worldIn.getBlockState(pos.down()).getMaterial();
			}
		}
	}

	@Override
	public boolean canEntitySpawn(IBlockState state, Entity entityIn) {
		return false;
	}

	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (this.isDamaging) {
			if (entityIn instanceof EntityLivingBase) {
				entityIn.attackEntityFrom(DamageSource.GENERIC, 4);
			}

		}
	}

}
