/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1826
 *  net.minecraft.class_1829
 *  net.minecraft.class_1832
 *  net.minecraft.class_1834
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 */
package com.sakalti.sakaplus.parasitory.registry;

import com.sakalti.sakaplus.parasitory.registry.ParasitoryEntities;
import net.minecraft.class_1792;
import net.minecraft.class_1826;
import net.minecraft.class_1829;
import net.minecraft.class_1832;
import net.minecraft.class_1834;
import net.minecraft.class_2378;
import net.minecraft.class_2960;

public class ParasitoryItems {
    public static final class_1792 UGNAZHI_SPAWN_EGG = new class_1826(ParasitoryEntities.UGNAZHI, 0x333322, 0x77AA33, new class_1792.class_1793());
    public static final class_1792 UGNAZHI_SWORD = new class_1829((class_1832)class_1834.field_22033, 28, -1.3000001f, new class_1792.class_1793());
    public static final class_1792 HP_UPPER = new class_1792(new class_1792.class_1793().method_7889(1));

    public static void register() {
        class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)new class_2960("sakaplus", "ugnazhi_spawn_egg"), (Object)UGNAZHI_SPAWN_EGG);
        class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)new class_2960("sakaplus", "ugnazhi_sword"), (Object)UGNAZHI_SWORD);
        class_2378.method_10230((class_2378)class_2378.field_11142, (class_2960)new class_2960("sakaplus", "hp_upper"), (Object)HP_UPPER);
    }
}
