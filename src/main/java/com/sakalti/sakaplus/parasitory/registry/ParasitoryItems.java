// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.parasitory.registry;

import net.minecraft.class_1832;
import net.minecraft.class_1829;
import net.minecraft.class_1834;
import net.minecraft.class_1299;
import net.minecraft.class_1826;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_1792;

public class ParasitoryItems
{
    public static final class_1792 UGNAZHI_SPAWN_EGG;
    public static final class_1792 UGNAZHI_SWORD;
    public static final class_1792 HP_UPPER;
    
    public static void register() {
        class_2378.method_10230((class_2378)class_2378.field_11142, new class_2960("sakaplus", "ugnazhi_spawn_egg"), (Object)ParasitoryItems.UGNAZHI_SPAWN_EGG);
        class_2378.method_10230((class_2378)class_2378.field_11142, new class_2960("sakaplus", "ugnazhi_sword"), (Object)ParasitoryItems.UGNAZHI_SWORD);
        class_2378.method_10230((class_2378)class_2378.field_11142, new class_2960("sakaplus", "hp_upper"), (Object)ParasitoryItems.HP_UPPER);
    }
    
    static {
        UGNAZHI_SPAWN_EGG = (class_1792)new class_1826((class_1299)ParasitoryEntities.UGNAZHI, 3355426, 7842355, new class_1792.class_1793());
        UGNAZHI_SWORD = (class_1792)new class_1829((class_1832)class_1834.field_22033, 28, -1.3000001f, new class_1792.class_1793());
        HP_UPPER = new class_1792(new class_1792.class_1793().method_7889(1));
    }
}
