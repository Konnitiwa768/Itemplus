// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.datagen;

import net.minecraft.class_2248;
import net.minecraft.class_4910;
import java.util.Iterator;
import net.minecraft.class_4943;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_4915;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

public class SakaModelProvider extends FabricModelProvider
{
    public SakaModelProvider(final FabricDataGenerator generator) {
        super(generator);
    }
    
    public void generateItemModels(final class_4915 itemModelGenerator) {
        for (final class_2960 id : class_2378.field_11142.method_10235()) {
            final class_1792 item = (class_1792)class_2378.field_11142.method_10223(id);
            if (item instanceof class_1747) {
                continue;
            }
            itemModelGenerator.method_25733(item, class_4943.field_22938);
        }
    }
    
    public void generateBlockStateModels(final class_4910 blockStateModelGenerator) {
        for (final class_2960 id : class_2378.field_11146.method_10235()) {
            final class_2248 block = (class_2248)class_2378.field_11146.method_10223(id);
            blockStateModelGenerator.method_25641(block);
        }
    }
}
