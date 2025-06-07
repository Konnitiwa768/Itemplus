// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.registry.emeraldium;

import net.minecraft.class_1738;
import net.minecraft.class_1304;
import net.minecraft.class_1810;
import net.minecraft.class_1829;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_1792;
import net.minecraft.class_1741;
import net.minecraft.class_1832;

public class ModEmeraldiumItems
{
    public static final class_1832 EMERALDIUM_TOOL_MATERIAL;
    public static final class_1741 EMERALDIUM_ARMOR_MATERIAL;
    public static final String MODID = "sakaplus";
    public static final class_1792 EMERALDIUM_SWORD;
    public static final class_1792 EMERALDIUM_PICKAXE;
    public static final class_1792 EMERALDIUM_HELMET;
    public static final class_1792 EMERALDIUM_CHESTPLATE;
    public static final class_1792 EMERALDIUM_LEGGINGS;
    public static final class_1792 EMERALDIUM_BOOTS;
    
    private static class_1792 register(final String name, final class_1792 item) {
        return (class_1792)class_2378.method_10230((class_2378)class_2378.field_11142, new class_2960("sakaplus", name), (Object)item);
    }
    
    public static void registerAll() {
    }
    
    static {
        EMERALDIUM_TOOL_MATERIAL = (class_1832)new EmeraldiumToolMaterial();
        EMERALDIUM_ARMOR_MATERIAL = (class_1741)new EmeraldiumArmorMaterial();
        EMERALDIUM_SWORD = register("emeraldium_sword", (class_1792)new class_1829(ModEmeraldiumItems.EMERALDIUM_TOOL_MATERIAL, 7, -1.6f, new class_1792.class_1793()));
        EMERALDIUM_PICKAXE = register("emeraldium_pickaxe", (class_1792)new class_1810(ModEmeraldiumItems.EMERALDIUM_TOOL_MATERIAL, 2, -2.8f, new class_1792.class_1793()));
        EMERALDIUM_HELMET = register("emeraldium_helmet", (class_1792)new class_1738(ModEmeraldiumItems.EMERALDIUM_ARMOR_MATERIAL, class_1304.field_6169, new class_1792.class_1793()));
        EMERALDIUM_CHESTPLATE = register("emeraldium_chestplate", (class_1792)new class_1738(ModEmeraldiumItems.EMERALDIUM_ARMOR_MATERIAL, class_1304.field_6174, new class_1792.class_1793()));
        EMERALDIUM_LEGGINGS = register("emeraldium_leggings", (class_1792)new class_1738(ModEmeraldiumItems.EMERALDIUM_ARMOR_MATERIAL, class_1304.field_6172, new class_1792.class_1793()));
        EMERALDIUM_BOOTS = register("emeraldium_boots", (class_1792)new class_1738(ModEmeraldiumItems.EMERALDIUM_ARMOR_MATERIAL, class_1304.field_6166, new class_1792.class_1793()));
    }
}
