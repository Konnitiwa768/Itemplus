/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 */
package com.sakalti.sakaplus;

import com.sakalti.sakaplus.block.SakaplusBlocks;
import com.sakalti.sakaplus.enchant.ModEnchantments;
import com.sakalti.sakaplus.entity.ModEntities;
import com.sakalti.sakaplus.entity.ModEntities2;
import com.sakalti.sakaplus.item.CrystalWeapons;
import com.sakalti.sakaplus.ore.SakaPlusOreBlockItems;
import com.sakalti.sakaplus.ore.SakaPlusOreBlocks;
import com.sakalti.sakaplus.ore.SakaPlusOreWorldgen;
import com.sakalti.sakaplus.parasitory.registry.ParasitoryEntities;
import com.sakalti.sakaplus.parasitory.registry.ParasitoryItems;
import com.sakalti.sakaplus.registry.Frieds;
import com.sakalti.sakaplus.registry.abyssalite.ModAbyssaliteItems;
import com.sakalti.sakaplus.registry.emeraldium.ModEmeraldiumItems;
import com.sakalti.sakaplus.registry.gemstone.ModGemstoneItems;
import net.fabricmc.api.ModInitializer;

public class SakaPlusMod
implements ModInitializer {
    public static final String MOD_ID = "sakaplus";

    public void onInitialize() {
        Frieds.register();
        ModAbyssaliteItems.registerAll();
        ModGemstoneItems.registerAll();
        ModEmeraldiumItems.registerAll();
        SakaPlusOreBlocks.init();
        CrystalWeapons.registerCrystalWeapons();
        SakaPlusOreBlockItems.init();
        SakaPlusOreWorldgen.init();
        ModEntities.registerAll();
        ModEntities2.register();
        ModEnchantments.register();
        ParasitoryEntities.register();
        ParasitoryItems.register();
        SakaplusBlocks.register();
    }
}
