/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.biome.v1.BiomeModifications
 *  net.fabricmc.fabric.api.biome.v1.BiomeSelectors
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2893$class_2895
 *  net.minecraft.class_2960
 *  net.minecraft.class_2975
 *  net.minecraft.class_3031
 *  net.minecraft.class_3037
 *  net.minecraft.class_3124
 *  net.minecraft.class_5321
 *  net.minecraft.class_5450
 *  net.minecraft.class_5458
 *  net.minecraft.class_5843
 *  net.minecraft.class_6792
 *  net.minecraft.class_6793
 *  net.minecraft.class_6795
 *  net.minecraft.class_6796
 *  net.minecraft.class_6806
 *  net.minecraft.class_6880
 */
package com.sakalti.sakaplus.ore;

import com.sakalti.sakaplus.ore.SakaPlusOreBlocks;
import java.util.List;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2893;
import net.minecraft.class_2960;
import net.minecraft.class_2975;
import net.minecraft.class_3031;
import net.minecraft.class_3037;
import net.minecraft.class_3124;
import net.minecraft.class_5321;
import net.minecraft.class_5450;
import net.minecraft.class_5458;
import net.minecraft.class_5843;
import net.minecraft.class_6792;
import net.minecraft.class_6793;
import net.minecraft.class_6795;
import net.minecraft.class_6796;
import net.minecraft.class_6806;
import net.minecraft.class_6880;

public class SakaPlusOreWorldgen {
    private static class_2975<?, ?> ore(class_2248 block, int veinSize) {
        return new class_2975(class_3031.field_13517, (class_3037)new class_3124(class_6806.field_35858, block.method_9564(), veinSize));
    }

    private static class_6796 placed(class_2975<?, ?> configured, int veinsPerChunk, int minY, int maxY) {
        class_6880 entry = class_6880.method_40223(configured);
        List<class_6792> modifiers = List.of(class_6793.method_39623((int)veinsPerChunk), class_5450.method_39639(), class_6795.method_39634((class_5843)class_5843.method_33841((int)minY), (class_5843)class_5843.method_33841((int)maxY)), class_6792.method_39614());
        return new class_6796(entry, modifiers);
    }

    public static void init() {
        SakaPlusOreWorldgen.registerOre("orange_crystal_ore", SakaPlusOreBlocks.ORANGE_CRYSTAL_ORE, 7, 5, -32, 48);
        SakaPlusOreWorldgen.registerOre("beige_crystal_ore", SakaPlusOreBlocks.BEIGE_CRYSTAL_ORE, 6, 4, -16, 32);
        SakaPlusOreWorldgen.registerOre("cyan_crystal_ore", SakaPlusOreBlocks.CYAN_CRYSTAL_ORE, 5, 6, -64, 16);
        SakaPlusOreWorldgen.registerOre("purple_crystal_ore", SakaPlusOreBlocks.PURPLE_CRYSTAL_ORE, 4, 4, -64, 0);
        SakaPlusOreWorldgen.registerOre("black_crystal_ore", SakaPlusOreBlocks.BLACK_CRYSTAL_ORE, 4, 3, -64, -16);
    }

    private static void registerOre(String id, class_2248 block, int veinSize, int veinsPerChunk, int minY, int maxY) {
        class_2960 configuredId = new class_2960("sakaplus", id + "_configured");
        class_2960 placedId = new class_2960("sakaplus", id + "_placed");
        class_2975<?, ?> configured = SakaPlusOreWorldgen.ore(block, veinSize);
        class_6796 placed = SakaPlusOreWorldgen.placed(configured, veinsPerChunk, minY, maxY);
        class_2378.method_10230((class_2378)class_5458.field_25929, (class_2960)configuredId, configured);
        class_2378.method_10230((class_2378)class_5458.field_35761, (class_2960)placedId, (Object)placed);
        class_5321 featureKey = class_5321.method_29179((class_5321)class_2378.field_35758, (class_2960)placedId);
        BiomeModifications.addFeature((Predicate)BiomeSelectors.foundInOverworld(), (class_2893.class_2895)class_2893.class_2895.field_13176, (class_5321)featureKey);
    }
}
