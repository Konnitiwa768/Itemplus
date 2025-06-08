package com.sakalti.sakaplus.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks2 {
    public static final Block IRON_SCAFFOLD = new IronScaffoldBlock();

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("sakaplus", "iron_scaffold"), IRON_SCAFFOLD);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "iron_scaffold"),
            new BlockItem(IRON_SCAFFOLD, new FabricItemSettings()));
    }
}
