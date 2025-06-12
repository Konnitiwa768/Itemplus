package com.sakalti.sakaplus.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks2 {
    public static final Block IRON_SCAFFOLD = new IronScaffoldBlock();

    // kruzi_stone ブロックを追加
    public static final Block KRUZI_STONE = new Block(AbstractBlock.Settings
        .of(Material.STONE)
        .strength(2.0f, 6.0f) // 硬さ2.0f、爆破耐性6.0f（石とほぼ同じ）
        .requiresTool()       // 適切なツールで採掘必要
    );

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("sakaplus", "iron_scaffold"), IRON_SCAFFOLD);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "iron_scaffold"),
            new BlockItem(IRON_SCAFFOLD, new FabricItemSettings()));

        Registry.register(Registry.BLOCK, new Identifier("sakaplus", "kruzi_stone"), KRUZI_STONE);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "kruzi_stone"),
            new BlockItem(KRUZI_STONE, new FabricItemSettings()));
    }
}
