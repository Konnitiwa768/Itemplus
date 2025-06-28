package com.sakalti.sakaplus.event;

import com.sakalti.sakaplus.attribute.ModAttributes;
import net.fabricmc.fabric.api.entity.event.v1.DamageCallback;
import net.minecraft.entity.LivingEntity;

public class DamageHandler {

    public static void register() {
        DamageCallback.EVENT.register((entity, source, amount) -> {
            if (entity instanceof LivingEntity living) {
                double adaptation = living.getAttributeValue(ModAttributes.ADAPTATION);
                double reduced = amount - adaptation;
                if (reduced < 0) {
                    reduced = 0;
                }
                return (float) reduced;
            }
            return amount;
        });
    }
}
