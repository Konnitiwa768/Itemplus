package com.sakalti.sakaplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SakaModelProvider extends FabricModelProvider {
    public SakaModelProvider(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Identifier id : Registry.ITEM.getIds()) {
            Item item = Registry.ITEM.get(id);
            if (item instanceof BlockItem) continue; // BlockItemはBlock側で処理
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (Identifier id : Registry.BLOCK.getIds()) {
            Block block = Registry.BLOCK.get(id);
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }
    }
}
