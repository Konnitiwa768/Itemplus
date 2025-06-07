// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.ore;

import net.minecraft.class_2431;
import net.minecraft.class_4970;
import net.minecraft.class_2246;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_2248;

public class SakaPlusOreBlocks
{
    public static final class_2248 ORANGE_CRYSTAL_ORE;
    public static final class_2248 BEIGE_CRYSTAL_ORE;
    public static final class_2248 CYAN_CRYSTAL_ORE;
    public static final class_2248 PURPLE_CRYSTAL_ORE;
    public static final class_2248 BLACK_CRYSTAL_ORE;
    
    private static class_2248 register(final String name) {
        return (class_2248)class_2378.method_10230((class_2378)class_2378.field_11146, new class_2960("sakaplus", name), (Object)new class_2431(class_4970.class_2251.method_9630((class_4970)class_2246.field_10442)) {});
    }
    
    public static void init() {
    }
    
    static {
        ORANGE_CRYSTAL_ORE = register("orange_crystal_ore");
        BEIGE_CRYSTAL_ORE = register("beige_crystal_ore");
        CYAN_CRYSTAL_ORE = register("cyan_crystal_ore");
        PURPLE_CRYSTAL_ORE = register("purple_crystal_ore");
        BLACK_CRYSTAL_ORE = register("black_crystal_ore");
    }
}
