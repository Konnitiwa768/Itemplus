package com.sakalti.sakaplus.tinco.client;

import com.sakalti.sakaplus.tinco.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;

public class TincoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.ASSEMBLED_TOOL, new AssembledToolRenderer());
    }
}
