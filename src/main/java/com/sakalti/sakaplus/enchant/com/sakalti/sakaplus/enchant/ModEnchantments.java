// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.enchant;

import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_1887;

public class ModEnchantments
{
    public static class_1887 goodSharpness;
    public static class_1887 extraSharpness;
    
    public static void register() {
        ModEnchantments.goodSharpness = (class_1887)class_2378.method_10230(class_2378.field_11160, new class_2960("sakaplus", "good_sharpness"), (Object)new GoodSharpnessEnchantment());
        ModEnchantments.extraSharpness = (class_1887)class_2378.method_10230(class_2378.field_11160, new class_2960("sakaplus", "extra_sharpness"), (Object)new ExtraSharpnessEnchantment());
    }
}
