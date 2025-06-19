package com.sakalti.sakaplus.registry;

import net.minecraft.item.FoodComponent;
import com.sakalti.sakaplus.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoods {
    public static final FoodComponent GLOW_BERRY_BREAD = new FoodComponent.Builder().hunger(13).saturationModifier(3.9f).build();
    public static final FoodComponent CHOCOLATE_BAR = new FoodComponent.Builder().hunger(8).saturationModifier(2.6f).build();
    // ここから追加
    public static final FoodComponent SWEET_BERRY_PIE = new FoodComponent.Builder()
        .hunger(7) // コスパ良く
        .saturationModifier(4.5f)
        .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 1), 1.0f) // 3秒=60tick, 再生II
        .build();
    public static final FoodComponent KUR_BRUTE_MEAT = new FoodComponent.Builder()
        .hunger(13) // コスパ良く
        .saturationModifier(15.5f)
        .statusEffect(new StatusEffectInstance(ModEffects.LIGHT_BLOCK, 40, 3), 1.0f) // 3秒=60tick, 再生II
        .build();
    public static final FoodComponent LIGHT_BERRY = new FoodComponent.Builder()
        .hunger(4) // コスパ良く
        .saturationModifier(4.5f)
        .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 400, 4), 1.0f) // 3秒=60tick, 再生II
        .build();
    public static final FoodComponent GLOW_BERRY_DONUT = new FoodComponent.Builder()
        .hunger(5) // コスパ良く
        .saturationModifier(4.4f)
        .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 110, 1), 1.0f) // 5.5秒=110tick, 耐性II
        .build();
}
