/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1738
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_3222
 */
package com.sakalti.sakaplus.registry.gemstone;

import com.sakalti.sakaplus.registry.gemstone.GemstoneArmorMaterial;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1738;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_3222;

public class ModGemstoneArmorBonus {
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (class_3222 player : server.method_3760().method_14571()) {
                if (!ModGemstoneArmorBonus.hasFullGemstoneArmor(player)) continue;
                player.method_6092(new class_1293(class_1294.field_5907, 210, 1, false, false, true));
            }
        });
    }

    private static boolean hasFullGemstoneArmor(class_3222 player) {
        for (class_1799 stack : player.method_5661()) {
            class_1792 class_17922 = stack.method_7909();
            if (!(class_17922 instanceof class_1738)) {
                return false;
            }
            class_1738 armor = (class_1738)class_17922;
            if (armor.method_7686() instanceof GemstoneArmorMaterial) continue;
            return false;
        }
        return true;
    }
}
