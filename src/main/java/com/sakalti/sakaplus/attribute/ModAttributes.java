package com.sakalti.sakaplus.attribute;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.ClampedEntityAttribute;

public class ModAttributes {

    public static final EntityAttribute ADAPTATION = new ClampedEntityAttribute(
            "attribute.name.generic.adaptation",
            0.0D,   // 初期値
            0.0D,   // 最小値
            1024.0D // 最大値
    ).setTracked(true);
}
