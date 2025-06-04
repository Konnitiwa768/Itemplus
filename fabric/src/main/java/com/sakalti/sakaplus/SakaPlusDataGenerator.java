package com.sakalti.sakaplus;

import com.sakalti.sakaplus.datagen.SakaModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SakaPlusDataGenerator {
    public static void gatherData(FabricDataGenerator generator) {
        generator.addProvider(new SakaModelProvider(generator));
    }
}
