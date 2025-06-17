package com.sakalti.sakaplus.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class MudoStatusEffect extends StatusEffect {
    public static final UUID MUDO_UUID = UUID.fromString("7c112e8a-8a0b-44cc-a4fc-1136ac1be118");

    public MudoStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x551A8B); // 紫
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        EntityAttributeInstance attribute = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attribute == null) return;

        // 既存のデバフを除去
        EntityAttributeModifier existing = attribute.getModifier(MUDO_UUID);
        if (existing != null) {
            attribute.removeModifier(existing);
        }

        int level = amplifier + 1;
        double reduction = -Math.min(level, 18); // Lvに応じて最大-18まで

        EntityAttributeModifier debuff = new EntityAttributeModifier(
            MUDO_UUID,
            "mudo_max_health_debuff",
            reduction,
            EntityAttributeModifier.Operation.ADDITION
        );

        attribute.addPersistentModifier(debuff);

        // 現在のHPが最大を超えていれば調整
        if (entity.getHealth() > entity.getMaxHealth()) {
            entity.setHealth(entity.getMaxHealth());
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true; // 毎tick適用して上書き処理を確実に
    }

    @Override
    public void onRemoved(LivingEntity entity) {
        if (entity.getWorld().isClient) return;

        EntityAttributeInstance attribute = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attribute == null) return;

        EntityAttributeModifier existing = attribute.getModifier(MUDO_UUID);
        if (existing != null) {
            attribute.removeModifier(existing);
        }
    }
}
