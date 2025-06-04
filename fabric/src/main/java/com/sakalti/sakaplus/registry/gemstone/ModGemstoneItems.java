package com.sakalti.sakaplus.registry.gemstone;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModGemstoneItems {
    public static final String MODID = "sakaplus";

    public static final ArmorMaterial GEMSTONE_ARMOR_MATERIAL = new GemstoneArmorMaterial();
    public static final ToolMaterial GEMSTONE_TOOL_MATERIAL = new GemstoneToolMaterial();

    // 武器
    public static final Item GEMSTONE_SWORD = register("gemstone_sword",
            new SwordItem(GEMSTONE_TOOL_MATERIAL, 5, -2.4f, new Item.Settings())); // 攻撃力 9

    // 防具
    public static final Item GEMSTONE_HELMET = register("gemstone_helmet",
            new ArmorItem(GEMSTONE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()));
    public static final Item GEMSTONE_CHESTPLATE = register("gemstone_chestplate",
            new ArmorItem(GEMSTONE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()));
    public static final Item GEMSTONE_LEGGINGS = register("gemstone_leggings",
            new ArmorItem(GEMSTONE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()));
    public static final Item GEMSTONE_BOOTS = register("gemstone_boots",
            new ArmorItem(GEMSTONE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MODID, name), item);
    }

    public static void registerAll() {
        // 強制ロード用
    }
}
