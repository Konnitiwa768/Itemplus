/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3532
 *  net.minecraft.class_5597
 *  net.minecraft.class_5603
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_630
 */
package com.sakalti.sakaplus.parasitory.client.model;

import com.sakalti.sakaplus.parasitory.entity.UgnazhiEntity;
import net.minecraft.class_3532;
import net.minecraft.class_5597;
import net.minecraft.class_5603;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_630;

public class UgnazhiModel
extends class_5597<UgnazhiEntity> {
    private final class_630 root;
    private final class_630 body;
    private final class_630[] leftLegs = new class_630[3];
    private final class_630[] rightLegs = new class_630[3];

    public UgnazhiModel(class_630 root) {
        this.root = root;
        this.body = root.method_32086("body");
        for (int i = 0; i < 3; ++i) {
            this.leftLegs[i] = this.body.method_32086("left_leg_" + i);
            this.rightLegs[i] = this.body.method_32086("right_leg_" + i);
        }
    }

    public static class_5607 getTexturedModelData() {
        class_5609 data = new class_5609();
        class_5610 root = data.method_32111();
        class_5610 body = root.method_32117("body", class_5606.method_32108().method_32101(0, 0).method_32097(-4.0f, -4.0f, -4.0f, 8.0f, 8.0f, 8.0f), class_5603.method_32090((float)0.0f, (float)16.0f, (float)0.0f));
        for (int i = 0; i < 3; ++i) {
            body.method_32117("left_leg_" + i, class_5606.method_32108().method_32101(0, 16).method_32097(0.0f, 0.0f, -1.0f, 6.0f, 1.0f, 2.0f), class_5603.method_32091((float)4.0f, (float)0.0f, (float)(-3.0f + (float)(i * 3)), (float)0.0f, (float)0.0f, (float)0.0f));
            body.method_32117("right_leg_" + i, class_5606.method_32108().method_32101(0, 19).method_32097(-6.0f, 0.0f, -1.0f, 6.0f, 1.0f, 2.0f), class_5603.method_32091((float)-4.0f, (float)0.0f, (float)(-3.0f + (float)(i * 3)), (float)0.0f, (float)0.0f, (float)0.0f));
        }
        return class_5607.method_32110((class_5609)data, (int)64, (int)32);
    }

    public void setAngles(UgnazhiEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        for (int i = 0; i < 3; ++i) {
            float swing;
            this.leftLegs[i].field_3654 = swing = class_3532.method_15362((float)(limbAngle * 1.5f + (float)i)) * limbDistance * 1.2f;
            this.rightLegs[i].field_3654 = -swing;
        }
    }

    public class_630 method_32008() {
        return this.root;
    }
}
