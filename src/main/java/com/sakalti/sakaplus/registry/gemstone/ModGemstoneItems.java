// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.registry.gemstone;

import net.minecraft.class_1738;
import net.minecraft.class_1304;
import net.minecraft.class_1829;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_1792;
import net.minecraft.class_1832;
import net.minecraft.class_1741;

public class ModGemstoneItems
{
    public static final String MODID = "sakaplus";
    public static final class_1741 GEMSTONE_ARMOR_MATERIAL;
    public static final class_1832 GEMSTONE_TOOL_MATERIAL;
    public static final class_1792 GEMSTONE_SWORD;
    public static final class_1792 GEMSTONE_HELMET;
    public static final class_1792 GEMSTONE_CHESTPLATE;
    public static final class_1792 GEMSTONE_LEGGINGS;
    public static final class_1792 GEMSTONE_BOOTS;
    
    private static class_1792 register(final String name, final class_1792 item) {
        return (class_1792)class_2378.method_10230((class_2378)class_2378.field_11142, new class_2960("sakaplus", name), (Object)item);
    }
    
    public static void registerAll() {
    }
    
    static {
        GEMSTONE_ARMOR_MATERIAL = (class_1741)new GemstoneArmorMaterial();
        GEMSTONE_TOOL_MATERIAL = (class_1832)new GemstoneToolMaterial();
        GEMSTONE_SWORD = register("gemstone_sword", (class_1792)new class_1829(ModGemstoneItems.GEMSTONE_TOOL_MATERIAL, 5, -2.4f, new class_1792.class_1793()));
        GEMSTONE_HELMET = register("gemstone_helmet", (class_1792)new class_1738(ModGemstoneItems.GEMSTONE_ARMOR_MATERIAL, class_1304.field_6169, new class_1792.class_1793()));
        GEMSTONE_CHESTPLATE = register("gemstone_chestplate", (class_1792)new class_1738(ModGemstoneItems.GEMSTONE_ARMOR_MATERIAL, class_1304.field_6174, new class_1792.class_1793()));
        GEMSTONE_LEGGINGS = register("gemstone_leggings", (class_1792)new class_1738(ModGemstoneItems.GEMSTONE_ARMOR_MATERIAL, class_1304.field_6172, new class_1792.class_1793()));
        GEMSTONE_BOOTS = register("gemstone_boots", (class_1792)new class_1738(ModGemstoneItems.GEMSTONE_ARMOR_MATERIAL, class_1304.field_6166, new class_1792.class_1793()));
    }
}
