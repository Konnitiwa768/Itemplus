/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.biome.v1.BiomeModifications
 *  net.fabricmc.fabric.api.biome.v1.BiomeSelectors
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1311
 *  net.minecraft.class_1317
 *  net.minecraft.class_1317$class_1319
 *  net.minecraft.class_2378
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_2960
 *  net.minecraft.class_4048
 *  net.minecraft.class_5132$class_5133
 */
package com.sakalti.sakaplus.entity;

import com.sakalti.sakaplus.entity.NucreeperEntity;
import java.util.function.Predicate;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1311;
import net.minecraft.class_1317;
import net.minecraft.class_2378;
import net.minecraft.class_2902;
import net.minecraft.class_2960;
import net.minecraft.class_4048;
import net.minecraft.class_5132;

public class ModEntities2 {
    public static final class_1299<NucreeperEntity> NUCREEPER = (class_1299)class_2378.method_10230((class_2378)class_2378.field_11145, (class_2960)new class_2960("sakaplus", "nucreeper"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6302, NucreeperEntity::new).dimensions(class_4048.method_18385((float)0.6f, (float)1.7f)).trackRangeBlocks(80).trackedUpdateRate(3).build());

    public static void register() {
        FabricDefaultAttributeRegistry.register(NUCREEPER, (class_5132.class_5133)NucreeperEntity.createNucreeperAttributes());
        BiomeModifications.addSpawn((Predicate)BiomeSelectors.foundInOverworld(), (class_1311)class_1311.field_6302, NUCREEPER, (int)20, (int)1, (int)2);
        class_1317.method_20637(NUCREEPER, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, class_1308::method_20636);
    }
}
