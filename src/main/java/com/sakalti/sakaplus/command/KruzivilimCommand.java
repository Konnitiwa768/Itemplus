package com.sakalti.sakaplus.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class KruzivilimCommand {

    // クルジヴィリムのディメンションキー
    public static final RegistryKey<World> KRUZIVILIM_DIM = RegistryKey.of(RegistryKeys.WORLD, new Identifier("sakaplus", "kruzivilim"));

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("kruzivilim")
            .then(CommandManager.literal("iku")
                .executes(ctx -> teleport(ctx.getSource(), true)))
            .then(CommandManager.literal("modoru")
                .executes(ctx -> teleport(ctx.getSource(), false)))
        );
    }

    private static int teleport(ServerCommandSource source, boolean toKruzivilim) {
        ServerPlayerEntity player = source.getPlayer();

        if (player == null) {
            source.sendError(Text.of("プレイヤーしか使えません。"));
            return 0;
        }

        // 金インゴット28個を所持しているかチェック
        int goldCount = countItems(player, Items.GOLD_INGOT);
        if (goldCount < 28) {
            player.sendMessage(Text.of("§c金インゴットが28個必要です。"), false);
            return 0;
        }

        // 消費
        removeItems(player, Items.GOLD_INGOT, 28);

        // テレポート先のディメンションを取得
        ServerWorld targetWorld = player.getServer().getWorld(toKruzivilim ? KRUZIVILIM_DIM : World.OVERWORLD);
        if (targetWorld == null) {
            player.sendMessage(Text.of("§cテレポート先の世界が見つかりません。"), false);
            return 0;
        }

        BlockPos pos = player.getBlockPos();
        player.teleport(targetWorld, pos.getX(), pos.getY(), pos.getZ(), player.getYaw(), player.getPitch());
        player.sendMessage(Text.of("§6" + (toKruzivilim ? "クルジヴィリムへ移動しました。" : "元の世界に戻りました。")), false);

        return 1;
    }

    // 所持しているアイテムをカウント
    private static int countItems(ServerPlayerEntity player, net.minecraft.item.Item item) {
        return player.getInventory().main.stream()
            .filter(stack -> stack != null && stack.getItem() == item)
            .mapToInt(stack -> stack.getCount())
            .sum();
    }

    // 指定数のアイテムを削除
    private static void removeItems(ServerPlayerEntity player, net.minecraft.item.Item item, int amount) {
        int remaining = amount;
        for (int i = 0; i < player.getInventory().main.size(); i++) {
            var stack = player.getInventory().main.get(i);
            if (stack != null && stack.getItem() == item) {
                int take = Math.min(stack.getCount(), remaining);
                stack.decrement(take);
                remaining -= take;
                if (remaining <= 0) break;
            }
        }
    }
}
