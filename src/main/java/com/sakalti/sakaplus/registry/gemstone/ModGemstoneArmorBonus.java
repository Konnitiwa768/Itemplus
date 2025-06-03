package com.sakalti.sakaplus.registry.gemstone;

import net.fabricmc.fabric.api.entity.event.v1.LivingEquipmentTickCallback;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModGemstoneArmorBonus {
    public static void init() {
        LivingEquipmentTickCallback.EVENT.register((entity) -> {
            if (!(entity instanceof ServerPlayerEntity player)) return;

            boolean fullSet = true;
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                    ItemStack stack = player.getEquippedStack(slot);
                    if (!(stack.getItem() instanceof ArmorItem armor) || !(armor.getMaterial() instanceof GemstoneArmorMaterial)) {
                        fullSet = false;
                        break;
                    }
                }
            }

            if (fullSet) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 210, 1, false, false, true));
            }
        });
    }
}
