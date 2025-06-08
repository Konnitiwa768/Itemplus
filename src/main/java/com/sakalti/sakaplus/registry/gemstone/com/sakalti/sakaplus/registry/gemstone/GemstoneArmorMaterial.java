/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1741
 *  net.minecraft.class_1802
 *  net.minecraft.class_1856
 *  net.minecraft.class_1935
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 */
package com.sakalti.sakaplus.registry.gemstone;

import net.minecraft.class_1304;
import net.minecraft.class_1741;
import net.minecraft.class_1802;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_3414;
import net.minecraft.class_3417;

public class GemstoneArmorMaterial
implements class_1741 {
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_AMOUNTS = new int[]{2, 6, 5, 2};

    public int method_7696(class_1304 slot) {
        return BASE_DURABILITY[slot.method_5927()] * 31;
    }

    public int method_7697(class_1304 slot) {
        return PROTECTION_AMOUNTS[slot.method_5927()];
    }

    public int method_7699() {
        return 20;
    }

    public class_3414 method_7698() {
        return class_3417.field_15103;
    }

    public class_1856 method_7695() {
        return class_1856.method_8091((class_1935[])new class_1935[]{class_1802.field_8759, class_1802.field_8477});
    }

    public String method_7694() {
        return "gemstone";
    }

    public float method_7700() {
        return 1.0f;
    }

    public float method_24355() {
        return 0.0f;
    }
}
