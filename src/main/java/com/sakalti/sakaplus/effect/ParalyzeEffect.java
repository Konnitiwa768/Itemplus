package com.sakalti.sakaplus.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;

public class ParalyzeEffect extends StatusEffect {
    public ParalyzeEffect() {
        super(StatusEffectCategory.HARMFUL, 0xAAAAFF); // 薄い青紫色
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        // ここはtickごとに特殊な処理を入れたい場合
        // プレイヤーの動きを止める処理はクライアント側で!
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return false;
    }
}
