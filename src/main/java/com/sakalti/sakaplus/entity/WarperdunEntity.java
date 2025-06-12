package com.sakalti.sakaplus.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Random;

public class WarperdunEntity extends FlyingEntity implements Monster {

    private final ServerBossBar bossBar;
    private int shootTick = 0;

    public WarperdunEntity(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 1150;
        this.bossBar = new ServerBossBar(Text.literal("Warperdun"));
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
    protected void initGoals() {
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.add(3, new MeleeAttackGoal(this, 1.0, false));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
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
            double dx = MathHelper.cos((float) angle);
            double dz = MathHelper.sin((float) angle);
            double dy = 0.15;

            ArrowEntity arrow = new ArrowEntity(this.world, this.getX(), this.getY() + 1, this.getZ());
            arrow.setVelocity(dx, dy, dz, (float) arrowSpeed, 0.0F);
            arrow.setOwner(this);
            arrow.setInvisible(true);
            arrow.setDamage(3.0D);

            if (arrow instanceof PersistentProjectileEntity projectile) {
                projectile.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
            }

            this.world.spawnEntity(arrow);
        }
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    protected void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    protected void onStoppedTrackingBy(ServerPlayerEntity player) {
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

    //public static boolean canSpawn(EntityType<WarperdunEntity> type, WorldAccess world, SpawnReason reason, BlockPos pos, Random random) {
    //    return world.getDifficulty() != Difficulty.PEACEFUL
    //       && world.getBlockState(pos.down()).isSolidBlock(world, pos.down());
    //}
}
