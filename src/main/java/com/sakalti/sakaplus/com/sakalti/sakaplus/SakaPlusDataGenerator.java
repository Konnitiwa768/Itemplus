/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
 *  net.minecraft.class_2405
 */
package com.sakalti.sakaplus;

import com.sakalti.sakaplus.datagen.SakaModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.class_2405;

public class SakaPlusDataGenerator {
    public static void gatherData(FabricDataGenerator generator) {
        generator.addProvider((class_2405)new SakaModelProvider(generator));
    }
}
