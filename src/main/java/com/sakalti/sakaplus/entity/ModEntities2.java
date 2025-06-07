// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.entity;

import net.minecraft.class_4048;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_1308;
import net.minecraft.class_2902;
import net.minecraft.class_1317;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.class_1311;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.class_1299;

public class ModEntities2
{
    public static final class_1299<NucreeperEntity> NUCREEPER;
    
    public static void register() {
        FabricDefaultAttributeRegistry.register((class_1299)ModEntities2.NUCREEPER, NucreeperEntity.createNucreeperAttributes());
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), class_1311.field_6302, (class_1299)ModEntities2.NUCREEPER, 20, 1, 2);
        class_1317.method_20637((class_1299)ModEntities2.NUCREEPER, class_1317.class_1319.field_6317, class_2902.class_2903.field_13203, class_1308::method_20636);
    }
    
    static {
        NUCREEPER = (class_1299)class_2378.method_10230((class_2378)class_2378.field_11145, new class_2960("sakaplus", "nucreeper"), (Object)FabricEntityTypeBuilder.create(class_1311.field_6302, NucreeperEntity::new).dimensions(class_4048.method_18385(0.6f, 1.7f)).trackRangeBlocks(80).trackedUpdateRate(3).build());
    }
}
