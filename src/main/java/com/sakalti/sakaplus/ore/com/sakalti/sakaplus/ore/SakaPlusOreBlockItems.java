/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1747
 *  net.minecraft.class_1761
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 */
package com.sakalti.sakaplus.ore;

import com.sakalti.sakaplus.ore.SakaPlusOreBlocks;
import net.minecraft.class_1747;
import net.minecraft.class_1761;
import net.minecraft.class_1792;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2960;

public class SakaPlusOreBlockItems {
    public static void init() {
        SakaPlusOreBlockItems.registerBlockItem("orange_crystal_ore", SakaPlusOreBlocks.ORANGE_CRYSTAL_ORE);
        SakaPlusOreBlockItems.registerBlockItem("beige_crystal_ore", SakaPlusOreBlocks.BEIGE_CRYSTAL_ORE);
        SakaPlusOreBlockItems.registerBlockItem("cyan_crystal_ore", SakaPlusOreBlocks.CYAN_CRYSTAL_ORE);
        SakaPlusOreBlockItems.registerBlockItem("purple_crystal_ore", SakaPlusOreBlocks.PURPLE_CRYSTAL_ORE);
        SakaPlusOreBlockItems.registerBlockItem("black_crystal_ore", SakaPlusOreBlocks.BLACK_CRYSTAL_ORE);
    }

    private static void registerBlockItem(String name, class_2248 block) {
        class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)new class_2960("sakaplus", name), (Object)new class_1747(block, new class_1792.class_1793().method_7892(class_1761.field_7931)));
    }
}
