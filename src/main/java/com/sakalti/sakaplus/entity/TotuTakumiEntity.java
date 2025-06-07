// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.entity;

import net.minecraft.class_5134;
import net.minecraft.class_5132;
import net.minecraft.class_1400;
import net.minecraft.class_1376;
import net.minecraft.class_1361;
import net.minecraft.class_1657;
import net.minecraft.class_1394;
import net.minecraft.class_1366;
import net.minecraft.class_1314;
import net.minecraft.class_1384;
import net.minecraft.class_1352;
import net.minecraft.class_1308;
import net.minecraft.class_1347;
import net.minecraft.class_1937;
import net.minecraft.class_1299;
import net.minecraft.class_1548;

public class TotuTakumiEntity extends class_1548
{
    public TotuTakumiEntity(final class_1299<? extends class_1548> entityType, final class_1937 world) {
        super((class_1299)entityType, world);
        this.method_7005(1);
    }
    
    protected void method_5959() {
        this.field_6201.method_6277(1, (class_1352)new class_1347((class_1308)this));
        this.field_6201.method_6277(2, (class_1352)new class_1384((class_1314)this));
        this.field_6201.method_6277(3, (class_1352)new class_1366((class_1314)this, 1.0, false));
        this.field_6201.method_6277(4, (class_1352)new class_1394((class_1314)this, 1.0));
        this.field_6201.method_6277(5, (class_1352)new class_1361((class_1308)this, (Class)class_1657.class, 8.0f));
        this.field_6201.method_6277(6, (class_1352)new class_1376((class_1308)this));
        this.field_6185.method_6277(1, (class_1352)new class_1400((class_1308)this, (Class)class_1657.class, true));
    }
    
    public static class_5132.class_5133 createTotuTakumiAttributes() {
        return class_1548.method_26828().method_26868(class_5134.field_23716, 30.0).method_26868(class_5134.field_23724, 8.0).method_26868(class_5134.field_23717, 50.0).method_26868(class_5134.field_23719, 0.36);
    }
}
