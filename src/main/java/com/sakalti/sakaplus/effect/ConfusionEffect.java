package com.sakalti.sakaplus.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

import java.util.Random;

public class ConfusionEffect extends StatusEffect {
    private final Random random = new Random();

    public ConfusionEffect() {
        super(StatusEffectCategory.HARMFUL, 0xE8A4FF); // 色は自由にどうぞ
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true; // 毎 tick 実行
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        int level = amplifier + 1; // lv1〜

        /* -----------------------------
         * 体力減少：lv1=1, lv2=2, lv3=3 …
         * ----------------------------- */
        entity.damage(entity.getDamageSources().magic(), level);

        /* -----------------------------
         * 攻撃力低下：レベル^1.35 減少
         * ----------------------------- */
        double reduction = Math.pow(level, 1.35);
        var attack = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attack != null) {
            double base = attack.getBaseValue();
            attack.setBaseValue(Math.max(0, base - reduction));
        }

        /* -----------------------------
         * 7.7%：勝手にジャンプ
         * ----------------------------- */
        if (random.nextFloat() < 0.077F) {
            entity.jump();
        }

        /* -----------------------------
         * 9.4%：2〜5ブロック前進（貫通）
         * ----------------------------- */
        if (random.nextFloat() < 0.094F) {
            double forward = 2 + random.nextInt(4); // 2〜5
            entity.addVelocity(
                    -Math.sin(Math.toRadians(entity.getYaw())) * forward,
                    0,
                    Math.cos(Math.toRadians(entity.getYaw())) * forward
            );
            entity.velocityDirty = true;
        }

        /* -----------------------------
         * 12.8%：左クリック（攻撃）
         * ----------------------------- */
        if (entity instanceof PlayerEntity player) {
            if (random.nextFloat() < 0.128F) {
                player.attack(player.getAttacker() != null ? player.getAttacker() : entity);
            }

            /* -----------------------------
             * 5.4%：右クリック（使用）
             * ----------------------------- */
            if (random.nextFloat() < 0.054F) {
                player.useItem(player.getWorld(), player.getStackInHand(Hand.MAIN_HAND), Hand.MAIN_HAND);
            }
        }

        /* -----------------------------
         * 18〜35秒：視点をランダム回転
         * ----------------------------- */
        int duration = entity.getStatusEffect(this).getDuration();
        if (duration <= 35 * 20 && duration >= 18 * 20) {
            float yaw = entity.getYaw() + (random.nextFloat() * 60 - 30);  // ±30度
            float pitch = entity.getPitch() + (random.nextFloat() * 40 - 20); // ±20度
            entity.setYaw(yaw);
            entity.setPitch(pitch);
        }

        /* -----------------------------
         * 39〜45秒：定期ダメージ（lvごと速度変化）
         * lv1: 1秒
         * lv2: 0.9秒
         * lv3: 0.85秒
         * lv4: 0.825秒
         * ----------------------------- */
        if (duration <= 45 * 20 && duration >= 39 * 20) {
            double interval;
            switch (level) {
                case 1 -> interval = 20;
                case 2 -> interval = 18;
                case 3 -> interval = 17;
                case 4 -> interval = 16.5;
                default -> interval = 20;
            }

            if (duration % (int) interval == 0) {
                entity.damage(entity.getDamageSources().magic(), 3);
            }
        }
    }
}
