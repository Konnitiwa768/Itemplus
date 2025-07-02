package com.sakalti.sakaplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import com.sakalti.sakaplus.tinco.item.ModItems5;
import com.sakalti.sakaplus.tinco.client.AssembledToolBakedModel;
import com.sakalti.sakaplus.command.KruzivilimCommand;
import com.sakalti.sakaplus.registry.ModEntities333;
import com.sakalti.sakaplus.registry.Weapons;
import com.sakalti.sakaplus.dimension.SakaplusDimensions;
import com.sakalti.sakaplus.block.ModBlocks2;
import com.sakalti.sakaplus.registry.ModItems;

public class SakaplusMod2 implements ModInitializer {
    @Override
    public void onInitialize() {
        ModBlocks2.registerBlocks();
        ModelLoadingRegistry.INSTANCE.registerResourceProvider(manager -> (resourceId, context) -> {
            if (resourceId.getNamespace().equals("tinco") && resourceId.getPath().equals("assembled_tool")) {
            return new AssembledToolBakedModel();
            }
          return null;
        });
        Weapons.registerItems();
        ModEntities333.register();
        ModItems.register();
        SakaplusDimensions.register();
        ModItems5.register();
        // コマンドの登録（Fabric API v2）
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            KruzivilimCommand.register(dispatcher);
        });
    }
}
