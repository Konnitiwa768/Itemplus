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
package com.sakalti.sakaplus.registry.emeraldium;

import com.sakalti.sakaplus.registry.emeraldium.EmeraldiumArmorMaterial;
import com.sakalti.sakaplus.registry.emeraldium.EmeraldiumToolMaterial;
import net.minecraft.class_1304;
import net.minecraft.class_1738;
import net.minecraft.class_1741;
import net.minecraft.class_1792;
import net.minecraft.class_1810;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_2378;
import net.minecraft.class_2960;

public class ModEmeraldiumItems {
    public static final class_1832 EMERALDIUM_TOOL_MATERIAL = new EmeraldiumToolMaterial();
    public static final class_1741 EMERALDIUM_ARMOR_MATERIAL = new EmeraldiumArmorMaterial();
    public static final String MODID = "sakaplus";
    public static final class_1792 EMERALDIUM_SWORD = ModEmeraldiumItems.register("emeraldium_sword", (class_1792)new class_1829(EMERALDIUM_TOOL_MATERIAL, 7, -1.6f, new class_1792.class_1793()));
    public static final class_1792 EMERALDIUM_PICKAXE = ModEmeraldiumItems.register("emeraldium_pickaxe", (class_1792)new class_1810(EMERALDIUM_TOOL_MATERIAL, 2, -2.8f, new class_1792.class_1793()));
    public static final class_1792 EMERALDIUM_HELMET = ModEmeraldiumItems.register("emeraldium_helmet", (class_1792)new class_1738(EMERALDIUM_ARMOR_MATERIAL, class_1304.field_6169, new class_1792.class_1793()));
    public static final class_1792 EMERALDIUM_CHESTPLATE = ModEmeraldiumItems.register("emeraldium_chestplate", (class_1792)new class_1738(EMERALDIUM_ARMOR_MATERIAL, class_1304.field_6174, new class_1792.class_1793()));
    public static final class_1792 EMERALDIUM_LEGGINGS = ModEmeraldiumItems.register("emeraldium_leggings", (class_1792)new class_1738(EMERALDIUM_ARMOR_MATERIAL, class_1304.field_6172, new class_1792.class_1793()));
    public static final class_1792 EMERALDIUM_BOOTS = ModEmeraldiumItems.register("emeraldium_boots", (class_1792)new class_1738(EMERALDIUM_ARMOR_MATERIAL, class_1304.field_6166, new class_1792.class_1793()));

    private static class_1792 register(String name, class_1792 item) {
        return (class_1792)class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)new class_2960(MODID, name), (Object)item);
    }

    public static void registerAll() {
    }
}
