// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.registry.abyssalite;

import net.minecraft.class_1738;
import net.minecraft.class_1304;
import net.minecraft.class_1810;
import net.minecraft.class_1829;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_1741;
import net.minecraft.class_1832;
import net.minecraft.class_1792;

public class ModAbyssaliteItems
{
    public static final String MODID = "sakaplus";
    public static final class_1792 ABYSSALITE_INGOT;
    public static final class_1832 ABYSSALITE_TOOL_MATERIAL;
    public static final class_1741 ABYSSALITE_ARMOR_MATERIAL;
    public static final class_1792 ABYSSALITE_SWORD;
    public static final class_1792 ABYSSALITE_PICKAXE;
    public static final class_1792 ABYSSALITE_HELMET;
    public static final class_1792 ABYSSALITE_CHESTPLATE;
    public static final class_1792 ABYSSALITE_LEGGINGS;
    public static final class_1792 ABYSSALITE_BOOTS;
    
    private static class_1792 register(final String name, final class_1792 item) {
        return (class_1792)class_2378.method_10230((class_2378)class_2378.field_11142, new class_2960("sakaplus", name), (Object)item);
    }
    
    public static void registerAll() {
    }
    
    static {
        ABYSSALITE_INGOT = register("abyssalite_ingot", new class_1792(new class_1792.class_1793()));
        ABYSSALITE_TOOL_MATERIAL = (class_1832)new AbyssaliteToolMaterial();
        ABYSSALITE_ARMOR_MATERIAL = (class_1741)new AbyssaliteArmorMaterial();
        ABYSSALITE_SWORD = register("abyssalite_sword", (class_1792)new class_1829(ModAbyssaliteItems.ABYSSALITE_TOOL_MATERIAL, 5, -2.4f, new class_1792.class_1793()));
        ABYSSALITE_PICKAXE = register("abyssalite_pickaxe", (class_1792)new class_1810(ModAbyssaliteItems.ABYSSALITE_TOOL_MATERIAL, 1, -2.8f, new class_1792.class_1793()));
        ABYSSALITE_HELMET = register("abyssalite_helmet", (class_1792)new class_1738(ModAbyssaliteItems.ABYSSALITE_ARMOR_MATERIAL, class_1304.field_6169, new class_1792.class_1793()));
        ABYSSALITE_CHESTPLATE = register("abyssalite_chestplate", (class_1792)new class_1738(ModAbyssaliteItems.ABYSSALITE_ARMOR_MATERIAL, class_1304.field_6174, new class_1792.class_1793()));
        ABYSSALITE_LEGGINGS = register("abyssalite_leggings", (class_1792)new class_1738(ModAbyssaliteItems.ABYSSALITE_ARMOR_MATERIAL, class_1304.field_6172, new class_1792.class_1793()));
        ABYSSALITE_BOOTS = register("abyssalite_boots", (class_1792)new class_1738(ModAbyssaliteItems.ABYSSALITE_ARMOR_MATERIAL, class_1304.field_6166, new class_1792.class_1793()));
    }
}
