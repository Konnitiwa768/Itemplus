package com.sakalti.sakaplus.registry.abyssalite;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModAbyssaliteItems {
    public static final String MODID = "sakaplus";

    // 素材
    public static final Item ABYSSALITE_INGOT = register("abyssalite_ingot", new Item(new Item.Settings()));

    // 素材クラス
    public static final ToolMaterial ABYSSALITE_TOOL_MATERIAL = new AbyssaliteToolMaterial();
    public static final ArmorMaterial ABYSSALITE_ARMOR_MATERIAL = new AbyssaliteArmorMaterial();

    // 武器・ツール
    public static final Item ABYSSALITE_SWORD = register("abyssalite_sword",
            new SwordItem(ABYSSALITE_TOOL_MATERIAL, 5, -2.4f, new Item.Settings())); // 5 + 3.5 = 8.5

    public static final Item ABYSSALITE_PICKAXE = register("abyssalite_pickaxe",
            new PickaxeItem(ABYSSALITE_TOOL_MATERIAL, 1, -2.8f, new Item.Settings()));

    // 防具
    public static final Item ABYSSALITE_HELMET = register("abyssalite_helmet",
            new ArmorItem(ABYSSALITE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()));
    public static final Item ABYSSALITE_CHESTPLATE = register("abyssalite_chestplate",
            new ArmorItem(ABYSSALITE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()));
    public static final Item ABYSSALITE_LEGGINGS = register("abyssalite_leggings",
            new ArmorItem(ABYSSALITE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()));
    public static final Item ABYSSALITE_BOOTS = register("abyssalite_boots",
            new ArmorItem(ABYSSALITE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MODID, name), item);
    }

    public static void registerAll() {
        // 必要ならここで呼ぶだけ
    }
}
