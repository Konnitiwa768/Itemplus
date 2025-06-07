// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.client.renderer;

import net.minecraft.class_1297;
import net.minecraft.class_583;
import net.minecraft.class_5602;
import net.minecraft.class_5617;
import net.minecraft.class_2960;
import net.minecraft.class_562;
import com.sakalti.sakaplus.entity.NucreeperEntity;
import net.minecraft.class_927;

public class NucreeperRenderer extends class_927<NucreeperEntity, class_562<NucreeperEntity>>
{
    private static final class_2960 TEXTURE;
    
    public NucreeperRenderer(final class_5617.class_5618 context) {
        super(context, (class_583)new class_562(context.method_32167(class_5602.field_27699)), 0.5f);
    }
    
    public class_2960 getTexture(final NucreeperEntity entity) {
        return NucreeperRenderer.TEXTURE;
    }
    
    static {
        TEXTURE = new class_2960("sakaplus", "textures/entity/nucreeper.png");
    }
}
