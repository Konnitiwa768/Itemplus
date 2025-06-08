/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_1311
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1829
 *  net.minecraft.class_1832
 *  net.minecraft.class_1856
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 */
package com.sakalti.sakaplus.item;

import net.minecraft.class_1309;
import net.minecraft.class_1311;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_1856;
import net.minecraft.class_2378;
import net.minecraft.class_2960;

public class TheLastTentacleItem
extends class_1829 {
    public static final class_1832 LAST_TENTACLE_MATERIAL = new class_1832(){

        public int method_8025() {
            return 600;
        }

        public float method_8027() {
            return 5.0f;
        }

        public float method_8028() {
            return 3.0f;
        }

        public int method_8024() {
            return 3;
        }

        public int method_8026() {
            return 18;
        }

        public class_1856 method_8023() {
            return class_1856.field_9017;
        }
    };
    public static final class_2960 ID = new class_2960("sakaplus", "the_last_tentacle");
    public static final class_1792 INSTANCE = new TheLastTentacleItem();

    public TheLastTentacleItem() {
        super(LAST_TENTACLE_MATERIAL, 12, -1.6f, new class_1792.class_1793().method_7895(600));
    }

    public boolean method_7873(class_1799 stack, class_1309 target, class_1309 attacker) {
        if (attacker instanceof class_1657) {
            class_1657 player = (class_1657)attacker;
            if (target instanceof class_1657 || target.method_5864().method_5891() == class_1311.field_6294 || target.method_5864().method_5891() == class_1311.field_6303) {
                return false;
            }
        }
        return super.method_7873(stack, target, attacker);
    }

    public static void register() {
        class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)ID, (Object)INSTANCE);
    }
}
