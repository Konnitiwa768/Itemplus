package com.sakalti.sakaplus.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item GLOW_BERRY_BREAD = new Item(new Item.Settings().food(ModFoods.GLOW_BERRY_BREAD));
    public static final Item CHOCOLATE_BAR = new Item(new Item.Settings().food(ModFoods.CHOCOLATE_BAR));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(SakaPlusMod.MOD_ID, "glow_berry_bread"), GLOW_BERRY_BREAD);
        Registry.register(Registry.ITEM, new Identifier(SakaPlusMod.MOD_ID, "chocolate_bar"), CHOCOLATE_BAR);
    }
}
