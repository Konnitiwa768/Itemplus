/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5601
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_927
 */
package com.sakalti.sakaplus.parasitory.client.renderer;

import com.sakalti.sakaplus.parasitory.client.model.UgnazhiModel;
import com.sakalti.sakaplus.parasitory.entity.UgnazhiEntity;
import net.minecraft.class_2960;
import net.minecraft.class_5601;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_927;

public class UgnazhiRenderer
extends class_927<UgnazhiEntity, UgnazhiModel> {
    public static final class_5601 LAYER = new class_5601(new class_2960("sakaplus", "ugnazhi"), "main");

    public UgnazhiRenderer(class_5617.class_5618 context) {
        super(context, (class_583)new UgnazhiModel(context.method_32167(LAYER)), 0.4f);
    }

    public class_2960 getTexture(UgnazhiEntity entity) {
        return new class_2960("sakaplus", "textures/entity/ugnazhi.png");
    }
}
