package com.sakalti.sakaplus.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class MudoStatusEffect extends StatusEffect {
    // HPPlusItem と干渉しないよう別UUIDを使う
    public static final UUID MUDO_UUID = UUID.fromString("b8db37c0-6722-4f92-98f5-c0a4c6c9ae32");

    public MudoStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x551A8B); // 紫色
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        EntityAttributeInstance attribute = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attribute == null) return;

        // 一度だけ反映すればよい（常にremove→addする必要なし）
        EntityAttributeModifier existing = attribute.getModifier(MUDO_UUID);
        int desiredReduction = Math.min(amplifier + 1, 18);

        if (existing != null) {
            // 値が合っていれば再適用不要
            if (existing.getValue() == -desiredReduction) return;

            attribute.removeModifier(existing);
        }

        EntityAttributeModifier modifier = new EntityAttributeModifier(
            MUDO_UUID,
            "mudo_hp_penalty",
            -desiredReduction,
            EntityAttributeModifier.Operation.ADDITION
        );
        attribute.addPersistentModifier(modifier);

        // 現在体力が最大を上回っていたら調整
        if (entity.getHealth() > entity.getMaxHealth()) {
            entity.setHealth(entity.getMaxHealth());
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true; // 毎tick確認（新Lvに変化時などを確実に反映）
    }

    @Override
    public void onRemoved(LivingEntity entity) {
        if (entity.getWorld().isClient) return;

        EntityAttributeInstance attribute = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attribute == null) return;

        EntityAttributeModifier modifier = attribute.getModifier(MUDO_UUID);
        if (modifier != null) {
            attribute.removeModifier(modifier);
        }
    }
}
