package com.sakalti.sakaplus.registry;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item GLOW_BERRY_BREAD = new Item(new Item.Settings().food(ModFoods.GLOW_BERRY_BREAD));
    public static final Item CHOCOLATE_BAR = new Item(new Item.Settings().food(ModFoods.CHOCOLATE_BAR));
    // ここから追加
    public static final Item SWEET_BERRY_PIE = new Item(new Item.Settings().food(ModFoods.SWEET_BERRY_PIE));
    public static final Item GLOW_BERRY_DONUT = new Item(new Item.Settings().food(ModFoods.GLOW_BERRY_DONUT));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "glow_berry_bread"), GLOW_BERRY_BREAD);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "chocolate_bar"), CHOCOLATE_BAR);
        // ここから追加
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "sweet_berry_pie"), SWEET_BERRY_PIE);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "glow_berry_donut"), GLOW_BERRY_DONUT);
    }
}
