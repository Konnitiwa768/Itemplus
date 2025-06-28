package com.sakalti.sakaplus.mixin;

import com.sakalti.sakaplus.attribute.ModAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class AdaptationMixin {

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void applyAdaptation(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if ((Object)this instanceof LivingEntity living) {
            double adaptation = living.getAttributeValue(ModAttributes.ADAPTATION);
            float reduced = (float)(amount - adaptation);
            if (reduced < 0) {
                reduced = 0;
            }
            // ダメージ0なら即false（無効）
            if (reduced <= 0) {
                cir.setReturnValue(false);
                return;
            }
            // 改めてdamage呼び出し
            living.damage(source, reduced);
            cir.setReturnValue(true);
        }
    }
}
