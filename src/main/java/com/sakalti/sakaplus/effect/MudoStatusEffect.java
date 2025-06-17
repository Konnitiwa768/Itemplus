package com.sakalti.sakaplus.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class MudoStatusEffect extends StatusEffect {
    public static final UUID MUDO_UUID = UUID.fromString("43cde614-d5a9-445c-a7e2-b2d9a2fd7abc");

    public MudoStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x551A8B); // 紫色系のデバフ色
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient) {
            int level = amplifier + 1;
            double maxReduction = Math.min(level, 18); // 上限：10ポイント

            // 既存の修正があれば削除
            if (entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH) != null) {
                entity.getAttributes().removeModifier(EntityAttributes.GENERIC_MAX_HEALTH, MUDO_UUID);

                // 新しい修正を適用
                EntityAttributeModifier modifier = new EntityAttributeModifier(
                    MUDO_UUID,
                    "mudo_max_health_debuff",
                    -maxReduction,
                    EntityAttributeModifier.Operation.ADDITION
                );
                entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addPersistentModifier(modifier);

                // 現在の体力が最大体力を上回っていれば調整
                double newMax = entity.getMaxHealth();
                if (entity.getHealth() > newMax) {
                    entity.setHealth((float) newMax);
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // 毎tick更新して最大体力デバフを維持
        return true;
    }

    @Override
    public void onRemoved(LivingEntity entity) {
        if (!entity.getWorld().isClient) {
            if (entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH) != null) {
                entity.getAttributes().removeModifier(EntityAttributes.GENERIC_MAX_HEALTH, MUDO_UUID);
            }
        }
        super.onRemoved(entity);
    }
}
