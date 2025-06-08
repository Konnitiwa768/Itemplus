// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import net.minecraft.class_1799;
import net.minecraft.class_1890;
import com.sakalti.sakaplus.enchant.ModEnchantments;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({ class_1657.class })
public abstract class AttackDamageMixin
{
    @ModifyVariable(method = { "attack(Lnet/minecraft/entity/Entity;)V" }, at = @At(value = "STORE", ordinal = 0), index = 9)
    private float modifyAttackDamage(float originalDamage) {
        final class_1657 player = (class_1657)this;
        final class_1799 stack = player.method_5998(class_1268.field_5808);
        final int good = class_1890.method_8225(ModEnchantments.goodSharpness, stack);
        final int extra = class_1890.method_8225(ModEnchantments.extraSharpness, stack);
        if (good > 0) {
            originalDamage += 1.0f + 0.75f * good;
        }
        if (extra > 0) {
            originalDamage += 1.5f + 0.6f * extra;
        }
        return originalDamage;
    }
}
