package com.sakalti.sakaplus.registry;

import net.minecraft.item.Item;
import com.sakalti.sakaplus.block.ModBlocks2;
import com.sakalti.sakaplus.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import com.sakalti.sakaplus.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModItems {
    // 🟣 ブロックアイテム（食べられるbloomsquer）
    public static final Item BLOOMSQUER_ITEM = new BlockItem(ModBlocks2.BLOOMSQUER, new Item.Settings()
        .group(ItemGroup.FOOD)
        .food(ModFoods.BLOOMSQUER)
        .maxCount(16)
    );

    public static final Item HP_PLUS = new HPPlusItem(new Item.Settings().maxCount(6));

    public static final Item GLOW_BERRY_BREAD = new Item(new Item.Settings().food(ModFoods.GLOW_BERRY_BREAD));
    public static final Item HACHIWARI_MANJU = new Item(new Item.Settings().food(ModFoods.HACHIWARI_MANJU));
    public static final Item LIGHT_BERRY = new Item(new Item.Settings().food(ModFoods.LIGHT_BERRY));
    public static final Item CHOCOLATE_BAR = new Item(new Item.Settings().food(ModFoods.CHOCOLATE_BAR));
    public static final Item SWEET_BERRY_PIE = new Item(new Item.Settings().food(ModFoods.SWEET_BERRY_PIE));
    public static final Item GLOW_BERRY_DONUT = new Item(new Item.Settings().food(ModFoods.GLOW_BERRY_DONUT));
    public static final Item KUR_BRUTE_MEAT = new Item(new Item.Settings().food(ModFoods.KUR_BRUTE_MEAT));
    public static final Item TOUFU_A = new Item(new Item.Settings().food(ModFoods.TOUFU_A));

    // 🆕 ライトストーンの追加
    public static final Item LIGHT_STONE = new Item(new Item.Settings());

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "bloomsquer"), BLOOMSQUER_ITEM);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "glow_berry_bread"), GLOW_BERRY_BREAD);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "light_berry"), LIGHT_BERRY);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "kur_brute_meat"), KUR_BRUTE_MEAT);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "chocolate_bar"), CHOCOLATE_BAR);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "sweet_berry_pie"), SWEET_BERRY_PIE);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "glow_berry_donut"), GLOW_BERRY_DONUT);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "hp_plus"), HP_PLUS);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "light_stone"), LIGHT_STONE);
        Registry.register(Registry.ITEM, new Identifier("sakaplus", "toufu_a"), TOUFU_A);
    }
}
