// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.parasitory.client.renderer;

import net.minecraft.class_1297;
import net.minecraft.class_2960;
import net.minecraft.class_583;
import net.minecraft.class_5617;
import net.minecraft.class_5601;
import com.sakalti.sakaplus.parasitory.client.model.UgnazhiModel;
import com.sakalti.sakaplus.parasitory.entity.UgnazhiEntity;
import net.minecraft.class_927;

public class UgnazhiRenderer extends class_927<UgnazhiEntity, UgnazhiModel>
{
    public static final class_5601 LAYER;
    
    public UgnazhiRenderer(final class_5617.class_5618 context) {
        super(context, (class_583)new UgnazhiModel(context.method_32167(UgnazhiRenderer.LAYER)), 0.4f);
    }
    
    public class_2960 getTexture(final UgnazhiEntity entity) {
        return new class_2960("sakaplus", "textures/entity/ugnazhi.png");
    }
    
    static {
        LAYER = new class_5601(new class_2960("sakaplus", "ugnazhi"), "main");
    }
}
