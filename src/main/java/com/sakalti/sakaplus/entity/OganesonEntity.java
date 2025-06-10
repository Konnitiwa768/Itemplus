package com.sakalti.sakaplus.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.ai.goal.FlyGoal;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.world.World;

public class OganesonEntity extends BlazeEntity {
    private int shootTick = 0;

    public OganesonEntity(EntityType<? extends BlazeEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    // 属性: HP18, 防御2, 攻撃1, 追従距離48
    public static DefaultAttributeContainer.Builder createAttributes() {
        return BlazeEntity.createBlazeAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 18.0D)
            .add(EntityAttributes.GENERIC_ARMOR, 2.0D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0D)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.36D);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new FlyGoal(this, 1.0));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(3, new LookAtEntityGoal(this, LivingEntity.class, 8.0F));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PiglinEntity.class, true));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0, false));
    }

    @Override
    public void tick() {
        super.tick();
        if ((this.getTarget() == null || !this.getTarget().isAlive()) && !this.world.isClient) {
            this.world.getEntitiesByClass(PiglinEntity.class, this.getBoundingBox().expand(16), piglin -> true)
                .stream().findFirst().ifPresent(this::setTarget);
        }
        if (!this.world.isClient) {
            shootTick++;
            if (shootTick >= 10) { // 0.5秒ごと
                shootRadialArrows();
                shootTick = 0;
            }
        }
    }

    private void shootRadialArrows() {
        int count = 8; // 8方向
        double arrowSpeed = 2.0F;
        for (int i = 0; i < count; i++) {
            double angle = 2 * Math.PI * i / count;
            double dx = Math.cos(angle);
            double dz = Math.sin(angle);
            double dy = 0.15;

            ArrowEntity arrow = new ArrowEntity(this.world, this.getX(), this.getY() + 1, this.getZ()) {
                @Override
                protected void onHit(LivingEntity target) {
                    super.onHit(target);
                    target.hurtResistantTime = 0; // 無敵時間リセット
                }
            };
            arrow.setVelocity(dx, dy, dz, (float)arrowSpeed, 0.0F);
            arrow.setOwner(this);
            arrow.setPickupType(PersistentProjectileEntity.PickupPermission.DISALLOWED);
            arrow.setInvisible(true); // 完全透明
            arrow.setDamage(1.0D); // ダメージ1

            this.world.spawnEntity(arrow);
        }
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }
}
