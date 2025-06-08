/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5602
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_562
 *  net.minecraft.class_583
 *  net.minecraft.class_927
 */
package com.sakalti.sakaplus.client.renderer;

import com.sakalti.sakaplus.entity.TotuTakumiEntity;
import net.minecraft.class_2960;
import net.minecraft.class_5602;
import net.minecraft.class_5617;
import net.minecraft.class_562;
import net.minecraft.class_583;
import net.minecraft.class_927;

public class TotuTakumiRenderer
extends class_927<TotuTakumiEntity, class_562<TotuTakumiEntity>> {
    private static final class_2960 TEXTURE = new class_2960("sakaplus", "textures/entity/totu_takumi.png");

    public TotuTakumiRenderer(class_5617.class_5618 context) {
        super(context, (class_583)new class_562(context.method_32167(class_5602.field_27699)), 0.5f);
    }

    public class_2960 getTexture(TotuTakumiEntity entity) {
        return TEXTURE;
    }
}
