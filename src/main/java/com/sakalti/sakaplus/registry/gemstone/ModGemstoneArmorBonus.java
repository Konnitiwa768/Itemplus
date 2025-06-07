// 
// Decompiled by Procyon v0.6.0
// 

package com.sakalti.sakaplus.registry.gemstone;

import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.server.MinecraftServer;
import net.minecraft.class_1792;
import java.util.Iterator;
import net.minecraft.class_1738;
import net.minecraft.class_1799;
import net.minecraft.class_3222;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class ModGemstoneArmorBonus
{
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register((Object)(server -> {
            for (final class_3222 player : server.method_3760().method_14571()) {
                if (hasFullGemstoneArmor(player)) {
                    player.method_6092(new class_1293(class_1294.field_5907, 210, 1, false, false, true));
                }
            }
        }));
    }
    
    private static boolean hasFullGemstoneArmor(final class_3222 player) {
        for (final class_1799 stack : player.method_5661()) {
            final class_1792 method_7909 = stack.method_7909();
            if (!(method_7909 instanceof class_1738)) {
                return false;
            }
            final class_1738 armor = (class_1738)method_7909;
            if (!(armor.method_7686() instanceof GemstoneArmorMaterial)) {
                return false;
            }
        }
        return true;
    }
}
