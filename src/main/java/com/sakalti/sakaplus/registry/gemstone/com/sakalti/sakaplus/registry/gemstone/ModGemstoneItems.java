/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1738
 *  net.minecraft.class_1741
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1829
 *  net.minecraft.class_1832
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 */
package com.sakalti.sakaplus.registry.gemstone;

import com.sakalti.sakaplus.registry.gemstone.GemstoneArmorMaterial;
import com.sakalti.sakaplus.registry.gemstone.GemstoneToolMaterial;
import net.minecraft.class_1304;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_2378;
import net.minecraft.class_2960;

public class ModGemstoneItems {
    public static final String MODID = "sakaplus";
    public static final class_1741 GEMSTONE_ARMOR_MATERIAL = new GemstoneArmorMaterial();
    public static final class_1832 GEMSTONE_TOOL_MATERIAL = new GemstoneToolMaterial();
    public static final class_1792 GEMSTONE_SWORD = ModGemstoneItems.register("gemstone_sword", (class_1792)new class_1829(GEMSTONE_TOOL_MATERIAL, 5, -2.4f, new class_1792.class_1793()));
    public static final class_1792 GEMSTONE_HELMET = ModGemstoneItems.register("gemstone_helmet", (class_1792)new class_1738(GEMSTONE_ARMOR_MATERIAL, class_1304.field_6169, new class_1792.class_1793()));
    public static final class_1792 GEMSTONE_CHESTPLATE = ModGemstoneItems.register("gemstone_chestplate", (class_1792)new class_1738(GEMSTONE_ARMOR_MATERIAL, class_1304.field_6174, new class_1792.class_1793()));
    public static final class_1792 GEMSTONE_LEGGINGS = ModGemstoneItems.register("gemstone_leggings", (class_1792)new class_1738(GEMSTONE_ARMOR_MATERIAL, class_1304.field_6172, new class_1792.class_1793()));
    public static final class_1792 GEMSTONE_BOOTS = ModGemstoneItems.register("gemstone_boots", (class_1792)new class_1738(GEMSTONE_ARMOR_MATERIAL, class_1304.field_6166, new class_1792.class_1793()));

    private static class_1792 register(String name, class_1792 item) {
        return (class_1792)class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)new class_2960(MODID, name), (Object)item);
    }

    public static void registerAll() {
    }
}
