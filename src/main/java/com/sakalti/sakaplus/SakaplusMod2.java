package com.sakalti.sakaplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import com.sakalti.sakaplus.command.KruzivilimCommand;
import com.sakalti.sakaplus.registry.ModEntities33;
import com.sakalti.sakaplus.registry.Weapons;
import com.sakalti.sakaplus.dimension.SakaplusDimensions;
import com.sakalti.sakaplus.block.ModBlocks2;
import com.sakalti.sakaplus.registry.ModItems;

public class SakaplusMod2 implements ModInitializer {
    @Override
    public void onInitialize() {
        ModBlocks2.registerBlocks();
        Weapons.registerItems();
        ModEntities33.register();
        ModItems.register();
        SakaplusDimensions.register();

        // コマンドの登録（Fabric API v2）
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            KruzivilimCommand.register(dispatcher);
        });
    }
}
