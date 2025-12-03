package com.sakalti.sakaplus.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;

import java.util.Random;

public class ChaosConfusionEffect extends StatusEffect {
    private final Random random = new Random();

    public ChaosConfusionEffect() {
        super(StatusEffectCategory.HARMFUL, 0xFF0000); // 赤色
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true; // 毎 tick発動
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getWorld().isClient) return;

        int level = amplifier + 1;

        // 体力減少
        entity.damage(entity.getDamageSources().magic(), level);

        // 攻撃力低下
        var attack = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (attack != null) {
            double reduction = Math.pow(level, 1.35);
            double base = attack.getBaseValue();
            attack.setBaseValue(Math.max(0, base - reduction));
        }

        // 7.7%: 勝手にジャンプ（velocity操作）
        if (random.nextFloat() < 0.077F && entity.isOnGround()) {
            entity.setVelocity(entity.getVelocity().x, 0.42D, entity.getVelocity().z); // ジャンプ高さ0.42
            entity.velocityDirty = true;
            entity.getWorld().playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, entity.getSoundCategory(), 0.5F, 1.2F);
        }

        // 9.4%: 前方に2〜5ブロック移動
        if (random.nextFloat() < 0.094F) {
            double forward = 2 + random.nextInt(4);
            float yawRad = (float) Math.toRadians(entity.getYaw());
            entity.addVelocity(-Math.sin(yawRad) * forward, 0, Math.cos(yawRad) * forward);
            entity.velocityDirty = true;
        }

        // 12.8%: 自動攻撃（周囲にダメージ）
        if (random.nextFloat() < 0.128F) {
            // 周囲1ブロックのLivingEntityにランダムダメージ
            entity.getWorld().getEntitiesByClass(LivingEntity.class, entity.getBoundingBox().expand(1), e -> e != entity)
                    .forEach(e -> e.damage(entity.getDamageSources().magic(), 2));
        }

        // 5.4%: 自動アイテム使用（MAIN_HANDを消費せずに再生）
        if (entity instanceof PlayerEntity player && random.nextFloat() < 0.054F) {
            player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.ENTITY_ITEM_PICKUP, player.getSoundCategory(), 0.5F, 1.0F);
        }

        // 18〜35秒: 視点カオス
        int duration = entity.getStatusEffect(this).getDuration();
        if (duration <= 35 * 20 && duration >= 18 * 20) {
            float yaw = entity.getYaw() + (random.nextFloat() * 120 - 60);
            float pitch = entity.getPitch() + (random.nextFloat() * 80 - 40);
            entity.setYaw(yaw);
            entity.setPitch(pitch);
        }

        // 39〜45秒: 定期ダメージ lvごとに速度変化
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

        // 5%: ランダムテレポート（±3ブロック）
        if (random.nextFloat() < 0.05F) {
            World world = entity.getWorld();
            double x = entity.getX() + (random.nextDouble() * 6 - 3);
            double y = entity.getY();
            double z = entity.getZ() + (random.nextDouble() * 6 - 3);
            entity.requestTeleport(x, y, z);
            world.spawnParticles(ParticleTypes.CRIT, x, y + 1, z, 10, 0.5, 0.5, 0.5, 0.1);
        }

        // 15%: パーティクル＋効果音
        if (random.nextFloat() < 0.15F) {
            World world = entity.getWorld();
            world.spawnParticles(ParticleTypes.ASH, entity.getX(), entity.getY() + 1, entity.getZ(), 5, 0.3, 0.3, 0.3, 0.05);
            world.playSound(null, entity.getBlockPos(), SoundEvents.BLOCK_ANVIL_LAND, entity.getSoundCategory(), 0.3F, 1.5F);
        }
    }
}
