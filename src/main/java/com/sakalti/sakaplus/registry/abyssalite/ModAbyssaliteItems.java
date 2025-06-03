package com.sakalti.sakaplus.registry.abyssalite;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import static com.sakalti.sakaplus.SakaplusMod.MODID;

public class ModAbyssaliteItems {
    public static final Item ABYSSALITE_INGOT = register("abyssalite_ingot", new Item(new Item.Settings()));
    
    public static final ToolMaterial ABYSSALITE_TOOL_MATERIAL = new AbyssaliteToolMaterial();
    public static final ArmorMaterial ABYSSALITE_ARMOR_MATERIAL = new AbyssaliteArmorMaterial();

    public static final Item ABYSSALITE_SWORD = register("abyssalite_sword",
        new SwordItem(ABYSSALITE_TOOL_MATERIAL, 5, -2.4f, new Item.Settings())); // +3.5 = 8.5

    public static final Item ABYSSALITE_PICKAXE = register("abyssalite_pickaxe",
        new PickaxeItem(ABYSSALITE_TOOL_MATERIAL, 1, -2.8f, new Item.Settings()));

    public static final Item ABYSSALITE_HELMET = register("abyssalite_helmet",
        new ArmorItem(ABYSSALITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item ABYSSALITE_CHESTPLATE = register("abyssalite_chestplate",
        new ArmorItem(ABYSSALITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item ABYSSALITE_LEGGINGS = register("abyssalite_leggings",
        new ArmorItem(ABYSSALITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item ABYSSALITE_BOOTS = register("abyssalite_boots",
        new ArmorItem(ABYSSALITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()));

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MODID, name), item);
    }

    public static void registerAll() {
        // 呼び出すことで全て登録される
    }
}
