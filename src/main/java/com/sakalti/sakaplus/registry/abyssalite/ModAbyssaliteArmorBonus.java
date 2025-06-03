package com.sakalti.sakaplus.registry.abyssalite;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModAbyssaliteArmorBonus {
    public static void init() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (hasFullAbyssaliteArmor(player)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 210, 0, false, false, true));
                }
            }
        });
    }

    private static boolean hasFullAbyssaliteArmor(PlayerEntity player) {
        return player.getInventory().armor.stream().allMatch(stack ->
            stack.getItem() instanceof ArmorItem armor && armor.getMaterial() instanceof AbyssaliteArmorMaterial
        );
    }
}
