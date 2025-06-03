package com.sakalti.sakaplus.registry;

import com.sakalti.sakaplus.SakaPlusMod;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Frieds {

    public static final Item RAW_FRIES = new Item(new Item.Settings().food(
            new FoodComponent.Builder().hunger(2).build()
    ));

    public static final Item FRIES = new Item(new Item.Settings().food(
            new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).build()
    ));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(SakaPlusMod.MOD_ID, "raw_fries"), RAW_FRIES);
        Registry.register(Registry.ITEM, new Identifier(SakaPlusMod.MOD_ID, "fries"), FRIES);
    }
}
