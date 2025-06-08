/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_2248
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_4910
 *  net.minecraft.class_4915
 *  net.minecraft.class_4943
 */
package com.sakalti.sakaplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_4910;
import net.minecraft.class_4915;
import net.minecraft.class_4943;

public class SakaModelProvider
extends FabricModelProvider {
    public SakaModelProvider(FabricDataGenerator generator) {
        super(generator);
    }

    public void generateItemModels(class_4915 itemModelGenerator) {
        for (class_2960 id : class_2378.field_11142.method_10235()) {
            class_1792 item = (class_1792)class_2378.field_11142.method_10223(id);
            if (item instanceof class_1747) continue;
            itemModelGenerator.method_25733(item, class_4943.field_22938);
        }
    }

    public void generateBlockStateModels(class_4910 blockStateModelGenerator) {
        for (class_2960 id : class_2378.field_11146.method_10235()) {
            class_2248 block = (class_2248)class_2378.field_11146.method_10223(id);
            blockStateModelGenerator.method_25641(block);
        }
    }
}
