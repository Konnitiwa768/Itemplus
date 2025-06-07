// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.enchant;

import net.minecraft.class_1893;
import net.minecraft.class_1304;
import net.minecraft.class_1886;
import net.minecraft.class_1887;

public class ExtraSharpnessEnchantment extends class_1887
{
    public ExtraSharpnessEnchantment() {
        super(class_1887.class_1888.field_9088, class_1886.field_9074, new class_1304[] { class_1304.field_6173 });
    }
    
    public int method_8183() {
        return 5;
    }
    
    public int method_8182(final int level) {
        return 10 + level * 12;
    }
    
    public int method_20742(final int level) {
        return this.method_8182(level) + 20;
    }
    
    public boolean method_8193() {
        return true;
    }
    
    public boolean method_25949() {
        return false;
    }
    
    public boolean method_8180(final class_1887 other) {
        return other != class_1893.field_9118 && other != ModEnchantments.goodSharpness && super.method_8180(other);
    }
}
