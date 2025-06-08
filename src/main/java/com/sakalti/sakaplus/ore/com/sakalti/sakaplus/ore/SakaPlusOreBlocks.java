/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2431
 *  net.minecraft.class_2960
 *  net.minecraft.class_4970
 *  net.minecraft.class_4970$class_2251
 */
package com.sakalti.sakaplus.ore;

import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2431;
import net.minecraft.class_2960;
import net.minecraft.class_4970;

public class SakaPlusOreBlocks {
    public static final class_2248 ORANGE_CRYSTAL_ORE = SakaPlusOreBlocks.register("orange_crystal_ore");
    public static final class_2248 BEIGE_CRYSTAL_ORE = SakaPlusOreBlocks.register("beige_crystal_ore");
    public static final class_2248 CYAN_CRYSTAL_ORE = SakaPlusOreBlocks.register("cyan_crystal_ore");
    public static final class_2248 PURPLE_CRYSTAL_ORE = SakaPlusOreBlocks.register("purple_crystal_ore");
    public static final class_2248 BLACK_CRYSTAL_ORE = SakaPlusOreBlocks.register("black_crystal_ore");

    private static class_2248 register(String name) {
        return (class_2248)class_2378.method_10230((class_2378)class_2378.field_11146, (class_2960)new class_2960("sakaplus", name), (Object)new class_2431(class_4970.class_2251.method_9630((class_4970)class_2246.field_10442)){});
    }

    public static void init() {
    }
}
