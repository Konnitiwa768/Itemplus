package com.sakalti.sakaplus;

import net.fabricmc.api.ModInitializer;

// レジストリ（sakaplus固有）
import com.sakalti.sakaplus.registry.Frieds;
import com.sakalti.sakaplus.registry.abyssalite.ModAbyssaliteItems;
import com.sakalti.sakaplus.registry.gemstone.ModGemstoneItems;

public class SakaPlusMod implements ModInitializer {
    public static final String MOD_ID = "sakaplus";

    @Override
    public void onInitialize() {
        // フレンド（味方）系の登録
        Frieds.register();

        // アビサライト素材の一括登録
        ModAbyssaliteItems.registerAll();

        // 宝石素材の一括登録
        ModGemstoneItems.registerAll();
    }
}
