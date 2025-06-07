// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.registry.emeraldium;

import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1856;
import net.minecraft.class_3417;
import net.minecraft.class_3414;
import net.minecraft.class_1304;
import net.minecraft.class_1741;

public class EmeraldiumArmorMaterial implements class_1741
{
    private static final int[] BASE_DURABILITY;
    private static final int[] PROTECTION;
    
    public int method_7696(final class_1304 slot) {
        return EmeraldiumArmorMaterial.BASE_DURABILITY[slot.method_5927()] * 50;
    }
    
    public int method_7697(final class_1304 slot) {
        return EmeraldiumArmorMaterial.PROTECTION[slot.method_5927()];
    }
    
    public int method_7699() {
        return 18;
    }
    
    public class_3414 method_7698() {
        return class_3417.field_15103;
    }
    
    public class_1856 method_7695() {
        return class_1856.method_8091(new class_1935[] { (class_1935)class_1802.field_8687 });
    }
    
    public String method_7694() {
        return "emeraldium";
    }
    
    public float method_7700() {
        return 2.0f;
    }
    
    public float method_24355() {
        return 0.1f;
    }
    
    static {
        BASE_DURABILITY = new int[] { 13, 15, 16, 11 };
        PROTECTION = new int[] { 2, 7, 6, 6 };
    }
}
