package com.sakalti.sakaplus.registry.emeraldium;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEmeraldiumItems {
    public static final ToolMaterial EMERALDIUM_TOOL_MATERIAL = new EmeraldiumToolMaterial();
    public static final ArmorMaterial EMERALDIUM_ARMOR_MATERIAL = new EmeraldiumArmorMaterial();
    public static final String MODID = "sakaplus";

    public static final Item EMERALDIUM_SWORD = register("emeraldium_sword",
        new SwordItem(EMERALDIUM_TOOL_MATERIAL, 7, -1.6f, new Item.Settings())); // 7 + 4 = 11
    public static final Item EMERALDIUM_PICKAXE = register("emeraldium_pickaxe",
        new PickaxeItem(EMERALDIUM_TOOL_MATERIAL, 2, -2.8f, new Item.Settings()));

    public static final Item EMERALDIUM_HELMET = register("emeraldium_helmet",
        new ArmorItem(EMERALDIUM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings()));
    public static final Item EMERALDIUM_CHESTPLATE = register("emeraldium_chestplate",
        new ArmorItem(EMERALDIUM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings()));
    public static final Item EMERALDIUM_LEGGINGS = register("emeraldium_leggings",
        new ArmorItem(EMERALDIUM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings()));
    public static final Item EMERALDIUM_BOOTS = register("emeraldium_boots",
        new ArmorItem(EMERALDIUM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MODID, name), item);
    }

    public static void registerAll() {}
}
