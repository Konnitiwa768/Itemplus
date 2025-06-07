package com.sakalti.sakaplus.parasitory.entity;

import com.sakalti.sakaplus.parasitory.registry.ParasitoryItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.entity.damage.DamageSource;

public class ShiberEntity extends PathAwareEntity {

    public ShiberEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 10;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.15, false));
        this.goalSelector.add(2, new SwimAroundGoal(this, 1.2, 40)); // 水泳移動
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 54.0)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14.0)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.27)
            .add(EntityAttributes.GENERIC_SWIM_SPEED, 1.4); // 泳ぎが速い
    }

    @Override
    public boolean canBreatheInWater() {
        return true; // 水中で呼吸可能
    }

    @Override
    public boolean isPushedByFluids() {
        return false; // 水流で流されない
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.isTouchingWater()) {
            this.updateVelocity(0.02F, movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9D));
        } else {
            super.travel(movementInput);
        }
    }

    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);
        if (!this.world.isClient) {
            Random random = this.getRandom();

            // 例：13%でShiber Sword
            if (random.nextFloat() < 0.13f) {
                this.dropStack(new ItemStack(ParasitoryItems.SHIBER_SWORD));
            }

            // 25%でHPアッパー
            if (random.nextFloat() < 0.25f) {
                this.dropStack(new ItemStack(ParasitoryItems.HP_UPPER));
            }
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        // 特に追加データなし
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        // 特に追加データなし
    }

    public static boolean canSpawn(EntityType<ShiberEntity> type, WorldAccess world, SpawnReason reason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isOpaque();
    }
}
