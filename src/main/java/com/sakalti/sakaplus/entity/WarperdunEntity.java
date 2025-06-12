package com.sakalti.sakaplus.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class WarperdunEntity extends PathAwareEntity implements Monster {

    private final ServerBossBar bossBar;
    private int shootTick = 0;

    public WarperdunEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 1150;
        this.bossBar = new ServerBossBar(Text.literal("Warperdun"), BossBar.Color.RED, BossBar.Style.PROGRESS);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 330.0D)
            .add(EntityAttributes.GENERIC_ARMOR, 8.0D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0D)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D)
            .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.6D);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.world.isClient) {
            shootTick++;
            if (shootTick >= 10) {
                shootRadialArrows();
                shootTick = 0;
            }
            this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        }
    }

    private void shootRadialArrows() {
        int count = 8;
        double arrowSpeed = 2.0;
        for (int i = 0; i < count; i++) {
            double angle = 2 * Math.PI * i / count;
            double dx = Math.cos(angle);
            double dz = Math.sin(angle);
            double dy = 0.15;

            ArrowEntity arrow = new ArrowEntity(this.world, this.getX(), this.getY() + 1, this.getZ()) {
                @Override
                protected void onEntityHit(EntityHitResult entityHitResult) {
                    super.onEntityHit(entityHitResult);
                    if (entityHitResult.getEntity() instanceof MobEntity target) {
                        target.hurtTime = 0; // 無敵時間リセット
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

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        if (!this.world.isClient) {
            this.bossBar.clearPlayers();
        }
    }
}
