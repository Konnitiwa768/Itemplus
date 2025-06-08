/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_4174$class_4175
 */
package com.sakalti.sakaplus.registry;

import net.minecraft.class_1792;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_4174;

public class Frieds {
    public static final class_1792 RAW_FRIES = new class_1792(new class_1792.class_1793().method_19265(new class_4174.class_4175().method_19238(2).method_19242()));
    public static final class_1792 FRIES = new class_1792(new class_1792.class_1793().method_19265(new class_4174.class_4175().method_19238(6).method_19237(0.6f).method_19242()));

    public static void register() {
        class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)new class_2960("sakaplus", "raw_fries"), (Object)RAW_FRIES);
        class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)new class_2960("sakaplus", "fries"), (Object)FRIES);
    }
}
