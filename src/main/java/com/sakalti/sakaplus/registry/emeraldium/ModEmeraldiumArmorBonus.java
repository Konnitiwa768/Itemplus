package com.sakalti.sakaplus.registry.emeraldium;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModEmeraldiumArmorBonus {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                if (hasFullEmeraldiumArmor(player)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 210, 1, false, false, true));
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 210, 1, false, false, true));
                }
            }
        });
    }

    private static boolean hasFullEmeraldiumArmor(ServerPlayerEntity player) {
        for (ItemStack stack : player.getArmorItems()) {
            if (!(stack.getItem() instanceof ArmorItem armor)) return false;
            if (!(armor.getMaterial() instanceof EmeraldiumArmorMaterial)) return false;
        }
        return true;
    }
}
