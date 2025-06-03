package com.sakalti.sakaplus;

import com.sakalti.sakaplus.datagen.SakaModelProvider;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SakaPlusDataGenerator implements ModInitializer {
    @Override
    public void onInitialize() {
        // datagen専用、何もしない
    }

    public static void onInitializeDataGen(FabricDataGenerator generator) {
        generator.createPack().addProvider(SakaModelProvider::new);
    }
}
