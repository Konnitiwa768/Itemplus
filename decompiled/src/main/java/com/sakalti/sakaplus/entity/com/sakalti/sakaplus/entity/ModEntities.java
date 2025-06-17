// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.entity;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.class_4048;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_2378;
import net.minecraft.class_1308;
import net.minecraft.class_2960;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.class_1311;
import net.minecraft.class_5458;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.class_1299;

public class ModEntities3
{
    public static class_1299<TotuTakumiEntity> TOTU_TAKUMI;
    public static class_1299<KouriTakumiEntity> KOURI_TAKUMI;
    
    public static void registerAll() {
        FabricDefaultAttributeRegistry.register((class_1299)ModEntities3.TOTU_TAKUMI, TotuTakumiEntity.createTotuTakumiAttributes());
        FabricDefaultAttributeRegistry.register((class_1299)ModEntities3.KOURI_TAKUMI, KouriTakumiEntity.createKouriTakumiAttributes());
        ModEntities3.TOTU_TAKUMI = registerCreeper("totu_takumi", (class_1299.class_4049<TotuTakumiEntity>)TotuTakumiEntity::new, 0.6f, 1.7f, 80);
        ModEntities3.KOURI_TAKUMI = registerCreeper("kouri_takumi", (class_1299.class_4049<KouriTakumiEntity>)KouriTakumiEntity::new, 0.6f, 1.7f, 80);
        BiomeModifications.addSpawn(context -> {
            final class_2960 biomeId = class_5458.field_25933.method_10221((Object)context.getBiome());
            return biomeId != null && biomeId.method_12832().contains("nether");
        }, class_1311.field_6302, (class_1299)ModEntities3.TOTU_TAKUMI, 40, 1, 3);
        BiomeModifications.addSpawn(context -> {
            final class_2960 biomeId2 = class_5458.field_25933.method_10221((Object)context.getBiome());
            return biomeId2 != null && (biomeId2.method_12832().contains("snow") || biomeId2.method_12832().contains("ice") || biomeId2.method_12832().contains("frozen"));
        }, class_1311.field_6302, (class_1299)ModEntities3.KOURI_TAKUMI, 35, 1, 2);
    }
    
    private static <T extends class_1308> class_1299<T> registerCreeper(final String name, final class_1299.class_4049<T> factory, final float width, final float height, final int trackRange) {
        return (class_1299<T>)class_2378.method_10230((class_2378)class_2378.field_11145, new class_2960("sakaplus", name), (Object)FabricEntityTypeBuilder.create(class_1311.field_6302, (class_1299.class_4049)factory).dimensions(class_4048.method_18385(width, height)).trackRangeBlocks(trackRange).trackedUpdateRate(3).build());
    }
}
