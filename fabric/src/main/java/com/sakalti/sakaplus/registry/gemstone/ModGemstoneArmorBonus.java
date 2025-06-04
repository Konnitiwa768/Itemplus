package com.sakalti.sakaplus.registry.gemstone;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModGemstoneArmorBonus {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (hasFullGemstoneArmor(player)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 210, 1, false, false, true));
                }
            }
        });
    }

    private static boolean hasFullGemstoneArmor(ServerPlayerEntity player) {
        for (ItemStack stack : player.getArmorItems()) {
            if (!(stack.getItem() instanceof ArmorItem armor)) return false;
            if (!(armor.getMaterial() instanceof GemstoneArmorMaterial)) return false;
        }
        return true;
    }
}
