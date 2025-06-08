/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder
 *  net.minecraft.class_1299
 *  net.minecraft.class_1311
 *  net.minecraft.class_1317
 *  net.minecraft.class_1317$class_1319
 *  net.minecraft.class_2378
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_2960
 *  net.minecraft.class_4048
 *  net.minecraft.class_5132$class_5133
 */
package com.sakalti.sakaplus.parasitory.registry;

import com.sakalti.sakaplus.parasitory.entity.UgnazhiEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_1317;
import net.minecraft.class_2378;
import net.minecraft.class_2902;
import net.minecraft.class_2960;
import net.minecraft.class_4048;
import net.minecraft.class_5132;

public class ParasitoryEntities {
    public static final class_1299<UgnazhiEntity> UGNAZHI = (class_1299)class_2378.method_10230((class_2378)class_2378.field_11145, (class_2960)new class_2960("sakaplus", "ugnazhi"), (Object)FabricEntityTypeBuilder.create((class_1311)class_1311.field_6302, UgnazhiEntity::new).dimensions(class_4048.method_18385((float)0.6f, (float)0.8f)).trackRangeBlocks(8).build());

    public static void register() {
        FabricDefaultAttributeRegistry.register(UGNAZHI, (class_5132.class_5133)UgnazhiEntity.createAttributes());
        class_1317.method_20637(UGNAZHI, (class_1317.class_1319)class_1317.class_1319.field_6317, (class_2902.class_2903)class_2902.class_2903.field_13203, UgnazhiEntity::canSpawn);
    }
}
