/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1309
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

import java.util.Random;
import net.minecraft.class_1282;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_1856;
import net.minecraft.class_2378;
import net.minecraft.class_2960;

public class BeigeSlashItem
extends class_1829 {
    public static final class_1832 BEIGE_MATERIAL = new class_1832(){

        public int method_8025() {
            return 750;
        }

        public float method_8027() {
            return 5.0f;
        }

        public float method_8028() {
            return 3.0f;
        }

        public int method_8024() {
            return 5;
        }

        public int method_8026() {
            return 10;
        }

        public class_1856 method_8023() {
            return class_1856.field_9017;
        }
    };
    private static final Random RANDOM = new Random();
    public static final class_2960 ID = new class_2960("sakaplus", "beige_slash");
    public static final class_1792 INSTANCE = new BeigeSlashItem();

    public BeigeSlashItem() {
        super(BEIGE_MATERIAL, 15, -1.6f, new class_1792.class_1793().method_7895(750));
    }

    public boolean method_7873(class_1799 stack, class_1309 target, class_1309 attacker) {
        if (RANDOM.nextFloat() < 0.25f) {
            attacker.method_5643(class_1282.field_5869, 9.0f);
        }
        return super.method_7873(stack, target, attacker);
    }

    public static void register() {
        class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)ID, (Object)INSTANCE);
    }
}
