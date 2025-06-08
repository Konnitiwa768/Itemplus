/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1887
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 */
package com.sakalti.sakaplus.enchant;

import com.sakalti.sakaplus.enchant.ExtraSharpnessEnchantment;
import com.sakalti.sakaplus.enchant.GoodSharpnessEnchantment;
import net.minecraft.class_1887;
import net.minecraft.class_2378;
import net.minecraft.class_2960;

public class ModEnchantments {
    public static class_1887 goodSharpness;
    public static class_1887 extraSharpness;

    public static void register() {
        goodSharpness = (class_1887)class_2378.method_10230((class_2378)class_2378.field_11160, (class_2960)new class_2960("sakaplus", "good_sharpness"), (Object)((Object)new GoodSharpnessEnchantment()));
        extraSharpness = (class_1887)class_2378.method_10230((class_2378)class_2378.field_11160, (class_2960)new class_2960("sakaplus", "extra_sharpness"), (Object)((Object)new ExtraSharpnessEnchantment()));
    }
}
