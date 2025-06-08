/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.biome.v1.BiomeModifications
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_4049
 *  net.minecraft.class_1308
 *  net.minecraft.class_1311
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_4048
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5458
 */
package com.sakalti.sakaplus.entity;

import com.sakalti.sakaplus.entity.KouriTakumiEntity;
import com.sakalti.sakaplus.entity.TotuTakumiEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1311;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_4048;
import net.minecraft.class_5132;
import net.minecraft.class_5458;

public class ModEntities {
    public static class_1299<TotuTakumiEntity> TOTU_TAKUMI;
    public static class_1299<KouriTakumiEntity> KOURI_TAKUMI;

    public static void registerAll() {
        FabricDefaultAttributeRegistry.register(TOTU_TAKUMI, (class_5132.class_5133)TotuTakumiEntity.createTotuTakumiAttributes());
        FabricDefaultAttributeRegistry.register(KOURI_TAKUMI, (class_5132.class_5133)KouriTakumiEntity.createKouriTakumiAttributes());
        TOTU_TAKUMI = ModEntities.registerCreeper("totu_takumi", TotuTakumiEntity::new, 0.6f, 1.7f, 80);
        KOURI_TAKUMI = ModEntities.registerCreeper("kouri_takumi", KouriTakumiEntity::new, 0.6f, 1.7f, 80);
        BiomeModifications.addSpawn(context -> {
            class_2960 biomeId = class_5458.field_25933.method_10221((Object)context.getBiome());
            return biomeId != null && biomeId.method_12832().contains("nether");
        }, (class_1311)class_1311.field_6302, TOTU_TAKUMI, (int)40, (int)1, (int)3);
        BiomeModifications.addSpawn(context -> {
            class_2960 biomeId = class_5458.field_25933.method_10221((Object)context.getBiome());
            return biomeId != null && (biomeId.method_12832().contains("snow") || biomeId.method_12832().contains("ice") || biomeId.method_12832().contains("frozen"));
        }, (class_1311)class_1311.field_6302, KOURI_TAKUMI, (int)35, (int)1, (int)2);
    }

    private static <T extends class_1308> class_1299<T> registerCreeper(String name, class_1299.class_4049<T> factory, float width, float height, int trackRange) {
        return (class_1299)class_2378.method_10230((class_2378)class_2378.field_11145, (class_2960)new class_2960("sakaplus", name), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6302, factory).dimensions(class_4048.method_18385((float)width, (float)height)).trackRangeBlocks(trackRange).trackedUpdateRate(3).build());
    }
}
