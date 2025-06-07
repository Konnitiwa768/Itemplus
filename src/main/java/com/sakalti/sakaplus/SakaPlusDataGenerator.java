// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus;

import net.minecraft.class_2405;
import com.sakalti.sakaplus.datagen.SakaModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SakaPlusDataGenerator
{
    public static void gatherData(final FabricDataGenerator generator) {
        generator.addProvider((class_2405)new SakaModelProvider(generator));
    }
}
