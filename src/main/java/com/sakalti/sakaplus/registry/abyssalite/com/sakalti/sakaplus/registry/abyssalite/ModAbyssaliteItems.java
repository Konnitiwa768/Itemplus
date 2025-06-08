/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1738
 *  net.minecraft.class_1741
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1810
 *  net.minecraft.class_1829
 *  net.minecraft.class_1832
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 */
package com.sakalti.sakaplus.registry.abyssalite;

import com.sakalti.sakaplus.registry.abyssalite.AbyssaliteArmorMaterial;
import com.sakalti.sakaplus.registry.abyssalite.AbyssaliteToolMaterial;
import net.minecraft.class_1304;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1810;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_2378;
import net.minecraft.class_2960;

public class ModAbyssaliteItems {
    public static final String MODID = "sakaplus";
    public static final class_1792 ABYSSALITE_INGOT = ModAbyssaliteItems.register("abyssalite_ingot", new class_1792(new class_1792.class_1793()));
    public static final class_1832 ABYSSALITE_TOOL_MATERIAL = new AbyssaliteToolMaterial();
    public static final class_1741 ABYSSALITE_ARMOR_MATERIAL = new AbyssaliteArmorMaterial();
    public static final class_1792 ABYSSALITE_SWORD = ModAbyssaliteItems.register("abyssalite_sword", (class_1792)new class_1829(ABYSSALITE_TOOL_MATERIAL, 5, -2.4f, new class_1792.class_1793()));
    public static final class_1792 ABYSSALITE_PICKAXE = ModAbyssaliteItems.register("abyssalite_pickaxe", (class_1792)new class_1810(ABYSSALITE_TOOL_MATERIAL, 1, -2.8f, new class_1792.class_1793()));
    public static final class_1792 ABYSSALITE_HELMET = ModAbyssaliteItems.register("abyssalite_helmet", (class_1792)new class_1738(ABYSSALITE_ARMOR_MATERIAL, class_1304.field_6169, new class_1792.class_1793()));
    public static final class_1792 ABYSSALITE_CHESTPLATE = ModAbyssaliteItems.register("abyssalite_chestplate", (class_1792)new class_1738(ABYSSALITE_ARMOR_MATERIAL, class_1304.field_6174, new class_1792.class_1793()));
    public static final class_1792 ABYSSALITE_LEGGINGS = ModAbyssaliteItems.register("abyssalite_leggings", (class_1792)new class_1738(ABYSSALITE_ARMOR_MATERIAL, class_1304.field_6172, new class_1792.class_1793()));
    public static final class_1792 ABYSSALITE_BOOTS = ModAbyssaliteItems.register("abyssalite_boots", (class_1792)new class_1738(ABYSSALITE_ARMOR_MATERIAL, class_1304.field_6166, new class_1792.class_1793()));

    private static class_1792 register(String name, class_1792 item) {
        return (class_1792)class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)new class_2960(MODID, name), (Object)item);
    }

    public static void registerAll() {
    }
}
