package com.sakalti.sakaplus.mixin;

import com.sakalti.sakaplus.attribute.ModAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgument;

@Mixin(LivingEntity.class)
public abstract class AdaptationMixin {

    /**
     * damageメソッドの第2引数（ダメージ量）を改変する
     */
    @ModifyArgument(
            method = "damage",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"),
            index = 1
    )
    private float modifyDamage(float amount, DamageSource source) {
        if ((Object)this instanceof LivingEntity living) {
            double adaptation = living.getAttributeValue(ModAttributes.ADAPTATION);
            double reduced = amount - adaptation;
            if (reduced < 0) {
                reduced = 0;
            }
            return (float) reduced;
        }
        return amount;
    }
}
