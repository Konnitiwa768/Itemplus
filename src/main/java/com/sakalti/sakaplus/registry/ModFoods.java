package com.sakalti.sakaplus.registry;

import net.minecraft.item.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoods {
    public static final FoodComponent GLOW_BERRY_BREAD = new FoodComponent.Builder().hunger(13).saturationModifier(0.9f).build();
    public static final FoodComponent CHOCOLATE_BAR = new FoodComponent.Builder().hunger(8).saturationModifier(0.6f).build();
    // ここから追加
    public static final FoodComponent SWEET_BERRY_PIE = new FoodComponent.Builder()
        .hunger(7) // コスパ良く
        .saturationModifier(0.8f)
        .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 1), 1.0f) // 3秒=60tick, 再生II
        .build();
}
