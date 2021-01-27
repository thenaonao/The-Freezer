package com.aqwerfproject.freezer.init;

import java.util.ArrayList;
import java.util.List;

import com.aqwerfproject.freezer.Main;
import com.aqwerfproject.freezer.objects.ItemBlueGlowStoneDust;
import com.aqwerfproject.freezer.objects.ItemCrystal;
import com.aqwerfproject.freezer.objects.ItemCrystalArmor;
import com.aqwerfproject.freezer.objects.ItemCrystalAxe;
import com.aqwerfproject.freezer.objects.ItemCrystalHoe;
import com.aqwerfproject.freezer.objects.ItemCrystalPickaxe;
import com.aqwerfproject.freezer.objects.ItemCrystalShovel;
import com.aqwerfproject.freezer.objects.ItemCrystalSword;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {

	public static final List<Item> ITEMS = new ArrayList<Item>(); 
	
	
	public static final ArmorMaterial CRYSTAL_ARMOR = EnumHelper.addArmorMaterial(Main.MODID + ":CRYSTALARMOR", Main.MODID + ":crystal_armor", 12, new int[]{3, 5, 5, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	public static final ToolMaterial CRYSTAL_TOOL = EnumHelper.addToolMaterial(Main.MODID + ":CRYSTALTOOL", 2, 220, 6.0F, 2.5F, 18);
	
	
	public static final Item CRYSTAL = new ItemCrystal("material_crystal");
	
	public static final Item BLUEGLOWSTONE_DUST = new ItemBlueGlowStoneDust("dust_blueglowstone");
	public static final Item HELMET_CRYSTAL = new ItemCrystalArmor(CRYSTAL_ARMOR,1,EntityEquipmentSlot.HEAD,"crystal_helmet");
	public static final Item CHESTPLATE_CRYSTAL = new ItemCrystalArmor(CRYSTAL_ARMOR,1,EntityEquipmentSlot.CHEST,"crystal_chestplate");
	public static final Item LEGGINGS_CRYSTAL = new ItemCrystalArmor(CRYSTAL_ARMOR,2,EntityEquipmentSlot.LEGS,"crystal_leggings");
	public static final Item BOOTS_CRYSTAL = new ItemCrystalArmor(CRYSTAL_ARMOR,1,EntityEquipmentSlot.FEET,"crystal_boots");
	
	public static final Item HOE_CRYSTAL = new ItemCrystalHoe(CRYSTAL_TOOL,"crystal_hoe");  
	public static final Item AXE_CRYSTAL = new ItemCrystalAxe(CRYSTAL_TOOL,"crystal_axe");  
	public static final Item PICKAXE_CRYSTAL = new ItemCrystalPickaxe(CRYSTAL_TOOL,"crystal_pickaxe"); 
	public static final Item SHOVEL_CRYSTAL = new ItemCrystalShovel(CRYSTAL_TOOL,"crystal_shovel");  
	public static final Item SWORD_CRYSTAL = new ItemCrystalSword(CRYSTAL_TOOL,"crystal_sword");
}
 