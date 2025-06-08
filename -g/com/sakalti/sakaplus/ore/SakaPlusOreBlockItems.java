// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.ore;

import net.minecraft.class_1747;
import net.minecraft.class_1761;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_2248;

public class SakaPlusOreBlockItems
{
    public static void init() {
        registerBlockItem("orange_crystal_ore", SakaPlusOreBlocks.ORANGE_CRYSTAL_ORE);
        registerBlockItem("beige_crystal_ore", SakaPlusOreBlocks.BEIGE_CRYSTAL_ORE);
        registerBlockItem("cyan_crystal_ore", SakaPlusOreBlocks.CYAN_CRYSTAL_ORE);
        registerBlockItem("purple_crystal_ore", SakaPlusOreBlocks.PURPLE_CRYSTAL_ORE);
        registerBlockItem("black_crystal_ore", SakaPlusOreBlocks.BLACK_CRYSTAL_ORE);
    }
    
    private static void registerBlockItem(final String name, final class_2248 block) {
        class_2378.method_10230((class_2378)class_2378.field_11142, new class_2960("sakaplus", name), (Object)new class_1747(block, new class_1792.class_1793().method_7892(class_1761.field_7931)));
    }
}
