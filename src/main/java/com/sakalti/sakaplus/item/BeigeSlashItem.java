// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.item;

import net.minecraft.class_1856;
import net.minecraft.class_2378;
import net.minecraft.class_1282;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import java.util.Random;
import net.minecraft.class_1832;
import net.minecraft.class_1829;

public class BeigeSlashItem extends class_1829
{
    public static final class_1832 BEIGE_MATERIAL;
    private static final Random RANDOM;
    public static final class_2960 ID;
    public static final class_1792 INSTANCE;
    
    public BeigeSlashItem() {
        super(BeigeSlashItem.BEIGE_MATERIAL, 15, -1.6f, new class_1792.class_1793().method_7895(750));
    }
    
    public boolean method_7873(final class_1799 stack, final class_1309 target, final class_1309 attacker) {
        if (BeigeSlashItem.RANDOM.nextFloat() < 0.25f) {
            attacker.method_5643(class_1282.field_5869, 9.0f);
        }
        return super.method_7873(stack, target, attacker);
    }
    
    public static void register() {
        class_2378.method_10230((class_2378)class_2378.field_11142, BeigeSlashItem.ID, (Object)BeigeSlashItem.INSTANCE);
    }
    
    static {
        BEIGE_MATERIAL = (class_1832)new class_1832() {
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
        RANDOM = new Random();
        ID = new class_2960("sakaplus", "beige_slash");
        INSTANCE = (class_1792)new BeigeSlashItem();
    }
}
