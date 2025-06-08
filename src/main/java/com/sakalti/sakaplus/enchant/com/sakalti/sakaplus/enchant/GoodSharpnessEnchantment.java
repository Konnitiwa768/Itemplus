/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1886
 *  net.minecraft.class_1887
 *  net.minecraft.class_1887$class_1888
 *  net.minecraft.class_1893
 */
package com.sakalti.sakaplus.enchant;

import com.sakalti.sakaplus.enchant.ModEnchantments;
import net.minecraft.class_1304;
import net.minecraft.class_1886;
import net.minecraft.class_1887;
import net.minecraft.class_1893;

public class GoodSharpnessEnchantment
extends class_1887 {
    public GoodSharpnessEnchantment() {
        super(class_1887.class_1888.field_9090, class_1886.field_9074, new class_1304[]{class_1304.field_6173});
    }

    public int method_8183() {
        return 3;
    }

    public int method_8182(int level) {
        return 5 + level * 10;
    }

    public int method_20742(int level) {
        return this.method_8182(level) + 15;
    }

    public boolean method_8180(class_1887 other) {
        return other != class_1893.field_9118 && other != ModEnchantments.extraSharpness && super.method_8180(other);
    }
}
