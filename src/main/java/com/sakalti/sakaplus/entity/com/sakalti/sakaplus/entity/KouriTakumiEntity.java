/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1347
 *  net.minecraft.class_1352
 *  net.minecraft.class_1361
 *  net.minecraft.class_1366
 *  net.minecraft.class_1376
 *  net.minecraft.class_1384
 *  net.minecraft.class_1394
 *  net.minecraft.class_1400
 *  net.minecraft.class_1548
 *  net.minecraft.class_1657
 *  net.minecraft.class_1927$class_4179
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_3218
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 */
package com.sakalti.sakaplus.entity;

import com.sakalti.sakaplus.mixin.CreeperEntityAccessor;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1347;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1366;
import net.minecraft.class_1376;
import net.minecraft.class_1384;
import net.minecraft.class_1394;
import net.minecraft.class_1400;
import net.minecraft.class_1548;
import net.minecraft.class_1657;
import net.minecraft.class_1927;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_3218;
import net.minecraft.class_5132;
import net.minecraft.class_5134;

public class KouriTakumiEntity
extends class_1548 {
    private boolean frozenExploded = false;

    public KouriTakumiEntity(class_1299<? extends class_1548> entityType, class_1937 world) {
        super(entityType, world);
        this.method_7005(1);
    }

    protected void method_5959() {
        this.field_6201.method_6277(1, (class_1352)new class_1347((class_1308)this));
        this.field_6201.method_6277(2, (class_1352)new class_1384((class_1314)this));
        this.field_6201.method_6277(3, (class_1352)new class_1366((class_1314)this, 1.0, false));
        this.field_6201.method_6277(4, (class_1352)new class_1394((class_1314)this, 1.0));
        this.field_6201.method_6277(5, (class_1352)new class_1361((class_1308)this, class_1657.class, 8.0f));
        this.field_6201.method_6277(6, (class_1352)new class_1376((class_1308)this));
        this.field_6185.method_6277(1, (class_1352)new class_1400((class_1308)this, class_1657.class, true));
    }

    public static class_5132.class_5133 createKouriTakumiAttributes() {
        return class_1548.method_26828().method_26868(class_5134.field_23716, 22.0).method_26868(class_5134.field_23724, 7.0).method_26868(class_5134.field_23717, 50.0).method_26868(class_5134.field_23719, 0.36);
    }

    public void method_5773() {
        super.method_5773();
        if (!this.method_37908().field_9236 && !this.frozenExploded) {
            try {
                CreeperEntityAccessor accessor = (CreeperEntityAccessor)((Object)this);
                int currentFuse = accessor.getCurrentFuseTime();
                int fuseTime = accessor.getFuseTime();
                if (this.method_7007() > 0 && currentFuse >= fuseTime - 1) {
                    this.frozenExploded = true;
                    float radius = accessor.getExplosionRadius();
                    this.onFrozenExplode(radius);
                }
            }
            catch (Exception e) {
                System.err.println("Failed to access CreeperEntity internals: " + e.getMessage());
            }
        }
    }

    private void onFrozenExplode(float explosionRadius) {
        class_1309 class_13092 = this.method_5968();
        if (!(class_13092 instanceof class_1657)) {
            return;
        }
        class_1657 target = (class_1657)class_13092;
        class_3218 world = (class_3218)this.method_37908();
        class_2338 center = target.method_24515();
        for (int dx = -2; dx <= 2; ++dx) {
            for (int dy = 0; dy <= 2; ++dy) {
                for (int dz = -2; dz <= 2; ++dz) {
                    class_2338 pos = center.method_10069(dx, dy, dz);
                    if (!world.method_22347(pos) && !world.method_8320(pos).method_26207().method_15800()) continue;
                    world.method_8501(pos, class_2246.field_10225.method_9564());
                }
            }
        }
        world.method_8537(null, (double)center.method_10263() + 0.5, (double)center.method_10264(), (double)center.method_10260() + 0.5, explosionRadius, false, class_1927.class_4179.field_18685);
        this.method_31472();
    }
}
