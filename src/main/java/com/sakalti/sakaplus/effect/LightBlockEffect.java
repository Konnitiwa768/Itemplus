package com.sakalti.sakaplus.effect;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;

public class LightBlockEffect extends StatusEffects {
    public LightBlockEffect() {
        super(StatusEffectCategory.HARMFUL, 0xFFFFFF); // 白色
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        // ここでは特別なtick処理は不要
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}
