/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1366
 *  net.minecraft.class_1376
 *  net.minecraft.class_1394
 *  net.minecraft.class_1400
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2487
 *  net.minecraft.class_3730
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5819
 */
package com.sakalti.sakaplus.parasitory.entity;

import com.sakalti.sakaplus.parasitory.registry.ParasitoryItems;
import net.minecraft.class_1282;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1366;
import net.minecraft.class_1376;
import net.minecraft.class_1394;
import net.minecraft.class_1400;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_3730;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5819;

public class UgnazhiEntity
extends class_1314 {
    private long spawnTime;

    public UgnazhiEntity(class_1299<? extends class_1314> entityType, class_1937 world) {
        super(entityType, world);
        this.spawnTime = world.method_8510();
        this.field_6194 = 7;
    }

    protected void method_5959() {
        this.field_6201.method_6277(1, (class_1352)new class_1366((class_1314)this, 1.0, false));
        this.field_6201.method_6277(2, (class_1352)new class_1394((class_1314)this, 0.8));
        this.field_6201.method_6277(3, (class_1352)new class_1376((class_1308)this));
        this.field_6185.method_6277(1, (class_1352)new class_1400((class_1308)this, class_1657.class, true));
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 20.0).method_26868(class_5134.field_23721, 4.0).method_26868(class_5134.field_23717, 100.0).method_26868(class_5134.field_23719, 0.25);
    }

    public void method_5773() {
        long age;
        super.method_5773();
        if (this.field_6002.field_9236 || (age = this.field_6002.method_8510() - this.spawnTime) > 34000L) {
            // empty if block
        }
    }

    protected void method_16077(class_1282 source, boolean causedByPlayer) {
        super.method_16077(source, causedByPlayer);
        if (!this.field_6002.field_9236) {
            class_5819 random = this.method_6051();
            if (random.method_43057() < 0.11f) {
                this.method_5775(new class_1799((class_1935)ParasitoryItems.UGNAZHI_SWORD));
            }
            if (random.method_43057() < 0.25f) {
                this.method_5775(new class_1799((class_1935)ParasitoryItems.HP_UPPER));
            }
        }
    }

    public void method_5652(class_2487 nbt) {
        super.method_5652(nbt);
        nbt.method_10544("SpawnTime", this.spawnTime);
    }

    public void method_5749(class_2487 nbt) {
        super.method_5749(nbt);
        this.spawnTime = nbt.method_10537("SpawnTime");
    }

    public static boolean canSpawn(class_1299<UgnazhiEntity> type, class_1936 world, class_3730 reason, class_2338 pos, class_5819 random) {
        return world.method_8320(pos.method_10074()).method_26225();
    }
}
