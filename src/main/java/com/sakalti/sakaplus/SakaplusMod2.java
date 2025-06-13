package com.sakalti.sakaplus;

import net.fabricmc.api.ModInitializer;
import com.sakalti.sakaplus.command.KruzivilimCommand;
import com.sakalti.sakaplus.registry.ModEntities;
import com.sakalti.sakaplus.dimension.SakaplusDimensions;
import com.sakalti.sakaplus.block.ModBlocks2;
import com.sakalti.sakaplus.registry.ModItems;

public class SakaplusMod2 implements ModInitializer {
    @Override
    public void onInitialize() {
        ModBlocks2.registerBlocks();
        ModEntities.register();
        ModItems.register();
        SakaplusDimensions.register();
            KruzivilimCommand.register(dispatcher);
    }
}
