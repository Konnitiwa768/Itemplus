package com.sakalti.sakaplus.registry.abyssalite;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModAbyssaliteArmorBonus {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (hasFullAbyssaliteArmor(player)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 210, 0, false, false, true));
                }
            }
        });
    }

    private static boolean hasFullAbyssaliteArmor(ServerPlayerEntity player) {
        for (ItemStack stack : player.getArmorItems()) {
            if (!(stack.getItem() instanceof ArmorItem armor)) return false;
            if (!(armor.getMaterial() instanceof AbyssaliteArmorMaterial)) return false;
        }
        return true;
    }
}
