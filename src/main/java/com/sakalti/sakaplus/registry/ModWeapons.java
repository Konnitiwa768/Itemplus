package com.sakalti.sakaplus;

import com.sakalti.sakaplus.item.LightningStinger;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModWeapons {
    public static final Item LIGHTNING_STINGER = new LightningStinger();

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "lightning_stinger"), LIGHTNING_STINGER);
    }
}
