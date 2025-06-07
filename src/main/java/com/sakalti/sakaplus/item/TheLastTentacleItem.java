// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.item;

import net.minecraft.class_1856;
import net.minecraft.class_2378;
import net.minecraft.class_1311;
import net.minecraft.class_1657;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import net.minecraft.class_1832;
import net.minecraft.class_1829;

public class TheLastTentacleItem extends class_1829
{
    public static final class_1832 LAST_TENTACLE_MATERIAL;
    public static final class_2960 ID;
    public static final class_1792 INSTANCE;
    
    public TheLastTentacleItem() {
        super(TheLastTentacleItem.LAST_TENTACLE_MATERIAL, 12, -1.6f, new class_1792.class_1793().method_7895(600));
    }
    
    public boolean method_7873(final class_1799 stack, final class_1309 target, final class_1309 attacker) {
        if (attacker instanceof final class_1657 player) {
            if (target instanceof class_1657 || target.method_5864().method_5891() == class_1311.field_6294 || target.method_5864().method_5891() == class_1311.field_6303) {
                return false;
            }
        }
        return super.method_7873(stack, target, attacker);
    }
    
    public static void register() {
        class_2378.method_10230((class_2378)class_2378.field_11142, TheLastTentacleItem.ID, (Object)TheLastTentacleItem.INSTANCE);
    }
    
    static {
        LAST_TENTACLE_MATERIAL = (class_1832)new class_1832() {
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
        ID = new class_2960("sakaplus", "the_last_tentacle");
        INSTANCE = (class_1792)new TheLastTentacleItem();
    }
}
