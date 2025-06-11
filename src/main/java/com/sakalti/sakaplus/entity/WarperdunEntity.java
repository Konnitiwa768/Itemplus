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
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class WarperdunEntity extends BlazeEntity {
    private int shootTick = 0;

    public WarperdunEntity(EntityType<? extends BlazeEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 1150;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return BlazeEntity.createBlazeAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 330.0D)
            .add(EntityAttributes.GENERIC_ARMOR, 8.0D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0D)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.22D);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(1, new FlyGoal(this, 1.0));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(3, new LookAtEntityGoal(this, LivingEntity.class, 8.0F));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, LivingEntity.class, true));
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
            if (shootTick >= 10) {
                shootRadialArrows();
                shootTick = 0;
            }
        }
    }

    private void shootRadialArrows() {
        int count = 8;
        double arrowSpeed = 2.0F;
        for (int i = 0; i < count; i++) {
            double angle = 2 * Math.PI * i / count;
            double dx = Math.cos(angle);
            double dz = Math.sin(angle);
            double dy = 0.15;

            ArrowEntity arrow = new ArrowEntity(this.world, this.getX(), this.getY() + 1, this.getZ()) {
                @Override
                protected void onEntityHit(EntityHitResult entityHitResult) {
                    super.onEntityHit(entityHitResult);
                    if (entityHitResult.getEntity() instanceof LivingEntity target) {
                        // hurtTimeはパブリック/protected
                        target.hurtTime = 0; // 直後のダメージで無敵時間をリセット
                    }
                }
            };
            arrow.setVelocity(dx, dy, dz, (float)arrowSpeed, 0.0F);
            arrow.setOwner(this);
            if (arrow instanceof PersistentProjectileEntity) {
                ((PersistentProjectileEntity)arrow).pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
            }
            arrow.setInvisible(true);
            arrow.setDamage(3.0D);

            this.world.spawnEntity(arrow);
        }
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }
}
