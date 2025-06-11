package com.sakalti.sakaplus.effect;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class ParalyzeHandler implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.player.hasStatusEffect(ModEffects.PARALYZE)) {
                // キー入力無効化
                client.options.forwardKey.setPressed(false);
                client.options.backKey.setPressed(false);
                client.options.leftKey.setPressed(false);
                client.options.rightKey.setPressed(false);
                client.options.jumpKey.setPressed(false);
                client.options.sneakKey.setPressed(false);
                client.options.sprintKey.setPressed(false);
                client.options.attackKey.setPressed(false);
                client.options.useKey.setPressed(false);
                // マウス操作も必要ならここで対応
            }
        });
    }
}
