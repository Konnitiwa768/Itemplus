/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1887
 *  net.minecraft.class_1890
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package com.sakalti.sakaplus.mixin;

import com.sakalti.sakaplus.enchant.ModEnchantments;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value={class_1657.class})
public abstract class AttackDamageMixin {
    @ModifyVariable(method={"attack(Lnet/minecraft/entity/Entity;)V"}, at=@At(value="STORE", ordinal=0), index=9)
    private float modifyAttackDamage(float originalDamage) {
        class_1657 player = (class_1657)this;
        class_1799 stack = player.method_5998(class_1268.field_5808);
        int good = class_1890.method_8225((class_1887)ModEnchantments.goodSharpness, (class_1799)stack);
        int extra = class_1890.method_8225((class_1887)ModEnchantments.extraSharpness, (class_1799)stack);
        if (good > 0) {
            originalDamage += 1.0f + 0.75f * (float)good;
        }
        if (extra > 0) {
            originalDamage += 1.5f + 0.6f * (float)extra;
        }
        return originalDamage;
    }
}
