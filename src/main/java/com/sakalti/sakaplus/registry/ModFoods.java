package com.sakalti.sakaplus.registry;

import net.minecraft.item.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import com.sakalti.sakaplus.effect.ModEffects;

public class ModFoods {
    public static final FoodComponent GLOW_BERRY_BREAD = new FoodComponent.Builder()
        .hunger(13)
        .saturationModifier(3.9f)
        .build();
    
    public static final FoodComponent TOUFU_A = new FoodComponent.Builder()
        .hunger(4)
        .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 140, 1), 1.0f)
        .saturationModifier(5.0f)
        .build();

    public static final FoodComponent CHOCOLATE_BAR = new FoodComponent.Builder()
        .hunger(8)
        .saturationModifier(2.6f)
        .build();

    public static final FoodComponent SWEET_BERRY_PIE = new FoodComponent.Builder()
        .hunger(7)
        .saturationModifier(4.5f)
        .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 1), 1.0f)
        .build();

    public static final FoodComponent KUR_BRUTE_MEAT = new FoodComponent.Builder()
        .hunger(13)
        .saturationModifier(15.5f)
        .statusEffect(new StatusEffectInstance(ModEffects.LIGHT_BLOCK, 40, 3), 1.0f)
        .build();

    public static final FoodComponent LIGHT_BERRY = new FoodComponent.Builder()
        .hunger(4)
        .saturationModifier(4.5f)
        .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 400, 4), 1.0f)
        .build();

    public static final FoodComponent GLOW_BERRY_DONUT = new FoodComponent.Builder()
        .hunger(5)
        .saturationModifier(4.4f)
        .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 110, 1), 1.0f)
        .build();
    
    public static final FoodComponent HACHIWARI_MANJU = new FoodComponent.Builder()
        .hunger(12)
        .saturationModifier(8.4f)
        .statusEffect(new StatusEffectInstance(ModEffects.CRYSTAL, 200, 1), 1.0f)
        .build();

    public static final FoodComponent BLOOMSQUER = new FoodComponent.Builder()
        .hunger(6)
        .saturationModifier(10.0f)
        .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 10, 4), 1.0f)
        .build();
}
