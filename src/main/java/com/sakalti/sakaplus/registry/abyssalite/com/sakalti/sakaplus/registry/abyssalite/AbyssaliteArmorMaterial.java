/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1741
 *  net.minecraft.class_1856
 *  net.minecraft.class_1935
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 */
package com.sakalti.sakaplus.registry.abyssalite;

import com.sakalti.sakaplus.registry.abyssalite.ModAbyssaliteItems;
import net.minecraft.class_1304;
import net.minecraft.class_1741;
import net.minecraft.class_1856;
import net.minecraft.class_1935;
import net.minecraft.class_3414;
import net.minecraft.class_3417;

public class AbyssaliteArmorMaterial
implements class_1741 {
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[]{3, 6, 5, 4};

    public int method_7696(class_1304 slot) {
        return BASE_DURABILITY[slot.method_5927()] * 44;
    }

    public int method_7697(class_1304 slot) {
        return PROTECTION_VALUES[slot.method_5927()];
    }

    public int method_7699() {
        return 15;
    }

    public class_3414 method_7698() {
        return class_3417.field_21866;
    }

    public class_1856 method_7695() {
        return class_1856.method_8091((class_1935[])new class_1935[]{ModAbyssaliteItems.ABYSSALITE_INGOT});
    }

    public String method_7694() {
        return "abyssalite";
    }

    public float method_7700() {
        return 2.5f;
    }

    public float method_24355() {
        return 0.1f;
    }
}
