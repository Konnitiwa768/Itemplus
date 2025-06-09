package com.sakalti.sakaplus.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class ScorcherEntity extends BlazeEntity {
    public ScorcherEntity(EntityType<? extends BlazeEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    // 属性（アトリビュート）定義
    public static DefaultAttributeContainer.Builder createAttributes() {
        return BlazeEntity.createBlazeAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.0D)
                .add(EntityAttributes.GENERIC_SPEED, 0.36D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40.0D);
    }

    @Override
    public void tick() {
        super.tick();
        // ピグリン優先ターゲット
        if ((this.getTarget() == null || !this.getTarget().isAlive()) && !this.world.isClient) {
            this.world.getEntitiesByClass(PiglinEntity.class, this.getBoundingBox().expand(16), piglin -> true)
                    .stream().findFirst().ifPresent(this::setTarget);
        }
    }
    @Override
    public boolean isFireImmune() {
      return true;
    }
    // デバッグ用ドロップ（LootTable推奨）
    @Override
    protected void dropLoot(DamageSource source, boolean causedByPlayer) {
        super.dropLoot(source, causedByPlayer);
        this.dropItem(Items.CRIMSON_STEM, this.random.nextBetween(1, 3));
        if (this.random.nextFloat() < 0.3f) {
            this.dropItem(Items.GHAST_TEAR, 1);
        }
    }
}
