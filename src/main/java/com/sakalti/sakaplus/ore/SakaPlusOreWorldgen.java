// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.ore;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.class_2893;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.class_5321;
import net.minecraft.class_2378;
import net.minecraft.class_5458;
import net.minecraft.class_2960;
import net.minecraft.class_6797;
import java.util.List;
import net.minecraft.class_6792;
import net.minecraft.class_6795;
import net.minecraft.class_5843;
import net.minecraft.class_5450;
import net.minecraft.class_6793;
import net.minecraft.class_6880;
import net.minecraft.class_6796;
import net.minecraft.class_3037;
import net.minecraft.class_3124;
import net.minecraft.class_6806;
import net.minecraft.class_3031;
import net.minecraft.class_2975;
import net.minecraft.class_2248;

public class SakaPlusOreWorldgen
{
    private static class_2975<?, ?> ore(final class_2248 block, final int veinSize) {
        return (class_2975<?, ?>)new class_2975(class_3031.field_13517, (class_3037)new class_3124(class_6806.field_35858, block.method_9564(), veinSize));
    }
    
    private static class_6796 placed(final class_2975<?, ?> configured, final int veinsPerChunk, final int minY, final int maxY) {
        final class_6880<class_2975<?, ?>> entry = (class_6880<class_2975<?, ?>>)class_6880.method_40223((Object)configured);
        final List<class_6797> modifiers = List.of(class_6793.method_39623(veinsPerChunk), class_5450.method_39639(), class_6795.method_39634(class_5843.method_33841(minY), class_5843.method_33841(maxY)), class_6792.method_39614());
        return new class_6796((class_6880)entry, (List)modifiers);
    }
    
    public static void init() {
        registerOre("orange_crystal_ore", SakaPlusOreBlocks.ORANGE_CRYSTAL_ORE, 7, 5, -32, 48);
        registerOre("beige_crystal_ore", SakaPlusOreBlocks.BEIGE_CRYSTAL_ORE, 6, 4, -16, 32);
        registerOre("cyan_crystal_ore", SakaPlusOreBlocks.CYAN_CRYSTAL_ORE, 5, 6, -64, 16);
        registerOre("purple_crystal_ore", SakaPlusOreBlocks.PURPLE_CRYSTAL_ORE, 4, 4, -64, 0);
        registerOre("black_crystal_ore", SakaPlusOreBlocks.BLACK_CRYSTAL_ORE, 4, 3, -64, -16);
    }
    
    private static void registerOre(final String id, final class_2248 block, final int veinSize, final int veinsPerChunk, final int minY, final int maxY) {
        final class_2960 configuredId = new class_2960("sakaplus", id + "_configured");
        final class_2960 placedId = new class_2960("sakaplus", id + "_placed");
        final class_2975<?, ?> configured = ore(block, veinSize);
        final class_6796 placed = placed(configured, veinsPerChunk, minY, maxY);
        class_2378.method_10230(class_5458.field_25929, configuredId, (Object)configured);
        class_2378.method_10230(class_5458.field_35761, placedId, (Object)placed);
        final class_5321<class_6796> featureKey = (class_5321<class_6796>)class_5321.method_29179(class_2378.field_35758, placedId);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), class_2893.class_2895.field_13176, (class_5321)featureKey);
    }
}
