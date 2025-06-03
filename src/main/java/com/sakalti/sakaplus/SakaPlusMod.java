package com.sakalti.sakaplus;

import com.sakalti.sakaplus.registry.Frieds;
import net.fabricmc.api.ModInitializer;
import com.sakalti.sakaplus.registry.abyssalite.ModAbyssaliteItems
import com.sakalti.sakaplus.registry.gemstone.ModGemstoneItems

public class SakaPlusMod implements ModInitializer {
    public static final String MOD_ID = "sakaplus";

    @Override
    public void onInitialize() {
        Frieds.register();
        ModAbyssaliteItems.register();
        ModGemstoneItems.register();
    }
}
