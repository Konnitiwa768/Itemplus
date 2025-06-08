package com.sakalti.sakaplus.block;

import net.minecraft.block.ScaffoldingBlock;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock;

public class IronScaffoldBlock extends ScaffoldingBlock {
    public IronScaffoldBlock() {
        super(AbstractBlock.Settings.of(Material.METAL)
            .strength(2.5f, 10.0f)
            .requiresTool()
            .nonOpaque()
        );
    }
}
