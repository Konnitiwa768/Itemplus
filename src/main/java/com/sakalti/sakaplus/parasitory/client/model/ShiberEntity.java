package com.sakalti.sakaplus.parasitory.client.model;

import net.minecraft.class_1297;
import net.minecraft.class_3532;
import net.minecraft.class_5610;
import net.minecraft.class_5603;
import net.minecraft.class_5606;
import net.minecraft.class_5609;
import net.minecraft.class_5607;
import net.minecraft.class_630;
import com.sakalti.sakaplus.parasitory.entity.ShiberEntity; // ←ShiberEntityに合わせて
import net.minecraft.class_5597;

public class ShiberModel extends class_5597<ShiberEntity> {
    private final class_630 root;
    private final class_630 joint1;
    private final class_630 joint2;
    private final class_630[] leftLegs1;
    private final class_630[] rightLegs1;
    private final class_630[] leftLegs2;
    private final class_630[] rightLegs2;

    public ShiberModel(final class_630 root) {
        this.leftLegs1 = new class_630[3];
        this.rightLegs1 = new class_630[3];
        this.leftLegs2 = new class_630[3];
        this.rightLegs2 = new class_630[3];
        this.root = root;
        this.joint1 = root.method_32086("joint1");
        this.joint2 = root.method_32086("joint2");
        for (int i = 0; i < 3; ++i) {
            this.leftLegs1[i] = this.joint1.method_32086("left_leg1_" + i);
            this.rightLegs1[i] = this.joint1.method_32086("right_leg1_" + i);
            this.leftLegs2[i] = this.joint2.method_32086("left_leg2_" + i);
            this.rightLegs2[i] = this.joint2.method_32086("right_leg2_" + i);
        }
    }

    public static class_5607 getTexturedModelData() {
        final class_5609 data = new class_5609();
        final class_5610 root = data.method_32111();
        // joint1: Y方向に薄くて長い
        final class_5610 joint1 = root.method_32117("joint1", class_5606.method_32108().method_32101(0, 0).method_32097(-5.0f, -1.5f, -4.0f, 10.0f, 3.0f, 8.0f), class_5603.method_32090(0.0f, 16.0f, 0.0f));
        // joint2: joint1の後ろに連結、薄め
        final class_5610 joint2 = root.method_32117("joint2", class_5606.method_32108().method_32101(0, 12).method_32097(-4.0f, -1.5f, 4.0f, 8.0f, 3.0f, 8.0f), class_5603.method_32090(0.0f, 16.0f, 8.0f));

        // joint1の左右足（合計6本）
        for (int i = 0; i < 3; ++i) {
            joint1.method_32117("left_leg1_" + i, class_5606.method_32108().method_32101(0, 20).method_32097(0.0f, 0.0f, -1.0f, 6.0f, 1.0f, 2.0f), class_5603.method_32091(5.0f, 1.5f, -3.0f + i * 3, 0.0f, 0.0f, 0.0f));
            joint1.method_32117("right_leg1_" + i, class_5606.method_32108().method_32101(0, 23).method_32097(-6.0f, 0.0f, -1.0f, 6.0f, 1.0f, 2.0f), class_5603.method_32091(-5.0f, 1.5f, -3.0f + i * 3, 0.0f, 0.0f, 0.0f));
        }
        // joint2の左右足（合計6本）
        for (int i = 0; i < 3; ++i) {
            joint2.method_32117("left_leg2_" + i, class_5606.method_32108().method_32101(24, 20).method_32097(0.0f, 0.0f, -1.0f, 6.0f, 1.0f, 2.0f), class_5603.method_32091(4.0f, 1.5f, 5.0f + i * 3, 0.0f, 0.0f, 0.0f));
            joint2.method_32117("right_leg2_" + i, class_5606.method_32108().method_32101(24, 23).method_32097(-6.0f, 0.0f, -1.0f, 6.0f, 1.0f, 2.0f), class_5603.method_32091(-4.0f, 1.5f, 5.0f + i * 3, 0.0f, 0.0f, 0.0f));
        }

        return class_5607.method_32110(data, 64, 32);
    }

    @Override
    public void setAngles(final ShiberEntity entity, final float limbAngle, final float limbDistance, final float animationProgress, final float headYaw, final float headPitch) {
        for (int i = 0; i < 3; ++i) {
            final float swing = class_3532.method_15362(limbAngle * 1.5f + i) * limbDistance * 1.2f;
            this.leftLegs1[i].field_3654 = swing;
            this.rightLegs1[i].field_3654 = -swing;
            this.leftLegs2[i].field_3654 = swing;
            this.rightLegs2[i].field_3654 = -swing;
        }
    }

    @Override
    public class_630 method_32008() {
        return this.root;
    }
}
