// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.registry.abyssalite;

import net.minecraft.class_1935;
import net.minecraft.class_1856;
import net.minecraft.class_3417;
import net.minecraft.class_3414;
import net.minecraft.class_1304;
import net.minecraft.class_1741;

public class AbyssaliteArmorMaterial implements class_1741
{
    private static final int[] BASE_DURABILITY;
    private static final int[] PROTECTION_VALUES;
    
    public int method_7696(final class_1304 slot) {
        return AbyssaliteArmorMaterial.BASE_DURABILITY[slot.method_5927()] * 44;
    }
    
    public int method_7697(final class_1304 slot) {
        return AbyssaliteArmorMaterial.PROTECTION_VALUES[slot.method_5927()];
    }
    
    public int method_7699() {
        return 15;
    }
    
    public class_3414 method_7698() {
        return class_3417.field_21866;
    }
    
    public class_1856 method_7695() {
        return class_1856.method_8091(new class_1935[] { (class_1935)ModAbyssaliteItems.ABYSSALITE_INGOT });
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
    
    static {
        BASE_DURABILITY = new int[] { 13, 15, 16, 11 };
        PROTECTION_VALUES = new int[] { 3, 6, 5, 4 };
    }
}
