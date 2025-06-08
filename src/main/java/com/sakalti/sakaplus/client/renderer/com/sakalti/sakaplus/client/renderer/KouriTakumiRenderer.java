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

import com.sakalti.sakaplus.entity.KouriTakumiEntity;
import net.minecraft.class_2960;
import net.minecraft.class_5602;
import net.minecraft.class_5617;
import net.minecraft.class_562;
import net.minecraft.class_583;
import net.minecraft.class_927;

public class KouriTakumiRenderer
extends class_927<KouriTakumiEntity, class_562<KouriTakumiEntity>> {
    private static final class_2960 TEXTURE = new class_2960("sakaplus", "textures/entity/kouri_takumi.png");

    public KouriTakumiRenderer(class_5617.class_5618 context) {
        super(context, (class_583)new class_562(context.method_32167(class_5602.field_27699)), 0.5f);
    }

    public class_2960 getTexture(KouriTakumiEntity entity) {
        return TEXTURE;
    }
}
