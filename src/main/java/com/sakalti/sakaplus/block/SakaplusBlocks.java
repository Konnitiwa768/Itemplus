// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.block;

import net.minecraft.class_2498;
import net.minecraft.class_4970;
import net.minecraft.class_3614;
import net.minecraft.class_1747;
import net.minecraft.class_1761;
import net.minecraft.class_1792;
import net.minecraft.class_2960;
import net.minecraft.class_2378;
import net.minecraft.class_2248;

public class SakaplusBlocks
{
    public static final class_2248 WOODEN_SCAFFOLD;
    
    public static void register() {
        class_2378.method_10230((class_2378)class_2378.field_11146, new class_2960("sakaplus", "wooden_scaffold"), (Object)SakaplusBlocks.WOODEN_SCAFFOLD);
        class_2378.method_10230((class_2378)class_2378.field_11142, new class_2960("sakaplus", "wooden_scaffold"), (Object)new class_1747(SakaplusBlocks.WOODEN_SCAFFOLD, new class_1792.class_1793().method_7892(class_1761.field_7928)));
    }
    
    static {
        WOODEN_SCAFFOLD = (class_2248)new WoodenScaffoldBlock(class_4970.class_2251.method_9637(class_3614.field_15932).method_9629(0.4f, 0.5f).method_9626(class_2498.field_11547).method_22488());
    }
}
